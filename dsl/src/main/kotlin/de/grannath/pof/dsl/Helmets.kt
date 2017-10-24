package de.grannath.pof.dsl

enum class Helmets(override val printName: String) : Printable {
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
}

fun strDexHelmets() =
        listOf(Helmets.BATTERED_HELM,
               Helmets.SALLET,
               Helmets.VISORED_SALLET,
               Helmets.GILDED_SALLET,
               Helmets.SECUTOR_HELM,
               Helmets.FENCER_HELM,
               Helmets.LACQUERED_HELM,
               Helmets.FLUTED_BASCINET,
               Helmets.PIG_FACED_BASCINET,
               Helmets.NIGHTMARE_BASCINET)
