package de.grannath.pof.dsl

import de.grannath.pof.model.Comp
import de.grannath.pof.model.DropLevelMatcher
import de.grannath.pof.model.ItemLevelMatcher
import de.grannath.pof.model.LinkedSocketMatcher
import de.grannath.pof.model.Matcher
import de.grannath.pof.model.QualityMatcher
import de.grannath.pof.model.Rarity
import de.grannath.pof.model.RarityMatcher
import de.grannath.pof.model.SocketColor
import de.grannath.pof.model.SocketGroup
import de.grannath.pof.model.SocketGroupMatcher
import de.grannath.pof.model.SocketGroups
import de.grannath.pof.model.SocketMatcher

fun FilterContext.rarities(vararg rarities: Rarity) {
    val list = rarities.toMutableList()
    this.matchers.removeAll {
        if (it is RarityMatcher) {
            list.addAll(it.rarities)
            true
        } else {
            false
        }
    }

    if (list.isNotEmpty()) {
        this.matchers.add(RarityMatcher(list))
    }
}

@FilterBuilder
class LimitContext(
    private val filterContext: FilterContext,
    private val matcherBuilder: (Pair<Int, Comp>) -> Matcher
) {
    fun or(limit: Pair<Int, Comp>): LimitContext {
        filterContext.matchers.add(matcherBuilder(limit))
        return this
    }
}

fun FilterContext.dropLevel(limit: Pair<Int, Comp>): LimitContext {
    if (this.matchers.any { it is DropLevelMatcher }) {
        throw IllegalStateException("Multiple drop level matchers!")
    }

    this.matchers.add(DropLevelMatcher(limit))
    return LimitContext(this, ::DropLevelMatcher)
}

fun FilterContext.itemLevel(limit: Pair<Int, Comp>): LimitContext {
    if (this.matchers.any { it is ItemLevelMatcher }) {
        throw IllegalStateException("Multiple item level matchers!")
    }

    this.matchers.add(ItemLevelMatcher(limit))
    return LimitContext(this, ::ItemLevelMatcher)
}

fun FilterContext.quality(limit: Pair<Int, Comp>): LimitContext {
    if (this.matchers.any { it is QualityMatcher }) {
        throw IllegalStateException("Multiple quality matchers!")
    }

    this.matchers.add(QualityMatcher(limit))
    return LimitContext(this, ::QualityMatcher)
}

fun FilterContext.sockets(limit: Pair<Int, Comp>): LimitContext {
    if (this.matchers.any { it is SocketMatcher }) {
        throw IllegalStateException("Multiple socket matchers!")
    }

    this.matchers.add(SocketMatcher(limit))
    return LimitContext(this, ::QualityMatcher)
}

fun FilterContext.linkedSockets(limit: Pair<Int, Comp>): LimitContext {
    if (this.matchers.any { it is LinkedSocketMatcher }) {
        throw IllegalStateException("Multiple linked socket matchers!")
    }

    this.matchers.add(LinkedSocketMatcher(limit))
    return LimitContext(this, ::LinkedSocketMatcher)
}

fun group(vararg colors: SocketColor) =
    SocketGroup(colors.toList())

fun groups(vararg groups: SocketGroup) =
    SocketGroups(groups.toList())

fun FilterContext.socketGroups(vararg groups: SocketGroup) {
    val list = groups.toMutableList()
    this.matchers.removeAll {
        if (it is SocketGroupMatcher) {
            list.addAll(it.socketGroups)
            true
        } else {
            false
        }
    }

    if (list.isNotEmpty()) {
        this.matchers.add(SocketGroupMatcher(list))
    }
}
