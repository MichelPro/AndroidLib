package com.michel.intrastructure.utils

import android.util.Log

/**
 * 工具类
 * Created by Michel on 2017/4/7.
 */
val TAG: String = "michel"

val isDebug: Boolean = true

fun LogI(msg: String) {
    if (isDebug) {
        Log.i(TAG, msg)
    }
}

fun LogD(msg: String) {
    if (isDebug) {
        Log.d(TAG, msg)
    }
}

fun LogW(msg: String) {
    if (isDebug) {
        Log.w(TAG, msg)
    }
}

fun LogE(msg: String) {
    if (isDebug) {
        Log.e(TAG, msg)
    }
}

fun LogI(tag: String, msg: String) {
    if (isDebug) {
        Log.i(tag, msg)
    }
}

fun LogD(tag: String, msg: String) {
    if (isDebug) {
        Log.d(tag, msg)
    }
}

fun LogW(tag: String, msg: String) {
    if (isDebug) {
        Log.w(tag, msg)
    }
}

fun LogE(tag: String, msg: String) {
    if (isDebug) {
        Log.e(tag, msg)
    }
}


