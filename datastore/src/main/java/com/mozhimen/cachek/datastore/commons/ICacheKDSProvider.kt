package com.mozhimen.cachek.datastore.commons

import com.mozhimen.cachek.basic.commons.ICacheKProvider

/**
 * @ClassName ICacheKDSProvider
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2024/12/7 1:12
 * @Version 1.0
 */
interface ICacheKDSProvider : ICacheKProvider {

    suspend fun <T> putObjAsync(key: String, value: T)
    suspend fun putIntAsync(key: String, value: Int)
    suspend fun putLongAsync(key: String, value: Long)
    suspend fun putStringAsync(key: String, value: String)
    suspend fun putBooleanAsync(key: String, value: Boolean)
    suspend fun putFloatAsync(key: String, value: Float)
    suspend fun putDoubleAsync(key: String, value: Double)
    suspend fun putStringSetAsync(key: String, value: Set<String>)
    suspend fun putByteArrayAsync(key: String, value: ByteArray)

    /////////////////////////////////////////////////////////////////////

    fun putString(key: String, value: String)
    fun putBoolean(key: String, value: Boolean)
    fun putInt(key: String, value: Int)
    fun putLong(key: String, value: Long)
    fun putFloat(key: String, value: Float)
    fun putDouble(key: String, value: Double)
    fun putStringSet(key: String, value: Set<String>)
    fun putByteArray(key: String, value: ByteArray)

    /////////////////////////////////////////////////////////////////////

    fun getInt(key: String): Int
    fun getLong(key: String): Long
    fun getString(key: String): String
    fun getBoolean(key: String): Boolean
    fun getFloat(key: String): Float
    fun getDouble(key: String): Double
    fun getStringSet(key: String): Set<String>
    fun getByteArray(key: String): ByteArray

    /////////////////////////////////////////////////////////////////////

    fun getInt(key: String, default: Int): Int
    fun getLong(key: String, default: Long): Long
    fun getString(key: String, default: String): String
    fun getBoolean(key: String, default: Boolean): Boolean
    fun getFloat(key: String, default: Float): Float
    fun getDouble(key: String, default: Double): Double
    fun getStringSet(key: String, default: Set<String>): Set<String>
    fun getByteArray(key: String, default: ByteArray): ByteArray

    /////////////////////////////////////////////////////////////////////

    fun clear()
}