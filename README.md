# Grocery Scraper
[![Build Status](https://travis-ci.org/matt453677854/grocery-scraper.svg?branch=master)](https://travis-ci.org/matt453677854/grocery-scraper)

## Build
Install dependencies, compile, and test:
`mvn install`  

## Test
Run only the tests:
`mvn test`  

## Run
Run the application (the argument is the URI of the products page):
`mvn compile exec:java -Dexec.args="http://hiring-tests.s3-website-eu-west-1.amazonaws.com/2015_Developer_Scrape/5_products.html"`  
