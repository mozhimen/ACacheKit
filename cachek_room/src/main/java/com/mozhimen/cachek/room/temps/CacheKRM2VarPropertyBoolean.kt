package com.mozhimen.cachek.room.temps

import com.mozhimen.cachek.basic.bases.BaseCacheKVarPropertyBoolean
import com.mozhimen.cachek.basic.bases.BaseCacheKVarPropertySyncBoolean
import com.mozhimen.cachek.room.CacheKRM
import com.mozhimen.cachek.room.commons.ICacheKRMProvider


/**
 * @ClassName CacheKRMDelegateBoolean
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2023/3/13 15:17
 * @Version 1.0
 */
class CacheKRM2VarPropertyBoolean(
    cacheKRMProvider: ICacheKRMProvider, key: String, default: Boolean = false
) : BaseCacheKVarPropertySyncBoolean<ICacheKRMProvider>(cacheKRMProvider, key, default)