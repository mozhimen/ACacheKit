package com.mozhimen.cachek.test

import android.os.Bundle
import com.mozhimen.basick.elemk.androidx.appcompat.bases.databinding.BaseActivityVDB
import com.mozhimen.cachek.serial.UtilKStrSerialNo
import com.mozhimen.cachek.test.databinding.ActivityUtilkGenerateNoBinding

class UtilKGenerateNoActivity : BaseActivityVDB<ActivityUtilkGenerateNoBinding>() {
    override fun initView(savedInstanceState: Bundle?) {
        vdb.utilkGenerateNoBtn.setOnClickListener {
            vdb.utilkGenerateNoTxt.text = UtilKStrSerialNo.get()
        }
    }
}