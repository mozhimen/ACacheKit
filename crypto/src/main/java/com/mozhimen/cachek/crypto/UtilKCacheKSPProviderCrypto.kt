package com.mozhimen.cachek.crypto

import com.mozhimen.cachek.basic.commons.ICacheKProvider
import com.mozhimen.cryptok.basic.CryptoKAES
import com.mozhimen.cryptok.basic.mos.MCryptoAESConfig

/**
 * @ClassName UtilKCacheKSPProviderCrypto
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2024/10/2 14:06
 * @Version 1.0
 */
fun ICacheKProvider.putString_ofCryptoAES(key: String, value: String, secretKey: String = "5rfj4FVG&Td#$*Jd") {
    UtilKCacheKSPProviderCrypto.putString_ofCryptoAES(this, key, value, secretKey)
}

fun ICacheKProvider.getString_ofCryptoAES(key: String, defaultValue: String = "", secretKey: String = "5rfj4FVG&Td#$*Jd"): String =
    UtilKCacheKSPProviderCrypto.getString_ofCryptoAES(this, key, defaultValue, secretKey)

//////////////////////////////////////////////////////////////////////////////////////////

object UtilKCacheKSPProviderCrypto {
    @JvmStatic
    fun putString_ofCryptoAES(cachekKProvider: ICacheKProvider, key: String, value: String, secretKey: String = "5rfj4FVG&Td#$*Jd") {
        if (value.isEmpty()) return
        cachekKProvider.putObj(key, CryptoKAES.with(MCryptoAESConfig(secretKey = secretKey)).encryptWithBase64(value))
    }

    @JvmStatic
    fun getString_ofCryptoAES(cachekKProvider: ICacheKProvider, key: String, defaultValue: String = "", secretKey: String = "5rfj4FVG&Td#$*Jd"): String {
        val value = cachekKProvider.getObj(key, defaultValue)
        return CryptoKAES.with(MCryptoAESConfig(secretKey = secretKey)).decryptWithBase64(value)
    }
}