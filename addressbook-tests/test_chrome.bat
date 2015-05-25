
rem run test using Chrome

java -cp bin;C:\JavaLibraries\xstream-1.4.8\lib\xstream-1.4.8.jar;C:\JavaLibraries\xstream-1.4.8\lib\xmlpull-1.1.3.1.jar;C:\JavaLibraries\xstream-1.4.8\lib\xpp3_min-1.1.4c.jar;C:\Tools\selenium-server-standalone-2.45.0.jar -DconfigFile=chrome.properties org.testng.TestNG testng-customsuite.xml

pause