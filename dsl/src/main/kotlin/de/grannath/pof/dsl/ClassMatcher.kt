package de.grannath.pof.dsl

import de.grannath.pof.model.ClassMatcher

fun FilterContext.classNames(vararg classNames: List<String>) {
    val flatNames = classNames.flatMap { it }.toMutableList()

    this.matchers.removeAll {
        if (it is ClassMatcher) {
            flatNames.addAll(it.classes)
            true
        } else {
            false
        }
    }

    if (flatNames.isNotEmpty()) {
        this.matchers.add(ClassMatcher(flatNames))
    }
}

fun FilterContext.classNames(vararg classNames: String) =
    classNames(classNames.toList())

fun FilterContext.classes(vararg classes: List<Printable>) =
    classNames(classes.flatMap { it }.map { it.printName })

fun FilterContext.classes(vararg classes: Printable) =
    classes(classes.toList())
