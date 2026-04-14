package com.example.exchange.business.market

import com.alibaba.android.arouter.facade.annotation.Route
import com.example.exchange.base.router.RoutePath
import com.example.exchange.base.ui.PlaceholderModuleActivity

@Route(path = RoutePath.Market.PAGE)
class MarketMainActivity : PlaceholderModuleActivity() {
    override fun titleRes() = R.string.module_market_title
}
