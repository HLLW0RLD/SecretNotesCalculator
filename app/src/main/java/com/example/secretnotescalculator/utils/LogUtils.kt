package com.example.secretnotescalculator.utils

import android.util.Log
import com.google.gson.GsonBuilder

object LogUtils {
    const val TEST_TAG = "TESTOVIY"
    // wight text color
    fun logD(msg: Any, tag: String? = null) {
        Log.d(
            tag ?: setTag(),
            "$START_LOG DEBUG ${getClassWithMethod()} \n\t $RESULT_LOG ${
                createMsg(msg)
            } \n$END_LOG DEBUG ${getClassWithMethod()}\n$BORDER"
        )
    }

    // yellow text color
    fun logTest(msg: Any, tag: String? = null) {
        Log.i(
            tag ?: setTag(),
            "$START_LOG TEST ${getClassWithMethod()} \n\t TEST $RESULT_LOG: ${
                createMsg(msg)
            } \n$END_LOG TEST ${getClassWithMethod()}\n$BORDER"
        )
    }

    // red text color
    fun logE(msg: Any, tag: String? = null) {
        Log.e(
            tag ?: setTag(),
            "$START_LOG EXCEPTION ${getClassWithMethod()} \n\t $RESULT_LOG: ${
                createMsg(msg)
            } \n$END_LOG EXCEPTION ${getClassWithMethod()}\n$BORDER"
        )
    }

    private fun createMsg(msg: Any): String {
        return if (msg::class.toString().contains("String")){
            setPOJOtoMsg(msg.toString())
        } else {
            setPOJOtoMsg(msg)
        }
    }

    private fun setPOJOtoMsg(msg: Any): String {
        return try {
            val gsonPretty = GsonBuilder().setPrettyPrinting().create()
            gsonPretty.toJson(msg)
        } catch (e: Exception) {
            "object: $msg \nobject type: ${ msg::class } \nerror: $e"
        }
    }

    private fun setTag(): String {
        val re = Regex("[^A-Za-z ]")
        val stack = Throwable().fillInStackTrace()
        val trace = stack.stackTrace
        val fileName = trace[3].fileName.replace(".kt", "")
        var methodName = trace[3].className
            .replace("$", " ")
            .replaceBefore(" ", "")
            .replace(" ", "")
        methodName = re.replace(methodName, "")
        return "$fileName.$methodName"
    }

    private fun getClassWithMethod(): String {
        val re = Regex("[^A-Za-z ]")
        val stack = Throwable().fillInStackTrace()
        val trace = stack.stackTrace
        val fileName = trace[2].fileName.replace(".kt", "")
        var methodName = trace[2].className
            .replace("$", " ")
            .replaceBefore(" ", "")
            .replace(" ", "")
        methodName = re.replace(methodName, "")
        return "$fileName.$methodName() (line: ${trace[2].lineNumber})"
    }

    private const val START_LOG = "<-- START"
    private const val RESULT_LOG = "RESULT:"
    private const val END_LOG = "--> END"
    private const val b1 = "\n:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n"
    private const val b2 = "\n=============================================================================================================================================================\n"
    private const val b3 = "\n*************************************************************************************************************************************************************\n"
    private const val b4 = "\n#############################################################################################################################################################\n"
    private const val BORDER = b3
}