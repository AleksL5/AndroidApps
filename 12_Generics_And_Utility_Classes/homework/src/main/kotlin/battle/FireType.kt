package battle

sealed class FireType() {
	object SingleShot : FireType()
	val burstingFire = BurstingFire(3)
}