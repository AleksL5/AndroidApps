package battle

import kotlin.random.Random

class Team {

	fun getTeam() : MutableList<AbstractWarrior> {
		val team = mutableListOf<AbstractWarrior>()
		repeat(10) {
		team.add(createSoldier())
		}
		println("$team created:")
		team.forEach { println(it) }
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

}
