import CurrencyConverter

class DollarConverter : CurrencyConverter {
	override val currencyCode = "Dollars"

	override fun convertRub(count: Int) {
		val dollarsCount = count * 0.010863
		println("$count rubbles = $dollarsCount $currencyCode")
	}
}