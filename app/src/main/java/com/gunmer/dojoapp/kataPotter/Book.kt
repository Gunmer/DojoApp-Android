package com.gunmer.dojoapp.kataPotter

class Book(val price: Double) {

    var type: BookType? = null
    private set

    constructor(type: BookType) : this(8.0) {
        this.type = type
    }

}
