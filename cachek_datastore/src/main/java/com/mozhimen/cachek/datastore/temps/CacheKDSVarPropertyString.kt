package com.mozhimen.cachek.datastore.temps

import com.mozhimen.cachek.basic.bases.BaseCacheKVarPropertyString
import com.mozhimen.cachek.basic.bases.BaseCacheKVarPropertySyncString
import com.mozhimen.cachek.datastore.helpers.CacheKDSProvider


/**
 * @ClassName CacheKDSVarPropertyString
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2023/3/13 15:17
 * @Version 1.0
 */
class CacheKDSVarPropertyString(
    cacheKDSProvider: CacheKDSProvider, key: String, default: String = ""
) : BaseCacheKVarPropertySyncString<CacheKDSProvider>(cacheKDSProvider,key,default)