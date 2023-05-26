package com.example.basictriviacopy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import com.example.basictriviacopy.databinding.ActivitySportsQuesDiffBinding



class SportsQuesDiff : AppCompatActivity() {


    private lateinit var binding: ActivitySportsQuesDiffBinding
    private var rightAnswer: String? = null
    private var rightAnswerCount = 0
    private var quizCount=1
    private val total_questions=5


    private val sportsQues= mutableListOf(
        mutableListOf("Who among the following cricketers was the first to score a century for the Indian Test cricket team in his Debut Test match ?","Lala Amarnath", "Kapil Dev", "Sunil Gawaskar", "Nawab Pataudi"),
        mutableListOf("Where were the first Asian Games held?","New delhi", "Jakarta", "Kathmandu", "Islamabad"),
        mutableListOf("Which cricketer has the record of highest individual score in ODIs?","Rohit Sharma", "Martin Guptill", "Chris Gayle", "Virender Sehwag"),
        mutableListOf("Which is the first European Nation in history to win the Thomas Cup?","Germany", "England", "Denmark", "France"),
        mutableListOf("When was the Olympic flag first hoisted?","1914","1926","1920","1928")
        )





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        binding= ActivitySportsQuesDiffBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)

        //getMyData();


        //shuffling the questions
        sportsQues.shuffle()

        showNextQues()

    }

    fun showNextQues()
    {
        binding.questionNumber.text=getString(R.string.questionNumber, quizCount)
        val quiz = sportsQues[0]

        //displaying the question
        binding.question.text=quiz[0]
        rightAnswer= quiz[1]

        quiz.removeAt(0)

        //shuffling the choices
        quiz.shuffle()

        //removing this ques from quiz data
        sportsQues.removeAt(0)


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
            val intent= Intent(this@SportsQuesDiff,ResultActivity::class.java)
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
