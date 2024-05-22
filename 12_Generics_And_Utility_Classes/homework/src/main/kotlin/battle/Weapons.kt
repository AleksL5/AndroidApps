package battle

object Weapons {
	val createSniperRifle = object : AbstractWeapon(){
		override val maximumAmmo = 10
		override val fireType = FireType.SingleShot
		override val ammo = Ammo.SNIPERRIFLEAMMO
	}
	val createMachineGun = object : AbstractWeapon(){
		override val maximumAmmo = 20
		override val fireType = FireType.BurstingFire(3)
		override val ammo = Ammo.MACHINEGUNAMMO
	}
	val createShotGun = object : AbstractWeapon(){
		override val maximumAmmo = 8
		override val fireType = FireType.SingleShot
		override val ammo = Ammo.SHOTGUNAMMO
	}
	val createRevolver = object : AbstractWeapon(){
		override val maximumAmmo = 7
		override val fireType = FireType.SingleShot
		override val ammo = Ammo.REVOLVERAMMO
	}

}