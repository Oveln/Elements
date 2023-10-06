package com.oveln.elements.moudule.anvildyeing

import org.bukkit.entity.Player
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.inventory.PrepareAnvilEvent
import org.bukkit.inventory.AnvilInventory
import taboolib.common.platform.event.SubscribeEvent
import taboolib.module.nms.getI18nName
import taboolib.platform.util.buildItem

object AnvilListener {
    @SubscribeEvent
    fun onListened(event: PrepareAnvilEvent) {
        if (!AnvilDyeing.able) return
        val inv = event.inventory
        val item = inv.getItem(0)
        val dye = inv.getItem(1)
        item?.let {
            dye?.let {
                if (AnvilDyeing.Dyes.containsKey(dye.type)) {
                    event.result = buildItem(item) {
                        name ="&${AnvilDyeing.Dyes[dye.type]}" +
                                (if (inv.renameText == "")  it.getI18nName(event.view.player as Player) else inv.renameText)
                        colored()
                    }
                }
            }
        }
    }
    @SubscribeEvent
    fun onClick(event: InventoryClickEvent) {
        if (!AnvilDyeing.able) return
        if (event.inventory !is AnvilInventory || event.slot != 2) return
        val inv = event.inventory
        val item = inv.getItem(0)
        val dye = inv.getItem(1)
        item?.let {
            dye?.let {
                if (AnvilDyeing.Dyes.containsKey(dye.type)) {
                    event.cursor = inv.getItem(2)
                    inv.clear(0)
                    dye.amount = dye.amount - 1
                }
            }
        }
    }
}