package org.example

fun main() {
    var n: Int
    do {
        n = readln().toIntOrNull() ?: 0
        if (n <= 0)
            println("Number incorrect. Try again")
    } while (n <= 0)
    println("Get $n")

    val phoneBook = mutableListOf<String>()
    repeat(n) {
        val number = readln()
        phoneBook.add(number)
        println("Number $number saved")
    }
    println("Your phone book: ")
    phoneBook.forEachIndexed { index, it -> println("$index: $it") }

    println("Filtered book on \"+7\": ${phoneBook.filter { it.contains("+7") }} ")
    println("Get uniques numbers: ${phoneBook.toSet().size}")
    println("Sum of all numbers : ${phoneBook.sumOf { it.toLong() }}")

    val phoneBookToMap = mutableMapOf<String, String>()
    println("Input names for the phone numbers: ")
    var s: String
    var i = 0
    do {
        s = readln()
        phoneBookToMap[phoneBook[i]] = s
        i++
    } while (i <= phoneBook.size - 1)
    phoneBookToMap.toSortedMap().forEach{(key, value) -> println("Name: $value. Number: $key.") }
}
