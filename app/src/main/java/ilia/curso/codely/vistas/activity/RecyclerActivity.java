package ilia.curso.codely.vistas.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ilia.curso.codely.vistas.adaptars.CourseAdapter;
import ilia.curso.codely.vistas.model.Course;
import ilia.curso.codely.vistas.commons.DividerItemDecoration;
import ilia.curso.codely.vistas.R;

/**
 * Created by Perez on 05/03/2018.
 */

public class RecyclerActivity extends Activity {

    private List<Course> courses;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler);

        courses = initObjectList();

        mRecyclerView = findViewById(R.id.recyclerlist);
//        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        mRecyclerView.setHasFixedSize(true);

        CourseAdapter adapter = new CourseAdapter(this, courses);
        adapter.setOnClickListener(listListener);
        mRecyclerView.setAdapter(adapter);
    }

    private View.OnClickListener listListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Course item = courses.get(mRecyclerView.getChildAdapterPosition(view));
            showSelected(item);
        }
    };

    public void showSelected(Course item) {
        Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
    }

    private List<Course> initObjectList() {
        List<Course> listViewItems = new ArrayList<>();
        String[] titles = getResources().getStringArray(R.array.courses_titles);
        String[] authors = getResources().getStringArray(R.array.courses_authors);

        for (int i = 0; i < titles.length; i++) {
            int id = getResources().getIdentifier("codely_" + i, "mipmap", getPackageName());
            listViewItems.add(new Course(titles[i], id, authors[i]));
        }

        return listViewItems;
    }


}

