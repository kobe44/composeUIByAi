package com.example.exchange.business.trade

import com.alibaba.android.arouter.facade.annotation.Route
import com.example.exchange.base.router.RoutePath
import com.example.exchange.base.ui.PlaceholderModuleActivity

@Route(path = RoutePath.Trade.PAGE)
class TradeMainActivity : PlaceholderModuleActivity() {
    override fun titleRes() = R.string.module_trade_title
}
