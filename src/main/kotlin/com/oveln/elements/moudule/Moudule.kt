package com.oveln.elements.moudule

import taboolib.library.xseries.XMaterial

abstract class Moudule(
    val name: String,
    val description: String = "", // %%作为换行符
    val material: XMaterial
) {
    var able = true
    fun enable() {
        able = true
    }
    fun disable() {
        able = false
    }
}