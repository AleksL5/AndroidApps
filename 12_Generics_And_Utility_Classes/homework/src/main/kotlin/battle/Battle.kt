package battle

class Battle {
	private val team1 = Team("Red", 10).warriors
	private val team2 = Team("Green", 10).warriors

	private var isOver = false

	fun battle() {
		var roundCount = 1

		while (!isOver) {
			print("Round $roundCount starts! ")
			println(
				"Team Red health: ${checkAllWarriorsHealth(team1)} | Team Green health: ${
					checkAllWarriorsHealth(
						team2
					)
				}"
			)
			remove(team1)
			if (isOver)
				break
			team1[0].attack(team2[0])
			remove(team2)
			if (isOver)
				break
			team2[0].attack(team1[0])
			roundCount++
		}
		val winner = if (checkAllWarriorsHealth(team1) > checkAllWarriorsHealth(team2))
			"team 1 winner!" else "team 2 winner!"
		println("Battle ends $winner")
	}

	private fun checkAllWarriorsHealth(team: MutableList<AbstractWarrior>): Int {
		return team.map { it.currentHealth }.sum()
	}

	private fun remove(team: MutableList<AbstractWarrior>) {
		team.removeAll { it.currentHealth <= 0 }
		if (team.isEmpty())
			isOver = true
	}
}