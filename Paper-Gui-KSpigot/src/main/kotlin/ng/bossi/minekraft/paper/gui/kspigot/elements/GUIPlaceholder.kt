package ng.bossi.minekraft.paper.gui.kspigot.elements

import ng.bossi.minekraft.paper.gui.kspigot.ForInventory
import ng.bossi.minekraft.paper.gui.kspigot.GUIClickEvent
import ng.bossi.minekraft.paper.gui.kspigot.GUIElement
import org.bukkit.inventory.ItemStack

class GUIPlaceholder<T : ForInventory>(
    private val icon: ItemStack,
) : GUIElement<T>() {
    override fun getItemStack(slot: Int) = icon
    override fun onClickElement(clickEvent: GUIClickEvent<T>) {
        clickEvent.bukkitEvent.isCancelled = true
    }
}
