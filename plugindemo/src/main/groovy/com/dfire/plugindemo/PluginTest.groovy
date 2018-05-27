package com.dfire.plugindemo

import com.dfire.plugindemo.buildtype.Debug
import com.dfire.plugindemo.buildtype.Release
import com.dfire.plugindemo.model.AndroidConfig
import com.dfire.plugindemo.model.BuildType
import com.dfire.plugindemo.model.DefaultConfig
import org.gradle.api.Plugin
import org.gradle.api.Project

public class PluginTest implements Plugin<Project> {
    AndroidConfig mAndroidConfig

    void apply(Project project) {
        /**
         * 新建task
         */

        //方式一
        project.task('task1') {
            println "this is the task1"
        }
        // 方式二
        project.task('task2').doLast {
            println "create a task2"
        }
        //方式三 Deprecated
        project.task('task3') << {
            println "Hello task3"
        }

        /**
         * 读取配置
         */
        project.extensions.create('androidconfig', AndroidConfig)
        mAndroidConfig = project.androidconfig
        mAndroidConfig.extensions.create('defaultConfig', DefaultConfig)
        mAndroidConfig.extensions.create('buildTypes', BuildType)
        int compileSdkVersion = mAndroidConfig.compileSdkVersion
        DefaultConfig defaultConfig = mAndroidConfig.defaultConfig
        BuildType buildType = mAndroidConfig.buildTypes
        buildType.extensions.create('release', Release)
        buildType.extensions.create('debug', Debug)
        Release release
        Debug debug
        if (null != buildType) {
            release = buildType.release
            debug = buildType.debug
        }


        project.afterEvaluate {
            project.task('getConfig').doLast {
                println "compileSdkVersion-->${compileSdkVersion}"
                if (null != defaultConfig) {
                    println "applicationId-->${defaultConfig.applicationId}"
                    println "minSdkVersion-->${defaultConfig.minSdkVersion}"
                    println "versionName-->${defaultConfig.versionName}"
                }
                if (null != release) {
                    println "release debuggable-->${release.debuggable}"
                    println "release shrinkResources-->${release.shrinkResources}"
                }
                if (null != debug) {
                    println "debug debuggable-->${debug.debuggable}"
                    println "debug shrinkResources-->${debug.shrinkResources}"
                }

            }
        }

    }
}