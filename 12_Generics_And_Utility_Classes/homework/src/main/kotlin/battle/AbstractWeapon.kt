package battle

import Stack
import kotlin.random.Random

abstract class AbstractWeapon() {
	abstract val maximumAmmo: Int
	abstract val fireType: FireType
	abstract val cartridgeMagazine: Stack<Ammo>
	abstract val ammo: Ammo

	private fun createBullet(): Ammo = ammo

	fun reload() {
		repeat(maximumAmmo) {
			this.cartridgeMagazine.push(createBullet())
		}
	}

	fun takeAmmoForShot(): List<Ammo> {
		val ammoForShot = mutableListOf<Ammo>()
		if (!cartridgeMagazine.isEmpty() && cartridgeMagazine.getSize() > fireType.queueSize) {
			repeat(fireType.queueSize) {
				ammoForShot.add(createBullet())
				this.cartridgeMagazine.pop()
			}
		}
		return ammoForShot
	}
}
