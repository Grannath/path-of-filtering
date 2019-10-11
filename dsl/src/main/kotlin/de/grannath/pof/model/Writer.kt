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
        throw IllegalStateException("Cannot write this filter because the top-level does not define show or hide.")
    }
}

private fun Filter.append(writer: Writer, parents: List<Filter>) {
    val fullParents = listOf(this) + parents
    children.forEach { it.append(writer, fullParents) }

    if (matchers.isNotEmpty()) {
        val totalShow =
            parents.foldRight(show, { it, sh -> sh ?: it.show }) ?: true

        writer.write(if (totalShow) "Show" else "Hide")
        writer.write("\n")

        matchers.append(writer, parents.map { it.matchers })

        style.append(writer, parents.map { it.style })

        writer.write("\n")
    } else {
        println("Skipping block with ${children.size} children but no matchers")
    }
}

private fun List<Matcher>.append(writer: Writer, parents: List<List<Matcher>>) {
    val all = this.toMutableList()
    parents.forEach { all.addAll(it) }

    println("Writing block with matchers:\n$all")

    all.filterIsInstance(ClassMatcher::class.java)
        .firstOrNull()
        ?.append(writer)
    all.filterIsInstance(BaseTypeMatcher::class.java)
        .firstOrNull()
        ?.append(writer)
    all.filterIsInstance(RarityMatcher::class.java)
        .firstOrNull()
        ?.append(writer)
    all.filterIsInstance(DropLevelMatcher::class.java)
        .firstOrNull()
        ?.append(writer)
    all.filterIsInstance(ItemLevelMatcher::class.java)
        .firstOrNull()
        ?.append(writer)
    all.filterIsInstance(QualityMatcher::class.java)
        .firstOrNull()
        ?.append(writer)
    all.filterIsInstance(SocketMatcher::class.java)
        .firstOrNull()
        ?.append(writer)
    all.filterIsInstance(LinkedSocketMatcher::class.java)
        .firstOrNull()
        ?.append(writer)
    all.filterIsInstance(SocketGroupMatcher::class.java)
        .firstOrNull()
        ?.append(writer)
}

private fun ClassMatcher.append(writer: Writer) {
    val value = classes.joinToString(
        prefix = "\"",
        postfix = "\"",
        separator = "\" \""
    )
    println("Adding class selection for classes:\n$value")
    writer.write("    Class $value\n")
}

private fun BaseTypeMatcher.append(writer: Writer) {
    val value = types.joinToString(
        prefix = "\"",
        postfix = "\"",
        separator = "\" \""
    )
    writer.write("    BaseType $value\n")
}

private fun RarityMatcher.append(writer: Writer) {
    writer.write("    Rarity ${rarities.joinToString(separator = " ") { it.printName }}\n")
}

private fun DropLevelMatcher.append(writer: Writer) {
    writer.write("    DropLevel ${op.symbol} $level\n")
}

private fun ItemLevelMatcher.append(writer: Writer) {
    writer.write("    ItemLevel ${op.symbol} $level\n")
}

private fun QualityMatcher.append(writer: Writer) {
    writer.write("    Quality ${op.symbol} $quality\n")
}

private fun SocketMatcher.append(writer: Writer) {
    writer.write("    Sockets ${op.symbol} $count\n")
}

private fun LinkedSocketMatcher.append(writer: Writer) {
    writer.write("    LinkedSockets ${op.symbol} $count\n")
}

private fun SocketGroupMatcher.append(writer: Writer) {
    fun SocketGroup.printName() =
        socketColors.joinToString("") { it.printName }

    val groups = socketGroups.joinToString(" ") { it.printName() }
    writer.write("    SocketGroup $groups\n")
}

private fun Style.append(writer: Writer, parents: List<Style>) {
    var total = this
    parents.forEach {
        total = total.copy(
            backgroundColor = total.backgroundColor ?: it.backgroundColor,
            borderColor = total.borderColor ?: it.borderColor,
            textColor = total.textColor ?: it.textColor,
            fontSize = total.fontSize ?: it.fontSize
        )
    }

    with(total) {
        if (backgroundColor != null) writer.write("    SetBackgroundColor $backgroundColor\n")
        if (borderColor != null) writer.write("    SetBorderColor $borderColor\n")
        if (textColor != null) writer.write("    SetTextColor $textColor\n")
        if (fontSize != null) writer.write("    SetFontSize $fontSize\n")
    }
}
