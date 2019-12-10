package cn.orange.study.simple

/**
 *  @author kz
 *  @date 2019/12/8
 */
fun main() {
    val one = readLine()
    val two = readLine()

    val oneInt = one!!.toInt()
    val twoInt = two!!.toInt()

    println("$one + $two = ${oneInt + twoInt}")

}