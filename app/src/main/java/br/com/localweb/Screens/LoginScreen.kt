package br.com.localweb.Screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun LoginScreen(navController: NavController) {

    var usuarioState by remember {
        mutableStateOf("")
    }

    var senhaState by remember {
        mutableStateOf("")
    }

    var tamanhoSenha = 8

    var tamanhoCpf = 30

    var isChecked by remember { mutableStateOf(false) }

    var isSubscribed by remember { mutableStateOf(false) }

    var isButtonPressed by remember { mutableStateOf(false) }

    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = androidx.compose.ui.Modifier
            .background(color = Color.White)
            .fillMaxSize()
    ) {
        Card(
            modifier = androidx.compose.ui.Modifier
                .size(width = 900.dp, height = 150.dp),
            colors = CardDefaults.cardColors(
                containerColor = colorResource(id = br.com.localweb.R.color.background_black),
            ),
            shape = RoundedCornerShape(
                bottomEndPercent = 95
            ),

            ) {
            Card(
                modifier = androidx.compose.ui.Modifier
                    .align(Alignment.CenterHorizontally)

            ) {

            }
        }

        Column(
            modifier = androidx.compose.ui.Modifier
                .align(Alignment.CenterHorizontally)
                .padding(horizontal = 32.dp)
                .fillMaxWidth()

        ) {

            Image(
                painter = painterResource(id = br.com.localweb.R.drawable.localweb),
                contentDescription = "Logo Local Web",
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .size(300.dp)
                    .offset(y = (-90).dp)
            )

            OutlinedTextField(
                modifier = androidx.compose.ui.Modifier
                    .offset(y = (-165).dp)
                    .fillMaxWidth(),
                value = usuarioState,
                onValueChange = {
                    if (it.length <= tamanhoCpf) usuarioState = it
                },

                label = {
                    Text(
                        text = "E-mail",
                        color = Color(color = 0xFF1E1E1E)
                    )

                },
                shape = RoundedCornerShape(12.dp),
                singleLine = true,
                keyboardOptions = KeyboardOptions
                    (keyboardType = KeyboardType.Email),
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.Email,
                        contentDescription = "Icone de e-mail",
                        tint = colorResource(id = br.com.localweb.R.color.icon_input)
                    )
                },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    focusedLabelColor = Color(color = 0xFF1E1E1E),
                    unfocusedTextColor = Color.Gray
                ),
                placeholder = {
                    Text(text = "exemplo@exemplo.com.br")
                },

                )

            Spacer(modifier = androidx.compose.ui.Modifier.height(25.dp))

            OutlinedTextField(
                modifier = androidx.compose.ui.Modifier
                    .offset(y = (-175).dp)
                    .fillMaxWidth(),
                value = senhaState,
                onValueChange = {
                    if (it.length <= tamanhoSenha) senhaState = it
                },
                label = {
                    Text(
                        text = "Senha",
                        color = Color(0xFF1E1E1E)
                    )
                },
                shape = RoundedCornerShape(12.dp),
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text
                ),
                visualTransformation = PasswordVisualTransformation(),
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = "Ícone de Bloqueio",
                        tint = colorResource(id = br.com.localweb.R.color.icon_input)
                    )
                },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    focusedLabelColor = Color(0xFF1E1E1E),
                ),
                placeholder = {
                    Text(text = "Digite sua senha")
                }
            )

            Spacer(modifier = androidx.compose.ui.Modifier.height(16.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = androidx.compose.ui.Modifier
                    .offset(y = (-165).dp)
                    .padding(start = 16.dp)
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(20.dp)
                        .border(BorderStroke(2.dp, Color.Black))
                        .background(Color.White)
                        .clickable {
                            isChecked = !isChecked
                        }
                ) {
                    if (isChecked) {
                        Icon(
                            imageVector = Icons.Default.Check,
                            contentDescription = "Checked",
                            tint = Color.Black,
                            modifier = Modifier.size(16.dp)
                        )
                    }
                }

                Spacer(modifier = androidx.compose.ui.Modifier.width(8.dp))

                Text(
                    text = "Lembrar?",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
            }


            Spacer(modifier = androidx.compose.ui.Modifier.height(42.dp))

            Button(
                onClick = {
                    isButtonPressed = !isButtonPressed
                    navController.navigate("tela inicial")
                },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .width(290.dp)
                    .offset(y = (-150).dp),
                shape = RoundedCornerShape(
                    bottomStart = 35.dp,
                    topEnd = 35.dp
                ),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (isButtonPressed) Color.White else colorResource(id = br.com.localweb.R.color.color_botao)
                ),
                border = BorderStroke(
                    2.dp,
                    if (isButtonPressed) colorResource(id = br.com.localweb.R.color.color_botao) else Color.Transparent
                )
            ) {
                Text(
                    text = "ENTRAR",
                    modifier = Modifier
                        .padding(8.dp)
                        .border(BorderStroke
                            (2.dp, colorResource(id = br.com.localweb.R.color.color_botao))),
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = if (isButtonPressed) colorResource(id = br.com.localweb.R.color.color_botao) else Color.White  // Muda a cor do texto
                )
            }
            Row(
                modifier = androidx.compose.ui.Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 32.dp)
                    .offset(y = (-140).dp)
            )
            {
                Text(
                    modifier = Modifier,
                    text = "Não tem Conta? ",
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp,
                    color = colorResource(id = br.com.localweb.R.color.background_black)

                )
                Button(
                    onClick = {
                        isSubscribed = !isSubscribed  // Alterna o estado de clique
                        navController.navigate("cadastro")
                    },
                    modifier = Modifier
                        .offset(y = (-10).dp)
                        .padding(start = 8.dp)
                        .align(Alignment.CenterVertically),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (isSubscribed) Color.White else colorResource(id = br.com.localweb.R.color.btn_vermelho)  // Fundo branco quando pressionado
                    ),
                    border = BorderStroke(1.dp, Color.Red)  // Mantém a borda vermelha
                ) {
                    Text(
                        text = "Cadastre-se",
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold,
                        color = if (isSubscribed) colorResource(id = br.com.localweb.R.color.btn_vermelho) else Color.White  // Texto vermelho quando pressionado
                    )
                }

            }
            Card(
                modifier = androidx.compose.ui.Modifier
                    .size(width = 600.dp, height = 25.dp)
                    .fillMaxWidth(),

                colors = CardDefaults.cardColors(
                    containerColor = colorResource(id = br.com.localweb.R.color.background_black)
                ),
                shape = RoundedCornerShape(
                    topStartPercent = 40,
                    topEndPercent = 40
                )

            ) {

            }

        }
    }
}