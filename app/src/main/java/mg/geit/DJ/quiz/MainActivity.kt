package mg.geit.DJ.quiz

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import mg.geit.DJ.quiz.ui.theme.QUIZTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QUIZTheme {
                Scaffold { innerPadding ->
                    FirstScreen(
                        onclick = {
                            val intent = Intent(this, AskingActivity::class.java)
                            startActivity(intent)
                        },
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun FirstScreen(onclick: () -> Unit, name: String, modifier: Modifier = Modifier) {
    Box(modifier = modifier
        .background(color = Color.White)
        .clickable { onclick() }
    ) {
        Box {
            Column {
                Text(
                    text = "QUAND PERSONNE DEMANDE TON PERSONALITE?",
                    color = Color.Magenta,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 70.dp),
                    textAlign = TextAlign.Center
                )

                Text(
                    text = "CLIQUER N'INPORT OU  POUR SAVOIR".trimIndent(),
                    color = Color.Blue,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp),
                    textAlign = TextAlign.Center
                )

                Image(
                    painter = painterResource(id = R.drawable._6_personnality_backgroud),
                    contentDescription = "background image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                )
            }
        }
    }
}
