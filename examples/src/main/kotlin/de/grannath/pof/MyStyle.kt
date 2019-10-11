package de.grannath.pof

import de.grannath.pof.dsl.BodyArmour
import de.grannath.pof.dsl.Boots
import de.grannath.pof.dsl.Classes
import de.grannath.pof.dsl.Currency
import de.grannath.pof.dsl.FilterContext
import de.grannath.pof.dsl.Gloves
import de.grannath.pof.dsl.Helmets
import de.grannath.pof.dsl.Printable
import de.grannath.pof.dsl.atLeast
import de.grannath.pof.dsl.backgroundColor
import de.grannath.pof.dsl.baseTypes
import de.grannath.pof.dsl.borderColor
import de.grannath.pof.dsl.classes
import de.grannath.pof.dsl.fontSize
import de.grannath.pof.dsl.hide
import de.grannath.pof.dsl.highValueCurrency
import de.grannath.pof.dsl.hybridFlasksUpToLevel
import de.grannath.pof.dsl.lifeFlasksUpToLevel
import de.grannath.pof.dsl.lowValueCurrency
import de.grannath.pof.dsl.manaFlasksUpToLevel
import de.grannath.pof.dsl.midValueCurrency
import de.grannath.pof.dsl.orWhen
import de.grannath.pof.dsl.quality
import de.grannath.pof.dsl.rarities
import de.grannath.pof.dsl.scrolls
import de.grannath.pof.dsl.show
import de.grannath.pof.dsl.socketGroups
import de.grannath.pof.dsl.style
import de.grannath.pof.dsl.textColor
import de.grannath.pof.dsl.weapons
import de.grannath.pof.dsl.withStyle
import de.grannath.pof.model.Rarity
import de.grannath.pof.model.SocketGroup
import de.grannath.pof.model.SocketGroups

val baseStyle = style {
    fontSize(28)
}

val mediumHighlight = style(baseStyle) {
    fontSize(34)
}

val rareHighlight = style(mediumHighlight) {

}

val strongHighlight = style(baseStyle) {
    fontSize(34)
    borderColor(255, 0, 255)
}

val uniqueHighlight = style(strongHighlight) {

}

val topHighlight = style(baseStyle) {
    fontSize(38)
    borderColor(255, 0, 255)
    textColor(255, 0, 255)
}

val socketHighlight = style(baseStyle) {
    fontSize(38)
    borderColor(255, 0, 255)
}

val armourStyle = style(baseStyle) {

}

val weaponStyle = style(baseStyle) {

}

val currencyStyle = style(baseStyle) {
    backgroundColor(24, 24, 24)
    textColor(170, 158, 130)
}

val gemStyle = style(baseStyle) {

}

val flaskStyle = style(baseStyle) {

}

fun FilterContext.showCurrency() =
    show {
        classes(Classes.CURRENCY)

        withStyle(currencyStyle)

        orWhen {
            baseTypes(Currency.MIRROR_OF_KALANDRA)

            withStyle(topHighlight)
        }

        orWhen {
            baseTypes(highValueCurrency())

            withStyle(strongHighlight)
        }

        orWhen {
            baseTypes(midValueCurrency())

            withStyle(mediumHighlight)
        }

        orWhen {
            baseTypes(lowValueCurrency())
        }

        orWhen {
            baseTypes(scrolls())
        }
    }

fun FilterContext.showGems() =
    show {
        classes(Classes.ACTIVE_SKILL_GEMS, Classes.SUPPORT_SKILL_GEMS)

        withStyle(gemStyle)

        orWhen {
            quality(atLeast(1))

            withStyle(mediumHighlight)
        }
    }

fun FilterContext.showFlasks(minLevel: Int, vararg showTypes: Classes) =
    show {
        val flaskClasses = listOf(
            Classes.LIFE_FLASKS,
            Classes.MANA_FLASKS,
            Classes.HYBRID_FLASKS,
            Classes.UTILITY_FLASKS
        )

        classes(flaskClasses)

        withStyle(flaskStyle)

        show {
            quality(atLeast(1))

            withStyle(mediumHighlight)
        }

        hide {
            baseTypes(
                lifeFlasksUpToLevel(minLevel),
                manaFlasksUpToLevel(minLevel),
                hybridFlasksUpToLevel(minLevel)
            )
        }

        hide {
            classes(flaskClasses - showTypes)
        }
    }

fun FilterContext.highlightSockets(socketGroups: List<SocketGroup>) =
    socketGroups.forEach { highlightSockets(it) }

fun FilterContext.highlightSockets(socketGroup: SocketGroup?): Unit =
    if (socketGroup != null) orWhen {
        socketGroups(socketGroup)

        withStyle(socketHighlight)
    } else Unit

fun FilterContext.showWeapons(vararg favoriteWeapons: Classes): Unit =
    showWeapons(SocketGroups(), *favoriteWeapons)

fun FilterContext.showWeapons(
    socketGroup: SocketGroup,
    vararg favoriteWeapons: Classes
): Unit =
    showWeapons(SocketGroups(socketGroup), *favoriteWeapons)

fun FilterContext.showWeapons(
    socketGroups: SocketGroups,
    vararg favoriteWeapons: Classes
): Unit =
    show {
        withStyle(weaponStyle)

        show {
            classes(favoriteWeapons.toList())
            highlightSockets(socketGroups.groups)

            orWhen {
                rarities(Rarity.RARE)

                withStyle(rareHighlight)
                highlightSockets(socketGroups.groups)
            }

            orWhen {
                rarities(Rarity.UNIQUE)

                withStyle(uniqueHighlight)
                highlightSockets(socketGroups.groups)
            }
        }

        hide {
            classes(weapons() - favoriteWeapons.toList())

            show {
                rarities(Rarity.RARE)

                withStyle(rareHighlight)
            }

            show {
                rarities(Rarity.UNIQUE)

                withStyle(uniqueHighlight)
            }
        }
    }

fun FilterContext.showQuivers(
    socketGroup: SocketGroup? = null,
    show: Boolean = true
): Unit {
    val block: FilterContext.() -> Unit = {
        classes(Classes.QUIVERS)

        withStyle(weaponStyle)

        show {
            rarities(Rarity.RARE)

            withStyle(rareHighlight)
            highlightSockets(socketGroup)
        }

        show {
            rarities(Rarity.UNIQUE)

            withStyle(uniqueHighlight)
            highlightSockets(socketGroup)
        }

        highlightSockets(socketGroup)
    }

    if (show) show(block) else hide(block)
}

fun FilterContext.hideQuivers() =
    showQuivers(show = false)

fun FilterContext.showShields(
    socketGroup: SocketGroup? = null,
    show: Boolean = true
) {
    val block: FilterContext.() -> Unit = {
        classes(Classes.SHIELDS)

        withStyle(armourStyle)

        show {
            rarities(Rarity.RARE)

            withStyle(rareHighlight)
            highlightSockets(socketGroup)
        }

        show {
            rarities(Rarity.UNIQUE)

            withStyle(uniqueHighlight)
            highlightSockets(socketGroup)
        }

        highlightSockets(socketGroup)
    }

    if (show) show(block) else hide(block)
}

fun FilterContext.hideShields() =
    showShields(show = false)

fun FilterContext.showBodyArmours(vararg favoriteArmour: List<BodyArmour>) =
    showBodyArmours(SocketGroups(), *favoriteArmour)

fun FilterContext.showBodyArmours(
    socketGroup: SocketGroup,
    vararg favoriteArmour: List<BodyArmour>
) =
    showBodyArmours(SocketGroups(socketGroup), *favoriteArmour)

fun FilterContext.showBodyArmours(
    socketGroups: SocketGroups,
    vararg favoriteArmour: List<BodyArmour>
) =
    show {
        classes(Classes.BODY_ARMOURS)

        withStyle(armourStyle)

        showFavorites(socketGroups, favoriteArmour.asList().flatten())

        hideNonFavorites(socketGroups, favoriteArmour.toList().flatten())
    }



fun FilterContext.showHelmets(vararg favoriteHelmets: List<Helmets>) =
    showHelmets(SocketGroups(), *favoriteHelmets)

fun FilterContext.showHelmets(
    socketGroup: SocketGroup,
    vararg favoriteHelmets: List<Helmets>
) =
    showHelmets(SocketGroups(socketGroup), *favoriteHelmets)

fun FilterContext.showHelmets(
    socketGroups: SocketGroups,
    vararg favoriteHelmets: List<Helmets>
) =
    show {
        classes(Classes.HELMETS)

        withStyle(armourStyle)

        showFavorites(socketGroups, favoriteHelmets.asList().flatten())

        hideNonFavorites(socketGroups, favoriteHelmets.toList().flatten())
    }

fun FilterContext.showGloves(vararg favoriteGloves: List<Gloves>) =
    showGloves(SocketGroups(), *favoriteGloves)

fun FilterContext.showGloves(
    socketGroup: SocketGroup,
    vararg favoriteGloves: List<Gloves>
) =
    showGloves(SocketGroups(socketGroup), *favoriteGloves)

fun FilterContext.showGloves(
    socketGroups: SocketGroups,
    vararg favoriteGloves: List<Gloves>
) =
    show {
        classes(Classes.GLOVES)
        withStyle(armourStyle)

        showFavorites(socketGroups, favoriteGloves.asList().flatten())

        hideNonFavorites(socketGroups, favoriteGloves.toList().flatten())
    }

fun FilterContext.showBoots(vararg favoriteBoots: List<Boots>) =
    showBoots(SocketGroups(), *favoriteBoots)

fun FilterContext.showBoots(
    socketGroup: SocketGroup,
    vararg favoriteBoots: List<Boots>
) =
    showBoots(SocketGroups(socketGroup), *favoriteBoots)

fun FilterContext.showBoots(
    socketGroups: SocketGroups,
    vararg favoriteBoots: List<Boots>
) =
    show {
        classes(Classes.BOOTS)
        withStyle(armourStyle)

        showFavorites(socketGroups, favoriteBoots.asList().flatten())

        hideNonFavorites(socketGroups, favoriteBoots.toList().flatten())
    }


private inline fun <reified T> FilterContext.showFavorites(
    socketGroups: SocketGroups,
    favorites: List<T>
) where T : Printable
    =
    show {
        baseTypes(favorites)
        highlightSockets(socketGroups.groups)

        orWhen {
            rarities(Rarity.RARE)

            withStyle(rareHighlight)
            highlightSockets(socketGroups.groups)
        }

        orWhen {
            rarities(Rarity.UNIQUE)

            withStyle(uniqueHighlight)
            highlightSockets(socketGroups.groups)
        }
    }

private inline fun <reified T> FilterContext.hideNonFavorites(
    socketGroups: SocketGroups,
    favorites: List<T>
) where T : Printable,
        T : Enum<T>
    =
    hide {
        baseTypes(T::class.java.enumConstants.toList() - favorites)

        show {
            rarities(Rarity.RARE)

            withStyle(rareHighlight)
        }

        show {
            rarities(Rarity.UNIQUE)

            withStyle(uniqueHighlight)
        }
    }
