package de.grannath.pof.model

data class Filter(val show: Boolean? = null,
                  val matchers: List<Matcher> = emptyList(),
                  val style: Style = Style(),
                  val children: List<Filter> = emptyList())

sealed class Matcher

data class ClassMatcher(val classes: List<String> = emptyList()) : Matcher()

data class BaseTypeMatcher(val types: List<String> = emptyList()) : Matcher()

enum class Rarity(val printName: String) {
    NORMAL("Normal"), MAGIC("Magic"), RARE("Rare"), UNIQUE("Unique")

}

data class RarityMatcher(val rarity: Rarity) : Matcher()

enum class Comp(val symbol: String) {
    UP_TO("<"), UP_TO_INC("<="), EQ("="), AT_LEAST(">"), AT_LEAST_INC(">=")
}

data class DropLevelMatcher(val level: Int, val op: Comp) : Matcher() {
    constructor(pair: Pair<Int, Comp>) : this(pair.first, pair.second)
}

data class ItemLevelMatcher(val level: Int, val op: Comp) : Matcher() {
    constructor(pair: Pair<Int, Comp>) : this(pair.first, pair.second)
}

data class Color(val red: Int,
                 val green: Int,
                 val blue: Int,
                 val alpha: Int) {
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

data class Style(val backgroundColor: Color? = null,
                 val borderColor: Color? = null,
                 val textColor: Color? = null,
                 val fontSize: Int? = null)

