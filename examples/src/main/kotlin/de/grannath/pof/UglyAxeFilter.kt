package de.grannath.pof

import de.grannath.pof.dsl.Classes
import de.grannath.pof.dsl.dexBodyArmour
import de.grannath.pof.dsl.dexBoots
import de.grannath.pof.dsl.dexGloves
import de.grannath.pof.dsl.dexHelmets
import de.grannath.pof.dsl.dexIntBodyArmour
import de.grannath.pof.dsl.dexIntBoots
import de.grannath.pof.dsl.dexIntGloves
import de.grannath.pof.dsl.dexIntHelmets
import de.grannath.pof.dsl.filterFile
import de.grannath.pof.dsl.group
import de.grannath.pof.dsl.groups
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
import de.grannath.pof.dsl.withStyle
import de.grannath.pof.model.SocketColor

fun main(args: Array<String>) {
    filterFile("UglyAxe") {

        showCurrency()

        showGems()

        showFlasks(
            18,
            Classes.LIFE_FLASKS,
            Classes.MANA_FLASKS,
            Classes.HYBRID_FLASKS,
            Classes.UTILITY_FLASKS
        )

        showWeapons(
            group(
                SocketColor.RED,
                SocketColor.RED,
                SocketColor.RED,
                SocketColor.BLUE
            ),
            Classes.TWO_HAND_AXES
        )

        hideQuivers()

        hideShields()

        showBodyArmours(
            group(
                SocketColor.RED,
                SocketColor.RED,
                SocketColor.RED,
                SocketColor.GREEN
            ),
            strBodyArmour()
        )

        showHelmets(strHelmets())
        showGloves(strGloves())
        showBoots(strBoots())
    }

    filterFile("Wistina") {

        showCurrency()

        showGems()

        showFlasks(
            9,
            Classes.LIFE_FLASKS,
            Classes.MANA_FLASKS,
            Classes.HYBRID_FLASKS,
            Classes.UTILITY_FLASKS
        )

        showWeapons(
            group(
                SocketColor.GREEN,
                SocketColor.GREEN,
                SocketColor.GREEN,
                SocketColor.GREEN
            ),
            Classes.BOWS
        )

        showQuivers()

        hideShields()

        showBodyArmours(dexBodyArmour())

        showHelmets(dexHelmets())
        showGloves(dexGloves())
        showBoots(dexBoots())
    }

    filterFile("FantasticKnife") {

        showCurrency()

        showGems()

        showFlasks(
            18,
            Classes.LIFE_FLASKS,
            Classes.MANA_FLASKS,
            Classes.UTILITY_FLASKS
        )

        hideQuivers()

        hideShields()

        showBodyArmours(
            group(
                SocketColor.RED,
                SocketColor.GREEN,
                SocketColor.GREEN,
                SocketColor.GREEN,
                SocketColor.GREEN
            ),
            dexBodyArmour(),
            strDexBodyArmour()
        )

        val smallGroups = groups(
            group(
                SocketColor.GREEN,
                SocketColor.GREEN,
                SocketColor.RED,
                SocketColor.RED
            ),
            group(
                SocketColor.RED,
                SocketColor.RED,
                SocketColor.RED,
                SocketColor.GREEN
            ),
            group(
                SocketColor.RED,
                SocketColor.RED,
                SocketColor.BLUE,
                SocketColor.GREEN
            )
        )

        showWeapons(
            smallGroups,
            Classes.CLAWS
        )

        showHelmets(
            smallGroups,
            dexHelmets(),
            strDexHelmets()
        )
        showGloves(
            smallGroups,
            dexGloves(),
            strDexGloves()
        )
        showBoots(
            smallGroups,
            dexBoots(),
            strDexBoots()
        )
    }

    filterFile("PoisonousPoke") {

        show {
            socketGroups(group(SocketColor.RED, SocketColor.GREEN, SocketColor.BLUE))
            withStyle(strongHighlight)
        }

        showCurrency()

        showGems()

        showFlasks(
            40,
            Classes.LIFE_FLASKS,
            Classes.MANA_FLASKS,
            Classes.UTILITY_FLASKS
        )

        showQuivers()

        hideShields()

        val largeGroups = groups(
            group(
                SocketColor.GREEN,
                SocketColor.GREEN,
                SocketColor.GREEN,
                SocketColor.GREEN,
                SocketColor.GREEN
            )
        )

        val smallGroups = groups(
            group(
                SocketColor.GREEN,
                SocketColor.GREEN,
                SocketColor.BLUE,
                SocketColor.BLUE
            ),
            group(
                SocketColor.RED,
                SocketColor.RED,
                SocketColor.RED
            ),
            group(
                SocketColor.RED,
                SocketColor.RED,
                SocketColor.RED,
                SocketColor.BLUE
            )
        )

        showWeapons(
            largeGroups,
            Classes.BOWS
        )

        showBodyArmours(
            largeGroups,
            dexBodyArmour(),
            strDexBodyArmour(),
            dexIntBodyArmour()
        )
        showHelmets(
            smallGroups,
            dexHelmets(),
            strDexHelmets(),
            dexIntHelmets()
        )
        showGloves(
            smallGroups,
            dexGloves(),
            strDexGloves(),
            dexIntGloves()
        )
        showBoots(
            smallGroups,
            dexBoots(),
            strDexBoots(),
            dexIntBoots()
        )
    }
}
