package com.mozhimen.cachek.datastore.temps

import com.mozhimen.cachek.basic.bases.BaseCacheKVarPropertyString
import com.mozhimen.cachek.basic.bases.BaseCacheKVarPropertySyncString
import com.mozhimen.cachek.basic.bases.BaseCacheKVarPropertySyncStringSet
import com.mozhimen.cachek.datastore.helpers.CacheKDSProvider


/**
 * @ClassName CacheKDSVarPropertyString
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2023/3/13 15:17
 * @Version 1.0
 */
class CacheKDSVarPropertyStringSet(
    cacheKDSProvider: CacheKDSProvider, key: String, default: Set<String> = emptySet(),
) : BaseCacheKVarPropertySyncStringSet<CacheKDSProvider>(cacheKDSProvider, key, default)