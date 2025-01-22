package com.mozhimen.cachek.room.commons

import com.mozhimen.cachek.basic.commons.ICacheKProvider

/**
 * @ClassName ICacheKRMProvider
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/10/9
 * @Version 1.0
 */
interface ICacheKRMProvider : ICacheKProvider {
    fun putString(key: String, value: String)
    fun putBoolean(key: String, value: Boolean)
    fun putInt(key: String, value: Int)
    fun putLong(key: String, value: Long)
    fun putFloat(key: String, value: Float)
    fun putDouble(key: String, value: Double)
    fun putStringSet(key: String, value: Set<String>)

    /////////////////////////////////////////////////////////////////////

    fun getInt(key: String): Int
    fun getLong(key: String): Long
    fun getString(key: String): String
    fun getBoolean(key: String): Boolean
    fun getFloat(key: String): Float
    fun getDouble(key: String): Double
    fun getStringSet(key: String): Set<String>

    /////////////////////////////////////////////////////////////////////

    fun getInt(key: String, default: Int): Int
    fun getLong(key: String, default: Long): Long
    fun getString(key: String, default: String): String
    fun getBoolean(key: String, default: Boolean): Boolean
    fun getFloat(key: String, default: Float): Float
    fun getDouble(key: String, default: Double): Double
    fun getStringSet(key: String, default: Set<String>): Set<String>

    /////////////////////////////////////////////////////////////////////

    fun contains(key: String): Boolean
    fun remove(key: String)
    fun clear()
}