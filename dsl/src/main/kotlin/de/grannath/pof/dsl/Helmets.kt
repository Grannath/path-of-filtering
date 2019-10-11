package de.grannath.pof.dsl

enum class Helmets(override val printName: String) : Printable {
    // STR
    IRON_HAT("Iron Hat"),
    CONE_HELMET("Cone Helmet"),
    BARBUTE_HELMET("Barbute Helmet"),
    CLOSE_HELMET("Close Helmet"),
    GLADIATOR_HELMET("Gladiator Helmet"),
    REAVER_HELMET("Reaver Helmet"),
    SIEGE_HELMET("Siege Helmet"),
    SAMITE_HELMET("Samite Helmet"),
    EZOMYTE_BURGONET("Ezomyte Burgonet"),
    ROYAL_BURGONET("Royal Burgonet"),
    ETERNAL_BURGONET("Eternal Burgonet"),
    // DEX
    LEATHER_CAP("Leather Cap"),
    TRICORNE("Tricorne"),
    LEATHER_HOOD("Leather Hood"),
    WOLF_PELT("Wolf Pelt"),
    HUNTER_HOOD("Hunter Hood"),
    NOBLE_TRICORNE("Noble Tricorne"),
    URSINE_PELT("Ursine Pelt"),
    SILKEN_HOOD("Silken Hood"),
    SINNER_TRICORNE("Sinner Tricorne"),
    LION_PELT("Lion Pelt"),
    // INT
    VINE_CIRCLET("Vine Circlet"),
    IRON_CIRCLET("Iron Circlet"),
    TORTURE_CAGE("Torture Cage"),
    TRIBAL_CIRCLET("Tribal Circlet"),
    BONE_CIRCLET("Bone Circlet"),
    LUNARIS_CIRCLET("Lunaris Circlet"),
    STEEL_CIRCLET("Steel Circlet"),
    NECROMANCER_CIRCLET("Necromancer Circlet"),
    SOLARIS_CIRCLET("Solaris Circlet"),
    MIND_CAGE("Mind Cage"),
    HUBRIS_CIRCLET("Hubris Circlet"),
    // STR/DEX
    BATTERED_HELM("Battered Helm"),
    SALLET("Sallet"),
    VISORED_SALLET("Visored Sallet"),
    GILDED_SALLET("Gilded Sallet"),
    SECUTOR_HELM("Secutor Helm"),
    FENCER_HELM("Fencer Helm"),
    LACQUERED_HELM("Lacquered Helm"),
    FLUTED_BASCINET("Fluted Bascinet"),
    PIG_FACED_BASCINET("Pig-Faced Bascinet"),
    NIGHTMARE_BASCINET("Nightmare Bascinet"),
    // STR/INT
    RUSTED_COIF("Rusted Coif"),
    SOLDIER_HELMET("Soldier Helmet"),
    GREAT_HELMET("Great Helmet"),
    CRUSADER_HELMET("Crusader Helmet"),
    AVENTAIL_HELMET("Aventail Helmet"),
    ZEALOT_HELMET("Zealot Helmet"),
    GREAT_CROWN("Great Crown"),
    MAGISTRATE_CROWN("Magistrate Crown"),
    PROPHET_CROWN("Prophet Crown"),
    PRAETOR_CROWN("Praetor Crown"),
    BONE_HELMET("Bone Helmet"),
    // DEX/INT
    SCARE_MASK("Scare Mask"),
    PLAGUE_MASK("Plague Mask"),
    IRON_MASK("Iron Mask"),
    FESTIVAL_MASK("Festival Mask"),
    GOLDEN_MASK("Golden Mask"),
    RAVEN_MASK("Raven Mask"),
    CALLOUS_MASK("Callous Mask"),
    REGICIDE_MASK("Regicide Mask"),
    HARLEQUIN_MASK("Harlequin Mask"),
    VAAL_MASK("Vaal Mask"),
    DEICIDE_MASK("Deicide Mask"),
}

fun strHelmets() =
    listOf(
        Helmets.IRON_HAT,
        Helmets.CONE_HELMET,
        Helmets.BARBUTE_HELMET,
        Helmets.CLOSE_HELMET,
        Helmets.GLADIATOR_HELMET,
        Helmets.REAVER_HELMET,
        Helmets.SIEGE_HELMET,
        Helmets.SAMITE_HELMET,
        Helmets.EZOMYTE_BURGONET,
        Helmets.ROYAL_BURGONET,
        Helmets.ETERNAL_BURGONET
    )

fun dexHelmets() =
    listOf(
        Helmets.LEATHER_CAP,
        Helmets.TRICORNE,
        Helmets.LEATHER_HOOD,
        Helmets.WOLF_PELT,
        Helmets.HUNTER_HOOD,
        Helmets.NOBLE_TRICORNE,
        Helmets.URSINE_PELT,
        Helmets.SILKEN_HOOD,
        Helmets.SINNER_TRICORNE,
        Helmets.LION_PELT
    )

fun intHelmets() =
    listOf(
        Helmets.VINE_CIRCLET,
        Helmets.IRON_CIRCLET,
        Helmets.TORTURE_CAGE,
        Helmets.TRIBAL_CIRCLET,
        Helmets.BONE_CIRCLET,
        Helmets.LUNARIS_CIRCLET,
        Helmets.STEEL_CIRCLET,
        Helmets.NECROMANCER_CIRCLET,
        Helmets.SOLARIS_CIRCLET,
        Helmets.MIND_CAGE,
        Helmets.HUBRIS_CIRCLET
    )

fun strDexHelmets() =
    listOf(
        Helmets.BATTERED_HELM,
        Helmets.SALLET,
        Helmets.VISORED_SALLET,
        Helmets.GILDED_SALLET,
        Helmets.SECUTOR_HELM,
        Helmets.FENCER_HELM,
        Helmets.LACQUERED_HELM,
        Helmets.FLUTED_BASCINET,
        Helmets.PIG_FACED_BASCINET,
        Helmets.NIGHTMARE_BASCINET
    )

fun strIntHelmets() =
    listOf(
        Helmets.RUSTED_COIF,
        Helmets.SOLDIER_HELMET,
        Helmets.GREAT_HELMET,
        Helmets.CRUSADER_HELMET,
        Helmets.AVENTAIL_HELMET,
        Helmets.ZEALOT_HELMET,
        Helmets.GREAT_CROWN,
        Helmets.MAGISTRATE_CROWN,
        Helmets.PROPHET_CROWN,
        Helmets.PRAETOR_CROWN,
        Helmets.BONE_HELMET
    )

fun dexIntHelmets() =
    listOf(
        Helmets.SCARE_MASK,
        Helmets.PLAGUE_MASK,
        Helmets.IRON_MASK,
        Helmets.FESTIVAL_MASK,
        Helmets.GOLDEN_MASK,
        Helmets.RAVEN_MASK,
        Helmets.CALLOUS_MASK,
        Helmets.REGICIDE_MASK,
        Helmets.HARLEQUIN_MASK,
        Helmets.VAAL_MASK,
        Helmets.DEICIDE_MASK
    )
