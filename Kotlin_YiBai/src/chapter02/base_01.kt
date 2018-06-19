package chapter02


/**
 * Kotlin类和继承
 */
fun main(args: Array<String>) {

}

/**
 * 类
 */
//Kotlin中的类是使用class关键字来声明：
class Invoice {
//    ...
}

//类声明由类名，类头(指定类型参数，主构造函数等)和类体组成，由大括号括起来。类头和类主体都是可选的; 如果类没有主体，可以省略花括号。如下 -
class Empty


/**
 * 构造函数
 */
//Kotlin中的类可以有一个主构造函数和一个或多个辅助构造函数。 主构造函数是类头的一部分：它在类名后面(和可选的类型参数)。
//class Person constructor(firstName: String) {
//
//}

//如果主构造函数没有任何注释或可见性修饰符，那么可以省略constructor关键字：
//class Person(firstName: String) {
//
//}

//主构造函数不能包含任何代码。 初始化代码可以放在初始化程序块中，前缀为init关键字：
//class Customer(name: String) {
//    init {
//        logger.info("Customer initialized with value ${name}")
//    }
//}

//请注意，初始化程序块中可以使用主构造函数的参数。 它们也可以用在类体中声明属性的初始化器：
//class Customer(name: String) {
//    val customerKey = name.toUpperCase()
//}

//实际上，要声明属性并从主构造函数初始化它们，Kotlin有一个简洁的语法：
//class Person(val firstName: String, val lastName: String, var age: Int) {
    // ...
//}

//与常规属性大体相同，主构造函数中声明的属性可以是多值(var)或只读(val)。
//如果构造函数具有注释或可见性修饰符，则constructor关键字是必需的，修饰符将在它之前：
//class Customer public @Inject constructor(name: String) { ... }


/**
 * 辅助构造函数
 */
//类还可以声明辅助构造函数，它们以constructor关键字作为前缀：
//class Person {
//    constructor(parent: Person) {
//        parent.children.add(this)
//    }
//}

//如果类具有主构造函数，则每个辅助构造函数需要通过另一个辅助构造函数直接或间接地委派给主构造函数。 使用this关键字对同一类的另一个构造函数进行委派：
//class Person(val name: String) {
//    constructor(name: String, parent: Person) : this(name) {
//        parent.children.add(this)
//    }
//}

//如果一个非抽象类没有声明任何构造函数(主或辅助)，那么它将不使用参数来生成主构造函数。 构造函数的可见性将是公开的。 如果不希望类具有公共构造函数，
//则需要声明具有非默认可见性的空主构造函数：
class DontCreateMe private constructor () {
}

//注意：在JVM上，如果主构造函数的所有参数都具有默认值，编译器将生成一个额外的无参数构造函数，它将使用默认值。
//这使得更容易使用Kotlin与诸如Jackson或JPA的库，通过无参数构造函数创建类实例。
class Customer(val customerName: String = "")


/**
 * 创建类的实例
 */
//要创建一个类的实例，需要调用类的构造函数，就像它是一个常规函数一样：
val invoice = Invoice()
val customer = Customer("Joe Minsu")

//请注意，Kotlin创建对象并不使用new关键字。


/**
 * 类成员
 */
//类可以包含 -
//    构造函数和初始化程序块
//    函数
//    属性
//    嵌套和内部类
//    对象声明


/**
 * 继承
 */
//Kotlin中的所有类都有一个通用的超类：Any，这是一个没有父类型的类的默认超类。
class Example // Implicitly inherits from Any
//Any不是java.lang.Object; 特别地要说明的是，除了equals()，hashCode()和toString()之外，它不具有其它任何成员函数。

//要声明一个显式的超类型，将冒号后面的类型放在类头中：
open class Base(p: Int)

class Derived(p: Int) : Base(p)

//如果类具有主构造函数，则可以使用主构造函数的参数(并且必须)初始化基类型。

//如果类没有主构造函数，则每个辅助构造函数必须使用super关键字初始化基类型，或者委托给另一个构造函数。
//请注意，在这种情况下，不同的辅助构造函数可以调用基类型的不同构造函数：
//class MyView : View {
//    constructor(ctx: Context) : super(ctx)
//
//    constructor(ctx: Context, attrs: AttributeSet) : super(ctx, attrs)
//}

//一个类的开放(open)注释与Java的最终结果相反：它允许其他人继承这个类。 默认情况下，Kotlin中的所有类都是final，它对应于有效Java用法，设计和继承的文档或者禁止它。


/**
 * 重载方法
 */
//正如前面提到的，与Java不同的是，Kotlin需要对可覆盖成员进行显式注释(称之为open)和覆盖：
open class Base2 {
    open fun v() {}
    fun nv() {}
}
class Derived2() : Base2() {
    override fun v() {}
}
//Derived.v()需要覆盖(override)注释。 如果缺少(override)注释，编译器会抱错。 如果在一个函数上没有open注释，
//如在Base.nv()中，在子类中声明一个具有相同签名的方法是非法的，无论是否有覆盖(override)注释还是没有。
//在final类(例如不使用open注释的类)中，则禁止覆盖成员。

//标记为覆盖(override)的成员本身是打开的，即它可以在子类中被覆盖。 如果要禁止重新覆盖，请使用final关键字：
open class AnotherDerived() : Base2() {
    final override fun v() {}
}


/**
 * 覆盖属性
 */
//覆盖属性的工作方式与覆盖方法类似; 在超类上声明，然后在派生类上重新声明的属性必须以override替代，并且它们必须具有兼容类型。
//每个声明的属性可以被具有初始化器的属性或具有getter方法的属性覆盖。
//open class Foo {
//    open val x: Int get { ... }
//}
//
//class Bar1 : Foo() {
//    override val x: Int = ...
//}
//还可以使用var属性覆盖val属性，反之亦然。 这是允许的，因为val属性基本上声明一个getter方法，并将其替换为var，另外在派生类中声明一个setter方法。

//请注意，可以在主构造函数中使用override关键字作为属性声明的一部分。
interface Foo {
    val count: Int
}

class Bar1(override val count: Int) : Foo

class Bar2 : Foo {
    override var count: Int = 0
}


/**
 * 覆盖规则
 */
//在Kotlin中，实现继承由以下规则控制：如果类从其直接超类继承同一成员的多个实现，则它必须覆盖该成员并提供自己的实现(可能使用其中一个继承)。
//要表示从其继承的实现的超类型，可在尖括号中使用超类型名称超级限定，例如，super<Base>。
open class A {
    open fun f() { print("A") }
    fun a() { print("a") }
}

interface B {
    fun f() { print("B") } // interface members are 'open' by default
    fun b() { print("b") }
}

class C() : A(), B {
    // The compiler requires f() to be overridden:
    override fun f() {
        super<A>.f() // call to A.f()
        super<B>.f() // call to B.f()
    }
}
//从B继承A是没有问题的，对a()和b()函数也没有任何问题，因为C只继承每个这些函数的一个实现。 但是对于f()有两个由C继承的实现，
//因此必须在C中重写f()函数并提供自己的消除歧义的实现。


/**
 * 抽象类
 */
//一个类和其一些成员可以被声明为抽象。 抽象成员在其类中没有实现。 请注意，不需要使用open来注释抽象类或函数。

//可以用抽象来覆盖一个非抽象的open成员 -
//open class Base {
//    open fun f() {}
//}

//abstract class Derived : Base() {
//    override abstract fun f()
//}


/**
 * 伴随对象
 */
//在Kotlin中，与Java或C#不同，类没有静态(static)方法。 在大多数情况下，建议简单地使用包级别的功能。

//如果需要编写一个可以调用的函数，而不需要一个类实例，但需要访问一个类的内部(例如，一个工厂方法)，则可以将其作为对象声明的一个成员编写。

//更具体地说，如果在类中声明了一个伴随对象，则可以使用类名作为限定符的Java/C＃中调用静态方法相同的语法来调用其成员。





