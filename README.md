Card Recognizer Apps

Step 1. Add it in your root build.gradle at the end of repositories:

dependencyResolutionManagement {
		repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
		repositories {
			mavenCentral()
			maven { url 'https://jitpack.io' }
		}
	}

Step 2. Add the dependency

dependencies {
	        implementation 'com.github.mandipkanjiya:Card-Recognizer:Tag'
	}
