package cn.orange.study.simple

/**
 *  @author kz
 *  @date 2019/12/8
 */

fun main() {

    // [1, 99]
    val range = 1..99
    // [1, 99)
    val range2 = 1 until 99

    // 步长
    for (i in range.reversed() step 5) {
        println("i = $i")
    }
    // [10, 1]
    for (i in 10 downTo 1 - 1) {
        println("i = $i")
    }

}