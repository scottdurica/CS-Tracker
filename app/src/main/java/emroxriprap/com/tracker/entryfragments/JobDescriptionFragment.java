package emroxriprap.com.tracker.entryfragments;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import emroxriprap.com.tracker.DataEntryScreen;
import emroxriprap.com.tracker.R;

/**
 * Created by Scott Durica on 3/11/2015.
 */
public class JobDescriptionFragment extends Fragment{

    private Button next;
    private EditText description;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_job_description, container, false);


//        Bundle args = this.getArguments();
//        String date = args.getString("date");
        description = (EditText)rootView.findViewById(R.id.et_job_description);
        next = (Button)rootView.findViewById(R.id.b_job_description_next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("here here here here", "Getting here");

                DataEntryScreen dataEntryScreen = (DataEntryScreen)getActivity();
                dataEntryScreen.entry.setDescription(description.getText().toString());
                Fragment fragment = new TimeInFragment();
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.container, fragment, "TimeIn");
                ft.addToBackStack(null);
                ft.commit();
            }
        });


        return rootView;
    }
}
