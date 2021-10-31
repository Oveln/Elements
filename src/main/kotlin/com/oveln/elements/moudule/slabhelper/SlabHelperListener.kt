package com.oveln.elements.moudule.slabhelper

import org.bukkit.block.data.type.Slab
import org.bukkit.event.block.BlockBreakEvent
import taboolib.common.platform.event.SubscribeEvent

object SlabHelperListener {
    @SubscribeEvent
    fun onBreakSlab(event: BlockBreakEvent) {
        if (!SlabHelper.able) return
        if (event.block.blockData !is Slab) return
        val slab = event.block.blockData as Slab
        if (slab.type != Slab.Type.DOUBLE) return
        val y =event.player.rayTraceBlocks(15.0)?.hitPosition?.y
        y?.let {
            if (y-event.block.y>0.5) slab.type = Slab.Type.BOTTOM
            else slab.type = Slab.Type.TOP
            event.block.blockData = slab
            event.isCancelled = true
        }
    }
    //能用 但是不优雅
//    fun checktarget(player: Player, location: Location): Boolean {
//        var maxy = -1000.0
//        var miny = 1000.0
//        listOf(1, -1).forEach { a ->
//            listOf(1, -1).forEach { b ->
//                val vecmin =
//                    location.clone().add(0.5 * a + 0.5, 0.5, 0.5 * b + 0.5).subtract(player.eyeLocation).toVector()
//                        .normalize().y
//                val vecmax =
//                    location.clone().add(0.5 * a + 0.5, 1.0, 0.5 * b + 0.5).subtract(player.eyeLocation).toVector()
//                        .normalize().y
//                miny = miny.coerceAtMost(vecmin)
//                maxy = maxy.coerceAtLeast(vecmax)
//            }
//        }
//        val plyy = player.location.direction.normalize().y
//        if (plyy < maxy && plyy > miny) return true
//        return false
//    }
}