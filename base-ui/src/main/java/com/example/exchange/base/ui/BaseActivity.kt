package com.example.exchange.base.ui

import android.view.View
import androidx.activity.ComponentActivity
import androidx.annotation.StringRes
import com.google.android.material.snackbar.Snackbar

/**
 * 业务 Activity 基类：统一 Snackbar、可扩展加载框/空态。
 */
abstract class BaseActivity : ComponentActivity() {

    protected open fun rootViewForTips(): View = findViewById(android.R.id.content)

    protected fun showMessage(@StringRes resId: Int) {
        Snackbar.make(rootViewForTips(), resId, Snackbar.LENGTH_SHORT).show()
    }

    protected fun showMessage(message: CharSequence) {
        Snackbar.make(rootViewForTips(), message, Snackbar.LENGTH_SHORT).show()
    }
}
