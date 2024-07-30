package com.mozhimen.cachek.datastore.temps

import com.mozhimen.cachek.basic.bases.BaseCacheKVarPropertyInt
import com.mozhimen.cachek.basic.bases.BaseCacheKVarPropertySyncInt
import com.mozhimen.cachek.datastore.helpers.CacheKDSProvider


/**
 * @ClassName CacheKSPDelegate
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2023/3/13 15:17
 * @Version 1.0
 */
class CacheKDSVarPropertyInt(
    cacheKDSProvider: CacheKDSProvider, key: String, default: Int = 0
) : BaseCacheKVarPropertySyncInt<CacheKDSProvider>(cacheKDSProvider, key, default)