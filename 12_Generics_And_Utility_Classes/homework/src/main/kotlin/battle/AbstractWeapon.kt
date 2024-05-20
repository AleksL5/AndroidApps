package battle

import Stack

abstract class AbstractWeapon {
	abstract val maximumAmmo: Int
	abstract val fireType: FireType
	private val cartridgeMagazine = Stack<Ammo>()
	val cartridgeMagazineStatus = cartridgeMagazine.isEmpty()

	fun creatBullet(type: String): Ammo {
		return when (type) {
			"Sniper" -> Ammo.SNIPERRIFLEAMMO
			"Machine gunner" -> Ammo.MACHINEGUNAMMO
			"Sheriff" -> Ammo.SHOTGUNAMMO
			"Trooper" -> Ammo.REVOLVERAMMO
			else -> Ammo.EMPTYAMMO
		}
	}

	fun reload(warriorType: String){
		val newMagazine = Stack<Ammo>()
		newMagazine.push(creatBullet(warriorType))
	}

	fun takeBullet() = cartridgeMagazine.pop()



}