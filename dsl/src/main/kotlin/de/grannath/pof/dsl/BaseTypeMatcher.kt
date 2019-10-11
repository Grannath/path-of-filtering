package de.grannath.pof.dsl

import de.grannath.pof.model.BaseTypeMatcher

fun FilterContext.baseTypeNames(vararg typeNames: List<String>) {
    val flatNames = typeNames.flatMap { it }.toMutableList()

    this.matchers.removeAll {
        if (it is BaseTypeMatcher) {
            flatNames.addAll(it.types)
            true
        } else {
            false
        }
    }

    if (flatNames.isNotEmpty()) {
        this.matchers.add(BaseTypeMatcher(flatNames))
    }
}

fun FilterContext.baseTypeNames(vararg typeNames: String) =
    baseTypeNames(typeNames.toList())

fun FilterContext.baseTypes(vararg baseTypes: List<Printable>) =
    baseTypeNames(baseTypes.flatMap { it }.map { it.printName })

fun FilterContext.baseTypes(vararg baseTypes: Printable) =
    baseTypes(baseTypes.toList())
