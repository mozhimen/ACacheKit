package com.mozhimen.cachek.datastore.test

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.mozhimen.uik.databinding.bases.viewbinding.activity.BaseActivityVB
import com.mozhimen.uik.databinding.bases.viewbinding.activity.BaseActivityVBVM
import com.mozhimen.taskk.executor.TaskKExecutor
import com.mozhimen.kotlin.utilk.android.os.UtilKHandlerWrapper
import com.mozhimen.kotlin.utilk.android.widget.showToast
import com.mozhimen.kotlin.utilk.android.widget.value
import com.mozhimen.cachek.datastore.CacheKDS
import com.mozhimen.cachek.datastore.temps.CacheKDSVarPropertyString
import com.mozhimen.cachek.datastore.test.databinding.ActivityMainBinding
import com.mozhimen.cachek.ext.utils.asCacheKMutableLiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * 这是一个多线程读取的案例
 */
class MainActivity : BaseActivityVBVM<ActivityMainBinding, MainViewModel>() {
    companion object {
        const val SAVE_KEY = "SAVE_KEY"
    }


    override fun initView(savedInstanceState: Bundle?) {
        vb.mainBtnSave.setOnClickListener {
            save(vb.mainEdit.value)
        }

        vb.mainBtnRead.setOnClickListener {
            read()
        }

        vb.mainBtnReadWork.setOnClickListener {
            readOnBack()
        }

        vb.mainBtnReadWork2.setOnClickListener {
            readOnBack2()
        }
    }

    override fun initObserver() {
        vm.SAVE_KEY.observe(this) {
            it.showToast()
        }
    }

    private fun save(str: String) {
        if (str.isEmpty()) return
        vm.SAVE_KEY.setValue(str)
    }

    private fun read() {
        val value = CacheKDS.instance.with("DS_KEY", true).getString(SAVE_KEY)
        value.showToast()
    }

    private fun readOnBack() {
        lifecycleScope.launch(Dispatchers.IO) {
            val value = CacheKDS.instance.with("DS_KEY", true).getString(SAVE_KEY)
            Log.d(TAG, "readOnBack: value $value")
            withContext(Dispatchers.Main) {
                value.showToast()
            }
        }
    }

    private fun readOnBack2() {
        TaskKExecutor.execute(NAME) {
            val value = CacheKDS.instance.with("DS_KEY", true).getString(SAVE_KEY)
            Log.d(TAG, "readOnBack2: value $value")
            UtilKHandlerWrapper.post {
                value.showToast()
            }
        }
    }
}