package com.example.GrowBuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class Meditation extends AppCompatActivity {

    private SoundPool tone;
    private TextView time;
    private CountDownTimer timer;
    private EditText customTime;
    private TextView customDisplay;
    private CountDownTimer customCountdown;

    private Button reset;
    private Button five_Mins;
    private Button two_Mins;
    private Button ten_Mins;
    private Button twenty_Five;
    private Button setCustom;
    private Button start_Pause;
    private Button customReset;

    private int FIVE_MINS = 300000;
    private int TWO_MINS = 20000;
    private int TEN_MINS = 600000;
    private int TWENTY_FIVE_MINS = 1500000;
    private long startTime;
    private long customTimeLeft;
    private long endingTime;

    private boolean isRunning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meditation);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            AudioAttributes audioAttributes = new AudioAttributes.Builder()                 // This if statement is a version check that ensures the android soundpool works on all android versions
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .setUsage(AudioAttributes.USAGE_GAME)
                    .build();
            tone = new SoundPool.Builder()
                    .setMaxStreams(2)
                    .setAudioAttributes(audioAttributes)
                    .build();
        } else {
            tone = new SoundPool(2, AudioManager.STREAM_MUSIC, 0);         // a sound pool was chosen as it is better for short constant running sounds
        }


        final int sound = tone.load(this, R.raw.alert, 1);

        time = findViewById(R.id.shown_Time);
        reset = findViewById(R.id.btn_reset);
        two_Mins = findViewById(R.id.btn_2Mins);                                                // declaration of elements on activity page
        five_Mins = findViewById(R.id.btn_5mins);
        ten_Mins = findViewById(R.id.btn_10Mins);
        twenty_Five = findViewById(R.id.btn_25Mins);

        customTime = findViewById(R.id.edit_text_input);
        customDisplay = findViewById(R.id.text_view_countdown);
        setCustom = findViewById(R.id.button_set);
        start_Pause = findViewById(R.id.button_start_pause);
        customReset = findViewById(R.id.button_reset);

        five_Mins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                reset.setVisibility(View.VISIBLE);
                two_Mins.setVisibility(View.INVISIBLE);
                ten_Mins.setVisibility(View.INVISIBLE);
                twenty_Five.setVisibility(View.INVISIBLE);

                timer = new CountDownTimer(FIVE_MINS, 1000) {

                    public void onTick(long millisUntilFinished) {
                        int mins = (int) (millisUntilFinished / 1000 / 60);                             //this method creates a timer that counts down from a pre assigned time
                        int sec = (int) (millisUntilFinished / 1000 % 60);
                        String x = String.format("%02d:%02d", mins, sec);                               //this string converts the minuites and seconds into the standard time format (xx:xx)
                        time.setText(x);
                    }
                    public void onFinish() {
                        time.setText("Done!");
                        reset.setVisibility(View.VISIBLE);                                                  // when the timer is completed, the sound pool plays
                        tone.play(sound, 1, 1, 1, 0, 1);
                    }
                }.start();

            }
        });

        two_Mins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                reset.setVisibility(View.VISIBLE);
                ten_Mins.setVisibility(View.INVISIBLE);
                twenty_Five.setVisibility(View.INVISIBLE);
                five_Mins.setVisibility(View.INVISIBLE);

                timer = new CountDownTimer(TWO_MINS, 1000) {

                    public void onTick(long millisUntilFinished) {
                        int mins = (int) (millisUntilFinished / 1000 / 60);
                        int sec = (int) (millisUntilFinished / 1000 % 60);
                        String x = String.format("%02d:%02d", mins, sec);
                        time.setText(x);

                    }
                    public void onFinish() {
                        time.setText("Done!");
                        tone.play(sound, 1, 1, 1, 0, 1);
                        reset.setVisibility(View.VISIBLE);
                    }
                }.start();
            }
        });
        ten_Mins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reset.setVisibility(View.VISIBLE);
                two_Mins.setVisibility(View.INVISIBLE);
                twenty_Five.setVisibility(View.INVISIBLE);
                five_Mins.setVisibility(View.INVISIBLE);

                timer = new CountDownTimer(TEN_MINS, 1000) {

                    public void onTick(long millisUntilFinished) {
                        int mins = (int) (millisUntilFinished / 1000 / 60);
                        int sec = (int) (millisUntilFinished / 1000 % 60);
                        String x = String.format("%02d:%02d", mins, sec);
                        time.setText(x);
                    }
                    public void onFinish() {
                        time.setText("Done!");
                        tone.play(sound, 1, 1, 1, 0, 1);
                        reset.setVisibility(View.VISIBLE);
                    }
                }.start();

            }
        });
        twenty_Five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reset.setVisibility(View.VISIBLE);
                two_Mins.setVisibility(View.INVISIBLE);
                ten_Mins.setVisibility(View.INVISIBLE);
                five_Mins.setVisibility(View.INVISIBLE);

                timer = new CountDownTimer(TWENTY_FIVE_MINS, 1000) {

                    public void onTick(long millisUntilFinished) {
                        int mins = (int) (millisUntilFinished / 1000 / 60);
                        int sec = (int) (millisUntilFinished / 1000 % 60);
                        String x = String.format("%02d:%02d", mins, sec);
                        time.setText(x);

                    }
                    public void onFinish() {
                        time.setText("Done!");
                        tone.play(sound, 1, 1, 1, 0, 1);
                        reset.setVisibility(View.VISIBLE);
                    }
                }.start();
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                timer.cancel();
                time.setText("00:00");
                reset.setVisibility(View.INVISIBLE);
                two_Mins.setVisibility(View.VISIBLE);
                ten_Mins.setVisibility(View.VISIBLE);
                five_Mins.setVisibility(View.VISIBLE);
                twenty_Five.setVisibility(View.VISIBLE);
            }
        });


        setCustom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userInput = customTime.getText().toString();
                                                                                                                                                        //This method controls the actions of the set button
                if (userInput.length() == 0) {                                                                                                          // When this button is clicked, the  method gets the time the user
                    Toast.makeText(Meditation.this, "Enter a time (Mins)", Toast.LENGTH_SHORT).show();                                    // has entered in the input field.
                    return;
                }

                long millisInput = Long.parseLong(userInput) * 60000;                                                                                    // This line of code converts the users integer entry to a Long value in the format of seconds
                if (millisInput == 0) {                                                                                                                  // If the number is not a whole number, the user is flagged with a toast asking them to enter a valid number
                    Toast.makeText(Meditation.this, "Please enter a valid number", Toast.LENGTH_SHORT).show();
                    return;
                }
                set(millisInput);
                customTime.setText("");                                                                                                                   // after the time is set, the text field is cleared.
            }
        });

        start_Pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {                                                                                                                   // this button starts and pauses the custom set timer
                if (isRunning) {
                    pauseCustom();
                } else {                                                                                                                                    // if the timer is running, the button allows the user to pause the timer
                    startCustom();
                }                                                                                                                                           // if the timer isnt running, the button allows the user to start the timer
            }
        });
        customReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {                                                                                                                     // when this button is pressed, the reset method is run
                resetCustom();
            }
        });
    }
    private void set(long milliseconds) {
        startTime = milliseconds;                                                                                                       // this method is done when the set button is pressed. The method sets the start time as the value confirmed when the set
        resetCustom();                                                                                                                     // button is pressed.
        closeKeyboard();                                                                                                                    // after the time is set, the keyboard is closed and the reset method is run.

    }
    private void startCustom() {
        endingTime = System.currentTimeMillis() + customTimeLeft;                                                                   // this method starts the timer. on each second, the interface is updated.
        customCountdown = new CountDownTimer(customTimeLeft, 1000) {
            @Override
            public void onTick(long i) {
                customTimeLeft = i;
                updateCountDown();
            }
            @Override
            public void onFinish() {
                isRunning = false;
                updateInterface();
                tone.play(1,1,1,1,0,1);
            }
        }.start();
        isRunning = true;
        updateInterface();                                                                                              // the isRunning boolean is set to true so the argument can be checked to pause the timer.
    }
    private void pauseCustom() {
        customCountdown.cancel();
        isRunning = false;
        updateInterface();                                                                                              // if the timer is running, pressing the pause button cancels the timer.
    }
    private void resetCustom() {
        customTimeLeft = startTime;
        updateCountDown();
        updateInterface();
    }
    private void updateCountDown() {
        int hours = (int) (customTimeLeft / 1000) / 3600;                                                               // this method is responsible for making sure the timer is displayed properly.
        int minutes = (int) ((customTimeLeft / 1000) % 3600) / 60;
        int seconds = (int) (customTimeLeft / 1000) % 60;
        String timeLeftFormatted;

        if (hours > 0) {
            timeLeftFormatted = String.format(Locale.getDefault(),
                    "%d:%02d:%02d", hours, minutes, seconds);
        } else {
            timeLeftFormatted = String.format(Locale.getDefault(),
                    "%02d:%02d", minutes, seconds);
        }
        customDisplay.setText(timeLeftFormatted);
    }
    private void updateInterface() {
        if (isRunning) {
            customTime.setVisibility(View.INVISIBLE);
            setCustom.setVisibility(View.INVISIBLE);
            customReset.setVisibility(View.INVISIBLE);                                                  // this method is responsible for displaying the relevant buttons when the timer is start or stopped
            start_Pause.setText("Pause");
        } else {
            customTime.setVisibility(View.VISIBLE);
            setCustom.setVisibility(View.VISIBLE);
            start_Pause.setText("Start");
            if (customTimeLeft < 1000) {
                start_Pause.setVisibility(View.INVISIBLE);
            } else {
                start_Pause.setVisibility(View.VISIBLE);
            }
            if (customTimeLeft < startTime) {
                customReset.setVisibility(View.VISIBLE);
            } else {
                customReset.setVisibility(View.INVISIBLE);
            }
        }
    }
    private void closeKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);                               // this method closes the keyboard
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
    @Override
    protected void onStop() {
        super.onStop();
        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);                                      // when this method is run, the system saves the values. this is how the pausing of the timer is handled.
        SharedPreferences.Editor editor = prefs.edit();
        editor.putLong("startTime", startTime);
        editor.putLong("timeLeft", customTimeLeft);
        editor.putBoolean("running", isRunning);
        editor.putLong("endTime", endingTime);
        editor.apply();
        if (customCountdown != null) {
            customCountdown.cancel();
        }
    }
    @Override
    protected void onStart() {
        super.onStart();
        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);                          //when this method is run, the system gets the saved timer details meaning it can reload and resume th timer.
        startTime = prefs.getLong("startTime", 600000);
        customTimeLeft = prefs.getLong("timeLeft", startTime);
        isRunning = prefs.getBoolean("running", false);
        updateCountDown();
        updateInterface();
        if (isRunning) {
            endingTime = prefs.getLong("endTime", 0);
            customTimeLeft = endingTime - System.currentTimeMillis();
            if (customTimeLeft < 0) {
                customTimeLeft = 0;
                isRunning = false;
                updateCountDown();
                updateInterface();
            } else {
                startCustom();
            }
        }
    }
}