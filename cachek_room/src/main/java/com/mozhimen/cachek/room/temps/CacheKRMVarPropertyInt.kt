package com.mozhimen.cachek.room.temps

import com.mozhimen.cachek.basic.bases.BaseCacheKVarPropertyInt
import com.mozhimen.cachek.basic.bases.BaseCacheKVarPropertySyncInt
import com.mozhimen.cachek.room.CacheKRM


/**
 * @ClassName CacheKRMDelegateInt
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2023/3/13 15:17
 * @Version 1.0
 */
class CacheKRMVarPropertyInt(
    cacheKRMProvider: CacheKRM, key: String, default: Int = 0
) : BaseCacheKVarPropertySyncInt<CacheKRM>(cacheKRMProvider, key, default)