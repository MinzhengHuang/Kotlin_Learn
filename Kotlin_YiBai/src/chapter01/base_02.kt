package chapter01


/**
 * Kotlin惯用语法
 *
 * Created by huangminzheng on 2018/3/7.
 */
fun main(args: Array<String>) {

}

//函数参数的默认值
//fun foo(a: Int = 0, b: String = "") { ... }

//过滤列表
//val positives = list.filter { x -> x > 0 }
//或者，甚至可以写得更短一些：
//val positives = list.filter { it > 0 }

//字符串插值
//println("Name $name")
//实例检查
//when (x) {
//    is Foo -> ...
//    is Bar -> ...
//    else   -> ...
//}


//遍历映射/列表对
//for ((k, v) in map) {
//    println("$k -> $v")
//}

//使用范围
//for (i in 1..100) { ... }  // closed range: includes 100
//for (i in 1 until 100) { ... } // half-open range: does not include 100
//for (x in 2..10 step 2) { ... }
//for (x in 10 downTo 1) { ... }
//if (x in 1..10) { ... }

//只读列表
//val list = listOf("a", "b", "c")


//只读映射
//val map = mapOf("a" to 1, "b" to 2, "c" to 3)

//访问映射
//println(map["key"]) // 打印值
//map["key"] = value // 设置值

//懒属性
//val p: String by lazy {
//    // compute the string
//}

//扩展函数
fun String.spaceToCamelCase() {

}
//"Convert this to camelcase".spaceToCamelCase()


//创建单例
object Resource {
    val name = "Name"
}

//如果不为null的速记
//val files = File("Test").listFiles()
//println(files?.size)


//如果不为null和else的速记
//val files = File("Test").listFiles()
//println(files?.size ?: "empty")


//如果为null,执行语句
//val data = ...
//val email = data["email"] ?: throw IllegalStateException("Email is missing!")


//如果不为null,执行语句
//val data = ...
//
//data?.let {
//    ... // execute this block if not null
//}


//在 when 语句上返回
fun transform(color: String): Int {
    return when (color) {
        "Red" -> 0
        "Green" -> 1
        "Blue" -> 2
        else -> throw IllegalArgumentException("Invalid color param value")
    }
}

//try/catch 表达式
fun test() {
    val result = try {
//        count()
    } catch (e: ArithmeticException) {
        throw IllegalStateException(e)
    }

    // Working with result
}


//if表达式
fun foo(param: Int) {
    val result = if (param == 1) {
        "one"
    } else if (param == 2) {
        "two"
    } else {
        "three"
    }
}


//方法生成器风格的使用返回Unit
fun arrayOfMinusOnes(size: Int): IntArray {
    return IntArray(size).apply { fill(-1) }
}


//单表达式函数
fun theAnswer() = 42
//这相当于 -
//fun theAnswer(): Int {
//    return 42
//}


//这可以与其他惯用语法有效结合，从而代码更短。 例如，与when-expression结合：
fun transform2(color: String): Int = when (color) {
    "Red" -> 0
    "Green" -> 1
    "Blue" -> 2
    else -> throw IllegalArgumentException("Invalid color param value")
}


//在对象实例上调用多个方法(‘with’)
class Turtle {
//    fun penDown()
//    fun penUp()
//    fun turn(degrees: Double)
//    fun forward(pixels: Double)
}
val myTurtle = Turtle()
//with(myTurtle) { //draw a 100 pix square
//    penDown()
//    for(i in 1..4) {
//        forward(100.0)
//        turn(90.0)
//    }
//    penUp()
//}


//Java 7的try与资源的用法
//val stream = Files.newInputStream(Paths.get("/some/file.txt"))
//stream.buffered().reader().use { reader ->
//    println(reader.readText())
//}


//需要通用类型信息的通用函数的方便形式
//  public final class Gson {
//     ...
//     public <T> T fromJson(JsonElement json, Class<T> classOfT) throws JsonSyntaxException {
//     ...
//inline fun <reified T: Any> Gson.fromJson(json): T = this.fromJson(json, T::class.java)


//使用可空的布尔值
//val b: Boolean? = ...
//if (b == true) {
//    ...
//} else {
//    // `b` is false or null
//}
