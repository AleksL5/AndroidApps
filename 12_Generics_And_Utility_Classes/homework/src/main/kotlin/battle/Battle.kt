package battle

class Battle {
	val team1 = Team().getTeam()
	val team2 = Team().getTeam()
	val isOver = false

	fun battleStatus(team: MutableList<AbstractWarrior>){
		team1.forEach { println(it) }
	}

	fun checkAllWarriorsHealth(team: MutableList<AbstractWarrior>):Int {
		var sumOfHealth = 0
		for (i in team.indices){
			sumOfHealth += team[i].currentHealth
		}
		println("$team, total amount of health: $sumOfHealth ")
		return sumOfHealth
	}

	fun checkForRemove(team: MutableList<AbstractWarrior>){
		val candidatesOnRemove = mutableListOf<AbstractWarrior>()
		for (i in team.indices){
			if (team[i].currentHealth <= 0)
				candidatesOnRemove.add(team[i])
		}
		team.removeAll(candidatesOnRemove)
		println("${candidatesOnRemove.size} warriors died in $team")
	}



}