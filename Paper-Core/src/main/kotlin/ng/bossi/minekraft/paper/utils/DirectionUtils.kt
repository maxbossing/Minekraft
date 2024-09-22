package ng.bossi.minekraft.paper.utils

import org.bukkit.Location
import javax.smartcardio.Card

enum class VerticalDirection { UP, DOWN, STRAIGHT}
enum class CardinalDirection { NORTH, EAST, SOUTH, WEST }

fun Location.verticalDirection(): VerticalDirection = when {
    pitch <= -45 -> VerticalDirection.DOWN
    pitch >= 45 -> VerticalDirection.UP
    else -> VerticalDirection.STRAIGHT
}

fun Location.cardinalDirection() = (if (yaw < 0) yaw + 360f else yaw).let {
    when {
        it >= 315 || it < 45 -> CardinalDirection.SOUTH
        it < 135 -> CardinalDirection.WEST
        it < 225 -> CardinalDirection.NORTH
        it < 315 -> CardinalDirection.EAST
        else -> CardinalDirection.NORTH
    }
}
