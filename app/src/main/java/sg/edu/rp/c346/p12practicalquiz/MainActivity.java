package sg.edu.rp.c346.p12practicalquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Spinner spnWeb;
    WebView wvWeb;
    ArrayList<String> alWeb;
    ArrayAdapter<String> aaWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spnWeb = findViewById(R.id.spinnerWeb);
        wvWeb = findViewById(R.id.webViewWeb);
        alWeb = new ArrayList<>();
        String[]strWeb = getResources().getStringArray(R.array.app);
        alWeb.addAll(Arrays.asList(strWeb));
        aaWeb = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,alWeb);
        spnWeb.setAdapter(aaWeb);

        spnWeb.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int pos = spnWeb.getSelectedItemPosition();
                if(pos == 0){
                    wvWeb.setWebViewClient(new WebViewClient());
                    wvWeb.loadUrl("https://www.google.com");
                }else{
                    wvWeb.setWebViewClient(new WebViewClient());
                    wvWeb.loadUrl("https://www.rp.edu.sg");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}