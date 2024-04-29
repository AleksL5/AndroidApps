class CashBackCard(balance: Double = 5000.0, private val cashBackPercent: Double = 3.0) : BankCard(balance) {

	override fun deposit(count: Double) {
		balance += count
	}

	override fun pay(count: Double) {
		if (balance <= 0 && count > balance){
			println("Not enough money. Balance: $balance")
		}
		val cashBack = count * (cashBackPercent / 100)
		balance -= count
		balance += cashBack
		println("You pay $count. Balance: $balance")
	}

	override fun balanceGetInfo() {
		TODO("Not yet implemented")
	}

	override fun availableFundsGetInfo() {
		println("Balance: $balance")
		println("Cashback percent: $cashBackPercent")
	}
}