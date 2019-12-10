package cn.orange.study.simple

import java.lang.NumberFormatException

/**
 *  @author kz
 *  @date 2019/12/8
 */
fun main() {
    val str = "abc"
    try {
        println("str = ${str.toInt()}")
    } catch (e: NumberFormatException) {
        println("has error : ${e.message}")
    }
}