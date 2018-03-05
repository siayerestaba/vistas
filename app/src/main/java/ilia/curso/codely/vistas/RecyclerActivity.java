package ilia.curso.codely.vistas;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

/**
 * Created by Perez on 05/03/2018.
 */

public class RecyclerActivity extends Activity {

    private String[] hoursGuide;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler);

        hoursGuide = getResources().getStringArray(R.array.guide_hour);

        mRecyclerView = findViewById(R.id.recyclerlist);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        mRecyclerView.setHasFixedSize(true);

        StringAdapter adapter = new StringAdapter(this, hoursGuide);
        adapter.setOnClickListener(listListener);
        mRecyclerView.setAdapter(adapter);
    }

    private View.OnClickListener listListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String item = hoursGuide[mRecyclerView.getChildAdapterPosition(view)];
            showSelected(item);
        }
    };

    public void showSelected(String item) {
        Toast.makeText(this, item, Toast.LENGTH_SHORT).show();
    }

    private class StringAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {
        private LayoutInflater inflater;
        private Context context;
        private String[] items;
        private View.OnClickListener listener;


        // Provide a suitable constructor (depends on the kind of dataset)
        public StringAdapter(Context context, String[] items) {
            inflater = LayoutInflater.from(context);
            this.context = context;
            this.items = items;
        }

        public class StringViewHolder extends RecyclerView.ViewHolder {
            private TextView section;

            public StringViewHolder(View v) {
                super(v);
                section = (TextView) v.findViewById(R.id.section);
            }

            public void bindView(String texto) {
                section.setText(texto);
            }
        }

        // Create new views (invoked by the layout manager)
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemLayoutView = inflater.inflate(R.layout.menu_item, parent, false);
            itemLayoutView.setOnClickListener(listener);
            return new StringViewHolder(itemLayoutView);

        }

        // Replace the contents of a view (invoked by the layout manager)
        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            ((StringViewHolder) holder).bindView(items[position]);
        }

        @Override
        public int getItemCount() {
            return items.length;
        }

        public void setOnClickListener(View.OnClickListener listener) {
            this.listener = listener;
        }

        @Override
        public void onClick(View view) {
            if (listener != null)
                listener.onClick(view);
        }
    }
}

