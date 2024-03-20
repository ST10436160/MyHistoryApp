package za.ac.iie.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val historicFigures = mapOf(
        0..20 to "No historic figures for this age group",
        21..30 to "Napoleon Bonaparte",
        31..40 to "Abraham Lincoln",
        41..50 to "Albert Einstein",
        51..60 to "Winston Churchill",
        61..70 to "Nelson Mandela",
        71..80 to "Queen Elizabeth II",
        81..Int.MAX_VALUE to "No historic figures for this age group"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val generateHistoryButton = findViewById<Button>(R.id.generateHistoryButton)
        val infoTextView = findViewById<TextView>(R.id.infoTextView)
        val ageEditText = findViewById<EditText>(R.id.ageEditText)

        generateHistoryButton.setOnClickListener {
            val ageText = ageEditText.text.toString()
            if (ageText.isNotEmpty()) {
                val age = ageText.toInt()
                val historicFigure = findHistoricFigure(age)
                infoTextView.text = historicFigure
            } else {
                infoTextView.text = "Please enter your age"
            }
        }
    }

    private fun findHistoricFigure(age: Int): String {
        for ((ageRange, figure) in historicFigures) {
            if (age in ageRange) {
                return figure
            }
        }
        return "No historic figure found for this age"
    }
}

