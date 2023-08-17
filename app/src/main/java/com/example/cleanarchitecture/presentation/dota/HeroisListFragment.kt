package com.example.cleanarchitecture.presentation.dota

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.cleanarchitecture.app.App
import com.example.cleanarchitecture.databinding.FragmentHeroisListBinding
import com.example.cleanarchitecture.presentation.dota.adapter.HeroListAdapter
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.launch
import javax.inject.Inject


class HeroisListFragment : Fragment() {
    @Inject
    lateinit var vmFactory: DotaViewModelFactory
    private var _binding: FragmentHeroisListBinding? = null
    private val binding get() = _binding!!
    private lateinit var heroListAdapter: HeroListAdapter

    private val vm: HeroListViewModel by lazy {
        ViewModelProvider(
            this,
            vmFactory
        )[HeroListViewModel::class.java]
    }

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

        initRecyclerView()
        collectUIState()
        collectUIEvents()
    }

    private fun collectUIState() = lifecycleScope.launch {
        viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {

            vm.uiState.collect { state ->
                binding.apply {
                    pbLoading.isVisible = state.isLoading
                    if (!state.isLoading) {
                        heroListAdapter.submitList(state.heroes)
                    }
                }
            }

        }
    }

    private fun collectUIEvents() = lifecycleScope.launch {
        viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {

            vm.events.collect { event ->
                when (event) {
                    is HeroListEvent.ShowToast -> {
                        Snackbar.make(
                            binding.root,
                            event.message,
                            Snackbar.LENGTH_SHORT
                        ).show()
                    }

                    is HeroListEvent.NavigateToHeroDetailsScreen -> {
                        navigateToHeroDetailsScreen(heroId = event.heroId)
                    }
                }
            }
        }
    }

    private fun initRecyclerView() {
        heroListAdapter = HeroListAdapter(
            onItemClickListener = { heroId ->
                vm.onTriggerEvent(HeroListEvent.NavigateToHeroDetailsScreen(heroId = heroId))
            }
        )
//        heroListAdapter.setOnItemClickListener { heroId ->
//            viewModel.onTriggerEvent(HeroListEvent.NavigateToHeroDetailsScreen(heroId = heroId))
//        }
        binding.rvHeroesList.apply {
            adapter = heroListAdapter
            setHasFixedSize(true)
        }
    }

    private fun navigateToHeroDetailsScreen(heroId: Int) {
//        val action = HeroListFragmentDirections.actionHeroListFragmentToHeroDetailsFragment(
//            heroId = heroId
//        )
//        findNavController().navigate(action)
    }
}