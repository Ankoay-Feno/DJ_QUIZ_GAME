package mg.geit.DJ.quiz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import mg.geit.DJ.quiz.JsonNedded.

class AskingActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val json: JsonNedded? =  JsonNedded()
            val jsonContent = json.read

            AskingQuestions(text = jsonContent ?: "No content found")
        }
    }



    @Composable
    fun AskingQuestions(text: String) {
        Text(text = text)
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewAskingQuestions() {
        AskingQuestions(text = "Preview Text")
    }
}
