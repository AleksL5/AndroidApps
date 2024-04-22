


fun main() {
 val sony = TV("Sony", "Typhoon", 34 )
	sony.changeChannelByNumbers(3)
	sony.changeChannelByLongButtonDown(1)
	sony.volumeUp(120)
	sony.volumeDown(70)
	sony.turnOff()
	val lg = TV("LG", "Crystal", 42)
	lg.changeChannelByLongButtonDown(4)
	lg.changeChannelByLongButtonUp(5)
	lg.changeChannelByNumbers(1)
	lg.volumeUp(30)
	lg.turnOff()
}



