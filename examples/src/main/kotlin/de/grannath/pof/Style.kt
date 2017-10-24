package de.grannath.pof

import de.grannath.pof.dsl.*
import de.grannath.pof.model.Rarity

fun main(args: Array<String>) {
    file("foo.filter") {
        filter {
            classes(oneHandWeapons())
            hide()
            withStyle {
                backgroundColor(255, 0, 0)
            }

            filter {
                rarity(Rarity.RARE)
                itemLevel(upTo(12))
                withStyle {
                    fontSize(45)
                }
            }
        }

        withStyle {
            fontSize(32)
        }
    }
}
