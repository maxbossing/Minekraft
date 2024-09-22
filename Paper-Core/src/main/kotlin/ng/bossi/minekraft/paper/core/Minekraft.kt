package ng.bossi.minekraft.paper.core

import ng.bossi.minekraft.paper.core.tasks.KrunnableHolder
import org.bukkit.plugin.java.JavaPlugin

lateinit var MinekraftInstance: Minekraft
    private set

abstract class Minekraft : JavaPlugin() {

    override fun onLoad() {
        MinekraftInstance = this
        load()
    }
    override fun onEnable() { start() }
    override fun onDisable() { stop() }

    open fun load() {}
    open fun start() {}
    open fun stop() {}
}