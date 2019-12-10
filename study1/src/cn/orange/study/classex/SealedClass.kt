package cn.orange.study.classex

/**
 * Kotlin的封装类是Java中没有的新概念，并为此开辟了另一片可能性新的世界。
 * 密封类允许你表达约束层次结构，其中对象只能是给定类型之一。
 * 也就是说，我们有一个`具有特定数量的子类的类`。
 * 最后，我们得到的结论是非常类似枚举的概念。
 * 所不同的是，在枚举中，我们每个类型只有一个对象；
 * 而在密封类中，同一个类可以拥有几个对象。
 * 这种差异允许密封类的对象可以保持状态。
 * 这给我们带来一些的优势（稍后会看到），它也为函数性概念敞开大门。
 *
 * <a>https://www.cnblogs.com/figozhg/p/7107053.html</a> 没有太懂, 感觉可以看看
 */
sealed class Operation {
    class Add(val value: Int) : Operation()
    class Substract(val value: Int) : Operation()
    class Multiply(val value: Int) : Operation()
    class Divide(val value: Int) : Operation()
}

fun execute(x: Int, op: Operation) = when (op) {
    is Operation.Add -> x + op.value
    is Operation.Substract -> x - op.value
    is Operation.Multiply -> x * op.value
    is Operation.Divide -> x / op.value
}