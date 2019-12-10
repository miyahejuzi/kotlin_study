package cn.orange.study.simple

/**
 *  @author kz
 *  @date 2019/12/8
 */


fun add(a: Int, b: Int): Int = a + b

fun main() {
    println("invoke add = ${add(1, 1)}")
    // 函数指针?
    val sub: (Int, Int) -> Int = { x, y -> x - y }
    println("invoke sub = ${sub(1, 1)}")
    val mul = { x: Int, y: Int -> x * y }
    println("invoke mul = ${mul(1, 1)}")

}
