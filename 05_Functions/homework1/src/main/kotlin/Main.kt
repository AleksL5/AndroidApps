fun main() {
    val encryption = """F2p)v"y233{0->c}ttelciFc"""
    val resultFirst = descryptionFirst(encryption)
    val resultSecond = descryptionSecond(encryption)
    println("$resultFirst \n $resultSecond")

}

fun descryptionFirst(part: String): String {
    val splitText = part.length / 2
    val firstPart = part.take(splitText)

    val firstResult = firstPart.map { char -> char + 1 }.joinToString("")
        .replace('5', 's')
        .replace('4', 'u')
        .map {char -> char - 3}.joinToString("")
        .replace('0', 'o')

    return firstResult
}

fun descryptionSecond(part: String): String {
    val splitText = part.length / 2
    val secondPart = part.takeLast(splitText)

    val secondResult = secondPart.reversed()
        .map { char -> char - 4 }.joinToString("")
        .replace('_', ' ')

    return secondResult









}
