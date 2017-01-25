node ('Linux && Buildsystem') {

   stage 'prepare environment'
   
   def WORK=pwd();
   
   def mvnHome = tool 'MAVEN_3.2.1'
   def javaHome = tool 'JDK8u77'
      
   stage 'checkout scm'
   checkout scm
   
   stage 'deploy a Maven project'
   withEnv(["JAVA_HOME=${javaHome}","PATH+MAVEN=${mvnHome}/bin","PATH+JAVA=${javaHome}/bin"]) {
      sh returnStatus: true, script: "mvn clean deploy"
   }

   step([$class: 'ArtifactArchiver', artifacts: '**/target/*.jar', fingerprint: true])
   //step([$class: 'JUnitResultArchiver', testResults: '**/target/surefire-reports/TEST-*.xml'])
   
}
