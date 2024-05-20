package battle

interface Warrior {
	var isKilled: Boolean
	val evasionChance: Int

	fun attack(warrior: Warrior)
	fun getDamage(){
	}
}