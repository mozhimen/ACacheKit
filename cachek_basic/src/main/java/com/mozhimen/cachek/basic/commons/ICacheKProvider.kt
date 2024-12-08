package com.mozhimen.cachek.basic.commons

/**
 * @ClassName ICacheKProvider
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2023/6/4 14:34
 * @Version 1.0
 */
interface ICacheKProvider {
    fun <T> putObj(key: String, obj: T)
    fun <T> getObj(key: String, default: T): T
}