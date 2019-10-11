package de.grannath.pof.foo

import de.grannath.pof.dsl.Boots
import de.grannath.pof.dsl.Classes
import de.grannath.pof.dsl.atLeast
import de.grannath.pof.dsl.backgroundColor
import de.grannath.pof.dsl.baseTypes
import de.grannath.pof.dsl.borderColor
import de.grannath.pof.dsl.classes
import de.grannath.pof.dsl.dexBodyArmour
import de.grannath.pof.dsl.dexBoots
import de.grannath.pof.dsl.dexGloves
import de.grannath.pof.dsl.dexHelmets
import de.grannath.pof.dsl.dexIntBodyArmour
import de.grannath.pof.dsl.dexIntBoots
import de.grannath.pof.dsl.dexIntGloves
import de.grannath.pof.dsl.dexIntHelmets
import de.grannath.pof.dsl.filterFile
import de.grannath.pof.dsl.fontSize
import de.grannath.pof.dsl.group
import de.grannath.pof.dsl.hide
import de.grannath.pof.dsl.highValueCurrency
import de.grannath.pof.dsl.intBodyArmour
import de.grannath.pof.dsl.intBoots
import de.grannath.pof.dsl.intGloves
import de.grannath.pof.dsl.intHelmets
import de.grannath.pof.dsl.inverted
import de.grannath.pof.dsl.lifeFlasksUpToLevel
import de.grannath.pof.dsl.linkedSockets
import de.grannath.pof.dsl.lowValueCurrency
import de.grannath.pof.dsl.manaFlasksUpToLevel
import de.grannath.pof.dsl.midValueCurrency
import de.grannath.pof.dsl.orWhen
import de.grannath.pof.dsl.quality
import de.grannath.pof.dsl.rarities
import de.grannath.pof.dsl.scrolls
import de.grannath.pof.dsl.show
import de.grannath.pof.dsl.socketGroups
import de.grannath.pof.dsl.strBodyArmour
import de.grannath.pof.dsl.strBoots
import de.grannath.pof.dsl.strDexBodyArmour
import de.grannath.pof.dsl.strDexBoots
import de.grannath.pof.dsl.strDexGloves
import de.grannath.pof.dsl.strDexHelmets
import de.grannath.pof.dsl.strGloves
import de.grannath.pof.dsl.strHelmets
import de.grannath.pof.dsl.strIntBodyArmour
import de.grannath.pof.dsl.strIntBoots
import de.grannath.pof.dsl.strIntGloves
import de.grannath.pof.dsl.strIntHelmets
import de.grannath.pof.dsl.style
import de.grannath.pof.dsl.textColor
import de.grannath.pof.dsl.weapons
import de.grannath.pof.dsl.withStyle
import de.grannath.pof.model.Rarity
import de.grannath.pof.model.SocketColor

private val armourStyle = style {

}

private val strStyle = style(armourStyle) {
    borderColor(230, 0, 0)
}

private val dexStyle = style(armourStyle) {
    borderColor(0, 204, 0)
}

private val intStyle = style(armourStyle) {
    borderColor(0, 0, 255)
}

private val strDexStyle = style(armourStyle) {
    borderColor(230, 92, 0)
}

private val strIntStyle = style(armourStyle) {
    borderColor(230, 0, 255)
}

private val dexIntStyle = style(armourStyle) {
    borderColor(0, 204, 255)
}

private val weaponStyle = style {

}

private val currencyStyle = style {
    backgroundColor(24, 24, 24)
    textColor(170, 158, 130)
}

private val gemStyle = style {

}

private val flaskStyle = style {

}

fun main(args: Array<String>) {
    filterFile("testfilter.filter") {
        show()

        withStyle {
            fontSize(28)
        }

        // Currrency
        show {
            classes(Classes.CURRENCY)

            withStyle(currencyStyle)

            orWhen {
                baseTypes(scrolls())
            }

            orWhen {
                baseTypes(lowValueCurrency())
            }

            orWhen {
                baseTypes(midValueCurrency())

                withStyle {
                    fontSize(32)
                }
            }

            orWhen {
                baseTypes(highValueCurrency())

                withStyle(currencyStyle) {
                    inverted()
                    fontSize(36)
                }
            }
        }

        // Gems
        show {
            classes(Classes.ACTIVE_SKILL_GEMS, Classes.SUPPORT_SKILL_GEMS)

            withStyle(gemStyle)

            orWhen {
                quality(atLeast(1))
                withStyle(gemStyle) {
                    inverted()
                    fontSize(36)
                }
            }
        }

        // Flasks
        show {
            classes(
                Classes.LIFE_FLASKS,
                Classes.MANA_FLASKS,
                Classes.HYBRID_FLASKS,
                Classes.UTILITY_FLASKS
            )

            withStyle(flaskStyle)

            show {
                quality(atLeast(1))
                withStyle(flaskStyle) {
                    inverted()
                    fontSize(36)
                }
            }

            hide {
                baseTypes(
                    lifeFlasksUpToLevel(40),
                    manaFlasksUpToLevel(99)
                )
            }
        }

        //
        // Weapons
        //

        show {
            classes(Classes.THRUSTING_ONE_HAND_SWORDS, Classes.ONE_HAND_SWORDS)

            withStyle(weaponStyle)

            orWhen {
                socketGroups(
                    group(
                        SocketColor.RED,
                        SocketColor.RED,
                        SocketColor.RED
                    ),
                    group(
                        SocketColor.GREEN,
                        SocketColor.GREEN,
                        SocketColor.GREEN
                    )
                )

                withStyle(weaponStyle) {
                    inverted()
                    fontSize(40)
                }
            }
        }

        hide {
            classes(
                weapons()
                    - Classes.THRUSTING_ONE_HAND_SWORDS
                    - Classes.ONE_HAND_SWORDS
            )

            withStyle(weaponStyle)

            show {
                rarities(Rarity.RARE, Rarity.UNIQUE)
            }
        }

        hide {
            classes(Classes.QUIVERS)

            withStyle(weaponStyle)

            show {
                rarities(Rarity.RARE, Rarity.UNIQUE)
            }
        }

        //
        // Armour
        //

        hide {
            classes(Classes.SHIELDS)

            withStyle(armourStyle)

            show {
                rarities(Rarity.RARE, Rarity.UNIQUE)
            }
        }

        // STR
        show {
            baseTypes(
                strBodyArmour(),
                strHelmets(),
                strGloves(),
                strBoots()
            )

            withStyle(strStyle)

            show {
                classes(Classes.BODY_ARMOURS)
                socketGroups(
                    group(
                        SocketColor.GREEN,
                        SocketColor.RED,
                        SocketColor.RED,
                        SocketColor.RED,
                        SocketColor.RED,
                        SocketColor.RED
                    )
                )

                withStyle(strStyle) {
                    inverted()
                    fontSize(40)
                }
            }

            show {
                classes(Classes.HELMETS, Classes.GLOVES, Classes.BOOTS)
                socketGroups(
                    group(
                        SocketColor.GREEN,
                        SocketColor.RED,
                        SocketColor.RED,
                        SocketColor.RED
                    ),
                    group(
                        SocketColor.GREEN,
                        SocketColor.BLUE,
                        SocketColor.BLUE,
                        SocketColor.BLUE
                    )
                )

                withStyle(strStyle) {
                    inverted()
                    fontSize(40)
                }
            }

            show {
                linkedSockets(atLeast(5))

                withStyle {
                    fontSize(36)
                }
            }
        }

        // DEX
        show {
            baseTypes(
                dexBodyArmour(),
                dexHelmets(),
                dexGloves(),
                dexBoots()
            )

            withStyle(dexStyle)

            show {
                classes(Classes.BODY_ARMOURS)
                socketGroups(
                    group(
                        SocketColor.GREEN,
                        SocketColor.RED,
                        SocketColor.RED,
                        SocketColor.RED,
                        SocketColor.RED,
                        SocketColor.RED
                    )
                )

                withStyle(dexStyle) {
                    inverted()
                    fontSize(40)
                }
            }

            show {
                baseTypes(dexHelmets(), dexGloves(), dexBoots())
                socketGroups(
                    group(
                        SocketColor.GREEN,
                        SocketColor.RED,
                        SocketColor.RED,
                        SocketColor.RED
                    ),
                    group(
                        SocketColor.GREEN,
                        SocketColor.BLUE,
                        SocketColor.BLUE,
                        SocketColor.BLUE
                    )
                )

                withStyle(dexStyle) {
                    inverted()
                    fontSize(40)
                }
            }

            show {
                linkedSockets(atLeast(5))

                withStyle {
                    fontSize(36)
                }
            }
        }

        // INT
        hide {
            baseTypes(
                intBodyArmour(),
                intHelmets(),
                intGloves(),
                intBoots()
            )

            withStyle(intStyle)

            show {
                linkedSockets(atLeast(5))

                withStyle {
                    fontSize(36)
                }
            }
            show {
                rarities(Rarity.RARE, Rarity.UNIQUE)
            }
        }

        // STR/DEX
        show {
            baseTypes(
                strDexBodyArmour(),
                strDexHelmets(),
                strDexGloves(),
                strDexBoots() + Boots.TWO_TONED_BOOTS
            )

            withStyle(strDexStyle)

            show {
                classes(Classes.BODY_ARMOURS)
                socketGroups(
                    group(
                        SocketColor.GREEN,
                        SocketColor.RED,
                        SocketColor.RED,
                        SocketColor.RED,
                        SocketColor.RED,
                        SocketColor.RED
                    )
                )

                withStyle(strDexStyle) {
                    inverted()
                    fontSize(40)
                }
            }

            show {
                baseTypes(
                    strDexHelmets(),
                    strDexGloves(),
                    strDexBoots() + Boots.TWO_TONED_BOOTS
                )
                socketGroups(
                    group(
                        SocketColor.GREEN,
                        SocketColor.RED,
                        SocketColor.RED,
                        SocketColor.RED
                    ),
                    group(
                        SocketColor.GREEN,
                        SocketColor.BLUE,
                        SocketColor.BLUE,
                        SocketColor.BLUE
                    )
                )

                withStyle(strDexStyle) {
                    inverted()
                    fontSize(40)
                }
            }

            show {
                linkedSockets(atLeast(5))

                withStyle {
                    fontSize(36)
                }
            }
        }

        // STR/INT
        hide {
            baseTypes(
                strIntBodyArmour(),
                strIntHelmets(),
                strIntGloves(),
                strIntBoots()
            )

            withStyle(strIntStyle)

            show {
                linkedSockets(atLeast(5))

                withStyle {
                    fontSize(36)
                }
            }
            show {
                rarities(Rarity.RARE, Rarity.UNIQUE)
            }
        }

        // DEX/INT
        hide {
            baseTypes(
                dexIntBodyArmour(),
                dexIntHelmets(),
                dexIntGloves(),
                dexIntBoots()
            )

            withStyle(dexIntStyle)

            show {
                linkedSockets(atLeast(5))

                withStyle {
                    fontSize(36)
                }
            }
            show {
                rarities(Rarity.RARE, Rarity.UNIQUE)
            }
        }
    }
}
