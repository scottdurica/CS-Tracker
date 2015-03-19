package emroxriprap.com.tracker;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.roomorama.caldroid.CaldroidFragment;
import com.roomorama.caldroid.CaldroidListener;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

import emroxriprap.com.tracker.entryfragments.JobNameFragment;


public class DataEntryScreen extends FragmentActivity
        implements FragmentChangeListener {

//    Button next;
    public Entry entry;

    public Entry getEntry() {
        return entry;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_entry_screen);
        if (entry == null){
            entry = new Entry();
        }
//        if (savedInstanceState == null) {
//            getSupportFragmentManager().beginTransaction()
//                    .add(R.id.container, new PlaceholderFragment())
//                    .commit();
//        }
//        next = (Button)findViewById(R.id.b_next);
//        next.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d("GETTING HERE","GETTING HERE:::::::::::::::::::");
//                //see what fragment is showing so we know which frag to show next
//                Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.container);
//                if(fragment instanceof  JobNameFragment){
//                    Toast.makeText(getApplicationContext(),"JobName",Toast.LENGTH_SHORT).show();
//                }
//                //make sure field is filled out
//            }
//        });
        CaldroidFragment caldroidFragment = new CaldroidFragment();
        Bundle args = new Bundle();
        Calendar cal = Calendar.getInstance();
        args.putInt(CaldroidFragment.MONTH, cal.get(Calendar.MONTH) + 1);
        args.putInt(CaldroidFragment.YEAR, cal.get(Calendar.YEAR));
        caldroidFragment.setArguments(args);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.container, caldroidFragment, "Caldroid");
        ft.addToBackStack(null);
        ft.commit();

        final CaldroidListener listener = new CaldroidListener() {
            @Override
            public void onSelectDate(Date date, View view) {
//                SimpleDateFormat sdf = new SimpleDateFormat("MMMM F, yyyy - EEEE");
//                String d = sdf.format(date);
                DateFormat df = DateFormat.getDateInstance();
                String dd= df.format(date);
                Bundle args = new Bundle();
                args.putString("date",dd);
                JobNameFragment fragment = new JobNameFragment();
                fragment.setArguments(args);
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.container, fragment, "JobName");
                    ft.addToBackStack(null);
                    ft.commit();

            }
        };
        caldroidFragment.setCaldroidListener(listener);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_data_entry_screen, menu);
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
    public void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();;
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment, fragment.toString());
        fragmentTransaction.addToBackStack(fragment.toString());
        fragmentTransaction.commit();
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            View rootView = inflater.inflate(R.layout.fragment_job_name, container, false);

            return rootView;
        }
    }
}
