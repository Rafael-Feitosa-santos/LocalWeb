package br.com.localweb.Screens

import android.os.Build
import androidx.annotation.RequiresApi
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import java.time.LocalDate
import java.time.YearMonth
import java.time.format.TextStyle
import java.util.Locale


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CalendarioScreen(navController: NavController) {
    // Obter a data atual
    val currentDate = LocalDate.now()
    var selectedYear by remember { mutableStateOf(currentDate.year) }
    var selectedMonth by remember { mutableStateOf(currentDate.monthValue) }
    var selectedDay by remember { mutableStateOf(currentDate.dayOfMonth) }

    // Mapa de compromissos onde a chave é o dia e o valor é uma lista de compromissos desse dia
    val appointments = remember { mutableStateMapOf<Int, MutableList<Appointment>>() }
    var newAppointment by remember { mutableStateOf("") }
    var selectedColor by remember { mutableStateOf(Color.Gray) } // Cor padrão

    // Lista de cores disponíveis
// Lista de cores disponíveis
    val colorOptions = listOf(
        Color(0xFFE0E0E0), // Cinza Claro
        Color(0xFFB0BEC5), // Cinza Azulado
        Color(0xFF9E9E9E), // Cinza Médio
        Color(0xFFBCAAA4), // Bege Claro
        Color(0xFFCFD8DC), // Azul Claro
        Color(0xFFF5F5F5)  // Branco Neve
    )
    var selectedIcon by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(colorResource(id = br.com.localweb.R.color.vermelho))
            .height(90.dp),
    ) {


    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .offset(y = 120.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Cabeçalho do mês e ano (em português)
        Text(
            text = "${YearMonth.of(selectedYear, selectedMonth).month.getDisplayName(TextStyle.FULL, Locale("pt", "BR"))
                .replaceFirstChar { it.uppercase() }} $selectedYear",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Botão para voltar ao dia atual
        Button(
            onClick = {
                // Atualiza o estado para refletir a data atual
                selectedYear = currentDate.year
                selectedMonth = currentDate.monthValue
                selectedDay = currentDate.dayOfMonth
            },
            colors = ButtonDefaults.buttonColors(
                colorResource(id = br.com.localweb.R.color.btn_vermelho)
            )
        ) {
            Text(text = "Ir para Hoje")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Calendário
        DaysOfMonth(
            year = selectedYear,
            month = selectedMonth,
            selectedDay = selectedDay,
            appointments = appointments,
            onDaySelected = { selectedDay = it }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Exibir compromissos do dia selecionado
        Text(
            text = "Compromissos para o dia $selectedDay:",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )

        // Recuperar a lista de compromissos para o dia selecionado
        val dayAppointments = appointments[selectedDay] ?: mutableListOf()

        dayAppointments.toMutableList().forEachIndexed { index, appointment ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = appointment.description,
                    modifier = Modifier
                        .background(appointment.color) // Aplicar a cor ao compromisso
                        .padding(8.dp)
                )
                Button(onClick = {
                    // Criar uma cópia mutável da lista para manipulação
                    val updatedAppointments = appointments[selectedDay]?.toMutableList() ?: mutableListOf()
                    updatedAppointments.removeAt(index)
                    // Atualizar a lista de compromissos
                    appointments[selectedDay] = updatedAppointments

                    // Se a lista ficar vazia após a remoção, removemos o dia do mapa
                    if (appointments[selectedDay]?.isEmpty() == true) {
                        appointments.remove(selectedDay)
                    }
                }) {
                    Text(text = "Apagar")
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Campo para adicionar compromisso
        BasicTextField(
            value = newAppointment,
            onValueChange = { newAppointment = it },
            modifier = Modifier
                .background(Color.LightGray, CircleShape)
                .padding(8.dp)
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Seletor de cores
        Text(text = "Selecione uma cor para o compromisso:")
        Row(modifier = Modifier.padding(8.dp), horizontalArrangement = Arrangement.Center) {
            colorOptions.forEach { color ->
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .background(color)
                        .clickable { selectedColor = color }, // Atualizar a cor selecionada
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Botão para adicionar compromisso
        Button(
            onClick = {
                if (newAppointment.isNotBlank()) {
                    // Adicionar compromisso ao dia selecionado com a cor escolhida
                    val newEntry = Appointment(selectedDay, newAppointment, selectedColor)
                    appointments.computeIfAbsent(selectedDay) { mutableListOf() }.add(newEntry)
                    newAppointment = ""
                }
            },
            colors = ButtonDefaults.buttonColors(
                colorResource(id = br.com.localweb.R.color.btn_vermelho)
            )
        )  {
            Text(text = "Adicionar Compromisso")
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(110.dp)
            .background(colorResource(id = br.com.localweb.R.color.vermelho))
            .offset(y = 15.dp),
        horizontalAlignment = Alignment.End,
        verticalArrangement = Arrangement.SpaceEvenly
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
                onClick = {
                    selectedIcon = "email"
                    navController.navigate("home")
                },

                )

            AnimatedIcon(
                icon = Icons.Default.DateRange,
                contentDescription = "Calendar Icon",
                selectedIcon = selectedIcon,
                iconName = "calendar",
                onClick = {
                    selectedIcon = "calendar"
                    navController.navigate("calendario")
                }
            )


        }
    }
}



data class Appointment(val day: Int, val description: String, val color: Color)

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DaysOfMonth(
    year: Int,
    month: Int,
    selectedDay: Int,
    appointments: Map<Int, List<Appointment>>, // Adiciona o parâmetro de compromissos
    onDaySelected: (Int) -> Unit
) {
    val daysInMonth = YearMonth.of(year, month).lengthOfMonth()
    val firstDayOfMonth = LocalDate.of(year, month, 1).dayOfWeek.value % 7
    val days = (1..daysInMonth).toList()

    Column {
        for (week in 0..5) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                for (dayOfWeek in 0..6) {
                    val dayIndex = week * 7 + dayOfWeek
                    if (dayIndex < firstDayOfMonth || dayIndex >= firstDayOfMonth + daysInMonth) {
                        Spacer(modifier = Modifier.weight(1f))
                    } else {
                        val day = days[dayIndex - firstDayOfMonth]
                        val hasAppointments = appointments[day]?.isNotEmpty() == true
                        DayItem(day, day == selectedDay, hasAppointments) {
                            onDaySelected(day)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun DayItem(day: Int, isSelected: Boolean, hasAppointments: Boolean, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .size(40.dp)
            .clip(CircleShape)
            .background(
                when {
                    isSelected -> Color.LightGray
                    hasAppointments -> colorResource(id = br.com.localweb.R.color.vermelho) // Cor para dias com compromissos
                    else -> Color.Transparent
                }
            )
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = day.toString(),
            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun EmailRow(
    email: EmailItem,
    isSelected: Boolean,
    onClick: () -> Unit,
    onDelete: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .background(if (isSelected) Color.LightGray else Color.Transparent)
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
fun ImageVector.AnimatedIcon(
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
                imageVector = this@AnimatedIcon,
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