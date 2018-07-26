package com.example.nvmanh.note;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder> {

    private Context mContext;
    private List<Note> mNotes;

    public NoteAdapter(Context context, List<Note> notes) {
        this.mContext = context;
        this.mNotes = notes;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater =
                (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_note, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final Note note = mNotes.get(position);
        holder.mTextId.setText(note.getmId() + ". ");
        holder.mTextTitle.setText(note.getmTitle());
        holder.mTextBody.setText(note.getmBody());
    }

    @Override
    public int getItemCount() {
        if(mNotes != null){
            return mNotes.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mTextId;
        private TextView mTextTitle;
        private TextView mTextBody;

        public ViewHolder(View itemView) {
            super(itemView);
            mTextId = itemView.findViewById(R.id.text_id);
            mTextTitle = itemView.findViewById(R.id.text_title);
            mTextBody = itemView.findViewById(R.id.text_body);
        }
    }
}
