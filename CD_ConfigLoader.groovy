/**
 * Created by indira.nutakki on 1/26/2016.
 */
class CD_ConfigLoader {

    String artifactoryURL;
    String artifactoryPublishUser  ;
    String artifactoryPublishPassword;
    String releaseNumber;



  /*  def getArtifactoryURL(){
        return  this.artifactoryURL;

    }

    def getArtifactoryPublishUser(){
        return  this.artifactoryPublishUser;

    }

    def getArtifactoryPublishPassword(){
        return this.artifactoryPublishPassword;
    }
    def getArtifactoryreleaseNumber(){
        return this.releaseNumber;
    }*/

    def readConfigProperties() {
        def fileName = "PipeLineConfig.properties"
        String file = new File(fileName).getText();
        def lines = file.readLines();
       // println(lines[0])
        for (item in lines) {
           // println item;

            List<String> params = item.split("=");
            String name = params[0].toString().trim();
            String value = params[1].toString().trim();
            switch (name) {
                case 'artifactoryURL':
                    this.artifactoryURL = value;

                case 'artifactoryPublishUser':
                    this.artifactoryPublishUser = value;

                case 'artifactoryPublishPassword':
                    this.artifactoryPublishPassword = value;
                case 'releaseNumber':
                    this.releaseNumber = value;
            }
        }
        return this;

    }

    def buildStep(){
        readConfigProperties();
        StringBuilder sb = new StringBuilder();
        String mvnGoal = "clean deploy";
        String settingsFilePath = "/opt/apps/users/app/.m2/artifactory_settings.xml"

        sb.append("sh \"{mvnHome}/bin/mvn -X " + mvnGoal +
                    " -Pci -s "+settingsFilePath+
                    " -DartifactoryURL=" + this.artifactoryURL +
                    " -DartifactoryPublishUser=" + this.artifactoryPublishUser +
                    " -DartifactoryPublishPassword="+ this.artifactoryPublishPassword +
                    " -DreleaseNumber=" + this.releaseNumber + "\"");

        return sb.toString();


    }


}
