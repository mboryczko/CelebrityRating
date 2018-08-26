package pl.michalboryczko.bodyrating.ui.rate

import pl.michalboryczko.bodyrating.base.mvp.BaseView
import pl.michalboryczko.bodyrating.model.GalleryItem
import pl.michalboryczko.bodyrating.model.Person

interface RateView: BaseView {
    fun showProgeress()
    fun hideProgress()
    fun showPerson(p: Person)
}