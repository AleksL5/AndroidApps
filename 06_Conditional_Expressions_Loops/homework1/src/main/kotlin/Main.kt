fun main() {
    println("Input number for check")
    val n = readLine()?.toIntOrNull() ?: return

    if (n > 0)
        println(fib(n))
    else println("Incorrect number. Try another one")

}


tailrec fun fib(n: Int, a: Int = 0, b: Int = 1): Int =
    when (n) {

        1 -> b
        else -> fib(n - 1, b, a + b)

    }


