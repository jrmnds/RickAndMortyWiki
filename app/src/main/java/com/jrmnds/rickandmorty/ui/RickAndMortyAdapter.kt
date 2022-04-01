package com.jrmnds.rickandmorty.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jrmnds.rickandmorty.R
import com.jrmnds.rickandmorty.databinding.CharacterCardBinding
import com.jrmnds.rickandmorty.domain.model.Character
import org.w3c.dom.Text


class RickAndMortyAdapter(private val characters: List<Character>) : RecyclerView.Adapter<RickAndMortyAdapter.ViewHolder>(){

    class ViewHolder(val binding: CharacterCardBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(CharacterCardBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val character = characters[position]

        holder.binding.characterNameId.text = character.name
        holder.binding.characterStatusId.text = character.status
        holder.binding.characterSpeciesId.text = character.species
    }

    override fun getItemCount(): Int {
        return characters.size
    }

}