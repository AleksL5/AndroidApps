package org.example

import kotlin.random.Random

object Channels {
	private val channelsList = arrayListOf(
		"TV Spotlight",
		"TV Action",
		"TV Drama",
		"TV Thrillers",
		"TV Indies",
		"Classic Movies",
		"Pluto TV Movies",
		"TV Comedy",
		"TV Horror",
		"Black Cinema",
		"Paramount Movie Channel",
		"80s Rewind",
		"The Asylum",
		"Pluto TV Movies 2",
		"TV Romance",
		"TV Terror",
		"TV Documentaries",
		"MT Westerns",
		"TV Cult Films",
		"Gravitas Movies",
		"Pluto TV Sports",
		"PGA Tour",
		"TV Surf",
		"Pursuit Up",
		"Impact Wrestling",
		"Big Sky Conference",
		"Fox Sports",
		"Major League Soccer",
		"TV Winter Sports",
		"Fight",
		"Sports Grid",
		"NFL",
		"Stadium",
		"Red Bull TV",
		"Glory Kickboxing",
		"Eleven Sports"
	)


	fun shuffledList(): ArrayList<String>{
		val shuffledList = channelsList.shuffled()
		val randomCountList = shuffledList.take(Random.nextInt(5, shuffledList.size -1))
		val personalList = arrayListOf<String>()
		for (i in randomCountList.indices){
			personalList.add("$i - ${randomCountList[i]}")
		}
		println("Auto-tuning is complete. Number of channels: ${randomCountList.size}")
		personalList.forEach{ println(it) }
		return personalList
	}
}