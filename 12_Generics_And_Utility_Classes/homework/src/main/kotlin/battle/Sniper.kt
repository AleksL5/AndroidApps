package battle

import kotlin.random.Random

class Sniper : AbstractWarrior() {
	override val maximumHealth = 110
	override val evasionChance = 5
	override val accuracy: Int = 100
	override val weapon = Weapons
	override var currentHealth = 110
	override var isKilled = currentHealth <= 0

	override fun attack(warrior: AbstractWarrior) {
		val weapon = Weapons.createSniperRifle
		if (weapon.cartridgeMagazine.isEmpty()) {
			println("$this says: My target $warrior. There are no bullets in the weapon. Recharging and missing my turn.")
			weapon.reload()
		}else {
			weapon.takeAmmoForShot()
			print("$this shoot! $warrior")
			if ((this.accuracy - warrior.evasionChance).chance()){
				warrior.getDamage(weapon.ammo.takingCurrentDamage())
				println(" current health ${warrior.currentHealth}")
			}
			else println(" dodged")
		}
	}
}
