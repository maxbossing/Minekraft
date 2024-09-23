package ng.bossi.minekraft.paper.gui.kspigot.elements

import ng.bossi.minekraft.paper.gui.kspigot.ForInventory
import ng.bossi.minekraft.paper.gui.kspigot.GUIClickEvent
import ng.bossi.minekraft.paper.gui.kspigot.GUISlot

class GUIFreeSlot<T : ForInventory> : GUISlot<T>() {
    override fun onClick(clickEvent: GUIClickEvent<T>) {
        /* do nothing */
    }
}
