package mg.geit.DJ.quiz

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import java.io.BufferedReader
import java.io.File
import java.io.InputStream
import java.io.InputStreamReader

class AskingActivity:AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent{
            val profil:Profils? = readJsonFromAssets(this, "Profils.json", Profils::class.java)
            AskingQuestions(text = profil.toString())
        }
    }
}

fun <T> readJsonFromAssets(context: Context, fileName: String, classOfT: Class<T>): T? {
    val json: String? = try {
        val inputStream: InputStream = context.assets.open(fileName)
        val reader = BufferedReader(InputStreamReader(inputStream))
        val sb = StringBuilder()
        var line: String?
        while (reader.readLine().also { line = it } != null) {
            sb.append(line)
        }
        reader.close()
        sb.toString()
    } catch (e: Exception) {
        e.printStackTrace()
        null
    }

    val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    val jsonAdapter = moshi.adapter(classOfT)
    return json?.let { jsonAdapter.fromJson(it) }
}

@Composable
fun AskingQuestions(text :String)
{
    Text(text = text)
}

