package com.mozhimen.cachek.room.temps

import com.mozhimen.cachek.basic.bases.BaseCacheKVarPropertyFloat
import com.mozhimen.cachek.basic.bases.BaseCacheKVarPropertySyncFloat
import com.mozhimen.cachek.room.CacheKRM
import com.mozhimen.cachek.room.commons.ICacheKRMProvider


/**
 * @ClassName CacheKRMDelegateFloat
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2023/3/13 15:17
 * @Version 1.0
 */
class CacheKRMVarPropertyFloat(
    cacheKRMProvider: ICacheKRMProvider, key: String, default: Float = 0f
) : BaseCacheKVarPropertySyncFloat<ICacheKRMProvider>(cacheKRMProvider, key, default)