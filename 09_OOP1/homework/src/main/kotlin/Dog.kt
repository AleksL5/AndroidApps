import kotlin.random.Random

class Dog(energy:Int, weight:Int, maxAge: Int, name: String) : Animal (energy, weight, maxAge, name){
	override var age: Int = 0
		set(value) {
			if (value >= 0)
				field = value
		}
	override var isTooOld = age >= maxAge
	override val typeOfMove = "run"



	override fun move() {
		if (isTooOld) {
			println("Sorry ${this.name} is to old. Can't move")
		} else {
			this.energy -= 5
			this.weight -= 1
			tryIncrementAge()
			println("${this.name} $typeOfMove")
		}
	}
	override fun proCreate(): Dog{
		val newDog = Dog(Random.nextInt(1,10), Random.nextInt(1,5), this.maxAge, this.name)
		println("${this.name} procreating new ${newDog.name} Age:${newDog.age} Energy: ${newDog.energy} Weight ${newDog.weight} MaxAge: ${newDog.maxAge} ")
		return newDog
	}
}