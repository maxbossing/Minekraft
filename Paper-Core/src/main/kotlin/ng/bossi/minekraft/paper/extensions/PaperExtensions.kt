package ng.bossi.minekraft.paper.extensions

import org.bukkit.Bukkit
import org.bukkit.entity.Player

val players: Collection<Player> get() = Bukkit.getOnlinePlayers()
