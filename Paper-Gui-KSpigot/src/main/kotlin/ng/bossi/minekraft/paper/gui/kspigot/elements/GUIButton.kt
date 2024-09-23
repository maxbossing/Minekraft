package ng.bossi.minekraft.paper.gui.kspigot.elements

import ng.bossi.minekraft.paper.gui.kspigot.ForInventory
import ng.bossi.minekraft.paper.gui.kspigot.GUIClickEvent
import ng.bossi.minekraft.paper.gui.kspigot.GUIElement
import org.bukkit.inventory.ItemStack

open class GUIButton<T : ForInventory>(
    private val icon: ItemStack,
    private val action: (GUIClickEvent<T>) -> Unit,
) : GUIElement<T>() {
    final override fun getItemStack(slot: Int) = icon
    override fun onClickElement(clickEvent: GUIClickEvent<T>) {
        clickEvent.bukkitEvent.isCancelled = true
        action(clickEvent)
    }
}
