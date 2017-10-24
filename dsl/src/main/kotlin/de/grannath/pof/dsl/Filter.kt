package de.grannath.pof.dsl

import de.grannath.pof.model.Filter
import de.grannath.pof.model.Matcher
import de.grannath.pof.model.Style
import de.grannath.pof.model.append
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

@DslMarker
annotation class FilterBuilder

@FilterBuilder
class FilterContext
internal constructor(internal var show: Boolean? = null,
                     internal val matchers: MutableList<Matcher> = arrayListOf(),
                     internal var style: Style = Style(),
                     internal val children: MutableList<FilterContext> = arrayListOf())

private fun FilterContext.build(): Filter =
        Filter(show = show,
               children = children.map(FilterContext::build),
               matchers = matchers,
               style = style)

fun file(path: Path, create: FilterContext.() -> Unit) {
    val filter = FilterContext()
    filter.create()
    Files.newBufferedWriter(path).use { filter.build().append(it) }
}

fun file(path: String, create: FilterContext.() -> Unit) =
        file(Paths.get(path), create)

fun filterFile(name: String, create: FilterContext.() -> Unit) {
    val dir = Paths.get(System.getProperty("user.home"),
                        "Documents",
                        "My Games",
                        "Path of Exile")
    if (Files.exists(dir)) {
        file(dir.resolve(if (name.endsWith(".filter")) name else "$name.filter"),
             create)
    } else {
        throw IOException("Cannot find the 'Path of Exile' filter directory.")
    }
}

fun FilterContext.filter(create: FilterContext.() -> Unit) {
    val child = FilterContext()
    child.create()
    this.children.add(child)
}

fun FilterContext.show() {
    this.show = true
}

fun FilterContext.hide() {
    this.show = false
}
