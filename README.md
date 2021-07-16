# intentparser
[![](https://jitpack.io/v/lau1944/intentparser.svg)](https://jitpack.io/#lau1944/intentparser)

IntentParser is couple of extension functions for Intent class in order to pass objects much easier between Android activities.

### Set Up


Add this to your project gradle
```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

```

Add this to your application gradle
```

dependencies {
	        implementation 'com.github.lau1944:intentparser:v$currentVersion'
	}
```            


### How to use 

Pass object using extension method `putObject`

```kotlin
Current Acitivity
val testModel = TestModel(
            text = "hello world",
            isSuccess = false,
            testNum = 1,
            textModelSec = TextModelSec("second model")
)
startActivity(
     Intent(this, ActivityTest::class.java).apply {
          this.putObject(testModel)
     }
)        
        
```

Get object from Previous Activity

```kotlin
val testModel = intent.getObject(TestModel::class.java)
```





* The library is using `putExtra` under the hood
* So please remember do not pass a 'big object' into this method, it would lost some metadata and cause error

