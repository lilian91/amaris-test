# amaris-test

Running port application: 8085

Path application: /java_test

# Request to /prices service example

curl --location --request POST 'http://127.0.0.1:8085/java_test/prices/' \
--header 'Content-Type: application/json' \
--data-raw '{
    "applicationDate": "2020-06-14 10:00:00",
    "productId": 35455,
    "brandId": 1
}'






