package sourcebrain.com.stackoverflow;

import android.app.TimePickerDialog;
import android.content.Context;
import android.widget.TimePicker;

/**
 * Created by Sujay on 01-07-2016.
 */
public class CustomTimePicker extends TimePickerDialog {
    Context context;
    TimePicker picker;
    public CustomTimePicker(Context context, OnTimeSetListener listener, int hourOfDay, int minute, boolean is24HourView) {
        super(context, listener, hourOfDay, minute, is24HourView);
        this.context= context;
    }

    public CustomTimePicker(Context context, int themeResId, OnTimeSetListener listener, int hourOfDay, int minute, boolean is24HourView) {
        super(context, themeResId, listener, hourOfDay, minute, is24HourView);
    }


    @Override
    public void updateTime(int hourOfDay, int minuteOfHour) {
      //  super.updateTime(hourOfDay, minuteOfHour);
        System.out.println("updateTime" + minuteOfHour);
        if(picker!=null) {
            picker.setCurrentMinute(45);
        }
    }

    @Override
    public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
        picker = view;
        System.out.println("onTimeChanged" + minute);
        int newMinute =  ((minute+5-1) / 5) * 5;

        //updateTime(hourOfDay, 45);
        if (newMinute != minute) {

//           view.setMinute(newMinute); has same effect
        }
    }
}
