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
}