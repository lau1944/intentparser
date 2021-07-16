package com.vau.intentparser

import android.content.Intent

fun Intent.putObject(obj: Any) {
    this.putExtra("object", IntentParserImpl.parse(obj))
}

fun Intent.getObject(objClass: Class<out Any>) : Any? {
    val extras = this.extras

    if (extras != null) {
        return IntentParserImpl.resolve(objClass, extras)
    }

    return null
}