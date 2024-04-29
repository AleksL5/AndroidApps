fun main() {
	val creditCard = CreditCard()
	val cashBackCard = CashBackCard(5000.0, 3.0)
	val increaseDepositCard = IncreaseDepositCard()
	creditCard.deposit(5000.0)
	creditCard.pay(11000.0)
	cashBackCard.availableFundsGetInfo()
	cashBackCard.pay(3000.0)
	cashBackCard.balance


	}
