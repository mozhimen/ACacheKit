package com.mozhimen.cachek.datastore.temps

import com.mozhimen.cachek.basic.bases.BaseCacheKVarPropertyBoolean
import com.mozhimen.cachek.datastore.helpers.CacheKDSProvider


/**
 * @ClassName CacheKSPDelegate
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2023/3/13 15:17
 * @Version 1.0
 */
class CacheKDSVarPropertyBoolean(
    cacheKDSProvider: CacheKDSProvider, key: String, default: Boolean = false
) : BaseCacheKVarPropertyBoolean<CacheKDSProvider>(cacheKDSProvider, key, default)