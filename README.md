# TOOLS QA

- WEB & API Automation Testing Using Java, cucumber and restAssured

- Test results monitoring tool [Calliope.pro](https://app.calliope.pro)

- Environment and specs: [automationpractice](https://demoqa.com/)

### dependencies:
- [selenium-java](https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java)
- [cucumber-java](https://mvnrepository.com/artifact/io.cucumber/cucumber-java)
- [cucumber-junit](https://mvnrepository.com/artifact/io.cucumber/cucumber-junit)
- [webdrivermanager](https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager)
- [jackson-databind](https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind)
- [rest-assured](https://mvnrepository.com/artifact/io.rest-assured/rest-assured)
- [hamcrest](https://mvnrepository.com/artifact/org.hamcrest/hamcrest)

### Setting Up
These instructions will get you a copy of the project up and running on your local machine.

- *clone the repo:*
```shell
git clone https://github.com/FulgerYilmaz/ta_qualification1.git
```
- *set project sdk as 1.8*

Running tests from terminal:
```shell
mvn verify --file pom.xml
```
Running tests in CI/CD pipeline:
- In this project I used github actions but for any other CI/CD tools,
  checkout [calliope](https://docs.calliope.pro/import/manual-import/) documentation.

- If you want to use same pipeline setup just add following variables defined inside the workflows/maven.yml
  to your github repository as secret variables.

```properties  
 API_KEY: Required to import tests to Calliope.pro. Can be found on your Calliope.pro account page
 PROFILE_ID: Tests will be imported in one of your profiles on Calliope.pro. 
```  
### About api scenarios:
Automated scenarios are:
- Get Pet Request (api)
- Get Pet Request (api)
- Post Pet Request (api)

### About ui scenarios:
Automated scenarios are:
- Elements Section (ui)
- Elements Section (ui)
- Widgets Section  (ui)

These are the most critical features for website.
If website visitors can not click the section and see the features, they will not be able to see the content, then nothing
reasons for staying. 
For the next step: Automate rest of sections for %100 coverage.
