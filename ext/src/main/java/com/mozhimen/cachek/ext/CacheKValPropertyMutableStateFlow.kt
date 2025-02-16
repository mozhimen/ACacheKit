package com.mozhimen.cachek.ext

import com.mozhimen.cachek.basic.bases.BaseCacheKVarProperty
import com.mozhimen.cachek.ext.impls.CacheKMutableStateFlow
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

/**
 * @ClassName CacheKLiveDataProperty
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/12/9
 * @Version 1.0
 */
class CacheKValPropertyMutableStateFlow<T> constructor(private val _cacheKVarProperty: BaseCacheKVarProperty<*, T>) : ReadOnlyProperty<Any?, CacheKMutableStateFlow<T>> {
    private var _field: CacheKMutableStateFlow<T>? = null

    override fun getValue(thisRef: Any?, property: KProperty<*>): CacheKMutableStateFlow<T> =
        _field ?: CacheKMutableStateFlow(
            _onGetValue = { _cacheKVarProperty.getValue(thisRef, property) },
            _onSetValue = { _cacheKVarProperty.setValue(thisRef, property, it) },
        ).also { _field = it }
}