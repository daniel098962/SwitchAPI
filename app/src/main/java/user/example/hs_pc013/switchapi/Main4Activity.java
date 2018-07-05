package user.example.hs_pc013.switchapi;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Main4Activity extends AppCompatActivity {

    ImageButton btnC;
    ImageButton btnF;
    ImageButton btnS;

    RadioGroup rg1,rg2,rg3,rg4,rg5,rg6;

    RadioButton btnA1;
    RadioButton btnA2;
    RadioButton btnIN1;
    RadioButton btnIN2;
    RadioButton btnIN3;
    RadioButton btnIN4;
    RadioButton btnIN5;
    RadioButton btnIN6;
    RadioButton btnO1;
    RadioButton btnO2;
    RadioButton btnM1;
    RadioButton btnM2;
    RadioButton btnAll,btnOff;
    TextView txtN,txtI;
    Intent change = new Intent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        btnC = (ImageButton)findViewById(R.id.btnLink);
        btnC.setOnClickListener(btnLis);
        btnC.setEnabled(true);

        btnF = (ImageButton)findViewById(R.id.btnI);
        btnF.setOnClickListener(btnLis);
        btnF.setEnabled(false);

        btnS = (ImageButton)findViewById(R.id.btnS);
        btnS.setOnClickListener(btnLis);
        btnS.setEnabled(false);

        txtI = (TextView)findViewById(R.id.txtIPNAME);
        txtN = (TextView)findViewById(R.id.txtName);

        rg1 = (RadioGroup)findViewById(R.id.segmentAV);
        rg2 = (RadioGroup)findViewById(R.id.segmentedIn);
        rg5 = (RadioGroup)findViewById(R.id.segmentInput2);
        rg3 = (RadioGroup)findViewById(R.id.segmentOutput);
        rg4 = (RadioGroup)findViewById(R.id.segmentMe);
        rg6 = (RadioGroup)findViewById(R.id.segmentAll);

        btnA1 = (RadioButton)findViewById(R.id.btnAV1);
        btnA1.setEnabled(false);
        btnA2 = (RadioButton)findViewById(R.id.btnAV2);
        btnA2.setEnabled(false);
        btnIN1 = (RadioButton)findViewById(R.id.btnIN1);
        btnIN1.setEnabled(false);
        btnIN2 = (RadioButton)findViewById(R.id.btnIN2);
        btnIN2.setEnabled(false);
        btnIN3 = (RadioButton)findViewById(R.id.btnIN3);
        btnIN3.setEnabled(false);
        btnIN4 = (RadioButton)findViewById(R.id.btnIN4);
        btnIN4.setEnabled(false);
        btnIN5 = (RadioButton)findViewById(R.id.btnIN5);
        btnIN5.setEnabled(false);
        btnIN6 = (RadioButton)findViewById(R.id.btnIN6);
        btnIN6.setEnabled(false);
        btnO1 = (RadioButton)findViewById(R.id.btnOU1);
        btnO1.setEnabled(false);
        btnO2 = (RadioButton)findViewById(R.id.btnOU2);
        btnO2.setEnabled(false);
        btnM1 = (RadioButton)findViewById(R.id.btnME1);
        btnM1.setEnabled(false);
        btnM2 = (RadioButton)findViewById(R.id.btnME2);
        btnM2.setEnabled(false);
        btnAll = (RadioButton)findViewById(R.id.btnAll);
        btnAll.setEnabled(false);
        btnOff = (RadioButton)findViewById(R.id.btnOff);
        btnOff.setEnabled(false);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int vWidth = dm.widthPixels;
        int vHeight = dm.heightPixels;

        rg1.getLayoutParams().width = (int)((vWidth-214.2)/2);
        rg5.getLayoutParams().width=(int)((vWidth-214.2)/2);
        rg2.getLayoutParams().width = (int)(vWidth-214.2);
        rg6.getLayoutParams().width=(int)((vWidth-214.2)/2);
        rg3.getLayoutParams().width = (int)((vWidth-214.2)/2);
        rg4.getLayoutParams().width=(int)((vWidth-214.2)/2);

        //rg1.setOnCheckedChangeListener(radLis);
        //rg2.setOnCheckedChangeListener(radLis2);
    }

    @Override
    public void onStart()
    {
        super.onStart();
        /*
        String getIP1,getIP2,getIP3,getIP4,getIP5,getIP6,getOUT1,getOUT2;
        getIP1 = getSharedPreferences("Config", MODE_PRIVATE).getString("IP1","1");
        getIP2 = getSharedPreferences("Config", MODE_PRIVATE).getString("IP2","2");
        getIP3 = getSharedPreferences("Config", MODE_PRIVATE).getString("IP3","3");
        getIP4 = getSharedPreferences("Config", MODE_PRIVATE).getString("IP4","4");
        getIP5 = getSharedPreferences("Config", MODE_PRIVATE).getString("IP5","5");
        getIP6 = getSharedPreferences("Config", MODE_PRIVATE).getString("IP6","6");
        getOUT1 = getSharedPreferences("Config",MODE_PRIVATE).getString("OUT1","1");
        getOUT2 = getSharedPreferences("Config",MODE_PRIVATE).getString("OUT2","2");

        btnIN1.setText(getIP1);
        btnIN2.setText(getIP2);
        btnIN3.setText(getIP3);
        btnIN4.setText(getIP4);
        btnIN5.setText(getIP5);
        btnIN6.setText(getIP6);
        btnO1.setText(getOUT1);
        btnO2.setText(getOUT2);
        */
    }

    public Button.OnClickListener btnLis = new Button.OnClickListener()
    {
        public void onClick(View v)
        {

            switch (v.getId())
            {
                case R.id.btnLink:
                {

                    change.setClass(Main4Activity.this,ClientCode.class);
                    startActivity(change);
                    //overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
                    break;
                }
                case R.id.btnI:
                {

                    final ProgressDialog dialog = ProgressDialog.show(Main4Activity.this,
                            "Loading", "Please wait for 6 seconds...");
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                //progressBar.setVisibility(View.VISIBLE);
                                Thread.sleep(500);
                            } catch (Exception e) {
                                e.printStackTrace();
                            } finally {
                                dialog.dismiss();
                            }
                        }
                    }).start();
                    break;
                }
                case R.id.btnS:
                {

                    break;
                }
            }

        }
    };

}
