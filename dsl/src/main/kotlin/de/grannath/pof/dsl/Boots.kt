package de.grannath.pof.dsl

enum class Boots(override val printName: String) : Printable {
    // STR
    IRON_GREAVES("Iron Greaves"),
    STEEL_GREAVES("Steel Greaves"),
    PLATED_GREAVES("Plated Greaves"),
    REINFORCED_GREAVES("Reinforced Greaves"),
    ANTIQUE_GREAVES("Antique Greaves"),
    ANCIENT_GREAVES("Ancient Greaves"),
    GOLIATH_GREAVES("Goliath Greaves"),
    VAAL_GREAVES("Vaal Greaves"),
    TITAN_GREAVES("Titan Greaves"),
    // DEX
    RAWHIDE_BOOTS("Rawhide Boots"),
    GOATHIDE_BOOTS("Goathide Boots"),
    DEERSKIN_BOOTS("Deerskin Boots"),
    NUBUCK_BOOTS("Nubuck Boots"),
    EELSKIN_BOOTS("Eelskin Boots"),
    SHARKSKIN_BOOTS("Sharkskin Boots"),
    SHAGREEN_BOOTS("Shagreen Boots"),
    STEALTH_BOOTS("Stealth Boots"),
    SLINK_BOOTS("Slink Boots"),
    // INT
    WOOL_SHOES("Wool Shoes"),
    VELVET_SLIPPERS("Velvet Slippers"),
    SILK_SLIPPERS("Silk Slippers"),
    SCHOLAR_BOOTS("Scholar Boots"),
    SATIN_SLIPPERS("Satin Slippers"),
    SAMITE_SLIPPERS("Samite Slippers"),
    CONJURER_BOOTS("Conjurer Boots"),
    ARCANIST_SLIPPERS("Arcanist Slippers"),
    SORCERER_BOOTS("Sorcerer Boots"),
    // STR/DEX
    LEATHERSCALE_BOOTS("Leatherscale Boots"),
    IRONSCALE_BOOTS("Ironscale Boots"),
    BRONZESCALE_BOOTS("Bronzescale Boots"),
    STEELSCALE_BOOTS("Steelscale Boots"),
    SERPENTSCALE_BOOTS("Serpentscale Boots"),
    WYRMSCALE_BOOTS("Wyrmscale Boots"),
    HYDRASCALE_BOOTS("Hydrascale Boots"),
    DRAGONSCALE_BOOTS("Dragonscale Boots"),
    // STR/INT
    CHAIN_BOOTS("Chain Boots"),
    RINGMAIL_BOOTS("Ringmail Boots"),
    MESH_BOOTS("Mesh Boots"),
    RIVETED_BOOTS("Riveted Boots"),
    ZEALOT_BOOTS("Zealot Boots"),
    SOLDIER_BOOTS("Soldier Boots"),
    LEGION_BOOTS("Legion Boots"),
    CRUSADER_BOOTS("Crusader Boots"),
    // DEX/INT
    WRAPPED_BOOTS("Wrapped Boots"),
    STRAPPED_BOOTS("Strapped Boots"),
    CLASPED_BOOTS("Clasped Boots"),
    SHACKLED_BOOTS("Shackled Boots"),
    TRAPPER_BOOTS("Trapper Boots"),
    AMBUSH_BOOTS("Ambush Boots"),
    CARNAL_BOOTS("Carnal Boots"),
    ASSASSIN_S_BOOTS("Assassin's Boots"),
    MURDER_BOOTS("Murder Boots"),
    // Two-Toned
    TWO_TONED_BOOTS("Two-Toned Boots"),
}

fun strBoots() =
    listOf(
        Boots.IRON_GREAVES,
        Boots.STEEL_GREAVES,
        Boots.PLATED_GREAVES,
        Boots.REINFORCED_GREAVES,
        Boots.ANTIQUE_GREAVES,
        Boots.ANCIENT_GREAVES,
        Boots.GOLIATH_GREAVES,
        Boots.VAAL_GREAVES,
        Boots.TITAN_GREAVES
    )

fun dexBoots() =
    listOf(
        Boots.RAWHIDE_BOOTS,
        Boots.GOATHIDE_BOOTS,
        Boots.DEERSKIN_BOOTS,
        Boots.NUBUCK_BOOTS,
        Boots.EELSKIN_BOOTS,
        Boots.SHARKSKIN_BOOTS,
        Boots.SHAGREEN_BOOTS,
        Boots.STEALTH_BOOTS,
        Boots.SLINK_BOOTS
    )

fun intBoots() =
    listOf(
        Boots.WOOL_SHOES,
        Boots.VELVET_SLIPPERS,
        Boots.SILK_SLIPPERS,
        Boots.SCHOLAR_BOOTS,
        Boots.SATIN_SLIPPERS,
        Boots.SAMITE_SLIPPERS,
        Boots.CONJURER_BOOTS,
        Boots.ARCANIST_SLIPPERS,
        Boots.SORCERER_BOOTS
    )

fun strDexBoots() =
    listOf(
        Boots.LEATHERSCALE_BOOTS,
        Boots.IRONSCALE_BOOTS,
        Boots.BRONZESCALE_BOOTS,
        Boots.STEELSCALE_BOOTS,
        Boots.SERPENTSCALE_BOOTS,
        Boots.WYRMSCALE_BOOTS,
        Boots.HYDRASCALE_BOOTS,
        Boots.DRAGONSCALE_BOOTS
    )

fun strIntBoots() =
    listOf(
        Boots.CHAIN_BOOTS,
        Boots.RINGMAIL_BOOTS,
        Boots.MESH_BOOTS,
        Boots.RIVETED_BOOTS,
        Boots.ZEALOT_BOOTS,
        Boots.SOLDIER_BOOTS,
        Boots.LEGION_BOOTS,
        Boots.CRUSADER_BOOTS
    )

fun dexIntBoots() =
    listOf(
        Boots.WRAPPED_BOOTS,
        Boots.STRAPPED_BOOTS,
        Boots.CLASPED_BOOTS,
        Boots.SHACKLED_BOOTS,
        Boots.TRAPPER_BOOTS,
        Boots.AMBUSH_BOOTS,
        Boots.CARNAL_BOOTS,
        Boots.ASSASSIN_S_BOOTS,
        Boots.MURDER_BOOTS
    )
