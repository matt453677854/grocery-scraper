# Grocery Scraper
[![Build Status](https://travis-ci.org/matthewdooler/grocery-scraper.svg?branch=master)](https://travis-ci.org/matthewdooler/grocery-scraper)

Console application for scraping the Sainsbury's grocery list page, providing output in JSON format.

## Dependencies
The only dependencies are Java and Maven, and all other dependencies are installed through Maven. Tested on Mac OS X 10.9.5, Java 1.8.0_45 and Maven 3.2.3. Also tested on Java 1.7.

Maven dependencies:
- jsoup: html parsing
- gson: json serialization
- junit: testing framework
- wiremock: stubbing out HTTP endpoints
- commons-io

## Build
Install dependencies, compile, and test:  
`$ mvn install`  

## Test
Run only the tests:  
`$ mvn test`  
HTTP endpoints are stubbed out using wiremock.

## Run
Run the application (the argument is the URI of the products page):  
`$ mvn compile exec:java -Dexec.args="http://hiring-tests.s3-website-eu-west-1.amazonaws.com/2015_Developer_Scrape/5_products.html"`  

## Example output
```
{
  "results": [
    {
      "title": "Sainsbury's Apricot Ripe & Ready x5",
      "unit_price": 3.50,
      "size": "38.3kb",
      "description": "Apricots"
    },
    {
      "title": "Sainsbury's Avocado Ripe & Ready XL Loose 300g",
      "unit_price": 1.50,
      "size": "38.7kb",
      "description": "Avocados"
    },
    {
      "title": "Sainsbury's Avocado, Ripe & Ready x2",
      "unit_price": 1.80,
      "size": "43.4kb",
      "description": "Avocados"
    },
    {
      "title": "Sainsbury's Avocados, Ripe & Ready x4",
      "unit_price": 3.20,
      "size": "38.7kb",
      "description": "Avocados"
    },
    {
      "title": "Sainsbury's Conference Pears, Ripe & Ready x4 (minimum)",
      "unit_price": 1.50,
      "size": "38.5kb",
      "description": "Conference"
    },
    {
      "title": "Sainsbury's Golden Kiwi x4",
      "unit_price": 1.80,
      "size": "38.6kb",
      "description": "Gold Kiwi"
    },
    {
      "title": "Sainsbury's Kiwi Fruit, Ripe & Ready x4",
      "unit_price": 1.80,
      "size": "39.0kb",
      "description": "Kiwi"
    }
  ],
  "total": 15.10
}
 ```
