###**Test Project for testing API's Using RestAssured and TestNG**

This project tests the public API.

**DEPENDENCIES**:
 1. Java 7 or higher
 2. Gradle 3.0 or higher 
 3. Libraries:
	 a. RestAssured
	 b. TestNG
	 c. Apache HTTPCLient

**TestScenarios:**
Positive Testcase: Verify the behavior by providing all the required query parameters

Negative Testcase: Verify the behavior by removing the required query parameters.

**Project Structure:**
**main:** To write the common utilities used in the project like PropertiesLoader.java - to load the properties files.

**test:** Actual test cases are implemented in this directory. TestNASASoundsAPI.java

**resources:** Actual config properties files or TestData files.

**build.gradle:** This is the build configuration file.

**How to Run the project:** "gradle clean test" or to run a single testcase: "gradle -Dtest.single=testPosGetNASASounds test"

**Test Results Location:** ~/build\reports\tests\index.html

**Improvements that can be made:**

 - To read the testdata from an excel sheet with more test scenario data.

		 

