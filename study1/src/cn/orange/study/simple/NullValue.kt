package cn.orange.study.simple

/**
 *  String? 表示这个值能够为空,
 *  str!! 断言 str != null
 *
 *  @author kz
 *  @date 2019/12/8
 */

fun main() {
    val str = null
    println(introducedInNull(str))
}

fun introducedInNull(value: String?): String {
    return "the value is: $value"
}
