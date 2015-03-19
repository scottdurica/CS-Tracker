package emroxriprap.com.tracker.entryfragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
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
 * Created by Scott Durica on 3/17/2015.
 */
public class TimeInFragment extends Fragment{

    TimePicker timePicker;
    Button next;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_time_in, container, false);
        timePicker = (TimePicker)rootView.findViewById(R.id.tp_out);
        timePicker.setIs24HourView(true);
        next = (Button)rootView.findViewById(R.id.b_timein_next);
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
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                DataEntryScreen dataEntryScreen = (DataEntryScreen)getActivity();
                dataEntryScreen.entry.setInTime(time);
                Fragment fragment = new TimeOutFragment();
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.container, fragment, "TimeOut");
                ft.addToBackStack(null);
                ft.commit();
            }
        });

//        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
//            @Override
//            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
//                DateFormat date = new SimpleDateFormat("hh:mm");
//                String s = String.valueOf(hourOfDay) + ":" + String.valueOf(minute);
//                try {
//                    Date time = date.parse(s);
//                } catch (ParseException e) {
//                    e.printStackTrace();
//                }
//                Log.d("Value from button timepickerlistener: ", date.toString());
//
//            }
//        });


        return rootView;
    }
}
