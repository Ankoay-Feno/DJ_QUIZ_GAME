package mg.geit.DJ.quiz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import mg.geit.DJ.quiz.ui.theme.QUIZTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QUIZTheme {
                Scaffold(modifier = Modifier
                    .fillMaxSize()) { innerPadding ->
                    FirstScreen(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun FirstScreen(name: String, modifier: Modifier = Modifier) {
        Box(modifier = Modifier.background(color = Color.White)) {
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


                    Text(text = "CLIQUER N'INPORT OU  POUR SAVOIR".trimIndent(),
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
                            .clickable { }
                    )
                }

            }
        }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    QUIZTheme {
        FirstScreen("Android")
    }
}