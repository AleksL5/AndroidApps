import java.util.Scanner
fun main() {
	val converters = object {
		val dollarConverter = DollarConverter()
		val poundSterlingConverter = PoundSterlingConverter()
		val ChineseYuanConverter = ChineseYuanConverter()
		fun get(currencyCode: String) {
			val sc = Scanner(System.`in`)
			println("How much money you want to exchange?")
			val count = sc.nextInt()
			when (currencyCode) {
				"D", "d" -> {
					val dollarConverter = DollarConverter()
					dollarConverter.convertRub(count)
				}

				"P", "p" -> {
					val poundSterlingConverter = PoundSterlingConverter()
					poundSterlingConverter.convertRub(count)
				}

				"Y", "y" -> {
					val chineseYuanConverter = ChineseYuanConverter()
					chineseYuanConverter.convertRub(count)
				}

				else -> {
					println("Yours currency type $currencyCode unknown. Please enter exchange rate value")
					val s = Scanner(System.`in`)
					val exchangeRate = s.nextDouble()
					val unknownCurrency = object : CurrencyConverter{
						override val currencyCode = currencyCode

						override fun convertRub(count: Int) {
							val moneysCount = count * exchangeRate
							println("$count rubbles = $moneysCount $currencyCode")
						}
					}
					unknownCurrency.convertRub(count)
				}
			}
		}
	}
	// Currency type examples: D - Dollars, P - Pounds, Y - Yuan
	converters.get("x")
}




