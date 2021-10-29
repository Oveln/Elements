package com.oveln.elements.moudule.feathercutting

import com.oveln.elements.utils.Tools.colorful
import org.bukkit.Material
import org.bukkit.attribute.Attribute
import org.bukkit.entity.Ageable
import org.bukkit.entity.Chicken
import org.bukkit.entity.Damageable
import org.bukkit.event.player.PlayerInteractAtEntityEvent
import taboolib.common.platform.event.SubscribeEvent
import taboolib.common.platform.function.info
import taboolib.common.util.random
import taboolib.library.xseries.XMaterial
import taboolib.platform.util.buildItem

object CuttingListener {
    @SubscribeEvent
    fun onListened(event: PlayerInteractAtEntityEvent) {
        if (!FeatherCutting.able) return
        if (event.player.inventory.itemInMainHand.type != Material.SHEARS || event.rightClicked !is Chicken) return
        val chicken = event.rightClicked as Chicken
        if (chicken.isAdult && chicken.health > 3.0) {
            (event.rightClicked as Ageable).damage(1.0)
            event.rightClicked.world.dropItem(
                event.rightClicked.location,
                buildItem(XMaterial.FEATHER) {
                    amount = random(3)+1
                }
            )
            if (random(500) == 66) {
                event.rightClicked.customName = "骂人鸡"
                event.player.sendMessage(event.rightClicked.uniqueId,"&cFuck you!".colorful())
            }
        }
    }
}