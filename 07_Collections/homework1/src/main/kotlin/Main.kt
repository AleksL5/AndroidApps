package org.example

import java.util.Scanner

fun main() {
creatPhoneBook(3)

}

fun creatPhoneBook(number: Int): MutableList<String> {
    var phoneBook = mutableListOf<String>()
    val sc = Scanner(System.`in`)
    var i = 0
    while (i < number){
        val checkNumber = sc.next()
        if (checkNumber.toLong() < 0){
            println("Number incorrect. Try again")
        }
        else if (checkNumber.toLong() > 0) {
            println("Number $checkNumber saved")
            phoneBook.add(checkNumber)
            i++
        }
        else println("Try again")
    }
    println("Your numbers saved")
    return phoneBook
}
fun bookFilter(phoneBook: List<String>) = phoneBook.filter { it.contains("+7") }
fun bookToSet(phoneBook: List<String>){
    val phoneBookToSet = phoneBook.toSet()
    val numberOfnumbers = phoneBookToSet.size
    println("Number of phone numbers: $numberOfnumbers")
}
fun sumOfNumbers(phoneBook: List<String>) = phoneBook.sumOf { it.toLong() }
fun bookToMap(phoneBook: List<String>){
    var phoneBookToMap = mutableMapOf<String, String>()

}