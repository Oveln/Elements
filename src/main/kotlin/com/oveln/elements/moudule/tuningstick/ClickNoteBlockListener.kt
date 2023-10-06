package com.oveln.elements.moudule.tuningstick

import org.bukkit.Material
import org.bukkit.event.player.PlayerInteractEvent
import taboolib.common.platform.event.SubscribeEvent

object ClickNoteBlockListener {
    @SubscribeEvent
    fun onListened(event: PlayerInteractEvent) {
        if (!TuningStick.able) return
        val block = event.clickedBlock
        block?.let {
            if (block.type != Material.NOTE_BLOCK) return
            if (event.player.inventory.itemInMainHand.type != Material.BLAZE_ROD) return
            event.player.openInventory(TuningGUI(block).GUI)
        }
    }
}