package ng.bossi.minekraft.paper.event

import ng.bossi.minekraft.paper.MinekraftInstance
import org.bukkit.Bukkit
import org.bukkit.event.Event
import org.bukkit.event.EventPriority
import org.bukkit.event.HandlerList
import org.bukkit.event.Listener

inline fun <reified T : Event> listener(listener: KListener<T>.() -> Unit) =
    KListener<T>()
        .apply(listener)
        .also { if (it.autoRegistration) it.register() }

class KListener<T : Event> : Listener {
    private val filters = mutableListOf<(T) -> Boolean>()
    private val handlers = mutableListOf<(T, KListener<T>) -> Unit>()

    var uses = 0

    var priority: EventPriority = EventPriority.NORMAL
    var ignoreCancelled: Boolean = false
    var autoRegistration: Boolean = true
    var maxUses: Int? = null

    fun filter(filter: (event: T) -> Boolean) = filters.add(filter)
    fun handler(handler: (event: T, listener: KListener<T>) -> Unit) = handlers.add(handler)

    @PublishedApi
    internal fun onEvent(event: T) {
        maxUses?.let { if (uses >= it) this.unregister() }
        if (filters.any { !it(event) }) return
        handlers.forEach { it(event, this) }
        uses++
    }
}

fun Listener.unregister() = HandlerList.unregisterAll(this)

inline fun <reified T : Event> KListener<T>.register() {
    Bukkit.getPluginManager().registerEvent(
        T::class.java,
        this,
        priority,
        { _, event -> (event as? T)?.let { this.onEvent(it) } },
        MinekraftInstance,
        ignoreCancelled
    )
    this.uses = 0
}