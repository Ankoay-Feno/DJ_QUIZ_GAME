package mg.geit.DJ.quiz

import android.content.Context
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

 class JsonNedded {
    // Fonction pour lire le contenu JSON du fichier
    private fun readJsonFromAssets(context: Context, fileName: String): String? {
        return try {
            val inputStream: InputStream = context.assets.open(fileName)
            val reader = BufferedReader(InputStreamReader(inputStream))
            val sb = StringBuilder()
            reader.forEachLine { sb.append(it) }
            reader.close()
            sb.toString()
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}