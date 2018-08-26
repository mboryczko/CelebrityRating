package pl.michalboryczko.bodyrating.di.components

import dagger.Component
import pl.michalboryczko.bodyrating.AndroidApplication
import pl.michalboryczko.bodyrating.base.BaseActivity
import pl.michalboryczko.bodyrating.base.BaseFragment
import pl.michalboryczko.bodyrating.base.Navigator
import pl.michalboryczko.bodyrating.di.modules.ApplicationModule
import pl.michalboryczko.bodyrating.di.modules.ExecutorModule
import pl.michalboryczko.bodyrating.di.modules.InteractorModule
import pl.michalboryczko.bodyrating.di.modules.NetModule
import pl.michalboryczko.bodyrating.executor.PostExecutionThread
import pl.michalboryczko.bodyrating.executor.ThreadExecutor
import pl.michalboryczko.bodyrating.interactor.GetGirlsUseCase
import pl.michalboryczko.bodyrating.network.Repository
import pl.michalboryczko.bodyrating.storage.ResourceProvider
import pl.michalboryczko.bodyrating.storage.UserPreferences
import javax.inject.Singleton

/**
 * Created on 16.08.2018.
 */

/**
 * A component whose lifetime is the life of the application.
 */
@Singleton // Constraints this component to one-per-application or unscoped bindings.
@Component(
		modules = arrayOf(ApplicationModule::class, InteractorModule::class, ExecutorModule::class, NetModule::class))
interface ApplicationComponent {


	fun inject(baseActivity: BaseActivity)
	fun inject(baseFragment: BaseFragment)
	fun inject(androidApplication: AndroidApplication)


	fun provideGetGirlsUseCase(): GetGirlsUseCase


	fun navigator(): Navigator
	fun repository(): Repository
	fun threadExecutor(): ThreadExecutor
	fun postThreadExecutor(): PostExecutionThread
	fun sharedPreferences(): UserPreferences
	fun resourceProvider(): ResourceProvider

}