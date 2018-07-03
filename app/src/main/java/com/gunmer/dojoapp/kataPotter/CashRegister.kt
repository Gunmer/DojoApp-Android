package com.gunmer.dojoapp.kataPotter

class CashRegister {

    fun calculatePriceOf(shoppingBasket: Array<Book>): Double {
        val distinctList = shoppingBasket.distinctBy { it.type }
        val equalsList = shoppingBasket.filter { !distinctList.contains(it) }

        val discount = calculateDiscount(distinctList)

        val totalWithDiscount = distinctList.sumByDouble { applyDiscount(it, discount) }
        val totalWithoutDiscount = equalsList.sumByDouble { it.price }

        return  totalWithDiscount + totalWithoutDiscount
    }

    private fun calculateDiscount(distinctList: List<Book>): Double {
        return when (distinctList.size) {
            2 -> 0.05
            3 -> 0.1
            4 -> 0.2
            5 -> 0.25
            6 -> 0.3
            7 -> 0.35
            else -> 0.0
        }
    }

    private fun applyDiscount(book: Book, discount: Double) = book.price - book.price * discount
}
