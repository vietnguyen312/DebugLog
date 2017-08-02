# DebugLog
Library for log message in debug

Download
Gradle:
compile 'com.github.vietnguyen312:debuglog:master-SNAPSHOT'


Usage:

AwesomeLog awesome = new AwesomeLog();
awesome.setText("this is pretty log");
Debug.log("awesome log", awesome);

-- result:
FileName - ClassName - Method - AwesomeLog [
								text = this is pretty log
								]