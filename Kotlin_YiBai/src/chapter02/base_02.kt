package chapter02

/**
 * Kotlin属性和字段
 */
fun main(args: Array<String>) {

}

//Kotlin的类型可以有属性。 这些可以声明为可变的，使用var关键字或使用val关键字只读。
//class Address {
//    var name: String = ...
//    var street: String = ...
//    var city: String = ...
//    var state: String? = ...
//    var zip: String = ...
//}

//要使用一个属性，简单地通过名称引用它，就好像它是Java中的一个字段：

//fun copyAddress(address: Address): Address {
//    val result = Address() // there's no 'new' keyword in Kotlin
//    result.name = address.name // accessors are called
//    result.street = address.street
//    // ...
//    return result
//}


/**
 * Getters 和 Setters
 */
//声明属性的完整语法是 -
//var <propertyName>[: <PropertyType>] [= <property_initializer>]
//[<getter>]
//[<setter>]

//初始化程序，getter和setter是可选的。 如果可以从初始化程序(或从getter返回类型，如下所示)推断属性类型，则属性类型是可选的。

//例子：
//var allByDefault: Int? // error: explicit initializer required, default getter and setter implied
//var initialized = 1 // has type Int, default getter and setter


//只读属性声明的完整语法与可变的属性声明的不同之处，有两种方式：它以val而不是var开头，不允许setter：
//val simple: Int? // has type Int, default getter, must be initialized in constructor
//val inferredType = 1 // has type Int and a default getter

//可以在一个属性声明中写出自定义访问器，非常像普通功能。 以下是一个定制getter的例子：
//val isEmpty: Boolean
//    get() = this.size == 0

//自定义设置器(setter)如下所示：
//var stringRepresentation: String
//    get() = this.toString()
//    set(value) {
//        setDataFromString(value) // parses the string and assigns values to other properties
//    }

//按照惯例，setter参数的名称是value，可以选择或使用不同的名称。

//从Kotlin 1.1起，如果可以从getter推断属性类型，则可以省略它：
//val isEmpty get() = this.size == 0  // has type Boolean

//如果需要更改访问器的可见性或注释它，但不需要更改默认实现，可以定义访问器而不定义其主体：
//var setterVisibility: String = "abc"
//    private set // the setter is private and has the default implementation
//
//var setterWithAnnotation: Any? = null
//    @Inject set // annotate the setter with Inject

/**
 * 后备字段
 */
//Kotlin的类不能有字段。 但是，有时在使用自定义访问器时需要有一个后备字段。 为了这些目的，Kotlin提供了可以使用字段标识符访问的自动备份字段：
//var counter = 0 // the initializer value is written directly to the backing field
//    set(value) {
//        if (value >= 0) field = value
//    }

//field标识符只能在属性的访问器中使用。
//如果属性使用至少一个访问器的默认实现，或者自定义访问器通过field标识符引用它，则将为属性生成后备字段。
//例如，在以下情况下，将不会有后备字段：
//val isEmpty: Boolean
//    get() = this.size == 0

/**
 * 后备属性
 */
//如果想做一些不符合这个“隐性后备字段”方案的东西，总是可以回到拥有一个后备属性：
//private var _table: Map<String, Int>? = null
//public val table: Map<String, Int>
//    get() {
//        if (_table == null) {
//            _table = HashMap() // Type parameters are inferred
//        }
//        return _table ?: throw AssertionError("Set to null by another thread")
//    }

//在所有方面，这与Java中的一样，因为使用默认getter和setter的私有属性的访问被优化，因此不会引入函数调用开销。


/**
 * 编译时常数
 */
//在编译时已知其值的属性可以使用const修饰符标记为编译时常数。 这些属性需要满足以下要求：
//    对象的顶层或成员
//    初始化为String类型或原始类型的值
//    没有定制的getter

//这些属性可以在注释中使用：
//const val SUBSYSTEM_DEPRECATED: String = "This subsystem is deprecated"
//@Deprecated(SUBSYSTEM_DEPRECATED) fun foo() { ... }


/**
 * 后期初始化属性
 */
//通常，声明为非空类型的属性必须在构造函数中进行初始化。 然而，这通常不方便。 例如，可以通过依赖注入或单元测试的设置方法初始化属性。
//在这种情况下，不能在构造函数中提供非空的初始值设置，但是仍然希望在引用类的正文中的属性时避免空检查。

//要处理这种情况，可以使用lateinit修饰符标记属性：
//public class MyTest {
//    lateinit var subject: TestSubject
//
//    @SetUp fun setup() {
//        subject = TestSubject()
//    }
//
//    @Test fun test() {
//        subject.method()  // dereference directly
//    }
//}

//修饰符只能用于在一个类的主体内声明的var属性(不在主构造函数中)，并且只有当该属性没有自定义的getter或setter时才可以使用。 属性的类型必须为非空值，并且不能为原始类型。

//在初始化之前访问一个lateinit属性会引发一个特殊的异常，清楚地标识被访问的属性以及它还没被初始化的事实。


/**
 * 委托属性
 */
//最常见的属性只是读取(也可能写入)支持字段。 另一方面，使用定制getter和setter可以实现属性的任何行为。属性如何运作有一些共同的模式。
//几个例子：懒值，通过给定的键读取映射，访问数据库，通知访问者等。

















