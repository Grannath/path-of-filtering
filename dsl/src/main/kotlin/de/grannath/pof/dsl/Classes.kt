package de.grannath.pof.dsl

enum class Classes(override val printName: String) : Printable {
    CLAWS("Claws"),
    DAGGERS("Daggers"),
    WANDS("Wands"),
    ONE_HAND_SWORDS("One Hand Swords"),
    THRUSTING_ONE_HAND_SWORDS("Thrusting One Hand Swords"),
    ONE_HAND_AXES("One Hand Axes"),
    ONE_HAND_MACES("One Hand Maces"),
    SCEPTRES("Sceptres"),
    BOWS("Bows"),
    STAVES("Staves"),
    TWO_HAND_SWORDS("Two Hand Swords"),
    TWO_HAND_AXES("Two Hand Axes"),
    TWO_HAND_MACES("Two Hand Maces"),
    SHIELDS("Shields"),
    GLOVES("Gloves"),
    BOOTS("Boots"),
    BODY_ARMOURS("Body Armours"),
    HELMETS("Helmets"),
    AMULETS("Amulets"),
    RINGS("Rings"),
    BELTS("Belts"),
    QUIVERS("Quivers"),
    LIFE_FLASKS("Life Flasks"),
    MANA_FLASKS("Mana Flasks"),
    HYBRID_FLASKS("Hybrid Flasks"),
    UTILITY_FLASKS("Utility Flasks"),
    CURRENCY("Currency"),
    STACKABLE_CURRENCY("Stackable Currency"),
    MAPS("Maps"),
    MAP_FRAGMENTS("Map Fragments"),
    DIVINATION_CARD("Divination Card"),
    ACTIVE_SKILL_GEMS("Active Skill Gems"),
    SUPPORT_SKILL_GEMS("Support Skill Gems"),
    JEWEL("Jewel"),
    QUEST_ITEMS("Quest Items"),
    FISHING_RODS("Fishing Rods"),
    HIDEOUT_DOODADS("Hideout Doodads"),
    MICROTRANSACTIONS("Microtransactions")
}

fun weapons() =
    listOf(
        Classes.CLAWS,
        Classes.DAGGERS,
        Classes.WANDS,
        Classes.ONE_HAND_SWORDS,
        Classes.THRUSTING_ONE_HAND_SWORDS,
        Classes.ONE_HAND_AXES,
        Classes.ONE_HAND_MACES,
        Classes.SCEPTRES,
        Classes.BOWS,
        Classes.STAVES,
        Classes.TWO_HAND_SWORDS,
        Classes.TWO_HAND_AXES,
        Classes.TWO_HAND_MACES
    )

fun oneHandWeapons() =
    listOf(
        Classes.CLAWS,
        Classes.DAGGERS,
        Classes.WANDS,
        Classes.ONE_HAND_SWORDS,
        Classes.THRUSTING_ONE_HAND_SWORDS,
        Classes.ONE_HAND_AXES,
        Classes.ONE_HAND_MACES,
        Classes.SCEPTRES
    )

fun twoHandWeapons() =
    listOf(
        Classes.STAVES,
        Classes.TWO_HAND_SWORDS,
        Classes.TWO_HAND_AXES,
        Classes.TWO_HAND_MACES
    )

fun armour() =
    listOf(
        Classes.GLOVES,
        Classes.BOOTS,
        Classes.BODY_ARMOURS,
        Classes.HELMETS
    )

fun jewelry() =
    listOf(
        Classes.AMULETS,
        Classes.RINGS,
        Classes.BELTS
    )

fun flasks() =
    listOf(
        Classes.LIFE_FLASKS,
        Classes.MANA_FLASKS,
        Classes.HYBRID_FLASKS,
        Classes.UTILITY_FLASKS
    )

fun skillGems() =
    listOf(
        Classes.ACTIVE_SKILL_GEMS,
        Classes.SUPPORT_SKILL_GEMS
    )
