# DebugLog
Library for logging message in debug

# Download
-----------------------

Gradle:
```groovy
compile 'com.github.vietnguyen312:debuglog:master-SNAPSHOT'
```


#Usage:

```java
	AwesomeLog awesome = new AwesomeLog();
	awesome.setText("this is pretty log");
	Debug.log("optional message", awesome);
```


#**Result:**

```java
	FileName - ClassName - Method - [optional message]  AwesomeLog [
					    text = this is pretty log
					   ]
```
