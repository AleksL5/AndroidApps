import kotlin.random.Random

open class Animal(var energy: Int, var weight: Int, val maxAge: Int, val name: String) {
	open var age: Int = 0
		set(value) {
			if (value >= 0)
				field = value
		}
	open var isTooOld = age >= maxAge
	open val typeOfMove = "move"

	init {
		println("${this.name} was born ")
	}

	fun sleep() {
		this.energy += 5
		println("${this.name} sleep")
	}

	fun eat() {
		this.energy += 3
		this.weight += 1
		tryIncrementAge()
		println("${this.name} eat")
	}

	open fun move() {
		if (isTooOld) {
			println("Sorry ${this.name} is to old. Can't move")
		} else {
			this.energy -= 5
			this.weight -= 1
			tryIncrementAge()
			println("${this.name} $typeOfMove")
		}
	}

	open fun proCreate(): Animal {
		val newAnimal = Animal(Random.nextInt(0, 10), Random.nextInt(0, 5), this.maxAge, this.name)
		println("${this.name} procreating new ${newAnimal.name} Age: ${newAnimal.age} Energy: ${newAnimal.energy} Weight: ${newAnimal.weight} MaxAge: ${newAnimal.maxAge} ")

		return newAnimal
	}

	protected fun tryIncrementAge() = if (Random.nextBoolean()) {
		age += 1
	} else age += 0

	fun getInfo() {
		println("${this.javaClass}, Name: ${this.name}, Age: ${this.age}, Energy: ${this.energy}, Weight ${this.weight}, MaxAge: ${this.maxAge} ")
	}

	open fun randomAction() {
		val num = Random.nextInt(1, 5)
		when (num) {
			1 -> this.eat()
			2 -> this.sleep()
			3 -> this.move()
			4 -> this.proCreate()
		}

	}
}

