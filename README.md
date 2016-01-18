# Invoices payment with Selenium WebDriver and Cucumber

Pay your invoices with [Testy](https://github.com/sdl/Testy) and [Cucumber](https://cucumber.io/)

## Requirements

This invoices are tested/ready for :

- [x] Cards issued @[Banca Transilvania](https://www.bancatransilvania.ro/) with [3D Secure](https://www.bancatransilvania.ro/plati-cu-cardul-pe-internet/) enabled

## Ready Scenarios

- [x] Pay [e-on](https://myline-eon.ro/) invoice
- [x] Pay [UPC](https://my.upc.ro/) invoice
- [x] Pay [DIGI](https://digicare.rcs-rds.ro/) invoice

## First Setup

- Rename:

    [src\test\resources\feature\invoice\all-invoices-demo.feature](./src/test/resources/feature/invoice/all-invoices-demo.feature) -> all-invoices.feature
    
- Select Scenarios:

    make sure to leave only necessary scenarios
    
- Edit your credentials (user/pass/card details)

## Running the Tests:

    mvn clean test
    
