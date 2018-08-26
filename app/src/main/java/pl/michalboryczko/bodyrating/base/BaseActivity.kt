package pl.michalboryczko.bodyrating.base

import android.content.Context
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import butterknife.ButterKnife
import pl.michalboryczko.bodyrating.AndroidApplication
import pl.michalboryczko.bodyrating.R
import pl.michalboryczko.bodyrating.di.components.ActivityComponent
import pl.michalboryczko.bodyrating.di.components.ApplicationComponent
import pl.michalboryczko.bodyrating.di.components.DaggerActivityComponent
import pl.michalboryczko.bodyrating.di.modules.ActivityModule
import pl.michalboryczko.bodyrating.network.Repository
import javax.inject.Inject

/**
 * Created on 16.08.2018.
 */

/**
 * Base [android.app.Activity] class for every Activity in this application.
 */
abstract class BaseActivity : AppCompatActivity() {

	@Inject
	lateinit var navigator: Navigator

	@Inject
	lateinit var repository: Repository

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		applicationComponent.inject(this)
		if (isTabletDevice()) {
			requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_SENSOR
		} else {
			requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
		}


	}

/*
	override fun attachBaseContext(base: Context?) {
		super.attachBaseContext(CalligraphyContextWrapper.wrap(base))
	}*/

	/**
	 * Get the Main Application component for dependency injection.
	 * @return [ApplicationComponent]
	 */

	val applicationComponent: ApplicationComponent
		get() = (application as AndroidApplication).applicationComponent

	val activityComponent: ActivityComponent
		get() = DaggerActivityComponent.builder().applicationComponent(applicationComponent)
				.activityModule(ActivityModule(this))
				.build()

	fun showKeyboard(view: View){
		//not working
		val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
		imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)

		//moves bottom navigation view up

		//window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);


		/*window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE)
		window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)*/


		//not working
		/*  (getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).showSoftInputFromInputMethod(
				  view.windowToken, 0)*/

		//not working
		/*val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
		imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY)*/
	}

	fun hideKeyboard(view: View){
		(getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).hideSoftInputFromWindow(
				view.windowToken, 0)
	}

	fun showMessage(msg: String){
		Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
	}

	override fun onSupportNavigateUp(): Boolean {
		onBackPressed()
		return true
	}

	internal fun isTabletDevice() = resources.getBoolean(R.bool.isTablet)
}