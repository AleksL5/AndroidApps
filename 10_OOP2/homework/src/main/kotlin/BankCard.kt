abstract class BankCard(var balance: Double) {

	abstract fun deposit(count: Double)
	abstract fun pay(count: Double)
	abstract fun balanceGetInfo()
	abstract fun availableFundsGetInfo()

}