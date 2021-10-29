package com.oveln.elements.moudule.feathercutting

import org.bukkit.Material
import org.bukkit.entity.Chicken
import org.bukkit.event.entity.EntityDropItemEvent
import taboolib.common.platform.event.SubscribeEvent
import taboolib.common.platform.function.info

object LayEgglistener {
    @SubscribeEvent
    fun onListened(event: EntityDropItemEvent) {
        if (!FeatherCutting.able) return
        if (event.entity is Chicken && event.itemDrop.itemStack.type == Material.EGG) {
            (event.entity as Chicken).health = 4.0
        }
    }
}
