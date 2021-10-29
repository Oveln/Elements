package com.oveln.elements

import com.oveln.elements.command.Command
import com.oveln.elements.moudule.Manage
import taboolib.common.platform.Plugin
import taboolib.common.platform.function.*

object Main : Plugin() {
    override fun onEnable() {
        Command.register()

        Manage.load()

        info("v${pluginVersion} 启动完成 作者Oveln")
    }

    override fun onDisable() {
        Manage.save()

        info("v${pluginVersion} 关闭完成 作者Oveln")
    }
}