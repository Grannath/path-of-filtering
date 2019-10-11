package de.grannath.pof.dsl

import de.grannath.pof.model.Filter
import de.grannath.pof.model.Matcher
import de.grannath.pof.model.Style
import de.grannath.pof.model.append
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

@FilterBuilder
abstract class FilterContext
internal constructor(
    internal var show: Boolean? = null,
    internal val matchers: MutableList<Matcher> = arrayListOf(),
    internal var style: Style = Style(),
    internal val children: MutableList<SubFilterContext> = arrayListOf()
)

private fun FilterContext.build(): Collection<Filter> =
    matchers.groupBy { it.javaClass }
        .values
        .cartesianProduct()
        .map {
            Filter(
                show = show,
                children = children.map(FilterContext::build).flatten(),
                matchers = it,
                style = style
            )
        }

@FilterBuilder
class RootFilterContext(
    show: Boolean = true,
    matchers: MutableList<Matcher> = arrayListOf(),
    style: Style = Style(),
    children: MutableList<SubFilterContext> = arrayListOf()
) : FilterContext(
    show,
    matchers,
    style,
    children
)

@FilterBuilder
class SubFilterContext(
    show: Boolean? = null,
    matchers: MutableList<Matcher> = arrayListOf(),
    style: Style = Style(),
    children: MutableList<SubFilterContext> = arrayListOf()
) : FilterContext(
    show,
    matchers,
    style,
    children
)

fun file(path: Path, create: RootFilterContext.() -> Unit) {
    val filter = RootFilterContext()
    filter.create()
    Files.newBufferedWriter(path).use { wr ->
        filter.build().forEach { it.append(wr) }
    }
}

fun file(path: String, create: RootFilterContext.() -> Unit) =
    file(Paths.get(path), create)

fun filterFile(name: String, create: RootFilterContext.() -> Unit) {
    val dir = Paths.get(
        System.getProperty("user.home"),
        "Documents",
        "My Games",
        "Path of Exile"
    )
    if (Files.exists(dir)) {
        file(
            dir.resolve(if (name.endsWith(".filter")) name else "$name.filter"),
            create
        )
    } else {
        throw IOException("Cannot find the 'Path of Exile' filter directory.")
    }
}

fun FilterContext.show(create: SubFilterContext.() -> Unit) {
    val child = SubFilterContext(show = true)
    child.create()
    this.children.add(child)
}

fun FilterContext.hide(create: SubFilterContext.() -> Unit) {
    val child = SubFilterContext(show = false)
    child.create()
    this.children.add(child)
}

fun FilterContext.orWhen(create: SubFilterContext.() -> Unit) {
    val child = SubFilterContext()
    child.create()
    this.children.add(child)
}

fun RootFilterContext.show() {
    this.show = true
}

fun RootFilterContext.hide() {
    this.show = false
}
