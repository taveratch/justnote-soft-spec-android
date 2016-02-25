package com.example.taweesoft.justnote.views;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.taweesoft.justnote.R;
import com.example.taweesoft.justnote.models.Note;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by TAWEESOFT on 2/25/16 AD.
 */
public class NoteAdapter extends ArrayAdapter<Note>{

    public NoteAdapter(Context context, int resource, List<Note> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.note_custom_layout,null);
        }
        TextView subject_txt = (TextView)convertView.findViewById(R.id.subject_txt);
        TextView body_txt = (TextView)convertView.findViewById(R.id.body_txt);
        TextView char_txt = (TextView)convertView.findViewById(R.id.char_txt);
        TextView date_txt = (TextView)convertView.findViewById(R.id.date_txt);
        Note note = getItem(position);
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        Date date = new Date();
        date.setTime(note.getDate());
        date_txt.setText(format.format(date));
        char_txt.setText(note.getSubject().substring(0,1));
        subject_txt.setText(note.getSubject());
        body_txt.setText(note.getBody());
        return convertView;
    }
}
