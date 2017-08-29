#setup
1. Install java 8 as follows:
	$ sudo add-apt-repository ppa:webupd8team/java
	$ sudo apt-get update
	$ sudo apt-get install oracle-java8-installer

2. Download eclipse from here "http://www.eclipse.org/downloads/paexitckages/eclipse-ide-java-developers/marsr"

3. Add testng plug in eclipse 
   goto help>install new software
   enter url " http://beust.com/eclipse"
4. Install eclipse maven plugin m2e
	goto help>install new software
    enter url "http://download.eclipse.org/technology/m2e/releases"
5. Clone repository
	$git clone ssh://url
6. Import maven project in eclipse
7. Install xvfb and firefox
   $ sudo apt-get install Xvfb firefox

#GIT
git config --global user.name "Firstname Lastname"
git config --global user.email "username@cactusglobal.com"


if [ ! -d "~/.ssh" ]; then; mkdir ~/.ssh; fi
ssh-keygen -t rsa -C "username@domain.com" -N <passphrase> -f ~/.ssh/id_rsa
eval "$(ssh-agent -s)"
ssh-add ~/.ssh/id_rsa # Enter passphrase when prompted
xclip -sel clip < ~/.ssh/id_rsa.pub

#development

1. Update maven project
   right click on project > maven> update project
2. Add Page class in package ".selenium.pages"
3. Add TestNG tests in  package ".selenium.tests"

#Running tests

1. Start Selenium grid hub 
 	$java -jar selenium-server-standalone-2.53.1.jar -role hub -timeout 300000 &
 	$java -jar selenium-server-standalone-3.0.1.jar -role hub -timeout 300000 &
2. Register nodes to hub 
	$xvfb-run -a -s "-screen 0 1920x1020x24" java -jar selenium-server-standalone-2.53.1.jar -role node -nodeConfig node.json -Dwebdriver.ie.driver=.\IEDriverServer.exe -Dwebdriver.chrome.driver=./chromedriver &
	$xvfb-run -a -s "-screen 0 1920x1020x24" java -Dwebdriver.ie.driver=.\IEDriverServer.exe -Dwebdriver.chrome.driver=./chromedriver -Dwebdriver.firefox.marionette=.\geckodriver -jar selenium-server-standalone-3.0.0-beta4.jar -role node -nodeConfig node.json  &
	$xvfb-run -a -s "-screen 0 1920x1020x24" java -jar selenium-server-standalone-3.0.1.jar -role node -nodeConfig node_ver3.json  &
3. Run project as maven test
	$mvn clean install



