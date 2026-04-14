package com.example.exchange.base.router.event

/**
 * 跨模块事件载荷（由 [ModuleEventBus] 通过 Flow 分发）。
 */
sealed class ModuleEvent {

    data class UserLoginSuccess(val userId: String, val token: String) : ModuleEvent()

    data object UserLogout : ModuleEvent()

    /** 行情交易对切换等 */
    data class SymbolChanged(val symbol: String) : ModuleEvent()

    /** 系统公告 / 推送摘要 */
    data class NotifyReceived(val title: String, val body: String) : ModuleEvent()
}
