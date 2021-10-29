package com.oveln.elements.moudule

import taboolib.library.xseries.XMaterial

abstract class Moudule(val name: String, val description: String = "") {
    var able = true
    var material = XMaterial.REDSTONE_BLOCK
        private set
    constructor(name: String, description: String = "" , material: XMaterial):this(name,description) {
        this.material = material
    }
    fun Enable() {
        able = true
    }
    fun Disable() {
        able = false
    }
}