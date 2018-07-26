package com.example.nvmanh.note;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity{

    private static final String URL_GIT = "https://jsonplaceholder.typicode.com/posts";
    private static final String ID = "id";
    private static final String TITLE = "title";
    private static final String BODY = "body";
    private RecyclerView mRecyclerNote;
    private List<Note> mNotes;

    private DownloadJSON mDownloadJSON;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        mNotes = getNotes();
        setupView();
    }

    private void initView(){
        mRecyclerNote = findViewById(R.id.recycler_note);
    }

    private void setupView(){
        NoteAdapter noteAdapter = new NoteAdapter(this, mNotes);
        mRecyclerNote.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerNote.setAdapter(noteAdapter);
        noteAdapter.notifyDataSetChanged();
    }

    private String dowloadJSON() throws ExecutionException, InterruptedException {
        mDownloadJSON = new DownloadJSON();
        mDownloadJSON.execute(URL_GIT);
        return  mDownloadJSON.get();
    }

    private List<Note> getNotes(){
        List<Note> notes = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(dowloadJSON());
            for(int i = 0; i < jsonArray.length(); i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                int id = jsonObject.getInt(ID);
                String title = jsonObject.getString(TITLE);
                String body = jsonObject.getString(BODY);
                Note note = new Note(id, title, body);
                notes.add(note);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return notes;
    }
}
