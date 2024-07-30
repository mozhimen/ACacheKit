package com.mozhimen.cachek.basic.bases

import com.mozhimen.cachek.basic.commons.ICacheKProvider
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty


/**
 * @ClassName BaseCacheKDelegateInt
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2023/3/13 15:17
 * @Version 1.0
 */
open class BaseCacheKVarPropertySyncInt<P : ICacheKProvider>(
    private val _cacheKProvider: P,
    private val _key: String,
    private val _default: Int = 0
) : ReadWriteProperty<Any?, Int> {
    @Volatile
    private var _field = _cacheKProvider.getInt(_key, _default)

    override fun getValue(thisRef: Any?, property: KProperty<*>): Int {
        return synchronized(this){
            _field
        }
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
        synchronized(this){
            _field = value
            _cacheKProvider.putInt(_key, value)
        }
    }
}