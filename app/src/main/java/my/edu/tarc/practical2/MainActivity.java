package my.edu.tarc.practical2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText editTextWeight, editTextHeight;
    private TextView textViewResult;
    private ImageView imageViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Linking UI to program
        editTextWeight = (EditText)findViewById(R.id.editTextWeight);
        editTextHeight = (EditText)findViewById(R.id.editTextHeight);
        textViewResult = (TextView)findViewById(R.id.textViewResult);
        imageViewResult = (ImageView)findViewById(R.id.imageViewResult);
    }

    public void calculateBMI(View view){
        double weight, height, bmi;
        weight = Double.parseDouble(editTextWeight.getText().toString());
        height = Double.parseDouble(editTextHeight.getText().toString()) / 100;
        bmi = weight / (height * height);
        displayImage(bmi);
    }

    public void displayImage(double bmi){
        if(bmi <= 18.5){
            imageViewResult.setImageResource(R.drawable.under);
            textViewResult.setText("Underweight");
        }
        else
        if(bmi > 18.5 && bmi < 21){
            imageViewResult.setImageResource(R.drawable.normal);
            textViewResult.setText("Normal");
        }
        else
        if(bmi >= 21){
            imageViewResult.setImageResource(R.drawable.over);
            textViewResult.setText("Overweight");
        }
    }

    public void resetValue(View view){
        editTextHeight.setText("");
        editTextWeight.setText("");
        imageViewResult.setImageResource(R.drawable.empty);
    }
}
