package com.mozhimen.cachek.datastore.test

import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.mozhimen.basick.elemk.androidx.appcompat.bases.viewbinding.BaseActivityVB
import com.mozhimen.basick.taskk.executor.TaskKExecutor
import com.mozhimen.basick.taskk.handler.TaskKHandler
import com.mozhimen.basick.utilk.android.widget.showToast
import com.mozhimen.basick.utilk.android.widget.value
import com.mozhimen.cachek.datastore.CacheKDS
import com.mozhimen.cachek.datastore.test.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * 这是一个多线程读取的案例
 */
class MainActivity : BaseActivityVB<ActivityMainBinding>() {
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

    private fun save(str: String) {
        if (str.isEmpty()) return
        CacheKDS.instance.with(NAME, true).putString(SAVE_KEY, str)
    }

    private fun read() {
        val value = CacheKDS.instance.with(NAME, true).getString(SAVE_KEY)
        value.showToast()
    }

    private fun readOnBack() {
        lifecycleScope.launch(Dispatchers.IO) {
            val value = CacheKDS.instance.with(NAME, true).getString(SAVE_KEY)
            withContext(Dispatchers.Main) {
                value.showToast()
            }
        }
    }

    private fun readOnBack2() {
        TaskKExecutor.execute(NAME) {
            val value = CacheKDS.instance.with(NAME, true).getString(SAVE_KEY)
            TaskKHandler.post {
                value.showToast()
            }
        }
    }
}