package com.example.mynotesmvvm.Repository

import androidx.lifecycle.LiveData
import com.example.mynotesmvvm.Dao.NotesDao
import com.example.mynotesmvvm.Model.Notes

class NotesRepository(val dao: NotesDao) {

    fun getAllNotes():LiveData<List<Notes>> = dao.getNotes()

    fun getHighNotes():LiveData<List<Notes>> = dao.getHighNotes()

    fun getMediumNotes():LiveData<List<Notes>> = dao.getMediumNotes()

    fun getLowNotes():LiveData<List<Notes>> = dao.getLowNotes()

    fun insertNotes(notes: Notes){
        dao.insertNotes(notes)
    }

    fun deleteNotes(id: Int){
        dao.deleteNotes(id)
    }

    fun updateNotes(notes: Notes){
        dao.updateNotes(notes)
    }
}