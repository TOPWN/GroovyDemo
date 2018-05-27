package com.dfire.plugindemo

/**
 * @see <a href="http://groovy-lang.org/single-page-documentation.html">Groovy</a>
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
numbers.each {}
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

//省略括号
foo "hello", 20

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
 * Closure(闭包)，不同于JS中的闭包
 */

def c0 = { String x, int y ->
    println "hey ${x} the value is ${y}"
}

def c1 = { age -> println age }

def c2 = { it -> println it }

def c3 = { println it }

def item = 1

def c4 = { -> item++ }

def c5 = { item++ }

def listener = { e -> println "Clicked on $e" }
assert listener instanceof Closure

Closure<Boolean> isTextFile = {
    File it -> it.name.endsWith('.txt')
}
//调用闭包,最后一行作为返回值
def result = isTextFile(new File('xx/yy/z.txt'))
def callResult = isTextFile.call(new File('xx/yy/z.txt'))

//最后一行无返回值，则返回null
Closure callback = { println 'Done!' }

def greeting = { "Hello, $it!" }
assert greeting('Patrick') == 'Hello, Patrick!'

//可以省略圆括号
greeting 'Patrick'

//将closure作为method参数
def lst = [11, 12, 13, 14]
lst.each { println it }//print "11 12 13 14"

//如果函数的最后一个参数是闭包的话，可以省略圆括号
def testClosure(int a1, String b1, Closure closure) {
    //do something
}

//当闭包作为闭包或方法的最后一个参数。可以将闭包从参数圆括号中提取出来接在最后，如果闭包是唯一的一个参数，则闭包或方法参数所在的圆括号也可以省略
testClosure(4, "test") {
    println "i am in closure"
}
//可以省略圆括号
testClosure 4, "hello", {
    println "i am in closure"
}