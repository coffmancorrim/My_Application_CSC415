package com.example.myapplicationcsc415.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplicationcsc415.R
import com.example.myapplicationcsc415.databinding.FragmentAnimalListBinding
import com.example.myapplicationcsc415.model.Animal
import com.example.myapplicationcsc415.ui.adapter.AnimalAdapter

import dagger.hilt.android.AndroidEntryPoint
import kotlin.random.Random

@AndroidEntryPoint
class AnimalListFragment : Fragment() {

    private var _binding: FragmentAnimalListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAnimalListBinding.inflate(inflater, container, false)

        binding.animalRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        val animals = mutableListOf<Animal>()

        val speciesList = listOf<String>(
            "Dolphin",
            "Pistol Shrimp",
            "Garden Snail",
            "Giant Pacific Octopus",
            "Polar Bear",
            "Japanese Macaques",
            "Koala",
            "Shoebill Stork",
            "Syrian Brown Bear",
            "Horned Lizard"
        )
        val typeList = listOf<String>(
            "mammal",
            "bird",
            "fish"
        )
        val factList = listOf<Int>(
            R.string.dolphin_fact,
            R.string.pistol_shrimp_Fact,
            R.string.garden_snail_fact,
            R.string.giant_pacific_octopus_fact,
            R.string.polar_bear_fact,
            R.string.japanese_macaques_fact,
            R.string.koala_fact,
            R.string.shoebill_stork_fact,
            R.string.syrian_brown_bear,
            R.string.horned_lizard_fact
        )

        val habitatList = listOf<String>(
            "grassy plains",
            "icy tundra",
            "humid jungle",
            "scorching desert",
            "tropical beach"
        )

        val eatingTypeList = listOf<String>(
            "carnivore",
            "herbivore",
            "omnivore"
        )

        val featuresList = listOf<String>(
            "four legs",
            "fur",
            "claws",
            "tail",
            "fins",
            "beak",
            "whiskers",
            "night vision",
            "opposable thumbs",
            "cold blooded",
            "skin",
            "poisonous",
            "warm blooded",
            "long neck",
            "big ears",
            "scaly skin",
            "breaths water"
        )

        val imageList = listOf<String>(
            "https://drive.google.com/uc?id=1UxA0ybSATM9pqcp8JZH8ZokWCX5v_l_h",
            "https://drive.google.com/uc?id=1QzXENpHjKVk6NiU37IhNIb6MZ076sTL_",
            "https://drive.google.com/uc?id=18NRWIh-VtHzzH2hmYjAFOyHmKR8HhiqS",
            "https://drive.google.com/uc?id=1dkaa2YiDhEA5wDLdrURofH6_MsLAP-7O",
            "https://drive.google.com/uc?id=10qm2mnPR0TgbMwNvHWcumobvZbt9dKV5",
            "https://drive.google.com/uc?id=1H0UbuCW3ZNpKCRZyc_XxXO8wKI5CPF2F",
            "https://drive.google.com/uc?id=1o9JWVpxzwI6BMy9vvNJJKxF0Jmm3CYb0",
            "https://drive.google.com/uc?id=1yAp9eUFXm1S2wlb0ZcK6MWMHsh6cBOlj",
            "https://drive.google.com/uc?id=1dBGsOwV_NBsv0wUL65djx-QX-q5UadcZ",
            "https://drive.google.com/uc?id=1GPDmlyJa9ugFe063dyBXKi1LlVRMj1VU"
        )


        for (i in 0..30) {
            animals.add(
                createAnimal(
                    speciesList.random(),
                    typeList.random(),
                    getString(factList.random()),
                    imageList.random(),
                    Random.nextInt(0, 15),
                    Random.nextInt(0, 455),
                    habitatList.random(),
                    eatingTypeList.random(),
                    Random.nextInt(1, 999),
                    mutableListOf(
                        featuresList.random(),
                        featuresList.random(),
                        featuresList.random(),
                        featuresList.random()
                    )
                )
            )
        }

        val adapter = AnimalAdapter(animals) {position ->
            val animal = animals[position]

            val bundle = bundleOf(
                "species" to animal.species,
                "type" to animal.type,
                "fact" to animal.fact,
                "image" to animal.image,
                "weight" to animal.weight,
                "size" to animal.size,
                "habitat" to animal.habitat,
                "eatingType" to animal.eatingType,
                "lifeSpan" to animal.lifeSpan,
                "features" to animal.features
            )

            val detailFragment = AnimalDetailFragment()
            detailFragment.arguments = bundle

            requireActivity().supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace(R.id.fragment_container_view, detailFragment)
                addToBackStack(null)
            }
        }
        binding.animalRecyclerView.adapter = adapter

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun createAnimal(
        species: String,
        type: String,
        fact: String,
        image: String,
        size: Int,
        weight: Int,
        habitat: String,
        eatingType: String,
        lifeSpan: Int,
        features: MutableList<String>

    ) = Animal(
        species = species,
        type = type,
        fact = fact,
        image = image,
        size = size,
        weight = weight,
        habitat = habitat,
        eatingType = eatingType,
        lifeSpan = lifeSpan,
        features = features
    )
}

