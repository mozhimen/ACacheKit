package com.mozhimen.cachek.basic.bases

import com.mozhimen.cachek.basic.commons.ICacheKProvider
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty


/**
 * @ClassName BaseCacheKVarPropertyString
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2023/3/13 15:17
 * @Version 1.0
 */
open class BaseCacheKVarPropertySyncStringSet<P : ICacheKProvider>(
    private val _cacheKProvider: P,
    private val _key: String,
    private val _default: Set<String> = emptySet()
) : ReadWriteProperty<Any?, Set<String>> {
    @Volatile
    private var _field = _cacheKProvider.getStringSet(_key, _default)

    override fun getValue(thisRef: Any?, property: KProperty<*>): Set<String> {
        return synchronized(this) {
            _field
        }
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Set<String>) {
        synchronized(this) {
            _field = value
            _cacheKProvider.putStringSet(_key, value)
        }
    }
}