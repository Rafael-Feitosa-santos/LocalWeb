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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

data class EmailItem(val sender: String, val subject: String, val preview: String, val time: String)

enum class EmailTab { INBOX, TRASH }

@Composable
fun HomeScreen(navController: NavController) {

    var selectedIcon by remember { mutableStateOf("none") }
    var searchText by remember { mutableStateOf("") }
    var selectedTab by remember { mutableStateOf(EmailTab.INBOX) }

    // Lista de e-mails de exemplo (Caixa de Entrada)
    var inboxEmails by remember {
        mutableStateOf(
            listOf(
                EmailItem(
                    "Cameron Williamson",
                    "Reading Tutors",
                    "Lorem ipsum dolor sit amet, consectetur...",
                    "5s"
                ),
                EmailItem(
                    "Jane Cooper",
                    "Chemistry Tutors",
                    "Lorem ipsum dolor sit amet, consectetur...",
                    "20s"
                ),
                EmailItem(
                    "Esther Howard",
                    "Must be FigJam...",
                    "Lorem ipsum dolor sit amet, consectetur...",
                    "20s"
                ),
                EmailItem(
                    "Jacob Jones",
                    "Good morning John...",
                    "Lorem ipsum dolor sit amet, consectetur...",
                    "12h"
                ),
                EmailItem(
                    "Jenny Wilson",
                    "Please send asap...",
                    "Lorem ipsum dolor sit amet, consectetur...",
                    "1d"
                ),
                EmailItem(
                    "Guy Hawkins",
                    "Re: Retour devis",
                    "Lorem ipsum dolor sit amet, consectetur...",
                    "1d"
                )
            )
        )
    }

    // Lista de e-mails excluídos
    var trashEmails by remember { mutableStateOf(listOf<EmailItem>()) }

    var selectedEmail by remember { mutableStateOf<EmailItem?>(null) }

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
                .align(Alignment.TopStart)
                .offset(y = 129.dp)
        ) {
            OutlinedTextField(
                value = searchText,
                onValueChange = { searchText = it },
                label = { Text("Pesquisar") },
                shape = RoundedCornerShape(24.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp, start = 6.dp, end = 6.dp),
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search Icon",
                        tint = Color.Gray
                    )
                }
            )


            // Abas para "Caixa de Entrada" e "Excluídos"
            TabRow(selectedTabIndex = selectedTab.ordinal) {
                Tab(
                    selected = selectedTab == EmailTab.INBOX,
                    onClick = { selectedTab = EmailTab.INBOX },
                    text = { Text("Caixa de Entrada") }
                )
                Tab(
                    selected = selectedTab == EmailTab.TRASH,
                    onClick = { selectedTab = EmailTab.TRASH },
                    text = { Text("Excluídos") }
                )
            }


        }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 180.dp, start = 16.dp, end = 16.dp)
                .offset(y = 98.dp)
        ) {
            val emailsToShow = if (selectedTab == EmailTab.INBOX) inboxEmails else trashEmails

            items(emailsToShow) { email ->
                EmailRow(
                    email = email,
                    isSelected = email == selectedEmail,
                    onClick = { selectedEmail = email },
                    onDelete = {
                        if (selectedTab == EmailTab.INBOX) {
                            inboxEmails = inboxEmails.toMutableList().also {
                                it.remove(email)
                                trashEmails = trashEmails + email
                            }
                        } else {
                            trashEmails = trashEmails.toMutableList().also { it.remove(email) }
                        }
                    }
                )
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(110.dp)
                .background(colorResource(id = br.com.localweb.R.color.background_black))
                .align(Alignment.BottomStart),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
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
                    onClick = { selectedIcon = "email"
                        navController.navigate("home")}
                )

                AnimatedIcon(
                    icon = Icons.Default.DateRange,
                    contentDescription = "Calendar Icon",
                    selectedIcon = selectedIcon,
                    iconName = "calendar",
                    onClick = { selectedIcon = "calendar"
                    navController.navigate("calendario")}
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

@Composable
fun Boolean.EmailRow(
    email: EmailItem,
    onClick: () -> Unit,
    onDelete: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .background(if (this) Color.LightGray else Color.Transparent)
            .clickable(onClick = onClick),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(end = 8.dp)
        ) {
            Text(text = email.sender, fontWeight = FontWeight.Bold)
            Text(text = email.subject, fontWeight = FontWeight.SemiBold)
            Text(text = email.preview, maxLines = 1, color = Color.Gray)
        }
        Text(text = email.time, color = Color.Gray)
        IconButton(onClick = onDelete) {
            Icon(imageVector = Icons.Default.Delete, contentDescription = "Delete Email")
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
            fadeIn() with fadeOut()
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
