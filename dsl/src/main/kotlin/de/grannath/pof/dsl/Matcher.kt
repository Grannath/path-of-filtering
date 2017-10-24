package de.grannath.pof.dsl

import de.grannath.pof.model.*

interface Printable {
    val printName: String
}

fun FilterContext.classNames(classNames: List<String>) {
    if (classNames.isEmpty()) {
        throw IllegalArgumentException("Provide at least one class name!")
    }

    if (this.matchers.any { it is ClassMatcher }) {
        throw IllegalStateException("Multiple class matchers!")
    }

    this.matchers.add(ClassMatcher(classNames))
}

fun FilterContext.classNames(vararg classNames: String) =
        classNames(classNames.toList())

fun FilterContext.classes(vararg classes: List<Printable>) =
        classNames(classes.flatMap { it }.map { it.printName })

fun FilterContext.classes(vararg classes: Printable) =
        classes(classes.toList())

fun FilterContext.baseTypeNames(typeNames: List<String>) {
    if (typeNames.isEmpty()) {
        throw IllegalArgumentException("Provide at least one type name!")
    }

    if (this.matchers.any { it is BaseTypeMatcher }) {
        throw IllegalStateException("Multiple base type matchers!")
    }

    this.matchers.add(BaseTypeMatcher(typeNames.toList()))
}

fun FilterContext.baseTypeNames(vararg typeNames: String) =
        baseTypeNames(typeNames.toList())

fun FilterContext.baseTypes(vararg baseTypes: List<Printable>) =
        baseTypeNames(baseTypes.flatMap { it }.map { it.printName })

fun FilterContext.baseTypes(vararg baseTypes: Printable) =
        baseTypes(baseTypes.toList())

fun FilterContext.rarity(rarity: Rarity) {
    if (this.matchers.any { it is RarityMatcher }) {
        throw IllegalStateException("Multiple rarity matchers!")
    }

    this.matchers.add(RarityMatcher(rarity))
}

fun upTo(level: Int) = level.to(Comp.UP_TO)
fun upToIncluding(level: Int) = level.to(Comp.UP_TO_INC)
fun atLeast(level: Int) = level.to(Comp.AT_LEAST)
fun atLeastIncluding(level: Int) = level.to(Comp.AT_LEAST_INC)
fun equalTo(level: Int) = level.to(Comp.EQ)

fun FilterContext.dropLevel(limit: Pair<Int, Comp>) {
    if (this.matchers.any { it is DropLevelMatcher }) {
        throw IllegalStateException("Multiple drop level matchers!")
    }

    this.matchers.add(DropLevelMatcher(limit))
}

fun FilterContext.itemLevel(limit: Pair<Int, Comp>) {
    if (this.matchers.any { it is ItemLevelMatcher }) {
        throw IllegalStateException("Multiple item level matchers!")
    }

    this.matchers.add(ItemLevelMatcher(limit))
}
