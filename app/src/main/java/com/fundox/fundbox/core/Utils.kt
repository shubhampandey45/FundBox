package com.fundox.fundbox.core

import android.util.Log
import com.fundox.fundbox.core.Constants.TAG

class Utils {
    companion object {
        fun print(e: Exception) = Log.e(TAG, e.stackTraceToString())
    }
}