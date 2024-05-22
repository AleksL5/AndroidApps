package battle

import kotlin.random.Random

class Sniper : AbstractWarrior() {
	override val maximumHealth = 200
	override val evasionChance = 30
	override val accuracy: Int = 70
	override val weapon = Weapons
	override val currentHealth = 200
	override var isKilled = false

	override fun attack(warrior: AbstractWarrior) {
		val weapon = weapon.createSniperRifle
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
