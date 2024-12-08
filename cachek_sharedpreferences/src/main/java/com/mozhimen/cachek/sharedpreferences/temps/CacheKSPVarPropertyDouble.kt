package com.mozhimen.cachek.sharedpreferences.temps

import com.mozhimen.cachek.basic.bases.BaseCacheKVarProperty
import com.mozhimen.cachek.sharedpreferences.helpers.CacheKSPProvider
import kotlin.reflect.KProperty


/**
 * @ClassName CacheKSPDelegate
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2023/3/13 15:17
 * @Version 1.0
 */
class CacheKSPVarPropertyDouble(
    cacheKSPProvider: CacheKSPProvider, default: Double = 0.0
) : BaseCacheKVarProperty<CacheKSPProvider, Double>(cacheKSPProvider, default) {
    override fun getValue(thisRef: Any?, property: KProperty<*>): Double =
        _field ?: _cacheKProvider.getDouble(property.name, _default).also { _field = it }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Double) {
        _field = value
        _cacheKProvider.putDouble(property.name, value)
    }
}