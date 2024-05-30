package battle

sealed class FireType(val queueSize: Int) {
	object SingleShot : FireType(1)
	data class BurstingFire(val count: Int = 2) : FireType(count)
}