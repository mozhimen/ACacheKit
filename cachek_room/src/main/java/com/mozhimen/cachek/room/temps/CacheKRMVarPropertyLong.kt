package com.mozhimen.cachek.room.temps

import com.mozhimen.cachek.basic.bases.BaseCacheKVarPropertyLong
import com.mozhimen.cachek.basic.bases.BaseCacheKVarPropertySyncLong
import com.mozhimen.cachek.room.CacheKRM

/**
 * @ClassName CacheKRMDelegateLong
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2023/3/13 15:17
 * @Version 1.0
 */
class CacheKRMVarPropertyLong(
    cacheKRMProvider: CacheKRM, key: String, default: Long = 0L
) : BaseCacheKVarPropertySyncLong<CacheKRM>(cacheKRMProvider, key, default)