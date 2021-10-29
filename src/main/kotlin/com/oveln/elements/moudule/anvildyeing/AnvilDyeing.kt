package com.oveln.elements.moudule.anvildyeing

import com.oveln.elements.moudule.Moudule
import org.bukkit.Material
import taboolib.library.xseries.XMaterial

object AnvilDyeing: Moudule("AnvilDyeing", description = "在铁砧里用染料给物品名字染色" , material = XMaterial.ANVIL) {
    val Dyes by lazy {
        mapOf(
            Pair(Material.RED_DYE , 'c'),
            Pair(Material.BLACK_DYE , '0'),
            Pair(Material.BLUE_DYE , '1'),
            Pair(Material.GREEN_DYE, '2'),
            Pair(Material.LIGHT_BLUE_DYE , 'b'),
            Pair(Material.PURPLE_DYE , '5'),
            Pair(Material.LIGHT_GRAY_DYE , '7'),
            Pair(Material.GRAY_DYE , '8'),
            Pair(Material.YELLOW_DYE , 'e'),
            Pair(Material.CYAN_DYE , '3'),
            Pair(Material.PINK_DYE , 'd')
        )
    }
}