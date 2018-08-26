package pl.michalboryczko.bodyrating.ui.main.impl

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import butterknife.ButterKnife
import butterknife.OnClick
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*
import pl.michalboryczko.bodyrating.R
import pl.michalboryczko.bodyrating.base.BaseActivity
import pl.michalboryczko.bodyrating.ui.main.MainPresenter
import pl.michalboryczko.bodyrating.ui.main.MainView
import javax.inject.Inject
class MainActivity : BaseActivity(), MainView/*, Toolbar.OnMenuItemClickListener*/ {

	@Inject
	lateinit var presenter: MainPresenter

	companion object {
		fun prepareIntent(activity: Activity): Intent = Intent(activity, MainActivity::class.java)
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		activityComponent.inject(this)
		presenter.attachView(this)
		ButterKnife.bind(this)
	}


	@OnClick(R.id.rateGuysButton)
	fun rateGuysClicked(){
		navigator.navigateToRateActivity(this)
	}

	@OnClick(R.id.rateGirlsButton)
	fun rateGirlsClicked(){
		navigator.navigateToRateActivity(this)
	}



}

