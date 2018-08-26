package pl.michalboryczko.bodyrating.executor

import io.reactivex.Scheduler

/**
 * Created on 16.08.2018.
 */
interface PostExecutionThread {

	fun getScheduler(): Scheduler

}