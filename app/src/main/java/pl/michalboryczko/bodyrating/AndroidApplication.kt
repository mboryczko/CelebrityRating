package pl.michalboryczko.bodyrating

import android.app.Activity
import android.app.Application
import android.support.multidex.MultiDexApplication
import com.bugfender.sdk.Bugfender
import com.facebook.stetho.Stetho
import pl.michalboryczko.bodyrating.di.components.ApplicationComponent
import pl.michalboryczko.bodyrating.di.components.DaggerApplicationComponent
import pl.michalboryczko.bodyrating.di.modules.ApplicationModule
import pl.michalboryczko.bodyrating.di.modules.NetModule

/**
 * Created by ${michal_boryczko} on 14.08.2018.
 */
class AndroidApplication : MultiDexApplication() {

	lateinit var applicationComponent: ApplicationComponent
		private set

	override fun onCreate() {
		super.onCreate()

		initializeInjector()
		//initializeBugfender()
		initializeStetho()

		if(!BuildConfig.DEBUG) {
			//initializeFabric()
		}



	}




	private fun initializeStetho() = Stetho.initializeWithDefaults(this)

	private fun initializeInjector() {
		applicationComponent = DaggerApplicationComponent.builder()
				.applicationModule(ApplicationModule(this))
				.netModule(NetModule(this))
				.build()
		applicationComponent.inject(this)
	}

	companion object {
		fun getInstance(activity: Activity) = activity.application as AndroidApplication
	}
}