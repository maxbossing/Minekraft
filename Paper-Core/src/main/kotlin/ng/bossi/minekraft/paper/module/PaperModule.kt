package ng.bossi.minekraft.paper.module

import ng.bossi.minekraft.annotation.MinekraftInternal
import ng.bossi.minekraft.module.VanillaModule
import ng.bossi.minekraft.paper.Minekraft

/**
 * Module Entrypoint for Paper Modules
 * @see VanillaModule
 * @author Max Bossing
 * @since 0.0.1
 */
@OptIn(MinekraftInternal::class)
abstract class PaperModule() : VanillaModule<Minekraft>