package com.example.mynotesmvvm.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.mynotesmvvm.Fragments.HomeFragmentDirections
import com.example.mynotesmvvm.Model.Notes
import com.example.mynotesmvvm.R
import com.example.mynotesmvvm.databinding.ItemNotesBinding

class NotesAdapter(private val requireContext: Context, var notesList: List<Notes>) :
    RecyclerView.Adapter<NotesAdapter.NotesViewHolder>() {

        fun filtering(newFilteredList: ArrayList<Notes>) {
            notesList = newFilteredList
            notifyDataSetChanged()
        }

    inner class NotesViewHolder(private var binding: ItemNotesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {
                notesTitle.text = notesList[position].title
                notes.text = notesList[position].notes
                date.text = notesList[position].date
                when(notesList[position].priority){
                    "1" ->{viewPriority.setBackgroundResource(R.drawable.green_circle)}
                    "2" ->{viewPriority.setBackgroundResource(R.drawable.yellow_circle)}
                    "3" ->{viewPriority.setBackgroundResource(R.drawable.red_circle)}
                }

                root.setOnClickListener{
                    val action = HomeFragmentDirections.actionHomeFragmentToEditNotesFragment(notesList[position])
                    Navigation.findNavController(it).navigate(action)
                }

            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        return NotesViewHolder(
            ItemNotesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return notesList.size
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        holder.bind(position)
    }

}