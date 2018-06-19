package chapter02

/**
 * Kotlin可见性修饰符
 */
fun main(args: Array<String>) {

}

//类，对象，接口，构造函数，函数，属性及其设置器可以具有可见性修饰符。 (Getter总是具有与属性相同的可见性。)Kotlin中有四个可见性修饰符：
//private, protected, internal 和 public。如果没有显式修饰符，则使用的默认可见性是public。


/**
 * 包
 */
//函数，属性和类，对象和接口可以在“顶层”上声明，即直接在包中：
//package foo
//
//fun baz() {}
//class Bar {}

//如果没有指定任何可见性修饰符，则默认使用public，这意味着声明将在任何位置都可见;
//如果将一个声明标记为private，那么它只会在包含声明的文件中可见;
//如果将其标记为internal，则在同一模块中的任何地方可见;
//如果将其标记为protected，则不可用于顶层声明。
//示例：
//// file name: example.kt
//package foo
//
//private fun foo() {} // visible inside example.kt
//
//public var bar: Int = 5 // property is visible everywhere
//    private set         // setter is visible only in example.kt
//
//internal val baz = 6    // visible inside the same module


/**
 * 类和接口
 */

//对于在类中声明的成员：
//    private只有在这个类才能看到(包括其所有成员);
//    protected - 相同于private + 在子类中可见;
//    internal - 模块中的任何看到声明类的客户端都看到其内部成员;
//    public - 声明类的任何客户看到它的公共成员。
//
//注意Java用户：外部类不会在Kotlin中看到其内部类的私有成员。
//如果覆盖protected的成员，并且不明确指定可见性，则覆盖成员也将具有protected的可见性。

//例子：
open class Outer {
    private val a = 1
    protected open val b = 2
    internal val c = 3
    val d = 4  // public by default

    protected class Nested {
        public val e: Int = 5
    }
}

class Subclass : Outer() {
    // a is not visible
    // b, c and d are visible
    // Nested and e are visible

    override val b = 5   // 'b' is protected
}

class Unrelated(o: Outer) {
    // o.a, o.b are not visible
    // o.c and o.d are visible (same module)
    // Outer.Nested is not visible, and Nested::e is not visible either
}

//构造函数
//要指定类的主构造函数的可见性，请使用以下语法(请注意，需要添加一个显式constructor关键字)：
//class C private constructor(a: Int) { ... }
//这里的构造函数是:private。 默认情况下，所有构造函数都是public，它们有效地相当于在类可见的地方可见(即internal类的构造函数只能在同一模块中可见)。

//局部声明
//局部的变量，函数和类不能有可见性修饰符。


/**
 * 模块
 */
//内部可见性修饰符意味着该成员可以使用相同的模块。 更具体地说，一个模块是一组编译的Kotlin文件：
//    IntelliJ IDEA模块;
//    Maven或Gradle项目;
//    通过一次调用Ant任务编译的一组文件。

























