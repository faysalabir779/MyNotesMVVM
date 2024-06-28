package com.example.mynotesmvvm.ViewModel

import android.app.Application
import android.provider.ContactsContract.CommonDataKinds.Note
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.mynotesmvvm.Database.NotesDatabase
import com.example.mynotesmvvm.Model.Notes
import com.example.mynotesmvvm.Repository.NotesRepository

class NotesViewModel(application: Application):AndroidViewModel(application) {

    val repository: NotesRepository

    init {
        val dao = NotesDatabase.getDatabaseInstance(application).myNotesDao()
        repository = NotesRepository(dao)
    }

    fun addNotes(notes: Notes){
        repository.insertNotes(notes)
    }

    fun getHighNotes():LiveData<List<Notes>> = repository.getHighNotes()

    fun geMediumNotes():LiveData<List<Notes>> = repository.getMediumNotes()

    fun getLowNotes():LiveData<List<Notes>> = repository.getLowNotes()

    fun getNotes():LiveData<List<Notes>> = repository.getAllNotes()

    fun deleteNotes(id:Int){
        repository.deleteNotes(id)
    }
    fun updateNotes(notes: Notes){
        repository.updateNotes(notes)
    }
}