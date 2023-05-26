package com.example.basictriviacopy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.basictriviacopy.databinding.ActivityChooseCategoryBinding

class ChooseCategory : AppCompatActivity() {
    private lateinit var binding: ActivityChooseCategoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_choose_category)


        binding= ActivityChooseCategoryBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)

        binding.sportsBtn.setOnClickListener {
            val intent = Intent(this@ChooseCategory, SportsQues::class.java)
            startActivity(intent)
        }

        binding.politicsBtn.setOnClickListener {
            val intent = Intent(this@ChooseCategory, PoliticsQues::class.java)
            startActivity(intent)
        }

        binding.EntBtn.setOnClickListener {
            val intent = Intent(this@ChooseCategory, MainActivity::class.java)
            startActivity(intent)
        }
    }
}