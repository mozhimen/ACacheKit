package com.mozhimen.cachek.mmkv.impls

import com.mozhimen.cachek.basic.bases.BaseCacheKVarProperty
import com.mozhimen.cachek.mmkv.helpers.CacheKMMKVProvider


/**
 * @ClassName CacheKSPDelegate
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2023/3/13 15:17
 * @Version 1.0
 */
class CacheKMMKVVarPropertyDouble(
    cacheKMMKVProvider: CacheKMMKVProvider, default: Double = 0.0
) : BaseCacheKVarProperty<CacheKMMKVProvider, Double>(cacheKMMKVProvider, default)