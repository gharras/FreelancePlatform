package com.example.freelanceplatform.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.constraintlayout.widget.Constraints
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.freelanceplatform.MainActivity
import com.example.freelanceplatform.R
import com.example.freelanceplatform.databinding.LogInFragmentBinding
import com.google.firebase.auth.FirebaseAuth

class LogInActivity : AppCompatActivity(), AuthListener {
    private lateinit var binding: LogInFragmentBinding
    private lateinit var email: String
    private lateinit var pass: String
    private lateinit var auth: FirebaseAuth
    private lateinit var viewModel: AuthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.log_in_fragment)
        viewModel = ViewModelProviders.of(this).get(AuthViewModel::class.java)
        binding.viewmodel = viewModel
        viewModel.authListener=this
        auth = FirebaseAuth.getInstance()

    }

    override fun onStarted() {
        binding.progressbar.visibility= View.VISIBLE
    }

    override fun onSuccess() {
        binding.progressbar.visibility= View.GONE
        startActivity(
            Intent(
                this,
                MainActivity::class.java
            )
        )    }

    override fun onFailure(message: String) {
        binding.progressbar.visibility= View.VISIBLE
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }

}
