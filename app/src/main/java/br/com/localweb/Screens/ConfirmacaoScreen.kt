package br.com.localweb.Screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.localweb.R

@Composable
fun ConfirmacaoScreen(navController: NavController) {

    var isTermsChecked by remember { mutableStateOf(false) }
    var isEmailSmsChecked by remember { mutableStateOf(false) }
    var showError by remember { mutableStateOf(false) }
    var isButtonPressed by remember { mutableStateOf(false) }


    Box(
        modifier = Modifier
            .background(colorResource(id = br.com.localweb.R.color.background_black))
            .fillMaxWidth()
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(y = 160.dp)
                .padding(start = 32.dp)
        ) {
            Text(
                text = "Muito bem!",
                color = colorResource(id = br.com.localweb.R.color.color_botao),
                fontSize = 33.sp,
                fontWeight = FontWeight.Black
            )
        }
        Row(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(y = 180.dp)
                .padding(32.dp)
        ) {
            Text(
                text = "\nAgora aceite os termos e condições abaixo ou clique no link que enviaremos ao seu e-mail.",
                color = Color.White,
                fontSize = 20.sp,
                textAlign = TextAlign.Left,
                fontWeight = FontWeight.W400
            )
        }

        Row(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(y = 325.dp)
                .padding(32.dp)
        ) {
            Text(
                text = "Leia antes de seguir:",
                color = Color.White,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.W400
            )
        }


    }


    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(32.dp)
            .offset(y = 370.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            Checkbox(
                checked = isTermsChecked,
                onCheckedChange = { isChecked ->
                    isTermsChecked = isChecked
                    showError = !isChecked  // Se não estiver marcado, mostra o erro
                },
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Green,
                    uncheckedColor = Color.Gray
                )
            )
            Text(
                text = "Concordo com os Termos e Condições de Uso da ferramenta",
                modifier = Modifier.padding(start = 8.dp),
                fontSize = 16.sp,
                color = Color.White
            )
        }

        if (showError && !isTermsChecked) {
            Text(
                text = "Você precisa concordar com os Termos para continuar.",
                color = Color.Red,
                fontSize = 14.sp,
                modifier = Modifier.padding(start = 40.dp)
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = isEmailSmsChecked,
                onCheckedChange = { isChecked ->
                    isEmailSmsChecked = isChecked
                },
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Green,
                    uncheckedColor = Color.Gray
                )
            )
            Text(
                text = "Concordo em receber comunicados e avisos por e-mail/sms",
                modifier = Modifier.padding(start = 8.dp),
                fontSize = 16.sp,
                color = Color.White
            )
        }

        Button(
            onClick = {
                isButtonPressed = !isButtonPressed
                navController.navigate("mensagem")
            },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .width(290.dp)
                .offset(y = 85.dp),
            shape = RoundedCornerShape(
                bottomStart = 35.dp,
                topEnd = 35.dp
            ),
            colors = ButtonDefaults.buttonColors(
                containerColor = if (isButtonPressed) Color.White else
                    colorResource(id = br.com.localweb.R.color.color_botao)
            ),
            border = BorderStroke(2.dp, if (isButtonPressed)
                colorResource(id = R.color.color_botao) else Color.Transparent)
        ) {
            Text(
                text = "Criar Conta",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = if (isButtonPressed) colorResource(id = br.com.localweb.R.color.color_botao) else Color.White
            )
        }

    }
}
