package de.grannath.pof.dsl

import io.kotlintest.matchers.shouldEqual
import io.kotlintest.specs.StringSpec

class CartesianProductTest : StringSpec() {
    init {
        "works as expected" {
            listOf(
                listOf("A", "B", "C"),
                listOf("1", "2")
            ).cartesianProduct() shouldEqual
                listOf(
                    listOf("A", "1"),
                    listOf("A", "2"),
                    listOf("B", "1"),
                    listOf("B", "2"),
                    listOf("C", "1"),
                    listOf("C", "2")
                )
        }
    }
}
