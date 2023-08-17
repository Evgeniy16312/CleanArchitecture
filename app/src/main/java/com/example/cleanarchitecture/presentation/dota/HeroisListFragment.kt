package com.example.cleanarchitecture.presentation.dota

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cleanarchitecture.app.App
import com.example.cleanarchitecture.databinding.FragmentHeroisListBinding

class HeroisListFragment : Fragment() {
    private var _binding: FragmentHeroisListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentHeroisListBinding
            .inflate(inflater, container, false)

        (requireActivity().applicationContext as App).appComponent.inject(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}