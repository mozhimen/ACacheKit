package com.mozhimen.cachek.datastore.temps

import com.mozhimen.cachek.basic.bases.BaseCacheKVarPropertyFloat
import com.mozhimen.cachek.basic.bases.BaseCacheKVarPropertySyncFloat
import com.mozhimen.cachek.datastore.helpers.CacheKDSProvider


/**
 * @ClassName CacheKSPDelegate
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2023/3/13 15:17
 * @Version 1.0
 */
class CacheKDSVarPropertyFloat(
    cacheKDSProvider: CacheKDSProvider, key: String, default: Float = 0f
) : BaseCacheKVarPropertySyncFloat<CacheKDSProvider>(cacheKDSProvider, key, default)