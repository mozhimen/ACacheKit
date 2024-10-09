package com.mozhimen.cachek.room.temps

import com.mozhimen.cachek.basic.bases.BaseCacheKVarPropertyDouble
import com.mozhimen.cachek.basic.bases.BaseCacheKVarPropertySyncDouble
import com.mozhimen.cachek.room.CacheKRM
import com.mozhimen.cachek.room.commons.ICacheKRMProvider


/**
 * @ClassName CacheKRMDelegateDouble
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2023/3/13 15:17
 * @Version 1.0
 */
class CacheKRMVarPropertyDouble(
    cacheKRMProvider: ICacheKRMProvider, key: String, default: Double = 0.0
) : BaseCacheKVarPropertySyncDouble<ICacheKRMProvider>(cacheKRMProvider, key, default)