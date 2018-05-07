package io.github.shardbytes.automata.streghttothenigeeeeeer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity/* implements View.OnClickListener*/{

    private Button tlac = findViewById(R.id.tlac);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*tlac.setOnClickListener(this);*/
    }
/*
    @Override
    public void onClick(View v) {
        tlac.setText("Kyss");
    }
    */
}
