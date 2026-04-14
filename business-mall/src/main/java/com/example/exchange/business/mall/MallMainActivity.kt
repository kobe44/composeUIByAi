package com.example.exchange.business.mall

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.exchange.base.router.RoutePath
import com.example.exchange.base.ui.BaseActivity
import com.example.exchange.business.mall.ui.MallApp

@Route(path = RoutePath.Mall.PAGE)
class MallMainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                MallApp()
            }
        }
    }
}
