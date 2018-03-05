/**
 *
 */
package ilia.curso.codely.vistas;

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
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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
        String[] values = getResources().getStringArray(R.array.guide_hour);

        adapter = new MenuAdapter(this, values);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(menuListener);
    }

    private OnItemClickListener menuListener = new OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            String item = adapter.getItem(position);
            showSelected(item);

        }
    };

    public void showSelected(String item) {
        Toast.makeText(this, item, Toast.LENGTH_SHORT).show();
    }

    private class MenuAdapter extends BaseAdapter {
        private Context context;
        private String[] menuItems;

        public MenuAdapter(Context context, String[] items) {
            this.context = context;
            menuItems = items;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            String entry = menuItems[position];

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.menu_item, null);

            TextView section = convertView.findViewById(R.id.section);
            section.setText(entry);

            return convertView;
        }

        @Override
        public int getCount() {
            return menuItems.length;
        }

        @Override
        public String getItem(int position) {
            return menuItems[position];
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
