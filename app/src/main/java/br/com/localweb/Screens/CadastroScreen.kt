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
import androidx.navigation.NavHostController

@Composable
fun CadastroScreen(navController: NavHostController) {

    var tamanhoCpf = 11


    var tamanhoSenha = 8

    var cpfState by remember {
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

    var confirmacaoSenhaState by remember { mutableStateOf("") }

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
                containerColor = colorResource(id = br.com.localweb.R.color.vermelho),
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
                painter = painterResource(id = br.com.localweb.R.drawable.localweb),
                contentDescription = "Logo Local Web",
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .size(280.dp)
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
                        text = "Nome",
                        color = colorResource(id = br.com.localweb.R.color.background_black)
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
                        tint = colorResource(id = br.com.localweb.R.color.vermelho)
                    )
                },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    focusedLabelColor = Color.White,
                ),
                placeholder = {
                    Text(text = "Como podemos te chamar?")
                }
            )


            OutlinedTextField(
                modifier = Modifier
                    .padding(top = 14.dp)
                    .offset(y = (-145).dp)
                    .fillMaxWidth(),
                value = emailState,
                onValueChange = {
                    emailState = it
                },

                label = {
                    Text(
                        text = "E-mail",
                        color = colorResource(id = br.com.localweb.R.color.background_black)
                    )

                },
                shape = RoundedCornerShape(12.dp),
                singleLine = true,
                keyboardOptions = KeyboardOptions
                    (keyboardType = KeyboardType.Email),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Email,
                        contentDescription = "Icone de E-mail",
                        tint = colorResource(id = br.com.localweb.R.color.vermelho)
                    )
                },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    focusedLabelColor = Color.White,
                ),
                placeholder = {
                    Text(text = "exemplo@exemplo.com.br")
                }
            )

            OutlinedTextField(
                modifier = Modifier
                    .padding(top = 14.dp, bottom = 12.dp)
                    .offset(y = (-145).dp)
                    .fillMaxWidth(),
                value = senhaState,
                onValueChange = {
                    if (it.length <= tamanhoSenha) senhaState = it
                },

                label = {
                    Text(
                        text = "Senha",
                        color = colorResource(id = br.com.localweb.R.color.background_black)
                    )

                },
                shape = RoundedCornerShape(12.dp),
                singleLine = true,
                keyboardOptions = KeyboardOptions
                    (keyboardType = KeyboardType.Text),
                visualTransformation =
                PasswordVisualTransformation(),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = "Icone de Telefone",
                        tint = colorResource(id = br.com.localweb.R.color.vermelho)
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

            OutlinedTextField(
                modifier = Modifier
                    .padding(top = 14.dp, bottom = 12.dp)
                    .offset(y = (-155).dp)
                    .fillMaxWidth(),
                value = confirmacaoSenhaState,  // Utilizando a variável para confirmação de senha
                onValueChange = {
                    if (it.length <= tamanhoSenha) confirmacaoSenhaState = it
                },
                label = {
                    Text(
                        text = "Confirmar Senha",
                        color = colorResource(id = br.com.localweb.R.color.background_black)
                    )
                },
                shape = RoundedCornerShape(12.dp),
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                visualTransformation = PasswordVisualTransformation(),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = "Ícone Senha",
                        tint = colorResource(id = br.com.localweb.R.color.vermelho)
                    )
                },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    focusedLabelColor = Color.White,
                ),
                placeholder = {
                    Text(text = "Confirme sua senha")
                }
            )

            Spacer(modifier = Modifier.height(9.dp))


            Button(
                onClick = {
                    isButtonPressedVoltar = !isButtonPressedVoltar
                    navController.navigate("confirmacao")
                },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .width(290.dp)
                    .offset(y = (-135).dp),
                shape = RoundedCornerShape(
                    bottomStart = 35.dp,
                    topEnd = 35.dp
                ),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (isButtonPressedVoltar)
                        Color.White else colorResource(id = br.com.localweb.R.color.btn_vermelho)
                ),
                border = BorderStroke(2.dp, if (isButtonPressedVoltar)
                    colorResource(id = br.com.localweb.R.color.btn_vermelho) else Color.Transparent)
            ) {
                Text(
                    text = "Próximo passo",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = if (isButtonPressedVoltar)
                        colorResource(id = br.com.localweb.R.color.btn_vermelho) else Color.White
                )
            }

        }
    }
}
