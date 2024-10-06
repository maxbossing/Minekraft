@file:Suppress("Unused")
package ng.bossi.minekraft.paper.tasks

import ng.bossi.minekraft.annotation.MinekraftInternal
import ng.bossi.minekraft.paper.MinekraftInstance
import org.bukkit.Bukkit
import org.bukkit.scheduler.BukkitRunnable
import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds

/**
 * Represents a [BukkitRunnable] with additional properties
 * @property counterUp Counts up the cycles if the task is infinite
 * @property counterDown Counts down the cycles until the task ends if `uses` is set in [task]
 * @author Jakob Kretzschmar (https://github.com/jakobkmar)
 * @author Max Bossing
 * @since 0.0.1
 * @see task
 */

abstract class KTask(
    var counterUp: Long? = null,
    var counterDown: Long? = null
) : BukkitRunnable()

/**
 * Creates a new [KTask]
 *
 * @param sync if it should run synchronous (true) or asynchronous (false)
 * @param delay Delay (in ticks) until the first execution
 * @param period Interval (in ticks) between executions
 * @param uses How many times the task should be executed - null for infinite
 * @param safeCallback If the endCallback should always be executed, even on shutdown or premature end
 * @param endCallback Callback that is executed when the task ends
 * @param task The [KTask] that will be executed every repetition
 * @author Jakob Kretzschmar (https://github.com/jakobkmar)
 * @since 0.0.1
 * @see [KTask]
  */
@OptIn(MinekraftInternal::class)
fun task(
    sync: Boolean = true,
    delay: Long = 0,
    period: Long? = 20,
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
                    KRunnableHolder.activate(this)
                else
                    KRunnableHolder.remove(this)
            }
        }
    }.let { kTask ->
        endCallback?.let { KRunnableHolder.add(kTask, it, safeCallback) }
        period?.let {
            if (sync) kTask.runTaskTimer(MinekraftInstance, delay, period)
            else kTask.runTaskTimerAsynchronously(
                MinekraftInstance,
                delay,
                period
            )
        }

        return kTask
    }
}

/**
 * Executes [task] after a delay
 * @param delay The delay in ticks
 * @param sync If [task] should be executed sync or async
 * @param task The block to execute
 * @since 0.0.1
 * @author Jakob Kretzschmar (https://github.com/jakobkmar)
 */
fun delayTask(delay: Long, sync: Boolean = true, task: () -> Unit) =
    if (sync) Bukkit.getScheduler().runTaskLater(MinekraftInstance, task, delay)
    else Bukkit.getScheduler().runTaskLaterAsynchronously(MinekraftInstance, task, delay)
