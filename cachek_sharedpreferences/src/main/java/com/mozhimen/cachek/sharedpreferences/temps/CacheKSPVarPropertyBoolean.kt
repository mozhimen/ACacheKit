package com.mozhimen.cachek.sharedpreferences.temps

import com.mozhimen.cachek.basic.bases.BaseCacheKVarPropertyBoolean
import com.mozhimen.cachek.sharedpreferences.helpers.CacheKSPProvider


/**
 * @ClassName CacheKSPDelegate
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2023/3/13 15:17
 * @Version 1.0
 */
class CacheKSPVarPropertyBoolean(
    cacheKSPProvider: CacheKSPProvider, key: String, default: Boolean = false
) : BaseCacheKVarPropertyBoolean<CacheKSPProvider>(cacheKSPProvider, key, default)