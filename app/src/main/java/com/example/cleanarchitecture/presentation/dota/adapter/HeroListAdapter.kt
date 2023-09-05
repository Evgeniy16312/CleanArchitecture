package com.example.cleanarchitecture.presentation.dota.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.cleanarchitecture.R
import com.example.cleanarchitecture.databinding.HeroListRvItemBinding
import com.example.cleanarchitecture.util.getProWinRateTextColor
import com.example.cleanarchitecture.util.loadImage
import com.example.cleanarchitecture.util.loadImageFromDrawables
import com.example.domain.models.dota.Hero
import com.example.domain.models.dota.HeroAttribute
import com.example.domain.models.dota.calculateProWinRate


class HeroListAdapter(
    private val onItemClickListener: ((Int) -> Unit)
) : ListAdapter<Hero, HeroListAdapter.ViewHolder>(DiffCall()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = HeroListRvItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(
            binding = binding,
            onItemClickListener = onItemClickListener
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
        holder.setItemClick(item.id)
    }

    inner class ViewHolder(
        private val binding: HeroListRvItemBinding,
        private val onItemClickListener: ((Int) -> Unit)
    ) : RecyclerView.ViewHolder(binding.root) {

        fun setItemClick(heroId: Int) {
            binding.root.setOnClickListener {
                this.onItemClickListener(heroId)
            }
        }

        fun bind(hero: Hero) {
            binding.apply {
                tvHeroName.text = hero.localizedName
                tvHeroAttribute.text = hero.primaryAttribute.uiValue

                val proWinRate = hero.calculateProWinRate()
                tvHeroPercentage.text = proWinRate
                tvHeroPercentage.setTextColor(getProWinRateTextColor(proWinRate))

                ivHeroImage.loadImage(imgUrl = hero.img)

                ivHeroAttribute.loadImageFromDrawables(
                    id = hero.getHeroAttributeImage(),
                )

            }
        }
    }

    fun Hero.getHeroAttributeImage(): Int {
        return when (primaryAttribute) {
            HeroAttribute.Agility -> R.drawable.ic_agility
            HeroAttribute.Intelligence -> R.drawable.ic_intelligence
            HeroAttribute.Strength -> R.drawable.ic_strength
            HeroAttribute.Unknown -> R.drawable.ic_agility
        }
    }

    // Diff Callback
    class DiffCall : DiffUtil.ItemCallback<Hero>() {
        override fun areItemsTheSame(oldItem: Hero, newItem: Hero): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Hero, newItem: Hero): Boolean {
            return oldItem == newItem
        }
    }
}





























