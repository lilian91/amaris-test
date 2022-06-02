package com.amaris.java_test.prices.api;

import com.amaris.java_test.prices.core.application.PricesService;
import com.amaris.java_test.prices.core.application.domain.wrapper.PricesWrapper;
import com.amaris.java_test.sharedkernel.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequestMapping("/prices") public class PricesController {

    private final PricesService pricesService;

    @Autowired public PricesController(PricesService pricesService) {
        this.pricesService = pricesService;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST) public ResponseEntity<?> getPrices(
            @RequestBody(required = false) PricesWrapper request) {
        Response result = pricesService.getPrices(request);

        if (result.isError())
            return ResponseEntity.status(result.getHttpStatus()).body(result);

        return ResponseEntity.ok().header("Success", "Success response").body(result);
    }

}
