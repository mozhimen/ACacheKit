package com.mozhimen.cachek.datastore.helpers

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import com.mozhimen.cachek.datastore.commons.ICacheKDSProvider
import com.mozhimen.cachek.datastore.utils.edit_
import com.mozhimen.kotlin.elemk.kotlin.cons.CSuppress
import com.mozhimen.kotlin.utilk.bases.BaseUtilK
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

open class CacheKDSProvider(dsName: String) : ICacheKDSProvider, BaseUtilK() {
    private val Context._dataStore: DataStore<Preferences> by preferencesDataStore(name = dsName)
    open val dataStore: DataStore<Preferences> by lazy { _context._dataStore }

    /////////////////////////////////////////////////////////////////////

    fun <T> transform(key: String, value: T, mutablePreferences: MutablePreferences) {
        when (value) {
            is String -> mutablePreferences[stringPreferencesKey(key)] = value //putString(key, value)
            is Boolean -> mutablePreferences[booleanPreferencesKey(key)] = value
            is Int -> mutablePreferences[intPreferencesKey(key)] = value
            is Long -> mutablePreferences[longPreferencesKey(key)] = value
            is Float -> mutablePreferences[floatPreferencesKey(key)] = value
            is Double -> mutablePreferences[doublePreferencesKey(key)] = value
            is ByteArray -> mutablePreferences[byteArrayPreferencesKey(key)] = value
            is Set<*> -> mutablePreferences[stringSetPreferencesKey(key)] = value as Set<String>
            else -> throw IllegalArgumentException("This type cannot be saved to the Data Store")
        }
    }

    /////////////////////////////////////////////////////////////////////

    override suspend fun <T> putObjAsync(key: String, value: T) {
        dataStore.edit_(key, value, ::transform)
    }

    override suspend fun putIntAsync(key: String, value: Int) {
        putObjAsync(key, value)
    }

    override suspend fun putLongAsync(key: String, value: Long) {
        putObjAsync(key, value)
    }

    override suspend fun putStringAsync(key: String, value: String) {
        putObjAsync(key, value)
    }

    override suspend fun putBooleanAsync(key: String, value: Boolean) {
        putObjAsync(key, value)
    }

    override suspend fun putFloatAsync(key: String, value: Float) {
        putObjAsync(key, value)
    }

    override suspend fun putDoubleAsync(key: String, value: Double) {
        putObjAsync(key, value)
    }

    override suspend fun putStringSetAsync(key: String, value: Set<String>) {
        putObjAsync(key, value)
    }

    override suspend fun putByteArrayAsync(key: String, value: ByteArray) {
        putObjAsync(key, value)
    }

    /////////////////////////////////////////////////////////////////////

    override fun <T> putObj(key: String, obj: T) {
        runBlocking { putObjAsync(key, obj) }
    }

    override fun putInt(key: String, value: Int) {
        runBlocking { putIntAsync(key, value) }
    }

    override fun putLong(key: String, value: Long) {
        runBlocking { putLongAsync(key, value) }
    }

    override fun putString(key: String, value: String) {
        runBlocking { putStringAsync(key, value) }
    }

    override fun putBoolean(key: String, value: Boolean) {
        runBlocking { putBooleanAsync(key, value) }
    }

    override fun putFloat(key: String, value: Float) {
        runBlocking { putFloatAsync(key, value) }
    }

    override fun putDouble(key: String, value: Double) {
        runBlocking { putDoubleAsync(key, value) }
    }

    override fun putStringSet(key: String, value: Set<String>) {
        runBlocking { putStringSetAsync(key, value) }
    }

    override fun putByteArray(key: String, value: ByteArray) {
        runBlocking { putByteArrayAsync(key, value) }
    }

    /////////////////////////////////////////////////////////////////////

    @Suppress(CSuppress.UNCHECKED_CAST)
    override fun <T> getObj(key: String, default: T): T =
        when (default) {
            is Int -> getInt(key, default)
            is Long -> getLong(key, default)
            is String -> getString(key, default)
            is Boolean -> getBoolean(key, default)
            is Float -> getFloat(key, default)
            is Double -> getDouble(key, default)
            is Set<*> -> getStringSet(key, default as Set<String>)
            is ByteArray -> getByteArray(key, default)
            else -> throw IllegalArgumentException("This type cannot be saved to the Data Store")
        } as T

    /////////////////////////////////////////////////////////////////////

    override fun getInt(key: String): Int =
        getInt(key, 0)

    override fun getInt(key: String, default: Int): Int =
        runBlocking { return@runBlocking dataStore.data.map { it[intPreferencesKey(key)] ?: default }.first() }

    //

    override fun getLong(key: String): Long =
        getLong(key, 0L)

    override fun getLong(key: String, default: Long): Long =
        runBlocking { return@runBlocking dataStore.data.map { it[longPreferencesKey(key)] ?: default }.first() }

    //

    override fun getString(key: String): String =
        getString(key, "")

    override fun getString(key: String, default: String): String =
        runBlocking { return@runBlocking dataStore.data.map { it[stringPreferencesKey(key)] ?: default }.first() }

    //

    override fun getBoolean(key: String): Boolean =
        getBoolean(key, false)

    override fun getBoolean(key: String, default: Boolean): Boolean =
        runBlocking { return@runBlocking dataStore.data.map { it[booleanPreferencesKey(key)] ?: default }.first() }

    //

    override fun getFloat(key: String): Float =
        getFloat(key, 0f)

    override fun getFloat(key: String, default: Float): Float =
        runBlocking { return@runBlocking dataStore.data.map { it[floatPreferencesKey(key)] ?: default }.first() }

    //

    override fun getDouble(key: String): Double =
        getDouble(key, 0.0)

    override fun getDouble(key: String, default: Double): Double =
        runBlocking { return@runBlocking dataStore.data.map { it[doublePreferencesKey(key)] ?: default }.first() }

    //

    override fun getStringSet(key: String): Set<String> =
        getStringSet(key, emptySet())

    override fun getStringSet(key: String, default: Set<String>): Set<String> =
        runBlocking { return@runBlocking dataStore.data.map { it[stringSetPreferencesKey(key)] ?: default }.first() }

    //

    override fun getByteArray(key: String): ByteArray =
        getByteArray(key, ByteArray(0))

    override fun getByteArray(key: String, default: ByteArray): ByteArray =
        runBlocking { return@runBlocking dataStore.data.map { it[byteArrayPreferencesKey(key)] ?: default }.first() }

    /////////////////////////////////////////////////////////////////////

    inline fun <reified T> getPreferencesKey(key: String): Preferences.Key<out Any> =
        when (T::class) {
            Int::class -> intPreferencesKey(key)
            Long::class -> longPreferencesKey(key)
            String::class -> stringPreferencesKey(key)//putString(key, value)
            Boolean::class -> booleanPreferencesKey(key)
            Float::class -> floatPreferencesKey(key)
            Double::class -> doublePreferencesKey(key)
            Set::class -> stringSetPreferencesKey(key)
            ByteArray::class -> byteArrayPreferencesKey(key)
            else -> throw IllegalArgumentException("This type cannot be saved to the Data Store")
        }

    inline fun <reified T> remove(key: String) {
        runBlocking {
            val preferencesKey = getPreferencesKey<T>(key)
            dataStore.edit { if (it.contains(preferencesKey)) it.remove(preferencesKey) }
        }
    }

    inline fun <reified T> contains(key: String): Boolean =
        runBlocking {
            dataStore.data.map { it.contains(getPreferencesKey<T>(key)) }.first()
        }

    override fun clear() {
        runBlocking {
            dataStore.edit { it.clear() }
        }
    }

//    // At the top level of your kotlin file:
//    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")
//
//    private val EXAMPLE_COUNTER = intPreferencesKey("example_counter")
//
//    val exampleCounterFlow: Flow<Int> = this.dataStore.data
//        .map { preferences ->
//            // No type safety.
//            preferences[EXAMPLE_COUNTER] ?: 0
//        }
//
//    val userPreferencesFlow: Flow<MResultBS> = dataStore.data
//        .catch { exception ->
//            // datastore.data throws an IOException when an error is encountered when reading data
//            if (exception is IOException) {
//                UtilKLogWrapper.e(TAG，" Error reading preferences.", exception)
//                emit(emptyPreferences())
//            } else {
//                throw exception
//            }
//        }.map { preferences ->
//            mapUserPreferences()
//        }
//
//
//    suspend fun incrementCounter() {
//        this.dataStore.edit { settings ->
//            val currentCounterValue = settings[EXAMPLE_COUNTER] ?: 0
//            settings[EXAMPLE_COUNTER] = currentCounterValue + 1
//        }
//    }
}