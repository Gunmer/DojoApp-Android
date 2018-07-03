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
    fun `should be 8 x n when n is the number of equals books`() {
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

    @Test
    fun `should be apply discount to two books whe basket has two distinct books and the others are the same type`() {
        val shoppingBasket = arrayOf(
                Book(BookType.PHILOSOPHERS_STONE),
                Book(BookType.PHILOSOPHERS_STONE),
                Book(BookType.CHAMBER_OF_SECRETS)
        )

        val price = cashRegister.calculatePriceOf(shoppingBasket)

        assertThat(price, `is`(23.2))

    }

    @Test
    fun `should be apply 10% of discount when basket has 3 distinct books`() {
        val shoppingBasket = arrayOf(
                Book(BookType.PHILOSOPHERS_STONE),
                Book(BookType.CHAMBER_OF_SECRETS),
                Book(BookType.PRISONER_OF_AZKABAN)
        )

        val price = cashRegister.calculatePriceOf(shoppingBasket)

        assertThat(price, `is`(21.6))
    }

    @Test
    fun `should be apply 20% of discount when basket has 4 distinct books`() {
        val shoppingBasket = arrayOf(
                Book(BookType.PHILOSOPHERS_STONE),
                Book(BookType.CHAMBER_OF_SECRETS),
                Book(BookType.PRISONER_OF_AZKABAN),
                Book(BookType.ORDER_OF_THE_PHOENIX)
        )

        val price = cashRegister.calculatePriceOf(shoppingBasket)

        assertThat(price, `is`(25.6))
    }

    @Test
    fun `should be apply 25% of discount when basket has 5 distinct books`() {
        val shoppingBasket = arrayOf(
                Book(BookType.PHILOSOPHERS_STONE),
                Book(BookType.CHAMBER_OF_SECRETS),
                Book(BookType.PRISONER_OF_AZKABAN),
                Book(BookType.ORDER_OF_THE_PHOENIX),
                Book(BookType.GOBLET_OF_FIRE)
        )

        val price = cashRegister.calculatePriceOf(shoppingBasket)

        assertThat(price, `is`(30.0))
    }

    @Test
    fun `should be apply 30% of discount when basket has 6 distinct books`() {
        val shoppingBasket = arrayOf(
                Book(BookType.PHILOSOPHERS_STONE),
                Book(BookType.CHAMBER_OF_SECRETS),
                Book(BookType.PRISONER_OF_AZKABAN),
                Book(BookType.ORDER_OF_THE_PHOENIX),
                Book(BookType.GOBLET_OF_FIRE),
                Book(BookType.HALF_BLOOD_PRINCE)
        )

        val price = cashRegister.calculatePriceOf(shoppingBasket)

        assertThat(price, `is`(33.6))
    }

    @Test
    fun `should be apply 35% of discount when basket has 7 distinct books`() {
        val shoppingBasket = arrayOf(
                Book(BookType.PHILOSOPHERS_STONE),
                Book(BookType.CHAMBER_OF_SECRETS),
                Book(BookType.PRISONER_OF_AZKABAN),
                Book(BookType.ORDER_OF_THE_PHOENIX),
                Book(BookType.GOBLET_OF_FIRE),
                Book(BookType.HALF_BLOOD_PRINCE),
                Book(BookType.DEATHLY_HALLOWS)
        )

        val price = cashRegister.calculatePriceOf(shoppingBasket)

        assertThat(price, `is`(36.4))
    }

    @Test
    fun `should be apply 5% of discount when basket has 7 distinct books`() {
        val shoppingBasket = arrayOf(
                Book(BookType.PRISONER_OF_AZKABAN),
                Book(BookType.ORDER_OF_THE_PHOENIX),
                Book(BookType.PRISONER_OF_AZKABAN),
                Book(BookType.ORDER_OF_THE_PHOENIX),
                Book(BookType.PRISONER_OF_AZKABAN),
                Book(BookType.ORDER_OF_THE_PHOENIX),
                Book(BookType.PRISONER_OF_AZKABAN),
                Book(BookType.ORDER_OF_THE_PHOENIX)
        )

        val price = cashRegister.calculatePriceOf(shoppingBasket)

        assertThat(price, `is`(12.2))
    }


}
