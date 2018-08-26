package pl.michalboryczko.bodyrating.di.components

import dagger.Component
import pl.michalboryczko.bodyrating.ui.main.impl.MainActivity
import pl.michalboryczko.bodyrating.di.modules.ActivityModule
import pl.michalboryczko.bodyrating.di.scopes.ActivityScope
import pl.michalboryczko.bodyrating.ui.rate.impl.RateActivity

/**
 * Created on 16.08.2018.
 */

@ActivityScope
@Component(dependencies = arrayOf(ApplicationComponent::class), modules = arrayOf(ActivityModule::class))
interface ActivityComponent {

	fun inject(mainActivity: MainActivity)
	fun inject(rateActivity: RateActivity)


}