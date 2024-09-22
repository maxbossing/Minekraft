@file:Suppress("unused")

package ng.bossi.minekraft.paper.extensions

import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.inventory.PrepareItemCraftEvent
import org.bukkit.event.player.PlayerInteractEntityEvent
import org.bukkit.inventory.EquipmentSlot
import org.bukkit.inventory.ItemStack

var PrepareItemCraftEvent.isCancelled: Boolean
    get() = inventory.result?.type == Material.AIR
    set(value) {
        if (value) inventory.result = ItemStack(Material.AIR) else inventory.result = inventory.recipe?.result
    }

val PlayerInteractEntityEvent.usedItem: ItemStack?
    get() {
        val p: Player = this.player
        return when (this.hand) {
            EquipmentSlot.HAND -> p.inventory.itemInMainHand
            EquipmentSlot.OFF_HAND -> p.inventory.itemInOffHand
            else -> null
        }
    }