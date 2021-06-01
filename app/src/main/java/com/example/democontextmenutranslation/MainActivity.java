package com.example.democontextmenutranslation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvTranslate;
    TextView tvTranslate2;
    String clicked = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTranslate = findViewById(R.id.tvTranslate);
        tvTranslate2 = findViewById(R.id.tvTranslate2);


        registerForContextMenu(tvTranslate);
        registerForContextMenu(tvTranslate2);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0,0,0,"English");
        menu.add(0,1,1,"Italian");

        if(v == tvTranslate){
            clicked = "hello";
        }else if(v == tvTranslate2){
            clicked = "bye";
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(clicked.equalsIgnoreCase("hello")) {
            if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                //code for action
                tvTranslate.setText("Hello");

                return true; //menu item successfully handled
            } else if (item.getItemId() == 1) { //check if the selected menu item ID is 1
                //code for action
                tvTranslate.setText("Ciao");

                return true;  //menu item successfully handled
            }
        }else if(clicked.equalsIgnoreCase("bye")){
            if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                //code for action
                tvTranslate2.setText("Bye");

                return true; //menu item successfully handled
            } else if (item.getItemId() == 1) { //check if the selected menu item ID is 1
                //code for action
                tvTranslate2.setText("Addios");

                return true;  //menu item successfully handled
            }
        }

        return super.onContextItemSelected(item); //pass menu item to the superclass implementation
    }


}