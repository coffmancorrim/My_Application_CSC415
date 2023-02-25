package com.example.myapplicationcsc415.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplicationcsc415.R
import com.example.myapplicationcsc415.databinding.AnimalCardViewBinding
import com.example.myapplicationcsc415.model.Animal


class AnimalAdapter(
    private val animals: List<Animal>,
    private val onItemClick: (adapterPosition: Int) -> Unit
) :
    RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = AnimalCardViewBinding.inflate(layoutInflater, parent, false)

        return AnimalViewHolder(binding) { position ->
            onItemClick(position)
        }
    }

    override fun getItemCount() = animals.size

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        val animal = animals[position]
        holder.bind(animal)
    }
    inner class AnimalViewHolder(
        private val binding: AnimalCardViewBinding,
        private val onItemClick: (adapterPosition: Int) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                onItemClick(adapterPosition)
            }
        }

        fun bind(animal: Animal){
            Glide
                .with(binding.root)
                .load(animal.image)
                .into(binding.animalImage)

            binding.animalSpecies.text = animal.species
            binding.animalType.text = animal.type
            binding.animalFact.text = binding.root.context.getString(R.string.animal_fact_placeholder, animal.fact)
            binding.animalWeight.text = binding.root.context.getString(R.string.animal_weight_placeholder, animal.weight)
            binding.animalSize.text = binding.root.context.getString(R.string.animal_size_placeholder, animal.size)

            if (animal.type == "bird")
                binding.animalType.setBackgroundColor(
                    ContextCompat.getColor(
                        binding.animalType.context,
                        R.color.animal_yellow
                    )
                )
            else if (animal.type == "fish")
                binding.animalType.setBackgroundColor(
                    ContextCompat.getColor(
                        binding.animalType.context,
                        R.color.animal_blue
                    )
                )
            else
                binding.animalType.setBackgroundColor(
                    ContextCompat.getColor(
                        binding.animalType.context,
                        R.color.animal_green
                    )
                )

        }
    }
}