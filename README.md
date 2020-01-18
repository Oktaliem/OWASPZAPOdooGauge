<h1 align="center"><img src="https://user-images.githubusercontent.com/26521948/72658109-63a1d400-39e7-11ea-9667-c652586b4508.png" alt="Apache JMeter logo" /></h1>
<h4 align="center">SOFTWARE TESTING ENTHUSIAST</h4>
<br>

# OWASPZAPOdooGauge
Automated Security/Penetration testing demo with OWASP ZAP + Selenium + TestNG + Gauge + Java + Maven + Odoo.
This repository has 2 ways to run the test :
- run it via TestNG framework
- run it via Gauge framework

# Purpose
- This demo/repository is to provide example or framework/model that QA can be integrated as a part of CICD -DevSecOps.
```
https://www.redhat.com/en/topics/devops/what-is-devsecops
```
- Eveybody can clone/fork from this repository, run in their own local and learn security/penetration testing as a proof of concept.

# Statement
The author of this repository is not subject expert matter in penetration testing.
If you have any idea, suggestion or something that can be improved.
Nice to talk!! Sharing is caring. Let's learn together....

# Obstacle
This library/demo still unable to spidering sites & links after login if web application contains authentication token such as CSRF,etc during form login submission.

# Environment
```
MacOs/linux
IntelliJ
```

## Gauge - Test Automation Framework
Gauge is a light-weight cross-platform test automation tool with the ability to author test cases in the business language.

```
https://gauge.org/
https://docs.gauge.org/getting_started/installing-gauge.html?os=macos&language=java&ide=intellij

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

## OWASP ZAP - Security/Penetration Testing Tool
The OWASP Zed Attack Proxy (ZAP) is one of the world’s most popular free security tools and is actively maintained by hundreds of international volunteers*. It can help you automatically find security vulnerabilities in your web applications while you are developing and testing your applications. Its also a great tool for experienced pentesters to use for manual security testing.
```
https://www.owasp.org/index.php/OWASP_Zed_Attack_Proxy_Project
https://github.com/zaproxy/zaproxy/wiki/Downloads

$ brew cask install owasp-zap
```
Let's get familiar with it.
```
https://www.youtube.com/watch?v=wXext48sIHk
https://www.youtube.com/watch?v=b8M7Iha68I8
```

## Odoo - System Under Test
Odoo is an (Open Source ERP) all-in-one business software including CRM, website/e-commerce, billing, accounting, manufacturing, warehouse - and project management, and inventory.
Odoo will be used in this repository as web application target to find vulnerabilities.
```
https://hub.docker.com/r/bitnami/odoo/

Installation :
$ curl -sSL https://raw.githubusercontent.com/bitnami/bitnami-docker-odoo/master/docker-compose.yml > docker-compose.yml

Run Odoo server :
$ docker-compose up -d

```

## Project Folders
```
Gauge is another alternative framework to write a test via specification without gerkhin langunge 
(i.e Cucumber/JBehave)
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
$ mvn clean test -DsuitXmlFile=TestNG.xml
or 
$ mvn clean test
```

## Run the Test Via Command Line - Gauge
```
$ mvn gauge:execute
```

## Report - OWASP ZAP
i.e.

![image](https://user-images.githubusercontent.com/26521948/68544654-6341f700-0400-11ea-9624-08bd58c335d5.png)
Note : consider only the result that related to web app target (http://localhost/web/login/...)

## Report - GAUGE FRAMEWORK 
i.e.
![image](https://user-images.githubusercontent.com/26521948/68544671-9a180d00-0400-11ea-8ebf-4c5b91516ebb.png)

## Recap - Youtube
   <a href="https://www.youtube.com/watch?v=Cymsg63eOP4" target="_blank"><img src="https://user-images.githubusercontent.com/26521948/72658109-63a1d400-39e7-11ea-9667-c652586b4508.png" 
   alt="CLICK HERE" width="140" height="80" border="10" /></a>


## Testing Log

<details>
<summary>
CLICK ME
</summary>
<p>
 
```maven

GAUGE LOG :

[INFO] Scanning for projects...
[WARNING] 
[WARNING] Some problems were encountered while building the effective model for owaspzapodoogauge:owaspzapodoogauge:jar:1.0-SNAPSHOT
[WARNING] 'dependencies.dependency.systemPath' for net.continuumsecurity:zap-java-api:jar should not point at files within the project directory, ${project.basedir}/libs/proxy-2.4.2-SNAPSHOT.jar will be unresolvable by dependent projects @ line 73, column 25
[WARNING] 'dependencies.dependency.systemPath' for org.owasp:zaproxy-client-api:jar should not point at files within the project directory, ${project.basedir}/libs/zap-api-2.4-v6.jar will be unresolvable by dependent projects @ line 80, column 25
[WARNING] 'dependencies.dependency.systemPath' for edu.umass.cs.benchlab:harlib:jar should not point at files within the project directory, ${project.basedir}/libs/harlib-1.1.1.jar will be unresolvable by dependent projects @ line 87, column 25
[WARNING] 'dependencies.dependency.(groupId:artifactId:type:classifier)' must be unique: org.testng:testng:jar -> duplicate declaration of version 7.0.0 @ line 89, column 21
[WARNING] 'dependencies.dependency.(groupId:artifactId:type:classifier)' must be unique: com.thoughtworks.gauge:gauge-java:jar -> duplicate declaration of version 0.6.7 @ line 102, column 21
[WARNING] 
[WARNING] It is highly recommended to fix these problems because they threaten the stability of your build.
[WARNING] 
[WARNING] For this reason, future Maven versions might no longer support building such malformed projects.
[WARNING] 
[INFO] 
[INFO] ----------------< owaspzapodoogauge:owaspzapodoogauge >-----------------
[INFO] Building owaspzapodoogauge 1.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- gauge-maven-plugin:1.3.0:execute (default-cli) @ owaspzapodoogauge ---
[WARNING] [gauge] Property 'specsDir' not set. Using default value => 'specs'

Telemetry
---------

This installation of Gauge collects usage data in order to help us improve your experience.
The data is anonymous and doesn't include command-line arguments.
To turn this message off opt in or out by running 'gauge telemetry on' or 'gauge telemetry off'.

Read more about Gauge telemetry at https://gauge.org/telemetry


WARNING: An illegal reflective access operation has occurred
WARNING: Illegal reflective access by com.google.protobuf.UnsafeUtil (file:/Users/oktaliem/.m2/repository/com/google/protobuf/protobuf-java/3.3.1/protobuf-java-3.3.1.jar) to field java.nio.Buffer.address
WARNING: Please consider reporting this to the maintainers of com.google.protobuf.UnsafeUtil
WARNING: Use --illegal-access=warn to enable warnings of further illegal reflective access operations
WARNING: All illegal access operations will be denied in a future release
Nov 28, 2019 6:56:01 AM org.openqa.selenium.remote.DesiredCapabilities chrome
INFO: Using `new ChromeOptions()` is preferred to `DesiredCapabilities.chrome()`
Starting ChromeDriver 78.0.3904.70 (edb9c9f3de0247fd912a77b7f6cae7447f6d3ad5-refs/branch-heads/3904@{#800}) on port 23537
Only local connections are allowed.
Please protect ports used by ChromeDriver and related test frameworks to prevent access by malicious code.
Nov 28, 2019 6:56:04 AM org.openqa.selenium.remote.ProtocolHandshake createSession
INFO: Detected dialect: W3C
# Odoo Security/Penetration Testing
  ## TC01 - Login Page ZAP Scanning before Login        2019-11-28 06:56:05,133 [Thread-0] INFO  Gauge  - Landing to Login Page: http://localhost/web/login/
 ✔http://localhost/web/login/
2019-11-28 06:56:05,850 [Thread-0] INFO  Gauge  - Created client to ZAP API
2019-11-28 06:56:05,850 [Thread-0] INFO  Gauge  - Spidering Odoo...
2019-11-28 06:56:08,934 [Thread-0] INFO  Gauge  - Found URL: http://localhost/sitemap.xml
2019-11-28 06:56:08,934 [Thread-0] INFO  Gauge  - Found URL: http://localhost/
2019-11-28 06:56:08,934 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web/static/lib/bootstrap/css/bootstrap.css
2019-11-28 06:56:08,934 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web/static/lib/bootstrap/js/collapse.js
2019-11-28 06:56:08,934 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web/signup
2019-11-28 06:56:08,934 [Thread-0] INFO  Gauge  - Found URL: http://localhost/logo.png?company=1
2019-11-28 06:56:08,934 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web/static/src/img/logo2.png
2019-11-28 06:56:08,934 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web/static/lib/bootstrap/js/scrollspy.js
2019-11-28 06:56:08,934 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web/static/lib/bootstrap/js/modal.js
2019-11-28 06:56:08,934 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web/static/lib/bootstrap/js/popover.js
2019-11-28 06:56:08,934 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web/static/lib/bootstrap/js/alert.js
2019-11-28 06:56:08,935 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web/static/lib/bootstrap/js/tooltip.js
2019-11-28 06:56:08,935 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web/static/lib/bootstrap/js/index.js
2019-11-28 06:56:08,935 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web/static/lib/jquery/jquery.js
2019-11-28 06:56:08,935 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web/static/lib/bootstrap/js/carousel.js
2019-11-28 06:56:08,935 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web/static/lib/bootstrap/js/tab.js
2019-11-28 06:56:08,935 [Thread-0] INFO  Gauge  - Found URL: http://localhost/robots.txt
2019-11-28 06:56:08,935 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web
2019-11-28 06:56:08,935 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web/signup?redirect=http%3A%2F%2Flocalhost%2Fmy
2019-11-28 06:56:08,935 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web/content/425-bd52e6b/web.assets_frontend_minimal_js.js
2019-11-28 06:56:08,935 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web/login/
2019-11-28 06:56:08,935 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web/binary/company_logo
2019-11-28 06:56:08,935 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web/static/lib/fontawesome/css/font-awesome.css
2019-11-28 06:56:08,935 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web/reset_password
2019-11-28 06:56:08,935 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web/database/manager
2019-11-28 06:56:08,935 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web/content/664-fa3905a/web.assets_frontend.css
2019-11-28 06:56:08,935 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web/login
2019-11-28 06:56:08,935 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web/static/src/img/odoo_logo_tiny.png
2019-11-28 06:56:08,935 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web/static/lib/bootstrap/js/dropdown.js
2019-11-28 06:56:08,936 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web/static/src/img/favicon.ico
2019-11-28 06:56:08,936 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web/static/lib/bootstrap/js/util.js
2019-11-28 06:56:08,936 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web/content/424-d600052/web.assets_common_minimal_js.js
2019-11-28 06:56:08,936 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web?db=bitnami_odoo
2019-11-28 06:56:08,936 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web/content/654-4cce8d0/web.assets_common.css
2019-11-28 06:56:08,936 [Thread-0] INFO  Gauge  - Found URL: http://localhost/my
2019-11-28 06:56:08,936 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web/static/lib/bootstrap/js/button.js
2019-11-28 06:56:08,936 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web/login?redirect=http%3A%2F%2Flocalhost%2Fmy
2019-11-28 06:56:08,936 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web/static/lib/popper/popper.js
2019-11-28 06:56:08,936 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web/reset_password?redirect=http%3A%2F%2Flocalhost%2Fmy
2019-11-28 06:56:08,936 [Thread-0] INFO  Gauge  - Spider Odoo done.....
 ✔2019-11-28 06:56:09,158 [Thread-0] INFO  Gauge  - Set Alert and Attack Strength
 ✔2019-11-28 06:56:09,168 [Thread-0] INFO  Gauge  - Set Enable Passive Scanner
 ✔2019-11-28 06:56:09,173 [Thread-0] INFO  Gauge  - Scanning...http://localhost/web/login/
2019-11-28 06:56:09,274 [Thread-0] INFO  Gauge  - Scan is 13% complete.
2019-11-28 06:56:10,281 [Thread-0] INFO  Gauge  - Scan is 13% complete.
2019-11-28 06:56:11,288 [Thread-0] INFO  Gauge  - Scan is 100% complete.
2019-11-28 06:56:12,289 [Thread-0] INFO  Gauge  - Scanning done.
 ✔2019-11-28 06:56:12,368 [Thread-0] INFO  Gauge  - Remove false positive
 ✔2019-11-28 06:56:12,453 [Thread-0] INFO  Gauge  - Generate HTML Report
 ✔
  ## TC02 - Afer Login ZAP Scanning after Login 2019-11-28 06:56:12,640 [Thread-0] INFO  Gauge  - Landing to Login Page: http://localhost/web/login/
 ✔2019-11-28 06:56:12,819 [Thread-0] INFO  Gauge  - User inputs field with element: By.id: login and value user@example.com
2019-11-28 06:56:12,910 [Thread-0] INFO  Gauge  - User inputs field with element: By.id: password and value bitnami
2019-11-28 06:56:18,821 [Thread-0] INFO  Gauge  - User clicks On Element: By.className: btn-primary
2019-11-28 06:56:21,826 [Thread-0] INFO  Gauge  - User waits for 3000 milliseconds
 ✔http://localhost/web#cids=1
2019-11-28 06:56:22,381 [Thread-0] INFO  Gauge  - Created client to ZAP API
2019-11-28 06:56:22,381 [Thread-0] INFO  Gauge  - Spidering Odoo...
2019-11-28 06:56:25,457 [Thread-0] INFO  Gauge  - Found URL: http://localhost/sitemap.xml
2019-11-28 06:56:25,458 [Thread-0] INFO  Gauge  - Found URL: http://localhost/
2019-11-28 06:56:25,458 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web/static/lib/bootstrap/css/bootstrap.css
2019-11-28 06:56:25,458 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web/static/lib/bootstrap/js/collapse.js
2019-11-28 06:56:25,458 [Thread-0] INFO  Gauge  - Found URL: http://localhost/logo.png?company=1
2019-11-28 06:56:25,458 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web/signup
2019-11-28 06:56:25,458 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web/static/src/img/logo2.png
2019-11-28 06:56:25,458 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web/static/lib/bootstrap/js/scrollspy.js
2019-11-28 06:56:25,458 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web/static/lib/bootstrap/js/modal.js
2019-11-28 06:56:25,458 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web/static/lib/bootstrap/js/popover.js
2019-11-28 06:56:25,458 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web/static/lib/bootstrap/js/alert.js
2019-11-28 06:56:25,458 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web/static/lib/bootstrap/js/tooltip.js
2019-11-28 06:56:25,458 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web/static/lib/bootstrap/js/index.js
2019-11-28 06:56:25,458 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web/static/lib/jquery/jquery.js
2019-11-28 06:56:25,458 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web/static/lib/bootstrap/js/carousel.js
2019-11-28 06:56:25,458 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web/static/lib/bootstrap/js/tab.js
2019-11-28 06:56:25,458 [Thread-0] INFO  Gauge  - Found URL: http://localhost/robots.txt
2019-11-28 06:56:25,458 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web
2019-11-28 06:56:25,458 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web/signup?redirect=http%3A%2F%2Flocalhost%2Fmy
2019-11-28 06:56:25,458 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web/content/425-bd52e6b/web.assets_frontend_minimal_js.js
2019-11-28 06:56:25,458 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web/binary/company_logo
2019-11-28 06:56:25,458 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web/static/lib/fontawesome/css/font-awesome.css
2019-11-28 06:56:25,458 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web/database/manager
2019-11-28 06:56:25,458 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web/reset_password
2019-11-28 06:56:25,458 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web/login
2019-11-28 06:56:25,458 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web/content/664-fa3905a/web.assets_frontend.css
2019-11-28 06:56:25,458 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web/static/src/img/odoo_logo_tiny.png
2019-11-28 06:56:25,459 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web/static/lib/bootstrap/js/dropdown.js
2019-11-28 06:56:25,459 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web/static/src/img/favicon.ico
2019-11-28 06:56:25,459 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web/static/lib/bootstrap/js/util.js
2019-11-28 06:56:25,459 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web/content/424-d600052/web.assets_common_minimal_js.js
2019-11-28 06:56:25,459 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web?db=bitnami_odoo
2019-11-28 06:56:25,459 [Thread-0] INFO  Gauge  - Found URL: http://localhost/my
2019-11-28 06:56:25,459 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web/content/654-4cce8d0/web.assets_common.css
2019-11-28 06:56:25,459 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web/login?redirect=http%3A%2F%2Flocalhost%2Fmy
2019-11-28 06:56:25,459 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web/static/lib/bootstrap/js/button.js
2019-11-28 06:56:25,459 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web/reset_password?redirect=http%3A%2F%2Flocalhost%2Fmy
2019-11-28 06:56:25,459 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web/static/lib/popper/popper.js
2019-11-28 06:56:25,459 [Thread-0] INFO  Gauge  - Spider Odoo done.....
 ✔2019-11-28 06:56:25,723 [Thread-0] INFO  Gauge  - Set Alert and Attack Strength
 ✔2019-11-28 06:56:25,749 [Thread-0] INFO  Gauge  - Set Enable Passive Scanner
 ✔2019-11-28 06:56:25,756 [Thread-0] INFO  Gauge  - Scanning...http://localhost/web#cids=1
2019-11-28 06:56:25,800 [Thread-0] INFO  Gauge  - Scan is 0% complete.
2019-11-28 06:56:26,807 [Thread-0] INFO  Gauge  - Scan is 2% complete.
2019-11-28 06:56:27,814 [Thread-0] INFO  Gauge  - Scan is 2% complete.
2019-11-28 06:56:28,822 [Thread-0] INFO  Gauge  - Scan is 2% complete.
2019-11-28 06:56:29,830 [Thread-0] INFO  Gauge  - Scan is 2% complete.
2019-11-28 06:56:30,840 [Thread-0] INFO  Gauge  - Scan is 2% complete.
2019-11-28 06:56:31,849 [Thread-0] INFO  Gauge  - Scan is 2% complete.
2019-11-28 06:56:32,856 [Thread-0] INFO  Gauge  - Scan is 2% complete.
2019-11-28 06:56:33,863 [Thread-0] INFO  Gauge  - Scan is 2% complete.
2019-11-28 06:56:34,870 [Thread-0] INFO  Gauge  - Scan is 2% complete.
2019-11-28 06:56:35,876 [Thread-0] INFO  Gauge  - Scan is 3% complete.
2019-11-28 06:56:36,882 [Thread-0] INFO  Gauge  - Scan is 3% complete.
2019-11-28 06:56:37,888 [Thread-0] INFO  Gauge  - Scan is 4% complete.
2019-11-28 06:56:38,894 [Thread-0] INFO  Gauge  - Scan is 7% complete.
2019-11-28 06:56:39,899 [Thread-0] INFO  Gauge  - Scan is 7% complete.
2019-11-28 06:56:40,910 [Thread-0] INFO  Gauge  - Scan is 7% complete.
2019-11-28 06:56:41,930 [Thread-0] INFO  Gauge  - Scan is 8% complete.
2019-11-28 06:56:42,936 [Thread-0] INFO  Gauge  - Scan is 8% complete.
2019-11-28 06:56:43,944 [Thread-0] INFO  Gauge  - Scan is 11% complete.
2019-11-28 06:56:44,951 [Thread-0] INFO  Gauge  - Scan is 11% complete.
2019-11-28 06:56:45,960 [Thread-0] INFO  Gauge  - Scan is 18% complete.
2019-11-28 06:56:46,970 [Thread-0] INFO  Gauge  - Scan is 21% complete.
2019-11-28 06:56:47,977 [Thread-0] INFO  Gauge  - Scan is 24% complete.
2019-11-28 06:56:48,980 [Thread-0] INFO  Gauge  - Scan is 24% complete.
2019-11-28 06:56:49,985 [Thread-0] INFO  Gauge  - Scan is 26% complete.
2019-11-28 06:56:50,994 [Thread-0] INFO  Gauge  - Scan is 29% complete.
2019-11-28 06:56:52,002 [Thread-0] INFO  Gauge  - Scan is 32% complete.
2019-11-28 06:56:53,016 [Thread-0] INFO  Gauge  - Scan is 34% complete.
2019-11-28 06:56:54,026 [Thread-0] INFO  Gauge  - Scan is 35% complete.
2019-11-28 06:56:55,036 [Thread-0] INFO  Gauge  - Scan is 36% complete.
2019-11-28 06:56:56,049 [Thread-0] INFO  Gauge  - Scan is 37% complete.
2019-11-28 06:56:57,058 [Thread-0] INFO  Gauge  - Scan is 38% complete.
2019-11-28 06:56:58,067 [Thread-0] INFO  Gauge  - Scan is 41% complete.
2019-11-28 06:56:59,075 [Thread-0] INFO  Gauge  - Scan is 43% complete.
2019-11-28 06:57:00,084 [Thread-0] INFO  Gauge  - Scan is 46% complete.
2019-11-28 06:57:01,087 [Thread-0] INFO  Gauge  - Scan is 46% complete.
2019-11-28 06:57:02,104 [Thread-0] INFO  Gauge  - Scan is 46% complete.
2019-11-28 06:57:03,114 [Thread-0] INFO  Gauge  - Scan is 46% complete.
2019-11-28 06:57:04,119 [Thread-0] INFO  Gauge  - Scan is 46% complete.
2019-11-28 06:57:05,124 [Thread-0] INFO  Gauge  - Scan is 46% complete.
2019-11-28 06:57:06,130 [Thread-0] INFO  Gauge  - Scan is 46% complete.
2019-11-28 06:57:07,135 [Thread-0] INFO  Gauge  - Scan is 47% complete.
2019-11-28 06:57:08,139 [Thread-0] INFO  Gauge  - Scan is 49% complete.
2019-11-28 06:57:09,145 [Thread-0] INFO  Gauge  - Scan is 52% complete.
2019-11-28 06:57:10,152 [Thread-0] INFO  Gauge  - Scan is 52% complete.
2019-11-28 06:57:11,159 [Thread-0] INFO  Gauge  - Scan is 54% complete.
2019-11-28 06:57:12,164 [Thread-0] INFO  Gauge  - Scan is 57% complete.
2019-11-28 06:57:13,173 [Thread-0] INFO  Gauge  - Scan is 57% complete.
2019-11-28 06:57:14,179 [Thread-0] INFO  Gauge  - Scan is 57% complete.
2019-11-28 06:57:15,187 [Thread-0] INFO  Gauge  - Scan is 57% complete.
2019-11-28 06:57:16,195 [Thread-0] INFO  Gauge  - Scan is 57% complete.
2019-11-28 06:57:17,202 [Thread-0] INFO  Gauge  - Scan is 57% complete.
2019-11-28 06:57:18,210 [Thread-0] INFO  Gauge  - Scan is 57% complete.
2019-11-28 06:57:19,215 [Thread-0] INFO  Gauge  - Scan is 58% complete.
2019-11-28 06:57:20,224 [Thread-0] INFO  Gauge  - Scan is 59% complete.
2019-11-28 06:57:21,230 [Thread-0] INFO  Gauge  - Scan is 59% complete.
2019-11-28 06:57:22,234 [Thread-0] INFO  Gauge  - Scan is 60% complete.
2019-11-28 06:57:23,245 [Thread-0] INFO  Gauge  - Scan is 61% complete.
2019-11-28 06:57:24,253 [Thread-0] INFO  Gauge  - Scan is 62% complete.
2019-11-28 06:57:25,260 [Thread-0] INFO  Gauge  - Scan is 63% complete.
2019-11-28 06:57:26,266 [Thread-0] INFO  Gauge  - Scan is 64% complete.
2019-11-28 06:57:27,271 [Thread-0] INFO  Gauge  - Scan is 65% complete.
2019-11-28 06:57:28,282 [Thread-0] INFO  Gauge  - Scan is 66% complete.
2019-11-28 06:57:29,290 [Thread-0] INFO  Gauge  - Scan is 67% complete.
2019-11-28 06:57:30,296 [Thread-0] INFO  Gauge  - Scan is 68% complete.
2019-11-28 06:57:31,306 [Thread-0] INFO  Gauge  - Scan is 69% complete.
2019-11-28 06:57:32,316 [Thread-0] INFO  Gauge  - Scan is 69% complete.
2019-11-28 06:57:33,319 [Thread-0] INFO  Gauge  - Scan is 73% complete.
2019-11-28 06:57:34,326 [Thread-0] INFO  Gauge  - Scan is 76% complete.
2019-11-28 06:57:35,332 [Thread-0] INFO  Gauge  - Scan is 79% complete.
2019-11-28 06:57:36,339 [Thread-0] INFO  Gauge  - Scan is 80% complete.
2019-11-28 06:57:37,349 [Thread-0] INFO  Gauge  - Scan is 84% complete.
2019-11-28 06:57:38,358 [Thread-0] INFO  Gauge  - Scan is 85% complete.
2019-11-28 06:57:39,368 [Thread-0] INFO  Gauge  - Scan is 86% complete.
2019-11-28 06:57:40,373 [Thread-0] INFO  Gauge  - Scan is 89% complete.
2019-11-28 06:57:41,382 [Thread-0] INFO  Gauge  - Scan is 91% complete.
2019-11-28 06:57:42,386 [Thread-0] INFO  Gauge  - Scan is 92% complete.
2019-11-28 06:57:43,395 [Thread-0] INFO  Gauge  - Scan is 100% complete.
2019-11-28 06:57:44,401 [Thread-0] INFO  Gauge  - Scanning done.
 ✔2019-11-28 06:57:44,435 [Thread-0] INFO  Gauge  - Alert: SQL Injection at URL: http://localhost/web/login?redirect=http%3A%2F%2Flocalhost%2Fmy+AND+1%3D1+--+ Parameter: redirect CWE ID: 89
 ✘
            Failed Step: Remove False Positive
            Specification: specs/ZapTest.spec
            Error Message: java.lang.AssertionError: 
            Expected: <0>
                 but: was <1>
            Stacktrace: 
            org.hamcrest.MatcherAssert.assertThat(MatcherAssert.java:20)
            org.hamcrest.MatcherAssert.assertThat(MatcherAssert.java:8)
            net.oktaliem.gaugetest.PageActions.removeFalsePositive(PageActions.java:521)
            net.oktaliem.gaugetest.PageSteps.falsePositive(PageSteps.java:55)
            java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
            java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
            java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
            java.base/java.lang.reflect.Method.invoke(Method.java:566)
            com.thoughtworks.gauge.execution.MethodExecutor.execute(MethodExecutor.java:38)
            com.thoughtworks.gauge.execution.StepExecutionStage.executeStepMethod(StepExecutionStage.java:74)
            com.thoughtworks.gauge.execution.StepExecutionStage.executeStep(StepExecutionStage.java:67)
            com.thoughtworks.gauge.execution.StepExecutionStage.execute(StepExecutionStage.java:49)
            com.thoughtworks.gauge.execution.AbstractExecutionStage.executeNext(AbstractExecutionStage.java:24)
            com.thoughtworks.gauge.execution.HookExecutionStage.execute(HookExecutionStage.java:43)
            com.thoughtworks.gauge.execution.ExecutionPipeline.start(ExecutionPipeline.java:29)
            com.thoughtworks.gauge.processor.ExecuteStepProcessor.process(ExecuteStepProcessor.java:45)
            com.thoughtworks.gauge.connection.MessageDispatcher.dispatchMessages(MessageDispatcher.java:92)
            com.thoughtworks.gauge.GaugeRuntime.dispatchMessages(GaugeRuntime.java:96)
            com.thoughtworks.gauge.GaugeRuntime.lambda$connectSynchronously$1(GaugeRuntime.java:79)
            java.base/java.lang.Thread.run(Thread.java:834)
            
  ## TC03 - Database Manager Page ZAP Scanning  2019-11-28 06:57:46,174 [Thread-0] INFO  Gauge  - Landing to Database Manager Page: http://localhost/web/database/manager
 ✔http://localhost/web/database/manager
2019-11-28 06:57:46,726 [Thread-0] INFO  Gauge  - Created client to ZAP API
2019-11-28 06:57:46,727 [Thread-0] INFO  Gauge  - Spidering Odoo...
2019-11-28 06:57:49,796 [Thread-0] INFO  Gauge  - Found URL: http://localhost/sitemap.xml
2019-11-28 06:57:49,796 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web/static/lib/bootstrap/css/bootstrap.css
2019-11-28 06:57:49,796 [Thread-0] INFO  Gauge  - Found URL: http://localhost/
2019-11-28 06:57:49,796 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web/static/lib/bootstrap/js/collapse.js
2019-11-28 06:57:49,796 [Thread-0] INFO  Gauge  - Found URL: http://localhost/logo.png?company=1
2019-11-28 06:57:49,796 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web/signup
2019-11-28 06:57:49,796 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web/static/src/img/logo2.png
2019-11-28 06:57:49,796 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web/static/lib/bootstrap/js/scrollspy.js
2019-11-28 06:57:49,796 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web/static/lib/bootstrap/js/modal.js
2019-11-28 06:57:49,796 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web/static/lib/bootstrap/js/popover.js
2019-11-28 06:57:49,796 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web/static/lib/bootstrap/js/alert.js
2019-11-28 06:57:49,796 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web/static/lib/bootstrap/js/tooltip.js
2019-11-28 06:57:49,797 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web/static/lib/bootstrap/js/index.js
2019-11-28 06:57:49,797 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web/static/lib/jquery/jquery.js
2019-11-28 06:57:49,797 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web/static/lib/bootstrap/js/carousel.js
2019-11-28 06:57:49,797 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web/static/lib/bootstrap/js/tab.js
2019-11-28 06:57:49,797 [Thread-0] INFO  Gauge  - Found URL: http://localhost/robots.txt
2019-11-28 06:57:49,797 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web
2019-11-28 06:57:49,797 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web/signup?redirect=http%3A%2F%2Flocalhost%2Fmy
2019-11-28 06:57:49,797 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web/content/425-bd52e6b/web.assets_frontend_minimal_js.js
2019-11-28 06:57:49,797 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web/binary/company_logo
2019-11-28 06:57:49,797 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web/static/lib/fontawesome/css/font-awesome.css
2019-11-28 06:57:49,797 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web/database/manager
2019-11-28 06:57:49,797 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web/reset_password
2019-11-28 06:57:49,797 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web/login
2019-11-28 06:57:49,797 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web/content/664-fa3905a/web.assets_frontend.css
2019-11-28 06:57:49,797 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web/static/lib/bootstrap/js/dropdown.js
2019-11-28 06:57:49,797 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web/static/src/img/odoo_logo_tiny.png
2019-11-28 06:57:49,797 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web/static/src/img/favicon.ico
2019-11-28 06:57:49,797 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web/static/lib/bootstrap/js/util.js
2019-11-28 06:57:49,797 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web/content/424-d600052/web.assets_common_minimal_js.js
2019-11-28 06:57:49,797 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web?db=bitnami_odoo
2019-11-28 06:57:49,797 [Thread-0] INFO  Gauge  - Found URL: http://localhost/my
2019-11-28 06:57:49,797 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web/content/654-4cce8d0/web.assets_common.css
2019-11-28 06:57:49,797 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web/static/lib/bootstrap/js/button.js
2019-11-28 06:57:49,798 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web/login?redirect=http%3A%2F%2Flocalhost%2Fmy
2019-11-28 06:57:49,798 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web/static/lib/popper/popper.js
2019-11-28 06:57:49,798 [Thread-0] INFO  Gauge  - Found URL: http://localhost/web/reset_password?redirect=http%3A%2F%2Flocalhost%2Fmy
2019-11-28 06:57:49,798 [Thread-0] INFO  Gauge  - Spider Odoo done.....
 ✔2019-11-28 06:57:49,995 [Thread-0] INFO  Gauge  - Set Alert and Attack Strength
 ✔2019-11-28 06:57:49,999 [Thread-0] INFO  Gauge  - Set Enable Passive Scanner
 ✔2019-11-28 06:57:50,000 [Thread-0] INFO  Gauge  - Scanning...http://localhost/web/database/manager
2019-11-28 06:57:50,017 [Thread-0] INFO  Gauge  - Scan is 13% complete.
2019-11-28 06:57:51,023 [Thread-0] INFO  Gauge  - Scan is 13% complete.
2019-11-28 06:57:52,030 [Thread-0] INFO  Gauge  - Scan is 100% complete.
2019-11-28 06:57:53,034 [Thread-0] INFO  Gauge  - Scanning done.
 ✔2019-11-28 06:57:53,058 [Thread-0] INFO  Gauge  - Remove false positive
 ✔2019-11-28 06:57:53,106 [Thread-0] INFO  Gauge  - Generate HTML Report
 ✔

Successfully generated html-report to => /Users/oktaliem/OktaDocuments/Github/OWASPZAPOdooGauge/reports/html-report/index.html
Specifications: 1 executed      0 passed        1 failed        0 skipped
Scenarios:      3 executed      2 passed        1 failed        0 skipped

Total time taken: 1m51.694s
[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  01:57 min
[INFO] Finished at: 2019-11-28T06:57:53+08:00
[INFO] ------------------------------------------------------------------------
[ERROR] Failed to execute goal com.thoughtworks.gauge.maven:gauge-maven-plugin:1.3.0:execute (default-cli) on project owaspzapodoogauge: Gauge Specs execution failed -> [Help 1]
[ERROR] 
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR] 
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoFailureException


```

## TestNG Log

<details>
<summary>
CLICK ME
</summary>
<p>
 
```maven

[INFO] Scanning for projects...
[WARNING] 
[WARNING] Some problems were encountered while building the effective model for owaspzapodoogauge:owaspzapodoogauge:jar:1.0-SNAPSHOT
[WARNING] 'dependencies.dependency.systemPath' for net.continuumsecurity:zap-java-api:jar should not point at files within the project directory, ${project.basedir}/libs/proxy-2.4.2-SNAPSHOT.jar will be unresolvable by dependent projects @ line 73, column 25
[WARNING] 'dependencies.dependency.systemPath' for org.owasp:zaproxy-client-api:jar should not point at files within the project directory, ${project.basedir}/libs/zap-api-2.4-v6.jar will be unresolvable by dependent projects @ line 80, column 25
[WARNING] 'dependencies.dependency.systemPath' for edu.umass.cs.benchlab:harlib:jar should not point at files within the project directory, ${project.basedir}/libs/harlib-1.1.1.jar will be unresolvable by dependent projects @ line 87, column 25
[WARNING] 'dependencies.dependency.(groupId:artifactId:type:classifier)' must be unique: org.testng:testng:jar -> duplicate declaration of version 7.0.0 @ line 89, column 21
[WARNING] 'dependencies.dependency.(groupId:artifactId:type:classifier)' must be unique: com.thoughtworks.gauge:gauge-java:jar -> duplicate declaration of version 0.6.7 @ line 102, column 21
[WARNING] 
[WARNING] It is highly recommended to fix these problems because they threaten the stability of your build.
[WARNING] 
[WARNING] For this reason, future Maven versions might no longer support building such malformed projects.
[WARNING] 
[INFO] 
[INFO] ----------------< owaspzapodoogauge:owaspzapodoogauge >-----------------
[INFO] Building owaspzapodoogauge 1.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ owaspzapodoogauge ---
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ owaspzapodoogauge ---
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] skip non existing resourceDirectory /Users/oktaliem/OktaDocuments/Github/OWASPZAPOdooGauge/src/main/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.8.1:compile (default-compile) @ owaspzapodoogauge ---
[INFO] Changes detected - recompiling the module!
[WARNING] File encoding has not been set, using platform encoding UTF-8, i.e. build is platform dependent!
[INFO] Compiling 1 source file to /Users/oktaliem/OktaDocuments/Github/OWASPZAPOdooGauge/target/classes
[INFO] /Users/oktaliem/OktaDocuments/Github/OWASPZAPOdooGauge/src/main/java/net/oktaliem/web/drivers/DriverFactory.java: /Users/oktaliem/OktaDocuments/Github/OWASPZAPOdooGauge/src/main/java/net/oktaliem/web/drivers/DriverFactory.java uses or overrides a deprecated API.
[INFO] /Users/oktaliem/OktaDocuments/Github/OWASPZAPOdooGauge/src/main/java/net/oktaliem/web/drivers/DriverFactory.java: Recompile with -Xlint:deprecation for details.
[INFO] 
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ owaspzapodoogauge ---
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] Copying 1 resource
[INFO] 
[INFO] --- maven-compiler-plugin:3.8.1:testCompile (default-testCompile) @ owaspzapodoogauge ---
[INFO] Changes detected - recompiling the module!
[WARNING] File encoding has not been set, using platform encoding UTF-8, i.e. build is platform dependent!
[INFO] Compiling 13 source files to /Users/oktaliem/OktaDocuments/Github/OWASPZAPOdooGauge/target/test-classes
[INFO] /Users/oktaliem/OktaDocuments/Github/OWASPZAPOdooGauge/src/test/java/net/oktaliem/gaugetest/PageActions.java: Some input files use or override a deprecated API.
[INFO] /Users/oktaliem/OktaDocuments/Github/OWASPZAPOdooGauge/src/test/java/net/oktaliem/gaugetest/PageActions.java: Recompile with -Xlint:deprecation for details.
[INFO] /Users/oktaliem/OktaDocuments/Github/OWASPZAPOdooGauge/src/test/java/net/oktaliem/gaugetest/PageActions.java: Some input files use unchecked or unsafe operations.
[INFO] /Users/oktaliem/OktaDocuments/Github/OWASPZAPOdooGauge/src/test/java/net/oktaliem/gaugetest/PageActions.java: Recompile with -Xlint:unchecked for details.
[INFO] 
[INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ owaspzapodoogauge ---
[INFO] Surefire report directory: /Users/oktaliem/OktaDocuments/Github/OWASPZAPOdooGauge/target/surefire-reports

-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running TestSuite
Configuring TestNG with: org.apache.maven.surefire.testng.conf.TestNG652Configurator@4f063c0a
2019-11-28 06:52:20,643 [main] INFO  net.oktaliem.OdooScanTest  - Created client to ZAP API
Nov 28, 2019 6:52:20 AM org.openqa.selenium.remote.DesiredCapabilities chrome
INFO: Using `new ChromeOptions()` is preferred to `DesiredCapabilities.chrome()`
Starting ChromeDriver 78.0.3904.70 (edb9c9f3de0247fd912a77b7f6cae7447f6d3ad5-refs/branch-heads/3904@{#800}) on port 14497
Only local connections are allowed.
Please protect ports used by ChromeDriver and related test frameworks to prevent access by malicious code.
Nov 28, 2019 6:52:23 AM org.openqa.selenium.remote.ProtocolHandshake createSession
INFO: Detected dialect: W3C
2019-11-28 06:52:24,250 [main] INFO  net.oktaliem.OdooScanTest  - Spidering Odoo...http://localhost/web/login/
2019-11-28 06:52:28,333 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/sitemap.xml
2019-11-28 06:52:28,333 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/
2019-11-28 06:52:28,333 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web/static/lib/bootstrap/css/bootstrap.css
2019-11-28 06:52:28,333 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web/static/lib/bootstrap/js/collapse.js
2019-11-28 06:52:28,334 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web/signup
2019-11-28 06:52:28,334 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/logo.png?company=1
2019-11-28 06:52:28,334 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web/static/src/img/logo2.png
2019-11-28 06:52:28,334 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web/static/lib/bootstrap/js/scrollspy.js
2019-11-28 06:52:28,334 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web/static/lib/bootstrap/js/modal.js
2019-11-28 06:52:28,334 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web/static/lib/bootstrap/js/popover.js
2019-11-28 06:52:28,334 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web/static/lib/bootstrap/js/alert.js
2019-11-28 06:52:28,334 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web/static/lib/bootstrap/js/tooltip.js
2019-11-28 06:52:28,334 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web/static/lib/bootstrap/js/index.js
2019-11-28 06:52:28,335 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web/static/lib/jquery/jquery.js
2019-11-28 06:52:28,335 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web/static/lib/bootstrap/js/carousel.js
2019-11-28 06:52:28,335 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web/static/lib/bootstrap/js/tab.js
2019-11-28 06:52:28,335 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/robots.txt
2019-11-28 06:52:28,335 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web
2019-11-28 06:52:28,335 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web/signup?redirect=http%3A%2F%2Flocalhost%2Fmy
2019-11-28 06:52:28,335 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web/content/425-bd52e6b/web.assets_frontend_minimal_js.js
2019-11-28 06:52:28,335 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web/login/
2019-11-28 06:52:28,335 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web/binary/company_logo
2019-11-28 06:52:28,336 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web/static/lib/fontawesome/css/font-awesome.css
2019-11-28 06:52:28,336 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web/reset_password
2019-11-28 06:52:28,336 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web/database/manager
2019-11-28 06:52:28,336 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web/content/664-fa3905a/web.assets_frontend.css
2019-11-28 06:52:28,336 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web/login
2019-11-28 06:52:28,336 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web/static/src/img/odoo_logo_tiny.png
2019-11-28 06:52:28,337 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web/static/lib/bootstrap/js/dropdown.js
2019-11-28 06:52:28,337 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web/static/src/img/favicon.ico
2019-11-28 06:52:28,337 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web/static/lib/bootstrap/js/util.js
2019-11-28 06:52:28,337 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web/content/424-d600052/web.assets_common_minimal_js.js
2019-11-28 06:52:28,337 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web?db=bitnami_odoo
2019-11-28 06:52:28,337 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web/content/654-4cce8d0/web.assets_common.css
2019-11-28 06:52:28,338 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/my
2019-11-28 06:52:28,338 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web/static/lib/bootstrap/js/button.js
2019-11-28 06:52:28,338 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web/login?redirect=http%3A%2F%2Flocalhost%2Fmy
2019-11-28 06:52:28,338 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web/static/lib/popper/popper.js
2019-11-28 06:52:28,338 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web/reset_password?redirect=http%3A%2F%2Flocalhost%2Fmy
2019-11-28 06:52:28,340 [main] INFO  net.oktaliem.OdooScanTest  - Spider Odoo done.....
2019-11-28 06:52:28,563 [main] INFO  net.oktaliem.OdooScanTest  - Scanning...http://localhost/web/login/
2019-11-28 06:52:28,595 [main] INFO  net.oktaliem.OdooScanTest  - Scan is 13% complete.
2019-11-28 06:52:29,604 [main] INFO  net.oktaliem.OdooScanTest  - Scan is 13% complete.
2019-11-28 06:52:30,615 [main] INFO  net.oktaliem.OdooScanTest  - Scan is 100% complete.
2019-11-28 06:52:31,616 [main] INFO  net.oktaliem.OdooScanTest  - Scanning done.
2019-11-28 06:52:31,709 [main] INFO  net.oktaliem.OdooScanTest  - HTML report is created
2019-11-28 06:52:32,288 [main] INFO  net.oktaliem.OdooScanTest  - Created client to ZAP API
Nov 28, 2019 6:52:32 AM org.openqa.selenium.remote.DesiredCapabilities chrome
INFO: Using `new ChromeOptions()` is preferred to `DesiredCapabilities.chrome()`
Starting ChromeDriver 78.0.3904.70 (edb9c9f3de0247fd912a77b7f6cae7447f6d3ad5-refs/branch-heads/3904@{#800}) on port 23482
Only local connections are allowed.
Please protect ports used by ChromeDriver and related test frameworks to prevent access by malicious code.
Nov 28, 2019 6:52:33 AM org.openqa.selenium.remote.ProtocolHandshake createSession
INFO: Detected dialect: W3C
2019-11-28 06:52:34,195 [main] INFO  net.oktaliem.OdooScanTest  - Spidering Odoo...http://localhost/web/database/manager
2019-11-28 06:52:37,284 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/sitemap.xml
2019-11-28 06:52:37,285 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web/static/lib/bootstrap/css/bootstrap.css
2019-11-28 06:52:37,285 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/
2019-11-28 06:52:37,286 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web/static/lib/bootstrap/js/collapse.js
2019-11-28 06:52:37,286 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/logo.png?company=1
2019-11-28 06:52:37,286 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web/signup
2019-11-28 06:52:37,286 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web/static/src/img/logo2.png
2019-11-28 06:52:37,286 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web/static/lib/bootstrap/js/scrollspy.js
2019-11-28 06:52:37,287 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web/static/lib/bootstrap/js/modal.js
2019-11-28 06:52:37,287 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web/static/lib/bootstrap/js/popover.js
2019-11-28 06:52:37,288 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web/static/lib/bootstrap/js/alert.js
2019-11-28 06:52:37,288 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web/static/lib/bootstrap/js/tooltip.js
2019-11-28 06:52:37,288 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web/static/lib/bootstrap/js/index.js
2019-11-28 06:52:37,289 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web/static/lib/jquery/jquery.js
2019-11-28 06:52:37,289 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web/static/lib/bootstrap/js/carousel.js
2019-11-28 06:52:37,289 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web/static/lib/bootstrap/js/tab.js
2019-11-28 06:52:37,289 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/robots.txt
2019-11-28 06:52:37,289 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web
2019-11-28 06:52:37,289 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web/signup?redirect=http%3A%2F%2Flocalhost%2Fmy
2019-11-28 06:52:37,289 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web/content/425-bd52e6b/web.assets_frontend_minimal_js.js
2019-11-28 06:52:37,289 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web/binary/company_logo
2019-11-28 06:52:37,290 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web/static/lib/fontawesome/css/font-awesome.css
2019-11-28 06:52:37,290 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web/database/manager
2019-11-28 06:52:37,290 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web/reset_password
2019-11-28 06:52:37,290 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web/login
2019-11-28 06:52:37,290 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web/content/664-fa3905a/web.assets_frontend.css
2019-11-28 06:52:37,290 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web/static/lib/bootstrap/js/dropdown.js
2019-11-28 06:52:37,290 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web/static/src/img/odoo_logo_tiny.png
2019-11-28 06:52:37,290 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web/static/src/img/favicon.ico
2019-11-28 06:52:37,290 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web/static/lib/bootstrap/js/util.js
2019-11-28 06:52:37,291 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web/content/424-d600052/web.assets_common_minimal_js.js
2019-11-28 06:52:37,291 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web?db=bitnami_odoo
2019-11-28 06:52:37,291 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/my
2019-11-28 06:52:37,291 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web/content/654-4cce8d0/web.assets_common.css
2019-11-28 06:52:37,291 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web/static/lib/bootstrap/js/button.js
2019-11-28 06:52:37,291 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web/login?redirect=http%3A%2F%2Flocalhost%2Fmy
2019-11-28 06:52:37,291 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web/static/lib/popper/popper.js
2019-11-28 06:52:37,291 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web/reset_password?redirect=http%3A%2F%2Flocalhost%2Fmy
2019-11-28 06:52:37,291 [main] INFO  net.oktaliem.OdooScanTest  - Spider Odoo done.....
2019-11-28 06:52:37,624 [main] INFO  net.oktaliem.OdooScanTest  - Scanning...http://localhost/web/database/manager
2019-11-28 06:52:37,667 [main] INFO  net.oktaliem.OdooScanTest  - Scan is 13% complete.
2019-11-28 06:52:38,672 [main] INFO  net.oktaliem.OdooScanTest  - Scan is 13% complete.
2019-11-28 06:52:39,678 [main] INFO  net.oktaliem.OdooScanTest  - Scan is 100% complete.
2019-11-28 06:52:40,680 [main] INFO  net.oktaliem.OdooScanTest  - Scanning done.
2019-11-28 06:52:40,764 [main] INFO  net.oktaliem.OdooScanTest  - HTML report is created
2019-11-28 06:52:41,308 [main] INFO  net.oktaliem.OdooScanTest  - Created client to ZAP API
Nov 28, 2019 6:52:41 AM org.openqa.selenium.remote.DesiredCapabilities chrome
INFO: Using `new ChromeOptions()` is preferred to `DesiredCapabilities.chrome()`
Starting ChromeDriver 78.0.3904.70 (edb9c9f3de0247fd912a77b7f6cae7447f6d3ad5-refs/branch-heads/3904@{#800}) on port 2197
Only local connections are allowed.
Please protect ports used by ChromeDriver and related test frameworks to prevent access by malicious code.
Nov 28, 2019 6:52:42 AM org.openqa.selenium.remote.ProtocolHandshake createSession
INFO: Detected dialect: W3C
2019-11-28 06:52:49,414 [main] INFO  net.oktaliem.OdooScanTest  - User has landing to: http://localhost/web/login/
2019-11-28 06:52:49,414 [main] INFO  net.oktaliem.OdooScanTest  - Spidering Odoo...http://localhost/web#action=100&active_id=mailbox_inbox&cids=1&menu_id=79
2019-11-28 06:52:52,474 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/sitemap.xml
2019-11-28 06:52:52,474 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/
2019-11-28 06:52:52,474 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web/static/lib/bootstrap/css/bootstrap.css
2019-11-28 06:52:52,474 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web/static/lib/bootstrap/js/collapse.js
2019-11-28 06:52:52,474 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/logo.png?company=1
2019-11-28 06:52:52,474 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web/signup
2019-11-28 06:52:52,474 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web/static/src/img/logo2.png
2019-11-28 06:52:52,474 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web/static/lib/bootstrap/js/scrollspy.js
2019-11-28 06:52:52,475 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web/static/lib/bootstrap/js/modal.js
2019-11-28 06:52:52,475 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web/static/lib/bootstrap/js/popover.js
2019-11-28 06:52:52,475 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web/static/lib/bootstrap/js/alert.js
2019-11-28 06:52:52,475 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web/static/lib/bootstrap/js/tooltip.js
2019-11-28 06:52:52,475 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web/static/lib/bootstrap/js/index.js
2019-11-28 06:52:52,475 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web/static/lib/jquery/jquery.js
2019-11-28 06:52:52,475 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web/static/lib/bootstrap/js/carousel.js
2019-11-28 06:52:52,475 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web/static/lib/bootstrap/js/tab.js
2019-11-28 06:52:52,475 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/robots.txt
2019-11-28 06:52:52,475 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web
2019-11-28 06:52:52,475 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web/signup?redirect=http%3A%2F%2Flocalhost%2Fmy
2019-11-28 06:52:52,475 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web/content/425-bd52e6b/web.assets_frontend_minimal_js.js
2019-11-28 06:52:52,475 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web/binary/company_logo
2019-11-28 06:52:52,475 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web/static/lib/fontawesome/css/font-awesome.css
2019-11-28 06:52:52,475 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web/reset_password
2019-11-28 06:52:52,475 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web/database/manager
2019-11-28 06:52:52,475 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web/login
2019-11-28 06:52:52,475 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web/content/664-fa3905a/web.assets_frontend.css
2019-11-28 06:52:52,476 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web/static/src/img/odoo_logo_tiny.png
2019-11-28 06:52:52,476 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web/static/lib/bootstrap/js/dropdown.js
2019-11-28 06:52:52,476 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web/static/src/img/favicon.ico
2019-11-28 06:52:52,476 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web/static/lib/bootstrap/js/util.js
2019-11-28 06:52:52,476 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web/content/424-d600052/web.assets_common_minimal_js.js
2019-11-28 06:52:52,476 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web?db=bitnami_odoo
2019-11-28 06:52:52,476 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/my
2019-11-28 06:52:52,476 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web/content/654-4cce8d0/web.assets_common.css
2019-11-28 06:52:52,476 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web/login?redirect=http%3A%2F%2Flocalhost%2Fmy
2019-11-28 06:52:52,476 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web/static/lib/bootstrap/js/button.js
2019-11-28 06:52:52,476 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web/reset_password?redirect=http%3A%2F%2Flocalhost%2Fmy
2019-11-28 06:52:52,476 [main] INFO  net.oktaliem.OdooScanTest  - Found URL: http://localhost/web/static/lib/popper/popper.js
2019-11-28 06:52:52,476 [main] INFO  net.oktaliem.OdooScanTest  - Spider Odoo done.....
2019-11-28 06:52:52,728 [main] INFO  net.oktaliem.OdooScanTest  - Scanning...http://localhost/web#action=100&active_id=mailbox_inbox&cids=1&menu_id=79
2019-11-28 06:52:52,751 [main] INFO  net.oktaliem.OdooScanTest  - Scan is 0% complete.
2019-11-28 06:52:53,758 [main] INFO  net.oktaliem.OdooScanTest  - Scan is 2% complete.
2019-11-28 06:52:54,766 [main] INFO  net.oktaliem.OdooScanTest  - Scan is 2% complete.
2019-11-28 06:52:55,773 [main] INFO  net.oktaliem.OdooScanTest  - Scan is 2% complete.
2019-11-28 06:52:56,782 [main] INFO  net.oktaliem.OdooScanTest  - Scan is 2% complete.
2019-11-28 06:52:57,788 [main] INFO  net.oktaliem.OdooScanTest  - Scan is 2% complete.
2019-11-28 06:52:58,799 [main] INFO  net.oktaliem.OdooScanTest  - Scan is 3% complete.
2019-11-28 06:52:59,822 [main] INFO  net.oktaliem.OdooScanTest  - Scan is 4% complete.
2019-11-28 06:53:00,827 [main] INFO  net.oktaliem.OdooScanTest  - Scan is 7% complete.
2019-11-28 06:53:01,839 [main] INFO  net.oktaliem.OdooScanTest  - Scan is 7% complete.
2019-11-28 06:53:02,859 [main] INFO  net.oktaliem.OdooScanTest  - Scan is 7% complete.
2019-11-28 06:53:03,863 [main] INFO  net.oktaliem.OdooScanTest  - Scan is 7% complete.
2019-11-28 06:53:04,871 [main] INFO  net.oktaliem.OdooScanTest  - Scan is 8% complete.
2019-11-28 06:53:05,878 [main] INFO  net.oktaliem.OdooScanTest  - Scan is 10% complete.
2019-11-28 06:53:06,888 [main] INFO  net.oktaliem.OdooScanTest  - Scan is 11% complete.
2019-11-28 06:53:07,895 [main] INFO  net.oktaliem.OdooScanTest  - Scan is 18% complete.
2019-11-28 06:53:08,902 [main] INFO  net.oktaliem.OdooScanTest  - Scan is 18% complete.
2019-11-28 06:53:09,908 [main] INFO  net.oktaliem.OdooScanTest  - Scan is 21% complete.
2019-11-28 06:53:10,913 [main] INFO  net.oktaliem.OdooScanTest  - Scan is 24% complete.
2019-11-28 06:53:11,919 [main] INFO  net.oktaliem.OdooScanTest  - Scan is 24% complete.
2019-11-28 06:53:12,927 [main] INFO  net.oktaliem.OdooScanTest  - Scan is 26% complete.
2019-11-28 06:53:13,937 [main] INFO  net.oktaliem.OdooScanTest  - Scan is 29% complete.
2019-11-28 06:53:14,943 [main] INFO  net.oktaliem.OdooScanTest  - Scan is 30% complete.
2019-11-28 06:53:15,953 [main] INFO  net.oktaliem.OdooScanTest  - Scan is 33% complete.
2019-11-28 06:53:16,960 [main] INFO  net.oktaliem.OdooScanTest  - Scan is 34% complete.
2019-11-28 06:53:17,972 [main] INFO  net.oktaliem.OdooScanTest  - Scan is 35% complete.
2019-11-28 06:53:18,978 [main] INFO  net.oktaliem.OdooScanTest  - Scan is 37% complete.
2019-11-28 06:53:19,986 [main] INFO  net.oktaliem.OdooScanTest  - Scan is 38% complete.
2019-11-28 06:53:20,996 [main] INFO  net.oktaliem.OdooScanTest  - Scan is 39% complete.
2019-11-28 06:53:22,003 [main] INFO  net.oktaliem.OdooScanTest  - Scan is 43% complete.
2019-11-28 06:53:23,012 [main] INFO  net.oktaliem.OdooScanTest  - Scan is 46% complete.
2019-11-28 06:53:24,021 [main] INFO  net.oktaliem.OdooScanTest  - Scan is 46% complete.
2019-11-28 06:53:25,025 [main] INFO  net.oktaliem.OdooScanTest  - Scan is 46% complete.
2019-11-28 06:53:26,037 [main] INFO  net.oktaliem.OdooScanTest  - Scan is 46% complete.
2019-11-28 06:53:27,043 [main] INFO  net.oktaliem.OdooScanTest  - Scan is 46% complete.
2019-11-28 06:53:28,051 [main] INFO  net.oktaliem.OdooScanTest  - Scan is 46% complete.
2019-11-28 06:53:29,087 [main] INFO  net.oktaliem.OdooScanTest  - Scan is 46% complete.
2019-11-28 06:53:30,096 [main] INFO  net.oktaliem.OdooScanTest  - Scan is 46% complete.
2019-11-28 06:53:31,101 [main] INFO  net.oktaliem.OdooScanTest  - Scan is 49% complete.
2019-11-28 06:53:32,109 [main] INFO  net.oktaliem.OdooScanTest  - Scan is 52% complete.
2019-11-28 06:53:33,116 [main] INFO  net.oktaliem.OdooScanTest  - Scan is 52% complete.
2019-11-28 06:53:34,122 [main] INFO  net.oktaliem.OdooScanTest  - Scan is 52% complete.
2019-11-28 06:53:35,131 [main] INFO  net.oktaliem.OdooScanTest  - Scan is 52% complete.
2019-11-28 06:53:36,141 [main] INFO  net.oktaliem.OdooScanTest  - Scan is 56% complete.
2019-11-28 06:53:37,147 [main] INFO  net.oktaliem.OdooScanTest  - Scan is 57% complete.
2019-11-28 06:53:38,155 [main] INFO  net.oktaliem.OdooScanTest  - Scan is 57% complete.
2019-11-28 06:53:39,164 [main] INFO  net.oktaliem.OdooScanTest  - Scan is 57% complete.
2019-11-28 06:53:40,167 [main] INFO  net.oktaliem.OdooScanTest  - Scan is 57% complete.
2019-11-28 06:53:41,179 [main] INFO  net.oktaliem.OdooScanTest  - Scan is 57% complete.
2019-11-28 06:53:42,191 [main] INFO  net.oktaliem.OdooScanTest  - Scan is 57% complete.
2019-11-28 06:53:43,200 [main] INFO  net.oktaliem.OdooScanTest  - Scan is 57% complete.
2019-11-28 06:53:44,208 [main] INFO  net.oktaliem.OdooScanTest  - Scan is 57% complete.
2019-11-28 06:53:45,218 [main] INFO  net.oktaliem.OdooScanTest  - Scan is 57% complete.
2019-11-28 06:53:46,227 [main] INFO  net.oktaliem.OdooScanTest  - Scan is 57% complete.
2019-11-28 06:53:47,240 [main] INFO  net.oktaliem.OdooScanTest  - Scan is 57% complete.
2019-11-28 06:53:48,245 [main] INFO  net.oktaliem.OdooScanTest  - Scan is 58% complete.
2019-11-28 06:53:49,263 [main] INFO  net.oktaliem.OdooScanTest  - Scan is 58% complete.
2019-11-28 06:53:50,272 [main] INFO  net.oktaliem.OdooScanTest  - Scan is 59% complete.
2019-11-28 06:53:51,283 [main] INFO  net.oktaliem.OdooScanTest  - Scan is 60% complete.
2019-11-28 06:53:52,292 [main] INFO  net.oktaliem.OdooScanTest  - Scan is 60% complete.
2019-11-28 06:53:53,297 [main] INFO  net.oktaliem.OdooScanTest  - Scan is 61% complete.
2019-11-28 06:53:54,303 [main] INFO  net.oktaliem.OdooScanTest  - Scan is 61% complete.
2019-11-28 06:53:55,313 [main] INFO  net.oktaliem.OdooScanTest  - Scan is 62% complete.
2019-11-28 06:53:56,318 [main] INFO  net.oktaliem.OdooScanTest  - Scan is 63% complete.
2019-11-28 06:53:57,327 [main] INFO  net.oktaliem.OdooScanTest  - Scan is 63% complete.
2019-11-28 06:53:58,331 [main] INFO  net.oktaliem.OdooScanTest  - Scan is 64% complete.
2019-11-28 06:53:59,342 [main] INFO  net.oktaliem.OdooScanTest  - Scan is 65% complete.
2019-11-28 06:54:00,353 [main] INFO  net.oktaliem.OdooScanTest  - Scan is 67% complete.
2019-11-28 06:54:01,359 [main] INFO  net.oktaliem.OdooScanTest  - Scan is 68% complete.
2019-11-28 06:54:02,365 [main] INFO  net.oktaliem.OdooScanTest  - Scan is 68% complete.
2019-11-28 06:54:03,372 [main] INFO  net.oktaliem.OdooScanTest  - Scan is 68% complete.
2019-11-28 06:54:04,377 [main] INFO  net.oktaliem.OdooScanTest  - Scan is 72% complete.
2019-11-28 06:54:05,381 [main] INFO  net.oktaliem.OdooScanTest  - Scan is 74% complete.
2019-11-28 06:54:06,390 [main] INFO  net.oktaliem.OdooScanTest  - Scan is 78% complete.
2019-11-28 06:54:07,397 [main] INFO  net.oktaliem.OdooScanTest  - Scan is 80% complete.
2019-11-28 06:54:08,402 [main] INFO  net.oktaliem.OdooScanTest  - Scan is 83% complete.
2019-11-28 06:54:09,406 [main] INFO  net.oktaliem.OdooScanTest  - Scan is 85% complete.
2019-11-28 06:54:10,416 [main] INFO  net.oktaliem.OdooScanTest  - Scan is 85% complete.
2019-11-28 06:54:11,421 [main] INFO  net.oktaliem.OdooScanTest  - Scan is 88% complete.
2019-11-28 06:54:12,429 [main] INFO  net.oktaliem.OdooScanTest  - Scan is 90% complete.
2019-11-28 06:54:13,436 [main] INFO  net.oktaliem.OdooScanTest  - Scan is 91% complete.
2019-11-28 06:54:14,441 [main] INFO  net.oktaliem.OdooScanTest  - Scan is 100% complete.
2019-11-28 06:54:15,442 [main] INFO  net.oktaliem.OdooScanTest  - Scanning done.
2019-11-28 06:54:15,463 [main] INFO  net.oktaliem.OdooScanTest  - Alert: SQL Injection at URL: http://localhost/web/reset_password?redirect=http%3A%2F%2Flocalhost%2Fmy%27+AND+%271%27%3D%271%27+--+ Parameter: redirect CWE ID: 89
2019-11-28 06:54:15,464 [main] INFO  net.oktaliem.OdooScanTest  - Alert: SQL Injection at URL: http://localhost/web/login?redirect=http%3A%2F%2Flocalhost%2Fmy+ASC++--+ Parameter: redirect CWE ID: 89
2019-11-28 06:54:15,464 [main] INFO  net.oktaliem.OdooScanTest  - Alert: SQL Injection at URL: http://localhost/web/signup?redirect=http%3A%2F%2Flocalhost%2Fmy+AND+1%3D1+--+ Parameter: redirect CWE ID: 89
/Users/oktaliem/OktaDocuments/Github/OWASPZAPOdooGauge/drivers/chromedriver-mac
Starting ChromeDriver 78.0.3904.70 (edb9c9f3de0247fd912a77b7f6cae7447f6d3ad5-refs/branch-heads/3904@{#800}) on port 27732
Only local connections are allowed.
Please protect ports used by ChromeDriver and related test frameworks to prevent access by malicious code.
Nov 28, 2019 6:54:17 AM org.openqa.selenium.remote.ProtocolHandshake createSession
INFO: Detected dialect: W3C
2019-11-28 06:54:18,094 [main] INFO  Library Test  - Landing to Login Page: http://localhost/web/login/
2019-11-28 06:54:18,267 [main] INFO  Library Test  - User inputs field with element: [[ChromeDriver: chrome on MAC (d101da20e01f06a6125719ae7fb60589)] -> id: login] and value test
2019-11-28 06:54:18,573 [main] INFO  Library Test  - User inputs field with element: [[ChromeDriver: chrome on MAC (d101da20e01f06a6125719ae7fb60589)] -> id: password] and value test
2019-11-28 06:54:18,922 [main] INFO  Library Test  - User clicks On Element: [[ChromeDriver: chrome on MAC (d101da20e01f06a6125719ae7fb60589)] -> class name: btn-primary]
/Users/oktaliem/OktaDocuments/Github/OWASPZAPOdooGauge/drivers/chromedriver-mac
Starting ChromeDriver 78.0.3904.70 (edb9c9f3de0247fd912a77b7f6cae7447f6d3ad5-refs/branch-heads/3904@{#800}) on port 6132
Only local connections are allowed.
Please protect ports used by ChromeDriver and related test frameworks to prevent access by malicious code.
Nov 28, 2019 6:54:20 AM org.openqa.selenium.remote.ProtocolHandshake createSession
INFO: Detected dialect: W3C
2019-11-28 06:54:21,089 [main] INFO  Library Test  - Landing to Login Page: http://localhost/web/login/
2019-11-28 06:54:21,259 [main] INFO  Library Test  - User inputs field with element: By.id: login and value test
2019-11-28 06:54:21,545 [main] INFO  Library Test  - User inputs field with element: By.id: password and value test
2019-11-28 06:54:26,549 [main] INFO  Library Test  - User waits for 5000 milliseconds
2019-11-28 06:54:26,762 [main] INFO  Library Test  - User clicks On Element: By.className: btn-primary
/Users/oktaliem/OktaDocuments/Github/OWASPZAPOdooGauge/drivers/chromedriver-mac
Starting ChromeDriver 78.0.3904.70 (edb9c9f3de0247fd912a77b7f6cae7447f6d3ad5-refs/branch-heads/3904@{#800}) on port 36894
Only local connections are allowed.
Please protect ports used by ChromeDriver and related test frameworks to prevent access by malicious code.
Nov 28, 2019 6:54:28 AM org.openqa.selenium.remote.ProtocolHandshake createSession
INFO: Detected dialect: W3C
2019-11-28 06:54:28,716 [main] INFO  Library Test  - Landing to Login Page: http://localhost/web/login/
/Users/oktaliem/OktaDocuments/Github/OWASPZAPOdooGauge/drivers/chromedriver-mac
Starting ChromeDriver 78.0.3904.70 (edb9c9f3de0247fd912a77b7f6cae7447f6d3ad5-refs/branch-heads/3904@{#800}) on port 11785
Only local connections are allowed.
Please protect ports used by ChromeDriver and related test frameworks to prevent access by malicious code.
Nov 28, 2019 6:54:30 AM org.openqa.selenium.remote.ProtocolHandshake createSession
INFO: Detected dialect: W3C
2019-11-28 06:54:30,724 [main] INFO  Library Test  - Landing to Login Page: http://localhost/web/login/
2019-11-28 06:54:30,781 [main] INFO  Library Test  - Open New Tab
2019-11-28 06:54:30,803 [main] INFO  Library Test  - Go to second tab
2019-11-28 06:54:33,803 [main] INFO  Library Test  - User waits for 3000 milliseconds
2019-11-28 06:54:33,827 [main] INFO  Library Test  - Go to first tab
2019-11-28 06:54:35,831 [main] INFO  Library Test  - User waits for 2000 milliseconds
Tests run: 7, Failures: 1, Errors: 0, Skipped: 0, Time elapsed: 136.43 sec <<< FAILURE!
tc03_odooSecurityPassiveScanAfterLogin(net.oktaliem.OdooScanTest)  Time elapsed: 92.87 sec  <<< FAILURE!
java.lang.AssertionError: 
Expected: <0>
     but: was <3>
        at org.hamcrest.MatcherAssert.assertThat(MatcherAssert.java:20)
        at org.hamcrest.MatcherAssert.assertThat(MatcherAssert.java:8)
        at net.oktaliem.ZapScannerBase.removeFalsePositive(ZapScannerBase.java:246)
        at net.oktaliem.OdooScanTest.tc03_odooSecurityPassiveScanAfterLogin(OdooScanTest.java:42)


Results :

Failed tests:   tc03_odooSecurityPassiveScanAfterLogin(net.oktaliem.OdooScanTest): (..)

Tests run: 7, Failures: 1, Errors: 0, Skipped: 0

[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  02:20 min
[INFO] Finished at: 2019-11-28T06:54:36+08:00
[INFO] ------------------------------------------------------------------------
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-surefire-plugin:2.12.4:test (default-test) on project owaspzapodoogauge: There are test failures.
[ERROR] 
[ERROR] Please refer to /Users/oktaliem/OktaDocuments/Github/OWASPZAPOdooGauge/target/surefire-reports for the individual test results.
[ERROR] -> [Help 1]
[ERROR] 
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR] 
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoFailureException

```


