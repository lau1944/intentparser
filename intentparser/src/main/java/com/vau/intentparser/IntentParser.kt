package com.vau.intentparser

import android.os.Bundle
import com.google.gson.Gson

interface IntentParser {
    /**
     * only primitive type is allowed to add in list
     */
    fun parse(obj: Any?, gson: Gson): String

    fun resolve(objClass: Class<out Any?>, bundle: Bundle, gson: Gson): Any
}