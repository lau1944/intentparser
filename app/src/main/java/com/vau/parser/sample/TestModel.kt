package com.vau.parser.sample

data class TestModel(
    val text: String,
    val isSuccess: Boolean,
    val testNum: Int,
    val textModelSec: SecTestModel,
){
    override fun toString(): String {
        return "text: $text, isSuccess: $isSuccess, number: $testNum, testModelSec: $textModelSec"
    }
}
