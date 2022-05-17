def call(tomcatIp,warName,credId){
    sshagent(["${credId}"]) {
        //copy war file to tomcat server
        sh "scp -o StrictHostKeyChecking=no target/*.war ec2-user@${tomcatIp}:/opt/tomcat8.webapps/${warName}.war"
        //stop tomcat
        sh "ssh ec2-user@${tomcatIp}8 /opt/tomcat8/bin/shutdown.sh"
        //start tomcat
        sh "ssh ec2-user@${tomcatIp} /opt/tomcat8/startup.sh"
    }
    }
