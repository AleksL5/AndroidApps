package battle

import org.example.NoAmmoException
import kotlin.random.Random

class Trooper  : AbstractWarrior() {
	override val maximumHealth = 100
	override val evasionChance = 1
	override val accuracy: Int = 85
	override val weapon = Weapons
	override var currentHealth = 100
	override var isKilled = currentHealth <= 0

	override fun attack(warrior: AbstractWarrior) {
		val weapon = Weapons.createRevolver
		try {
			weapon.takeAmmoForShot()
			print("$this shoot! $warrior")
			if ((this.accuracy - warrior.evasionChance).chance()) {
				warrior.getDamage(weapon.ammo.takingCurrentDamage())
				println(" current health ${warrior.currentHealth}")
			} else println(" dodged")
		} catch (e: NoAmmoException) {
			println("$this says: My target $warrior. There are no bullets in the weapon. Recharging and missing my turn.")
			weapon.reload()
		}
	}
}