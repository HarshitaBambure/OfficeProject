package com.example.officeproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.officeproject.api.request.LoginRequest
import com.example.officeproject.api.request.PatchUserRequest
import com.example.officeproject.databinding.ActivityMainBinding
import com.example.officeproject.helpers.*
import com.example.officeproject.viewmodels.LoginViewModel
import com.example.officeproject.viewmodels.ViewModelFactory

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Aoto login code
        var token = getPreferances(Constant.LOGIN_TOKEN)
        if (!token.isNullOrEmpty())//check token is in pref
        {
            Constant.token = token;
            //open main activity
        }

        viewModel = ViewModelProvider(
            this,
            ViewModelFactory()
        ).get(LoginViewModel::class.java)

        binding.btnLogin.setOnClickListener {
            checkLogin()
            //  updateDriverDetails()
        }
    }


    fun updateDriverDetails() {
        var request = PatchUserRequest(job = "testeer", name = "ravi")
        lifecycleScope.launchWhenStarted {
            var data = viewModel.patchDriver(request)

        }
    }

    fun checkLogin() {
        var username = binding.edtUsername.text.toString().trim();
        var pwd = binding.edtPwd.text.toString().trim();
        var loginRequest = LoginRequest(pwd, username)
        lifecycleScope.launchWhenStarted {
            binding.prgCircular.visibility = View.VISIBLE
            var loginResponse = viewModel.checkLogin(loginRequest)
            if (loginResponse.token.isNullOrEmpty()) {
                showToast("Username or password is Invalid")
            } else {
                showToast("Sucess...")
                savePreferances(Constant.LOGIN_TOKEN, loginResponse.token) //store token to pref
                Constant.token = loginResponse.token;
                binding.edtUsername.setText(loginResponse.token)
            }
            binding.prgCircular.visibility = View.GONE
        }
    }

    fun logout() {
        clearPref()
        finish()
        // to clear all activity and close app finishAffinity()
    }

    fun getDriverList() {
        lifecycleScope.launchWhenStarted {
            var data = viewModel.getDriverList()

        }
    }
}