package com.example.taweesoft.justnote.activities;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.taweesoft.justnote.R;
import com.example.taweesoft.justnote.models.Note;
import com.example.taweesoft.justnote.models.Storage;
import com.example.taweesoft.justnote.views.NoteAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private GridView gridView;
    private List<Note> notes = new ArrayList<Note>();
    private NoteAdapter adapter;
    private ImageView add_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialComponents();

    }

    public void initialComponents(){
        gridView = (GridView)findViewById(R.id.gridView);
        add_button = (ImageView)findViewById(R.id.add_button);
        adapter = new NoteAdapter(this,R.layout.note_custom_layout,notes);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, NoteActivity.class);
                intent.putExtra("note", notes.get(position));
                Log.e("MAIN", notes.get(position).hashCode() + "");
                startActivity(intent);
            }
        });

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,NewNoteActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        notes.clear();
        for(Note note : Storage.getInstance().loadNotes()){
            notes.add(note);
        }
        adapter.notifyDataSetChanged();
    }
}
