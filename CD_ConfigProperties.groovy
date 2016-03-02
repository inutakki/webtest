artifactoryURL="http://jsahfjasdhfk.com/inutakki"
artifactoryPublishUser="asdf"
artifactoryPublishPassword="sdj"
settingsFilePath="jskfjslafk.xml"
releaseNumber="2016.02.0"
strArray = new String[2]
strArray[0]="ci"
strArray[1]="release"

def map=[ci:"ci", release:"release"]

def  getArr(){
  return(strArray);
}

def getMap(){
  return map;
}


def getURL(){
  return artifactoryURL;
}
def getPublishUser(){
  return artifactoryPublishUser;
}

def getPublishPassword(){
  return artifactoryPublishPassword;
}
def getSettingsFilePath(){
  return settingsFilePath;
}

def getReleaseNumber(){
  return releaseNumber;
}

return this;
