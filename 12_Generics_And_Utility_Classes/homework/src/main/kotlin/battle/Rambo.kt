package battle

import kotlin.random.Random

class Rambo : AbstractWarrior() {
	override val maximumHealth = 170
	override val evasionChance = 25
	override val accuracy: Int = 60
	override val weapon = Weapons
	override val currentHealth = 170
	override var isKilled = false

	override fun attack(warrior: AbstractWarrior) {
		val weapon = weapon.createMachineGun
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