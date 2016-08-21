# Grocery Scraper
[![Build Status](https://travis-ci.org/matt453677854/grocery-scraper.svg?branch=master)](https://travis-ci.org/matt453677854/grocery-scraper)

## Dependencies
The only dependencies are Java and Maven, and all other dependencies are installed through Maven. Tested on Mac OS X 10.9.5, Java 1.8.0_45 and Maven 3.2.3. Also tested on Java 1.7.

## Build
Install dependencies, compile, and test:  
`mvn install`  

## Test
Run only the tests:  
`mvn test`  

## Run
Run the application (the argument is the URI of the products page):  
`mvn compile exec:java -Dexec.args="http://hiring-tests.s3-website-eu-west-1.amazonaws.com/2015_Developer_Scrape/5_products.html"`  
