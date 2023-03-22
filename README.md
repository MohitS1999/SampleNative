# SampleNative
For accessing the native library

To get Git project into your build

>Step 1. Add the JitPack repository to your build file
```gradle
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

>Step 2. Add the dependency
```gradle
dependencies {
	        implementation 'com.github.MohitS1999:SampleNative:1.1.0'
	}
```

<h1>
How do I use Native Library 
</h1>

>Step 1. Add the JitPack repository to your build file

```gradle
FloatArrayLib.simpleNativeLib(baseContext,arr)
```
1) we have to pass the float array
2) This will return the float array 
