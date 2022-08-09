# ABN - Gitlab API Automation

This repository contains the automation application that performs checks to verify the Gitlab API CURD operations.
## Getting Started

### Prerequisites

- Git
- An IDE

### External Libraries Used

- Rest Assured
- lombok 4.0.0
- Serenity BDD 2.1.5
- Cucumber 2.1.2
- Gradle 6.8
- JDK 15 or below

### Gitlab Account Details

For test purpose, a Gitlab account is created. Users can log in using the below credentials and use the Gitlab UI if needed.

Email: abngitlabapi@myself.com

Password : Abn@gitlabapi

Gitlab Link : https://gitlab.com/users/sign_in

## Running the tests

1.Use below command to execute the tests:

Linux/Mac:
```
./gradlew test \
-Denv=<ENVIRONMENT (local or staging)> \
-DtargetURL='https://gitlab.com'
```

or to run the whole build
```
./gradlew build \
-Denv=<ENVIRONMENT (local or staging)> \
-DtargetURL='https://gitlab.com'
```
> On windows, use `gradle.bat`

2.If all works fine you will find an index.html file inside [**target/site/serenity**](/target/site/serenity) folder with the results of the
tests.

## Example Report:

![Serenity BDD - Test Report HTML Home](/resources/images/SerenitySummary.png)

![Serenity BDD - Test Report HTML Home](/resources/images/AllTestResults.png)

![Serenity BDD - Test Report HTML Home](/resources/images/TestLevelReport.png)

# Architecture

The architectural approach is based on Dave Farley's DSL + Protocol Drivers approach.

The project is divided into 4 layers:

**1 - Test Cases:**

Placed at the folder **src/test/resources/features/**, the test cases are scenarios written in Gherkin.
Their goal is to describe the capabilities of the System Under Test (SUT), so that their successful
verification would mean that the SUT has the behaviors we want it to have.


**2 - Domain Specific Language (DSL):**

Placed at the folder **src/test/java/dsl**, the goal this layer is two-fold:

1 - Describe the flows of behavior to implement each step defined in the Test Cases, on the _usecases_ folders.
As a side effect of the definition of these flows, data-structures named Entities will be used created in order to
package the data necessary to interact with the underlying systems and check their responses.

2 - Define the behavior of the systems the project will interact, named _XYZProtocol_.


**3 - Protocol Drivers (PD):**

Placed at the folder **src/test/java/protocoldrivers** folder, PDs implement a _Protocol_ interface, against
a particular implementation of the SUT and other systems.


**4 - System Under Test:**

The SUTs are external to this project. Here, we target the Gitlab APIs.

![4 layered architecture](/resources/images/Screenshot 2022-03-03 at 16.33.47.png)

## FAQ

#### How can I get the project into my IDE?
Clone or download the project repository from the below GitHub link.

#### How can I execute the tests?
Refer the **Running the tests** section or inside your IDE create a gradle run configurations and provide the -Denv and -DtargetURL values and run the tests.

#### I'm getting compile errors. What is the next step?
Make sure you have downloaded/cloned the project correctly. Also verify the compiler settings in your IDE.

#### Do I need any proxy settings to run the tests?
NO. Gitlab APIs are Open APIs and only PRIVATE-TOKEN is needed to execute the tests.
