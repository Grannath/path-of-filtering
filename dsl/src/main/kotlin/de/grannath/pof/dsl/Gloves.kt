package de.grannath.pof.dsl

enum class Gloves(override val printName: String) : Printable {
    FISHSCALE_GAUNTLETS("Fishscale Gauntlets"),
    IRONSCALE_GAUNTLETS("Ironscale Gauntlets"),
    BRONZESCALE_GAUNTLETS("Bronzescale Gauntlets"),
    STEELSCALE_GAUNTLETS("Steelscale Gauntlets"),
    SERPENTSCALE_GAUNTLETS("Serpentscale Gauntlets"),
    WYRMSCALE_GAUNTLETS("Wyrmscale Gauntlets"),
    HYDRASCALE_GAUNTLETS("Hydrascale Gauntlets"),
    DRAGONSCALE_GAUNTLETS("Dragonscale Gauntlets")
}

fun strDexGloves() =
        listOf(Gloves.FISHSCALE_GAUNTLETS,
               Gloves.IRONSCALE_GAUNTLETS,
               Gloves.BRONZESCALE_GAUNTLETS,
               Gloves.STEELSCALE_GAUNTLETS,
               Gloves.SERPENTSCALE_GAUNTLETS,
               Gloves.WYRMSCALE_GAUNTLETS,
               Gloves.HYDRASCALE_GAUNTLETS,
               Gloves.DRAGONSCALE_GAUNTLETS)
