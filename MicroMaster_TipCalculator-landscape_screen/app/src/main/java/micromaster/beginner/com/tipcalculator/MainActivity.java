package micromaster.beginner.com.tipcalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText input_billAmount;
    private Button buttonTip15;
    private Button buttonTip20;
    private TextView totalAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String initialTotalValue = "";
        if (savedInstanceState != null) {
            initialTotalValue = savedInstanceState.getString("totalAmount");
        }

        input_billAmount = findViewById(R.id.input_billAmount);
        buttonTip15 = findViewById(R.id.button_tip_15);
        buttonTip20 = findViewById(R.id.button_tip_20);
        totalAmount = findViewById(R.id.totalAmount);

        buttonTip15.setOnClickListener(this);
        buttonTip20.setOnClickListener(this);

        totalAmount.setText(initialTotalValue);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_tip_15:
                calculateTip(0.15);
                break;
            case R.id.button_tip_20:
                calculateTip(0.20);
                break;
        }
    }

    private void calculateTip(double tipValue) {
        Double tipDoubleValue = parseTip(input_billAmount.getText().toString());
        if (tipDoubleValue != null) {
            tipDoubleValue += tipDoubleValue * tipValue;
            totalAmount.setText(String.format(Locale.ENGLISH,"%.2f",tipDoubleValue));
        }
    }

    public static Double parseTip(String tipValue) {
        try {
            return Double.parseDouble(tipValue);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("totalAmount", totalAmount.getText().toString());
        super.onSaveInstanceState(outState);
    }
}
