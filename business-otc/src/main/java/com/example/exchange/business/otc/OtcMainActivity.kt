package com.example.exchange.business.otc

import com.alibaba.android.arouter.facade.annotation.Route
import com.example.exchange.base.router.RoutePath
import com.example.exchange.base.ui.PlaceholderModuleActivity

@Route(path = RoutePath.Otc.PAGE)
class OtcMainActivity : PlaceholderModuleActivity() {
    override fun titleRes() = R.string.module_otc_title
}
