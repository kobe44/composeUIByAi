package com.example.exchange.business.finance

import com.alibaba.android.arouter.facade.annotation.Route
import com.example.exchange.base.router.RoutePath
import com.example.exchange.base.ui.PlaceholderModuleActivity

@Route(path = RoutePath.Finance.PAGE)
class FinanceMainActivity : PlaceholderModuleActivity() {
    override fun titleRes() = R.string.module_finance_title
}
