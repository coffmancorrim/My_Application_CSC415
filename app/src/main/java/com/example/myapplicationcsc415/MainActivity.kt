package com.example.myapplicationcsc415

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    var index = -1
    var speciesList = listOf<String>(
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
    var typeList = listOf<String>(
        "mammal",
        "bird",
        "fish"
    )
    var factList = listOf<Int>(
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
    var imageList = listOf<Int>(
        R.mipmap.dolphin,
        R.mipmap.shrimp,
        R.mipmap.snail,
        R.mipmap.octo,
        R.mipmap.polar_bear,
        R.mipmap.monkey,
        R.mipmap.koala,
        R.mipmap.bird,
        R.mipmap.bear,
        R.mipmap.lizard
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.animal_recycler_view)

        recyclerView.layoutManager = LinearLayoutManager(this)

        val animals = mutableListOf<Animal>()

        for (i in 0..9) {
            animals.add(createAnimals())
        }

        val adapter = AnimalAdapter(animals)
        recyclerView.adapter = adapter

    }

    private fun createAnimals(): Animal {
        index++
        return Animal(
            species = speciesList[index],
            type = typeList[Random.nextInt(0, 3)],
            fact = getString(factList[index]),
            image = imageList[index],
            size = Random.nextInt(1, 15),
            weight = Random.nextInt(10, 300),
            endangered = listOf()
        )
    }
}