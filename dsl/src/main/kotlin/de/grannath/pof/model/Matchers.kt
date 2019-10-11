package de.grannath.pof.model

sealed class Matcher

data class ClassMatcher(val classes: List<String> = emptyList()) : Matcher()

data class BaseTypeMatcher(val types: List<String> = emptyList()) : Matcher()

enum class Rarity(val printName: String) {
    NORMAL("Normal"), MAGIC("Magic"), RARE("Rare"), UNIQUE("Unique")
}

data class RarityMatcher(val rarities: List<Rarity>) : Matcher()

enum class Comp(val symbol: String) {
    LOWER_THAN("<"), LOWER_THAN_INCL("<="), EQ("="), HIGHER_THAN(">"), HIGHER_THAN_INCL(
        ">="
    )
}

data class DropLevelMatcher(val level: Int, val op: Comp) : Matcher() {
    constructor(pair: Pair<Int, Comp>) : this(pair.first, pair.second)
}

data class ItemLevelMatcher(val level: Int, val op: Comp) : Matcher() {
    constructor(pair: Pair<Int, Comp>) : this(pair.first, pair.second)
}

data class QualityMatcher(val quality: Int, val op: Comp) : Matcher() {
    constructor(pair: Pair<Int, Comp>) : this(pair.first, pair.second)
}

data class SocketMatcher(val count: Int, val op: Comp) : Matcher() {
    constructor(pair: Pair<Int, Comp>) : this(pair.first, pair.second)
}

data class LinkedSocketMatcher(val count: Int, val op: Comp) : Matcher() {
    constructor(pair: Pair<Int, Comp>) : this(pair.first, pair.second)
}

enum class SocketColor(val printName: String) {
    RED("R"), GREEN("G"), BLUE("B"), WHITE("W")
}

data class SocketGroup(val socketColors: List<SocketColor>) {
    constructor(vararg socketColors: SocketColor) : this(socketColors.toList())
}

data class SocketGroups(val groups: List<SocketGroup>) {
    constructor(vararg groups: SocketGroup) : this(groups.toList())
}

data class SocketGroupMatcher(val socketGroups: List<SocketGroup>) : Matcher() {
    constructor(vararg socketGroups: SocketGroup) : this(socketGroups.toList())
}
