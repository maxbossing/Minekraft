package ng.bossi.minekraft.paper.extensions

import org.bukkit.inventory.Inventory

fun Inventory.closeForViewers() = HashSet(viewers).forEach { it.closeInventory() }