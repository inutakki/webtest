artifactoryURL="http://jsahfjasdhfk.com/inutakki"
artifactoryPublishUser="asdf"
artifactoryPublishPassword="sdj"
settingsFilePath="jskfjslafk.xml"
releaseNumber="2016.02.0"
String[] s=["ci", "release"] as String[];

def getArr(){
  return s;
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
