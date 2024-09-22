@file:Suppress("unused")

package ng.bossi.minekraft.paper.items

import net.kyori.adventure.text.Component
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.ItemMeta

fun itemStack(material: Material, builder: ItemStack.() -> Unit) = ItemStack(material).apply(builder)

inline fun <reified T : ItemMeta> ItemStack.meta(builder: T.() -> Unit) =
    ((itemMeta as? T) ?: itemMeta(type, builder))?.let {
        itemMeta = it.apply(builder)
    }

inline fun <reified T : ItemMeta> itemMeta(material: Material, builder: T.() -> Unit): T? =
    Bukkit.getItemFactory().getItemMeta(material).let {
        if (it is T) it.apply(builder) else null
    }

fun ItemMeta.flag(itemFlag: ItemFlag) = addItemFlags(itemFlag)
fun ItemMeta.flags(vararg itemFlag: ItemFlag) = addItemFlags(*itemFlag)
fun ItemMeta.removeFlag(itemFlag: ItemFlag) = removeItemFlags(itemFlag)
fun ItemMeta.removeFlags(vararg itemFlag: ItemFlag) = removeItemFlags(*itemFlag)

var ItemMeta.displayName: Component?
    get() = if (hasDisplayName()) displayName() else null
    set(value) = displayName(value ?: Component.empty())

var ItemMeta.customModelData: Int?
    get() = if (hasCustomModelData()) customModelData else null
    set(value) = setCustomModelData(value)
