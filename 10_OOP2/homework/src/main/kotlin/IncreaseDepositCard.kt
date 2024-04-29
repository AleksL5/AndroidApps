class IncreaseDepositCard(balance: Double = 5000.0, private val increasePercent: Double = 5.0) : BankCard(balance) {



	override fun deposit(count: Double) {
		val countIncrease = count * (increasePercent / 100)
		balance += count + countIncrease
	}

	override fun pay(count: Double) {
		if (balance <= 0 && count > balance){
			println("Not enough money. Balance: $balance")
		}
		balance -= count
		println("You pay $count. Balance: $balance")
	}

	override fun balanceGetInfo() {
		TODO("Not yet implemented")
	}

	override fun availableFundsGetInfo() {
		println("Balance: $balance")
	}
}