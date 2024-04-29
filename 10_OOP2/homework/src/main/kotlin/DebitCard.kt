class DebitCard(balance: Double) : BankCard(balance) {

	override fun deposit(count: Double) {
	balance += count
	}

	override fun pay(count: Double) {
		if (balance <= 0 && count > balance){
			println("Not enough money. Balance: $balance")
		}
		balance -= count
		println("You pay $count. Balance: $balance")
	}

	override fun balanceGetInfo() {
		println("Balance: $balance")
	}

	override fun availableFundsGetInfo() {
		println("Balance: $balance")
	}
}