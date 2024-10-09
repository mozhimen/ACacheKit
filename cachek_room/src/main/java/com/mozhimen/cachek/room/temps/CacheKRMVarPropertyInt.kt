package com.mozhimen.cachek.room.temps

import com.mozhimen.cachek.basic.bases.BaseCacheKVarPropertyInt
import com.mozhimen.cachek.basic.bases.BaseCacheKVarPropertySyncInt
import com.mozhimen.cachek.room.CacheKRM
import com.mozhimen.cachek.room.commons.ICacheKRMProvider


/**
 * @ClassName CacheKRMDelegateInt
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2023/3/13 15:17
 * @Version 1.0
 */
class CacheKRMVarPropertyInt(
    cacheKRMProvider: ICacheKRMProvider, key: String, default: Int = 0
) : BaseCacheKVarPropertySyncInt<ICacheKRMProvider>(cacheKRMProvider, key, default)