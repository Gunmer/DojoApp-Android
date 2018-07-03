package com.gunmer.dojoapp.kataPotter

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class CashRegisterTest {

    //SUT
    private val cashRegister = CashRegister()

    @Test
    fun `should be 8 when the basket have one book`() {
        //Arrange
        val shoppingBasket = arrayOf(Book(BookType.PHILOSOPHERS_STONE))

        //Act
        val price = cashRegister.calculatePriceOf(shoppingBasket)

        //Assert
        assertThat(price, `is`(8.0))
    }

    @Test
    fun`should be 8 x n when n is the number of equals books`() {
        val n = 400

        val shoppingBasket = mutableListOf<Book>()
        for (i in 1..n) {
            shoppingBasket.add(Book(BookType.PHILOSOPHERS_STONE))
        }

        val price = cashRegister.calculatePriceOf(shoppingBasket.toTypedArray())

        assertThat(price, `is`(8.0 * n))
    }

    @Test
    fun `should be apply 5% of discount when basket has 2 distinct books`() {
        val shoppingBasket = arrayOf(Book(BookType.PHILOSOPHERS_STONE), Book(BookType.CHAMBER_OF_SECRETS))

        val price = cashRegister.calculatePriceOf(shoppingBasket)

        assertThat(price, `is`(15.2))
    }

}
