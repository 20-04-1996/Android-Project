package app.com.example.pankaj.simplelistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.concurrent.Callable;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    TextView text_name;
    TextView text_description;
    ListView listView;

    int[] IMAGES = {
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5,
            R.drawable.img6,
            R.drawable.img7,
            R.drawable.img8,
            R.drawable.img9
    };

    String[] NAMES = {"Flower1","Flower2","Flower3","Flower4","Flower5","Flower6","Flower7","Flower8","Flower9"};

    String[] DESCRIPTION = {"Aconitum","African Daisy","Agapanthus","Alchemilla","Alstroemeria","Alyssum","Angelonia",
            "Anthurium","Aquilegia"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);

        CustomAdapter adapter = new CustomAdapter();

        listView.setAdapter(adapter);

    }

    public class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return IMAGES.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {

            view = getLayoutInflater().inflate(R.layout.list_item,null);

            imageView = (ImageView)view.findViewById(R.id.imageView);
            text_name = (TextView)view.findViewById(R.id.text_name);
            text_description = (TextView)view.findViewById(R.id.text_description);

            imageView.setImageResource(IMAGES[position]);
            text_name.setText(NAMES[position]);
            text_description.setText(DESCRIPTION[position]);

            return view;
        }
    }
}
