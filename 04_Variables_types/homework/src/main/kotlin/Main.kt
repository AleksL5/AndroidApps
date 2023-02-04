fun main() {

    val firstName: String = "Aleksandr"
    val lastName: String = "Latyshev"
    var hight: Double
    hight = 187.5
    val weight : Float = 87.4f

    val isChild = hight <= 140 && weight <= 40
    // Child Hight = 140; Child Weight = 40

    var info = "$firstName \n$lastName \n" +"My hight is " + "\"" +  "$hight \n" +"My weight is " + "\"" + "$weight \n" + "I'm a child ? " + "\"" + "$isChild"

    println (info)

    hight = 188.5

    info = "$firstName \n$lastName \n" +"My hight is " + "\"" +  "$hight \n" +"My weight is " + "\"" + "$weight \n" + "I'm a child ? " + "\"" + "$isChild"


    println (info)
}