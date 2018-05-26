# 目标
- 交流学习Groovy，了解其基础知识以及如何使用Groovy编写一个Gralde Plugin。
# Groovy
- 基于JVM的动态语言
- 和Java无缝衔接
- 支持DSL
- 可用于编写脚本






# DSL
- 什么是DSL？

  > Domain-Specific Language 领域特定语言，针对一个特定的领域，具有受限表达性的一种计算机程序语言。可以看做是一种抽象处理的方式。简单的说就是`方言`
- 分类
  - 外部DSL
     > 一种独立的可解析的语言。举例，SQL。

  - 内部DSL
     > 通用语言所暴露的用来执行特定任务的API，一般至少包括`DSL语义模型`和`解析脚本`。举例，Gradle。




# Gradle
- 什么是Gradle
  >基于`Groovy`和`内部DSL`来实现的用于构建项目的框架（仅仅是一个框架）。
- 使用  
  > 配合各种plugin，比如Android-Gradle-Plugin、Java-Plugin、Maven-Plugin等。

- 核心
  - Project
  - Task

- 生命周期
  - 初始化
    >读取setting.gradle中的内容，导入工程，创建project实例。

  - 配置
    >执行各个工程的build.gradle脚本，配置project及其tasks。

  - 运行
    > 执行task

# Gradle Plugin开发
- 创建方法 [Packaging a plugin][1]
  - 内部创建
     - Build script
     - buildSrc project
  - 外部创建
     - [自定义Plugin][2]


- plugin不限于使用groovy开发


  [1]: https://docs.gradle.org/current/userguide/custom_plugins.html#sec:packaging_a_plugin
  [2]: https://blog.csdn.net/sbsujjbcy/article/details/50782830
