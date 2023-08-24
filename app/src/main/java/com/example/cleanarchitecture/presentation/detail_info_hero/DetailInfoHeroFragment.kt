package com.example.cleanarchitecture.presentation.detail_info_hero

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.cleanarchitecture.databinding.FragmentDetailInfoHeroBinding

class DetailInfoHeroFragment : Fragment() {
    private var _binding: FragmentDetailInfoHeroBinding? = null
    private val binding get() = _binding!!
    private val args: DetailInfoHeroFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentDetailInfoHeroBinding
            .inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        args.heroId
    }
}