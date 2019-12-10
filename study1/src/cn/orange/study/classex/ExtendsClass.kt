package cn.orange.study.classex

/**
 *  @author kz
 *  @date 2019/12/8
 */

open class Father() {
    var like = "apple"

    open fun say(something: String) {
        println("father say $something")
    }
}

class Son : Father() {

    override fun say(something: String) {
        println("son not say $something")
    }
}

fun main() {
    val son = Son()
    println(son.like)
    son.say("apple")
}