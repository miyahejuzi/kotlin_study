package cn.orange.study.pattern

/**
 *  策略模式:
 *  抽象策略（Strategy）类：定义了一个公共接口，各种不同的算法以不同的方式实现这个接口，
 *  环境角色使用这个接口调用不同的算法，一般使用接口或抽象类实现。
 */
interface Strategy {
    fun strategyMethod()
}

/**
 * 具体策略（concrete strategy）类：实现了抽象策略定义的接口，提供具体的算法实现。
 */
class FirstStrategyImpl() : Strategy {
    override fun strategyMethod() {
        println("First Concrete strategy implement")
    }
}

class SecondStrategyImpl() : Strategy {
    override fun strategyMethod() {
        println("Second Concrete strategy implement")
    }
}
// ----------- end

/**
 * 环境（Context）类：持有一个策略类的引用，最终给客户端调用。
 */
class Content(var strategy: Strategy) :
    Strategy {
    override fun strategyMethod() {
        strategy.strategyMethod()
    }
}

fun main() {
    val content: Content = when (readLine()) {
        "1" -> Content(FirstStrategyImpl())
        "2" -> Content(SecondStrategyImpl())
        else -> throw RuntimeException("not find strategy")
    }
    content.strategyMethod()
}