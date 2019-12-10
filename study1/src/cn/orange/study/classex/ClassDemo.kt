package cn.orange.study.classex

/**
 *  @author kz
 *  @date 2019/12/8
 */

class Rect(var height: Int, var width: Int) {
    fun area(): Int {
        return height * width
    }
}

fun main() {
    val rect = Rect(10, 2)
    println("${rect.height}")
    println("rect.area() = ${rect.area()}")
}