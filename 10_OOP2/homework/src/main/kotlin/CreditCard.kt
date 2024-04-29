class CreditCard(balance: Double = 5000.0, private val creditLimit: Double = 10000.0) : BankCard(balance) {
	private var creditMoney = creditLimit


	override fun deposit(count: Double) {
		val rest = (creditMoney + count) - creditLimit
		if (creditMoney == creditLimit) {
			balance += count
			println("Deposit: $count, Balance: $balance, Credit balance: $creditMoney")
		} else if (count + creditMoney > creditLimit) {
			creditMoney = creditLimit
			balance += rest
			println("Deposit: $count, Balance: $balance, Credit balance: $creditMoney")
		} else if (count + creditMoney < creditLimit){
			creditMoney += count
			println("Deposit: $count, Balance: $balance, Credit balance: $creditMoney")
		}
		else {
			balance += count
			println("Deposit: $count, Balance: $balance, Credit balance: $creditMoney")
		}
	}

	override fun pay(count: Double) {
		if (count < balance) {
			balance -= count
			println("You pay $count. Balance: $balance, Credit balance: $creditMoney")
		} else if (count > balance + creditMoney) {
			println("You want to pay $count. Not enough money. Balance: $balance, Credit balance: $creditMoney")
		} else if (count > balance || count < balance + creditMoney) {
			creditMoney -= (count - balance)
			balance = 0.0
			println("You pay $count. Balance: $balance, Credit balance: $creditMoney")
		}
	}

	override fun balanceGetInfo() {
		println("Balance: $balance")
	}

	override fun availableFundsGetInfo() {
		println("Credit card limit: $creditLimit\nCredit balance: $creditMoney\nBalance: $balance")
	}
}