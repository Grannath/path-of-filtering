package de.grannath.pof.dsl

import de.grannath.pof.model.Printable

enum class BodyArmour(override val printName: String) : Printable {
    LIGHT_BRIGANDINE("Light Brigandine"),
    SCALE_DOUBLET("Scale Doublet"),
    INFANTRY_BRIGANDINE("Infantry Brigandine"),
    FULL_SCALE_ARMOUR("Full Scale Armour"),
    SOLDIERS_BRIGANDINE("Soldier's Brigandine"),
    FIELD_LAMELLAR("Field Lamellar"),
    WYRMSCALE_DOUBLET("Wyrmscale Doublet"),
    HUSSAR_BRIGANDINE("Hussar Brigandine"),
    FULL_WYRMSCALE("Full Wyrmscale"),
    COMMANDERS_BRIGANDINE("Commander's Brigandine"),
    BATTLE_LAMELLAR("Battle Lamellar"),
    DRAGONSCALE_DOUBLET("Dragonscale Doublet"),
    DESERT_BRIGANDINE("Desert Brigandine"),
    FULL_DRAGONSCALE("Full Dragonscale"),
    GENERALS_BRIGANDINE("General's Brigandine"),
    TRIUMPHANT_LAMELLAR("Triumphant Lamellar")
}

fun strDexBodyArmour() =
        listOf(BodyArmour.LIGHT_BRIGANDINE,
               BodyArmour.SCALE_DOUBLET,
               BodyArmour.INFANTRY_BRIGANDINE,
               BodyArmour.FULL_SCALE_ARMOUR,
               BodyArmour.SOLDIERS_BRIGANDINE,
               BodyArmour.FIELD_LAMELLAR,
               BodyArmour.WYRMSCALE_DOUBLET,
               BodyArmour.HUSSAR_BRIGANDINE,
               BodyArmour.FULL_WYRMSCALE,
               BodyArmour.COMMANDERS_BRIGANDINE,
               BodyArmour.BATTLE_LAMELLAR,
               BodyArmour.DRAGONSCALE_DOUBLET,
               BodyArmour.DESERT_BRIGANDINE,
               BodyArmour.FULL_DRAGONSCALE,
               BodyArmour.GENERALS_BRIGANDINE,
               BodyArmour.TRIUMPHANT_LAMELLAR)
