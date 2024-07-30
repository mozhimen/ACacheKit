package com.mozhimen.cachek.datastore.temps

import com.mozhimen.cachek.basic.bases.BaseCacheKVarPropertyDouble
import com.mozhimen.cachek.basic.bases.BaseCacheKVarPropertySyncDouble
import com.mozhimen.cachek.datastore.helpers.CacheKDSProvider


/**
 * @ClassName CacheKSPDelegate
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2023/3/13 15:17
 * @Version 1.0
 */
class CacheKDSVarPropertyDouble(
    cacheKDSProvider: CacheKDSProvider, key: String, default: Double = 0.0
) : BaseCacheKVarPropertySyncDouble<CacheKDSProvider>(cacheKDSProvider, key, default)