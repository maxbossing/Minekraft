@file:Suppress("unused")

package ng.bossi.minekraft.paper

import ng.bossi.minekraft.module.VanillaModule
import ng.bossi.minekraft.paper.module.PaperModule
import ng.bossi.minekraft.paper.tasks.KRunnableHolder
import org.bukkit.plugin.java.JavaPlugin

lateinit var MinekraftInstance: Minekraft
    private set

abstract class Minekraft : JavaPlugin() {
    private val kRunnableHolderProperty = lazy { KRunnableHolder }
    internal val kRunnableHolder by kRunnableHolderProperty

    open val modules: List<PaperModule>? = null

    override fun onLoad() {
        MinekraftInstance = this
        modules?.forEach { it.load(this) }
        load()
    }

    override fun onEnable() {
        modules?.forEach { it.start(this) }
        start()
    }

    override fun onDisable() {
        stop()
        modules?.forEach { it.stop(this) }
        if (kRunnableHolderProperty.isInitialized()) kRunnableHolderProperty.value.close()
    }

    open fun load() {}
    open fun start() {}
    open fun stop() {}
}