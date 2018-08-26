package pl.michalboryczko.bodyrating.di.modules

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import pl.michalboryczko.bodyrating.AndroidApplication
import pl.michalboryczko.bodyrating.UiThread
import pl.michalboryczko.bodyrating.base.Navigator
import pl.michalboryczko.bodyrating.di.DaggerNames
import pl.michalboryczko.bodyrating.executor.JobExecutor
import pl.michalboryczko.bodyrating.executor.PostExecutionThread
import pl.michalboryczko.bodyrating.executor.ThreadExecutor
import pl.michalboryczko.bodyrating.storage.ResourceProvider
import javax.inject.Named
import javax.inject.Singleton

/**
 * Created on 16.08.2018.
 */
@Module
class ApplicationModule(private val application: AndroidApplication) {

	@Provides
	@Named(DaggerNames.APPLICATION_CONTEXT)
	@Singleton
	internal fun provideApplicationContext(): Context = application

/*	@Provides
	@Singleton
	internal fun provideNavigator(): Navigator = Navigator()*/

	@Provides
	@Singleton
	internal fun providePostExecutionThread(uiThread: UiThread): PostExecutionThread = uiThread

	@Provides
	@Singleton
	internal fun provideThreadExecutor(jobExecutor: JobExecutor): ThreadExecutor = jobExecutor


	@Provides
	@Singleton
	internal fun provideSharedPreferences(@Named(DaggerNames.APPLICATION_CONTEXT) context: Context): SharedPreferences =
	//SecurePreferences(context, "", "mobile_shop")
			context.getSharedPreferences("smay_preferences", Context.MODE_PRIVATE)


	@Provides
	@Singleton
	internal fun provideResourceProvider(@Named(DaggerNames.APPLICATION_CONTEXT) context: Context): ResourceProvider = ResourceProvider(context)


	@Provides
	@Singleton
	internal fun provideNavigator(): Navigator = Navigator()




}