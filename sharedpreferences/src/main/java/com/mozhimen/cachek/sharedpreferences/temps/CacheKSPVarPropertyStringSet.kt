package com.mozhimen.cachek.sharedpreferences.temps

import com.mozhimen.cachek.basic.bases.BaseCacheKVarProperty
import com.mozhimen.cachek.sharedpreferences.helpers.CacheKSPProvider


/**
 * @ClassName CacheKSPVarPropertyString
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2023/3/13 15:17
 * @Version 1.0
 */
class CacheKSPVarPropertyStringSet(
    cacheKSPProvider: CacheKSPProvider, default: Set<String> = emptySet()
) : BaseCacheKVarProperty<CacheKSPProvider,Set<String>>(cacheKSPProvider, default)