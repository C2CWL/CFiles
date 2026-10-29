package dev.cluvex.strata.feature.settings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.KeyboardArrowRight
import androidx.compose.material.icons.rounded.Code
import androidx.compose.material.icons.rounded.VolunteerActivism
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import dev.cluvex.strata.R

@Composable
fun SupportCard(onOpen: () -> Unit) {
    Card(
        onClick = onOpen,
        shape = RoundedCornerShape(28.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.tertiaryContainer,
            contentColor = MaterialTheme.colorScheme.onTertiaryContainer,
        ),
        modifier = Modifier.fillMaxWidth().padding(top = 16.dp).testTag("settings-support-card"),
    ) {
        Row(Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            SettingIcon(Icons.Rounded.VolunteerActivism, Tint.PRIMARY, size = 48)
            Column(Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(2.dp)) {
                Text(stringResource(R.string.settings_support_title), style = MaterialTheme.typography.titleMedium)
                Text(stringResource(R.string.settings_support_summary), style = MaterialTheme.typography.bodyMedium)
            }
            Icon(Icons.AutoMirrored.Rounded.KeyboardArrowRight, contentDescription = null)
        }
    }
}

@Composable
fun SupportPage(onBack: () -> Unit) {
    val uriHandler = LocalUriHandler.current
    SettingsPageScaffold(stringResource(R.string.settings_support_title), onBack) {
        Text(
            stringResource(R.string.settings_support_body),
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(start = 8.dp, end = 8.dp, top = 16.dp).testTag("support-body"),
        )
        SettingsGroup(stringResource(R.string.settings_support_title)) {
            link(
                "C2CWL/CFiles",
                summary = "https://github.com/C2CWL/CFiles",
                icon = Icons.Rounded.Code,
            ) { uriHandler.openUri("https://github.com/C2CWL/CFiles") }
        }
    }
}
