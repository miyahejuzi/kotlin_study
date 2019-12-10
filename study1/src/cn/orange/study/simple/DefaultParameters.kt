package cn.orange.study.simple

/**
 *  @author kz
 *  @date 2019/12/8
 */
fun say(name: String = "name", said: String = "nothing") {
    println("$name said $said")
}

fun main() {
    say()
    say(said = "I am god!")
    say("I", "I am god!")
}