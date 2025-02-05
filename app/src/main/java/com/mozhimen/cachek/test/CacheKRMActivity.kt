package com.mozhimen.cachek.test

import android.os.Bundle
import com.mozhimen.uik.databinding.bases.viewdatabinding.activity.BaseActivityVDB
import com.mozhimen.cachek.room.CacheKRM2
import com.mozhimen.cachek.room.temps.CacheKRM2VarPropertyString
import com.mozhimen.kotlin.utilk.android.widget.showToast
import com.mozhimen.cachek.test.databinding.ActivityCachekRmBinding

class CacheKRMActivity : BaseActivityVDB<ActivityCachekRmBinding>() {
    private var _editStr: String by CacheKRM2VarPropertyString(CacheKRM2.instance.with("123")/*或者CacheKRM*/, "")

    override fun initView(savedInstanceState: Bundle?) {
        vdb.cachekRmEdit.setText(_editStr)
        vdb.cachekRmBtn.setOnClickListener {
            _editStr = vdb.cachekRmEdit.text.toString()
        }
        vdb.cachekRmBtn1.setOnClickListener {
            "${/*获取CacheKRM*/CacheKRM2.instance.with("123").contains("editStr")}".showToast()
        }
    }
}