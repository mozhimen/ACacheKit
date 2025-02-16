package com.mozhimen.cachek.datastore.temps

import com.mozhimen.cachek.basic.bases.BaseCacheKValPropertyFlow
import com.mozhimen.cachek.datastore.helpers.CacheKDSProvider


/**
 * @ClassName CacheKSPDelegate
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2023/3/13 15:17
 * @Version 1.0
 */
class CacheKDSValPropertyFlowBoolean(
    cacheKProvider: CacheKDSProvider, default: Boolean = false, propertyName: String = "",
) : BaseCacheKValPropertyFlow<CacheKDSProvider, Boolean>(cacheKProvider, default, propertyName)