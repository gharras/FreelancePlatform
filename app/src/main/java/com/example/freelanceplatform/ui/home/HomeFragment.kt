package com.example.freelanceplatform.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.freelanceplatform.R
import com.example.freelanceplatform.adapter.ActiveProjectsAdapter
import com.example.freelanceplatform.databinding.FragmentHomeBinding
import com.example.freelanceplatform.model.ActiveProjects

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var binding: FragmentHomeBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

//        val textView: TextView = root.findViewById(R.id.text_home)
//        homeViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
        binding.viewAllButton.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_home_to_activeProjetsDetailsFragment)
        }
        homeViewModel.getActiveProjects()
        homeViewModel.activeProjectsList.observe(viewLifecycleOwner, Observer {
            binding.activeProjectsList.adapter =
                ActiveProjectsAdapter(it as ArrayList<ActiveProjects>)

        })
        return binding.root
    }
}
