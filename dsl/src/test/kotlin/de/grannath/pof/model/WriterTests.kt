package de.grannath.pof.model

import io.kotlintest.matchers.shouldBe
import io.kotlintest.matchers.shouldThrow
import io.kotlintest.specs.StringSpec
import java.io.StringWriter

class BasicWriterTest : StringSpec() {
    init {
        "empty show block is empty" {
            printing { Filter(show = true) } shouldBe "Show"
        }

        "simple show block is complete" {
            printing {
                Filter(
                    show = true,
                    matchers = listOf(ClassMatcher(listOf("Some Class"))),
                    style = Style(backgroundColor = Color(50, 50, 20, 100))
                )
            } shouldBe """
                |Show
                |    Class "Some Class"
                |    SetBackgroundColor 50 50 20 100
                """.trimMargin()
        }

        "simple hide block is complete" {
            printing {
                val rgb = SocketGroup(
                    SocketColor.RED,
                    SocketColor.GREEN,
                    SocketColor.BLUE
                )
                val rgg = SocketGroup(
                    SocketColor.RED,
                    SocketColor.GREEN,
                    SocketColor.GREEN
                )
                Filter(
                    show = false,
                    matchers = listOf(
                        ClassMatcher(listOf("Some Class")),
                        SocketGroupMatcher(
                            listOf(
                                rgb,
                                rgg
                            )
                        )
                    ),
                    style = Style(
                        backgroundColor = Color(50, 50, 20, 100),
                        fontSize = 42
                    )
                )
            } shouldBe """
                |Hide
                |    Class "Some Class"
                |    SocketGroup RGB RGG
                |    SetBackgroundColor 50 50 20 100
                |    SetFontSize 42
                """.trimMargin()
        }

        "fails if show/hide is unset" {
            val writer = StringWriter()
            shouldThrow<IllegalStateException> {
                Filter(show = null).append(writer)
            }
        }
    }
}

class NestedWriterTest : StringSpec() {
    init {
        "two levels are ordered correctly" {
            printing {
                val child = Filter(
                    show = true,
                    matchers = listOf(ClassMatcher(listOf("Some Class")))
                )
                Filter(
                    show = false,
                    children = listOf(child)
                )
            } shouldBe """
                |Show
                |    Class "Some Class"
                |
                |Hide
                """.trimMargin()
        }

        "style is inherited" {
            printing {
                val child = Filter(
                    show = true,
                    matchers = listOf(ClassMatcher(listOf("Some Class"))),
                    style = Style(fontSize = 32)
                )
                Filter(
                    show = true,
                    children = listOf(child),
                    style = Style(textColor = Color(10, 20, 30, 0))
                )
            } shouldBe """
                |Show
                |    Class "Some Class"
                |    SetTextColor 10 20 30 0
                |    SetFontSize 32
                |
                |Show
                |    SetTextColor 10 20 30 0
                """.trimMargin()
        }

        "two large levels are ordered correctly" {
            printing {
                val childOne = Filter(
                    show = false,
                    matchers = listOf(ClassMatcher(listOf("Some Class"))),
                    style = Style(fontSize = 20)
                )
                val childTwo = Filter(
                    show = true,
                    matchers = listOf(ClassMatcher(listOf("Some Other Class"))),
                    style = Style(fontSize = 42)
                )
                Filter(
                    show = false,
                    children = listOf(childOne, childTwo)
                )
            } shouldBe """
                |Hide
                |    Class "Some Class"
                |    SetFontSize 20
                |
                |Show
                |    Class "Some Other Class"
                |    SetFontSize 42
                |
                |Hide
                """.trimMargin()
        }

        "three levels are ordered correctly" {
            printing {
                val leafOne = Filter(
                    matchers = listOf(ClassMatcher(listOf("Some Class"))),
                    style = Style(fontSize = 20)
                )
                val leafTwo = Filter(
                    show = true,
                    matchers = listOf(ClassMatcher(listOf("Some Other Class"))),
                    style = Style(fontSize = 42)
                )
                val nodeOne = Filter(
                    show = true,
                    matchers = listOf(ItemLevelMatcher(10, Comp.EQ)),
                    children = listOf(leafOne, leafTwo),
                    style = Style(textColor = Color(50, 50, 50, 50))
                )
                val nodeTwo = Filter(
                    show = false,
                    matchers = listOf(ItemLevelMatcher(10, Comp.HIGHER_THAN)),
                    children = listOf(leafOne, leafTwo),
                    style = Style(textColor = Color(50, 50, 50, 50))
                )
                Filter(
                    show = true,
                    children = listOf(nodeOne, nodeTwo)
                )
            } shouldBe """
                |Show
                |    Class "Some Class"
                |    ItemLevel = 10
                |    SetTextColor 50 50 50 50
                |    SetFontSize 20
                |
                |Show
                |    Class "Some Other Class"
                |    ItemLevel = 10
                |    SetTextColor 50 50 50 50
                |    SetFontSize 42
                |
                |Show
                |    ItemLevel = 10
                |    SetTextColor 50 50 50 50
                |
                |Hide
                |    Class "Some Class"
                |    ItemLevel > 10
                |    SetTextColor 50 50 50 50
                |    SetFontSize 20
                |
                |Show
                |    Class "Some Other Class"
                |    ItemLevel > 10
                |    SetTextColor 50 50 50 50
                |    SetFontSize 42
                |
                |Hide
                |    ItemLevel > 10
                |    SetTextColor 50 50 50 50
                |
                |Show
                """.trimMargin()
        }
    }
}

fun printing(ini: () -> Filter): String {
    val writer = StringWriter()
    ini().append(writer)
    return writer.toString().trim()
}
