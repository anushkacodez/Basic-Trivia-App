package com.example.basictriviacopy

import ApiInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import com.example.basictriviacopy.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL="https://opentdb.com/"


class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    private var rightAnswer: String? = null
    private var rightAnswerCount = 0
    private var quizCount=1
    private val total_questions=4


    private val quizData= mutableListOf(
        mutableListOf("Who is known as the 'father of Indian Cinema","DadasahebPhalke", "Satyajit Ray", "DadaSaheb Torne", "V. Shantaram"),
        mutableListOf("Which was the first Indian movie nominated for Oscar?","Mother India", "Lagaan", "Salaam Bombay", "None of these"),
        mutableListOf("Which is the highest grossing Indian film ever?","Dangal", "Bajrangi Bhaijaan", "PK", "Bahubali"),
        mutableListOf("Which director has directed the most movies in India?","Rajkumar Hirani", "Rohit Shetty", "Aditya Chopra", "Javed Akhtar"),
        mutableListOf("Who was the director of the famous movie ‘Sholay’?","Ramesh Sippy", "Shakti Samanta", "Mehboob Khan", "None of these")

        )










    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        binding=ActivityMainBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)

        //getMyData();


        //shuffling the questions
        quizData.shuffle()

        showNextQues()

    }

    fun showNextQues()
    {
        binding.questionNumber.text=getString(R.string.questionNumber, quizCount)
        val quiz = quizData[0]

        //displaying the question
        binding.question.text=quiz[0]
        rightAnswer= quiz[1]

        quiz.removeAt(0)

        //shuffling the choices
        quiz.shuffle()

        //removing this ques from quiz data
        quizData.removeAt(0)


        //displaying corresponding choices
        binding.option1.text=quiz[0]
        binding.option2.text=quiz[1]
        binding.option3.text=quiz[2]
        binding.option4.text=quiz[3]



    }
    /*
    private fun getMyData(){
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(ApiInterface::class.java)
        val retrofitData = retrofitBuilder.getData(9, 10, "easy", "multiple")
        retrofitData.enqueue(object : Callback<MyData?> {
            override fun onResponse(call: Call<MyData?>, response: Response<MyData?>) {
                val responseBody = response.body()!!
                val dataBody = responseBody.results
                Log.i("Question_data", "${responseBody.results}")
                for (data in dataBody){ quizData.add(data)
                }
                showNextQues()
            }

            override fun onFailure(call: Call<MyData?>, t: Throwable) {
                Log.d("Question_data", "${t.message}")
            }
        })}*/


        fun checkCorrectAns()
        {
            if(quizCount==total_questions)
            {
                val intent= Intent(this@MainActivity,ResultActivity::class.java)
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
