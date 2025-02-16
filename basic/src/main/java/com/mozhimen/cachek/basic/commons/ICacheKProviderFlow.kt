package com.mozhimen.cachek.basic.commons

import kotlinx.coroutines.flow.Flow

/**
 * @ClassName ICacheKDSProviderFlow
 * @Description TODO
 * @Author mozhimen
 * @Date 2025/2/12
 * @Version 1.0
 */
interface ICacheKProviderFlow {
    fun <T> getFlowObj(key: String, default: T): Flow<T>
}