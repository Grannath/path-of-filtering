package de.grannath.pof.dsl

import io.kotlintest.forAll
import io.kotlintest.matchers.containsAll
import io.kotlintest.matchers.should
import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.StringSpec

class BodyArmourTest : StringSpec() {
    init {
        "groups cover all items" {
            strBodyArmour() +
                dexBodyArmour() +
                intBodyArmour() +
                strDexBodyArmour() +
                strIntBodyArmour() +
                dexIntBodyArmour() should containsAll(BodyArmour.values().toList())

        }

        "groups should have no duplicates" {
            forAll(
                listOf(
                    strBodyArmour(),
                    dexBodyArmour(),
                    intBodyArmour(),
                    strDexBodyArmour(),
                    strIntBodyArmour(),
                    dexIntBodyArmour()
                )
            ) {
                it.size shouldBe it.toSet().size
            }
        }
    }
}

class BootsTest : StringSpec() {
    init {
        "groups cover all items" {
            strBoots() +
                dexBoots() +
                intBoots() +
                strDexBoots() +
                strIntBoots() +
                dexIntBoots() +
                Boots.TWO_TONED_BOOTS should containsAll(Boots.values().toList())

        }

        "groups should have no duplicates" {
            forAll(
                listOf(
                    strBoots(),
                    dexBoots(),
                    intBoots(),
                    strDexBoots(),
                    strIntBoots(),
                    dexIntBoots()
                )
            ) {
                it.size shouldBe it.toSet().size
            }
        }
    }
}

class GlovesTest : StringSpec() {
    init {
        "groups cover all items" {
            strGloves() +
                dexGloves() +
                intGloves() +
                strDexGloves() +
                strIntGloves() +
                dexIntGloves() should containsAll(Gloves.values().toList())

        }

        "groups should have no duplicates" {
            forAll(
                listOf(
                    strGloves(),
                    dexGloves(),
                    intGloves(),
                    strDexGloves(),
                    strIntGloves(),
                    dexIntGloves()
                )
            ) {
                it.size shouldBe it.toSet().size
            }
        }
    }
}

class HelmetsTest : StringSpec() {
    init {
        "groups cover all items" {
            strHelmets() +
                dexHelmets() +
                intHelmets() +
                strDexHelmets() +
                strIntHelmets() +
                dexIntHelmets() should containsAll(Helmets.values().toList())

        }

        "groups should have no duplicates" {
            forAll(
                listOf(
                    strHelmets(),
                    dexHelmets(),
                    intHelmets(),
                    strDexHelmets(),
                    strIntHelmets(),
                    dexIntHelmets()
                )
            ) {
                it.size shouldBe it.toSet().size
            }
        }
    }
}
