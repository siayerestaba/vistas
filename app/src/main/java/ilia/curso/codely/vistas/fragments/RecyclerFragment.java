/**
 *
 */
package ilia.curso.codely.vistas.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ilia.curso.codely.vistas.R;
import ilia.curso.codely.vistas.adaptars.CourseAdapter;
import ilia.curso.codely.vistas.model.Course;


/**
 * @author ilia
 */
public class RecyclerFragment extends Fragment {
    private List<Course> courses;
    private RecyclerView mRecyclerView;

    public RecyclerFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.recycler, container, false);

        courses = initObjectList();

        mRecyclerView = rootView.findViewById(R.id.recyclerlist);
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
//		mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
//		mRecyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        mRecyclerView.setHasFixedSize(true);

        CourseAdapter adapter = new CourseAdapter(getActivity(), courses);
        adapter.setOnClickListener(listListener);
        mRecyclerView.setAdapter(adapter);

        return rootView;
    }

    private View.OnClickListener listListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Course item = courses.get(mRecyclerView.getChildAdapterPosition(view));
            showSelected(item);
        }
    };

    public void showSelected(Course item) {
        Toast.makeText(getActivity(), item.getTitle(), Toast.LENGTH_SHORT).show();
    }

    private List<Course> initObjectList() {
        List<Course> listViewItems = new ArrayList<>();
        String[] titles = getResources().getStringArray(R.array.courses_titles);
        String[] authors = getResources().getStringArray(R.array.courses_authors);

        for (int i = 0; i < titles.length; i++) {
            int id = getResources().getIdentifier("codely_" + i, "mipmap", getActivity().getPackageName());
            listViewItems.add(new Course(titles[i], id, authors[i]));
        }

        return listViewItems;
    }
}
