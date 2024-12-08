package com.mozhimen.cachek.mmkv.commons

import android.os.Parcelable
import com.mozhimen.cachek.basic.commons.ICacheKProvider

/**
 * @ClassName ICacheKMMKVProvider
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2024/12/8 1:38
 * @Version 1.0
 */
interface ICacheKMMKVProvider : ICacheKProvider {
    fun putIntSync(key: String, value: String)
    fun putLongSync(key: String, value: String)
    fun putStringSync(key: String, value: String)
    fun putBooleanSync(key: String, value: String)
    fun putFloatSync(key: String, value: String)
    fun putStringSetSync(key: String, value: Set<String>)

    /////////////////////////////////////////////////////////////////////

    fun putInt(key: String, value: Int)
    fun putLong(key: String, value: Long)
    fun putString(key: String, value: String)
    fun putBoolean(key: String, value: Boolean)
    fun putFloat(key: String, value: Float)
    fun putDouble(key: String, value: Double)
    fun putByteArray(key: String, value: ByteArray)
    fun putStringSet(key: String, value: Set<String>)
    fun putParcelable(key: String, value: Parcelable)

    /////////////////////////////////////////////////////////////////////

    fun getInt(key: String): Int
    fun getInt(key: String, default: Int): Int
    fun getLong(key: String): Long
    fun getLong(key: String, default: Long): Long
    fun getString(key: String): String
    fun getString(key: String, default: String): String
    fun getBoolean(key: String): Boolean
    fun getBoolean(key: String, default: Boolean): Boolean
    fun getFloat(key: String): Float
    fun getFloat(key: String, default: Float): Float
    fun getDouble(key: String): Double
    fun getDouble(key: String, default: Double): Double
    fun getByteArray(key: String): ByteArray?
    fun getByteArray(key: String, default: ByteArray): ByteArray?
    fun getStringSet(key: String): Set<String>
    fun getStringSet(key: String, default: Set<String>): Set<String>
    fun <T : Parcelable> getParcelable(key: String, clazz: Class<T>): T?
    fun <T : Parcelable> getParcelable(key: String, clazz: Class<T>, default: T): T?

    /////////////////////////////////////////////////////////////////////

    fun getAll(): MutableMap<String, *>
    fun contains(key: String): Boolean
    fun remove(key: String)
    fun removeAllOf(vararg key: String)
    fun clear()
}