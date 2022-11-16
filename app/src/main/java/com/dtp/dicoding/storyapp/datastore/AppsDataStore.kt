package com.dtp.dicoding.storyapp.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(
    name = "AppsDataStore"
)

class AppsDataStore(private val context: Context) {

    var token by PreferenceDataStore(
        dataStore = context.dataStore,
        key = TOKEN,
        defaultValue = "https://private-gw.waresix.com/"
    )

    val isLogin get() = token.isNotBlank()

    suspend fun clear() {
        context.dataStore.edit {
            it.clear()
        }
    }

    companion object {
        private val TOKEN = stringPreferencesKey("token")
    }
}