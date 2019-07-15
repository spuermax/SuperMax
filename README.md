# SuperMax
Super Max Developers.

## 如何使用

#### step 1：项目的build.gradle添加依赖

        buildscript {
            repositories {
                    jcenter()
                    mavenCentral()
                    maven {
                        url 'https://jitpack.io'
                    }
                }
        }

        allprojects {
            repositories {
                ...
                maven {
                    url 'https://jitpack.io'
                }
            }
        }

#### step 2：app的build.gradle添加依赖

        dependencies {
            ...
        implementation 'com.github.spuermax:SuperMax:0.1'
        }  
