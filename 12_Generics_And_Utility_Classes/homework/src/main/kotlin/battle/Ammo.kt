package battle

import kotlin.random.Random

enum class Ammo(val damage: Int, val criticalDamageChance: Int, val criticalDamageRatio: Int) {
	SNIPERRIFLEAMMO(50, 20, 30),
	MACHINEGUNAMMO(40, 20, 30),
	SHOTGUNAMMO(30, 15, 25),
	REVOLVERAMMO(20, 10, 15),
	EMPTYAMMO(0,0,0);

	fun takingCurrentDamage(damage: Int, criticalDamageChance: Int, criticalDamageRatio: Int): Int {
		val criticalDamage = damage * criticalDamageRatio
		val currentDamage = if (criticalDamageChance.criticalStrikeChance())
			criticalDamage
		else damage
		return currentDamage
	}
}

fun Int.criticalStrikeChance() = Random.nextInt() * 100 < this