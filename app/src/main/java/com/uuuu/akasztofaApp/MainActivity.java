package com.uuuu.akasztofaApp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.helper.widget.Flow;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    ImageView imageExecutionPlace, imageHelp;
    TextView megfejtesAllapot , textHelp;
    ConstraintLayout layoutLetters;
    Flow flowLetters;

    char[] letters_en = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        addLetterButtons(letters_en);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mainmenu, menu);
        return true;
    }
    private void init() {
        imageExecutionPlace = findViewById(R.id.imageExecutionPlace);
        megfejtesAllapot = findViewById(R.id.megfejtesAllapot);
        imageHelp = findViewById(R.id.imageHelp);
        textHelp = findViewById(R.id.textHelp);
        layoutLetters = findViewById(R.id.layoutLetters);
        flowLetters = findViewById(R.id.flowLetters);
    }

    /**
     * A választott nyelv ABC-nek megfelelő parancsgombokat a felületre helyezi.
     * @param letters
     */
    private void addLetterButtons(char[] letters){
        int[] referenceIDs = new int[letters.length];
        for (int i = 0; i < letters.length; i++) {
            MaterialButton myButton = new MaterialButton(this);
            myButton.setText(String.valueOf(letters[i]).toUpperCase());
            myButton.setId(View.generateViewId());
            final int id_ = myButton.getId();
            referenceIDs[i] = id_;
            myButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // TODO: 18 May 2023 Leellenőrizzük, hogy szerepel-e a karakter.
                    Toast.makeText(MainActivity.this, "Kattintott a " +String.valueOf(letters[id_-1]).toUpperCase(), Toast.LENGTH_SHORT).show();
                }
            });
            layoutLetters.addView(myButton);
            flowLetters.setReferencedIds(referenceIDs);
        }
    }
}