package com.dfire.plugindemo

import org.gradle.api.Plugin
import org.gradle.api.Project

public class PluginTest implements Plugin<Project> {
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

    }
}