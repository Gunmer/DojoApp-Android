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

}
