package de.grannath.pof.dsl

enum class Boots(override val printName: String) : Printable {
    LEATHERSCALE_BOOTS("Leatherscale Boots"),
    IRONSCALE_BOOTS("Ironscale Boots"),
    BRONZESCALE_BOOTS("Bronzescale Boots"),
    STEELSCALE_BOOTS("Steelscale Boots"),
    SERPENTSCALE_BOOTS("Serpentscale Boots"),
    WYRMSCALE_BOOTS("Wyrmscale Boots"),
    HYDRASCALE_BOOTS("Hydrascale Boots"),
    DRAGONSCALE_BOOTS("Dragonscale Boots")
}

fun strDexBoots() =
        listOf(Boots.LEATHERSCALE_BOOTS,
               Boots.IRONSCALE_BOOTS,
               Boots.BRONZESCALE_BOOTS,
               Boots.STEELSCALE_BOOTS,
               Boots.SERPENTSCALE_BOOTS,
               Boots.WYRMSCALE_BOOTS,
               Boots.HYDRASCALE_BOOTS,
               Boots.DRAGONSCALE_BOOTS)
