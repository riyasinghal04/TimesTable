package com.example.timestable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView timeTableLS;

    public void generateTimesTable(int timesTable){

        ArrayList<String> timeTableContent=new ArrayList<String>();
        for(int i=1;i<=20;i++){
            timeTableContent.add(Integer.toString(i*timesTable));
        }

        ArrayAdapter<String> arrayAdapter =new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,timeTableContent);
        timeTableLS.setAdapter(arrayAdapter);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar timeTableSB= (SeekBar)findViewById(R.id.timeTableSeekbar);
        timeTableLS=(ListView)findViewById((R.id.myListView));
        timeTableSB.setMax(20);
        timeTableSB.setProgress(10);

        timeTableSB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//set minimum
                int min=1;
                int timeTable;
                if(progress<1){
                    timeTable=min;
                    timeTableSB.setProgress(min);
                }
                else {
                    timeTable = progress;
                    //to set progress min value to 1
                }
                    //Log.i("Seekbar value", Integer.toString(timeTable));
                generateTimesTable(timeTable);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        generateTimesTable(10);



    }
}
