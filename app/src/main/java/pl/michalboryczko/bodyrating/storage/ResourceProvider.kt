package pl.michalboryczko.bodyrating.storage

/**
 * Created on 16.08.2018.
 */

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import pl.michalboryczko.bodyrating.R
import javax.inject.Inject

class ResourceProvider @Inject constructor(val context: Context) {
	var text_view_unlock = context.resources.getString(R.string.text_view_unlock)
	var text_view_lock = context.resources.getString(R.string.text_view_lock)


	var communicate_rating_saved = context.resources.getString(R.string.communicate_rating_saved)

}
