package com.example.exchange.common.asset

import com.alibaba.android.arouter.facade.annotation.Route
import com.example.exchange.base.router.RoutePath
import com.example.exchange.base.ui.PlaceholderModuleActivity

@Route(path = RoutePath.Asset.PAGE)
class AssetMainActivity : PlaceholderModuleActivity() {
    override fun titleRes() = R.string.module_asset_title
}
