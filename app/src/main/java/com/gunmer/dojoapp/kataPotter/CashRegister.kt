package com.gunmer.dojoapp.kataPotter

import java.util.*

class CashRegister {

    fun calculatePriceOf(shoppingBasket: Array<Book>): Double {
        var books = shoppingBasket.toMutableList()
        var totalWithDiscount = 0.0

        while (books.isNotEmpty()) {
            val distinctList = books.distinctBy { it.type }
            books = books.filter { !distinctList.contains(it) }.toMutableList()
            val discount = calculateDiscount(distinctList)
            totalWithDiscount += distinctList.sumByDouble { applyDiscount(it, discount) }
        }


        return  String.format(Locale.ENGLISH,"%.2f", totalWithDiscount).toDouble()
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
