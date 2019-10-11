package de.grannath.pof.model

data class Filter(
    val show: Boolean? = null,
    val matchers: List<Matcher> = emptyList(),
    val style: Style = Style(),
    val children: List<Filter> = emptyList()
) {
    init {
        if (matchers.groupBy { it.javaClass }
                .any { it.value.size > 1 }) {
            throw IllegalArgumentException("Multiple matchers of the same type are not allowed.")
        }
    }
}

data class Color(
    val red: Int,
    val green: Int,
    val blue: Int,
    val alpha: Int
) {
    init {
        if (red < 0 || red > 255) {
            throw IllegalArgumentException("Invalid red value $red!")
        }
        if (green < 0 || green > 255) {
            throw IllegalArgumentException("Invalid green value $green!")
        }
        if (blue < 0 || blue > 255) {
            throw IllegalArgumentException("Invalid blue value $blue!")
        }
        if (alpha < 0 || alpha > 255) {
            throw IllegalArgumentException("Invalid alpha value $alpha!")
        }
    }

    override fun toString() = "$red $green $blue $alpha"
}

data class Style(
    val backgroundColor: Color? = null,
    val borderColor: Color? = null,
    val textColor: Color? = null,
    val fontSize: Int? = null
)

