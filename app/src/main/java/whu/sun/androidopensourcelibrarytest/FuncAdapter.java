package whu.sun.androidopensourcelibrarytest;

import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class FuncAdapter extends RecyclerView.Adapter<FuncAdapter.ViewHolder> {

    private List<Func> funcs;

    static class ViewHolder extends RecyclerView.ViewHolder {
        private AppCompatImageView imageView;
        private AppCompatTextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img);
            textView = itemView.findViewById(R.id.txt);
        }
    }

    public FuncAdapter(List<Func> funcs) {
        this.funcs = funcs;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_func, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Func func = funcs.get(position);
        holder.imageView.setImageResource(func.getImgId());
        holder.textView.setText(func.getName());
    }

    @Override
    public int getItemCount() {
        return funcs.size();
    }
}
