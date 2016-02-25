package com.example.taweesoft.justnote.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.taweesoft.justnote.R;
import com.example.taweesoft.justnote.models.Note;

public class NoteActivity extends AppCompatActivity {

    private Note note;
    private TextView char_txt , subject_txt, body_txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        note = (Note)getIntent().getSerializableExtra("note");
        initialComponent();

        char_txt.setText(note.getSubject().substring(0,1));
        subject_txt.setText(note.getSubject());
        body_txt.setText(note.getBody());

    }

    public void initialComponent(){
        char_txt = (TextView)findViewById(R.id.char_txt);
        subject_txt = (TextView)findViewById(R.id.subject_txt);
        body_txt = (TextView)findViewById(R.id.body_txt);
    }
}
