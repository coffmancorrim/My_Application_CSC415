package com.example.MyApplicationCSC415.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.MyApplicationCSC415.MainActivity
import com.example.MyApplicationCSC415.R


class AnimalDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_animal_detail, container, false)

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


            view.findViewById<TextView>(R.id.animal_species).text = species
            view.findViewById<TextView>(R.id.animal_type).text = type.toString()
            view.findViewById<TextView>(R.id.animal_fact).text = "Animal Fact: " + fact
            Glide
                .with(view.context)
                .load(image)
                .into(view.findViewById(R.id.animal_image))
            view.findViewById<TextView>(R.id.animal_weight).text = "Weight: " + weight.toString()
            view.findViewById<TextView>(R.id.animal_size).text = "Size: " + size.toString()
            view.findViewById<TextView>(R.id.animal_habitat).text = "Habitat: " + habitat

            view.findViewById<TextView>(R.id.animal_eating_type).text = "Eating Type: " + eatingType
            view.findViewById<TextView>(R.id.animal_lifespan).text =
                "Lifespan: " + lifeSpan.toString()
            view.findViewById<TextView>(R.id.animal_endangered).text = "Features: " + features

            var constraintLayout = view.findViewById<ViewGroup>(R.id.bubble)

            if (type == "bird")
                constraintLayout.setBackgroundColor(
                    ContextCompat.getColor(
                        constraintLayout.context,
                        R.color.animal_red
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

        return view
    }
}
