package ng.bossi.minekraft.extensions

import ng.bossi.minekraft.annotation.MinekraftInternal

@MinekraftInternal
class MinMaxPair<T : Comparable<T>>(a: T, b: T) {
    val min: T
    val max: T

    init {
        if (a >= b) {
            min = b; max = a
        } else {
            min = a; max = b
        }
    }
}