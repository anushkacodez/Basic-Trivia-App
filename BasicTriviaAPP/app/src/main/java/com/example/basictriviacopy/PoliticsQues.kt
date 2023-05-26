package com.example.basictriviacopy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import com.example.basictriviacopy.databinding.ActivityPoliticsQuesBinding




class PoliticsQues : AppCompatActivity() {


    private lateinit var binding: ActivityPoliticsQuesBinding
    private var rightAnswer: String? = null
    private var rightAnswerCount = 0
    private var quizCount=1
    private val total_questions=5


    private val politicsQues= mutableListOf(
        mutableListOf("The members of the Rajya Sabha are elected by","elected members of the legislative assembly", "elected members of the legislative council", "the people", "Lok Sabha"),
        mutableListOf("Full form of EVM","Electron Voting Machine", "Electron Validation Machine", "Electronic Validation Machine", "Early Voting Machine"),
        mutableListOf("In the ancient period direct democracy existed in:","Greece", "India", "Britain", "China"),
        mutableListOf("The pre-requisite for the enforcement of directive principles of the state policy is","adequate resources", "active opposition", "socialist govt", "an effective, hones government"),
        mutableListOf("The position of a chief minister is","similar to that of the prime minister","identical to that of the president","a combination of the position of the prime minister and president","not constitutional")
        )





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        binding= ActivityPoliticsQuesBinding.inflate(layoutInflater)
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
            val intent= Intent(this@PoliticsQues,ResultActivity::class.java)
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
