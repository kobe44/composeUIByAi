package com.example.exchange.common.user

import com.alibaba.android.arouter.facade.annotation.Route
import com.example.exchange.base.router.RoutePath
import com.example.exchange.base.ui.PlaceholderModuleActivity

@Route(path = RoutePath.User.PAGE)
class UserMainActivity : PlaceholderModuleActivity() {
    override fun titleRes() = R.string.module_user_title
}
