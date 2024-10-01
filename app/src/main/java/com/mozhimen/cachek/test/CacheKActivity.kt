package com.mozhimen.cachek.test

import android.view.View
import com.mozhimen.bindk.bases.activity.databinding.BaseActivityVDB
import com.mozhimen.kotlin.utilk.android.content.startContext
import com.mozhimen.cachek.test.databinding.ActivityCachekBinding


/**
 * @ClassName CacheKActivity
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2023/3/13 15:56
 * @Version 1.0
 */
class CacheKActivity : BaseActivityVDB<ActivityCachekBinding>() {

    fun goCachekDS(view: View) {
        startContext<CacheKDSActivity>()
    }

    fun goCachekRM(view: View) {
        startContext<CacheKRMActivity>()
    }

    fun goCachekSP(view: View) {
        startContext<CacheKSPActivity>()
    }
}