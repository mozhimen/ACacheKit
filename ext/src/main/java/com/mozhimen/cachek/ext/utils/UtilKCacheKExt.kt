package com.mozhimen.cachek.ext.utils

import com.mozhimen.cachek.basic.bases.BaseCacheKVarProperty
import com.mozhimen.cachek.ext.CacheKMutableLiveDataProperty
import com.mozhimen.cachek.ext.CacheKMutableStateFlowProperty

/**
 * @ClassName UtilKCacheKExt
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/12/9
 * @Version 1.0
 */

fun <T> BaseCacheKVarProperty<*, T>.asCacheKMutableLiveData(): CacheKMutableLiveDataProperty<T> =
    UtilKCacheKExt.asCacheKMutableLiveData(this)

fun <T> BaseCacheKVarProperty<*, T>.asCacheKMutableStateFlow(): CacheKMutableStateFlowProperty<T> =
    UtilKCacheKExt.asCacheKMutableStateFlow(this)

////////////////////////////////////////////////////////////////////

object UtilKCacheKExt {
    @JvmStatic
    fun <T> asCacheKMutableLiveData(cacheKVarProperty: BaseCacheKVarProperty<*, T>): CacheKMutableLiveDataProperty<T> =
        CacheKMutableLiveDataProperty(cacheKVarProperty)

    @JvmStatic
    fun <T> asCacheKMutableStateFlow(cacheKVarProperty: BaseCacheKVarProperty<*, T>): CacheKMutableStateFlowProperty<T> =
        CacheKMutableStateFlowProperty(cacheKVarProperty)
}