package de.grannath.pof.dsl

enum class Currency(override val printName: String) : Printable {
    MIRROR_OF_KALANDRA("Mirror of Kalandra"),
    ETERNAL_ORB("Eternal Orb"),
    EXALTED_ORB("Exalted Orb"),
    DIVINE_ORB("Divine Orb"),
    REGAL_ORB("Regal Orb"),
    CHAOS_ORB("Chaos Orb"),
    ORB_OF_SCOURING("Orb of Scouring"),
    ORB_OF_REGRET("Orb of Regret"),
    ORB_OF_ALCHEMY("Orb of Alchemy"),
    CARTOGRAPHERS_CHISEL("Cartographer's Chisel"),
    ORB_OF_FUSING("Orb of Fusing"),
    JEWELLERS_ORB("Jeweller's Orb"),
    CHROMATIC_ORB("Chromatic Orb"),
    ORB_OF_CHANCE("Orb of Chance"),
    ORB_OF_ALTERATION("Orb of Alteration"),
    GEMCUTTERS_PRISM("Gemcutter's Prism"),
    BLESSED_ORB("Blessed Orb"),
    VAAL_ORB("Vaal Orb"),
    ORB_OF_TRANSMUTATION("Orb of Transmutation"),
    ORB_OF_AUGMENTATION("Orb of Augmentation"),
    ARMOURERS_SCRAP("Armourer's Scrap"),
    BLACKSMITHS_WHETSTONE("Blacksmith's Whetstone"),
    GLASSBLOWERS_BAUBLE("Glassblower's Bauble"),
    PORTAL_SCROLL("Portal Scroll"),
    SCROLL_OF_WISDOM("Scroll of Wisdom")
}

fun scrolls() =
    listOf(
        Currency.PORTAL_SCROLL,
        Currency.SCROLL_OF_WISDOM
    )

fun lowValueCurrency() =
    listOf(
        Currency.GLASSBLOWERS_BAUBLE,
        Currency.BLACKSMITHS_WHETSTONE,
        Currency.ARMOURERS_SCRAP,
        Currency.ORB_OF_AUGMENTATION,
        Currency.ORB_OF_TRANSMUTATION
    )

fun midValueCurrency() =
    listOf(
        Currency.VAAL_ORB,
        Currency.BLESSED_ORB,
        Currency.GEMCUTTERS_PRISM,
        Currency.ORB_OF_ALTERATION,
        Currency.ORB_OF_CHANCE,
        Currency.CHROMATIC_ORB,
        Currency.JEWELLERS_ORB,
        Currency.ORB_OF_FUSING,
        Currency.CARTOGRAPHERS_CHISEL,
        Currency.ORB_OF_ALCHEMY
    )

fun highValueCurrency() =
    listOf(
        Currency.ORB_OF_REGRET,
        Currency.ORB_OF_SCOURING,
        Currency.CHAOS_ORB,
        Currency.REGAL_ORB,
        Currency.DIVINE_ORB,
        Currency.EXALTED_ORB,
        Currency.ETERNAL_ORB,
        Currency.MIRROR_OF_KALANDRA
    )
