package com.oveln.elements.moudule.reap

import org.bukkit.block.data.Ageable
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent
import taboolib.common.platform.event.SubscribeEvent

object ReapListener {
    @SubscribeEvent
    fun onListened(event: PlayerInteractEvent) {
        if (!Reap.able) return
        val block = event.clickedBlock
        block?.let {
            if (event.action == Action.RIGHT_CLICK_BLOCK) {
                val blockData = block.blockData
                if (blockData is Ageable) {
                    if (blockData.age == blockData.maximumAge) {
                        block.drops.forEach {
                            it?.let { block.world.dropItem(block.location,it) }
                        }
                        blockData.age = 0
                        block.blockData = blockData
                    }
                }
            }
        }
    }
}