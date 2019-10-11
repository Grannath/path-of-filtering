package de.grannath.pof.dsl

enum class LifeFlasks(override val printName: String, val level: Int) :
    Printable, Comparable<LifeFlasks> {
    SMALL_LIFE_FLASK("Small Life Flask", 1),
    MEDIUM_LIFE_FLASK("Medium Life Flask", 3),
    LARGE_LIFE_FLASK("Large Life Flask", 6),
    GREATER_LIFE_FLASK("Greater Life Flask", 12),
    GRAND_LIFE_FLASK("Grand Life Flask", 18),
    GIANT_LIFE_FLASK("Giant Life Flask", 24),
    COLOSSAL_LIFE_FLASK("Colossal Life Flask", 30),
    SACRED_LIFE_FLASK("Sacred Life Flask", 36),
    HALLOWED_LIFE_FLASK("Hallowed Life Flask", 42),
    SANCTIFIED_LIFE_FLASK("Sanctified Life Flask", 50),
    DIVINE_LIFE_FLASK("Divine Life Flask", 60),
    ETERNAL_LIFE_FLASK("Eternal Life Flask", 65),
}

fun lifeFlasksUpToLevel(level: Int) =
    LifeFlasks.values().filter { it.level < level }

fun lifeFlasksAtLeastWithLevel(level: Int) =
    LifeFlasks.values().filter { it.level >= level }

enum class ManaFlasks(override val printName: String, val level: Int) :
    Printable, Comparable<ManaFlasks> {
    SMALL_MANA_FLASK("Small Mana Flask", 1),
    MEDIUM_MANA_FLASK("Medium Mana Flask", 3),
    LARGE_MANA_FLASK("Large Mana Flask", 6),
    GREATER_MANA_FLASK("Greater Mana Flask", 12),
    GRAND_MANA_FLASK("Grand Mana Flask", 18),
    GIANT_MANA_FLASK("Giant Mana Flask", 24),
    COLOSSAL_MANA_FLASK("Colossal Mana Flask", 30),
    SACRED_MANA_FLASK("Sacred Mana Flask", 36),
    HALLOWED_MANA_FLASK("Hallowed Mana Flask", 42),
    SANCTIFIED_MANA_FLASK("Sanctified Mana Flask", 50),
    DIVINE_MANA_FLASK("Divine Mana Flask", 60),
    ETERNAL_MANA_FLASK("Eternal Mana Flask", 65),
}

fun manaFlasksUpToLevel(level: Int) =
    ManaFlasks.values().filter { it.level < level }

fun manaFlasksAtLeastWithLevel(level: Int) =
    ManaFlasks.values().filter { it.level >= level }

enum class HybridFlasks(override val printName: String, val level: Int) :
    Printable, Comparable<HybridFlasks> {
    SMALL_HYBRID_FLASK("Small Hybrid Flask", 10),
    MEDIUM_HYBRID_FLASK("Medium Hybrid Flask", 20),
    LARGE_HYBRID_FLASK("Large Hybrid Flask", 30),
    COLOSSAL_HYBRID_FLASK("Colossal Hybrid Flask", 40),
    SACRED_HYBRID_FLASK("Sacred Hybrid Flask", 50),
    HALLOWED_HYBRID_FLASK("Hallowed Hybrid Flask", 60),
}

fun hybridFlasksUpToLevel(level: Int) =
    HybridFlasks.values().filter { it.level < level }

fun hybridFlasksAtLeastWithLevel(level: Int) =
    HybridFlasks.values().filter { it.level >= level }

enum class UtilityFlasks(override val printName: String) : Printable {
    QUICKSILVER_FLASK("Quicksilver Flask"),
    BISMUTH_FLASK("Bismuth Flask"),
    STIBNITE_FLASK("Stibnite Flask"),
    AMETHYST_FLASK("Amethyst Flask"),
    RUBY_FLASK("Ruby Flask"),
    SAPPHIRE_FLASK("Sapphire Flask"),
    TOPAZ_FLASK("Topaz Flask"),
    SILVER_FLASK("Silver Flask"),
    AQUAMARINE_FLASK("Aquamarine Flask"),
    GRANITE_FLASK("Granite Flask"),
    JADE_FLASK("Jade Flask"),
    QUARTZ_FLASK("Quartz Flask"),
    SULPHUR_FLASK("Sulphur Flask"),
    BASALT_FLASK("Basalt Flask"),
    DIAMOND_FLASK("Diamond Flask"),
}
