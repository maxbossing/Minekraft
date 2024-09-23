package ng.bossi.minekraft.module

interface VanillaModule<T> {
    fun load(entrypoint: T)
    fun start(entrypoint: T)
    fun stop(entrypoint: T)
}