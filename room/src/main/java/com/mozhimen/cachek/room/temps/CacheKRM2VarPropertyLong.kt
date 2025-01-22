package com.mozhimen.cachek.room.temps

import com.mozhimen.cachek.basic.bases.BaseCacheKVarPropertySync
import com.mozhimen.cachek.room.commons.ICacheKRMProvider

/**
 * @ClassName CacheKRMDelegateLong
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2023/3/13 15:17
 * @Version 1.0
 */
class CacheKRM2VarPropertyLong(
    cacheKRMProvider: ICacheKRMProvider, default: Long = 0L
) : BaseCacheKVarPropertySync<ICacheKRMProvider, Long>(cacheKRMProvider, default)