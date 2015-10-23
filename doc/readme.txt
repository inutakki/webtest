README.txt
==========

Welcome to (Kayak Flights Availability Check) webtest Maven Project!

webtest Version Notes
=========================
The webtest project v1.00 was built and tested using java version "1.7". Please refer to \webtest\pom.xml for various other version details.
webtest Project Workspace Organization has the following standard structure:

ProjectName\
ProjectName\doc\
ProjectName\report\
ProjectName\data\
ProjectName\test-output\
ProjectName\target\

Contents
========
This project includes the following as part of the compressed file package under which this README resides.

Deliverable			FileName & Relative Location Path
=========			===========================
1. Project URL		https://github.com/firmsoil/webtest
2. This File			webtest\doc\readme.txt
3. Source Code			webtest\src\test\java\com\hogai\webtest\search\ (Flight Search source)
				webtest\src\test\java\com\hogai\webtest\search\ (Page Object Model source)
4. Compiled Code			\webtest\target\test-classes\com\hogai\webtest\search (Flight Search class)
				\webtest\target\test-classes\com\hogai\webtest\pages (Page Object Model class)
5. TestNG Config Suite XML file - C:\Users\mpujari\workspace\webtest\src\main\resources\ (XML Suite files)
6. Maven POM File - \webtest\pom.xml
7. Copy of Input Data Set		webtest\data\input\ (placeholder)
8. Copy of Output Data		webtest\data\output\ (placeholder)


Usage & I/O
===========
1. Maven - mvn clean test
2. Jenkins
a. Create a Maven project
b. Configure "Root POM" as "<path to workspace>\webtest\pom.xml"
c. Configure Post-build Actions as "Publish TestNG Results" with "TestNG XML report pattern as <path to webtest>\test-output\testng-results.xml
(Please ensure that "TestNG Results Plugin" is installed in your Jenkins instance)
d. Run Build to execute and get results like following
[INFO] Installing C:\Users\mpujari\workspace\webtest\pom.xml to C:\Users\mpujari\.m2\repository\com\hogai\auto\webtest\0.0.1-SNAPSHOT\webtest-0.0.1-SNAPSHOT.pom
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------

Constraints/Restrictions
========================
1. Please do not hit the kayak.com production server in multithreaded mode from one IP. The multi-browser parallel option is not included 
in the TestNG.xml config file. It should be like

<!-- Uncomment/Include for parallel execution
  <test name="InternetExplorerTests">
    <parameter name="browserName" value="IE"/>
    <parameter name="baseURL" value="http://www.kayak.com/flights"/>
     <classes>
      <class name="com.hogai.webtest.search.FlightTest"/>
   </classes>
  </test>
--!>
<!-- for parallel execution use parallel="true" in the suite element -->

2. Use of Extent Reports is not fully complete but an HTML format of the report for management/business reporting is available at webtest\report\TestReport.html
  
Issues/Feedback
===============
Please contact manoj.pujari@gmail.com for support. I will be glad to be of assistance.

Finally
=======

I hope that you find webtest easy and enjoyable to use!




