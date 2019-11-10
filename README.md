# OWASPZAPOdooGauge
Run Automated Security/Penetration testing with OWASP ZAP + Selenium + TestNG + Gauge + Java + Maven + Odoo.
This repository has 2 ways to run the test :
- run it via TestNG framework
- run it via Gauge framework

Gauge is another alternative framework to write a test via specification without gerkhin langunge (Cucumber)

# Environment
```
MacOs/linux
IntelliJ
```


## Gauge
Gauge is a light-weight cross-platform test automation tool with the ability to author test cases in the business language.
```
https://docs.gauge.org/getting_started/installing-gauge.html?os=macos&language=java&ide=intellij
https://github.com/getgauge-examples/java-maven-selenium

Installation : 
$ brew install gauge
$ gauge install java

$ gauge -v
Gauge version: 1.0.6

Plugins
-------
html-report (4.0.8)
java (0.7.3)
screenshot (0.0.1)

```

## OWASP ZAP
The OWASP Zed Attack Proxy (ZAP) is one of the world’s most popular free security tools and is actively maintained by hundreds of international volunteers*. It can help you automatically find security vulnerabilities in your web applications while you are developing and testing your applications. Its also a great tool for experienced pentesters to use for manual security testing.
```
brew cask install owasp-zap
```

## Odoo
Odoo is an all-in-one business software including CRM, website/e-commerce, billing, accounting, manufacturing, warehouse - and project management, and inventory.
```
https://hub.docker.com/r/bitnami/odoo/

Installation :
$ curl -sSL https://raw.githubusercontent.com/bitnami/bitnami-docker-odoo/master/docker-compose.yml > docker-compose.yml

Run Odoo server :
$ docker-compose up -d

```

## Project Folders
```
https://docs.gauge.org/writing-specifications.html?os=macos&language=java&ide=intellij

Gauge Test
specs : A specification is a business test case which describes a particular feature of the application that needs testing.
reports : Gauge test report (html)
concepts : Concepts provide the ability to combine re-usable, logical groups of steps into a single unit.

TestNG Test
OdooScanTest.java

```

## Run the Test Via Command Line - TestNG
```
mvn clean test -DsuitXmlFile=TestNG.xml
```

## Run the Test Via Command Line - Gauge
```
mvn gauge:execute
```

## Run the Test Via Command Line - Both Framework
```
mvn clean test
```

## Report - OWASP ZAP
i.e.
![image](https://user-images.githubusercontent.com/26521948/68544654-6341f700-0400-11ea-9624-08bd58c335d5.png)

## Report - GAUGE FRAMEWORK 
i.e.
![image](https://user-images.githubusercontent.com/26521948/68544671-9a180d00-0400-11ea-8ebf-4c5b91516ebb.png)

## Recap - Youtube
```
https://www.youtube.com/watch?v=Cymsg63eOP4
```
[![IMAGE ALT TEXT HERE](https://www.youtube.com/watch?v=Cymsg63eOP4)](https://www.youtube.com/watch?v=Cymsg63eOP4)
