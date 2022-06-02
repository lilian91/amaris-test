package com.amaris.java_test.prices.core.application;

import com.amaris.java_test.prices.core.application.domain.dto.PricesDto;
import com.amaris.java_test.prices.core.application.domain.Prices;
import com.amaris.java_test.prices.core.application.domain.wrapper.PricesWrapper;
import com.amaris.java_test.sharedkernel.Response;
import com.amaris.java_test.sharedkernel.Utils;
import com.amaris.java_test.sharedkernel.criteria.GenericJpaDao;
import com.amaris.java_test.sharedkernel.criteria.IGenericDao;
import com.amaris.java_test.sharedkernel.exception.DateFormtaInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.text.SimpleDateFormat;
import java.util.List;

@Service public class PricesService {
    private final IGenericDao<Prices> pricesIGenericDao;

    @Autowired public PricesService(IGenericDao<Prices> pricesIGenericDao) {
        this.pricesIGenericDao = pricesIGenericDao;

        ((GenericJpaDao) this.pricesIGenericDao).setClazz(Prices.class);
    }

    public Response getPrices(PricesWrapper request) {

        try {
            String sql = "select * from prices ";

            List<PricesDto> result = pricesIGenericDao
                    .getNativeQuery(ObjectUtils.isEmpty(request) ? sql : sql + applyFilters(request),
                            "PricesQueryMapping").getResultList();

            return new Response(HttpStatus.OK, result);
        } catch (Exception e) {
            if (e instanceof DateFormtaInputException)
                return new Response(HttpStatus.PRECONDITION_FAILED, e.getMessage(), true);
            e.printStackTrace();
            return new Response(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), true);
        }
    }

    private String applyFilters(PricesWrapper request) throws Exception {

        String where = "where";
        //Filter by application date
        if (!ObjectUtils.isEmpty(request.getApplicationDate())) {
            String date = Utils.isValidDate(request.getApplicationDate());
            where += " start_date <= '" + date + "' and end_date >= '" + date + "' ";
        }
        //Filter by product id
        if (!ObjectUtils.isEmpty(request.getProductId())) {
            String byPID = " product_id = " + request.getProductId();
            where += (where.endsWith("where")) ? byPID : " and " + byPID;
        }
        //Filter by brand id
        if (!ObjectUtils.isEmpty(request.getBrandId())) {
            String byBID = " brand_id = " + request.getBrandId();
            where += (where.endsWith("where")) ? byBID : " and " + byBID;
        }

        return where;
    }
}
