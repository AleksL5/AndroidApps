fun main () {
    val encryption = """F2p)v"y233{0->c}ttelciFc"""

    decryption(encryption)
}
fun decryption (part: String) {
    val partText = part.length / 2
    val firstPart = (part.take(partText))
    val secondPart = (part.takeLast(partText))

    val stepOne = firstPart.map {char -> char + 1}. joinToString("")
    val stepTwo = stepOne.replace ('5', 's')
    val stepThree = stepTwo.replace ('4', 'u')
    val stepFour = stepThree.map {char -> char - 3}. joinToString ("")
    val stepFive = stepFour.replace ('0', 'o')


    val stepSix = secondPart.reversed()
    val stepSeven = stepSix.map {char -> char - 4}.joinToString("")
    val stepEight = stepSeven.replace('_',' ')


    println("$stepFive\n$stepEight")
}
