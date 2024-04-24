import kotlin.random.Random

class NatureReserve {
	private val natureReserve = mutableListOf(
		Animal(70, 10, 15, "Simba"),
		Animal(50, 10, 14, "Pumba"),
		Animal(80, 10, 12, "Gazele"),
		Bird(70, 2, 3, "Bird1"),
		Bird(70, 2, 3, "Bird2"),
		Bird(70, 2, 3, "Bird3"),
		Bird(70, 2, 3, "Bird4"),
		Bird(70, 2, 3, "Bird5"),
		Fish(70, 2, 3, "Fish1"),
		Fish(70, 2, 3, "Fish2"),
		Fish(70, 2, 3, "Fish3"),
		Dog(70, 5, 15, "Dog1"),
		Dog(70, 5, 15, "Dog2")
	)


	fun lifeCircle(n: Int) {
			for (i in 1..n){
			checkForRemove()
			if (natureReserve.size == 0){
				println("Nature reserve is empty")
			}
			else {
				for (i in natureReserve.indices) {
					when ((1..5).random()) {
						1 -> natureReserve[i].eat()
						2 -> natureReserve[i].sleep()
						3 -> natureReserve[i].move()
						4 -> {
							val child = natureReserve[i].proCreate()
							natureReserve.add(child)
							println("${child.name} added to reserve")
						}
					}
				}
				checkForRemove()
				println("Life circle over")
				natureReserve.forEach { it.getInfo() }
				println("Living on these moment")

			}
		}
	}

	private fun checkForRemove() {
		val candidatesOnRemove = mutableListOf<Animal>()
		for (i in natureReserve.indices)
			if (natureReserve[i].isTooOld || natureReserve[i].energy < 0) {
				candidatesOnRemove.add(natureReserve[i])
			}
		natureReserve.removeAll(candidatesOnRemove)
		println("${candidatesOnRemove.size} died")
	}


}