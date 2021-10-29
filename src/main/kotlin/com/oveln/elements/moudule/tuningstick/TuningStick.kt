package com.oveln.elements.moudule.tuningstick

import com.oveln.elements.moudule.Moudule
import taboolib.library.xseries.XMaterial

object TuningStick: Moudule(
    name = "TuningStick",
    description = "可以通过烈焰棒给音符盒调音",
    material = XMaterial.NOTE_BLOCK
) {
    val NoteIsable by lazy {
        listOf(
            listOf(0,0,0,-1,2,2,1),
            listOf(2,2,1,2,2,2,1),
            listOf(2,2,1,2,0,0,0),
        )
    }
    val NoteID by lazy {
        listOf(
            listOf(-1,-1,-1,0,1,3,5),
            listOf(6,8,10,11,13,15,17),
            listOf(18,20,22,23,-1,-1,-1),
        )
    }
    val NoteName by lazy {
        listOf(
            "C","D","E","F","G","A","B"
        )
    }
    val NoteIcon by lazy {
        listOf(
            XMaterial.RED_DYE,
            XMaterial.ORANGE_DYE,
            XMaterial.YELLOW_DYE,
            XMaterial.GREEN_DYE,
            XMaterial.BLUE_DYE,
            XMaterial.LIGHT_BLUE_DYE,
            XMaterial.PURPLE_DYE
        )
    }
    val NoteSlot by lazy {
        listOf(
            listOf(10,11,12,13,14,15,16),
            listOf(19,20,21,22,23,24,25),
            listOf(28,29,30,31,32,33,34),
        )
    }
}