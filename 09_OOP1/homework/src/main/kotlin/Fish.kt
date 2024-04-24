import kotlin.random.Random

class Fish(energy:Int, weight:Int, maxAge: Int, name: String) : Animal (energy, weight, maxAge, name){
	override var age: Int = 0
		set(value) {
			if (value >= 0)
				field = value
		}
	override var isTooOld = age >= maxAge
	override val typeOfMove = "swim"



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
	override fun proCreate(): Fish{
		val newFish = Fish(Random.nextInt(1,10), Random.nextInt(1,5), this.maxAge, this.name)
		println("${this.name} procreating new ${newFish.name} Age:${newFish.age} Energy: ${newFish.energy} Weight ${newFish.weight} MaxAge: ${newFish.maxAge} ")
		return newFish
	}
}
