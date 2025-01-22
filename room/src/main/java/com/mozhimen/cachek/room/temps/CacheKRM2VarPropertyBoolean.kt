package com.mozhimen.cachek.room.temps

import com.mozhimen.cachek.basic.bases.BaseCacheKVarPropertySync
import com.mozhimen.cachek.room.commons.ICacheKRMProvider


/**
 * @ClassName CacheKRMDelegateBoolean
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2023/3/13 15:17
 * @Version 1.0
 */
class CacheKRM2VarPropertyBoolean(
    cacheKRMProvider: ICacheKRMProvider, default: Boolean = false
) : BaseCacheKVarPropertySync<ICacheKRMProvider, Boolean>(cacheKRMProvider, default)