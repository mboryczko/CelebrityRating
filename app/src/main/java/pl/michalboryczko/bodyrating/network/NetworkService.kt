package pl.michalboryczko.bodyrating.network

/**
 * Created on 16.08.2018.
 */

import android.support.annotation.Nullable
import io.reactivex.Single
import pl.michalboryczko.bodyrating.model.Person
import retrofit2.Response
import retrofit2.http.*

/**
 * Created by ${michal_boryczko} on 25.06.2018.
 */
interface NetworkService {

	@GET("bodyrating/girls.php")
	fun getGirls(
	): Single<List<Person>>


	@GET("bodyrating/guys.php")
	fun getGuys(
	): Single<List<Person>>

}