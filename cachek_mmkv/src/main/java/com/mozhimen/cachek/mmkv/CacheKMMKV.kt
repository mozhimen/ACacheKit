package com.mozhimen.cachek.mmkv

import android.content.Context
import com.mozhimen.cachek.basic.commons.ICacheK
import com.mozhimen.cachek.mmkv.helpers.CacheKMMKVProvider
import com.mozhimen.kotlin.lintk.optins.OApiInit_InApplication
import com.tencent.mmkv.MMKV
import java.util.concurrent.ConcurrentHashMap

/**
 * @ClassName CacheKMMKV
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2023/9/27 16:40
 * @Version 1.0
 */
@OApiInit_InApplication
class CacheKMMKV : com.mozhimen.cachek.basic.commons.ICacheK<CacheKMMKVProvider> {
    companion object {
        @JvmStatic
        val instance = INSTANCE.holder
    }

    ////////////////////////////////////////////////////////////////////////////

    private val _mmkvMap = ConcurrentHashMap<String, CacheKMMKVProvider>()

    ////////////////////////////////////////////////////////////////////////////

    override fun with(name: String): CacheKMMKVProvider =
        with(name, false)

    fun init(context: Context) {
        MMKV.initialize(context)
    }

    fun with(name: String, isMultiProcess: Boolean): CacheKMMKVProvider {
        var mmkv = _mmkvMap[name]
        if (mmkv == null) {
            mmkv = CacheKMMKVProvider(name, isMultiProcess)
            _mmkvMap[name] = mmkv
        }
        return mmkv
    }

    ////////////////////////////////////////////////////////////////////////////

    private object INSTANCE {
        val holder = CacheKMMKV()
    }
}