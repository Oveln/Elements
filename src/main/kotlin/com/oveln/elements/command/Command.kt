package com.oveln.elements.command

import com.oveln.elements.moudule.Manage
import org.bukkit.entity.Player
import taboolib.common.platform.ProxyCommandSender
import taboolib.common.platform.ProxyPlayer
import taboolib.common.platform.command.command

object Command {
    fun register() {
        command("elements" , aliases = listOf("ele") , description = "Elements插件命令") {
            literal("hello" , optional = true) {
                execute<ProxyCommandSender>{sender, _, _ ->
                    sender.sendMessage("Hello Elements")
                }
            }
            literal("manage",optional = true) {
                execute<ProxyPlayer> { sender, _, _ ->
                    sender.cast<Player>().openInventory(Manage.ManageGUI)
                }
            }
        }
    }
}