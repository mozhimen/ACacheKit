package com.mozhimen.cachek.test

import android.os.Bundle
import com.mozhimen.cachek.sharedpreferences.CacheKSP
import com.mozhimen.cachek.sharedpreferences.temps.CacheKSPVarPropertyString
import com.mozhimen.uik.databinding.bases.viewdatabinding.activity.BaseActivityVDB
import com.mozhimen.kotlin.utilk.android.widget.showToast
import com.mozhimen.cachek.test.databinding.ActivityCachekSpBinding

class CacheKSPActivity : BaseActivityVDB<ActivityCachekSpBinding>() {

    private val _spTestPro by lazy { CacheKSP.instance.with("sp_test") }
    private var _editStr: String by CacheKSPVarPropertyString(_spTestPro, "")

    override fun initView(savedInstanceState: Bundle?) {
        vdb.cachekSpEdit.setText(_editStr)
        vdb.cachekSpBtn.setOnClickListener {
            _editStr = vdb.cachekSpEdit.text.toString()
        }
        vdb.cachekSpBtn1.setOnClickListener {
            "${_spTestPro.contains("editStr")}".showToast()
        }
    }
}