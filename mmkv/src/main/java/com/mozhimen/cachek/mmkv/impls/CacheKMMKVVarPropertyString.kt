package com.mozhimen.cachek.mmkv.impls

import com.mozhimen.cachek.basic.bases.BaseCacheKVarProperty
import com.mozhimen.cachek.mmkv.helpers.CacheKMMKVProvider


/**
 * @ClassName CacheKDSVarPropertyString
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2023/3/13 15:17
 * @Version 1.0
 */
class CacheKMMKVVarPropertyString(
    cacheKMMKVProvider: CacheKMMKVProvider, default: String = ""
) : BaseCacheKVarProperty<CacheKMMKVProvider, String>(cacheKMMKVProvider,default)