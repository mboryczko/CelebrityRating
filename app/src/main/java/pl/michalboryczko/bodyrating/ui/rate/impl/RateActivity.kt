package pl.michalboryczko.bodyrating.ui.rate.impl

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import butterknife.ButterKnife
import butterknife.OnClick
import kotlinx.android.synthetic.main.activity_rate.*
import pl.michalboryczko.bodyrating.R
import pl.michalboryczko.bodyrating.base.BaseActivity
import pl.michalboryczko.bodyrating.base.BaseActivity_MembersInjector
import pl.michalboryczko.bodyrating.commons.StarsAdapter
import pl.michalboryczko.bodyrating.model.GalleryItem
import pl.michalboryczko.bodyrating.model.Person
import pl.michalboryczko.bodyrating.ui.rate.RatePresenter
import pl.michalboryczko.bodyrating.ui.rate.RateView
import javax.inject.Inject

class RateActivity : BaseActivity(), RateView {

    lateinit var adapter: StarsAdapter

    companion object {
        fun prepareIntent(activity: Activity): Intent = Intent(activity, RateActivity::class.java)
    }

    @Inject
    lateinit var presenter: RatePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rate)
        activityComponent.inject(this)
        presenter.attachView(this)
        ButterKnife.bind(this)
        initRateRecycler()
    }

    override fun onResume() {
        super.onResume()
        presenter.init()
    }

    override fun showProgeress() {
        progressBar.visibility = View.VISIBLE
        gallery_pager.visibility = View.GONE
        page_indicator.visibility = View.GONE
        rateRecyler.visibility = View.GONE
        textView.visibility = View.GONE
        nextButton.visibility = View.GONE
    }

    override fun hideProgress() {
        progressBar.visibility = View.GONE
        gallery_pager.visibility = View.VISIBLE
        page_indicator.visibility = View.VISIBLE
        rateRecyler.visibility = View.VISIBLE
        textView.visibility = View.VISIBLE
        nextButton.visibility = View.VISIBLE
    }

    override fun showPerson(p: Person) {
        textView.text = p.name
        gallery_pager.adapter = ViewPagerAdapter(p.images.toMutableList())
        page_indicator.setViewPager(gallery_pager)
    }

    private fun initRateRecycler(){
        rateRecyler.layoutManager = LinearLayoutManager(this, LinearLayout.HORIZONTAL, false)
        adapter = StarsAdapter(this)
        rateRecyler.adapter = adapter
    }

    @OnClick(R.id.nextButton)
    fun nextButtonClicked(){

        presenter.nextPersonClicked(adapter.getSelectedStar())
    }
}
