package chapter02


/**
 * Kotlin接口
 * Kotlin中的接口非常类似于Java 8。它们可以包含抽象方法的声明以及方法实现。 使它们与抽象类不同的是接口不能存储状态。 它们可以具有属性，
 * 但这些需要是抽象的或提供访问器实现。
 */
fun main(args: Array<String>) {

}

//使用关键字：interface定义接口
interface MyInterface {
    fun bar()
    fun foo() {
        // optional body
    }
}

/**
 * 实现接口
 */
//类或对象可以实现一个或多个接口：
class Child : MyInterface {
    override fun bar() {
        // body
    }
}

/**
 * 接口属性
 */
//您可以在接口中声明属性。 在接口中声明的属性可以是抽象的，也可以为访问者提供实现。 在接口中声明的属性不能具有后备字段，
//因此在接口中声明的访问器不能引用它们。
interface MyInterface2 {
    val prop: Int // abstract

    val propertyWithImplementation: String
        get() = "foo"

    fun foo() {
        print(prop)
    }
}

class Child2 : MyInterface2 {
    override val prop: Int = 29
}

/**
 * 解决重载冲突
 */
//当在超类型列表中声明很多类型时，可能会出现继承同一方法的多个实现。 例如 -
interface A2 {
    fun foo() { print("A") }
    fun bar()
}

interface B2 {
    fun foo() { print("B") }
    fun bar() { print("bar") }
}

class C2 : A2 {
    override fun bar() { print("bar") }
}

class D2 : A2, B2 {
    override fun foo() {
        super<A2>.foo()
        super<B2>.foo()
    }

    override fun bar() {
        super<B2>.bar()
    }
}

//接口A2和B2都声明函数foo()和bar()。它们都实现了foo()，但只有B2实现bar()，bar()在A2中没有标记为abstract，
//因为这是接口的默认值，如果函数没有主体。 现在，如果类C2类要实现A2接口，显然必须重写bar()并提供一个实现。

//然而，如果D2类实现A2和B2的方法，需要实现从多个接口继承的所有方法，并指定D2应该如何实现它们。此规则既适用于继承单个实现(bar())和多个实现(foo())的方法。

