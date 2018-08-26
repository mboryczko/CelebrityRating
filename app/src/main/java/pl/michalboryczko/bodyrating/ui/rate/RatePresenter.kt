package pl.michalboryczko.bodyrating.ui.rate

import android.util.Log
import io.reactivex.observers.DisposableSingleObserver
import pl.michalboryczko.bodyrating.base.mvp.Presenter
import pl.michalboryczko.bodyrating.executor.PostExecutionThread
import pl.michalboryczko.bodyrating.executor.ThreadExecutor
import pl.michalboryczko.bodyrating.interactor.GetGirlsUseCase
import pl.michalboryczko.bodyrating.model.Person
import pl.michalboryczko.bodyrating.model.PersonRating
import pl.michalboryczko.bodyrating.network.Repository
import pl.michalboryczko.bodyrating.storage.ResourceProvider
import pl.michalboryczko.bodyrating.storage.UserPreferences
import java.util.*
import javax.inject.Inject

class RatePresenter @Inject constructor(
        private val getGirlsUseCase: GetGirlsUseCase,
        private val userPreferences: UserPreferences,
        private val resourceProvider: ResourceProvider

): Presenter<RateView>() {

    private var cachedPersonList: MutableList<Person> = mutableListOf()
    private var cachedRatingList: MutableList<PersonRating> = mutableListOf()
    private var currentPerson: Person? = null

    override fun pause() = Unit
    override fun destroy() = Unit
    override fun resume() = Unit

    fun init(){
        view.showProgeress()
        getGirlsUseCase.execute(object: DisposableSingleObserver<List<Person>>(){
            override fun onSuccess(t: List<Person>) {
                cachedPersonList = t.toMutableList()
                view.showPerson(getNextPerson(null))
                view.hideProgress()

            }

            override fun onError(e: Throwable) {
                view.showMessage(e.toString())
            }
        })
    }

    fun getNextPerson(personRating: PersonRating?): Person{
        val nextPerson = getNextRandomPerson()
        /*nextPerson.images.forEach{
            it.replace("\\", "")
        }*/
        if(personRating != null)
            cachedRatingList.add(personRating)

        if(cachedPersonList.isNotEmpty()) {
            view.showPerson(nextPerson)
            currentPerson = nextPerson
            cachedPersonList.remove(nextPerson)

        }

        else{
            view.showMessage("wszystkie osoby zostały już ocenione")
            Log.d("ratePresenterLog", cachedRatingList.toString())
        }

        return nextPerson
    }

    private fun getNextRandomPerson(): Person{
        val r = Random()
        if(cachedPersonList.isNotEmpty()) {
            val index = r.nextInt(cachedPersonList.size)
            return cachedPersonList[index]
        }

        return Person("", "xd", "", "", mutableListOf())
    }


    fun nextPersonClicked(rating: Int){
        //view.showMessage(resourceProvider.communicate_rating_saved + "($rating)")
        if(currentPerson != null){
            val personRating = PersonRating(currentPerson!!.id, rating)
            getNextPerson(personRating)
        }


    }



}