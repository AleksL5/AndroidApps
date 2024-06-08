package org.example

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.random.asJavaRandom
import java.math.BigInteger
import java.util.*
import kotlin.concurrent.thread
import kotlin.random.Random
import kotlin.system.measureTimeMillis
import kotlin.time.measureTime

fun main() {
	runBlocking {
		launch {
			var firstPlayerScore = 0
			var secondPlayerScore = 0

			var firstPlayerCards = getCards()
			var secondPlayerCards = getCards()

			println("First player cards: ")
			firstPlayerCards.forEach { println(it) }

			println("Second player cards: ")
			secondPlayerCards.forEach { println(it) }

			println("Game start!")
			Generator.flow().collect {value ->
				delay(300)
				println(value)
				firstPlayerCards.map { if (it.contains(value)) {
					println("First player match $value!")
					firstPlayerScore++
				} }
				secondPlayerCards.map { if (it.contains(value)) {
					println("Second player match $value!")
					secondPlayerScore++
				} }

				if (firstPlayerScore == 5 || secondPlayerScore == 5) {
					val winner = if (firstPlayerScore > secondPlayerScore) "First player" else "Second player"
					println("Congratulations! $winner Win!")
					cancel()
				}
			}
		}
		println("Welcome to Lotto game! First who collect five numbers won!")
	}
}

object Generator {
	fun flow(): Flow<Int> {
		return setNumbers.asFlow()
	}
}

fun getCards(): MutableList<List<Int>> {
	val setNumbers = (1..90).shuffled().toMutableList()
	val cards = mutableListOf<List<Int>>()
	var number = 0
	for (i in 0..2) {
		var array = mutableListOf<Int>()
		for (j in 0..8) {
			if (j < 5)
				array += setNumbers[number]
			else
				array += 0
			number++
		}
		cards.add(array.shuffled())
	}
	return cards
}

val setNumbers = (1..90).shuffled().toMutableList()



