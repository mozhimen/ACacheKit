package com.mozhimen.cachek.basic.bases

import com.mozhimen.cachek.basic.commons.ICacheKPropertyFlow
import com.mozhimen.cachek.basic.commons.ICacheKProviderFlow
import kotlinx.coroutines.flow.Flow
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty


/**
 * @ClassName BaseCacheKDelegateInt
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2023/3/13 15:17
 * @Version 1.0
 */
open class BaseCacheKValPropertyFlow<P : ICacheKProviderFlow, T> constructor(
    protected val _cacheKProviderFlow: P,
    protected open val _default: T,
    protected val _propertyName: String,
) : ReadOnlyProperty<Any?, Flow<T>>, ICacheKPropertyFlow {
    override fun getCacheKProviderFlow(): ICacheKProviderFlow =
        _cacheKProviderFlow

    override fun getValue(thisRef: Any?, property: KProperty<*>): Flow<T> =
        if (_propertyName.isNotEmpty()){
            _cacheKProviderFlow.getFlowObj(_propertyName, _default)
        }else{
            _cacheKProviderFlow.getFlowObj(property.name, _default)
        }
}