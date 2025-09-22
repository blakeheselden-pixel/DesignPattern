## Introduction
Hello, to whoever that may be reading this, this is an implementation of the Abstract Factory Pattern that we learned in 
university (SOFE 3650). It also includes a small testing suite for ensuring function.

## Structure 
The project is split into 2 major parts, one of which is the [main](src/main) folder. This folder carries all the source 
code that runs our program. At a high level, it creates a very simple implementation of the Abstract Factory Pattern.
The [Main](src/main/java/Main.java) Java class within the src folder allows users to run a more interactive version of the code. 
You can choose the name of your file and change the contents of your file to whatever you'd like. 

The second part is the [test](src/test) folder, which contains the files needed to run the testing suite we made for our
code.

## Testing Method
This project includes a suite of JUnit 5 test classes located in src/test/java. The tests are made to validate the devices behave as expected and implementation of the Abstract Factory Pattern is done correctly.
Test Classes:
FactoryBrandATest - Verifies that FactoryBrandA creates SmartBulbA and SmartLockA. Ensures created objects are not null and have the correct manufacturer
FactoryBrandBTest - Verifies that FactoryBrandB creates SmartBulbB and SmartLockB. Ensures created objects are not null and have the correct manufacturer
SmartBulbTest - Confirms that bulb from each factory are of the correct subtype (SmartbulbA/SmartBulbB). Validates manufacturer branding strings.
SmartLockTest - Confirms that locks from each factory are of the correct subtype (SmartLockA/SmartLockB). Validates manufacturer brandin strings.
AssignmentTest - End to end test covering the two required assignment cases; Creating a Brand A Buld from FactoryBrandA, Creating a Brand B Lock from FactoryBrandB. Verifies correct instantiation, subtype, and manufacturer.

We used [JUnit5](https://docs.junit.org/current/user-guide/) from the Maven repository to run our Java tests. These unit
tests are run by instantiating the concrete classes that implement the interfaces, and thus _don't_ test the interfaces 
themselves. Nevertheless, from what we understand, interfaces and abstract classes should be tested using concrete 
implementations and not directly. Should you run into any troubles getting a correct output , please take a look at our 
screen dumps for what you should see when you run the tests.

>### UML Diagram Screen Capture:
> 
>![Alt text](screencaptures/AbstractFactory_UML.png?raw=true "Abstract Factory UML")
