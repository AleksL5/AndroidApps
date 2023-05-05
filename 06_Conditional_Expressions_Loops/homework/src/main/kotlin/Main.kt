fun main() {
    println("Enter number")
    var i = 1
    val n = readLine()?.toIntOrNull() ?: return
    if (n == 0)
        println("Incorrect number. Please try another one")
    else
        println("Result")

    var t1 = 0
    var t2 = 1
    println("First $n numbers: ")
    while (i <= n) {
        print("${t1} ")
        val sum = t1 + t2
        t1 = t2
        t2 = sum
        i++
    }

}