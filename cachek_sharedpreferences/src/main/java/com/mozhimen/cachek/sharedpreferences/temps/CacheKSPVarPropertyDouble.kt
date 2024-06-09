package com.mozhimen.cachek.sharedpreferences.temps

import com.mozhimen.cachek.basic.bases.BaseCacheKVarPropertyDouble
import com.mozhimen.cachek.sharedpreferences.helpers.CacheKSPProvider


/**
 * @ClassName CacheKSPDelegate
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2023/3/13 15:17
 * @Version 1.0
 */
class CacheKSPVarPropertyDouble(
    cacheKSPProvider: CacheKSPProvider, key: String, default: Double = 0.0
) : BaseCacheKVarPropertyDouble<CacheKSPProvider>(cacheKSPProvider, key, default)