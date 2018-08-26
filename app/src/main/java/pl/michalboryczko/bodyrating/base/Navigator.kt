package pl.michalboryczko.bodyrating.base

import android.app.Activity
import pl.michalboryczko.bodyrating.ui.main.impl.MainActivity
import pl.michalboryczko.bodyrating.ui.rate.impl.RateActivity
import javax.inject.Singleton

/**
 * Created on 16.08.2018.
 */
@Singleton
class Navigator {

	fun navigateToMainActivity(activity: Activity) = activity.apply { startActivity(MainActivity.prepareIntent(activity)) }
	fun navigateToRateActivity(activity: Activity) = activity.apply { startActivity(RateActivity.prepareIntent(activity)) }

}
