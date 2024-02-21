package com.ubb.raiffaisen.thinktank.test.infra

import com.ubb.raiffaisen.thinktank.test.core.TestRepository
import javax.inject.Inject

// indiferent daca am  sau nu ceva in constructor, daca folosesc hilt trebuie sa
// am inject constructor
class TestRepositoryImpl @Inject constructor(

) : TestRepository{
    override fun multiplication(val1: Int, val2: Int): Int = val1 * val2

    override fun sum(val1: Int, val2: Int): Int = val1 + val2
}