/**
 *
 */
package ilia.curso.codely.vistas.activity;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ilia.curso.codely.vistas.model.Course;
import ilia.curso.codely.vistas.R;

/**
 * @author ilia
 */
public class ListWithStyleActivity extends Activity {

    private MenuAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);

        initListView();
    }

    private void initListView() {
        ListView listview = findViewById(R.id.menu_listview);

        List<Course> courses = initObjectList();
        adapter = new MenuAdapter(this, courses);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(menuListener);
    }

    private OnItemClickListener menuListener = new OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            showSelected(adapter.getItem(position));

        }
    };

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

    public void showSelected(Course course) {
        Toast.makeText(this, course.getTitle(), Toast.LENGTH_SHORT).show();
    }

    private class MenuAdapter extends BaseAdapter {
        private Context context;
        private List<Course> menuItems;

        public MenuAdapter(Context context, List<Course> items) {
            this.context = context;
            menuItems = items;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Course course = menuItems.get(position);

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item, null);

            TextView title = convertView.findViewById(R.id.item_title);
            title.setText(course.getTitle());

            TextView author = convertView.findViewById(R.id.item_author);
            author.setText(course.getAuthor());

            ImageView image = convertView.findViewById(R.id.item_image);
            image.setImageResource(course.getImage());

            return convertView;
        }

        @Override
        public int getCount() {
            return menuItems.size();
        }

        @Override
        public Course getItem(int position) {
            return menuItems.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }
}
