@file:Suppress("unused")

package ng.bossi.minekraft.paper

import ng.bossi.minekraft.paper.tasks.KRunnableHolder
import org.bukkit.plugin.java.JavaPlugin

lateinit var MinekraftInstance: Minekraft
    private set

abstract class Minekraft : JavaPlugin() {
    private val kRunnableHolderProperty = lazy { KRunnableHolder }
    internal val kRunnableHolder by kRunnableHolderProperty

    override fun onLoad() {
        MinekraftInstance = this
        load()
    }

    override fun onEnable() {
        start()
    }

    override fun onDisable() {
        stop()
        if (kRunnableHolderProperty.isInitialized()) kRunnableHolderProperty.value.close()
    }

    open fun load() {}
    open fun start() {}
    open fun stop() {}
}