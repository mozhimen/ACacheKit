package com.mozhimen.cachek.datastore.test

import com.mozhimen.cachek.datastore.CacheKDS
import com.mozhimen.cachek.datastore.temps.CacheKDSVarPropertyString
import com.mozhimen.cachek.ext.utils.asCacheKMutableLiveData
import com.mozhimen.kotlin.elemk.androidx.lifecycle.bases.BaseViewModel

/**
 * @ClassName MainViewModel
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/12/9
 * @Version 1.0
 */
class MainViewModel: BaseViewModel() {
    val SAVE_KEY by CacheKDSVarPropertyString(CacheKDS.instance.with("DS_KEY", true)).asCacheKMutableLiveData()
}