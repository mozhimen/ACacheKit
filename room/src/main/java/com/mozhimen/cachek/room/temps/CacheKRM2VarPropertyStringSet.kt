package com.mozhimen.cachek.room.temps

import com.mozhimen.cachek.basic.bases.BaseCacheKVarPropertySync
import com.mozhimen.cachek.room.commons.ICacheKRMProvider


/**
 * @ClassName CacheKRMVarPropertyString
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2023/3/13 15:17
 * @Version 1.0
 */
class CacheKRM2VarPropertyStringSet(
    cacheKRMProvider: ICacheKRMProvider, default: Set<String> = emptySet()
) : BaseCacheKVarPropertySync<ICacheKRMProvider, Set<String>>(cacheKRMProvider,default)