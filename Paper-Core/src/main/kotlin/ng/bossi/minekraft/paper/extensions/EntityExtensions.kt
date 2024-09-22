@file:Suppress("unused")

package ng.bossi.minekraft.paper.extensions

import org.bukkit.Location
import org.bukkit.attribute.Attribute
import org.bukkit.entity.Entity
import org.bukkit.entity.LivingEntity
import kotlin.math.sqrt

fun Entity.isInRadius(center: Location, radius: Double): Boolean = location.isInRadius(center, radius)
fun Entity.isInBox(loc1: Location, loc2: Location) = location.isInBox(loc1, loc2)

fun Entity.moveUpwards(distance: Int) = velocity.setY(sqrt(2 * distance * 9.81) * 0.08)

fun LivingEntity.heal() {
    health = getAttribute(Attribute.GENERIC_MAX_HEALTH)?.value
        ?: throw NullPointerException("The entity does not have a max health value!")
}