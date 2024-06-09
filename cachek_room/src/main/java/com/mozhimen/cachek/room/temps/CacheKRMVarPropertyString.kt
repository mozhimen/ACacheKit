package com.mozhimen.cachek.room.temps

import com.mozhimen.cachek.basic.bases.BaseCacheKVarPropertyString
import com.mozhimen.cachek.room.CacheKRM


/**
 * @ClassName CacheKRMVarPropertyString
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2023/3/13 15:17
 * @Version 1.0
 */
class CacheKRMVarPropertyString(
    cacheKRMProvider: CacheKRM, key: String, default: String = ""
) : BaseCacheKVarPropertyString<CacheKRM>(cacheKRMProvider,key,default)