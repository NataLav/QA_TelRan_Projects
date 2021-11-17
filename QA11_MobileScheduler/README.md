# QA11_MobileScheduler

Selenium-java tests for mobile app "Mobile Scheduler".

The app provides a service to create events on user's schedule. In the test package you will find basic tests for this app - creation of the new user, creation of the event for today and for the date specified in the past or future.

A project to build up a test coverage for an android mobile app.

Project is accomplished using Android emulator and Appium test automation tool. The project was build based on value object pattern.

The test package consist of

*  positive basic scenarios (login; creating, editing, deleting events)

*  UI tests (visibility objects on the page)

*  login Rest API tests

*  saving logs to a separate file each time while running the test script

Technology Used : Java, TestNG, Selenium, Gradle, Postman, Open API (Swagger), Appium, Android Studio


# To run the project a user should do:
1. start Appium server;
2. find and open in command line your android emulator:
```bash
emulator -list-avds
```
```bash
emulator @name_of_your_emulator
```
3. use Intellij IDEA to run the project or use command line:
```bash
gradle name_of_your_test_suite
```
(from your build.gradle file) 
