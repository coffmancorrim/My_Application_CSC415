package com.example.myapplicationcsc415.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.myapplicationcsc415.R
import com.example.myapplicationcsc415.databinding.FragmentAnimalDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnimalDetailFragment : Fragment() {

    private var _binding: FragmentAnimalDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAnimalDetailBinding.inflate(inflater, container, false)

        if (arguments != null) {
            val species = requireArguments().getString("species")
            val type = requireArguments().getString("type")
            val fact = requireArguments().getString("fact")
            val image = requireArguments().getString("image")
            val weight = requireArguments().getInt("weight")
            val size = requireArguments().getInt("size")
            val habitat = requireArguments().getString("habitat")
            val eatingType = requireArguments().getString("eatingType")
            val lifeSpan = requireArguments().getInt("lifeSpan")
            val features = requireArguments().getStringArrayList("features")

            Glide
                .with(binding.root)
                .load(image)
                .into(binding.animalImage)


            binding.animalSpecies.text = species
            binding.animalType.text = type.toString()
            binding.animalFact.text =
                binding.root.context.getString(R.string.animal_fact_placeholder, fact)
            binding.animalWeight.text =
                binding.root.context.getString(R.string.animal_weight_placeholder, weight)
            binding.animalSize.text =
                binding.root.context.getString(R.string.animal_size_placeholder, size)
            binding.animalHabitat.text =
                binding.root.context.getString(R.string.animal_habitat_placeholder, habitat)
            binding.animalEatingType.text =
                binding.root.context.getString(R.string.animal_eating_type_placeholder, eatingType)
            binding.animalLifespan.text =
                binding.root.context.getString(R.string.animal_lifespan_placeholder, lifeSpan)
            binding.animalEndangered.text = binding.root.context.getString(
                R.string.animal_features_placeholder,
                features?.get(0) ?: "none",
                features?.get(1) ?: "none",
                features?.get(2) ?: "none",
                features?.get(3) ?: "none"
            )

            val constraintLayout = binding.bubble

            if (type == "bird")
                constraintLayout.setBackgroundColor(
                    ContextCompat.getColor(
                        constraintLayout.context,
                        R.color.animal_yellow
                    )
                )
            else if (type == "fish")
                constraintLayout.setBackgroundColor(
                    ContextCompat.getColor(
                        constraintLayout.context,
                        R.color.animal_blue
                    )
                )
            else
                constraintLayout.setBackgroundColor(
                    ContextCompat.getColor(
                        constraintLayout.context,
                        R.color.animal_green
                    )
                )
        }

        return binding.root
    }
}
