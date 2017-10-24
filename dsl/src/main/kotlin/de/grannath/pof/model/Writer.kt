package de.grannath.pof.model

import java.io.Writer

fun Filter.append(writer: Writer) {
    if (show != null) {
        val parents = listOf(this)
        children.forEach { it.append(writer, parents) }

        writer.write(if (show) "Show" else "Hide")
        writer.write("\n")

        matchers.append(writer, emptyList())

        style.append(writer, emptyList())

        writer.write("\n")
    } else {
        copy(show = true).append(writer)
    }
}

private fun Filter.append(writer: Writer, parents: List<Filter>) {
    val fullParents = parents + this
    children.forEach { it.append(writer, fullParents) }

    val totalShow =
            parents.foldRight(show, { it, sh -> sh ?: it.show }) ?: true

    writer.write(if (totalShow) "Show" else "Hide")
    writer.write("\n")

    matchers.append(writer, parents.map { it.matchers })

    style.append(writer, parents.map { it.style })

    writer.write("\n")
}

private fun List<Matcher>.append(writer: Writer, parents: List<List<Matcher>>) {
    val all = ArrayList(this)
    parents.forEach { all.addAll(it) }

    all.filterIsInstance(ClassMatcher::class.java)
            .singleOrNull()
            ?.append(writer)
    all.filterIsInstance(BaseTypeMatcher::class.java)
            .singleOrNull()
            ?.append(writer)
    all.filterIsInstance(RarityMatcher::class.java)
            .singleOrNull()
            ?.append(writer)
    all.filterIsInstance(DropLevelMatcher::class.java)
            .singleOrNull()
            ?.append(writer)
    all.filterIsInstance(ItemLevelMatcher::class.java)
            .singleOrNull()
            ?.append(writer)
}

private fun ClassMatcher.append(writer: Writer) {
    val value = classes.joinToString(prefix = "\"",
                                     postfix = "\"",
                                     separator = "\" \"")
    writer.write("    Class $value\n")
}

private fun BaseTypeMatcher.append(writer: Writer) {
    val value = types.joinToString(prefix = "\"",
                                   postfix = "\"",
                                   separator = "\" \"")
    writer.write("    BaseType $value\n")
}

private fun RarityMatcher.append(writer: Writer) {
    writer.write("    Rarity ${rarity.printName}\n")
}

private fun DropLevelMatcher.append(writer: Writer) {
    writer.write("    DropLevel ${op.symbol} $level\n")
}

private fun ItemLevelMatcher.append(writer: Writer) {
    writer.write("    ItemLevel ${op.symbol} $level\n")
}

private fun Style.append(writer: Writer, parents: List<Style>) {
    var total = this
    parents.forEach {
        total = total.copy(
                backgroundColor = total.backgroundColor ?: it.backgroundColor,
                borderColor = total.borderColor ?: it.borderColor,
                textColor = total.textColor ?: it.textColor,
                fontSize = total.fontSize ?: it.fontSize)
    }

    with(total) {
        if (backgroundColor != null) writer.write("    BackgroundColor $backgroundColor\n")
        if (borderColor != null) writer.write("    BorderColor $borderColor\n")
        if (textColor != null) writer.write("    TextColor $textColor\n")
        if (fontSize != null) writer.write("    FontColor $fontSize\n")
    }
}
