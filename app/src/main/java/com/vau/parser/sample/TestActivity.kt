package com.vau.parser.sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.vau.intentparser.getObject

class TestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        val testModel = intent.getObject(TestModel::class.java)
        println("model get : $testModel")
    }
}