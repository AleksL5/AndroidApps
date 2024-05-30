package battle

import kotlin.random.Random

enum class Ammo(private val damage: Int, private val criticalDamageChance: Int, private val criticalDamageRatio: Int) {
	SNIPERRIFLEAMMO(85, 20, 7),
	MACHINEGUNAMMO(80, 20, 5),
	SHOTGUNAMMO(80, 15, 4),
	REVOLVERAMMO(75, 10, 3),
	EMPTYAMMO(0, 0, 0);

	fun takingCurrentDamage(): Int {
		val damage = if (criticalDamageChance.chance()) {
			damage * criticalDamageRatio
		} else {
			damage
		}
		print(" $damage damage taken,")
		return damage
	}
}

fun Int.chance() = Random.nextInt(100) < this