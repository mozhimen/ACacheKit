package com.mozhimen.cachek.datastore.temps

import com.mozhimen.cachek.basic.bases.BaseCacheKVarPropertyLong
import com.mozhimen.cachek.basic.bases.BaseCacheKVarPropertySyncLong
import com.mozhimen.cachek.datastore.helpers.CacheKDSProvider

/**
 * @ClassName CacheKSPDelegate
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2023/3/13 15:17
 * @Version 1.0
 */
class CacheKDSVarPropertyLong(
    cacheKDSProvider: CacheKDSProvider, key: String, default: Long = 0L
) : BaseCacheKVarPropertySyncLong<CacheKDSProvider>(cacheKDSProvider, key, default)