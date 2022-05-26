package sg.edu.rp.c346.id21014919.demooptionmenutranslation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvRegisteredText, tvRegisteredText2;
    String wordClicked = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvRegisteredText = findViewById(R.id.tvRegisteredText);
        tvRegisteredText2 = findViewById(R.id.tvRegisteredText2);

        registerForContextMenu(tvRegisteredText);
        registerForContextMenu(tvRegisteredText2);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        if(v == tvRegisteredText) {
            wordClicked = "hello";
        } else if (v == tvRegisteredText2) {
            wordClicked = "bye";
        }

        menu.add(0,0,0,"English");
        menu.add(0,1,1,"Italian");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(wordClicked.equalsIgnoreCase("hello")){
            if(item.getItemId()==0) { //check whether the selected menu item ID is 0
                //code for action
                Toast.makeText(MainActivity.this, "English is chosen", Toast.LENGTH_SHORT).show();
                tvRegisteredText.setText("Hello");
                return true; //menu item successfully handled

            } else if(item.getItemId()==1) { //check if the selected menu item ID is 1
                //code for action
                Toast.makeText(MainActivity.this, "Italian is chosen", Toast.LENGTH_SHORT).show();
                tvRegisteredText.setText("Ciao");
                return true;  //menu item successfully handled
            }
        }
        if(wordClicked.equalsIgnoreCase("bye")){
            if(item.getItemId()==0) { //check whether the selected menu item ID is 0
                //code for action
                Toast.makeText(MainActivity.this, "English is chosen", Toast.LENGTH_SHORT).show();
                tvRegisteredText2.setText("Bye");
                return true; //menu item successfully handled

            } else if(item.getItemId()==1) { //check if the selected menu item ID is 1
                //code for action
                Toast.makeText(MainActivity.this, "Italian is chosen", Toast.LENGTH_SHORT).show();
                tvRegisteredText2.setText("Addio");
                return true;  //menu item successfully handled
            }
        }
        return super.onContextItemSelected(item); //pass menu item to the superclass implementation
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            tvRegisteredText.setText("Hello ");
            tvRegisteredText2.setText("Bye ");
            return true;
        } else if (id == R.id.italianSelection) {
            tvRegisteredText.setText("Ciao");
            tvRegisteredText2.setText("Addio ");
            return true;
        } else {
            tvRegisteredText.setText("Error translation");
        }

        return super.onOptionsItemSelected(item);
    }




}