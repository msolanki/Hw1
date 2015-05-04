package calculator.example.com.hw1;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import java.sql.BatchUpdateException;


public class Scientific extends ActionBarActivity {

    private TextView strDisplay;
    private Button basic;
    private Button btnsin, btncos, btntan, btni, btnln, btnlog, btnpi, btnexpo, btnper, btnfact, btnroot, btnsquare, btnopbr, btnclbr ;
    private double dblnumber;
    private String value = "0";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scientific);

        strDisplay = (TextView) findViewById(R.id.txtScreen);

        basic = (Button) findViewById(R.id.btnBasic);
        btnsin = (Button) findViewById(R.id.btnSin);
        btncos = (Button) findViewById(R.id.btnCos);
        btntan = (Button) findViewById(R.id.btnTan);

        btni = (Button) findViewById(R.id.btnI);
        btnln = (Button) findViewById(R.id.btnLn);
        btnlog = (Button) findViewById(R.id.btnLog);
        btnpi = (Button) findViewById(R.id.btnPi);

        btnexpo = (Button) findViewById(R.id.btnExpo);
        btnper = (Button) findViewById(R.id.btnPer);
        btnfact = (Button) findViewById(R.id.btnFact);
        btnroot = (Button) findViewById(R.id.btnRoot);

        btnsquare = (Button) findViewById(R.id.btnSquare);
        btnopbr = (Button) findViewById(R.id.btnOpBr);
        btnclbr = (Button) findViewById(R.id.btnClBr);


        Intent intent = getIntent();
        try {
            value = intent.getStringExtra("value");
        } catch (Exception e) {
        }

        strDisplay.setText(value);

        basic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Scientific.this, MainActivity.class);
                value = strDisplay.getText().toString();
                intent.putExtra("value", value);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);
            }
        });

        btnsin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dblnumber = Double.parseDouble(value);
                dblnumber = Math.sin(dblnumber);
                value = Double.toString(dblnumber);
                strDisplay.setText(value);
            }
        });

        btncos.setOnClickListener(new View.OnClickListener(){
            public void onClick (View v){
                dblnumber = Double.parseDouble(value);
                dblnumber = Math.cos(dblnumber);
                value = Double.toString(dblnumber);
                strDisplay.setText(value);
            }
        });

        btntan.setOnClickListener(new View.OnClickListener(){
            public void onClick (View v){
                dblnumber = Double.parseDouble(value);
                dblnumber = Math.tan(dblnumber);
                value = Double.toString(dblnumber);
                strDisplay.setText(value);
            }
        });

        btnln.setOnClickListener(new View.OnClickListener(){
            public void onClick (View v){
                dblnumber = Double.parseDouble(value);
                dblnumber = Math.log(dblnumber);
                value = Double.toString(dblnumber);
                strDisplay.setText(value);
            }

        });

        btnlog.setOnClickListener(new View.OnClickListener(){
            public void onClick (View v){
                dblnumber = Double.parseDouble(value);
                dblnumber = Math.log10(dblnumber);
                value = Double.toString(dblnumber);
                strDisplay.setText(value);
            }

        });

        btnroot.setOnClickListener(new View.OnClickListener(){
            public void onClick (View v){
                dblnumber = Double.parseDouble(value);
                dblnumber = Math.sqrt(dblnumber);
                value = Double.toString(dblnumber);
                strDisplay.setText(value);
            }
        });

        btnpi.setOnClickListener(new View.OnClickListener(){
            public void onClick (View v){
                dblnumber = Double.parseDouble(value);
                dblnumber = 3.14159 * dblnumber;
                value = Double.toString(dblnumber);
                strDisplay.setText(value);
            }
        });

        btnfact.setOnClickListener(new View.OnClickListener(){
            public void onClick (View v){
                dblnumber = Double.parseDouble(value);
                double result = 1;
                for (int i=1; i<=dblnumber; i++)
                    result = result * i;
                value = Double.toString(result);
                strDisplay.setText(value);
            }
        });

        btnopbr.setOnClickListener(new View.OnClickListener(){
            public void onClick (View v){
                value+="(";
                strDisplay.setText(value);
            }
        });

        btnclbr.setOnClickListener(new View.OnClickListener(){
            public void onClick (View v){
                value+=")";
                strDisplay.setText(value);
            }
        });
    }
}