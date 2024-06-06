package org.example

import kotlinx.coroutines.*
import kotlin.random.asJavaRandom
import java.math.BigInteger
import java.util.*
import kotlin.concurrent.thread
import kotlin.system.measureTimeMillis
import kotlin.time.measureTime

private val zero = (0).toBigInteger()
private val one = (1).toBigInteger()

fun main() {
	runBlocking {
		val scope = CoroutineScope(Dispatchers.Default)

		val pro = scope.launch {
			progressBar()
		}

		val fib1 = scope.async {
			println(Fibonacci.take((100).toBigInteger()))
		}

		val fib2 = scope.async {
			try {
				withTimeout(2000) {
					println(Fibonacci.take((5555).toBigInteger()))
				}
			} catch (e: TimeoutCancellationException) {
				println(Thread.currentThread().name)
				println("Calculating timed out")

			}
		}

		val fib3 = scope.async {
			println(Fibonacci.take((150).toBigInteger()))
		}

		fib1.await()
		fib2.await()
		fib3.await()
		delay(3000)
		pro.cancel()
	}
}

object Fibonacci {
	suspend fun take(number: BigInteger): BigInteger {
		yield()
		delay(2000)
		if (number <= zero)
			println("Try another number")
		else tailFiboNumb(number)
		println(Thread.currentThread().name)
		return tailFiboNumb(number)
	}
}

private fun tailFiboNumb(n: BigInteger, a: BigInteger = zero, b: BigInteger = one): BigInteger =
	when (n) {
		zero -> a
		one -> b
		else -> tailFiboNumb(n - one, b, a + b)
	}

suspend fun progressBar() {
	thread {
		println("Start calculating! ")
		var progress: Int = 1
		while (progress != 0) {
			Thread.sleep(300)
			println("Calculating: $progress")
			progress++
		}
			println("Calculating ends")
			progress = 0
		}
	}

fun Int.toBigInteger(): BigInteger = BigInteger.valueOf(this.toLong())
