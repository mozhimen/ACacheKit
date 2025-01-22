package com.mozhimen.cachek.datastore.utils

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.MutablePreferences
import androidx.datastore.preferences.core.Preferences

/**
 * @ClassName UtilKPreferences
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2024/12/7 0:22
 * @Version 1.0
 */
suspend fun <T> DataStore<Preferences>.edit_(key: String, value: T, transform: suspend (String, T, MutablePreferences) -> Unit): Preferences =
    UtilKPreferences.edit_(this, key, value, transform)

//////////////////////////////////////////////////////////////////////////

object UtilKPreferences {
    @JvmStatic
    suspend fun <T> edit_(dataStore: DataStore<Preferences>, key: String, value: T, transform: suspend (String, T, MutablePreferences) -> Unit): Preferences =
        dataStore.updateData {
            it.toMutablePreferences().apply { transform(key, value, this) }
        }
}