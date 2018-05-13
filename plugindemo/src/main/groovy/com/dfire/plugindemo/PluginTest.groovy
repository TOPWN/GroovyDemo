package com.dfire.plugindemo

import org.gradle.api.Plugin
import org.gradle.api.Project

public class PluginTest implements Plugin<Project> {
    void apply(Project project) {
        project.task('testTask') << {
            println "Hello gradle plugin"
        }
    }
}