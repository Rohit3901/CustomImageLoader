# Custom Image Loader 
Android Application in Kotlin for showing list of images.

## Sdk Version and Tools
    min_sdk_version = 21
    target_sdk_version = 28
    compile_sdk_version = 28
    build tool version = 3.4.2

## Features
* To be able to asynchronously load the image onto the ImageView.
* To be able to load the images faster by caching it in memory.
* To be able to load the images faster by using disk-level caching.
* To be able to cancel the on-flight load request in case the loading is not needed anymore.

## Decisions
* Using MVVM Architecture pattern
* Using Kotlion as language
* Using Dagger2,rxJava2 and Live Data for communication and dependency injection.

## Assumptions
* User can cancel the loading while the progress bar is rotating i.e network call is being made.
