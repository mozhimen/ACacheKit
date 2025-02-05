package com.mozhimen.cachek.test

import android.os.Bundle
import com.mozhimen.cachek.datastore.CacheKDS
import com.mozhimen.cachek.datastore.temps.CacheKDSVarPropertyString
import com.mozhimen.uik.databinding.bases.viewdatabinding.activity.BaseActivityVDB
import com.mozhimen.kotlin.utilk.android.widget.showToast
import com.mozhimen.cachek.test.databinding.ActivityCachekDsBinding

class CacheKDSActivity : BaseActivityVDB<ActivityCachekDsBinding>() {
    private val _dsTestPro by lazy { CacheKDS.instance.with("sp_test") }
    private var editStr: String by CacheKDSVarPropertyString(_dsTestPro)

    override fun initView(savedInstanceState: Bundle?) {
        vdb.cachekDsEdit.setText(editStr)
        vdb.cachekDsBtn.setOnClickListener {
            editStr = vdb.cachekDsEdit.text.toString()
        }
        vdb.cachekDsBtn1.setOnClickListener {
            "${_dsTestPro.contains<String>("editStr")}".showToast()
        }
    }
}
