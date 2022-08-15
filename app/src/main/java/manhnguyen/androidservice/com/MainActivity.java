package manhnguyen.androidservice.com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editTextDataIntent;
    Button btnStartService, btnStopService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextDataIntent = (EditText) findViewById(R.id.edt_data_intent);
        btnStartService = (Button) findViewById(R.id.btn_start_service);
        btnStopService = (Button) findViewById(R.id.btn_stop_service);
        btnStartService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickStartService();
            }
        });
        btnStopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickStopService();
            }
        });
    }

    private void clickStopService() {
        Intent intent = new Intent(this, MyService.class);
        stopService(intent);
    }

    private void clickStartService() {
        Intent intent = new Intent(this, MyService.class);
        intent.putExtra("key_data_extent", editTextDataIntent.getText().toString().trim());
        startService(intent);
    }
}