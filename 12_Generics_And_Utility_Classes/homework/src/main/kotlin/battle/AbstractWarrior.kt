package battle

import kotlin.random.Random


abstract class AbstractWarrior : Warrior{
	abstract val maximumHealth: Int
	abstract val accuracy: Int
	abstract val weapon: Weapons
	abstract var currentHealth: Int



	override fun getDamage(damage: Int) {
		currentHealth -= damage
	}

	override fun toString(): String {
	return "${this.javaClass.simpleName}${(this.hashCode()).toString().substring(2)} ($currentHealth hp)"
	}

}
