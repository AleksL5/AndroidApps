package org.example

class TV(private val brand: String, private val tvModel: String, private val diagonalSize: Int) {
	private var isOn: Boolean = false
	private var isOff = true
	private var volumeLevel = 0
		set(value) {
			field = if (value > MAX_VOLUME) MAX_VOLUME
			else value
		}
	init {
		println("TV created. Brand: $brand, Model: $tvModel, Diagonal size: $diagonalSize.")
	}
	private val channelsList = Channels.shuffledList()
	private var currentChannel: Int = 0


	fun showInfo(){
		println("TV brand: $brand, model: $tvModel, Diagonal size: $diagonalSize, Number of channels: ${channelsList.size} ")
	}
	fun turnOn() {
		isOn = true
		isOff = false
		println("TV On")
	}

	fun turnOff() {
		isOff = true
		isOn = false
		println("TV Off")
	}

	fun volumeUp(value: Int) {
		volumeLevel += value
		println("Volume level: $volumeLevel")
	}

	fun volumeDown(value: Int) {
		volumeLevel -= value
		println("Volume level: $volumeLevel")
	}

	fun changeChannelByNumbers(value: Int) {
		if (isOn && value > channelsList.size || value < 0) {
			println("Channel: $value is incorrect. Try another channel")
			return
		} else if (isOff && value < channelsList.size && value > 0) {
			isOn = true
			isOff = false
			currentChannel = value
			println("TV On. Channel number: ${channelsList[value]}")
		} else if (isOff) {
			isOn = true
			isOff = false
			println("TV On. Try another channel")
		} else if (value > channelsList.size || value < 0) {
			println("Channel: $value is incorrect. Try another channel")
			return
		} else {
			println("Channel number: ${channelsList[value]}")
			currentChannel = value
		}
	}

	fun changeChannelByLongButtonUp(pressValue: Int) {
		if (isOff && (pressValue + currentChannel) < channelsList.size) {
			isOn = true
			isOff = false
			currentChannel += pressValue
			println("TV On. You press \"Plus\" button: $pressValue times. Channel number: ${channelsList[currentChannel]}")
		} else if (isOff && (pressValue + currentChannel) > channelsList.size) {
			isOn = true
			isOff = false
			currentChannel = (currentChannel + pressValue) - channelsList.size
			println("TV On. You press \"Plus\" button: $pressValue times. Channel number: ${channelsList[currentChannel]}")
		} else if (isOn && (pressValue + currentChannel) < channelsList.size) {
			currentChannel += pressValue
			println("You press \"Plus\" button: $pressValue times. Channel number: ${channelsList[currentChannel]}")
		} else {
			currentChannel = (currentChannel + pressValue) - channelsList.size
			println("You press \"Plus\" button: $pressValue times. Channel number: ${channelsList[currentChannel]}.")
		}
	}

	fun changeChannelByLongButtonDown(pressValue: Int) {
		if (isOff && (currentChannel - pressValue) < 0) {
			isOn = true
			isOff = false
			currentChannel = (currentChannel - pressValue) + channelsList.size
			println("TV On. You press \"Minus\" button: $pressValue times. Channel number: ${channelsList[currentChannel]}")
		} else if (isOff && (currentChannel - pressValue) > 0) {
			isOn = true
			isOff = false
			currentChannel -= pressValue
			println("TV On. You press \"Minus\" button: $pressValue times. Channel number: ${channelsList[currentChannel]}")
		} else if (isOn && (currentChannel - pressValue) < 0) {
			currentChannel = (currentChannel - pressValue) + channelsList.size
			println("You press \"Minus\" button: $pressValue times. Channel number: ${channelsList[currentChannel]}")
		} else {
			currentChannel -= pressValue
			println("You press \"Minus\" button: $pressValue times. Channel number: ${channelsList[currentChannel]}")
		}
	}
	companion object{
		const val MAX_VOLUME = 100
	}
}

