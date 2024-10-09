package com.mozhimen.cachek.room.temps

import com.mozhimen.cachek.basic.bases.BaseCacheKVarPropertyLong
import com.mozhimen.cachek.basic.bases.BaseCacheKVarPropertySyncLong
import com.mozhimen.cachek.room.CacheKRM
import com.mozhimen.cachek.room.commons.ICacheKRMProvider

/**
 * @ClassName CacheKRMDelegateLong
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2023/3/13 15:17
 * @Version 1.0
 */
class CacheKRMVarPropertyLong(
    cacheKRMProvider: ICacheKRMProvider, key: String, default: Long = 0L
) : BaseCacheKVarPropertySyncLong<ICacheKRMProvider>(cacheKRMProvider, key, default)