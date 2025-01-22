package com.mozhimen.cachek.ext.impls

import com.mozhimen.kotlin.elemk.commons.IA_Listener
import com.mozhimen.kotlin.elemk.commons.I_AListener
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

/**
 * @ClassName CacheKMutableStateFlow
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/12/9
 * @Version 1.0
 */
class CacheKMutableStateFlow<T> constructor(
    private val _onGetValue: I_AListener<T>,
    private val _onSetValue: IA_Listener<T>,
    private val _mutableStateFlow: MutableStateFlow<T> = MutableStateFlow(_onGetValue()),
) : MutableStateFlow<T> {
    override val subscriptionCount: StateFlow<Int>
        get() = _mutableStateFlow.subscriptionCount

    override val replayCache: List<T>
        get() = _mutableStateFlow.replayCache

    override var value: T
        get() = _onGetValue.invoke()
        set(value) {
            val origin = _mutableStateFlow.value
            _mutableStateFlow.value = value
            if (origin != value) {
                _onSetValue.invoke(value)
            }
        }

    override suspend fun collect(collector: FlowCollector<T>): Nothing =
        _mutableStateFlow.collect(collector)


    override fun compareAndSet(expect: T, update: T): Boolean =
        _mutableStateFlow.compareAndSet(expect, update).also { compareAndSet ->
            if (compareAndSet)
                _onSetValue.invoke(value)
        }

    override suspend fun emit(value: T) {
        _mutableStateFlow.emit(value)
    }

    @ExperimentalCoroutinesApi
    override fun resetReplayCache() {
        _mutableStateFlow.resetReplayCache()
    }

    override fun tryEmit(value: T): Boolean =
        _mutableStateFlow.tryEmit(value)
}
