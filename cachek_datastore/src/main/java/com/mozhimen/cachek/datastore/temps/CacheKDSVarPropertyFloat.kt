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
class CacheKDSVarPropertyFloat(
    cacheKDSProvider: CacheKDSProvider, default: Float = 0f
) : BaseCacheKVarPropertySync<CacheKDSProvider,Float>(cacheKDSProvider, default)