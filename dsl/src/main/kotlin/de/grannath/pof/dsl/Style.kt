package de.grannath.pof.dsl

import de.grannath.pof.model.Color
import de.grannath.pof.model.Style

@FilterBuilder
class StyleContext
internal constructor(
    internal var backgroundColor: Color? = null,
    internal var borderColor: Color? = null,
    internal var textColor: Color? = null,
    internal var fontSize: Int? = null
)

private fun StyleContext.build() =
    Style(
        backgroundColor = backgroundColor,
        borderColor = borderColor,
        fontSize = fontSize,
        textColor = textColor
    )

fun style(create: StyleContext.() -> Unit): Style {
    val context = StyleContext()
    context.create()
    return context.build()
}

fun style(style: Style, create: StyleContext.() -> Unit): Style {
    val context = StyleContext(
        backgroundColor = style.backgroundColor,
        textColor = style.textColor,
        fontSize = style.fontSize,
        borderColor = style.borderColor
    )
    context.create()
    return context.build()
}

fun FilterContext.withStyle(create: StyleContext.() -> Unit) {
    val context = StyleContext()
    context.create()
    this.style = context.build()
}

fun FilterContext.withStyle(style: Style, create: StyleContext.() -> Unit) {
    val context = StyleContext(
        backgroundColor = style.backgroundColor,
        textColor = style.textColor,
        fontSize = style.fontSize,
        borderColor = style.borderColor
    )
    context.create()
    this.style = context.build()
}

fun FilterContext.withStyle(style: Style) {
    this.style = style
}

fun StyleContext.fontSize(size: Int) {
    if (size < 18 || size > 45) {
        throw IllegalArgumentException("Illegal font size $size!")
    }

    this.fontSize = size
}

fun StyleContext.backgroundColor(
    red: Int,
    green: Int,
    blue: Int,
    alpha: Int = 255
) {
    this.backgroundColor = Color(red, green, blue, alpha)
}

fun StyleContext.borderColor(
    red: Int,
    green: Int,
    blue: Int,
    alpha: Int = 255
) {
    this.borderColor = Color(red, green, blue, alpha)
}

fun StyleContext.textColor(red: Int, green: Int, blue: Int, alpha: Int = 255) {
    this.textColor = Color(red, green, blue, alpha)
}

fun StyleContext.inverted() {
    val oldBg = this.backgroundColor
    this.backgroundColor = this.textColor
    this.textColor = oldBg
}
