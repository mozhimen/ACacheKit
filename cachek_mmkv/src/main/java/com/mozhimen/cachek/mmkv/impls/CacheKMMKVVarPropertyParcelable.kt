package com.mozhimen.cachek.mmkv.impls

import android.os.Parcelable
import com.mozhimen.cachek.basic.bases.BaseCacheKVarProperty
import com.mozhimen.cachek.mmkv.helpers.CacheKMMKVProvider
import kotlin.reflect.KProperty


/**
 * @ClassName CacheKSPDelegate
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2023/3/13 15:17
 * @Version 1.0
 */
class CacheKMMKVVarPropertyParcelable<T : Parcelable>(
    cacheKMMKVProvider: CacheKMMKVProvider, private val _clazz: Class<T>, default: T
) : BaseCacheKVarProperty<CacheKMMKVProvider, T>(cacheKMMKVProvider, default) {
    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return _field ?: _cacheKProvider.getParcelable(property.name, _clazz, _default).also { _field = it } ?: _default
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        _field = value
        _cacheKProvider.putParcelable(property.name, value)
    }
}