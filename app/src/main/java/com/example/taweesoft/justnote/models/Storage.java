package com.example.taweesoft.justnote.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TAWEESOFT on 2/25/16 AD.
 */
public class Storage {
    private static Storage storage=null;
    private List<Note> notes = new ArrayList<Note>();
    public static Storage getInstance(){
        if(storage == null)
            storage = new Storage();
        return storage;
    }

    public void saveNotes(Note note){
        notes.add(note);
    }

    public List<Note> loadNotes(){
        //Todo : Write the real logic.
        return notes;
    }
}
