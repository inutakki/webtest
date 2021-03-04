@Library('Pipeline-shared-library') _
pipeline {
agent none
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
	     def buildCause = currentBuild.getBuildCauses()[0].shortDescription
             echo "Current build was caused by: ${buildCause}\n"

	    //currentBuild.rawBuild.get
	    def result =  apiValidator("./definitions/swagger.yaml") 
	    println("FinalResult: ${result}") 
           }
         }
      }
  }
}
