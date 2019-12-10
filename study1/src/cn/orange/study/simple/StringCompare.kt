package cn.orange.study.simple

/**
 *  == 和 === 的区别
 *  自动拆装箱的问题: 和 java 里面差不多的原理
 *  Int is int, Int? is Integer
 *
 *  @author kz
 *  @date 2019/12/8
 */

fun template(statement: String, s1: Any, s2: Any) {
    println("$statement : ")
    println("s1 and s2 are the same? == is comparing value = ${s1 == s2}")
    println("s1 and s2 are the same? === is comparing address  = ${s1 === s2}")
    println("---")
}


fun comparingTheSameString() {
    val s1 = "aaa"
    val s2 = "aaa"
    template("two string comparing", s1, s2)
}

fun comparingTheInteger() {
    val a: Int = 128
    val b: Int? = a
    val c: Int? = a
    template("two Int? comparing", b!!, c!!)
}

fun main() {
    comparingTheSameString()
    comparingTheInteger()
}