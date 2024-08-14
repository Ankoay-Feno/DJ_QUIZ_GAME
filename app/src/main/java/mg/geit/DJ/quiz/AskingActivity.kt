package mg.geit.DJ.quiz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
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
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.gson.Gson

class AskingActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val jsonNedded = JsonNedded()
            val jsonContent = jsonNedded.readJsonFromAssets(this, "Profils.json")

            // Créer une instance de Gson
            val gson = Gson()

            // Désérialiser le JSON en une instance de CategoriesProfils
            val categoriesProfils = gson.fromJson(jsonContent, CategoriesProfils::class.java)

            QuestionScreen(categoriesProfils = categoriesProfils)
        }
    }
}

@Composable
fun QuestionScreen(categoriesProfils: CategoriesProfils) {
    var questionIndex by remember { mutableStateOf(0) } // Pour gérer l'indice de la question actuelle
    val allQuestions = categoriesProfils.getAllQuestions()

    Box (modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.padding(top = 10.dp)) {
            if (allQuestions.isNotEmpty()) {
                Image(modifier = Modifier.align(Alignment.CenterHorizontally),
                    painter = painterResource(id = R.drawable.image), contentDescription = "icon")
                // Afficher la question actuelle
                BlockQuestion(question = allQuestions[questionIndex])

                Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween)
                {
                    Text(fontSize = 10.sp, text = "         Totalement en desaccord")
                    Text(fontSize = 10.sp, text = "neutre       ")
                    Text(fontSize = 10.sp, text = "Totalement en accord         ")
                }

                // Afficher les boutons "Prev" et "Next"
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Button(onClick = { if (questionIndex > 0) questionIndex-- }) {
                        Text("Precedent")
                    }
                    Button(onClick = { if (questionIndex < allQuestions.size - 1) questionIndex++ }) {
                        Text("Suivant")
                    }
                }
            } else {
                Text("No questions available")
            }
        }
    }
}

@Composable
fun CustomCheckbox(
    isChecked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    backgroundColor: Color,
    size: Dp
) {
    Box(
        modifier = Modifier
            .size(size)
            .border(
                width = 2.dp,
                color = if (isChecked) Color.Transparent else backgroundColor, // Color of border when checked or unchecked
                shape = CircleShape
            )
            .background(
                color = if (isChecked) backgroundColor else Color.Transparent, // Background color when checked or unchecked
                shape = CircleShape
            )
            .padding(4.dp), // Padding inside the box
        contentAlignment = Alignment.Center
    ) {
        Checkbox(
            modifier = Modifier.size(size),
            checked = isChecked,
            onCheckedChange = onCheckedChange,
            colors = CheckboxDefaults.colors(
                checkedColor = Color.Transparent, // Checkbox color when checked
                uncheckedColor = Color.Transparent // Checkbox color when unchecked
            )
        )
    }
}


@Composable
fun BlockQuestion(question:String)
{
    var selectedIndex by remember { mutableStateOf(-1) } // -1 means no checkbox is selected

    val checkboxSize = 60.dp
    val spacing = 5.dp

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    )
    {
        Column (modifier = Modifier.fillMaxHeight(0.7f))
        {
            Box (modifier = Modifier)
            {
                Text(
                    text = question,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxHeight(0.6f),
                    fontSize = 20.sp,
                    fontFamily = FontFamily.Serif

                )
            }
            Spacer(modifier = Modifier.padding(10.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.CenterHorizontally), // Center the Row horizontally
                horizontalArrangement = Arrangement.SpaceEvenly, // Space the checkboxes evenly
                verticalAlignment = Alignment.CenterVertically
            )
            {
                CustomCheckbox(
                    isChecked = selectedIndex == 0,
                    onCheckedChange = { isChecked ->
                        if (isChecked) selectedIndex = 0 else selectedIndex = -1
                    },
                    backgroundColor = Color.Red,
                    size = 60.dp
                )

                Spacer(modifier = Modifier.width(spacing))

                CustomCheckbox(
                    isChecked = selectedIndex == 1,
                    onCheckedChange = { isChecked ->
                        if (isChecked) selectedIndex = 1 else selectedIndex = -1
                    },
                    backgroundColor = Color(0xFFFFA500),
                    size = 50.dp
                )

                Spacer(modifier = Modifier.width(spacing))

                CustomCheckbox(
                    isChecked = selectedIndex == 2,
                    onCheckedChange = { isChecked ->
                        if (isChecked) selectedIndex = 2 else selectedIndex = -1
                    },
                    backgroundColor = Color.Yellow,
                    size = 40.dp
                )

                Spacer(modifier = Modifier.width(spacing))

                CustomCheckbox(
                    isChecked = selectedIndex == 3,
                    onCheckedChange = { isChecked ->
                        if (isChecked) selectedIndex = 3 else selectedIndex = -1
                    },
                    backgroundColor = Color.Green,
                    size = 50.dp
                )

                Spacer(modifier = Modifier.width(spacing))

                CustomCheckbox(
                    isChecked = selectedIndex == 4,
                    onCheckedChange = { isChecked ->
                        if (isChecked) selectedIndex = 4 else selectedIndex = -1
                    },
                    backgroundColor = Color.Blue,
                    size = 60.dp
                )
            }
        }

    }
}

fun CategoriesProfils.getAllQuestions(): List<String> {
    val allQuestions = mutableListOf<String>()
    bienfaiteur?.let { allQuestions.addAll(it) }
    insoumis?.let { allQuestions.addAll(it) }
    visionnaire?.let { allQuestions.addAll(it) }
    célébrité?.let { allQuestions.addAll(it) }
    médiateur?.let { allQuestions.addAll(it) }
    conservateur?.let { allQuestions.addAll(it) }
    épicurien?.let { allQuestions.addAll(it) }
    leader?.let { allQuestions.addAll(it) }

    // Tri des questions par leur identifiant (e.g., "Q1", "Q2", ...)
    allQuestions.sortBy { question ->
        // Extraire le numéro de la question après "Q" et convertir en entier pour tri
        question.substring(1).takeWhile { it.isDigit() }.toInt()
    }
    return allQuestions
}
