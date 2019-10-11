package de.grannath.pof.dsl

import de.grannath.pof.model.Comp

@DslMarker
annotation class FilterBuilder

fun lowerThan(level: Int) = level.to(Comp.LOWER_THAN)
fun upTo(level: Int) = level.to(Comp.LOWER_THAN_INCL)
fun atLeast(level: Int) = level.to(Comp.HIGHER_THAN_INCL)
fun higherThan(level: Int) = level.to(Comp.HIGHER_THAN)
fun equalTo(level: Int) = level.to(Comp.EQ)

interface Printable {
    val printName: String
}

fun <T> Collection<Collection<T>>.cartesianProduct() =
    fold(listOf(listOf<T>()),
         { acc, elem ->
             acc.map { prod -> elem.map { prod + it } }.flatten()
         })
