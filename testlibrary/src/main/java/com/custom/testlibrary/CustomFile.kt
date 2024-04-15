package com.custom.testlibrary

import android.util.Log

/**
 * Created by Michael Ruppen on 15.04.2024
 */
class CustomFile(
    val testBool: Boolean
) {

    fun mySuperFun() {
        Log.d("TestLibrary", "Bool was: $testBool")
    }
}