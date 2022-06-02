DROP TABLE IF EXISTS prices;

CREATE TABLE  prices(
  id BIGINT NOT NULL AUTO_INCREMENT,
  brand_id BIGINT NOT NULL,
  start_date TIMESTAMP NOT NULL,
  end_date TIMESTAMP NOT NULL,
  price_list INT NOT NULL,
  product_id INT NOT NULL,
  priority INT NOT NULL,
  price DOUBLE NOT NULL,
  curr VARCHAR(5) NOT NULL,
  PRIMARY KEY (id));

INSERT INTO prices
VALUES (1,1, '2020-06-14 00:00:00','2020-12-31 23:59:59',1,35455,0,35.50,'EUR');
INSERT INTO prices
VALUES (2,1,'2020-06-14 15:00:00','2020-06-14 18:30:00',2,35455,1,25.45,'EUR');
INSERT INTO prices
VALUES (3,1,'2020-06-15 00:00:00','2020-06-15 11:00:00',3,35455,1,30.50,'EUR');
INSERT INTO prices
VALUES (4,1,'2020-06-15 16:00:00','2020-12-31 23:59:59',4,35455,1,38.95,'EUR');