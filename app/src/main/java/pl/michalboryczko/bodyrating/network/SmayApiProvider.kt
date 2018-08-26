package pl.michalboryczko.bodyrating.network

import android.content.Context
import java.util.*

/**
 * Created on 20.08.2018.
 */
object SmayApiProvider{

	fun provideSmayApiMap(context: Context, path: String): Map<String, String> = loadSmayApiAsMap(context, path)

	private fun loadSmayApiAsMap(context: Context, path: String): Map<String, String> {
		val map = mutableMapOf<String, String>()
		return context.assets.open(path)
				.bufferedReader().useLines { lines ->
					lines.forEach {
						val list = it.split(",", "")
						val function = list[0]
						val register = list[1] + list[2]

						map.put(function, register)
					}

					return map
				}
	}
}