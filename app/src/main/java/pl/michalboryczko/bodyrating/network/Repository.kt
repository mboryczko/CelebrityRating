package pl.michalboryczko.bodyrating.network

import io.reactivex.Single
import pl.michalboryczko.bodyrating.model.Person

/**
 * Created on 16.08.2018.
 */
interface Repository {

	fun getGirls(): Single<List<Person>>
	fun getMen(): Single<List<Person>>


}