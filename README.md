# DebugLog
Library for log message in debug

#Gradle:
compile 'com.github.vietnguyen312:debuglog:master-SNAPSHOT'


#Usage:

```java
AwesomeLog awesome = new AwesomeLog();
awesome.setText("this is pretty log");
Debug.log("awesome log", awesome);
```

-- result:

```java
FileName - ClassName - Method - AwesomeLog [
					    text = this is pretty log
					   ]
```
