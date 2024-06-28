package com.example.mynotesmvvm.Fragments

import android.os.Bundle
import android.text.format.DateFormat
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.mynotesmvvm.Model.Notes
import com.example.mynotesmvvm.R
import com.example.mynotesmvvm.ViewModel.NotesViewModel
import com.example.mynotesmvvm.databinding.FragmentCreateNotesBinding
import java.util.Date

class CreateNotesFragment : Fragment() {

    private lateinit var binding: FragmentCreateNotesBinding
    private var priority: String = "1"
    val viewModel: NotesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCreateNotesBinding.inflate(layoutInflater, container, false)
        binding.btnSaveNotes.setOnClickListener {
            createNotes(it)
        }
        binding.pGreen.setImageResource(R.drawable.chceck_two)

        binding.pGreen.setOnClickListener {
            priority = "1"
            binding.pGreen.setImageResource(R.drawable.chceck_two)
            binding.pRed.setImageResource(0)
            binding.pYellow.setImageResource(0)
        }
        binding.pYellow.setOnClickListener {
            priority = "2"
            binding.pYellow.setImageResource(R.drawable.chceck_two)
            binding.pRed.setImageResource(0)
            binding.pGreen.setImageResource(0)
        }
        binding.pRed.setOnClickListener {
            priority = "3"
            binding.pRed.setImageResource(R.drawable.chceck_two)
            binding.pGreen.setImageResource(0)
            binding.pYellow.setImageResource(0)
        }

        binding.backBtn.setOnClickListener {
            Navigation.findNavController(it!!).navigate(R.id.action_createNotesFragment_to_homeFragment)
        }

        return binding.root
    }

    private fun createNotes(it: View?) {
        val title = binding.editTitle.text.toString()
        val notes = binding.etNotes.text.toString()

        val d = Date()
        val notesDate: CharSequence = DateFormat.format("MMMM d, yyyy ", d.time)

        val data = Notes(null, title,  notes, notesDate.toString(), priority)
        viewModel.addNotes(data)
        Toast.makeText(requireContext(), "Notes created successfully", Toast.LENGTH_SHORT).show()
        Navigation.findNavController(it!!).navigate(R.id.action_createNotesFragment_to_homeFragment)


    }

}