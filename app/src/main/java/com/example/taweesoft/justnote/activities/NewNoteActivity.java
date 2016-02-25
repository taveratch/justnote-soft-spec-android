package com.example.taweesoft.justnote.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.taweesoft.justnote.R;
import com.example.taweesoft.justnote.models.Note;
import com.example.taweesoft.justnote.models.Storage;

public class NewNoteActivity extends AppCompatActivity {

    private EditText subject_txt , info_txt;
    private ImageView add_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_note);
        initialComponents();

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Storage.getInstance().saveNotes(new Note(subject_txt.getText().toString(),info_txt.getText().toString(),"#FFCA0A",System.currentTimeMillis()));
                finish();
            }
        });
    }

    public void initialComponents(){
        subject_txt = (EditText)findViewById(R.id.subject_txt);
        info_txt = (EditText)findViewById(R.id.info_txt);
        add_button = (ImageView)findViewById(R.id.add_button);
    }
}
