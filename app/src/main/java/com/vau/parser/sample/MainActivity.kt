package com.vau.parser.sample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.vau.intentparser.putObject

class MainActivity : AppCompatActivity() {
    private lateinit var toNext: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val testModel = TestModel(
                text = "hello world",
                isSuccess = false,
                testNum = 1,
                textModelSec = SecTestModel("second model")
        )

        toNext = findViewById(R.id.to_next)
        toNext.setOnClickListener {
            startActivity(
                    Intent(this, TestActivity::class.java).apply {
                        this.putObject(testModel)
                    }
            )
        }
    }
}