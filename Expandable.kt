package com.example.myapplication

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Shapes
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExpandableCard(title :String,description:String){
    var expandedState by remember { mutableStateOf(false) }
    val rotationState by animateFloatAsState(targetValue = if(expandedState) 180f else 0f)

    Card (
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing
                )
            ),
        shape = Shapes().medium,
        onClick = {
            expandedState = !expandedState
        }
    ){
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)) {
            Row (verticalAlignment = Alignment.CenterVertically){
                Text(text = title, fontSize = 24.sp, fontWeight = FontWeight.Bold, modifier = Modifier.weight(6f), maxLines = 1, overflow = TextOverflow.Ellipsis)
                IconButton(modifier = Modifier
                    .alpha(0.5f)
                    .rotate(rotationState),
                    onClick = {
                        expandedState = !expandedState
                    }) {
                    Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = "Drop-Down-Arrow", modifier = Modifier.weight(1f))
                }
            }
            if(expandedState){
                Text(
                    text = description,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Normal,
                    maxLines = 4,
                    overflow = TextOverflow.Ellipsis)
            }
        }
    }
}
