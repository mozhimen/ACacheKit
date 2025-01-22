package com.mozhimen.cachek.mmkv.helpers

import android.content.SharedPreferences
import android.os.Parcelable
import com.mozhimen.cachek.basic.commons.ICacheKProvider
import com.mozhimen.cachek.mmkv.commons.ICacheKMMKVProvider
import com.tencent.mmkv.MMKV
import java.lang.IllegalArgumentException

/**
 * @ClassName CacheKMMKVProvider
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2023/9/27 16:41
 * @Version 1.0
 */
class CacheKMMKVProvider(mmkvName: String, isMultiProcess: Boolean) : ICacheKMMKVProvider {

    private val _mmkv: MMKV by lazy { if (isMultiProcess) MMKV.mmkvWithID(mmkvName, MMKV.MULTI_PROCESS_MODE) else MMKV.mmkvWithID(mmkvName) }

    /////////////////////////////////////////////////////////////////////

    fun getEditor(): SharedPreferences.Editor =
        _mmkv.edit()

    fun <T> getPutEditor(key: String, value: T): SharedPreferences.Editor =
        when (value) {
            is Int -> getEditor().putInt(key, value)
            is Long -> getEditor().putLong(key, value)
            is String -> getEditor().putString(key, value)
            is Boolean -> getEditor().putBoolean(key, value)
            is Float -> getEditor().putFloat(key, value)
            is Set<*> -> getEditor().putStringSet(key, value as Set<String>)
            else -> throw IllegalArgumentException("Unknown Type.")
        }

    /////////////////////////////////////////////////////////////////////

    fun <T> putObjSync(key: String, value: T) {
        getPutEditor(key, value).commit()
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

    /////////////////////////////////////////////////////////////////////

    override fun <T> putObj(key: String, obj: T) {
//        getPutEditor(key, obj).apply()
        when (obj) {
            is Int, Long, String, Boolean, Float -> getPutEditor(key, obj).apply()
            is Set<*> -> getPutEditor(key,obj).apply()
            is Double -> _mmkv.encode(key, obj)
            is ByteArray -> _mmkv.encode(key, obj)
            is Parcelable -> _mmkv.encode(key, obj)
        }
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

    override fun putDouble(key: String, value: Double) {
        putObj(key, value)
    }

    override fun putByteArray(key: String, value: ByteArray) {
        putObj(key, value)
    }

    override fun putStringSet(key: String, value: Set<String>) {
        putObj(key, value)
    }

    override fun putParcelable(key: String, value: Parcelable) {
        putObj(key, value)
    }

    /////////////////////////////////////////////////////////////////////

    override fun <T> getObj(key: String, default: T): T =
        when (default) {
            is Int -> getInt(key, default)
            is Long -> getLong(key, default)
            is String -> getString(key, default)
            is Boolean -> getBoolean(key, default)
            is Float -> getFloat(key, default)
            is Double -> getDouble(key, default)
            is ByteArray -> getByteArray(key, default)
            is Set<*> -> getStringSet(key, default as Set<String>)
            else -> throw IllegalArgumentException("Unknown Type.")
        } as T

    /////////////////////////////////////////////////////////////////////

    override fun getInt(key: String): Int =
        _mmkv.decodeInt(key)

    override fun getInt(key: String, default: Int): Int =
        _mmkv.decodeInt(key, default)

    //

    override fun getLong(key: String): Long =
        _mmkv.decodeLong(key)

    override fun getLong(key: String, default: Long): Long =
        _mmkv.decodeLong(key, default)

    //

    override fun getString(key: String): String =
        _mmkv.decodeString(key) ?: ""

    override fun getString(key: String, default: String): String =
        _mmkv.decodeString(key, default) ?: ""

    //

    override fun getBoolean(key: String): Boolean =
        _mmkv.decodeBool(key)

    override fun getBoolean(key: String, default: Boolean): Boolean =
        _mmkv.decodeBool(key, default)

    //

    override fun getFloat(key: String): Float =
        _mmkv.decodeFloat(key)

    override fun getFloat(key: String, default: Float): Float =
        _mmkv.decodeFloat(key, default)

    //

    override fun getDouble(key: String): Double =
        _mmkv.decodeDouble(key)

    override fun getDouble(key: String, default: Double): Double =
        _mmkv.decodeDouble(key, default)

    //

    override fun getByteArray(key: String): ByteArray? =
        _mmkv.decodeBytes(key)

    override fun getByteArray(key: String, default: ByteArray): ByteArray? =
        _mmkv.decodeBytes(key, default)

    //

    override fun getStringSet(key: String): Set<String> =
        _mmkv.decodeStringSet(key) ?: emptySet()

    override fun getStringSet(key: String, default: Set<String>): Set<String> =
        _mmkv.decodeStringSet(key, default) ?: default

    //

    override fun <T : Parcelable> getParcelable(key: String, clazz: Class<T>): T? =
        _mmkv.decodeParcelable(key, clazz)

    override fun <T : Parcelable> getParcelable(key: String, clazz: Class<T>, default: T): T? =
        _mmkv.decodeParcelable(key, clazz, default)

    //

    override fun getAll(): MutableMap<String, *> =
        _mmkv.all

    /////////////////////////////////////////////////////////////////////

    override fun contains(key: String): Boolean =
        _mmkv.containsKey(key)

    override fun remove(key: String) {
        if (contains(key))
            getEditor().remove(key).apply()
    }

    override fun removeAllOf(vararg key: String) {
        _mmkv.removeValuesForKeys(key)
    }

    override fun clear() {
        _mmkv.edit().clear().apply()
    }
}