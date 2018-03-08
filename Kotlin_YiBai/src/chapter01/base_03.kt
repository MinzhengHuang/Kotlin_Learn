package chapter01

/**
 * Kotlin编码约定/编码风格
 *
 * Created by huangminzheng on 2018/3/7.
 */

fun main(args: Array<String>) {

}

/**
 * 命名风格
 */
//如果有疑问，请使用Java编码约定，例如：
//    使用驼峰名称格式(并避免在名称中使用下划线)
//    类型从大写字母开始
//    方法和属性以小写字母开始
//    使用4空格缩进
//    公共函数应该放置到通用文件中，并以Kotlin文档呈现


/**
 * 冒号
 */
//冒号之前有一个空格，冒号分隔了类型和超类型，并且没有空格，冒号分隔实例和类型：
//interface Foo<out T : Any> : Bar {
//    fun foo(a: Int): T
//}


/**
 * Lambda表达式
 */
//在lambda表达式中，大括号周围应该使用空格，以及将参数与主体使用箭头分开。 只要有可能，lambda应该传递到括号之外。
//list.filter { it > 10 }.map {
//    element -> element * 2
//}
//在短而且不嵌套的lambdas中，建议使用它的惯例，而不是明确声明参数。 在具有参数的嵌套lambdas中，参数应始终要明确声明。


/**
 * 类头格式化
 */
//有几个参数的类可以写成一行：
//class Person(id: Int, name: String)
//具有较长头的类应格式化，每个主构造函数参数使用单独的行缩进。 此外，右括号应该在新的一行。 如果使用继承，则超类构造函数调用或实现接口列表应位于与括号相同的行上：
//class Person(
//        id: Int,
//        name: String,
//        surname: String
//) : Human(id, name) {
//    // ...
//}

//对于多个接口，超类构造函数调用应首先定位，然后每个接口应位于不同的行中：
//class Person(
//        id: Int,
//        name: String,
//        surname: String
//) : Human(id, name),
//        KotlinMaker {
//    // ...
//}
//构造函数参数可以使用常规缩进或连续缩进(双倍的常规缩进)。


/**
 * Unit 编码风格
 */
//如果函数返回Unit，则返回类型应该省略：
//fun foo() { // ": Unit" is omitted here
//
//}


/**
 * 函数和属性
 */
//在某些情况下，没有参数的函数与只读属性可互换。虽然语义是相似的，但是有一些风格约定的时候可适当选择使用。
//当用在基础算法时，属性优先于函数情况：
//    不抛出
//    具有O(1)复杂性
//    是廉价的计算(或caсhed在第一次运行)
//    通过调用返回相同的结果





















