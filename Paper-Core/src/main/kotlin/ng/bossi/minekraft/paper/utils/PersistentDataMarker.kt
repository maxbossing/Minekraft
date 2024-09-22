@file:Suppress("unused")

package ng.bossi.minekraft.paper.utils

import ng.bossi.minekraft.paper.MinekraftInstance
import ng.bossi.minekraft.paper.items.meta
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.ItemMeta
import org.bukkit.persistence.PersistentDataHolder
import org.bukkit.persistence.PersistentDataType

private fun key(key: String) = NamespacedKey(MinekraftInstance, "marker_$key")

fun PersistentDataHolder.mark(key: String) =
    persistentDataContainer.set(key(key), PersistentDataType.BYTE, 1.toByte())

fun PersistentDataHolder.unmark(key: String) = persistentDataContainer.remove(key(key))
fun PersistentDataHolder.isMarked(key: String) = persistentDataContainer.has(key(key), PersistentDataType.BYTE)


fun ItemStack.mark(key: String) = meta<ItemMeta> { mark(key) }
fun ItemStack.unmark(key: String) = meta<ItemMeta> { unmark(key) }
fun ItemStack.isMarked(key: String): Boolean {
    var result = false
    meta<ItemMeta> { result = isMarked(key) }
    return result
}