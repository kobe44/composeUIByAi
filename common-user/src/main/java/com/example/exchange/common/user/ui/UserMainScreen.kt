package com.example.exchange.common.user.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.exchange.base.ui.R as BaseUiR
import com.example.exchange.base.ui.view.fastClick
import com.example.exchange.common.user.R

/**
 * 用户模块首页：标题 + 说明 + 播放 / 停止播放 / 录制 / 停止录制。
 */
@Composable
fun UserMainScreen(
    onPlayClick: () -> Unit,
    onStopPlayClick: () -> Unit,
    onRecordClick: () -> Unit,
    onStopRecordClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = stringResource(R.string.module_user_title),
            style = MaterialTheme.typography.headlineSmall,
        )
        Spacer(Modifier.height(12.dp))
        Text(
            text = stringResource(BaseUiR.string.base_ui_module_placeholder_hint),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center,
        )
        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = fastClick { onPlayClick() },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 50.dp),
        ) {
            Text(stringResource(BaseUiR.string.click_button_message_play))
        }
        Button(
            onClick = fastClick { onStopPlayClick() },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 50.dp),
        ) {
            Text(stringResource(BaseUiR.string.click_button_message_stop_play))
        }
        Button(
            onClick = fastClick { onRecordClick() },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 50.dp),
        ) {
            Text(stringResource(BaseUiR.string.click_button_message))
        }
        Button(
            onClick = fastClick { onStopRecordClick() },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 50.dp),
        ) {
            Text(stringResource(BaseUiR.string.click_button_message_again))
        }
    }
}
