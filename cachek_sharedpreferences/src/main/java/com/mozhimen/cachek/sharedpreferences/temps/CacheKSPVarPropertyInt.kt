package com.mozhimen.cachek.sharedpreferences.temps

import com.mozhimen.cachek.basic.bases.BaseCacheKVarPropertyInt
import com.mozhimen.cachek.sharedpreferences.helpers.CacheKSPProvider


/**
 * @ClassName CacheKSPDelegate
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2023/3/13 15:17
 * @Version 1.0
 */
class CacheKSPVarPropertyInt(
    cacheKSPProvider: CacheKSPProvider, key: String, default: Int = 0
) : BaseCacheKVarPropertyInt<CacheKSPProvider>(cacheKSPProvider, key, default)