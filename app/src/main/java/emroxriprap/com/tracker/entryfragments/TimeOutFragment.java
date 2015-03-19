package emroxriprap.com.tracker.entryfragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TimePicker;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import emroxriprap.com.tracker.DataEntryScreen;
import emroxriprap.com.tracker.R;

/**
 * Created by Scott Durica on 3/18/2015.
 */
public class TimeOutFragment extends Fragment{

    TimePicker timePicker;
    Button next;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_time_out, container, false);
        timePicker = (TimePicker) rootView.findViewById(R.id.tp_out);
        timePicker.setIs24HourView(true);
        next = (Button) rootView.findViewById(R.id.b_timeout_next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int hourOfDay = timePicker.getCurrentHour();
                int minute = timePicker.getCurrentMinute();

                DateFormat date = new SimpleDateFormat("hh:mm");
                String s = String.valueOf(hourOfDay) + ":" + String.valueOf(minute);
                Date time = null;
                try {
                    time = date.parse(s);
                    Log.d("time = ",s);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                DataEntryScreen dataEntryScreen = (DataEntryScreen) getActivity();
                dataEntryScreen.entry.setOutTime(time);

                Date in = dataEntryScreen.entry.getInTime();
                long diff = time.getTime() - in.getTime();
                int timeInSeconds = (int)diff / 1000;
                int hours = timeInSeconds / 3600;

                timeInSeconds -= hours * 3600;
                int minutes = timeInSeconds / 60;


                Log.d("The time difference is: ", "" + hours + ":" + minutes);

//                Fragment fragment = new TimeOutFragment();
//                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
//                ft.replace(R.id.container, fragment, "TimeOut");
//                ft.addToBackStack(null);
//                ft.commit();
            }
        });


        return rootView;
    }
}
