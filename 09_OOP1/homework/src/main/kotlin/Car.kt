import kotlin.random.Random

class Car(val brand: String, val model: String, val color: String) {

	constructor(descriptor: Pair<String, String>, color: String) : this(
		brand = descriptor.first,
		model = descriptor.second,
		color = color
	) {
		println("Secondary constructor")
	}

	init {
		println("First init")
	}

	var currentSpeed = 0.0

	init {
		println("Second init")
	}

	fun move() {
		val distance = Random.nextInt(1, 10)
		println("Car passed $distance km")
	}


	fun start() {
		println("Car started")
	}

	fun stop() {
		println("Car stopped")
	}

	fun printInfo() {
		println("Brand: $brand, model $model, Color: $color")
	}

	companion object {
		const val wheelsCount = 4
		fun getCarClass(length: Double): String = when (length) {
			3.6 -> "A"
			3.9 -> "B"
			4.1 -> "C"
			4.3 -> "D"
			4.6 -> "E"
			else -> "F"
		}
	}
}

