package com.oveln.elements.moudule

import com.oveln.elements.moudule.anvildyeing.AnvilDyeing
import com.oveln.elements.moudule.feathercutting.FeatherCutting
import com.oveln.elements.moudule.reap.Reap
import com.oveln.elements.moudule.slabhelper.SlabHelper
import com.oveln.elements.moudule.tuningstick.TuningStick
import com.oveln.elements.utils.Config
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemFlag
import taboolib.library.xseries.XMaterial
import taboolib.module.ui.buildMenu
import taboolib.module.ui.type.Linked
import taboolib.platform.util.buildItem
import taboolib.platform.util.inventoryCenterSlots

object Manage {
    val Moudles by lazy {
        listOf<Moudule>(
            AnvilDyeing,
            Reap,
            FeatherCutting,
            TuningStick,
            SlabHelper
        )
    }
    val ManageGUI by lazy {
        buildMenu<Linked<Moudule>>("Elements模块设置") {
            rows(6)
            slots(inventoryCenterSlots)
            handLocked(true)
            elements {
                Moudles
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
            onClick { event, element ->
                if (element.able) element.Disable()
                else element.Enable()
                event.inventory.setItem( event.rawSlot,
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
                )
            }
        }
    }
    fun load() {
        Moudles.forEach {
            if (Config.Moudele.getBoolean(it.name)) it.Enable()
            else it.Disable()
        }
    }
    fun save() {
        Moudles.forEach {
            Config.Moudele[it.name] = it.able
        }
        Config.Moudele.saveToFile()
    }
}