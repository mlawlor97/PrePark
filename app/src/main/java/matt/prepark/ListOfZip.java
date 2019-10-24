package matt.prepark;
/**
 * @author jawad
 */
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to create a list for the 'Search Parking' section
 */

public class ListOfZip extends ListActivity {
    private ArrayAdapter<String> adapter;
    @Override
    /**
     * Creates a list of the addresses that it gets from the database
     * A SearchView object is also implemented to search the list
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_zip);

        ListView listView = findViewById(R.id.listview);
        List list = new ArrayList();
        SearchView searchView;
        Intent intent = getIntent();
        ArrayList<String> address = intent.getStringArrayListExtra("addressList");
        final String username = intent.getStringExtra("username");

        adapter = new ArrayAdapter<String>(getListView().getContext(), android.R.layout.simple_list_item_1, address);
        getListView().setAdapter(adapter);
        searchView=findViewById(R.id.searchView1);
        //On Click Stuff

        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intentlist = new Intent(getApplicationContext(), Map.class);
                intentlist.putExtra("address",address.get(i));
                intentlist.putExtra("username", username);
                startActivity(intentlist);


            }
        });

       searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
               return false;
            }

            @Override
           public boolean onQueryTextChange(String s) {
               adapter.getFilter().filter(s);
                return false;
            }
        });

    }
}
