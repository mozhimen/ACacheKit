package com.mozhimen.cachek.sharedpreferences.temps

import com.mozhimen.cachek.basic.bases.BaseCacheKVarPropertyFloat
import com.mozhimen.cachek.sharedpreferences.helpers.CacheKSPProvider


/**
 * @ClassName CacheKSPDelegate
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2023/3/13 15:17
 * @Version 1.0
 */
class CacheKSPVarPropertyFloat(
    cacheKSPProvider: CacheKSPProvider, key: String, default: Float = 0f
) : BaseCacheKVarPropertyFloat<CacheKSPProvider>(cacheKSPProvider, key, default)