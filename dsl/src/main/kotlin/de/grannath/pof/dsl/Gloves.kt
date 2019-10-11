package de.grannath.pof.dsl

enum class Gloves(override val printName: String) : Printable {
    // STR
    IRON_GAUNTLETS("Iron Gauntlets"),
    PLATED_GAUNTLETS("Plated Gauntlets"),
    BRONZE_GAUNTLETS("Bronze Gauntlets"),
    STEEL_GAUNTLETS("Steel Gauntlets"),
    ANTIQUE_GAUNTLETS("Antique Gauntlets"),
    ANCIENT_GAUNTLETS("Ancient Gauntlets"),
    GOLIATH_GAUNTLETS("Goliath Gauntlets"),
    VAAL_GAUNTLETS("Vaal Gauntlets"),
    TITAN_GAUNTLETS("Titan Gauntlets"),
    SPIKED_GLOVES("Spiked Gloves"),
    // DEX
    RAWHIDE_GLOVES("Rawhide Gloves"),
    GOATHIDE_GLOVES("Goathide Gloves"),
    DEERSKIN_GLOVES("Deerskin Gloves"),
    NUBUCK_GLOVES("Nubuck Gloves"),
    EELSKIN_GLOVES("Eelskin Gloves"),
    SHARKSKIN_GLOVES("Sharkskin Gloves"),
    SHAGREEN_GLOVES("Shagreen Gloves"),
    STEALTH_GLOVES("Stealth Gloves"),
    SLINK_GLOVES("Slink Gloves"),
    GRIPPED_GLOVES("Gripped Gloves"),
    // INT
    WOOL_GLOVES("Wool Gloves"),
    VELVET_GLOVES("Velvet Gloves"),
    SILK_GLOVES("Silk Gloves"),
    EMBROIDERED_GLOVES("Embroidered Gloves"),
    SATIN_GLOVES("Satin Gloves"),
    SAMITE_GLOVES("Samite Gloves"),
    CONJURER_GLOVES("Conjurer Gloves"),
    ARCANIST_GLOVES("Arcanist Gloves"),
    SORCERER_GLOVES("Sorcerer Gloves"),
    FINGERLESS_SILK_GLOVES("Fingerless Silk Gloves"),
    // STR/DEX
    FISHSCALE_GAUNTLETS("Fishscale Gauntlets"),
    IRONSCALE_GAUNTLETS("Ironscale Gauntlets"),
    BRONZESCALE_GAUNTLETS("Bronzescale Gauntlets"),
    STEELSCALE_GAUNTLETS("Steelscale Gauntlets"),
    SERPENTSCALE_GAUNTLETS("Serpentscale Gauntlets"),
    WYRMSCALE_GAUNTLETS("Wyrmscale Gauntlets"),
    HYDRASCALE_GAUNTLETS("Hydrascale Gauntlets"),
    DRAGONSCALE_GAUNTLETS("Dragonscale Gauntlets"),
    // STR/INT
    CHAIN_GLOVES("Chain Gloves"),
    RINGMAIL_GLOVES("Ringmail Gloves"),
    MESH_GLOVES("Mesh Gloves"),
    RIVETED_GLOVES("Riveted Gloves"),
    ZEALOT_GLOVES("Zealot Gloves"),
    SOLDIER_GLOVES("Soldier Gloves"),
    LEGION_GLOVES("Legion Gloves"),
    CRUSADER_GLOVES("Crusader Gloves"),
    // DEX/INT
    WRAPPED_MITTS("Wrapped Mitts"),
    STRAPPED_MITTS("Strapped Mitts"),
    CLASPED_MITTS("Clasped Mitts"),
    TRAPPER_MITTS("Trapper Mitts"),
    AMBUSH_MITTS("Ambush Mitts"),
    CARNAL_MITTS("Carnal Mitts"),
    ASSASSIN_S_MITTS("Assassin's Mitts"),
    MURDER_MITTS("Murder Mitts"),
}

fun strGloves() =
    listOf(
        Gloves.IRON_GAUNTLETS,
        Gloves.PLATED_GAUNTLETS,
        Gloves.BRONZE_GAUNTLETS,
        Gloves.STEEL_GAUNTLETS,
        Gloves.ANTIQUE_GAUNTLETS,
        Gloves.ANCIENT_GAUNTLETS,
        Gloves.GOLIATH_GAUNTLETS,
        Gloves.VAAL_GAUNTLETS,
        Gloves.TITAN_GAUNTLETS,
        Gloves.SPIKED_GLOVES
    )

fun dexGloves() =
    listOf(
        Gloves.RAWHIDE_GLOVES,
        Gloves.GOATHIDE_GLOVES,
        Gloves.DEERSKIN_GLOVES,
        Gloves.NUBUCK_GLOVES,
        Gloves.EELSKIN_GLOVES,
        Gloves.SHARKSKIN_GLOVES,
        Gloves.SHAGREEN_GLOVES,
        Gloves.STEALTH_GLOVES,
        Gloves.SLINK_GLOVES,
        Gloves.GRIPPED_GLOVES
    )

fun intGloves() =
    listOf(
        Gloves.WOOL_GLOVES,
        Gloves.VELVET_GLOVES,
        Gloves.SILK_GLOVES,
        Gloves.EMBROIDERED_GLOVES,
        Gloves.SATIN_GLOVES,
        Gloves.SAMITE_GLOVES,
        Gloves.CONJURER_GLOVES,
        Gloves.ARCANIST_GLOVES,
        Gloves.SORCERER_GLOVES,
        Gloves.FINGERLESS_SILK_GLOVES
    )

fun strDexGloves() =
    listOf(
        Gloves.FISHSCALE_GAUNTLETS,
        Gloves.IRONSCALE_GAUNTLETS,
        Gloves.BRONZESCALE_GAUNTLETS,
        Gloves.STEELSCALE_GAUNTLETS,
        Gloves.SERPENTSCALE_GAUNTLETS,
        Gloves.WYRMSCALE_GAUNTLETS,
        Gloves.HYDRASCALE_GAUNTLETS,
        Gloves.DRAGONSCALE_GAUNTLETS
    )

fun strIntGloves() =
    listOf(
        Gloves.CHAIN_GLOVES,
        Gloves.RINGMAIL_GLOVES,
        Gloves.MESH_GLOVES,
        Gloves.RIVETED_GLOVES,
        Gloves.ZEALOT_GLOVES,
        Gloves.SOLDIER_GLOVES,
        Gloves.LEGION_GLOVES,
        Gloves.CRUSADER_GLOVES
    )

fun dexIntGloves() =
    listOf(
        Gloves.WRAPPED_MITTS,
        Gloves.STRAPPED_MITTS,
        Gloves.CLASPED_MITTS,
        Gloves.TRAPPER_MITTS,
        Gloves.AMBUSH_MITTS,
        Gloves.CARNAL_MITTS,
        Gloves.ASSASSIN_S_MITTS,
        Gloves.MURDER_MITTS
    )
