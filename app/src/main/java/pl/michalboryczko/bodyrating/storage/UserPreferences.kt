package pl.michalboryczko.bodyrating.storage

/**
 * Created on 16.08.2018.
 */

import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import javax.inject.Inject

class UserPreferences @Inject constructor(val sharedPreferences: SharedPreferences, val gson: Gson) {

	private object Key {
		const val USER_EMAIL = "user_email"
		const val PINCODE = "pincode"
		const val KIOSK_MODE = "kiosk_mode"
	}

	var userEmail: String
		get() = sharedPreferences.getString(Key.USER_EMAIL, "")
		set(value) = sharedPreferences.edit().putString(Key.USER_EMAIL, value).apply()


	var pincode: String
		get() = sharedPreferences.getString(Key.PINCODE, "0000")
		set(value) = sharedPreferences.edit().putString(Key.PINCODE, value).apply()


	var kioskMode: Boolean
		get() = sharedPreferences.getBoolean(Key.KIOSK_MODE, false)
		set(value) = sharedPreferences.edit().putBoolean(Key.KIOSK_MODE, value).apply()



}
