package com.project.latitudetechnolabs.data.preferences

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

private const val KEY_SAVED_AT = "key_saved_at"


class PreferenceProvider(
    context: Context
) {

    private val appContext = context.applicationContext

    private val preferences: SharedPreferences
    get() = PreferenceManager.getDefaultSharedPreferences(appContext)


    fun savelastSavedAt(savedAt: String) {
        preferences.edit().putString(KEY_SAVED_AT, null).apply()
    }

    fun getlastSavedAt() : String? {
        return preferences.getString(KEY_SAVED_AT, null)
    }

}