package com.mozhimen.cachek.ext.utils

import com.mozhimen.cachek.basic.bases.BaseCacheKVarProperty
import com.mozhimen.cachek.ext.CacheKValPropertyMutableLiveData
import com.mozhimen.cachek.ext.CacheKValPropertyMutableStateFlow

/**
 * @ClassName UtilKCacheKExt
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/12/9
 * @Version 1.0
 */

fun <T> BaseCacheKVarProperty<*, T>.asMutableLiveData(): CacheKValPropertyMutableLiveData<T> =
    UtilKCacheKExt.asMutableLiveData(this)

fun <T> BaseCacheKVarProperty<*, T>.asMutableStateFlow(): CacheKValPropertyMutableStateFlow<T> =
    UtilKCacheKExt.asMutableStateFlow(this)

////////////////////////////////////////////////////////////////////

object UtilKCacheKExt {
    @JvmStatic
    fun <T> asMutableLiveData(cacheKVarProperty: BaseCacheKVarProperty<*, T>): CacheKValPropertyMutableLiveData<T> =
        CacheKValPropertyMutableLiveData(cacheKVarProperty)

    @JvmStatic
    fun <T> asMutableStateFlow(cacheKVarProperty: BaseCacheKVarProperty<*, T>): CacheKValPropertyMutableStateFlow<T> =
        CacheKValPropertyMutableStateFlow(cacheKVarProperty)
}