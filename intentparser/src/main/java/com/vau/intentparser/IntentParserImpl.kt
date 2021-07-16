package com.vau.intentparser

import android.os.Bundle
import com.google.gson.Gson

class IntentParserImpl : IntentParser {

    companion object {
        val gson : Gson = Gson()
        fun parse(obj: Any): String {
            return IntentParserImpl().parse(obj, gson)
        }

        fun resolve(objClass: Class<out Any>, args: Bundle): Any {
            return IntentParserImpl().resolve(objClass, args, gson)
        }
    }

    override fun parse(obj: Any?, gson: Gson): String {
        return gson.toJson(obj)
    }

    override fun resolve(objClass: Class<out Any>, bundle: Bundle, gson: Gson): Any {
        val jsonStr = bundle.getString("object")
        return gson.fromJson(jsonStr, objClass)
    }

    /*
    /**
     * because kotlin like String type is a boxed type which is not a primitive type
     * we have to create this method to unbox them
     */
    private fun primitiveType(targetClass: Class<*>) : String? {
        return when (targetClass) {
            Int::class.java     -> "int"
            String::class.java  -> "string"
            Boolean::class.java -> "boolean"
            Short::class.java   -> "short"
            Long::class.java    -> "long"
            Byte::class.java    -> "byte"
            Float::class.java   -> "float"
            else -> null
        }
    }

    private fun deserialize(classname: String, content: String): Any {
        return castToDefaultType(classname, content) ?: deserializeObject(
            classname,
            content
        )
    }

    private fun deserializeObject(targetClassname: String, target: String): Any {
        val entry: List<String> = target.split(",")
        val targetClass: Class<out Any> = Class.forName(targetClassname)
        val args = arrayOfNulls<Any>(targetClass.fields.size)
        for (i: Int in 0..entry.size) {
            val pair = entry[i].split(":")
            args[i] = pair[1]
        }
        return targetClass.getConstructor().newInstance(args)
    }

    private fun castToDefaultType(typeName: String, value: String): Any? {
        when (typeName) {
            "string"  -> return value
            "boolean" -> return value.toBoolean()
            "int"     -> return value.toInt()
            "short"   -> return value.toShort()
            "long"    -> return value.toLong()
            "byte"    -> return value.toByte()
            "float"   -> return value.toFloat()
        }
        return null
    }
    */
}