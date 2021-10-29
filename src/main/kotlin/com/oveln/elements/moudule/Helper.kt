package com.oveln.elements.moudule

import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemFlag
import taboolib.library.xseries.XMaterial
import taboolib.module.ui.buildMenu
import taboolib.module.ui.type.Linked
import taboolib.platform.util.buildItem
import taboolib.platform.util.inventoryCenterSlots

object Helper {
    val HelpGUI by lazy {
        buildMenu<Linked<Moudule>>("Elements模块") {
            rows(6)
            slots(inventoryCenterSlots)
            handLocked(true)
            elements {
                Manage.Moudles
            }
            onGenerate { _, element, _, _ ->
                buildItem(element.material) {
                    name = "&f${element.name}"
                    lore.add(" ")
                    element.description.split("%%").forEach() {
                        lore.add("&e$it")
                    }
                    lore.add(" ")
                    lore.add("&f当前状态：${if (element.able) "&2开启" else "&c关闭"}")
                    if (element.able) enchants[Enchantment.DURABILITY] = 3
                    flags.add(ItemFlag.HIDE_ENCHANTS)
                    colored()
                }
            }
            if (hasNextPage()) {
                setNextPage(51) { _, _ ->
                    buildItem(XMaterial.SPECTRAL_ARROW) {
                        name = "&7下一页"
                        colored()
                    }
                }
            }
            if (hasPreviousPage())
                setPreviousPage(47) { _, _ ->
                    buildItem(XMaterial.SPECTRAL_ARROW) {
                        name = "&7上一页"
                        colored()
                    }
                }
        }
    }
}