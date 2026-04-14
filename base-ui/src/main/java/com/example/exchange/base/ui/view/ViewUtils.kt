package com.example.exchange.base.ui.view

import android.os.SystemClock
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue

@Composable
fun fastClick(time: Long = 500L, onclick: () -> Unit): () -> Unit {
    val lastClick by rememberUpdatedState(onclick)
    var lastClickTime by remember { mutableLongStateOf(0L) }

    return remember(time) {
        {
            val currentTime = SystemClock.elapsedRealtime()
            if (currentTime - lastClickTime >= time) {
                lastClickTime = currentTime
                lastClick()
            }
        }
    }
}