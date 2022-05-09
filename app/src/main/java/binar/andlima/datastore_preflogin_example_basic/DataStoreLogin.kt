package binar.andlima.datastore_preflogin_example_basic

import android.content.Context
import androidx.datastore.DataStore
import androidx.datastore.preferences.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DataStoreLogin(context : Context) {

    private val dataStore: DataStore<Preferences> = context.createDataStore(name = "user_pref")

    companion object{
        val USERNAME = preferencesKey<String>("USER_USERNAME")
        val PASSWORD = preferencesKey<String>("USER_PASSWORD")
    }
    //    MENAMBAHKAN DATA KE PREFERENCES
    suspend fun saveData(username : String, password : String){
        dataStore.edit {
            it[USERNAME] = username
            it[PASSWORD] = password
        }
    }

    //    UNTUK CLEAR DATA YANG ADA DI DATASTORE PREFERENCES
    suspend fun clearData(){
        dataStore.edit {
            it.clear()
        }
    }

    val userUsernameFlow : Flow<String> = dataStore.data.map {
        it[USERNAME] ?: ""
    }

}