package com.example.exchange.base.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.res.stringResource

/**
 * 通用业务组件首页占位：子类只需提供标题文案。
 */
abstract class PlaceholderModuleActivity : BaseActivity() {

    @StringRes
    protected abstract fun titleRes(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val titleResId = titleRes()
        setContent {
            MaterialTheme {
                ModulePlaceholderScreen(
                    title = stringResource(titleResId),
                    hint = stringResource(R.string.base_ui_module_placeholder_hint),
                )
            }
        }
    }
}
