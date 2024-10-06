package ng.bossi.minekraft.paper.extensions

import org.bukkit.Bukkit
import org.bukkit.entity.Player

/**
 * All online players
 * @since 0.0.1
 * @author Max Bossing
 */
val players: Collection<Player> get() = Bukkit.getOnlinePlayers()
