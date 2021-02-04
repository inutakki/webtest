@Library('Pipeline-shared-library') _
pipeline {
agent none
    environment {
        // Setting this to maven.  setEnv will not work without a build type
        // Using gitHubHost - no function in utils for the Git Hub Host
        buildType = "npm"
        gitHubHost = "github.kp.org"
        branchName = "${BRANCH_NAME}"
        triggerBmxJavaTest = false
        triggerBmxNodeTest = false
    }

    stages {
      stage('Initialization') {
        agent {label 'unixNode'}
        steps {
        script{ 
	 def testResult =  validator();
          print( "testResult: " + testResult);
	 // dir('DoDCheck'){
	     schemaValidatorTest()
	   sh "npm install";
    def value = sh(returnStdout: true, script: "node validatorTest.js");
	print("Executrion Test Result: ${value}")
        print("----Before executing js file")
	     sh(returnStdout: true, script: "node schemaValidator.js");
	   // }	

           }
         }
      }
  }
}
