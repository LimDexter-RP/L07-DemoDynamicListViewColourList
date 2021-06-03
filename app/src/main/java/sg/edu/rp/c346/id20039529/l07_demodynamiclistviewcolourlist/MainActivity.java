package sg.edu.rp.c346.id20039529.l07_demodynamiclistviewcolourlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText etElement;
    EditText etIndex;
    Button btnAdd;
    ListView lvColour;
    Button btnDelete;
    Button btnUpdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etElement = findViewById(R.id.editTextColour);
        btnAdd = findViewById(R.id.buttonAddItem);
        btnDelete = findViewById(R.id.buttonRemoveItem);
        btnUpdate = findViewById(R.id.buttonUpdateItem);
        lvColour = findViewById(R.id.listViewColour);
        etIndex = findViewById(R.id.editTextIndex);

        ArrayList <String> alColours = new ArrayList<>();
        alColours.add("Red");
        alColours.add("Orange");

        ArrayAdapter<String> aaColour = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, alColours);

        lvColour.setAdapter(aaColour);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String colour = etElement.getText().toString();
                int pos = Integer.parseInt(etIndex.getText().toString());
                alColours.add(pos, colour);
                aaColour.notifyDataSetChanged();
            }
        });
        lvColour.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String colour = alColours.get(position);
                Toast.makeText(MainActivity.this, colour, Toast.LENGTH_SHORT).show();
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = Integer.parseInt(etIndex.getText().toString());
                alColours.remove(pos);
                aaColour.notifyDataSetChanged();

            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String colour = etElement.getText().toString();
                int pos = Integer.parseInt(etIndex.getText().toString());
                alColours.set(pos, colour);
                aaColour.notifyDataSetChanged();
            }
        });
    }
}