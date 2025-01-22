package com.mozhimen.cachek.sharedpreferences.commons

import com.mozhimen.cachek.basic.commons.ICacheKProvider

/**
 * @ClassName ICacheKSPProvider
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2024/12/8 12:41
 * @Version 1.0
 */
interface ICacheKSPProvider : ICacheKProvider {
    fun <T> putObjSync(key: String, value: T)
    fun putIntSync(key: String, value: String)
    fun putLongSync(key: String, value: String)
    fun putStringSync(key: String, value: String)
    fun putBooleanSync(key: String, value: String)
    fun putFloatSync(key: String, value: String)
    fun putStringSetSync(key: String, value: Set<String>)
    fun putDoubleSync(key: String, value: Double)

    /////////////////////////////////////////////////////////////////////

    fun putInt(key: String, value: Int)
    fun putLong(key: String, value: Long)
    fun putString(key: String, value: String)
    fun putBoolean(key: String, value: Boolean)
    fun putFloat(key: String, value: Float)
    fun putDouble(key: String, value: Double)
    fun putStringSet(key: String, value: Set<String>)

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
    fun getStringSet(key: String): Set<String>
    fun getStringSet(key: String, default: Set<String>): Set<String>

    /////////////////////////////////////////////////////////////////////

    fun getAll(): MutableMap<String, *>
    fun contains(key: String): Boolean
    fun remove(key: String)
    fun clear()
}