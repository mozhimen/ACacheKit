package com.mozhimen.cachek.datastore.helpers

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.mozhimen.libk.jetpack.datastore.multiProcessPreferencesDataStore

/**
 * @ClassName CacheKDSProviderMultiProcess
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/6/14
 * @Version 1.0
 */
class CacheKDSProviderMultiProcess(dsName: String) : CacheKDSProvider(dsName) {
    private val Context._dataStore: DataStore<Preferences> by multiProcessPreferencesDataStore(name = dsName)
    override val dataStore: DataStore<Preferences> by lazy { _context._dataStore }
}