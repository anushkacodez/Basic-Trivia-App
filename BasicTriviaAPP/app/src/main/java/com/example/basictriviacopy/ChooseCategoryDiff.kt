package com.example.basictriviacopy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.basictriviacopy.databinding.ActivityChooseCategoryDiffBinding

class ChooseCategoryDiff : AppCompatActivity() {
    private lateinit var binding: ActivityChooseCategoryDiffBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_choose_category)


        binding= ActivityChooseCategoryDiffBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)

        binding.sportsBtn.setOnClickListener {
            val intent = Intent(this@ChooseCategoryDiff, SportsQuesDiff::class.java)
            startActivity(intent)
        }

        binding.politicsBtn.setOnClickListener {
            val intent = Intent(this@ChooseCategoryDiff, PoliticsQuesDiff::class.java)
            startActivity(intent)
        }

        binding.EntBtn.setOnClickListener {
            val intent = Intent(this@ChooseCategoryDiff, EntQuesDiff::class.java)
            startActivity(intent)
        }
    }
}