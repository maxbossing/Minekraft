package ng.bossi.minekraft.module

import ng.bossi.minekraft.annotation.MinekraftInternal

@MinekraftInternal
interface VanillaModule<T> {
    fun load(entrypoint: T)
    fun start(entrypoint: T)
    fun stop(entrypoint: T)
}