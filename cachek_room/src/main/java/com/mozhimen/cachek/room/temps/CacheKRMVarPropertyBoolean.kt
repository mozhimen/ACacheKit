package com.mozhimen.cachek.room.temps

import com.mozhimen.cachek.basic.bases.BaseCacheKVarPropertyBoolean
import com.mozhimen.cachek.room.CacheKRM


/**
 * @ClassName CacheKRMDelegateBoolean
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2023/3/13 15:17
 * @Version 1.0
 */
class CacheKRMVarPropertyBoolean(
    cacheKRMProvider: CacheKRM, key: String, default: Boolean = false
) : BaseCacheKVarPropertyBoolean<CacheKRM>(cacheKRMProvider, key, default)