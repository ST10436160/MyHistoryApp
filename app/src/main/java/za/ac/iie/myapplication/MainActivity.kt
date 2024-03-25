package za.ac.iie.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val historicFigures = mapOf(
        0..20 to Pair("Blaise Pascal", "developed a calculator at 19"),
        21..30 to Pair("William Pitt the Younger", " became prime minister of England at 24"),
        31..40 to Pair("Alexander the great", "Created an empire and died at 32"),
        41..50 to Pair("Henry Ford", "Invented the assembly line when he was 50"),
        51..60 to Pair("Adolf Hitler", "Died at the age of 56"),
        61..70 to Pair("George Washington", "Died at the age of 67"),
        71..80 to Pair("Albert Einstein", "Died at the age of 76"),
        81..Int.MAX_VALUE to Pair("No historic figures for this age group", "")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val generateHistoryButton = findViewById<Button>(R.id.generateHistoryButton)
        val clearButton = findViewById<Button>(R.id.clearButton)
        val infoTextView = findViewById<TextView>(R.id.infoTextView)
        val ageEditText = findViewById<EditText>(R.id.ageEditText)

        generateHistoryButton.setOnClickListener {
            val ageText = ageEditText.text.toString()
            if (ageText.isNotEmpty()) {
                val age = ageText.toInt()
                val historicFigureInfo = findHistoricFigure(age)
                infoTextView.text = historicFigureInfo
            } else {
                infoTextView.text = "Please enter your age"
            }
        }

        clearButton.setOnClickListener {
            infoTextView.text = "" // Clear info text
            ageEditText.text.clear() // Clear age input
        }
    }

    private fun findHistoricFigure(age: Int): String {
        for ((ageRange, figureInfo) in historicFigures) {
            if (age in ageRange) {
                val (historicFigure, deathInfo) = figureInfo
                return if (deathInfo.isNotEmpty()) {
                    "$historicFigure: $deathInfo"
                } else {
                    "$historicFigure"
                }
            }
        }
        return "No historic figure found for this age"
    }
}
