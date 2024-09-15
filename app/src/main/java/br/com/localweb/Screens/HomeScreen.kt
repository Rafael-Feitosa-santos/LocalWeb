package br.com.localweb.Screens

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.with
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {

    var selectedIcon by remember { mutableStateOf("none") }

    var searchText by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(colorResource(id = br.com.localweb.R.color.background_black))
                .height(90.dp),
        ) {

        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(colorResource(id = br.com.localweb.R.color.background_black))
                .height(110.dp)
                .align(Alignment.TopStart)
                .offset(y = 135.dp)
                .padding(start = 6.dp, end = 6.dp),

            ) {
            OutlinedTextField(
                value = searchText,
                onValueChange = { searchText = it },
                label = { Text("Pequisar") },
                shape = RoundedCornerShape(24.dp), // Apply rounded corners
                modifier = Modifier
                    .fillMaxWidth(),
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search Icon",
                        tint = Color.Gray // Adjust the color if needed
                    )
                }
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(110.dp)
                .background(colorResource(id = br.com.localweb.R.color.background_black))
                .align(Alignment.BottomStart), // Aligns at the bottom
            horizontalAlignment = Alignment.CenterHorizontally, // Centers icons horizontally
            verticalArrangement = Arrangement.Center // Centers vertically within the Column
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                AnimatedIcon(
                    icon = Icons.Default.Email,
                    contentDescription = "Email Icon",
                    selectedIcon = selectedIcon,
                    iconName = "email",
                    onClick = { selectedIcon = "email" }
                )

                AnimatedIcon(
                    icon = Icons.Default.DateRange,
                    contentDescription = "Calendar Icon",
                    selectedIcon = selectedIcon,
                    iconName = "calendar",
                    onClick = { selectedIcon = "calendar" }
                )

                AnimatedIcon(
                    icon = Icons.Default.Refresh,
                    contentDescription = "Refresh Icon",
                    selectedIcon = selectedIcon,
                    iconName = "refresh",
                    onClick = { selectedIcon = "refresh" }
                )
            }
        }


    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimatedIcon(
    icon: ImageVector,
    contentDescription: String,
    selectedIcon: String,
    iconName: String,
    onClick: () -> Unit
) {
    AnimatedContent(
        targetState = selectedIcon == iconName,
        transitionSpec = {
            if (targetState) {
                fadeIn() with fadeOut()
            } else {
                fadeIn() with fadeOut()
            }
        }
    ) { isSelected ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.clickable(onClick = onClick)
        ) {
            Icon(
                imageVector = icon,
                contentDescription = contentDescription,
                tint = if (isSelected)
                    colorResource(id = br.com.localweb.R.color.color_botao) else Color.White,
                modifier = Modifier.size(40.dp)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Box(
                modifier = Modifier
                    .height(2.dp)
                    .width(40.dp)
                    .background(if (isSelected) colorResource(id = br.com.localweb.R.color.color_botao) else Color.Transparent)
            )
        }
    }
}
