class CD_ConfigLoader {

    String artifactoryURL;
    String artifactoryUname  ;
    String artifactoryPassword;



    def getArtifactoryURL(){
        return  this.artifactoryURL;

    }

    def getArtifactoryUname(){
        return  this.artifactoryUname;

    }

    def getArtifactoryPassword(){
        return this.artifactoryPassword;
    }

    def createfromFile() {
        def fileName = "C:\\Users\\indira.nutakki\\.jenkins\\PipeLineConfig.txt"

        String file = new File(fileName).getText();
        def lines = file.readLines();
       // println(lines[0])
        def map = [:];
        for (item in lines) {
           // println item;

            List<String> params = item.split("=");
            String name = params[0].toString().trim();
            String value = params[1].toString().trim();
            switch (name) {
                case 'artifactoryURL':
                    this.artifactoryURL = value;

                case 'artifactoryUname':
                    this.artifactoryUname = value;

                case 'artifactoryPassword':
                    this.artifactoryPassword = value;
            }
        }

        return this;
    }
}
