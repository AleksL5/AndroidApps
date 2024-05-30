package battle

import kotlin.random.Random

class Team {


	fun getTeam(name: String, count: Int): MutableList<AbstractWarrior> {
		val team = mutableListOf<AbstractWarrior>()
		repeat(count) {
			team.add(createSoldier())
		}
		println("Team $name created:")
		team.forEach { println(it) }
		println("******************")
		return team
	}

	private fun createSoldier(): AbstractWarrior {
		val random = Random.nextInt(100)
		val sniper = Sniper()
		val rambo = Rambo()
		val sheriff = Sheriff()
		val trooper = Trooper()
		return when (random) {
			in 90..100 -> sniper
			in 70..90 -> rambo
			in 40..70 -> sheriff
			else -> trooper
		}
	}

	override fun toString(): String {
		return "${this.javaClass.simpleName}"
	}
}
