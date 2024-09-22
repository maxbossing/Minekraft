package ng.bossi.minekraft.paper.tasks

import ng.bossi.minekraft.paper.MinekraftInstance
import org.bukkit.Bukkit
import org.bukkit.scheduler.BukkitRunnable
import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds

abstract class KTask(
    var counterUp: Long? = null,
    var counterDown: Long? = null
) : BukkitRunnable()


fun task(
    sync: Boolean = true,
    delay: Duration = Duration.ZERO,
    period: Duration? = 1.seconds,
    uses: Long? = null,
    safeCallback: Boolean = false,
    endCallback: (() -> Unit)? = null,
    task: ((KTask) -> Unit)
): KTask? {
    uses?.let { if (it == 0L) return null }

    object : KTask() {
        private var counter = 0L
        override fun run() {
            var shouldCancel = false
            uses?.let {
                counterDown = uses - counter
                counter++

                if (counter >= uses)
                    shouldCancel = true

                counterUp = counter
            }
            task(this)

            if (shouldCancel) cancel()

            if (isCancelled) {
                if (shouldCancel || safeCallback)
                    KrunnableHolder.activate(this)
                else
                    KrunnableHolder.remove(this)
            }
        }
    }.let { kTask ->
        endCallback?.let { KrunnableHolder.add(kTask, it, safeCallback) }
        period?.let {
            if (sync) kTask.runTaskTimer(MinekraftInstance, delay.inWholeSeconds * 20, period.inWholeSeconds * 20)
            else kTask.runTaskTimerAsynchronously(MinekraftInstance, delay.inWholeSeconds * 20, period.inWholeSeconds * 20)
        }

        return kTask
    }
}


fun delayTask(delay: Duration = Duration.ZERO, sync: Boolean = true, task: () -> Unit) =
    if (sync) Bukkit.getScheduler().runTaskLater(MinekraftInstance, task, delay.inWholeSeconds * 20)
    else Bukkit.getScheduler().runTaskLaterAsynchronously(MinekraftInstance, task, delay.inWholeSeconds * 20)
