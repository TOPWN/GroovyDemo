package com.dfire.plugindemo

/**
 * http://groovy-lang.org/single-page-documentation.html
 */

//Single quoted string
def singleString = 'a single quoted string'

//GString
def name = "danggui"
println "hello ${name}"

//Triple single quoted string
def aMultilineString = '''line one
line two
line three'''

/**
 * List，使用JDK的java.util.List
 */
//ArrayList default
def numbers = [1, 2, 3]
//查找
assert letters[1] == 2
assert letters[-1] == 3
assert letters[-2] == 2
//更新值
numbers[1] = 0
assert letters[1] == 0
//新增值
numbers << 4

//类型强转
def linkedList = [2, 3, 4] as LinkedList

//类型显示声明
LinkedList otherLinked = [3, 4, 5]

/**
 * Arrays,必须显示声明类型
 */
String[] arrStr = ['Ananas', 'Banana', 'Kiwi']

/**
 * Maps,使用java.util.LinkedHashMap.
 */
def colors = [red: '#FF0000', green: '#00FF00', blue: '#0000FF']
//查找
assert colors['red'] == '#FF0000'
assert colors.green == '#00FF00'
//更新值
colors['pink'] = '#FF00FF'
colors.yellow = '#FFFF00'

/**
 * 操作符
 */
//Spread list elements
def items = [4, 5]
def list = [1, 2, 3, *items, 6]
assert list == [1, 2, 3, 4, 5, 6]

//Spread map elements
def m1 = [c: 3, d: 4]
def map = [a: 1, b: 2, *: m1]
assert map == [a: 1, b: 2, c: 3, d: 4]

/**
 * Method
 */

//没有“return“的情况下，最后一行作为返回值
def someMethod() {
    def name = "li"
    "method called {$name}"
}

//Default arguments
def foo(String par1, Integer par2 = 1) {
    [name: par1, age: par2]
}

assert foo('Marie').age == 1

/**
 * Class
 */
//定义property，groovy自动生成getters/setters
class Person {
    String name
    int age
    final String sex //final类型不会生成setter方法
}

//调用
def p = new Person()
p.name

/**
 * Closure(闭包)
 */
def item = 1
def c0 = { item++ }

def c1 = { -> item++ }

def c2 = { println it }

def c3 = { it -> println it }

def c4 = { age -> println age } //Groovy的闭包可以引用外部变量

def c5 = { String x, int y ->
    println "hey ${x} the value is ${y}"
}

def listener = { e -> println "Clicked on $e" }
assert listener instanceof Closure

Closure callback = { println 'Done!' }

Closure<Boolean> isTextFile = {
    File it -> it.name.endsWith('.txt')
}
//调用闭包
def result = isTextFile(new File())
def callResult = isTextFile.call(new File())
