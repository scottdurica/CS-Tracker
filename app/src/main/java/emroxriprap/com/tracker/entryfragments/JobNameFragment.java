package emroxriprap.com.tracker.entryfragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import emroxriprap.com.tracker.DataEntryScreen;
import emroxriprap.com.tracker.Entry;
import emroxriprap.com.tracker.R;


/**
 * Created by Scott Durica on 3/6/2015.
 */
public class JobNameFragment extends Fragment  {


    private Button next;
    private EditText name;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_job_name, container, false);

        name = (EditText)rootView.findViewById(R.id.et_job_name);

        Bundle args = this.getArguments();
        String date = args.getString("date");

        next = (Button)rootView.findViewById(R.id.b_jobname_next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.getText().toString().equalsIgnoreCase("")){
                    Toast.makeText(getActivity(),"Enter a job name", Toast.LENGTH_SHORT).show();
                }else{
                     DataEntryScreen des = (DataEntryScreen)getActivity();
                     Entry e = des.getEntry();
                     e.setJobName(name.getText().toString());
                     Fragment fragment = new JobDescriptionFragment();
                     FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                     ft.replace(R.id.container, fragment, "JobDescription");
                     ft.addToBackStack(null);
                     ft.commit();
                }
            }
        });


        return rootView;
    }



}
