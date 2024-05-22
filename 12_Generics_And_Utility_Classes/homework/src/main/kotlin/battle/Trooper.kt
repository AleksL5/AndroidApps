package battle

import kotlin.random.Random

class Trooper  : AbstractWarrior() {
	override val maximumHealth = 100
	override val evasionChance = 15
	override val accuracy: Int = 50
	override val weapon = Weapons
	override val currentHealth = 100
	override var isKilled = false

	override fun attack(warrior: AbstractWarrior) {
		val weapon = weapon.createRevolver
		if (weapon.takeAmmoForShot().isEmpty()){
			println("There are no bullets in the weapon. Recharging and missing my turn")
			weapon.reload()
		}else {
			weapon.takeAmmoForShot()
			if (Random.nextInt(100) < this.accuracy - warrior.evasionChance){
				weapon.takeAmmoForShot()
				warrior.getDamage(weapon.ammo.takingCurrentDamage())
			}
		}
	}
}