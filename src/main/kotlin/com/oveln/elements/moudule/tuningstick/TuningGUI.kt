package com.oveln.elements.moudule.tuningstick

import com.oveln.elements.moudule.tuningstick.TuningStick.NoteID
import com.oveln.elements.moudule.tuningstick.TuningStick.NoteIcon
import com.oveln.elements.moudule.tuningstick.TuningStick.NoteIsable
import com.oveln.elements.moudule.tuningstick.TuningStick.NoteName
import com.oveln.elements.moudule.tuningstick.TuningStick.NoteSlot
import org.bukkit.Note
import org.bukkit.block.Block
import org.bukkit.block.data.type.NoteBlock
import taboolib.module.ui.buildMenu
import taboolib.module.ui.type.Basic
import taboolib.platform.util.buildItem

class TuningGUI(noteblock: Block){
    val GUI by lazy {
        buildMenu<Basic>("调音") {
            rows(5)
            NoteSlot.forEachIndexed() { i , it ->
                it.forEachIndexed() {j, slotid ->
                    set(slotid,
                        buildItem(NoteIcon[j]) {
                            name = "&${if (NoteIsable[i][j]!=0) "e" else "8"}${NoteName[j]}音"
                            when (NoteIsable[i][j]) {
                                -1 -> lore.add("&f右键&c${NoteName[j]}#")
                                1 -> lore.add("&f左键&c${NoteName[j]}")
                                2 -> lore.add("&f左键&c${NoteName[j]}  &f右键&c${NoteName[j]}#")
                                0 -> lore.add("&f不支持这个音符")
                            }
                            colored()
                        }
                    )
                }
            }
            onClick() {event->
                event.isCancelled = true
                val note = FindNote(event.rawSlot,event.clickEvent().isRightClick)
                note?.let {
                    val blockData = noteblock.blockData as NoteBlock
                    blockData.note = note
                    blockData.isPowered = true
                    noteblock.blockData = blockData
                    event.clicker.playNote(noteblock.location,blockData.instrument,note)
                }
            }
        }
    }
    //找到被点击格子对应的音符
    fun FindNote(slotID: Int,sharped: Boolean): Note? {
        NoteSlot.forEachIndexed() { i, it ->
            it.forEachIndexed() { j, slotid ->
                if (slotid == slotID) {
                    when(NoteIsable[i][j]) {
                        -1 -> {
                            return if (sharped) Note(NoteID[i][j])
                            else null
                        }
                        1 -> {
                            return if (!sharped) Note(NoteID[i][j])
                            else null
                        }
                        2 -> return Note(NoteID[i][j]+(if (sharped) 1 else 0))
                        0 -> return null
                    }
                }

            }
        }
        return null
    }

}