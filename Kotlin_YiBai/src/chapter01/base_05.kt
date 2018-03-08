package chapter01


fun main(args: Array<String>) {



}

/**
 * if表达式
 */
//在Kotlin中，if表达式会返回一个值。
//val max = if (a > b) a else b

//if分支可以是块，并且最后一个表达式是块的值：
//val max = if (a > b) {
//    print("Choose a")
//    a
//} else {
//    print("Choose b")
//    b
//}


/**
 * When表达式
 */

//when (x) {
//    1 -> print("x == 1")
//    2 -> print("x == 2")
//    else -> { // Note the block
//        print("x is neither 1 nor 2")
//    }
//}

//当它的参数与所有when语句中的分支按顺序进行匹配，直到满足一些分支条件。when可以用作表达式或作为语句。 如果将其用作表达式，则满足分支的值将变为整体表达式的值。
//如果将when用作语句，则忽略各个分支的值。 (就像if语句，每个分支可以是一个块，其值是块中最后一个表达式的值。)

//如果其他的(if/else if)分支条件不满足，则评估求值else分支。如果when用作表达式，则else分支是必需的，除非编译器可以证明所有可能的情况都被分支条件覆盖。

//如果许多情况应该以同样的方式处理，分支条件可使用逗号组合：
//when (x) {
//    0, 1 -> print("x == 0 or x == 1")
//    else -> print("otherwise")
//}

//可以使用任意表达式(不仅仅是常量)作为分支条件 -
//when (x) {
//    parseInt(s) -> print("s encodes x")
//    else -> print("s does not encode x")
//}

//还可以检查值是否在或不在(in/!in)范围内或集合中：
//when (x) {
//    in 1..10 -> print("x is in the range")
//    in validNumbers -> print("x is valid")
//    !in 10..20 -> print("x is outside the range")
//    else -> print("none of the above")
//}

//另一个可能性是检查一个值是否(is/!is)为指定类型的值。请注意，由于智能转换，可以访问类型的方法和属性，而无需任何额外的检查。
fun hasPrefix(x: Any) = when(x) {
    is String -> x.startsWith("prefix")
    else -> false
}

//when也可以用来替代if-else if语句语法。 如果没有提供参数，则分支条件是简单的布尔表达式，当条件为真时执行分支：
//when {
//    x.isOdd() -> print("x is odd")
//    x.isEven() -> print("x is even")
//    else -> print("x is funny")
//}


/**
 * for循环
 */
//for循环提供迭代器用来遍历任何东西。 语法如下：
//for (item in collection) print(item)

//主体可以是一个块，如下 -
//for (item: Int in ints) {
//
//}

//如前所述，for迭代提供迭代器的任何内容，即
//    有一个成员或扩展函数iterator()，它的返回类型：
//        有一个成员或扩展函数next()和
//        有一个返回Boolean的成员或扩展函数hasNext()。

//所有这三个函数都需要被标记为运算符。
//for循环数组被编译为一个基于索引的循环，它不会创建一个迭代器对象。如果要遍历具有索引的数组或列表，可以这样做
//for (i in array.indices) {
//    print(array[i])
//}

//请注意，这个“通过范围的迭代”被编译成最佳实现，没有创建额外的对象。

//或者，可以使用withIndex库函数：
//for ((index, value) in array.withIndex()) {
//    println("the element at $index is $value")
//}


/**
 * while循环
 */
//while 和 do..while 用法和java语言中一样，如下 -
//while (x > 0) {
//    x--
//}
//
//do {
//    val y = retrieveData()
//} while (y != null) // y is visible here!


/**
 * Kotlin返回和跳转
 */
//Kotlin有三个结构跳转表达式：
//    return - 默认情况下，从最近的封闭函数或匿名函数返回。
//    break - 终止最近的闭合循环。
//    continue - 前进到最近的封闭循环的下一个步骤(迭代)。

//所有这些表达式都可以用作更大表达式的一部分：
//val s = person.name ?: return
//这些表达式的类型是Nothing类型。


/**
 * Break 和 Continue 标签
 */
//Kotlin中的任何表达式都可以标记一个标签。标签具有标识符的形式，它的后面跟@符号，
//例如：abc@，fooBar@是有效标签。 要使用标注表达式，只是在其前面放上一个标签。
//loop@ for (i in 1..100) {
//    // ...
//}

//现在，可以标记break或continue标签：
//loop@ for (i in 1..100) {
//    for (j in 1..100) {
//        if (...) break@loop
//    }
//}
//标记 break 为标记跳转到执行点后。标记继续进行到该循环的下一次迭代。


/**
 * 在标签上返回
 */
//使用函数文字，局部函数和对象表达式，函数可以嵌套在Kotlin中。 修饰return允许从外部函数返回。 最重要的用例是从lambda表达式返回。
//如下代码示例 -
//fun foo() {
//    ints.forEach {
//        if (it == 0) return
//        print(it)
//    }
//}

//返回表达式从最近的包围函数返回，即foo。 (请注意，这种非局部返回仅适用于传递给内联函数的lambda表达式)，
//如果需要从lambda表达式返回，必须对它进行标注并限定返回值：
//fun foo() {
//    ints.forEach lit@ {
//        if (it == 0) return@lit
//        print(it)
//    }
//}

//现在，它只从lambda表达式返回。通常使用隐性标签更为方便：这样的标签与传递lambda的函数具有相同的名称。
//fun foo() {
//    ints.forEach {
//        if (it == 0) return@forEach
//        print(it)
//    }
//}

//或者，可以用匿名函数替换lambda表达式。异常函数中的返回语句将从匿名函数中返回。
//fun foo() {
//    ints.forEach(fun(value: Int) {
//        if (value == 0) return
//        print(value)
//    })
//}

//当返回值时，解析器优先考虑标签的返回值，即 -
//return@a 1
//表示“在标签@a处返回1”，而不是“返回标记的表达式(@a 1)”。





























