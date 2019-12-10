package cn.orange.study.simple

/**
 *  @author kz
 *  @date 2019/12/8
 */

fun whenInt(value: Int) {
    when {
        value < 60 -> {
            println("< 60")
        }
        value < 100 -> {
            println("< 100")
        }
        else -> {
            println("other situations")
        }
    }
}

fun returnWhenInt(value: Int): String {
    return when {
        value < 60 -> {
            "$value < 60"
        }
        else -> {
            "$value is other situations"
        }
    }
}

fun main() {
    whenInt(59)
    whenInt(99)
    whenInt(1000)

    println("returnWhenInt = ${returnWhenInt(1000)}")
}