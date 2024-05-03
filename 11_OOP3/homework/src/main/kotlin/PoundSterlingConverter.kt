class PoundSterlingConverter : CurrencyConverter {
	override val currencyCode = "Pounds"

	override fun convertRub(count: Int) {
		val poundsCount = count * 0.008696
		println("$count rubbles = $poundsCount $currencyCode")
	}
}