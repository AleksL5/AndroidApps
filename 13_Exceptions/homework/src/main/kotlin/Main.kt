package org.example

import com.sun.jdi.IntegerType
import com.sun.jdi.IntegerValue
import kotlin.math.min
import kotlin.random.Random
val MINVALUE = (Integer.MIN_VALUE).toDouble()

fun main() {
	val wheel = Wheel()

	try {
		wheel.pumpUpTheWheel(2.5)
	}	catch (e: TooHighPressure){
		println("Pressure value between 2.6 - 10 is too high")
	}	catch (e: TooLowPressure){
		println("Pressure value between 0.0 - 2.4 is to low")
	}	catch (e: IncorrectPressure){
		println("Negative pressure value and higher than ten is incorrect")
	}
	println(wheel.pressureCheck())

}
class TooHighPressure() : Throwable("The pressure is to height")
class TooLowPressure() : Throwable("The pressure is to low")
class IncorrectPressure() : Throwable("Incorrect pressure")

class Wheel(){
	private var pressure = 0.0
	fun pumpUpTheWheel(count: Double){
		when(count){
			in 2.6..9.9 -> throw TooHighPressure()
			in 0.0..2.4 -> throw TooLowPressure()
			in MINVALUE..-0.01 -> throw IncorrectPressure()
			in 10.0..Double.MAX_VALUE -> throw IncorrectPressure()
			else -> pressure = count
		}
	}
	fun pressureCheck() = "Pressure value: $pressure"
}

