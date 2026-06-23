package me.rerere.rikkahub.ui.components.ai

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.SheetValue
import androidx.compose.material3.rememberBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import me.rerere.ai.core.ReasoningLevel
import me.rerere.rikkahub.ui.icons.OceanIcons
import me.rerere.rikkahub.R
import me.rerere.rikkahub.ui.components.ui.ToggleSurface
import kotlin.math.roundToInt

private val levels = ReasoningLevel.entries
private val levelCount = levels.size

@Composable
fun ReasoningButton(
    modifier: Modifier = Modifier,
    onlyIcon: Boolean = false,
    reasoningLevel: ReasoningLevel,
    onUpdateReasoningLevel: (ReasoningLevel) -> Unit,
) {
    var showPicker by remember { mutableStateOf(false) }

    if (showPicker) {
        ReasoningPicker(
            reasoningLevel = reasoningLevel,
            onDismissRequest = { showPicker = false },
            onUpdateReasoningLevel = onUpdateReasoningLevel
        )
    }

    ToggleSurface(
        checked = reasoningLevel.isEnabled,
        onClick = { showPicker = true },
        modifier = modifier,
    ) {
        Row(
            modifier = Modifier.padding(vertical = 8.dp, horizontal = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Box(
                modifier = Modifier.size(24.dp),
                contentAlignment = Alignment.Center
            ) {
                ReasoningIcon(reasoningLevel)
            }
            if (!onlyIcon) Text(stringResource(R.string.setting_provider_page_reasoning))
        }
    }
}

@Composable
fun ReasoningPicker(
    reasoningLevel: ReasoningLevel,
    onDismissRequest: () -> Unit = {},
    onUpdateReasoningLevel: (ReasoningLevel) -> Unit,
) {
    val currentIndex = levels.indexOf(reasoningLevel).coerceAtLeast(0)
    var sliderValue by remember { mutableFloatStateOf(currentIndex.toFloat()) }

    LaunchedEffect(currentIndex) {
        sliderValue = currentIndex.toFloat()
    }

    ModalBottomSheet(
        onDismissRequest = onDismissRequest,
        sheetState = rememberBottomSheetState(initialValue = SheetValue.Hidden, enabledValues = setOf(SheetValue.Hidden, SheetValue.Expanded)),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
                .padding(bottom = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            // 标题
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(4.dp),
            ) {
                Text(
                    text = stringResource(R.string.reasoning_picker_title),
                    style = MaterialTheme.typography.titleLarge,
                )
                Text(
                    text = stringResource(R.string.reasoning_picker_hint),
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    textAlign = TextAlign.Center,
                )
            }

            // 当前等级展示
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                val iconColor by animateColorAsState(
                    if (reasoningLevel.isEnabled) MaterialTheme.colorScheme.primary
                    else MaterialTheme.colorScheme.onSurface
                )
                ReasoningIcon(
                    level = reasoningLevel,
                    modifier = Modifier.size(56.dp),
                    tint = iconColor,
                    iconSize = 30.dp,
                )
                Text(
                    text = reasoningLevel.label(),
                    style = MaterialTheme.typography.titleMedium,
                )
            }

            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp),
            ) {
                Slider(
                    value = sliderValue,
                    onValueChange = { sliderValue = it },
                    onValueChangeFinished = {
                        val snappedIndex = sliderValue.roundToInt().coerceIn(0, levelCount - 1)
                        sliderValue = snappedIndex.toFloat()
                        onUpdateReasoningLevel(levels[snappedIndex])
                    },
                    valueRange = 0f..(levelCount - 1).toFloat(),
                    steps = levelCount - 2,
                    modifier = Modifier.fillMaxWidth(),
                    thumb = {
                        Box(
                            modifier = Modifier
                                .size(24.dp)
                                .clip(CircleShape)
                                .background(MaterialTheme.colorScheme.primary),
                            contentAlignment = Alignment.Center,
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(10.dp)
                                    .clip(CircleShape)
                                    .background(MaterialTheme.colorScheme.onPrimary)
                            )
                        }
                    },
                    track = { sliderState ->
                        SliderDefaults.Track(
                            sliderState = sliderState,
                            drawStopIndicator = null,
                            thumbTrackGapSize = 0.dp,
                        )
                    }
                )

                ReasoningScale(
                    selectedLevel = reasoningLevel,
                    onSelect = { level ->
                        sliderValue = levels.indexOf(level).toFloat()
                        onUpdateReasoningLevel(level)
                    }
                )
            }
        }
    }
}

@Composable
private fun ReasoningScale(
    selectedLevel: ReasoningLevel,
    onSelect: (ReasoningLevel) -> Unit,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        levels.forEach { level ->
            val selected = level == selectedLevel
            val tickColor by animateColorAsState(
                if (selected) MaterialTheme.colorScheme.primary
                else MaterialTheme.colorScheme.outlineVariant
            )
            val labelColor by animateColorAsState(
                if (selected) MaterialTheme.colorScheme.primary
                else MaterialTheme.colorScheme.onSurfaceVariant
            )

            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                ToggleSurface(
                    checked = selected,
                    onClick = { onSelect(level) },
                    modifier = Modifier,
                ) {
                    Column(
                        modifier = Modifier
                            .padding(horizontal = 8.dp, vertical = 10.dp)
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                    ) {
                        Box(
                            modifier = Modifier
                                .width(if (selected) 20.dp else 16.dp)
                                .height(if (selected) 6.dp else 4.dp)
                                .clip(RoundedCornerShape(999.dp))
                                .background(tickColor)
                        )
                        Text(
                            text = level.label(),
                            style = MaterialTheme.typography.labelSmall,
                            textAlign = TextAlign.Center,
                            color = labelColor,
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun ReasoningIcon(
    level: ReasoningLevel,
    modifier: Modifier = Modifier.size(24.dp),
    tint: Color = MaterialTheme.colorScheme.onSurface,
    iconSize: Dp = 18.dp,
) {
    val enabled = level.isEnabled
    val ringColor = if (enabled) tint else MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.45f)
    val accentColor = if (enabled) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.outlineVariant
    val faintRingColor = ringColor.copy(alpha = if (enabled) 0.20f else 0.12f)

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center,
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val strokeWidth = size.minDimension * 0.07f
            val ringSize = size.minDimension * 0.74f
            val topLeft = Offset(
                x = (size.width - ringSize) / 2f,
                y = (size.height - ringSize) / 2f,
            )

            if (level != ReasoningLevel.OFF) {
                drawArc(
                    color = faintRingColor,
                    startAngle = -90f,
                    sweepAngle = 360f,
                    useCenter = false,
                    topLeft = topLeft,
                    size = androidx.compose.ui.geometry.Size(ringSize, ringSize),
                    style = Stroke(width = strokeWidth, cap = StrokeCap.Round),
                )
            }

            when (level) {
                ReasoningLevel.OFF -> Unit
                ReasoningLevel.AUTO -> {
                    drawCircle(
                        color = accentColor,
                        radius = strokeWidth * 0.95f,
                        center = Offset(size.width * 0.70f, size.height * 0.27f),
                    )
                    drawCircle(
                        color = accentColor.copy(alpha = 0.55f),
                        radius = strokeWidth * 0.62f,
                        center = Offset(size.width * 0.30f, size.height * 0.73f),
                    )
                }
                ReasoningLevel.LOW -> {
                    drawArc(
                        color = ringColor,
                        startAngle = -130f,
                        sweepAngle = 115f,
                        useCenter = false,
                        topLeft = topLeft,
                        size = androidx.compose.ui.geometry.Size(ringSize, ringSize),
                        style = Stroke(width = strokeWidth, cap = StrokeCap.Round),
                    )
                }
                ReasoningLevel.MEDIUM -> {
                    listOf(-150f to 110f, 18f to 120f).forEach { (start, sweep) ->
                        drawArc(
                            color = ringColor,
                            startAngle = start,
                            sweepAngle = sweep,
                            useCenter = false,
                            topLeft = topLeft,
                            size = androidx.compose.ui.geometry.Size(ringSize, ringSize),
                            style = Stroke(width = strokeWidth, cap = StrokeCap.Round),
                        )
                    }
                }
                ReasoningLevel.HIGH -> {
                    drawArc(
                        color = ringColor,
                        startAngle = -90f,
                        sweepAngle = 330f,
                        useCenter = false,
                        topLeft = topLeft,
                        size = androidx.compose.ui.geometry.Size(ringSize, ringSize),
                        style = Stroke(width = strokeWidth, cap = StrokeCap.Round),
                    )
                    drawCircle(
                        color = accentColor,
                        radius = strokeWidth * 0.78f,
                        center = Offset(size.width * 0.78f, size.height * 0.22f),
                    )
                }
                ReasoningLevel.XHIGH -> {
                    drawArc(
                        color = ringColor,
                        startAngle = -90f,
                        sweepAngle = 360f,
                        useCenter = false,
                        topLeft = topLeft,
                        size = androidx.compose.ui.geometry.Size(ringSize, ringSize),
                        style = Stroke(width = strokeWidth, cap = StrokeCap.Round),
                    )
                    val outerSize = size.minDimension * 0.94f
                    val outerTopLeft = Offset(
                        x = (size.width - outerSize) / 2f,
                        y = (size.height - outerSize) / 2f,
                    )
                    drawArc(
                        color = accentColor.copy(alpha = 0.72f),
                        startAngle = -42f,
                        sweepAngle = 255f,
                        useCenter = false,
                        topLeft = outerTopLeft,
                        size = androidx.compose.ui.geometry.Size(outerSize, outerSize),
                        style = Stroke(width = strokeWidth * 0.78f, cap = StrokeCap.Round),
                    )
                    listOf(
                        Offset(size.width * 0.78f, size.height * 0.17f),
                        Offset(size.width * 0.88f, size.height * 0.50f),
                        Offset(size.width * 0.24f, size.height * 0.82f),
                    ).forEachIndexed { index, center ->
                        drawCircle(
                            color = accentColor.copy(alpha = 1f - index * 0.16f),
                            radius = strokeWidth * (0.88f - index * 0.08f),
                            center = center,
                        )
                    }
                }
            }
        }

        Icon(
            imageVector = OceanIcons.Brain02,
            contentDescription = null,
            tint = tint,
            modifier = Modifier.size(iconSize),
        )
    }
}

@Composable
private fun ReasoningLevel.label(): String = when (this) {
    ReasoningLevel.OFF -> stringResource(R.string.reasoning_off)
    ReasoningLevel.AUTO -> stringResource(R.string.reasoning_auto)
    ReasoningLevel.LOW -> stringResource(R.string.reasoning_light)
    ReasoningLevel.MEDIUM -> stringResource(R.string.reasoning_medium)
    ReasoningLevel.HIGH -> stringResource(R.string.reasoning_heavy)
    ReasoningLevel.XHIGH -> stringResource(R.string.reasoning_xhigh)
}

@Composable
@Preview(showBackground = true)
private fun ReasoningPickerPreview() {
    MaterialTheme {
        var level by remember { mutableStateOf(ReasoningLevel.AUTO) }
        ReasoningPicker(
            reasoningLevel = level,
            onUpdateReasoningLevel = { level = it }
        )
    }
}
