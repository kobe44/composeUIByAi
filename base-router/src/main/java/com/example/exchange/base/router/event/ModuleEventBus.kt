package com.example.exchange.base.router.event

import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow

/**
 * 组件间消息总线：基于 [SharedFlow]，可在任意模块 emit，在协程中 collect（如 `lifecycleScope`）。
 */
object ModuleEventBus {

    private val _events = MutableSharedFlow<ModuleEvent>(
        replay = 0,
        extraBufferCapacity = 64,
        onBufferOverflow = BufferOverflow.DROP_OLDEST,
    )

    val events: SharedFlow<ModuleEvent> = _events.asSharedFlow()

    fun tryEmit(event: ModuleEvent): Boolean = _events.tryEmit(event)
}
