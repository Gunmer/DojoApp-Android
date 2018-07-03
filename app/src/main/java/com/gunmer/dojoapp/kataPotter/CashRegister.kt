package com.gunmer.dojoapp.kataPotter

class CashRegister {

    fun calculatePriceOf(shoppingBasket: Array<Book>): Double {

        val distinctSize = shoppingBasket.distinctBy { it.type }.size

        val discount = when (distinctSize) {
            2 -> 0.05
            else -> 0.0
        }

        return shoppingBasket.sumByDouble { it.price - it.price * discount }
    }

}