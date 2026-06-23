package me.rerere.rikkahub.ui.components.nav

import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import me.rerere.rikkahub.ui.icons.OceanIcons
import me.rerere.rikkahub.R
import me.rerere.rikkahub.ui.context.LocalNavController

@Composable
fun BackButton(modifier: Modifier = Modifier) {
    val navController = LocalNavController.current
    FilledTonalIconButton(
        onClick = {
            navController.popBackStack()
        },
        modifier = modifier,
        shapes = IconButtonDefaults.shapes(),
        colors = IconButtonDefaults.filledTonalIconButtonColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainerLow,
            contentColor = MaterialTheme.colorScheme.onSurface,
        ),
    ) {
        Icon(
            imageVector = OceanIcons.ArrowLeft01,
            contentDescription = stringResource(R.string.back)
        )
    }
}
