# DebugLog
Library for logging message in debug

# Download
-----------------------
Project build gradle:

```groovy
allprojects {
 repositories {
    jcenter()
    maven { url "https://jitpack.io" }
 }
}
```

Gradle:
```groovy
compile 'com.github.vietnguyen312:DebugLog:1.7.1'
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
#List - Map:

```java
	List<AwesomeLog> awesomeLogs = new LinkedList();
	AwesomeLog awesome = new AwesomeLog();
	awesome.setText("this is the first object");
	awesomeLogs.add(awesome);
	
	awesome = new AwesomeLog();
	awesome.setText("this is the second object");
	awesomeLogs.add(awesome);
	Debug.log("optional message", awesomeLogs);
```


#**Result:**

```java
	FileName - ClassName - Method - [optional message]  LinkedList [
						   [0] = [
							text = this is the first object
						   ],
						   [1] = [
							text = this is the second object
						   ]
						]
```
