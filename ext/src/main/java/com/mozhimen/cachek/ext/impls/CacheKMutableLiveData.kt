package com.mozhimen.cachek.ext.impls

import androidx.lifecycle.MutableLiveData
import com.mozhimen.kotlin.elemk.commons.IA_Listener
import com.mozhimen.kotlin.elemk.commons.I_AListener

/**
 * @ClassName CacheKMutableLiveData
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/12/9
 * @Version 1.0
 */
class CacheKMutableLiveData<T> constructor(
    private val _onGetValue: I_AListener<T>,
    private val _onSetValue: IA_Listener<T>,
) : MutableLiveData<T>(_onGetValue.invoke()) {
    override fun getValue(): T? {
        return _onGetValue.invoke()
    }

    override fun setValue(value: T) {
        _onSetValue.invoke(value)
        super.setValue(value)
    }
}