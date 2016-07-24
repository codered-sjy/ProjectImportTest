package sourcebrain.com.stackoverflow;

import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatDrawableManager;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences.Editor editor;
    }
    CustomTimePicker dialog;

    EditText mEtValue;
    SeekBar mSbValue;

    private void bindElements(){
        final int SEEKBAR_SIZE_CORRECTION = 200;
        final int SEEKBAR_MAX_SIZE = 1000;
        // 10000 Change to object max value
        int correctMax = SEEKBAR_MAX_SIZE - SEEKBAR_SIZE_CORRECTION;
        int newCorrectMax;

        mEtValue = (EditText) findViewById(R.id.et_value);
        mEtValue.setFilters(new InputFilter[] { new InputFilter.LengthFilter(SEEKBAR_MAX_SIZE) });
        mEtValue.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try{
                    if(s.length() > 0)
                        mSbValue.setProgress(Integer.parseInt(String.valueOf(s)));
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        mSbValue = (SeekBar) findViewById(R.id.sb_value);
        try {
            mSbValue.setMax(correctMax);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        mSbValue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mEtValue.setText(String.valueOf(progress));
                mEtValue.setSelection(mEtValue.getText().length());
            }
        });
    }
}
