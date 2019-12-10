package mastermind

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {
    var right = 0
    var one = arrayListOf<Char>()
    var two = arrayListOf<Char>()
    secret.zip(guess).forEach {
        if (it.first == it.second) {
            right++
        } else {
            one.add(it.first)
            two.add(it.second)
        }
    }
    one.retainAll(two)
    return Evaluation(right, one.size)
}
