package pl.michalboryczko.bodyrating

/**
 * Created on 16.08.2018.
 */
/**
 * MainThread (UI Thread) implementation based on a scheduler
 * which will execute actions on the Android UI thread
 */


import javax.inject.Inject
import javax.inject.Singleton

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import pl.michalboryczko.bodyrating.executor.PostExecutionThread

@Singleton
class UiThread @Inject constructor() : PostExecutionThread {

	override fun getScheduler(): Scheduler = AndroidSchedulers.mainThread()

}
