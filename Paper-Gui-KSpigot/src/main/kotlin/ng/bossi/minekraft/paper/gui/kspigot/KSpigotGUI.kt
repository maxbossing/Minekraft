package ng.bossi.minekraft.paper.gui.kspigot

import ng.bossi.minekraft.paper.Minekraft
import ng.bossi.minekraft.paper.module.PaperModule

object KSpigotGUI : PaperModule() {

    private val guiHolderProperty = lazy { GUIHolder }
    internal val guiHolder by guiHolderProperty

    override fun load(entrypoint: Minekraft) {}

    override fun start(entrypoint: Minekraft) {}

    override fun stop(entrypoint: Minekraft) {
        if (guiHolderProperty.isInitialized()) { guiHolderProperty.value.close() }
    }
}