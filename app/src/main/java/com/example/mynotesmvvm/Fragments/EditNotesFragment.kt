package com.example.mynotesmvvm.Fragments

import android.os.Bundle
import android.text.format.DateFormat
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.mynotesmvvm.Model.Notes
import com.example.mynotesmvvm.R
import com.example.mynotesmvvm.ViewModel.NotesViewModel
import com.example.mynotesmvvm.databinding.FragmentEditNotesBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import java.util.Date


class EditNotesFragment : Fragment() {

    private lateinit var binding: FragmentEditNotesBinding
    val oldNotes by navArgs<EditNotesFragmentArgs>()
    private var priority: String = "1"
    val viewModel: NotesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEditNotesBinding.inflate(layoutInflater, container, false)

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

        binding.btnEditSaveNotes.setOnClickListener {
            updateNotes(it)
        }

        binding.deleteBtn.setOnClickListener {
            deleteNotes(it)
        }

        binding.etTitle.setText(oldNotes.note.title)
        binding.etNotes.setText(oldNotes.note.notes)


        when (oldNotes.note.priority) {
            "1" -> {
                priority = "1"
                binding.pGreen.setImageResource(R.drawable.chceck_two)
                binding.pRed.setImageResource(0)
                binding.pYellow.setImageResource(0)
            }

            "2" -> {
                priority = "2"
                binding.pYellow.setImageResource(R.drawable.chceck_two)
                binding.pRed.setImageResource(0)
                binding.pGreen.setImageResource(0)
            }

            "3" -> {
                priority = "3"
                binding.pRed.setImageResource(R.drawable.chceck_two)
                binding.pGreen.setImageResource(0)
                binding.pYellow.setImageResource(0)
            }
        }
        binding.backBtn.setOnClickListener {
            Navigation.findNavController(it!!).navigate(R.id.action_editNotesFragment_to_homeFragment)
        }

        return binding.root
    }

    private fun deleteNotes(it: View?) {
        val bottomSheetDialog : BottomSheetDialog = BottomSheetDialog(requireContext(), R.style.BottomSheetStyle)
        bottomSheetDialog.setContentView(R.layout.dialoge_delete)
        bottomSheetDialog.show()

        val btnYes = bottomSheetDialog.findViewById<Button>(R.id.dialoge_yes)
        val btnNo = bottomSheetDialog.findViewById<Button>(R.id.dialoge_no)

        btnYes?.setOnClickListener{
            viewModel.deleteNotes(oldNotes.note.id!!)
            view?.findNavController()?.navigate(R.id.action_editNotesFragment_to_homeFragment)
            bottomSheetDialog.dismiss()
        }
        btnNo?.setOnClickListener{
            bottomSheetDialog.dismiss()
        }
    }

    private fun updateNotes(it: View?) {
        val title = binding.etTitle.text.toString()
        val notes = binding.etNotes.text.toString()

        val d = Date()
        val notesDate: CharSequence = DateFormat.format("MMMM d, yyyy ", d.time)

        val data = Notes(oldNotes.note.id , title,  notes, notesDate.toString(), priority)
        viewModel.updateNotes(data)
        Toast.makeText(requireContext(), "Notes updated successfully", Toast.LENGTH_SHORT).show()
        Navigation.findNavController(it!!).navigate(R.id.action_editNotesFragment_to_homeFragment)
    }

    companion object {

    }
}