package com.example.mynotesmvvm.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import androidx.room.util.query
import com.example.mynotesmvvm.Adapter.NotesAdapter
import com.example.mynotesmvvm.Model.Notes
import com.example.mynotesmvvm.R
import com.example.mynotesmvvm.ViewModel.NotesViewModel
import com.example.mynotesmvvm.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: NotesViewModel by viewModels()
    private var oldMyNotes = arrayListOf<Notes>()
    private lateinit var adapter: NotesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)

        viewModel.getNotes().observe(viewLifecycleOwner) { notesList ->
            oldMyNotes = notesList as ArrayList<Notes>
            adapter = NotesAdapter(requireContext(), notesList)
            binding.rvAllNotes.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            binding.rvAllNotes.adapter = adapter
        }

        binding.btnAddNotes.setOnClickListener{
           it.findNavController().navigate(R.id.action_homeFragment_to_createNotesFragment)
        }

        binding.filterHigh.setOnClickListener {
            viewModel.getHighNotes().observe(viewLifecycleOwner) { notesList ->
                oldMyNotes = notesList as ArrayList<Notes>
                binding.rvAllNotes.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
                binding.rvAllNotes.adapter = NotesAdapter(requireContext(), notesList)
            }
        }
        binding.filterMedium.setOnClickListener {
            viewModel.geMediumNotes().observe(viewLifecycleOwner) { notesList ->
                oldMyNotes = notesList as ArrayList<Notes>
                binding.rvAllNotes.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
                binding.rvAllNotes.adapter = NotesAdapter(requireContext(), notesList)
            }
        }
        binding.filterLow.setOnClickListener {
            viewModel.getLowNotes().observe(viewLifecycleOwner) { notesList ->
                oldMyNotes = notesList as ArrayList<Notes>
                binding.rvAllNotes.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
                binding.rvAllNotes.adapter = NotesAdapter(requireContext(), notesList)
            }
        }

        binding.allNotes.setOnClickListener {
            viewModel.getNotes().observe(viewLifecycleOwner) { notesList ->
                oldMyNotes = notesList as ArrayList<Notes>
                binding.rvAllNotes.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
                binding.rvAllNotes.adapter = NotesAdapter(requireContext(), notesList)
            }
        }

        binding.searchView.queryHint = "What do you want?"
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
               return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                notesFiltering(newText)
                return true
            }

        })

        binding.root.setOnTouchListener { _, _ ->
            binding.searchView.clearFocus()
            true
        }

        return binding.root
    }



    private fun notesFiltering(newText: String?) {
        val newFilteredList = arrayListOf<Notes>()

        for (i in oldMyNotes){
            if (i.title.contains(newText!!)|| i.notes.contains(newText!!)){
                 newFilteredList.add(i)
            }
        }

        adapter.filtering(newFilteredList)
    }

}
