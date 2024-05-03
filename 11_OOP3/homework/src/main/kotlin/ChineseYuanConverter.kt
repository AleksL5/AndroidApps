class ChineseYuanConverter : CurrencyConverter {
	override val currencyCode = "Yuan"

	override fun convertRub(count: Int) {
		val yuanCount = count * 0.078851
		println("$count rubbles = $yuanCount $currencyCode")
	}
}