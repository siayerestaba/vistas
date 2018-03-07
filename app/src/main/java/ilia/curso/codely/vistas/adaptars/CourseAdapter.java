package ilia.curso.codely.vistas.adaptars;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import ilia.curso.codely.vistas.R;
import ilia.curso.codely.vistas.model.Course;

public class CourseAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {
        private LayoutInflater inflater;
        private Context context;
        private List<Course> items;
        private View.OnClickListener listener;


        // Provide a suitable constructor (depends on the kind of dataset)
        public CourseAdapter(Context context, List<Course> items) {
            inflater = LayoutInflater.from(context);
            this.context = context;
            this.items = items;
        }

        public class CourseViewHolder extends RecyclerView.ViewHolder {
            private TextView title;
            private TextView author;
            private ImageView image;

            public CourseViewHolder(View v) {
                super(v);
                title = v.findViewById(R.id.item_title);
                author = v.findViewById(R.id.item_author);
                image = v.findViewById(R.id.item_image);
            }

            public void bindView(Course course) {
                title.setText(course.getTitle());
                author.setText(course.getAuthor());
                image.setImageResource(course.getImage());
            }
        }

        // Create new views (invoked by the layout manager)
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemLayoutView = inflater.inflate(R.layout.cardview2, parent, false);
            itemLayoutView.setOnClickListener(listener);
            return new CourseViewHolder(itemLayoutView);

        }

        // Replace the contents of a view (invoked by the layout manager)
        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            ((CourseViewHolder) holder).bindView(items.get(position));
        }

        @Override
        public int getItemCount() {
            return items.size();
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