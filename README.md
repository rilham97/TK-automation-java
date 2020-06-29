# TK-automation

## Maven Running Configuration
Right-click the pom.xml file and select Run As  Maven build.
![alt text](https://www.vogella.com/tutorials/EclipseMaven/img/xm2e_javaconverttomaven20.png.pagespeed.ic.LJL9xBE1M_.webp)  

Enter "clean install" as Goal.
For the first build you should run mamven build, after that you can run MVN Test without run build as long you don't add or change any dependency

## Runner Test Configuration
For @CucumberOptions, the above would look like:

* Run feature or scenario which **only** have tag label tag1 = {"@tag1"}
* Run all feautre or scenario **except** tag1 = {"not tag1"}
* Run feature or scenario which have tag label tag1 **OR** tag2 = {"@tag1 or @tag2"}
* Run feature or scenario which have tag label tag1 **AND** tag2  = {"@tag1 and @tag2"}
* Combianation clause tags = {"@tag1 and (@tag2 or @tag3)"}
