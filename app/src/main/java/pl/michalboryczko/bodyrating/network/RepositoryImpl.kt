package pl.michalboryczko.bodyrating.network

import javax.inject.Inject
import android.content.Context
import io.reactivex.Single
import io.reactivex.SingleTransformer
import pl.michalboryczko.bodyrating.lib.RepositoryStrings
import pl.michalboryczko.bodyrating.model.Person
import pl.michalboryczko.bodyrating.storage.UserPreferences
import retrofit2.Response
/**
 * Created on 16.08.2018.
 */

class RepositoryImpl @Inject constructor(val service: NetworkService,
										 val context: Context,
										 val preferences: UserPreferences) : Repository {


	override fun getGirls(): Single<List<Person>>
			= service.getGirls()


	override fun getMen(): Single<List<Person>> = service.getGuys()

	private fun <T> unpackResponseAndHandleErrors(): SingleTransformer<Response<T>, T> {
		return SingleTransformer { upstream ->
			upstream.flatMap {
				if(it.isSuccessful)
					Single.just(it.body())
				else{
					Single.error(Exception())
				}
			}
		}
	}
}



