package com.mozhimen.cachek.room.temps

import com.mozhimen.cachek.basic.bases.BaseCacheKVarPropertySync
import com.mozhimen.cachek.room.commons.ICacheKRMProvider


/**
 * @ClassName CacheKRMDelegateDouble
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2023/3/13 15:17
 * @Version 1.0
 */
class CacheKRM2VarPropertyDouble(
    cacheKRMProvider: ICacheKRMProvider, default: Double = 0.0
) : BaseCacheKVarPropertySync<ICacheKRMProvider,Double>(cacheKRMProvider, default)