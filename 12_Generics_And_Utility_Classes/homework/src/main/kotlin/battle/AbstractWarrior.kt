package battle

abstract class AbstractWarrior : Warrior{
	abstract val maximumHealth: Int
	abstract val accuracy: Int
	abstract val weapon: Weapons
	abstract val currentHealth: Int


	override fun attack(warrior: AbstractWarrior) {
	}

	override fun getDamage(damage: Int) {
		this.currentHealth - damage
	}
}
