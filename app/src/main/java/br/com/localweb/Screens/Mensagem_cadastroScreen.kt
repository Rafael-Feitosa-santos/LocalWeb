package br.com.localweb.Screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.localweb.R

@Composable
fun Mensagem_CadastroScreen(navController: NavController) {

    var isButtonPressed by remember { mutableStateOf(false) }


    Box(modifier = Modifier
        .background(colorResource(id = br.com.localweb.R.color.background_black))
        .fillMaxSize()
    ){
        Row(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .offset(y = 220.dp)
                .padding(start = 22.dp)
        ) {
            Text(
                text = "Parabéns!! \nSeu e-mail foi criado.",
                color = Color.White,
                fontSize = 33.sp,
                fontWeight = FontWeight.Black,
                lineHeight = 55.sp
            )
        }

        Button(
            onClick = {
                isButtonPressed = !isButtonPressed
                navController.navigate("login")
            },
            modifier = Modifier
                .width(290.dp)
                .offset(y = 400.dp, x = 60.dp),
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
                text = "Sair",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = if (isButtonPressed) colorResource(id = br.com.localweb.R.color.color_botao) else Color.White
            )
        }
    }
}