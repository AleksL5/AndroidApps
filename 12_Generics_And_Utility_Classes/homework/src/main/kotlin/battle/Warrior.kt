package battle

interface Warrior {
	val isKilled: Boolean
	val evasionChance: Int

	fun attack(warrior: AbstractWarrior)
	fun getDamage(damage: Int){}

}