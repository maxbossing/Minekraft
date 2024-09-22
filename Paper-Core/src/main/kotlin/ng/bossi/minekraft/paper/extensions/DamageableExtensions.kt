package ng.bossi.minekraft.paper.extensions

import org.bukkit.entity.Damageable

fun Damageable.kill() {
    health = 0.0
}