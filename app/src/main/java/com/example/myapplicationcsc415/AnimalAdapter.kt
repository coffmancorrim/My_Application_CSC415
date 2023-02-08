package com.example.myapplicationcsc415

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView


class AnimalAdapter(private val animals: List<Animal>) :
    RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.animal_card_view, parent, false)

        return AnimalViewHolder(view)
    }

    override fun getItemCount() = animals.size

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        val animal = animals[position]
        holder.animalImage.setImageResource(animal.image)
        holder.animalSpecies.text = animal.species
        holder.animalType.text = animal.type
        holder.animalFact.text = "Animal Fact: " + animal.fact
        holder.animalWeight.text = "Weight: " + animal.weight.toString() + " pounds"
        holder.animalSize.text = "Size: " + animal.size.toString() + " feet"

        if (animal.type == "bird")
            holder.animalType.setBackgroundColor(
                ContextCompat.getColor(
                    holder.animalType.context,
                    R.color.animal_red
                )
            )
        else if (animal.type == "fish")
            holder.animalType.setBackgroundColor(
                ContextCompat.getColor(
                    holder.animalType.context,
                    R.color.animal_blue
                )
            )
        else
            holder.animalType.setBackgroundColor(
                ContextCompat.getColor(
                    holder.animalType.context,
                    R.color.animal_green
                )
            )
    }

    class AnimalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val animalImage: ImageView = itemView.findViewById(R.id.animal_image)
        val animalSpecies: TextView = itemView.findViewById(R.id.animal_species)
        val animalType: TextView = itemView.findViewById(R.id.animal_type)
        val animalFact: TextView = itemView.findViewById(R.id.animal_fact)
        val animalWeight: TextView = itemView.findViewById(R.id.animal_weight)
        val animalSize: TextView = itemView.findViewById(R.id.animal_size)
    }
}