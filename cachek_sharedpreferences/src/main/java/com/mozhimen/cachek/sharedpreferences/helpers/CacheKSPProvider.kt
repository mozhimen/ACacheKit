package com.mozhimen.cachek.sharedpreferences.helpers

import android.content.Context
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import com.mozhimen.cachek.sharedpreferences.commons.ICacheKSPProvider
import com.mozhimen.kotlin.elemk.kotlin.cons.CSuppress
import com.mozhimen.kotlin.utilk.bases.BaseUtilK
import com.mozhimen.kotlin.utilk.android.content.UtilKContext
import java.lang.IllegalArgumentException

/**
 * @ClassName CacheKSPProvider
 * @Description TODO
 * @Author mozhimen / Kolin Zhao
 * @Date 2022/5/25 16:35
 * @Version 1.0
 */
class CacheKSPProvider(spName: String) : ICacheKSPProvider, BaseUtilK() {

    private val _sharedPreferences: SharedPreferences by lazy { UtilKContext.getSharedPreferences(_context, spName, Context.MODE_PRIVATE) }

    /////////////////////////////////////////////////////////////////////

    fun getEditor(): Editor =
        _sharedPreferences.edit()

    fun <T> getPutEditor(key: String, value: T): Editor =
        when (value) {
            is String -> getEditor().putString(key, value)
            is Boolean -> getEditor().putBoolean(key, value)
            is Int -> getEditor().putInt(key, value)
            is Long -> getEditor().putLong(key, value)
            is Float -> getEditor().putFloat(key, value)
            is Set<*> -> getEditor().putStringSet(key, value as Set<String>)
            else -> throw IllegalArgumentException("Unknown Type.")
        }

    /////////////////////////////////////////////////////////////////////

    override fun <T> putObjSync(key: String, value: T) {
        when (value) {
            is String, Boolean, Int, Long, Float -> getPutEditor(key, value).commit()
            is Set<*> -> getPutEditor(key, value).commit()
        }
    }

    /////////////////////////////////////////////////////////////////////

    override fun putIntSync(key: String, value: String) {
        putObjSync(key, value)
    }

    override fun putLongSync(key: String, value: String) {
        putObjSync(key, value)
    }

    override fun putStringSync(key: String, value: String) {
        putObjSync(key, value)
    }

    override fun putBooleanSync(key: String, value: String) {
        putObjSync(key, value)
    }

    override fun putFloatSync(key: String, value: String) {
        putObjSync(key, value)
    }

    override fun putStringSetSync(key: String, value: Set<String>) {
        putObjSync(key, value)
    }

    override fun putDoubleSync(key: String, value: Double) {
        putObjSync(key, java.lang.Double.doubleToRawLongBits(value));
    }

//    fun putStringEncryptSync(key: String, value: String) {
//        if (value.isEmpty()) return
//        putObjSync(key, CryptoKAES.with(MCryptoAESConfig(secretKey = "5rfj4FVG&Td#$*Jd")).encryptWithBase64(value))
//    }

    /////////////////////////////////////////////////////////////////////

    override fun <T> putObj(key: String, obj: T) {
        getPutEditor(key, obj).apply()
    }

    /////////////////////////////////////////////////////////////////////

    override fun putInt(key: String, value: Int) {
        putObj(key, value)
    }

    override fun putLong(key: String, value: Long) {
        putObj(key, value)
    }

    override fun putString(key: String, value: String) {
        putObj(key, value)
    }

    override fun putBoolean(key: String, value: Boolean) {
        putObj(key, value)
    }

    override fun putFloat(key: String, value: Float) {
        putObj(key, value)
    }

    override fun putStringSet(key: String, value: Set<String>) {
        putObj(key, value)
    }

    override fun putDouble(key: String, value: Double) {
        putObj(key, java.lang.Double.doubleToRawLongBits(value))
    }

//    fun putStringEncrypt(key: String, value: String) {
//        if (value.isEmpty()) return
//        putObj(key, CryptoKAES.with(MCryptoAESConfig(secretKey = "5rfj4FVG&Td#$*Jd")).encryptWithBase64(value))
//    }

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
            else -> throw IllegalArgumentException("Unknown Type.")
        } as T

    /////////////////////////////////////////////////////////////////////

    override fun getInt(key: String): Int =
        getInt(key, 0)

    override fun getInt(key: String, default: Int): Int =
        _sharedPreferences.getInt(key, default)

    //

    override fun getLong(key: String): Long =
        getLong(key, 0L)

    override fun getLong(key: String, default: Long): Long =
        _sharedPreferences.getLong(key, default)

    //

    override fun getString(key: String): String =
        getString(key, "")

    override fun getString(key: String, default: String): String =
        _sharedPreferences.getString(key, default) ?: default

    //

    override fun getBoolean(key: String): Boolean =
        getBoolean(key, false)

    override fun getBoolean(key: String, default: Boolean): Boolean =
        _sharedPreferences.getBoolean(key, default)

    //

    override fun getFloat(key: String): Float =
        getFloat(key, 0F)

    override fun getFloat(key: String, default: Float): Float =
        _sharedPreferences.getFloat(key, default)

    //

    override fun getDouble(key: String): Double =
        getDouble(key, 0.0)

    override fun getDouble(key: String, default: Double): Double =
        java.lang.Double.longBitsToDouble(_sharedPreferences.getLong(key, default.toLong()))

    //

    override fun getStringSet(key: String): Set<String> =
        getStringSet(key, emptySet())

    override fun getStringSet(key: String, default: Set<String>): Set<String> =
        _sharedPreferences.getStringSet(key, default) ?: emptySet()

    /////////////////////////////////////////////////////////////////////

    override fun getAll(): MutableMap<String, *> =
        _sharedPreferences.all

    override fun contains(key: String): Boolean =
        _sharedPreferences.contains(key)

    override fun remove(key: String) {
        if (contains(key))
            getEditor().remove(key).apply()
    }

    override fun clear() {
        getEditor().clear().apply()
    }
}

