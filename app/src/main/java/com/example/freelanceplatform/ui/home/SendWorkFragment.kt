package com.example.freelanceplatform.ui.home

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.freelanceplatform.R

class SendWorkFragment : Fragment() {

    companion object {
        fun newInstance() = SendWorkFragment()
    }

    private lateinit var viewModel: SendWorkViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.send_work_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(SendWorkViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
