package com.oveln.elements.utils

object Tools {
    fun String.colorful():String {
        return this.replace("&" , "§")
    }
}