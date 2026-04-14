package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.alibaba.android.arouter.launcher.ARouter
import com.example.exchange.base.router.RoutePath
import com.example.exchange.base.router.event.ModuleEventBus
import kotlinx.coroutines.launch

/**
 * 壳工程主界面：仅做组件入口演示与全局事件订阅（Flow collect）。
 */
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                MainScreen(
                    entries = buildList {
                        add("登录模块" to RoutePath.Login.PAGE)
                        add("用户模块" to RoutePath.User.PAGE)
                        add("资产模块" to RoutePath.Asset.PAGE)
                        add("通知模块" to RoutePath.Notify.PAGE)
                        add("行情模块" to RoutePath.Market.PAGE)
                        add("商城 Demo" to RoutePath.Mall.PAGE)
                        add("交易模块" to RoutePath.Trade.PAGE)
                        add("OTC 模块" to RoutePath.Otc.PAGE)
                        add("理财模块" to RoutePath.Finance.PAGE)
                    },
                    onEntryClick = { path ->
                        ARouter.getInstance().build(path).navigation()
                    },
                )
            }
        }

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                ModuleEventBus.events.collect { event ->
                    Log.d(TAG, "module event: $event")
                }
            }
        }
    }

    private companion object {
        const val TAG = "Shell"
    }
}

@Composable
private fun MainScreen(
    entries: List<Pair<String, String>>,
    onEntryClick: (String) -> Unit,
) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            item {
                Text(
                    text = "模块入口",
                    style = MaterialTheme.typography.headlineSmall,
                )
            }
            items(entries) { (title, path) ->
                ModuleEntryButton(title = title) {
                    onEntryClick(path)
                }
            }
        }
    }
}

@Composable
private fun ModuleEntryButton(
    title: String,
    onClick: () -> Unit,
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Button(
            onClick = onClick,
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text(text = title)
        }
    }
}

@Preview(showBackground = true, name = "壳工程 · 模块入口")
@Composable
private fun MainScreenPreview() {
    MaterialTheme {
        MainScreen(
            entries = listOf(
                "登录模块" to "/login",
                "用户模块" to "/user",
                "示例模块" to "/demo",
            ),
            onEntryClick = {},
        )
    }
}
