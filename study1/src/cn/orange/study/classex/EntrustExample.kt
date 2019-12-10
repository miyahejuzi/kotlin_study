package cn.orange.study.classex

import kotlin.properties.Delegates
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 *  委托 by 语法
 *    委托模式已证明是实现继承的一个很好的替代方式。Kotlin中委托分为类委托和委托属性，Kotlin官方库也封装了一些常用的委托
 *
 *  常见的使用场景 :
 *    有多个类或属性重复使用同一段代码。
 *    实现继承的代替方式
 *    可以使用 kotlin 标准委托，来实现一些特殊的功能，当然，自己也可以自定义一些
 *
 *  参考:
 *  <a>https://www.runoob.com/kotlin/kotlin-delegated.html</a>
 *  <a>https://juejin.im/entry/59ac33a36fb9a02491751e97</a>
 *
 *
 *  类委托:
 *    类 Derived 可以继承一个接口 Base，
 *    并将其所有共有的方法委托给一个指定的对象，
 *    也就是说把类 Derived 因继承而需要实现的方法委托给一个对象，从而不需要在该类内显式的实现
 *
 *  反编译的类委托的代码, 可以看到类似于继承
 *    public interface Base {
 *         public abstract fun print(): kotlin.Unit
 *    }
 *
 *    public final class BaseImpl public constructor(str: kotlin.String) : cn.orange.study.classex.Base {
 *        private final val str: kotlin.String /* compiled code */
 *        public open fun print(): kotlin.Unit { /* compiled code */ }
 *    }
 *
 *    public final class Derived public constructor(b: cn.orange.study.classex.Base) : cn.orange.study.classex.Base {
 *    }
 *
 */
interface Base {
    fun print()
}

class BaseImpl(private val str: String) : Base {
    override fun print() {
        println(str)
    }
}

class Derived(b: Base) : Base by b

/**
 * 委托属性 语法: val/var <属性名>: <类型> by <表达式>
 *   属性的委托不必实现任何的接口, 但是需要提供一个 getValue() 函数（和 setValue()——对于 var 属性）,
 *   因为属性对应的 get()（和 set()）会被委托给它的 getValue() 和 setValue() 方法。
 *   也可以直接继承 ReadWriteProperty, 实现其中的方法, 这样就避免了自己手写可能出现的错误,
 *   例如 Kotlin 源码中这样实现判空的委托属性:
 */
// 定义包含属性委托的类
class Example {
    var p: String by Delegate()
}

// 委托的类
class Delegate : ReadWriteProperty<Any, String> {
    override fun getValue(thisRef: Any, property: KProperty<*>): String {
        return "$thisRef, 这里委托了 ${property.name} 属性"
    }

    override fun setValue(thisRef: Any, property: KProperty<*>, value: String) {
        println("$thisRef 的 ${property.name} 属性赋值为 $value")
    }
}

/**
 * 标准委托, Kotlin 的标准库中已经内置了很多工厂方法来实现属性的委托。
 * 延迟属性 Lazy:
 *   lazy() 是一个函数, 接受一个 Lambda 表达式作为参数, 返回一个 Lazy <T> 实例的函数，
 *   返回的实例可以作为实现延迟属性的委托： 第一次调用 get() 会执行已传递给 lazy() 的 lambda 表达式并记录结果，
 *   后续调用 get() 只是返回记录的结果。
 */
val lazyValue: String by lazy {
    // 第一次调用输出，第二次调用不执行
    println("computed!")
    "Hello"
}

/**
 * 可观察属性 Observable:
 *    observable 可以用于实现观察者模式。
 *    Delegates.observable() 函数接受两个参数: 第一个是初始化值, 第二个是属性值变化事件的响应器(handler)。
 *    在属性赋值后会执行事件的响应器(handler)，它有三个参数：被赋值的属性、旧值和新值
 */
class User {
    var name: String by Delegates.observable("初始值") { property, old, new ->
        println("$property, 旧值：$old -> 新值：$new")
    }
}

/**
 * 把属性储存在映射中:
 *   一个常见的用例是在一个映射（map）里存储属性的值。
 *   这经常出现在像解析 JSON 或者做其他"动态"事情的应用中。
 *   在这种情况下，你可以使用映射实例自身作为委托来实现委托属性。
 *   这是可以动态修改的
 */
class Site(map: Map<String, Any?>) {
    val name: String by map
    val url: String by map
}

fun main(args: Array<String>) {
    // print 'base impl'
    Derived(BaseImpl("base impl")).print()

    val e = Example()
    // 访问该属性，调用 getValue() 函数
    println(e.p)
    // 调用 setValue() 函数
    e.p = "set value"
    println(e.p)

    // 第一次执行，执行两次输出表达式
    println(lazyValue)
    // 第二次执行，只输出返回值
    println(lazyValue)

    User().name = "新的值"

    val map = mutableMapOf("name" to "B站", "url" to "www.baidu.com")
    val site = Site(map)
    println("${site.name} -> ${site.url}")
    map["name"] = "A站"
    map["url"] = "www.alibaba.com"
    println("${site.name} -> ${site.url}")

}
