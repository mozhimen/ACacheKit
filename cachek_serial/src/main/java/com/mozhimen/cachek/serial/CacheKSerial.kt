package com.mozhimen.cachek.serial

import com.mozhimen.cachek.serial.helpers.SerialProvider
import java.util.concurrent.ConcurrentHashMap


/**
 * @ClassName PostKEncodeSerialNo
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2023/7/21 19:08
 * @Version 1.0
 */
class CacheKSerial {
    companion object {
        @JvmStatic
        val instance = INSTANCE.holder
    }

    /////////////////////////////////////////////////////////////////////////////////////

    private val _snMap = ConcurrentHashMap<String, SerialProvider>()

    /////////////////////////////////////////////////////////////////////////////////////

    fun with(name: String): SerialProvider {
        var sn = _snMap[name]
        if (sn == null) {
            sn = SerialProvider(name)
            _snMap[name] = sn
        }
        return sn
    }

    /////////////////////////////////////////////////////////////////////////////////////

    private object INSTANCE {
        val holder = CacheKSerial()
    }
}