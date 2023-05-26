package com.example.basictriviacopy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import com.example.basictriviacopy.databinding.ActivityPoliticsQuesDiffBinding




class PoliticsQuesDiff : AppCompatActivity() {


    private lateinit var binding: ActivityPoliticsQuesDiffBinding
    private var rightAnswer: String? = null
    private var rightAnswerCount = 0
    private var quizCount=1
    private val total_questions=5


    private val politicsQues= mutableListOf(
        mutableListOf("The name of the Laccadive, Minicoy and Amindivi islands was changed to Lakshadweep by an Act of Parliament in","1970", "1971", "1972", "1973"),
        mutableListOf("The power to decide an election petition is vested in the","High courts", "mumbai", "Parliament", "Election commission"),
        mutableListOf("The members of Lok Sabha hold office for a term of ____ years","5", "4", "3", "6"),
        mutableListOf("The minimum age to qualify for election to the Lok Sabha is","25 years", "35 years", "21 years", "18 years"),
        mutableListOf("The president can dissolve the Lok Sabha on","advice of the prime minister", "advice of the chief justice of India", "recommendation of Lok Sabha", "recommendation of the Rajya Sabha"),
        )





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        binding= ActivityPoliticsQuesDiffBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)

        //getMyData();


        //shuffling the questions
        politicsQues.shuffle()

        showNextQues()

    }

    fun showNextQues()
    {
        binding.questionNumber.text=getString(R.string.questionNumber, quizCount)
        val quiz = politicsQues[0]

        //displaying the question
        binding.question.text=quiz[0]
        rightAnswer= quiz[1]

        quiz.removeAt(0)

        //shuffling the choices
        quiz.shuffle()

        //removing this ques from quiz data
        politicsQues.removeAt(0)


        //displaying corresponding choices
        binding.option1.text=quiz[0]
        binding.option2.text=quiz[1]
        binding.option3.text=quiz[2]
        binding.option4.text=quiz[3]



    }


    fun checkCorrectAns()
    {
        if(quizCount==total_questions)
        {
            val intent= Intent(this@PoliticsQuesDiff,ResultActivity::class.java)
            intent.putExtra("RIGHT_ANSWER_COUNT",rightAnswerCount)
            startActivity(intent)

        }

        else{
            quizCount++;
            showNextQues();

        }

    }

    fun checkAnswer(view: View) {
        val answerBtn: Button = findViewById(view.id)
        val btnText = answerBtn.text.toString()

        val alertTitle: String
        if (btnText == rightAnswer) {
            alertTitle = "Correct!";
            rightAnswerCount++;
        }
        else{
            alertTitle="Wrong!"
        }

        AlertDialog.Builder(this)
            .setTitle(alertTitle)
            .setMessage("Answer: $rightAnswer")
            .setPositiveButton("OK"){dialogInterface, i-> checkCorrectAns()}
            .setCancelable(false)
            .show()




    }


}
