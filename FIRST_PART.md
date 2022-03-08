### First part

This is the First Part of the POC set up file.

____

#### Prerequisites
1. [Java 1.8+](https://www.oracle.com/in/java/technologies/javase/jdk14-archive-downloads.html#license-lightbox) - Programming Language
2. [Eclipse](https://www.eclipse.org/downloads/download.php?file=/oomph/epp/2020-12/R/eclipse-inst-jre-win64.exe&mirror_id=1287) - Editor/IDE
3. [Maven](https://mirrors.estointernet.in/apache/maven/maven-3/3.6.3/binaries/apache-maven-3.6.3-bin.zip) - Build Management Tool
4. TestNG - Testing Framework (In build in the Eclipse)
5. GitHub - Repository Management Tool

#### Importing Project to Local
1. Open Command Prompt/Terminal in your machine.
2. Navigate your Command Prompt/Terminal to the folder where you need to clone the repository.
3. Once navigate to folder, enter below command to clone the repository.
```
git clone <repository url>
```
4. It may ask to enter your GitHub credentials if you're opening first time.
5. It may take sometime to download the complete repository to your local.
6. Once the project is imported successfully, open the IDE.
7. From the Eclipse, go to File > Import > Existing Project into Workspace > Next
8. Click on Browse > Select Project Folder > Click on Finish.
9. It may take sometime to import the project in Eclipse completely.

#### Project Structure
1. **resources**

   `resources` folder contains the resources like properties file, csv or excels for the data
2. **src/main/java**
    1. _utility_

       `utility` package contains all the required utilities and drivers classes for running the automation. It has `BaseClass` which is initializing the WebDriver, `CommonClass` which is part of the reusable common methods for the automation, `Pages` is an enum for the all the page url for the website, and `RandomData` is class for the generating the random data for each execution.
    2. _pages_

       `pages` package contains all the PageObjects for the automation, it has all the required locator for the executing the tests.
3. **src/test/java**
    1. _test_cases_

       `test_cases` package contains actual test cases for the automation, it has two different test class, one is `PerformanceTest` to check the page load time for the pages and another is `SmokeTest` which contains some smoke test cases for the Emrit website.
4. **testng.xml**

   `testng.xml` file is the runner file for the all the test cases and contains list of the test cases based on the class for the execution. You can run `testng.xml` file to executing the tests, but it would be recommended to run `pom.xml` always to run the test execution
5. **pom.xml**

   `pom.xml` is the build file provided from Maven, it is similar to `package.json` in JS framework. `pom.xml` contains all the required dependencies and some scripts to execute. You need to run the `pom.xml` file (command provided below) to execute the test and generate the final test report.
6. **Reports**

   `Reports` folder will be created only after first execution will be done, it will autogenerate the report for each test execution and share the result

#### Passing configuration

- Before running the execution, you need to pass the `LOGIN_EMAIL` and `LOGIN_PASSWORD` in the `resources/config.properties` file for the login test execution.

#### Executing Tests

1. Open Command Prompt/Terminal in your machine.
2. Navigate your Command Prompt/Terminal to the project folder.
3. Once navigate inside project folder, enter below command to run the test execution
```
mvn clean install
```

#### Test Results

- Once the execution will complete the Test Report generated in the project folder itself.
- From the Project Explorer Open `Reports > Report_xxxxx` where xxxxx is the execution date and time
- Open the Report file `index.html` in the browser.
- You'll see the execution result with the steps performed and test results.
- In the report go to `Reporter Output` section for the all test execution steps.

#### TestNG Installation

- TestNG runner is already provided by Eclipse as default plugin when you install the Eclipse.
- For TestNG execution, we're using the jar file which downloaded directly from the Maven archive from `pom.xml` file.
