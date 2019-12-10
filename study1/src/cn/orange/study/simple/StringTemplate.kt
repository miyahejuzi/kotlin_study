package cn.orange.study.simple

import java.time.Instant

/**
 *  学习 kotlin 字符串模板语法
 *  @author kz
 *  @date 2019/12/8
 */

fun printNowTime(now: String): String {
    val template = """当前时间: $now """
    println("template = $template")
    return template
}

fun returnString(string: String) :String{
    return "this is the returned string $string"
}

fun main(args: Array<String>) {
    println("String template test")
    val str = printNowTime(Instant.now().toString())
    println("str = $str")

    println("""调用函数: ${returnString("'test string'")}""")
}
