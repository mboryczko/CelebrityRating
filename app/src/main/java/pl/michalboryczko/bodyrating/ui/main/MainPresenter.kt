package pl.michalboryczko.bodyrating.ui.main

import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import pl.michalboryczko.bodyrating.base.mvp.Presenter
import pl.michalboryczko.bodyrating.network.Repository
import pl.michalboryczko.bodyrating.executor.ThreadExecutor
import pl.michalboryczko.bodyrating.executor.PostExecutionThread
import pl.michalboryczko.bodyrating.storage.UserPreferences
import javax.inject.Inject

/**
 * Created on 16.08.2018.
 */
class MainPresenter @Inject constructor(
		val repository: Repository,
		val threadExecutor: ThreadExecutor,
		val postExecutionThread: PostExecutionThread,
		val userPreferences: UserPreferences
): Presenter<MainView>(){

	override fun pause() = Unit
	override fun destroy() = Unit
	override fun resume() = Unit

}