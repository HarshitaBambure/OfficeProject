package com.example.officeproject.helpers

import android.content.Context
import android.content.SharedPreferences
import android.widget.Toast


fun Context.showToast(msg: String){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

//this method is for save preferances
fun Context.savePreferances(key: String, value: String) {
    val sharedPref = this.getSharedPreferences(Constant.PREF_PROJECT_UP, Context.MODE_PRIVATE)
    val editor = sharedPref.edit()
    editor.putString(key, value)
    editor.apply()
}

//this method is for get preferances
fun Context.getPreferances(key: String): String? {
    val sharedPref = this.getSharedPreferences(Constant.PREF_PROJECT_UP, Context.MODE_PRIVATE)
    return sharedPref.getString(key, "")
}
fun Context.clearPref(){

    val preferences: SharedPreferences = getSharedPreferences("loginPrefs", Context.MODE_PRIVATE)
    val editor = preferences.edit()
    editor.clear()
    editor.apply()
}