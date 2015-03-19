package emroxriprap.com.tracker;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Date;


public class MainScreen extends ActionBarActivity implements View.OnClickListener{


    private final String OUT = "Off the Clock";
    private final String IN = "On the Clock";

    private String dateVal;
    private Button enterHours, punchOut, viewPayments, viewWorkLog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        setupLayout();
    }

    private void setupLayout() {
        TextView date = (TextView)findViewById(R.id.tv_date);
        dateVal = DateFormat.getDateInstance().format(new Date());
        date.setText(dateVal);


        enterHours =(Button)findViewById(R.id.b_enter_hours);
        viewPayments = (Button)findViewById(R.id.b_view_payments);
        viewWorkLog = (Button)findViewById(R.id.b_view_work_log);

        enterHours.setOnClickListener(this);
        viewPayments.setOnClickListener(this);
        viewWorkLog.setOnClickListener(this);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.b_enter_hours:
                intent = new Intent(this, DataEntryScreen.class);
                startActivity(intent);
                break;

        }
    }

}
