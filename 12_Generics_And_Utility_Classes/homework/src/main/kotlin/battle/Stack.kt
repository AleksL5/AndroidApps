class Stack<T>() {
	private val stack = mutableListOf<T>()

	fun push(item: T) {
		stack.add(item)
	}

	fun pop(): T? {
		return if (stack.isEmpty())
			null
		else stack.removeLast()
	}

	fun isEmpty(): Boolean = stack.isEmpty()
	fun getSize() = stack.size
	fun lastItem() = stack.last()

}
