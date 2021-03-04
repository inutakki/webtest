@Library('Pipeline-shared-library') _

import com.cloudbees.groovy.cps.NonCPS
pipeline {
agent none
	@NonCPS
		def getBuildtriggerCause(){
		startedByTimer = false
		def buildCauses = currentBuild.rawBuild.getCauses()
		for ( buildCause in buildCauses ) {
			if (buildCause != null) {
				def causeDescription = buildCause.getShortDescription()
				if (causeDescription.contains("Started by timer")) {
					startedByTimer = true
				}
			}
		}
		return causeDescription
	}
    environment {
        // Setting this to maven.  setEnv will not work without a build type
        // Using gitHubHost - no function in utils for the Git Hub Host
        buildType = "npm"
        gitHubHost = "github.org"
        branchName = "${BRANCH_NAME}"
        triggerJavaTest = false
        triggerNodeTest = false
    }

    stages {
      stage('Initialization') {
        agent {label 'unixNode'}
        steps {
		
        script{ 
		
	    def commitHash = sh (returnStdout: true, script: "git log -n 1 --pretty=format:'%H'")
            
            env.GIT_COMMIT_MSG = sh(returnStdout: true, script: "git log -1 --pretty=%B ${GIT_COMMIT}").trim()
            println("GitCommitMessage: ${env.GIT_COMMIT_MSG}")
	    println("displayname: ${currentBuild.displayName}")
	    //println("build cause trigger: ${BUILD_CAUSE}")
	    //println("build cause timer trigger: ${BUILD_CAUSE_TIMERTRIGGER}")
	    /*def buildCauses = currentBuild.rawBuild.getCauses()
	    for ( buildCause in buildCauses ) {
		if (buildCause != null) {
			def causeDescription = buildCause.getShortDescription()
			if (causeDescription.contains("Started by timer")) {
				startedByTimer = true
			}
			if(buildCause instanceof hudson.model.Cause$UserIdCause){
				println("triggered by User")
			}
			if(buildCause instanceof jenkins.branch.BranchIndexingCause){
				println("triggered by branch indexing")
			}
		}
	    }*/
	     //def buildCause = currentBuild.getBuildCauses()[0].shortDescription
	     def buildCause = currentBuild.getBuildCauses()[0]
             echo "Current build was caused by: ${buildCause}\n"
		echo "${getBuildtriggerCause()}"
	    //currentBuild.rawBuild.get
	    def result =  apiValidator("./definitions/swagger.yaml") 
	    println("FinalResult: ${result}") 
           }
         }
      }
  }
}
