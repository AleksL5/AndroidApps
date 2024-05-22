package battle

import kotlin.random.Random

enum class Ammo(private val damage: Int, private val criticalDamageChance: Int, private val criticalDamageRatio: Int) {
	SNIPERRIFLEAMMO(50, 20, 30),
	MACHINEGUNAMMO(40, 20, 30),
	SHOTGUNAMMO(30, 15, 25),
	REVOLVERAMMO(20, 10, 15),
	EMPTYAMMO(0,0,0);

	fun takingCurrentDamage(): Int { return if (criticalDamageChance.criticalStrikeChance()) damage * criticalDamageRatio else damage	}

}

fun Int.criticalStrikeChance() = Random.nextInt(100) < this