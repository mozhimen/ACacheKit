package com.mozhimen.cachek.ext

import com.mozhimen.cachek.basic.bases.BaseCacheKVarProperty
import com.mozhimen.cachek.ext.impls.CacheKMutableLiveData
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

/**
 * @ClassName CacheKLiveDataProperty
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/12/9
 * @Version 1.0
 */
class CacheKValPropertyMutableLiveData<T> constructor(private val _cacheKVarProperty: BaseCacheKVarProperty<*, T>) : ReadOnlyProperty<Any?, CacheKMutableLiveData<T>> {
    private var _field: CacheKMutableLiveData<T>? = null

    override fun getValue(thisRef: Any?, property: KProperty<*>): CacheKMutableLiveData<T> =
        _field ?: CacheKMutableLiveData(
            _onGetValue = { _cacheKVarProperty.getValue(thisRef, property) },
            _onSetValue = { _cacheKVarProperty.setValue(thisRef, property, it) }
        ).also { _field = it }
}