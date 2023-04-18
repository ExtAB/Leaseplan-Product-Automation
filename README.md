<h1 align="center">Assignment from leaseplan by A.</h1>

# 📎Waarkoop Product Heroku App
App seems to be a heroku Waarkoop product app that has different products like orange,cola,pasta things you could find in a store

```
Requirements  
• Refactor the given project
• Make it run correctly on Gitlab CI
• Use BDD format: Cucumber/Gherkin
• Required framework: Java Serenity + Maven
```

# ⛄ Prerequisite
* I chose JDK 14 or higher
* Maven 3.8.1
* Gitlab CI desktop

## 🚀 Installation
To run the automation project, you should run ```mvn verify``` from the command line or

```shell
mvn clean install
```

# 📃️ Writing your test cases in a Feature file
In order to have any test using cucumber serenity we need to first create a feature file and add the dependecies for it,
as we the ends with ```.feature``` it recognized the plain text to map it to code logic making our tests more readable


* Feature file example - Writing a test example
```
Feature: Product feature

  Scenario Outline: Search a valid product list
    Given I want to see all the available "<product>" products in my e-commerce shop
    When I search for all "<product>" products
    Then I should retrieve a list of products
    Examples:
      | product |
      | orange  |
         
API Scenarion:
* GET {product} - return a product
```

* Scenario writing
```
As a customer in a shop, I want to see if the store has the products I'm looking to buy 
Descriptoin : Search product by Getting it from the database store
* GET BaseURL + {product} Find product order by productName

```
```
As a store owner, I want to check my stores inventory
Descriptoin : Check Inventory
* GET BaseURL + {product} Find product order by productName
```

# 📑  Deeper example of writing a test
* Step 1) Create new feature file
* Step 2) Add Scenario for single test or Scenario Outline for multiple iterations
* Step 3) Steps can include ```Given, When, Then, And, But``` inside a Scenario
* Steo 4) We can create our own custome annotations
```
*************************   Sample Cucumber File  *************************
Feature: Example feature file

@AnnotationExample
  Scenario Outline: ExampleScenario
    Given I want to save "<country>" from global warming
      | country    |
      | Netherlands|
      | North Pole |
      | USA        |
    When I plant more trees to offset carbon ommisions
    Then "<treesPlanet>" are planet and the planet is saved
    Examples:
      | treesPlanet |
      | 9000        |
```
* Step 2)

```
*************************   Sample Stepd definition File  *************************

 @Given("String here that connects with cucumber feature file here")
    public void exampleMethod(String exampleNotes){
        implement logic here
    }
```

## 📁 File structure
```
src/
├─ main/
│  ├─ java/
│  │  ├─ controller/
│  │    ├─ EnvironmentController.java
│  │
│  │  ├─ model/
│  │    ├─ Product.java
│  │
│  │  ├─ resources/
│  │  │  ├─ apple.json.json
│  │  │  ├─ cola.json
│  │  │  ├─ invalidData.json
│  │  │  ├─ orange.json
│  │  │  ├─ pasta.json
│  │
│  │  ├─ restAPI/
│  │  │  ├─ Endpoints.enum
│  │  │  ├─ ProductClient.java
├─ test/
│  ├─ java/
│  │  ├─ stepdefinitions/
│  │  │  ├─ ProductStepDefinitions.java
│  │  ├─ steps/
│  │  │  ├─ ProductSteps.java
│  │  ├─ CucumberTestSuite.java
│  │
│  ├─ resources/
│  │  ├─ features/
│  │  │  ├─ Product.feature
│  │  ├─ logback-text.xml
│  │  ├─ serenity.conf
.gitattributes
.gitignore
LICENSE
pom.xml
README.md
serenity.properties
```

# 📋 Test Report path
Directory ```target/site/serenity/index.html```

# 🐅 How to configure Job in Git Lab.


Below is the sample of test.gitlab-ci.yml file which is configured with CI pipeline for building and executing maven project
```
image: maven:3.6.3-jdk-14

stages:
  - build
  - test
  - deploy

build:
  stage: build
  script:
    - mvn clean compile

test:
  stage: test
  script:
    - mvn clean verify -Dserenity.outputDirectory=reports/serenity -Dserenity.reports=reports/serenity
  artifacts:
    paths:
      - reports/serenity/

deploy:
  stage: deploy
  script:
    - mvn deploy
  only:
    - master
```
Project was created without using ChatGPT ;)