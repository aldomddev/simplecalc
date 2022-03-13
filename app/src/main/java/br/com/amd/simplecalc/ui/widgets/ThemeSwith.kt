package br.com.amd.simplecalc.ui.widgets

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import br.com.amd.simplecalc.R
import br.com.amd.simplecalc.ui.theme.Amber500
import br.com.amd.simplecalc.ui.theme.Gray500

@Immutable
data class ThemeSwitchColors(
    val checkedThumbColor: Color = Amber500,
    val checkedTrackColor: Color = Color.Black,
    val checkedTrackBorderColor: Color = Color.Black,
    val uncheckedThumbColor: Color = Gray500,
    val uncheckedTrackColor: Color = Amber500,
    val uncheckedTrackBorderColor: Color = Amber500,
)

@Composable
fun ThemeSwitch(
    checked: Boolean,
    onCheckedChange: ((Boolean) -> Unit)?,
    modifier: Modifier = Modifier,
    colors: ThemeSwitchColors = ThemeSwitchColors(),
    width: Dp = 40.dp,
    borderWidth: Dp = 2.dp,
    movementAnimSpec: AnimationSpec<Float> = tween(),
    colorsAnimSpec: AnimationSpec<Color> = tween(),
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    val animationProgress = animateFloatAsState(if (checked) 1f else 0f, movementAnimSpec)
    val toggleableModifier =
        if (onCheckedChange != null) {
            Modifier.toggleable(
                value = checked,
                onValueChange = onCheckedChange,
                enabled = enabled,
                role = Role.Switch,
                interactionSource = interactionSource,
                indication = null
            )
        } else {
            Modifier
        }

    val thumbColor = animateColorAsState(
        if (checked) colors.checkedThumbColor else colors.uncheckedThumbColor,
        animationSpec = colorsAnimSpec,
    )

    val trackColor = animateColorAsState(
        if (checked) colors.checkedTrackColor else colors.uncheckedTrackColor,
        animationSpec = colorsAnimSpec,
    )
    val borderColor = animateColorAsState(
        if (checked) colors.checkedTrackBorderColor else colors.uncheckedTrackBorderColor,
        animationSpec = colorsAnimSpec,
    )

    val height = width / 2
    val thumbDiameter = height - borderWidth * 2
    Box(Modifier.requiredSize(width, height).background(MaterialTheme.colors.primary)) {
        Track(
            modifier = modifier
                .requiredSize(width, height)
                .then(toggleableModifier),
            backgroundColor = MaterialTheme.colors.primary,
            trackColor = trackColor,
            borderColor = borderColor,
            borderWidth = borderWidth
        )
        Thumb(
            Modifier
                .requiredSize(thumbDiameter)
                .thumbOffset(width, height, borderWidth, thumbDiameter, animationProgress),
            thumbColor,
        )
    }
}

@Composable
private fun Track(
    modifier: Modifier,
    trackColor: State<Color>,
    borderColor: State<Color>,
    backgroundColor: Color,
    borderWidth: Dp
) = Box(
    modifier = modifier
        .background(trackColor.value, CircleShape)
        .border(borderWidth, borderColor.value, CircleShape)
) {
    Row(
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Image(
            painterResource(R.drawable.ic_sunny),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(10.dp)
                .height(10.dp)
        )
        Image(
            painterResource(R.drawable.ic_night),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(10.dp)
                .height(10.dp)
        )
    }
}

@Composable
private fun Thumb(modifier: Modifier, color: State<Color>) = Box(
    modifier = modifier
        .shadow(6.dp, CircleShape)
        .background(color.value, CircleShape)
)

private fun Modifier.thumbOffset(
    width: Dp,
    height: Dp,
    borderWidth: Dp,
    thumbDiameter: Dp,
    animationProgress: State<Float>
): Modifier {
    val startOffset = DpOffset(borderWidth, borderWidth)
    val middleOffset = DpOffset(
        x = (width - thumbDiameter) / 2,
        y = height - thumbDiameter - borderWidth
    )
    val endOffset = DpOffset(
        x = width - thumbDiameter - borderWidth,
        y = borderWidth
    )
    return offset {
        // State read happens in the offset's scope. Only this scope will be recomposed, avoiding
        // recomposition and improving performance.
        // More: https://developer.android.com/jetpack/compose/phases#phase2-layout
        val progress = animationProgress.value
        val fraction =
            if (progress <= 0.5f) progress * 2
            else (progress - 0.5f) * 2

        val dpOffset =
            if (progress <= 0.5f) {
                lerp(startOffset, middleOffset, fraction)
            } else {
                lerp(middleOffset, endOffset, fraction)
            }

        IntOffset(
            x = dpOffset.x.roundToPx(),
            y = dpOffset.y.roundToPx(),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ThemeSwitchPreview() {
    val checked = remember { mutableStateOf(false) }
    ThemeSwitch(checked = checked.value, onCheckedChange = { value -> checked.value = value })
}