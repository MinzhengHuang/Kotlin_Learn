package chapter01

/**
 * Kotlin数据类型
 */
fun main(args: Array<String>) {
    //数字字面常量的下划线(可以使用下划线使数字常量更易读：)
    val oneMillion = 1_000_000
    val creditCardNumber = 1234_5678_9012_3456L
    val socialSecurityNumber = 999_99_9999L
    val hexBytes = 0xFF_EC_DE_5E
    val bytes = 0b11010010_01101001_10010100_10010010

    val a: Int = 10000
    print(a === a) // Prints 'true'
    val boxedA: Int? = a
    val anotherBoxedA: Int? = a
    print(boxedA === anotherBoxedA) // !!!Prints 'false'!!!


    //字符串模板
    //字符串可以包含模板表达式，即被评估的代码片段，并且其结果被连接到字符串中。 模板表达式以美元符号($)开头以及简单名称组成：
    val i = 10
    val s = "i = $i" // evaluates to "i = 10"
    val s2 = "abc"
    val str = "$s2.length is ${s2.length}" // evaluates to "abc.length is 3"
}

