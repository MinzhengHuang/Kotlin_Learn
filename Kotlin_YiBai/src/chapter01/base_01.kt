package chapter01

/**
 * Kotlin基础语法
 *
 * Created by huangminzheng on 2018/3/7.
 */

fun main(args: Array<String>) {
    /**
     * 1.定义函数
     */
    print("sum of 3 and 5 is ")
    println(sum1(3, 5))
    println("sum of 19 and 23 is ${sum2(19, 23)}")
    printSum(-1, 8)

    /**
     * 2.定义局部变量
     */
    val a: Int = 1  // immediate assignment
    val b = 2   // `Int` type is inferred
    val c: Int  // Type required when no initia
    // lizer is provided
    c = 3       // deferred assignment
    println("a = $a, b = $b, c = $c")

    /**
     * 3.可变变量：
     */
    var x = 5 // `Int` type is inferred
    x += 1
    println("x = $x")

    /**
     * 4.使用字符串模板
     */
    var a2 = 1
    // simple name in template:
    val s1 = "a2 is $a2"
    a2 = 2
    // arbitrary expression in template:
    val s2 = "${s1.replace("is", "was")}, but now is $a2"
    println(s2)

    /**
     * 5.使用条件表达式
     */
    println("max of 0 and 42 is ${maxOf(0, 42)}")
    println("max of 0 and 42 is ${maxOf2(0, 42)}")

    /**
     * 6.使用可空值来检查null值
     */
    printProduct("6", "7")
    printProduct("a", "7")
    printProduct("a", "b")

    /**
     * 7.使用类型检查和自动转换
     */
    fun printLength(obj: Any) {
        println("'$obj' string length is ${getStringLength(obj) ?: "... err, not a string"} ")
    }
    printLength("Incomprehensibilities")
    printLength(1000)
    printLength(listOf(Any()))

    /**
     * 8.使用for循环
     */
    val items = listOf("apple", "banana", "kiwi")
    for (item in items) {
        println(item)
    }

    /**
     * 9.使用 while 循环
     */
    var index = 0
    while (index < items.size) {
        println("item at $index is ${items[index]}")
        index++
    }

    /**
     * 10.使用 when 表达式
     */
    println(describe(1))
    println(describe("Hello"))
    println(describe(1000L))
    println(describe(2))
    println(describe("other"))

    /**
     * 11.使用范围
     */
    //使用in操作符检查数字是否在指定范围内：
    val x2 = 10
    val y2 = 9
    if (x2 in 1..y2 + 1) {
        println("fits in range")
    }
    val list = listOf("a", "b", "c")

    //检查一个数字是否超出指定范围：
    if (-1 !in 0..list.lastIndex) {
        println("-1 is out of range")
    }
    if (list.size !in list.indices) {
        println("list size is out of valid list indices range too")
    }
    //迭代范围：
    for (x in 1..5) {
        print(x)
    }
    //或过程：
    for (x in 1..10 step 2) {
        println(x)
    }
    println("===============================")
    for (x in 9 downTo 0 step 3) {
        println(x)
    }

    /**
     * 12.使用集合
     */
    //迭代集合：
    for (item in items) {
        println(item)
    }
    //检查集合是否包含一个对象，使用in运算符：
    when {
        "orange" in items -> println("juicy")
        "apple" in items -> println("apple is fine too")
    }
    //使用lambda表达式过滤映射集合
    val fruits = listOf("banana", "avocado", "apple", "kiwi")
    fruits.filter { it.startsWith("a") }
            .sortedBy { it }
            .map { it.toUpperCase() }
            .forEach { println(it) }
}

//具有返回Int类型的两个Int参数的函数：
fun sum1(a: Int, b: Int): Int {
    return a + b
}

//函数与表达主体和推断返回值的类型：
fun sum2(a: Int, b: Int) = a + b

//函数返回无意义值：
fun printSum(a: Int, b: Int) {
    println("sum of $a and $b is ${a + b}")
}

//使用if表达式：
fun maxOf(a: Int, b: Int): Int {
    if (a > b) {
        return a
    } else {
        return b
    }
}

fun maxOf2(a: Int, b: Int) = if (a > b) a else b


//使用可返回null值的函数
fun parseInt(str: String): Int? {
    return str.toIntOrNull()
}

fun printProduct(arg1: String, arg2: String) {
    val x = parseInt(arg1)
    val y = parseInt(arg2)

    // Using `x * y` yields error because they may hold nulls.
    if (x != null && y != null) {
        // x and y are automatically cast to non-nullable after null check
        println(x * y)
    } else {
        println("either '$arg1' or '$arg2' is not a number")
    }
}


//is运算符检查表达式是否是类型的实例。 如果一个不可变的局部变量或属性是指定类型，则不需要显式转换：
fun getStringLength(obj: Any): Int? {
    if (obj is String) {
        // `obj` is automatically cast to `String` in this branch
        return obj.length
    }

    // `obj` is still of type `Any` outside of the type-checked branch
    return null
}


fun describe(obj: Any): String =
        when (obj) {
            1 -> "One"
            "Hello" -> "Greeting"
            is Long -> "Long"
            !is String -> "Not a string"
            else -> "Unknown"
        }



