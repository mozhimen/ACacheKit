package com.mozhimen.cachek.datastore.temps

import com.mozhimen.cachek.basic.bases.BaseCacheKVarPropertySync
import com.mozhimen.cachek.datastore.helpers.CacheKDSProvider


/**
 * @ClassName CacheKSPDelegate
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2023/3/13 15:17
 * @Version 1.0
 */
class CacheKDSVarPropertyDouble(
    cacheKDSProvider: CacheKDSProvider, default: Double = 0.0
) : BaseCacheKVarPropertySync<CacheKDSProvider,Double>(cacheKDSProvider, default)