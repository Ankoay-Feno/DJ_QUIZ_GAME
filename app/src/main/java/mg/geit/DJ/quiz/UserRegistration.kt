package mg.geit.DJ.quiz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview

class UserRegistration : ComponentActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Registration()
        }
    }
}


@Composable
fun Registration()
{
        var name by remember { mutableStateOf(" ") }
        var firstname by remember { mutableStateOf(" ") }
        var number by remember { mutableStateOf(" ") }
        var email by remember { mutableStateOf(" ") }



        Column {
            Image(modifier = Modifier.align(Alignment.CenterHorizontally),
                painter = painterResource(id = R.drawable.image), contentDescription = "icon")
            OutlinedTextField(modifier = Modifier.align(Alignment.CenterHorizontally),
                value = name,
                onValueChange = {name = it },
                label = { Text("NOM") }
            )
            OutlinedTextField(modifier = Modifier.align(Alignment.CenterHorizontally),
                value = firstname,
                onValueChange = {firstname = it},
                label = { Text(text = "PRENOM")})
            OutlinedTextField(modifier = Modifier.align(Alignment.CenterHorizontally),
                value = number,
                onValueChange = { number = it },
                label = { Text(text = "NUMBER")}
            )
            OutlinedTextField(modifier = Modifier.align(Alignment.CenterHorizontally),
                value = email,
                onValueChange = { email = it },
                label = { Text(text = "EMAIL")}
            )
            Button(modifier = Modifier.align(Alignment.CenterHorizontally),
                onClick = { /*TODO*/ })
            {
                Text(text = "Commencer")
            }
        }


}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RegistrationPreview()
{
    Registration()
}
