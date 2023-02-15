package com.example.MyApplicationCSC415

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.fragment.app.commit
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.MyApplicationCSC415.ui.AnimalDetailFragment


class AnimalAdapter(private val animals: List<Animal>) :
    RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.animal_card_view, parent, false)
        return AnimalViewHolder(view) { position ->
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

            val activity = view.context as AppCompatActivity

            activity.supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace(R.id.fragment_container_view, detailFragment)
                addToBackStack(null)
            }
        }
    }


    override fun getItemCount() = animals.size

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        val animal = animals[position]

        Glide
            .with(holder.itemView.context)
            .load(animal.image)
            .into(holder.animalImage)

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

    inner class AnimalViewHolder(
        itemView: View,
        private val onItemClick: (adapterPosition: Int) -> Unit
    ) : RecyclerView.ViewHolder(itemView) {
        val animalImage: ImageView = itemView.findViewById(R.id.animal_image)
        val animalSpecies: TextView = itemView.findViewById(R.id.animal_species)
        val animalType: TextView = itemView.findViewById(R.id.animal_type)
        val animalFact: TextView = itemView.findViewById(R.id.animal_fact)
        val animalWeight: TextView = itemView.findViewById(R.id.animal_weight)
        val animalSize: TextView = itemView.findViewById(R.id.animal_size)

        init {
            itemView.setOnClickListener {
                onItemClick(adapterPosition)
            }
        }
    }
}