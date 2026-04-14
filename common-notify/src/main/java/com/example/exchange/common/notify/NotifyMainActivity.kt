package com.example.exchange.common.notify

import com.alibaba.android.arouter.facade.annotation.Route
import com.example.exchange.base.router.RoutePath
import com.example.exchange.base.ui.PlaceholderModuleActivity

@Route(path = RoutePath.Notify.PAGE)
class NotifyMainActivity : PlaceholderModuleActivity() {
    override fun titleRes() = R.string.module_notify_title
}
