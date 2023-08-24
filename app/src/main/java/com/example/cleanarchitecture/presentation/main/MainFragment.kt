package com.example.cleanarchitecture.presentation.main

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import com.example.cleanarchitecture.app.App
import com.example.cleanarchitecture.databinding.FragmentMainBinding
import com.example.cleanarchitecture.navigation_utils.MainNavigationManager
import com.example.cleanarchitecture.navigation_utils.NavigationViewModel
import javax.inject.Inject

class MainFragment : Fragment() {
    @Inject
    lateinit var vmFactory: MainViewModelFactory
    private val vm: MainViewModel by lazy {
         ViewModelProvider(
            this,
            vmFactory
        )[MainViewModel::class.java]
    }
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private val navigationViewModel: NavigationViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentMainBinding
            .inflate(inflater, container, false)

        (requireActivity().applicationContext as App).appComponent.inject(this)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.e("AAA", "MainActivity created")

        vm.stateLive.observe(requireActivity()) { state ->
            binding.textView.text = "${state.firstName} ${state.lastName} ${state.saveResult}"
        }

        binding.buttonSave.setOnClickListener {
            val text = binding.editTv.text.toString()
            vm.send(SaveEvent(text = text))
        }

        binding.buttonGet.setOnClickListener {
            vm.send(LoadEvent())
        }

        binding.buttonNav.setOnClickListener {
            navigationViewModel.navigateTo(MainNavigationManager.HeroisListFragment)
        }
    }
}