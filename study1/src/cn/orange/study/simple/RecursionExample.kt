package cn.orange.study.simple

/**
 *  @author kz
 *  @date 2019/12/8
 */

fun foo1(num: Int): Int {
    return if (num == 1) {
        1
    } else {
        foo1(num - 1) + num
    }
}

tailrec fun foo2(num: Int, result: Int = 0): Int {
    return if (num == 1) {
        return result + 1
    } else {
        foo2(num - 1, result + num)
    }
}

fun main() {
//    println(foo1(100000000))
    println(foo2(100000000))
}
