package ng.bossi.minekraft.paper.extensions

import org.bukkit.entity.Player
import org.bukkit.inventory.EquipmentSlot
import org.bukkit.inventory.ItemStack

fun Player.saturate() {
    saturation = foodLevel.toFloat()
}

fun Player.hand(hand: EquipmentSlot) = when (hand) {
    EquipmentSlot.HAND -> inventory.itemInMainHand
    EquipmentSlot.OFF_HAND -> inventory.itemInOffHand
    else -> null
}

fun Player.give(vararg itemStacks: ItemStack) = inventory.addItem(*itemStacks)