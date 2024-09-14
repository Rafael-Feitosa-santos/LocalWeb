package br.com.localweb.Screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun CadastroScreen(navController: NavHostController) {

    var tamanhoCpf = 11

    var tamanhoTel = 9

    var tamanhoSenha = 8

    var cpfState by remember {
        mutableStateOf("")
    }

    var telState by remember {
        mutableStateOf("")
    }

    var emailState by remember {
        mutableStateOf("")
    }
    var senhaState by remember {
        mutableStateOf("")
    }

    var isButtonPressed by remember { mutableStateOf(false) }

    var isButtonPressedVoltar by remember { mutableStateOf(false) }

    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
    ) {
        Card(
            modifier = Modifier
                .size(width = 900.dp, height = 190.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFF90F0F),
            ),
            shape = RoundedCornerShape(bottomEndPercent = 95),
        ) {
            Card(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)

            ) {

            }
        }

        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(horizontal = 32.dp)
                .fillMaxWidth()

        ) {
            Image(
                painter = painterResource(id = br.com.localweb.R.drawable.local_web2),
                contentDescription = "Logo Local Web",
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .size(300.dp)
                    .offset(y = (-90).dp)
            )

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .offset(y = (-145).dp)
                    .padding(top = 14.dp),
                value = cpfState,
                onValueChange = {
                    if (it.length <= tamanhoCpf) cpfState = it
                },

                label = {
                    Text(
                        text = "CPF",
                        color = Color(color = 0xFF1E1E1E)
                    )

                },
                shape = RoundedCornerShape(12.dp),
                singleLine = true,
                keyboardOptions = KeyboardOptions
                    (keyboardType = KeyboardType.Number),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Icone de Pessoa",
                        tint = Color.White
                    )
                },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    focusedLabelColor = Color.White,
                ),
                placeholder = {
                    Text(text = "Informe o CPF")
                }
            )

            OutlinedTextField(
                modifier = Modifier
                    .padding(top = 14.dp)
                    .offset(y = (-140).dp)
                    .fillMaxWidth(),
                value = telState,
                onValueChange = {
                    if (it.length <= tamanhoTel) telState = it

                },

                label = {
                    Text(
                        text = "Telefone",
                        color = Color(color = 0xFF1E1E1E)
                    )

                },
                shape = RoundedCornerShape(14.dp),
                singleLine = true,
                keyboardOptions = KeyboardOptions
                    (keyboardType = KeyboardType.Number),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Phone,
                        contentDescription = "Icone de Telefone",
                        tint = Color.White
                    )
                },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    focusedLabelColor = Color.White,
                ),
                placeholder = {
                    Text(text = "Informe seu número")
                }
            )

            OutlinedTextField(
                modifier = Modifier
                    .padding(top = 14.dp)
                    .offset(y = (-135).dp)
                    .fillMaxWidth(),
                value = emailState,
                onValueChange = {
                    emailState = it
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
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Email,
                        contentDescription = "Icone de Telefone",
                        tint = Color.White
                    )
                },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    focusedLabelColor = Color.White,
                ),
                placeholder = {
                    Text(text = "Informe seu e-mail")
                }
            )

            OutlinedTextField(
                modifier = Modifier
                    .padding(top = 14.dp, bottom = 12.dp)
                    .offset(y = (-135).dp)
                    .fillMaxWidth(),
                value = senhaState,
                onValueChange = {
                    if (it.length <= tamanhoSenha) senhaState = it
                },

                label = {
                    Text(
                        text = "Senha",
                        color = Color(color = 0xFF1E1E1E)
                    )

                },
                shape = RoundedCornerShape(12.dp),
                singleLine = true,
                keyboardOptions = KeyboardOptions
                    (keyboardType = KeyboardType.NumberPassword),
                visualTransformation =
                PasswordVisualTransformation(),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = "Icone de Telefone",
                        tint = Color.White
                    )
                },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    focusedLabelColor = Color.White,
                ),
                placeholder = {
                    Text(text = "Digite sua senha")
                }
            )

            Spacer(modifier = Modifier.height(9.dp))

            Button(
                onClick = {
                    isButtonPressed = !isButtonPressed  // Alterna o estado de clique
                    navController.navigate("login")
                },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .width(290.dp)
                    .offset(y = (-115).dp),
                shape = RoundedCornerShape(
                    bottomStart = 35.dp,
                    topEnd = 35.dp
                ),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (isButtonPressed) Color.White else Color(color = 0xFFF90F0F)  // Muda a cor de fundo
                ),
                border = BorderStroke(2.dp, if (isButtonPressed) Color.Red else Color.Transparent)  // Adiciona a borda vermelha
            ) {
                Text(
                    text = "Criar Conta",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = if (isButtonPressed) Color.Red else Color.White  // Muda a cor do texto
                )
            }

            Button(
                onClick = {
                    isButtonPressedVoltar = !isButtonPressedVoltar  // Alterna o estado de clique
                    navController.navigate("login")
                },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .width(290.dp)
                    .offset(y = (-95).dp),
                shape = RoundedCornerShape(
                    bottomStart = 35.dp,
                    topEnd = 35.dp
                ),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (isButtonPressedVoltar) Color.White else Color(0xFFF90F0F)  // Muda a cor de fundo
                ),
                border = BorderStroke(2.dp, if (isButtonPressedVoltar) Color.Red else Color.Transparent)  // Adiciona a borda vermelha
            ) {
                Text(
                    text = "Voltar",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = if (isButtonPressedVoltar) Color.Red else Color.White  // Muda a cor do texto
                )
            }

        }
    }
}
