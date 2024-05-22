package battle

import kotlin.random.Random

class Sheriff : AbstractWarrior() {
	override val maximumHealth = 150
	override val evasionChance = 20
	override val accuracy: Int = 55
	override val weapon = Weapons
	override val currentHealth = 150
	override var isKilled = false

	override fun attack(warrior: AbstractWarrior) {
		val weapon = weapon.createShotGun
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