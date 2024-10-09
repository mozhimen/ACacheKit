package com.mozhimen.cachek.room

import com.mozhimen.cachek.basic.commons.ICacheK
import com.mozhimen.cachek.room.helpers.CacheKRMProvider
import java.util.concurrent.ConcurrentHashMap

/**
 * @ClassName CacheK
 * @Description TODO
 * @Author Kolin Zhao / Mozhimen
 * @Version 1.0
 */
class CacheKRM2 : ICacheK<CacheKRMProvider> {
    companion object {
        @JvmStatic
        val instance = INSTANCE.holder
    }

    /////////////////////////////////////////////////////////////////////////////////////

    private val _rmMap = ConcurrentHashMap<String, CacheKRMProvider>()

    /////////////////////////////////////////////////////////////////////////////////////

    override fun with(name: String): CacheKRMProvider {
        var sp = _rmMap[name]
        if (sp == null) {
            sp = CacheKRMProvider(name)
            _rmMap[name] = sp
        }
        return sp
    }

    /////////////////////////////////////////////////////////////////////////////////////

    private object INSTANCE {
        val holder = CacheKRM2()
    }
}