package user.example.hs_pc013.switchapi;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class MX_4UB extends ClientCode {

    ImageButton btnC;
    ImageButton btnF;
    ImageButton btnS;
    RadioGroup rgAV,rgIN,rgIN2,rgIN3,rgIN4,rgOP,rgOP2,rgOP3,rgOP4,rgME,rgAll;
    RadioButton btnA1;
    RadioButton btnA2;
    RadioButton btnIN1;
    RadioButton btnIN2;
    RadioButton btnIN3;
    RadioButton btnIN4;
    RadioButton btnIN5;
    RadioButton btnIN6;
    RadioButton btnIN7;
    RadioButton btnIN8;
    RadioButton btnIN9;
    RadioButton btnIN10;
    RadioButton btnIN11;
    RadioButton btnIN12;
    RadioButton btnIN13;
    RadioButton btnIN14;
    RadioButton btnIN15;
    RadioButton btnIN16;
    RadioButton btnO1;
    RadioButton btnO2;
    RadioButton btnO3;
    RadioButton btnO4;
    RadioButton btnO5;
    RadioButton btnO6;
    RadioButton btnO7;
    RadioButton btnO8;
    RadioButton btnO9;
    RadioButton btnO10;
    RadioButton btnO11;
    RadioButton btnO12;
    RadioButton btnO13;
    RadioButton btnO14;
    RadioButton btnO15;
    RadioButton btnO16;
    RadioButton btnM1;
    RadioButton btnM2;
    RadioButton btnAll,btnOff;
    TextView txtN,txtI;
    Intent change = new Intent();
    Intent Mation = new Intent();

    String IP2,TYPE;
    int PORT2;
    byte buff[] = new byte[4096];
    int Bhex[],BhexB[],BhexC[],BhexC1[],IVB[],DB[];
    String str1,str2,str3,str4,str5,str6,str7,str8,str9,str10,str11,str12,str13,str14,str15,str16;
    int a;
    String feedback[],bx,VerAB,VerA,VerB;
    int len,LB,INF,DN,CB,Ot,It,IB;
    char T[],TF[];
    String AorV = "";
    int InpuT=1,OutpuT;
    String inputString,inputString1,inputString2,inputString3,inputString4,inputString5,inputString6,inputString7,inputString8;
    byte Inp=0x01,OuT;
    String CrcS,CrcH;
    int CrcI;
    int xorCRC;
    int c;
    byte[] cb = new byte[4];
    byte[] byteCB = new byte[4];
    byte[] byteAV = new byte[5];
    String Protocol,Firmware;
    boolean EDID,SL;
    int MeTol;
    String getIP1,getIP2,getIP3,getIP4,getIP5,getIP6,getIP7,getIP8;
    String getIP9,getIP10,getIP11,getIP12,getIP13,getIP14,getIP15,getIP16;
    String getOUT1,getOUT2,getOUT3,getOUT4,getOUT5,getOUT6,getOUT7,getOUT8;
    String getOUT9,getOUT10,getOUT11,getOUT12,getOUT13,getOUT14,getOUT15,getOUT16;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mx_4_ub);

        rgAV = (RadioGroup)findViewById(R.id.segmentAV);
        rgIN = (RadioGroup)findViewById(R.id.segmentedIn);
        rgIN2 = (RadioGroup)findViewById(R.id.segmentInput2);
        rgIN3 = (RadioGroup)findViewById(R.id.segmentedIn3);
        rgIN4 = (RadioGroup)findViewById(R.id.segmentedIn4);

        rgOP = (RadioGroup)findViewById(R.id.segmentOutput);
        rgOP2 = (RadioGroup)findViewById(R.id.segmentOutput2);
        rgOP3 = (RadioGroup)findViewById(R.id.segmentOutput3);
        rgOP4 = (RadioGroup)findViewById(R.id.segmentOutput4);
        rgME = (RadioGroup)findViewById(R.id.segmentMe);
        rgAll = (RadioGroup)findViewById(R.id.segmentAll);

        rgAV.setOnCheckedChangeListener(radLis);
        rgIN.setOnCheckedChangeListener(radLis);
        rgIN2.setOnCheckedChangeListener(radLis);
        rgIN3.setOnCheckedChangeListener(radLis);
        rgIN4.setOnCheckedChangeListener(radLis);
        rgOP.setOnCheckedChangeListener(radLis);
        rgOP2.setOnCheckedChangeListener(radLis);
        rgOP3.setOnCheckedChangeListener(radLis);
        rgOP4.setOnCheckedChangeListener(radLis);
        rgME.setOnCheckedChangeListener(radLis);
        rgAll.setOnCheckedChangeListener(radLis);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int vWidth = dm.widthPixels;
        int vHeight = dm.heightPixels;

        rgAV.getLayoutParams().width = (int)((vWidth-214.2)/2);
        rgIN.getLayoutParams().width = (int)(vWidth-214.2);
        rgIN2.getLayoutParams().width = (int)(vWidth-214.2);
        rgIN3.getLayoutParams().width = (int)(vWidth-214.2);
        rgIN4.getLayoutParams().width = (int)(vWidth-214.2);
        rgAll.getLayoutParams().width=(int)((vWidth-214.2)/2);
        rgOP.getLayoutParams().width = (int)(vWidth-214.2);
        rgOP2.getLayoutParams().width = (int)(vWidth-214.2);
        rgOP3.getLayoutParams().width = (int)(vWidth-214.2);
        rgOP4.getLayoutParams().width = (int)(vWidth-214.2);
        rgME.getLayoutParams().width=(int)((vWidth-214.2)/2);

        btnC = (ImageButton) findViewById(R.id.btnLink);
        btnC.setOnClickListener(btnLis);
        btnC.setEnabled(true);

        btnF = (ImageButton) findViewById(R.id.btnI);
        btnF.setOnClickListener(btnLis);
        btnF.setEnabled(true);

        btnS = (ImageButton) findViewById(R.id.btnS);
        btnS.setOnClickListener(btnLis);
        btnS.setEnabled(true);

        btnA1 = (RadioButton) findViewById(R.id.btnAV1);
        btnA1.setEnabled(true);

        btnA2 = (RadioButton) findViewById(R.id.btnAV2);
        btnA2.setEnabled(true);

        btnIN1 = (RadioButton) findViewById(R.id.btnIN1);
        btnIN1.setEnabled(true);

        btnIN2 = (RadioButton) findViewById(R.id.btnIN2);
        btnIN2.setEnabled(true);

        btnIN3 = (RadioButton) findViewById(R.id.btnIN3);
        btnIN3.setEnabled(true);

        btnIN4 = (RadioButton) findViewById(R.id.btnIN4);
        btnIN4.setEnabled(true);

        btnIN5 = (RadioButton) findViewById(R.id.btnIN5);
        btnIN5.setEnabled(true);

        btnIN6 = (RadioButton) findViewById(R.id.btnIN6);
        btnIN6.setEnabled(true);

        btnIN7 = (RadioButton) findViewById(R.id.btnIN7);
        btnIN7.setEnabled(true);

        btnIN8 = (RadioButton) findViewById(R.id.btnIN8);
        btnIN8.setEnabled(true);

        btnIN9 = (RadioButton) findViewById(R.id.btnIN9);
        btnIN9.setEnabled(true);

        btnIN10 = (RadioButton) findViewById(R.id.btnIN10);
        btnIN10.setEnabled(true);

        btnIN11 = (RadioButton) findViewById(R.id.btnIN11);
        btnIN11.setEnabled(true);

        btnIN12 = (RadioButton) findViewById(R.id.btnIN12);
        btnIN12.setEnabled(true);

        btnIN13 = (RadioButton) findViewById(R.id.btnIN13);
        btnIN13.setEnabled(true);

        btnIN14 = (RadioButton) findViewById(R.id.btnIN14);
        btnIN14.setEnabled(true);

        btnIN15 = (RadioButton) findViewById(R.id.btnIN15);
        btnIN15.setEnabled(true);

        btnIN16 = (RadioButton) findViewById(R.id.btnIN16);
        btnIN16.setEnabled(true);

        btnO1 = (RadioButton) findViewById(R.id.btnOU1);
        btnO1.setEnabled(true);

        btnO2 = (RadioButton) findViewById(R.id.btnOU2);
        btnO2.setEnabled(true);

        btnO3 = (RadioButton) findViewById(R.id.btnOU3);
        btnO3.setEnabled(true);

        btnO4 = (RadioButton) findViewById(R.id.btnOU4);
        btnO4.setEnabled(true);

        btnO5 = (RadioButton) findViewById(R.id.btnOU5);
        btnO5.setEnabled(true);

        btnO6 = (RadioButton) findViewById(R.id.btnOU6);
        btnO6.setEnabled(true);

        btnO7 = (RadioButton) findViewById(R.id.btnOU7);
        btnO7.setEnabled(true);

        btnO8 = (RadioButton) findViewById(R.id.btnOU8);
        btnO8.setEnabled(true);

        btnO9 = (RadioButton) findViewById(R.id.btnOU9);
        btnO9.setEnabled(true);

        btnO10 = (RadioButton) findViewById(R.id.btnOU10);
        btnO10.setEnabled(true);

        btnO11 = (RadioButton) findViewById(R.id.btnOU11);
        btnO11.setEnabled(true);

        btnO12 = (RadioButton) findViewById(R.id.btnOU12);
        btnO12.setEnabled(true);

        btnO13 = (RadioButton) findViewById(R.id.btnOU13);
        btnO13.setEnabled(true);

        btnO14 = (RadioButton) findViewById(R.id.btnOU14);
        btnO14.setEnabled(true);

        btnO15 = (RadioButton) findViewById(R.id.btnOU15);
        btnO15.setEnabled(true);

        btnO16 = (RadioButton) findViewById(R.id.btnOU16);
        btnO16.setEnabled(true);

        btnM1 = (RadioButton) findViewById(R.id.btnME1);
        btnM1.setEnabled(true);

        btnM2 = (RadioButton) findViewById(R.id.btnME2);
        btnM2.setEnabled(true);
        btnAll = (RadioButton)findViewById(R.id.btnAll);
        btnOff = (RadioButton)findViewById(R.id.btnOff);

        txtI = (TextView) findViewById(R.id.txtIPNAME);
        txtN = (TextView) findViewById(R.id.txtName);

        Intent intent2 = this.getIntent();
        final Bundle bundle = intent2.getExtras();
        final String ip = bundle.getString("IP");
        final int port = bundle.getInt("PORT");
        String devicename = bundle.getString("DeviceName");
        //String back[] = bundle.getStringArray("Feedback");

        IP2 = ip;
        PORT2 = port;
        txtI.setText("       IP: " + ip);
        txtN.setText("Name: " + devicename);
        TYPE = devicename;
        runSocket();
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////   Button   /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public Button.OnClickListener btnLis = new Button.OnClickListener()
    {
        public void onClick(View v)
        {

            switch (v.getId())
            {
                case R.id.btnLink:
                {

                    change.setClass(MX_4UB.this,ClientCode.class);

                    startActivity(change);
                    break;
                }
                case R.id.btnI:
                {

                    startActivity(Mation);
                    break;
                }
                case R.id.btnS:
                {
                    Input1 = btnIN1.getText().toString();
                    Input2 = btnIN2.getText().toString();
                    Input3 = btnIN3.getText().toString();
                    Input4 = btnIN4.getText().toString();
                    Input5 = btnIN5.getText().toString();
                    Input6 = btnIN6.getText().toString();
                    Input7 = btnIN7.getText().toString();
                    Input8 = btnIN8.getText().toString();
                    Input9 = btnIN9.getText().toString();
                    Input10 = btnIN10.getText().toString();
                    Input11 = btnIN11.getText().toString();
                    Input12 = btnIN12.getText().toString();
                    Input13 = btnIN13.getText().toString();
                    Input14 = btnIN14.getText().toString();
                    Input15 = btnIN15.getText().toString();
                    Input16 = btnIN16.getText().toString();

                    Output1 = btnO1.getText().toString();
                    Output2 = btnO2.getText().toString();
                    Output3 = btnO3.getText().toString();
                    Output4 = btnO4.getText().toString();
                    Output5 = btnO5.getText().toString();
                    Output6 = btnO6.getText().toString();
                    Output7 = btnO7.getText().toString();
                    Output8 = btnO8.getText().toString();
                    Output9 = btnO9.getText().toString();
                    Output10 = btnO10.getText().toString();
                    Output11 = btnO11.getText().toString();
                    Output12 = btnO12.getText().toString();
                    Output13 = btnO13.getText().toString();
                    Output14 = btnO14.getText().toString();
                    Output15 = btnO15.getText().toString();
                    Output16 = btnO16.getText().toString();

                    change.setClass(MX_4UB.this,SettingConfig4UB.class);
                    Bundle bundleConSet = new Bundle();
                    bundleConSet.putString("In1",Input1);
                    bundleConSet.putString("In2",Input2);
                    bundleConSet.putString("In3",Input3);
                    bundleConSet.putString("In4",Input4);
                    bundleConSet.putString("In5",Input5);
                    bundleConSet.putString("In6",Input6);
                    bundleConSet.putString("In7",Input7);
                    bundleConSet.putString("In8",Input8);
                    bundleConSet.putString("In9",Input9);
                    bundleConSet.putString("In10",Input10);
                    bundleConSet.putString("In11",Input11);
                    bundleConSet.putString("In12",Input12);
                    bundleConSet.putString("In13",Input13);
                    bundleConSet.putString("In14",Input14);
                    bundleConSet.putString("In15",Input15);
                    bundleConSet.putString("In16",Input16);
                    bundleConSet.putString("Out1",getOUT1);
                    bundleConSet.putString("Out2",getOUT2);
                    bundleConSet.putString("Out3",getOUT3);
                    bundleConSet.putString("Out4",getOUT4);
                    bundleConSet.putString("Out5",getOUT5);
                    bundleConSet.putString("Out6",getOUT6);
                    bundleConSet.putString("Out7",getOUT7);
                    bundleConSet.putString("Out8",getOUT8);
                    bundleConSet.putString("Out9",getOUT9);
                    bundleConSet.putString("Out10",getOUT10);
                    bundleConSet.putString("Out11",getOUT11);
                    bundleConSet.putString("Out12",getOUT12);
                    bundleConSet.putString("Out13",getOUT13);
                    bundleConSet.putString("Out14",getOUT14);
                    bundleConSet.putString("Out15",getOUT15);
                    bundleConSet.putString("Out16",getOUT16);
                    bundleConSet.putString("Type",TYPE);

                    change.putExtras(bundleConSet);
                    startActivity(change);
                    break;
                }

            }

        }
    };
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public RadioGroup.OnCheckedChangeListener radLis = new RadioGroup.OnCheckedChangeListener()
    {
        public void onCheckedChanged(RadioGroup radioGroup,int checkedId)
        {
            switch (checkedId)
            {
                case R.id.btnAV1:
                {
                    btnA1.setTextColor(Color.parseColor("#ffffff"));
                    btnA2.setTextColor(Color.parseColor("#c90000"));
                    AorV = "Video";

                    break;
                }
                case R.id.btnAV2:
                {
                    btnA2.setTextColor(Color.parseColor("#ffffff"));
                    btnA1.setTextColor(Color.parseColor("#c90000"));
                    AorV = "Setting";

                    change.setClass(MX_4UB.this, AV_Setting_MX.class);
                    Bundle bundleSet = new Bundle();
                    bundleSet.putString("Type",TYPE);
                    change.putExtras(bundleSet);

                    startActivity(change);

                    break;
                }
                case R.id.btnIN1:
                {
                    btnIN1.setTextColor(Color.parseColor("#ffffff"));
                    btnIN2.setTextColor(Color.parseColor("#c90000"));
                    btnIN3.setTextColor(Color.parseColor("#c90000"));
                    btnIN4.setTextColor(Color.parseColor("#c90000"));
                    btnIN5.setTextColor(Color.parseColor("#c90000"));
                    btnIN6.setTextColor(Color.parseColor("#c90000"));
                    btnIN7.setTextColor(Color.parseColor("#c90000"));
                    btnIN8.setTextColor(Color.parseColor("#c90000"));
                    btnIN9.setTextColor(Color.parseColor("#c90000"));
                    btnIN10.setTextColor(Color.parseColor("#c90000"));
                    btnIN11.setTextColor(Color.parseColor("#c90000"));
                    btnIN12.setTextColor(Color.parseColor("#c90000"));
                    btnIN13.setTextColor(Color.parseColor("#c90000"));
                    btnIN14.setTextColor(Color.parseColor("#c90000"));
                    btnIN15.setTextColor(Color.parseColor("#c90000"));
                    btnIN16.setTextColor(Color.parseColor("#c90000"));

                    InpuT = 1;
                    Inp = 0x01;
                    inputString = btnIN1.getText().toString();
                    LastInput4UB = 1;
                    rgIN2.clearCheck();
                    rgIN3.clearCheck();
                    rgIN4.clearCheck();
                    rgIN.check(R.id.btnIN1);

                    break;
                }
                case R.id.btnIN2:
                {
                    btnIN2.setTextColor(Color.parseColor("#ffffff"));
                    btnIN1.setTextColor(Color.parseColor("#c90000"));
                    btnIN3.setTextColor(Color.parseColor("#c90000"));
                    btnIN4.setTextColor(Color.parseColor("#c90000"));
                    btnIN5.setTextColor(Color.parseColor("#c90000"));
                    btnIN6.setTextColor(Color.parseColor("#c90000"));
                    btnIN7.setTextColor(Color.parseColor("#c90000"));
                    btnIN8.setTextColor(Color.parseColor("#c90000"));
                    btnIN9.setTextColor(Color.parseColor("#c90000"));
                    btnIN10.setTextColor(Color.parseColor("#c90000"));
                    btnIN11.setTextColor(Color.parseColor("#c90000"));
                    btnIN12.setTextColor(Color.parseColor("#c90000"));
                    btnIN13.setTextColor(Color.parseColor("#c90000"));
                    btnIN14.setTextColor(Color.parseColor("#c90000"));
                    btnIN15.setTextColor(Color.parseColor("#c90000"));
                    btnIN16.setTextColor(Color.parseColor("#c90000"));

                    InpuT = 2;
                    Inp = 0x02;
                    inputString = btnIN2.getText().toString();
                    LastInput4UB = 2;
                    rgIN2.clearCheck();
                    rgIN3.clearCheck();
                    rgIN4.clearCheck();
                    rgIN.check(R.id.btnIN2);

                    break;
                }
                case R.id.btnIN3:
                {
                    btnIN3.setTextColor(Color.parseColor("#ffffff"));
                    btnIN2.setTextColor(Color.parseColor("#c90000"));
                    btnIN1.setTextColor(Color.parseColor("#c90000"));
                    btnIN4.setTextColor(Color.parseColor("#c90000"));
                    btnIN5.setTextColor(Color.parseColor("#c90000"));
                    btnIN6.setTextColor(Color.parseColor("#c90000"));
                    btnIN7.setTextColor(Color.parseColor("#c90000"));
                    btnIN8.setTextColor(Color.parseColor("#c90000"));
                    btnIN9.setTextColor(Color.parseColor("#c90000"));
                    btnIN10.setTextColor(Color.parseColor("#c90000"));
                    btnIN11.setTextColor(Color.parseColor("#c90000"));
                    btnIN12.setTextColor(Color.parseColor("#c90000"));
                    btnIN13.setTextColor(Color.parseColor("#c90000"));
                    btnIN14.setTextColor(Color.parseColor("#c90000"));
                    btnIN15.setTextColor(Color.parseColor("#c90000"));
                    btnIN16.setTextColor(Color.parseColor("#c90000"));

                    InpuT = 3;
                    Inp = 0x03;
                    inputString = btnIN3.getText().toString();
                    LastInput4UB = 3;
                    rgIN2.clearCheck();
                    rgIN3.clearCheck();
                    rgIN4.clearCheck();
                    rgIN.check(R.id.btnIN3);

                    break;
                }
                case R.id.btnIN4:
                {
                    btnIN4.setTextColor(Color.parseColor("#ffffff"));
                    btnIN2.setTextColor(Color.parseColor("#c90000"));
                    btnIN3.setTextColor(Color.parseColor("#c90000"));
                    btnIN1.setTextColor(Color.parseColor("#c90000"));
                    btnIN5.setTextColor(Color.parseColor("#c90000"));
                    btnIN6.setTextColor(Color.parseColor("#c90000"));
                    btnIN7.setTextColor(Color.parseColor("#c90000"));
                    btnIN8.setTextColor(Color.parseColor("#c90000"));
                    btnIN9.setTextColor(Color.parseColor("#c90000"));
                    btnIN10.setTextColor(Color.parseColor("#c90000"));
                    btnIN11.setTextColor(Color.parseColor("#c90000"));
                    btnIN12.setTextColor(Color.parseColor("#c90000"));
                    btnIN13.setTextColor(Color.parseColor("#c90000"));
                    btnIN14.setTextColor(Color.parseColor("#c90000"));
                    btnIN15.setTextColor(Color.parseColor("#c90000"));
                    btnIN16.setTextColor(Color.parseColor("#c90000"));

                    InpuT = 4;
                    Inp = 0x04;
                    inputString = btnIN4.getText().toString();
                    LastInput4UB = 4;
                    rgIN2.clearCheck();
                    rgIN3.clearCheck();
                    rgIN4.clearCheck();
                    rgIN.check(R.id.btnIN4);

                    break;
                }
                case R.id.btnIN5:
                {
                    btnIN5.setTextColor(Color.parseColor("#ffffff"));
                    btnIN2.setTextColor(Color.parseColor("#c90000"));
                    btnIN3.setTextColor(Color.parseColor("#c90000"));
                    btnIN4.setTextColor(Color.parseColor("#c90000"));
                    btnIN1.setTextColor(Color.parseColor("#c90000"));
                    btnIN6.setTextColor(Color.parseColor("#c90000"));
                    btnIN7.setTextColor(Color.parseColor("#c90000"));
                    btnIN8.setTextColor(Color.parseColor("#c90000"));
                    btnIN9.setTextColor(Color.parseColor("#c90000"));
                    btnIN10.setTextColor(Color.parseColor("#c90000"));
                    btnIN11.setTextColor(Color.parseColor("#c90000"));
                    btnIN12.setTextColor(Color.parseColor("#c90000"));
                    btnIN13.setTextColor(Color.parseColor("#c90000"));
                    btnIN14.setTextColor(Color.parseColor("#c90000"));
                    btnIN15.setTextColor(Color.parseColor("#c90000"));
                    btnIN16.setTextColor(Color.parseColor("#c90000"));

                    InpuT = 5;
                    Inp = 0x05;
                    inputString = btnIN5.getText().toString();
                    LastInput4UB = 5;
                    rgIN.clearCheck();
                    rgIN3.clearCheck();
                    rgIN4.clearCheck();
                    rgIN2.check(R.id.btnIN5);

                    break;
                }
                case R.id.btnIN6:
                {
                    btnIN6.setTextColor(Color.parseColor("#ffffff"));
                    btnIN2.setTextColor(Color.parseColor("#c90000"));
                    btnIN3.setTextColor(Color.parseColor("#c90000"));
                    btnIN4.setTextColor(Color.parseColor("#c90000"));
                    btnIN5.setTextColor(Color.parseColor("#c90000"));
                    btnIN1.setTextColor(Color.parseColor("#c90000"));
                    btnIN7.setTextColor(Color.parseColor("#c90000"));
                    btnIN8.setTextColor(Color.parseColor("#c90000"));
                    btnIN9.setTextColor(Color.parseColor("#c90000"));
                    btnIN10.setTextColor(Color.parseColor("#c90000"));
                    btnIN11.setTextColor(Color.parseColor("#c90000"));
                    btnIN12.setTextColor(Color.parseColor("#c90000"));
                    btnIN13.setTextColor(Color.parseColor("#c90000"));
                    btnIN14.setTextColor(Color.parseColor("#c90000"));
                    btnIN15.setTextColor(Color.parseColor("#c90000"));
                    btnIN16.setTextColor(Color.parseColor("#c90000"));

                    InpuT = 6;
                    Inp = 0x06;
                    inputString = btnIN6.getText().toString();
                    LastInput4UB = 6;
                    rgIN.clearCheck();
                    rgIN3.clearCheck();
                    rgIN4.clearCheck();
                    rgIN2.check(R.id.btnIN6);

                    break;
                }
                case R.id.btnIN7:
                {
                    btnIN7.setTextColor(Color.parseColor("#ffffff"));
                    btnIN2.setTextColor(Color.parseColor("#c90000"));
                    btnIN3.setTextColor(Color.parseColor("#c90000"));
                    btnIN4.setTextColor(Color.parseColor("#c90000"));
                    btnIN5.setTextColor(Color.parseColor("#c90000"));
                    btnIN1.setTextColor(Color.parseColor("#c90000"));
                    btnIN6.setTextColor(Color.parseColor("#c90000"));
                    btnIN8.setTextColor(Color.parseColor("#c90000"));
                    btnIN9.setTextColor(Color.parseColor("#c90000"));
                    btnIN10.setTextColor(Color.parseColor("#c90000"));
                    btnIN11.setTextColor(Color.parseColor("#c90000"));
                    btnIN12.setTextColor(Color.parseColor("#c90000"));
                    btnIN13.setTextColor(Color.parseColor("#c90000"));
                    btnIN14.setTextColor(Color.parseColor("#c90000"));
                    btnIN15.setTextColor(Color.parseColor("#c90000"));
                    btnIN16.setTextColor(Color.parseColor("#c90000"));

                    InpuT = 7;
                    Inp = 0x07;
                    inputString = btnIN7.getText().toString();
                    LastInput4UB = 7;
                    rgIN.clearCheck();
                    rgIN3.clearCheck();
                    rgIN4.clearCheck();
                    rgIN2.check(R.id.btnIN7);

                    break;
                }
                case R.id.btnIN8:
                {
                    btnIN8.setTextColor(Color.parseColor("#ffffff"));
                    btnIN2.setTextColor(Color.parseColor("#c90000"));
                    btnIN3.setTextColor(Color.parseColor("#c90000"));
                    btnIN4.setTextColor(Color.parseColor("#c90000"));
                    btnIN5.setTextColor(Color.parseColor("#c90000"));
                    btnIN1.setTextColor(Color.parseColor("#c90000"));
                    btnIN7.setTextColor(Color.parseColor("#c90000"));
                    btnIN6.setTextColor(Color.parseColor("#c90000"));
                    btnIN9.setTextColor(Color.parseColor("#c90000"));
                    btnIN10.setTextColor(Color.parseColor("#c90000"));
                    btnIN11.setTextColor(Color.parseColor("#c90000"));
                    btnIN12.setTextColor(Color.parseColor("#c90000"));
                    btnIN13.setTextColor(Color.parseColor("#c90000"));
                    btnIN14.setTextColor(Color.parseColor("#c90000"));
                    btnIN15.setTextColor(Color.parseColor("#c90000"));
                    btnIN16.setTextColor(Color.parseColor("#c90000"));

                    InpuT = 8;
                    Inp = 0x08;
                    inputString = btnIN8.getText().toString();
                    LastInput4UB = 8;
                    rgIN.clearCheck();
                    rgIN3.clearCheck();
                    rgIN4.clearCheck();
                    rgIN2.check(R.id.btnIN8);

                    break;
                }
                case R.id.btnIN9:
                {
                    btnIN9.setTextColor(Color.parseColor("#ffffff"));
                    btnIN2.setTextColor(Color.parseColor("#c90000"));
                    btnIN3.setTextColor(Color.parseColor("#c90000"));
                    btnIN4.setTextColor(Color.parseColor("#c90000"));
                    btnIN5.setTextColor(Color.parseColor("#c90000"));
                    btnIN1.setTextColor(Color.parseColor("#c90000"));
                    btnIN7.setTextColor(Color.parseColor("#c90000"));
                    btnIN6.setTextColor(Color.parseColor("#c90000"));
                    btnIN8.setTextColor(Color.parseColor("#c90000"));
                    btnIN10.setTextColor(Color.parseColor("#c90000"));
                    btnIN11.setTextColor(Color.parseColor("#c90000"));
                    btnIN12.setTextColor(Color.parseColor("#c90000"));
                    btnIN13.setTextColor(Color.parseColor("#c90000"));
                    btnIN14.setTextColor(Color.parseColor("#c90000"));
                    btnIN15.setTextColor(Color.parseColor("#c90000"));
                    btnIN16.setTextColor(Color.parseColor("#c90000"));

                    InpuT = 9;
                    Inp = 0x09;
                    inputString = btnIN9.getText().toString();
                    LastInput4UB = 9;
                    rgIN.clearCheck();
                    rgIN2.clearCheck();
                    rgIN4.clearCheck();
                    rgIN3.check(R.id.btnIN9);

                    break;
                }
                case R.id.btnIN10:
                {
                    btnIN10.setTextColor(Color.parseColor("#ffffff"));
                    btnIN2.setTextColor(Color.parseColor("#c90000"));
                    btnIN3.setTextColor(Color.parseColor("#c90000"));
                    btnIN4.setTextColor(Color.parseColor("#c90000"));
                    btnIN5.setTextColor(Color.parseColor("#c90000"));
                    btnIN1.setTextColor(Color.parseColor("#c90000"));
                    btnIN7.setTextColor(Color.parseColor("#c90000"));
                    btnIN6.setTextColor(Color.parseColor("#c90000"));
                    btnIN8.setTextColor(Color.parseColor("#c90000"));
                    btnIN9.setTextColor(Color.parseColor("#c90000"));
                    btnIN11.setTextColor(Color.parseColor("#c90000"));
                    btnIN12.setTextColor(Color.parseColor("#c90000"));
                    btnIN13.setTextColor(Color.parseColor("#c90000"));
                    btnIN14.setTextColor(Color.parseColor("#c90000"));
                    btnIN15.setTextColor(Color.parseColor("#c90000"));
                    btnIN16.setTextColor(Color.parseColor("#c90000"));

                    InpuT = 10;
                    Inp = 0x0a;
                    inputString = btnIN10.getText().toString();
                    LastInput4UB = 10;
                    rgIN.clearCheck();
                    rgIN2.clearCheck();
                    rgIN4.clearCheck();
                    rgIN3.check(R.id.btnIN10);

                    break;
                }
                case R.id.btnIN11:
                {
                    btnIN11.setTextColor(Color.parseColor("#ffffff"));
                    btnIN2.setTextColor(Color.parseColor("#c90000"));
                    btnIN3.setTextColor(Color.parseColor("#c90000"));
                    btnIN4.setTextColor(Color.parseColor("#c90000"));
                    btnIN5.setTextColor(Color.parseColor("#c90000"));
                    btnIN1.setTextColor(Color.parseColor("#c90000"));
                    btnIN7.setTextColor(Color.parseColor("#c90000"));
                    btnIN6.setTextColor(Color.parseColor("#c90000"));
                    btnIN8.setTextColor(Color.parseColor("#c90000"));
                    btnIN10.setTextColor(Color.parseColor("#c90000"));
                    btnIN9.setTextColor(Color.parseColor("#c90000"));
                    btnIN12.setTextColor(Color.parseColor("#c90000"));
                    btnIN13.setTextColor(Color.parseColor("#c90000"));
                    btnIN14.setTextColor(Color.parseColor("#c90000"));
                    btnIN15.setTextColor(Color.parseColor("#c90000"));
                    btnIN16.setTextColor(Color.parseColor("#c90000"));

                    InpuT = 11;
                    Inp = 0x0b;
                    inputString = btnIN11.getText().toString();
                    LastInput4UB = 11;
                    rgIN.clearCheck();
                    rgIN2.clearCheck();
                    rgIN4.clearCheck();
                    rgIN3.check(R.id.btnIN11);

                    break;
                }
                case R.id.btnIN12:
                {
                    btnIN12.setTextColor(Color.parseColor("#ffffff"));
                    btnIN2.setTextColor(Color.parseColor("#c90000"));
                    btnIN3.setTextColor(Color.parseColor("#c90000"));
                    btnIN4.setTextColor(Color.parseColor("#c90000"));
                    btnIN5.setTextColor(Color.parseColor("#c90000"));
                    btnIN1.setTextColor(Color.parseColor("#c90000"));
                    btnIN7.setTextColor(Color.parseColor("#c90000"));
                    btnIN6.setTextColor(Color.parseColor("#c90000"));
                    btnIN8.setTextColor(Color.parseColor("#c90000"));
                    btnIN10.setTextColor(Color.parseColor("#c90000"));
                    btnIN11.setTextColor(Color.parseColor("#c90000"));
                    btnIN9.setTextColor(Color.parseColor("#c90000"));
                    btnIN13.setTextColor(Color.parseColor("#c90000"));
                    btnIN14.setTextColor(Color.parseColor("#c90000"));
                    btnIN15.setTextColor(Color.parseColor("#c90000"));
                    btnIN16.setTextColor(Color.parseColor("#c90000"));

                    InpuT = 12;
                    Inp = 0x0c;
                    inputString = btnIN12.getText().toString();
                    LastInput4UB = 12;
                    rgIN.clearCheck();
                    rgIN2.clearCheck();
                    rgIN4.clearCheck();
                    rgIN3.check(R.id.btnIN12);

                    break;
                }
                case R.id.btnIN13:
                {
                    btnIN13.setTextColor(Color.parseColor("#ffffff"));
                    btnIN2.setTextColor(Color.parseColor("#c90000"));
                    btnIN3.setTextColor(Color.parseColor("#c90000"));
                    btnIN4.setTextColor(Color.parseColor("#c90000"));
                    btnIN5.setTextColor(Color.parseColor("#c90000"));
                    btnIN1.setTextColor(Color.parseColor("#c90000"));
                    btnIN7.setTextColor(Color.parseColor("#c90000"));
                    btnIN6.setTextColor(Color.parseColor("#c90000"));
                    btnIN8.setTextColor(Color.parseColor("#c90000"));
                    btnIN10.setTextColor(Color.parseColor("#c90000"));
                    btnIN11.setTextColor(Color.parseColor("#c90000"));
                    btnIN12.setTextColor(Color.parseColor("#c90000"));
                    btnIN9.setTextColor(Color.parseColor("#c90000"));
                    btnIN14.setTextColor(Color.parseColor("#c90000"));
                    btnIN15.setTextColor(Color.parseColor("#c90000"));
                    btnIN16.setTextColor(Color.parseColor("#c90000"));

                    InpuT = 13;
                    Inp = 0x0d;
                    inputString = btnIN13.getText().toString();
                    LastInput4UB = 13;
                    rgIN.clearCheck();
                    rgIN2.clearCheck();
                    rgIN3.clearCheck();
                    rgIN4.check(R.id.btnIN13);

                    break;
                }
                case R.id.btnIN14:
                {
                    btnIN14.setTextColor(Color.parseColor("#ffffff"));
                    btnIN2.setTextColor(Color.parseColor("#c90000"));
                    btnIN3.setTextColor(Color.parseColor("#c90000"));
                    btnIN4.setTextColor(Color.parseColor("#c90000"));
                    btnIN5.setTextColor(Color.parseColor("#c90000"));
                    btnIN1.setTextColor(Color.parseColor("#c90000"));
                    btnIN7.setTextColor(Color.parseColor("#c90000"));
                    btnIN6.setTextColor(Color.parseColor("#c90000"));
                    btnIN8.setTextColor(Color.parseColor("#c90000"));
                    btnIN10.setTextColor(Color.parseColor("#c90000"));
                    btnIN11.setTextColor(Color.parseColor("#c90000"));
                    btnIN12.setTextColor(Color.parseColor("#c90000"));
                    btnIN9.setTextColor(Color.parseColor("#c90000"));
                    btnIN13.setTextColor(Color.parseColor("#c90000"));
                    btnIN15.setTextColor(Color.parseColor("#c90000"));
                    btnIN16.setTextColor(Color.parseColor("#c90000"));

                    InpuT = 14;
                    Inp = 0x0e;
                    inputString = btnIN14.getText().toString();
                    LastInput4UB = 14;
                    rgIN.clearCheck();
                    rgIN2.clearCheck();
                    rgIN3.clearCheck();
                    rgIN4.check(R.id.btnIN14);

                    break;
                }
                case R.id.btnIN15:
                {
                    btnIN15.setTextColor(Color.parseColor("#ffffff"));
                    btnIN2.setTextColor(Color.parseColor("#c90000"));
                    btnIN3.setTextColor(Color.parseColor("#c90000"));
                    btnIN4.setTextColor(Color.parseColor("#c90000"));
                    btnIN5.setTextColor(Color.parseColor("#c90000"));
                    btnIN1.setTextColor(Color.parseColor("#c90000"));
                    btnIN7.setTextColor(Color.parseColor("#c90000"));
                    btnIN6.setTextColor(Color.parseColor("#c90000"));
                    btnIN8.setTextColor(Color.parseColor("#c90000"));
                    btnIN10.setTextColor(Color.parseColor("#c90000"));
                    btnIN11.setTextColor(Color.parseColor("#c90000"));
                    btnIN12.setTextColor(Color.parseColor("#c90000"));
                    btnIN9.setTextColor(Color.parseColor("#c90000"));
                    btnIN14.setTextColor(Color.parseColor("#c90000"));
                    btnIN13.setTextColor(Color.parseColor("#c90000"));
                    btnIN16.setTextColor(Color.parseColor("#c90000"));

                    InpuT = 15;
                    Inp = 0x0f;
                    inputString = btnIN15.getText().toString();
                    LastInput4UB = 15;
                    rgIN.clearCheck();
                    rgIN2.clearCheck();
                    rgIN3.clearCheck();
                    rgIN4.check(R.id.btnIN15);

                    break;
                }
                case R.id.btnIN16:
                {
                    btnIN16.setTextColor(Color.parseColor("#ffffff"));
                    btnIN2.setTextColor(Color.parseColor("#c90000"));
                    btnIN3.setTextColor(Color.parseColor("#c90000"));
                    btnIN4.setTextColor(Color.parseColor("#c90000"));
                    btnIN5.setTextColor(Color.parseColor("#c90000"));
                    btnIN1.setTextColor(Color.parseColor("#c90000"));
                    btnIN7.setTextColor(Color.parseColor("#c90000"));
                    btnIN6.setTextColor(Color.parseColor("#c90000"));
                    btnIN8.setTextColor(Color.parseColor("#c90000"));
                    btnIN10.setTextColor(Color.parseColor("#c90000"));
                    btnIN11.setTextColor(Color.parseColor("#c90000"));
                    btnIN12.setTextColor(Color.parseColor("#c90000"));
                    btnIN9.setTextColor(Color.parseColor("#c90000"));
                    btnIN14.setTextColor(Color.parseColor("#c90000"));
                    btnIN15.setTextColor(Color.parseColor("#c90000"));
                    btnIN13.setTextColor(Color.parseColor("#c90000"));

                    InpuT = 16;
                    Inp = 0x10;
                    inputString = btnIN16.getText().toString();
                    LastInput4UB = 16;
                    rgIN.clearCheck();
                    rgIN2.clearCheck();
                    rgIN3.clearCheck();
                    rgIN4.check(R.id.btnIN16);

                    break;
                }
                case R.id.btnOU1:
                {

                    if (AorV.equals("Video") || AorV.equals("Audio") || AorV.equals("")) {

                        OutpuT = 1;
                        OuT = 0x01;

                        btnO1.setText(getOUT1+"("+"V"+":"+inputString+")");

                        byteCB = new byte[]{0x20, 0x01, OuT, Inp};

                        CrcTraFor(byteCB);

                        byteAV = new byte[]{0x20, 0x01, OuT, Inp, cb[3]};
                        SwitchAV(byteAV);

                    }
                    else
                    {
                        Toast.makeText(MX_4UB.this, "You choose the wrong button  " + AorV + " please change", Toast.LENGTH_LONG).show();
                    }

                    break;
                }
                case R.id.btnOU2:
                {

                    if (AorV.equals("Video") || AorV.equals("Audio") || AorV.equals("")) {

                        OutpuT = 2;
                        OuT = 0x02;

                        btnO2.setText(getOUT2+"("+"V"+":"+inputString+")");

                        byteCB = new byte[]{0x20, 0x01, OuT, Inp};

                        CrcTraFor(byteCB);

                        byteAV = new byte[]{0x20, 0x01, OuT, Inp, cb[3]};
                        SwitchAV(byteAV);

                    }
                    else
                    {
                        Toast.makeText(MX_4UB.this, "You choose the wrong button  " + AorV + " please change", Toast.LENGTH_LONG).show();
                    }

                    break;
                }
                case R.id.btnOU3:
                {

                    if (AorV.equals("Video") || AorV.equals("Audio") || AorV.equals("")) {

                        OutpuT = 3;
                        OuT = 0x03;

                        btnO3.setText(getOUT3+"("+"V"+":"+inputString+")");

                        byteCB = new byte[]{0x20, 0x01, OuT, Inp};

                        CrcTraFor(byteCB);

                        byteAV = new byte[]{0x20, 0x01, OuT, Inp, cb[3]};
                        SwitchAV(byteAV);

                    }
                    else
                    {
                        Toast.makeText(MX_4UB.this, "You choose the wrong button  " + AorV + " please change", Toast.LENGTH_LONG).show();
                    }

                    break;
                }
                case R.id.btnOU4:
                {

                    if (AorV.equals("Video") || AorV.equals("Audio") || AorV.equals("")) {

                        OutpuT = 4;
                        OuT = 0x04;

                        btnO4.setText(getOUT4+"("+"V"+":"+inputString+")");

                        byteCB = new byte[]{0x20, 0x01, OuT, Inp};

                        CrcTraFor(byteCB);

                        byteAV = new byte[]{0x20, 0x01, OuT, Inp, cb[3]};
                        SwitchAV(byteAV);

                    }
                    else
                    {
                        Toast.makeText(MX_4UB.this, "You choose the wrong button  " + AorV + " please change", Toast.LENGTH_LONG).show();
                    }

                    break;
                }
                case R.id.btnOU5:
                {

                    if (AorV.equals("Video") || AorV.equals("Audio") || AorV.equals("")) {

                        OutpuT = 5;
                        OuT = 0x05;

                        btnO5.setText(getOUT5+"("+"V"+":"+inputString+")");

                        byteCB = new byte[]{0x20, 0x01, OuT, Inp};

                        CrcTraFor(byteCB);

                        byteAV = new byte[]{0x20, 0x01, OuT, Inp, cb[3]};
                        SwitchAV(byteAV);

                    }
                    else
                    {
                        Toast.makeText(MX_4UB.this, "You choose the wrong button  " + AorV + " please change", Toast.LENGTH_LONG).show();
                    }

                    break;
                }
                case R.id.btnOU6:
                {

                    if (AorV.equals("Video") || AorV.equals("Audio") || AorV.equals("")) {

                        OutpuT = 6;
                        OuT = 0x06;

                        btnO6.setText(getOUT6+"("+"V"+":"+inputString+")");

                        byteCB = new byte[]{0x20, 0x01, OuT, Inp};

                        CrcTraFor(byteCB);

                        byteAV = new byte[]{0x20, 0x01, OuT, Inp, cb[3]};
                        SwitchAV(byteAV);

                    }
                    else
                    {
                        Toast.makeText(MX_4UB.this, "You choose the wrong button  " + AorV + " please change", Toast.LENGTH_LONG).show();
                    }

                    break;
                }
                case R.id.btnOU7:
                {

                    if (AorV.equals("Video") || AorV.equals("Audio") || AorV.equals("")) {

                        OutpuT = 7;
                        OuT = 0x07;

                        btnO7.setText(getOUT7+"("+"V"+":"+inputString+")");

                        byteCB = new byte[]{0x20, 0x01, OuT, Inp};

                        CrcTraFor(byteCB);

                        byteAV = new byte[]{0x20, 0x01, OuT, Inp, cb[3]};
                        SwitchAV(byteAV);

                    }
                    else
                    {
                        Toast.makeText(MX_4UB.this, "You choose the wrong button  " + AorV + " please change", Toast.LENGTH_LONG).show();
                    }

                    break;
                }
                case R.id.btnOU8:
                {

                    if (AorV.equals("Video") || AorV.equals("Audio") || AorV.equals("")) {

                        OutpuT = 8;
                        OuT = 0x08;

                        btnO8.setText(getOUT8+"("+"V"+":"+inputString+")");

                        byteCB = new byte[]{0x20, 0x01, OuT, Inp};

                        CrcTraFor(byteCB);

                        byteAV = new byte[]{0x20, 0x01, OuT, Inp, cb[3]};
                        SwitchAV(byteAV);

                    }
                    else
                    {
                        Toast.makeText(MX_4UB.this, "You choose the wrong button  " + AorV + " please change", Toast.LENGTH_LONG).show();
                    }

                    break;
                }
                case R.id.btnOU9:
                {

                    if (AorV.equals("Video") || AorV.equals("Audio") || AorV.equals("")) {

                        OutpuT = 9;
                        OuT = 0x09;

                        btnO9.setText(getOUT9+"("+"V"+":"+inputString+")");

                        byteCB = new byte[]{0x20, 0x01, OuT, Inp};

                        CrcTraFor(byteCB);

                        byteAV = new byte[]{0x20, 0x01, OuT, Inp, cb[3]};
                        SwitchAV(byteAV);

                    }
                    else
                    {
                        Toast.makeText(MX_4UB.this, "You choose the wrong button  " + AorV + " please change", Toast.LENGTH_LONG).show();
                    }

                    break;
                }
                case R.id.btnOU10:
                {

                    if (AorV.equals("Video") || AorV.equals("Audio") || AorV.equals("")) {

                        OutpuT = 10;
                        OuT = 0x0a;

                        btnO10.setText(getOUT10+"("+"V"+":"+inputString+")");

                        byteCB = new byte[]{0x20, 0x01, OuT, Inp};

                        CrcTraFor(byteCB);

                        byteAV = new byte[]{0x20, 0x01, OuT, Inp, cb[3]};
                        SwitchAV(byteAV);

                    }
                    else
                    {
                        Toast.makeText(MX_4UB.this, "You choose the wrong button  " + AorV + " please change", Toast.LENGTH_LONG).show();
                    }

                    break;
                }
                case R.id.btnOU11:
                {

                    if (AorV.equals("Video") || AorV.equals("Audio") || AorV.equals("")) {

                        OutpuT = 11;
                        OuT = 0x0b;

                        btnO11.setText(getOUT11+"("+"V"+":"+inputString+")");

                        byteCB = new byte[]{0x20, 0x01, OuT, Inp};

                        CrcTraFor(byteCB);

                        byteAV = new byte[]{0x20, 0x01, OuT, Inp, cb[3]};
                        SwitchAV(byteAV);

                    }
                    else
                    {
                        Toast.makeText(MX_4UB.this, "You choose the wrong button  " + AorV + " please change", Toast.LENGTH_LONG).show();
                    }

                    break;
                }
                case R.id.btnOU12:
                {

                    if (AorV.equals("Video") || AorV.equals("Audio") || AorV.equals("")) {

                        OutpuT = 12;
                        OuT = 0x0c;

                        btnO12.setText(getOUT12+"("+"V"+":"+inputString+")");

                        byteCB = new byte[]{0x20, 0x01, OuT, Inp};

                        CrcTraFor(byteCB);

                        byteAV = new byte[]{0x20, 0x01, OuT, Inp, cb[3]};
                        SwitchAV(byteAV);

                    }
                    else
                    {
                        Toast.makeText(MX_4UB.this, "You choose the wrong button  " + AorV + " please change", Toast.LENGTH_LONG).show();
                    }

                    break;
                }
                case R.id.btnOU13:
                {

                    if (AorV.equals("Video") || AorV.equals("Audio") || AorV.equals("")) {

                        OutpuT = 13;
                        OuT = 0x0d;

                        btnO13.setText(getOUT13+"("+"V"+":"+inputString+")");

                        byteCB = new byte[]{0x20, 0x01, OuT, Inp};

                        CrcTraFor(byteCB);

                        byteAV = new byte[]{0x20, 0x01, OuT, Inp, cb[3]};
                        SwitchAV(byteAV);

                    }
                    else
                    {
                        Toast.makeText(MX_4UB.this, "You choose the wrong button  " + AorV + " please change", Toast.LENGTH_LONG).show();
                    }

                    break;
                }
                case R.id.btnOU14:
                {

                    if (AorV.equals("Video") || AorV.equals("Audio") || AorV.equals("")) {

                        OutpuT = 14;
                        OuT = 0x0e;

                        btnO14.setText(getOUT14+"("+"V"+":"+inputString+")");

                        byteCB = new byte[]{0x20, 0x01, OuT, Inp};

                        CrcTraFor(byteCB);

                        byteAV = new byte[]{0x20, 0x01, OuT, Inp, cb[3]};
                        SwitchAV(byteAV);

                    }
                    else
                    {
                        Toast.makeText(MX_4UB.this, "You choose the wrong button  " + AorV + " please change", Toast.LENGTH_LONG).show();
                    }

                    break;
                }
                case R.id.btnOU15:
                {

                    if (AorV.equals("Video") || AorV.equals("Audio") || AorV.equals("")) {

                        OutpuT = 15;
                        OuT = 0x0f;

                        btnO15.setText(getOUT15+"("+"V"+":"+inputString+")");

                        byteCB = new byte[]{0x20, 0x01, OuT, Inp};

                        CrcTraFor(byteCB);

                        byteAV = new byte[]{0x20, 0x01, OuT, Inp, cb[3]};
                        SwitchAV(byteAV);

                    }
                    else
                    {
                        Toast.makeText(MX_4UB.this, "You choose the wrong button  " + AorV + " please change", Toast.LENGTH_LONG).show();
                    }

                    break;
                }
                case R.id.btnOU16:
                {

                    if (AorV.equals("Video") || AorV.equals("Audio") || AorV.equals("")) {

                        OutpuT = 16;
                        OuT = 0x10;

                        btnO16.setText(getOUT16+"("+"V"+":"+inputString+")");

                        byteCB = new byte[]{0x20, 0x01, OuT, Inp};

                        CrcTraFor(byteCB);

                        byteAV = new byte[]{0x20, 0x01, OuT, Inp, cb[3]};
                        SwitchAV(byteAV);

                    }
                    else
                    {
                        Toast.makeText(MX_4UB.this, "You choose the wrong button  " + AorV + " please change", Toast.LENGTH_LONG).show();
                    }

                    break;
                }
                case R.id.btnME1:
                {

                    SL = true;
                    change.setClass(MX_4UB.this, SaveLoad_MX.class);
                    Bundle bundleSL = new Bundle();
                    bundleSL.putBoolean("SL", SL);
                    bundleSL.putString("Type",TYPE);
                    change.putExtras(bundleSL);
                    startActivity(change);
                    rgME.clearCheck();
                    break;
                }
                case R.id.btnME2:
                {

                    SL = false;
                    change.setClass(MX_4UB.this, SaveLoad_MX.class);
                    Bundle bundleSL = new Bundle();
                    bundleSL.putBoolean("SL", SL);
                    bundleSL.putString("Type",TYPE);
                    change.putExtras(bundleSL);

                    startActivity(change);
                    rgME.clearCheck();
                    break;
                }
                case R.id.btnAll:
                {
                    byteCB = new byte[]{0x20, 0x01, 0x00, Inp};
                    CrcTraFor(byteCB);
                    byteAV = new byte[]{0x20, 0x01, 0x00, Inp, cb[3]};
                    SwitchAV(byteAV);

                    btnO1.setText(getOUT1+"("+"V"+":"+inputString+")");
                    btnO2.setText(getOUT2+"("+"V"+":"+inputString+")");
                    btnO3.setText(getOUT3+"("+"V"+":"+inputString+")");
                    btnO4.setText(getOUT4+"("+"V"+":"+inputString+")");
                    btnO5.setText(getOUT5+"("+"V"+":"+inputString+")");
                    btnO6.setText(getOUT6+"("+"V"+":"+inputString+")");
                    btnO7.setText(getOUT7+"("+"V"+":"+inputString+")");
                    btnO8.setText(getOUT8+"("+"V"+":"+inputString+")");
                    btnO9.setText(getOUT9+"("+"V"+":"+inputString+")");
                    btnO10.setText(getOUT10+"("+"V"+":"+inputString+")");
                    btnO11.setText(getOUT11+"("+"V"+":"+inputString+")");
                    btnO12.setText(getOUT12+"("+"V"+":"+inputString+")");
                    btnO13.setText(getOUT13+"("+"V"+":"+inputString+")");
                    btnO14.setText(getOUT14+"("+"V"+":"+inputString+")");
                    btnO15.setText(getOUT15+"("+"V"+":"+inputString+")");
                    btnO16.setText(getOUT16+"("+"V"+":"+inputString+")");

                    rgAll.clearCheck();
                    break;
                }
                case R.id.btnOff:
                {
                    byteAV = new byte[]{0x20, 0x01, 0x00, 0x00, (byte)0xdb};
                    SwitchAV(byteAV);
                    btnO1.setText(getOUT1);
                    btnO2.setText(getOUT2);
                    btnO3.setText(getOUT3);
                    btnO4.setText(getOUT4);
                    btnO5.setText(getOUT5);
                    btnO6.setText(getOUT6);
                    btnO7.setText(getOUT7);
                    btnO8.setText(getOUT8);
                    btnO9.setText(getOUT9);
                    btnO10.setText(getOUT10);
                    btnO11.setText(getOUT11);
                    btnO12.setText(getOUT12);
                    btnO13.setText(getOUT13);
                    btnO14.setText(getOUT14);
                    btnO15.setText(getOUT15);
                    btnO16.setText(getOUT16);

                    rgAll.clearCheck();
                    break;
                }
            }
        }
    };
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void onStart()
    {
        super.onStart();
        btnA1.setChecked(true);
        btnA1.setTextColor(Color.parseColor("#ffffff"));
        AorV = "";

        rgIN.check(R.id.btnIN1);
        rgIN2.clearCheck();
        rgIN3.clearCheck();
        rgIN4.clearCheck();

        getIP1 = getSharedPreferences("Config4UB", MODE_PRIVATE).getString("IP1","1");
        getIP2 = getSharedPreferences("Config4UB", MODE_PRIVATE).getString("IP2","2");
        getIP3 = getSharedPreferences("Config4UB", MODE_PRIVATE).getString("IP3","3");
        getIP4 = getSharedPreferences("Config4UB", MODE_PRIVATE).getString("IP4","4");
        getIP5 = getSharedPreferences("Config4UB", MODE_PRIVATE).getString("IP5","5");
        getIP6 = getSharedPreferences("Config4UB", MODE_PRIVATE).getString("IP6","6");
        getIP7 = getSharedPreferences("Config4UB", MODE_PRIVATE).getString("IP7","7");
        getIP8 = getSharedPreferences("Config4UB", MODE_PRIVATE).getString("IP8","8");
        getIP9 = getSharedPreferences("Config4UB", MODE_PRIVATE).getString("IP9","9");
        getIP10 = getSharedPreferences("Config4UB", MODE_PRIVATE).getString("IP10","10");
        getIP11 = getSharedPreferences("Config4UB", MODE_PRIVATE).getString("IP11","11");
        getIP12 = getSharedPreferences("Config4UB", MODE_PRIVATE).getString("IP12","12");
        getIP13 = getSharedPreferences("Config4UB", MODE_PRIVATE).getString("IP13","13");
        getIP14 = getSharedPreferences("Config4UB", MODE_PRIVATE).getString("IP14","14");
        getIP15 = getSharedPreferences("Config4UB", MODE_PRIVATE).getString("IP15","15");
        getIP16 = getSharedPreferences("Config4UB", MODE_PRIVATE).getString("IP16","16");
        getOUT1 = getSharedPreferences("Config4UB",MODE_PRIVATE).getString("OUT1","1");
        getOUT2 = getSharedPreferences("Config4UB",MODE_PRIVATE).getString("OUT2","2");
        getOUT3 = getSharedPreferences("Config4UB",MODE_PRIVATE).getString("OUT3","3");
        getOUT4 = getSharedPreferences("Config4UB",MODE_PRIVATE).getString("OUT4","4");
        getOUT5 = getSharedPreferences("Config4UB",MODE_PRIVATE).getString("OUT5","5");
        getOUT6 = getSharedPreferences("Config4UB",MODE_PRIVATE).getString("OUT6","6");
        getOUT7 = getSharedPreferences("Config4UB",MODE_PRIVATE).getString("OUT7","7");
        getOUT8 = getSharedPreferences("Config4UB",MODE_PRIVATE).getString("OUT8","8");
        getOUT9 = getSharedPreferences("Config4UB",MODE_PRIVATE).getString("OUT9","9");
        getOUT10 = getSharedPreferences("Config4UB",MODE_PRIVATE).getString("OUT10","10");
        getOUT11 = getSharedPreferences("Config4UB",MODE_PRIVATE).getString("OUT11","11");
        getOUT12 = getSharedPreferences("Config4UB",MODE_PRIVATE).getString("OUT12","12");
        getOUT13 = getSharedPreferences("Config4UB",MODE_PRIVATE).getString("OUT13","13");
        getOUT14 = getSharedPreferences("Config4UB",MODE_PRIVATE).getString("OUT14","14");
        getOUT15 = getSharedPreferences("Config4UB",MODE_PRIVATE).getString("OUT15","15");
        getOUT16 = getSharedPreferences("Config4UB",MODE_PRIVATE).getString("OUT16","16");

        btnIN1.setText(getIP1);

        inputString = btnIN1.getText().toString();

        btnIN2.setText(getIP2);
        btnIN3.setText(getIP3);
        btnIN4.setText(getIP4);
        btnIN5.setText(getIP5);
        btnIN6.setText(getIP6);
        btnIN7.setText(getIP7);
        btnIN8.setText(getIP8);
        btnIN9.setText(getIP9);
        btnIN10.setText(getIP10);
        btnIN11.setText(getIP11);
        btnIN12.setText(getIP12);
        btnIN13.setText(getIP13);
        btnIN14.setText(getIP14);
        btnIN15.setText(getIP15);
        btnIN16.setText(getIP16);

        buttonSetText();
        if (LastInput4UB != 0)
        {
            switch (LastInput4UB)
            {
                case 1 :
                {
                    inputString = getIP1;
                    break;
                }
                case 2 :
                {
                    inputString = getIP2;
                    break;
                }
                case 3 :
                {
                    inputString = getIP3;
                    break;
                }
                case 4 :
                {
                    inputString = getIP4;
                    break;
                }
                case 5 :
                {
                    inputString = getIP5;
                    break;
                }
                case 6 :
                {
                    inputString = getIP6;
                    break;
                }
                case 7 :
                {
                    inputString = getIP7;
                    break;
                }
                case 8 :
                {
                    inputString = getIP8;
                    break;
                }
                case 9 :
                {
                    inputString = getIP9;
                    break;
                }
                case 10 :
                {
                    inputString = getIP10;
                    break;
                }
                case 11 :
                {
                    inputString = getIP11;
                    break;
                }
                case 12 :
                {
                    inputString = getIP12;
                    break;
                }
                case 13 :
                {
                    inputString = getIP13;
                    break;
                }
                case 14 :
                {
                    inputString = getIP14;
                    break;
                }
                case 15 :
                {
                    inputString = getIP15;
                    break;
                }
                case 16 :
                {
                    inputString = getIP16;
                    break;
                }
            }
        }

        if (ipFinal4UB != null)
        {
            txtI.setText("       IP: "+ipFinal4UB);
        }
    }

    public void runSocket()
    {

        try
        {
            if (m_socket != null)//連線成功才繼續往下執行
            {
                //傳送資料到Server端
                DataOutputStream out = new DataOutputStream(m_socket.getOutputStream());
                byte[] bytes2 = {0x20,0x3F,0x00,0x00,(byte) 0xF1};  //  給server 回傳機型相關資訊  80 0A 64 02 06 48 58 2D 32 35 36 32 47(HX-2562)


                out.write(bytes2);

                out.flush();

                //接收Server端資料

                DataInputStream in = new DataInputStream(m_socket.getInputStream());

                a = in.read(buff,0,buff.length);

                chaStr(a);

                Check();
                //s.close();  暫時關掉

            }

        }
        catch (IOException e)
        {
            Toast toast2 = Toast.makeText(MX_4UB.this,e.getMessage(),Toast.LENGTH_SHORT);
            toast2.show();
        }
    }

    public int chaStr(int b)
    {

        feedback = new String[b];
        Bhex = new int[b];

        for (int i=1; i<=b; i++)
        {

            String F = Integer.toHexString((buff[i-1] & 0x000000FF) | 0xFFFFFF00).substring(6); // 將編碼以16進制且兩位的方式顯示 並且值為正數不變，值為負數會自動刪除前面的 f (ex:  0x00 會顯示 00)

            feedback[i-1] = F;

            Bhex[i-1] = Integer.valueOf(F, 16).intValue(); //將16進制轉為10進制儲存

        }

        //Check();
        return b;
    }

    public void Check()
    {
        int i=1;
        if (feedback[i-1].equals("80"))
        {

            LB = Bhex[1];
            DN = LB-3;
            Ot = Bhex[3];
            It = Bhex[4];
            //DeciceName();
            Information();

        }

        else
        {
            System.out.println("Command不成立");
        }

    }

    public void Information()
    {
        boolean Audio,Video,Page1,O,Memory;

        int MemoryTol,q,w,e,r;

        //String bx = Integer.toBinaryString(Bhex[2]); //將值轉二進制的字串
        bx = Integer.toBinaryString(Bhex[2]);

        T = new char[bx.length()];   // 將字串的每一個字元單一取出
        for(int j=0; j<bx.length(); j++)
        {
            T[j] = bx.charAt(j);
            //System.out.println(T[j]);
        }

        //System.out.println(T[0]);

        if (bx.length()<8)                  // 代表Audio為0沒顯示
        {
            Audio = false;
            Video = (T[0]=='1')?true:false;
            Page1 = (T[1]=='1')?true:false;
            q = (T[3]=='1')?8:0;
            w = (T[4]=='1')?4:0;
            e = (T[5]=='1')?2:0;
            r = (T[6]=='1')?1:0;

            MemoryTol = q+w+e+r;

        }

        else                  //   Audio 為1有顯示
        {
            Audio = true;
            Video = (T[1]=='1')?true:false;
            Page1 = (T[2]=='1')?true:false;
            q = (T[4]=='1')?8:0;
            w = (T[5]=='1')?4:0;
            e = (T[6]=='1')?2:0;
            r = (T[7]=='1')?1:0;

            MemoryTol = q+w+e+r;

        }
        String str1 = String.valueOf(Audio);
        String str2 = String.valueOf(Video);
        String str3 = String.valueOf(Page1);

        MeTol = MemoryTol;
        //Toast infm = Toast.makeText(HX_2562.this,"Audio:"+str1+"Video:"+str2+"Page1"+str3+"Memory total have:"+MemoryTol,Toast.LENGTH_LONG);
        //infm.show();
        EDIDTYPE();
        ProtocolVer();
        FirmwareVer();

        Mation.setClass(MX_4UB.this,Information.class);
        Bundle bundleInf = new Bundle();
        bundleInf.putBoolean("Audio",Audio);
        bundleInf.putBoolean("Video",Video);
        bundleInf.putBoolean("Page1",Page1);
        bundleInf.putBoolean("EDID",EDID);
        bundleInf.putInt("Memory",MemoryTol);
        bundleInf.putInt("Output",Ot);
        bundleInf.putInt("Input",It);
        bundleInf.putString("Type",TYPE);
        bundleInf.putString("Protocol",Protocol);
        bundleInf.putString("Firmware",Firmware);
        //bundle.putStringArray("FeedBack" , feedback);
        Mation.putExtras(bundleInf);

        //startActivity(Mation);


    }

    public void DeciceName()
    {

        String Devicename = "";

        for (int i=5;i<(5+DN);i++)
        {
            char Asc2Char= (char) Bhex[i];
            Devicename+=Asc2Char;
        }

        //String aChar = new Character((char)i).toString();
        //System.out.println(Devicename);  // HX-2562
        TYPE = Devicename;
        txtN.setText("Name: "+TYPE);
    }

    public void SwitchAV(byte[] bytesAV)
    {
        //byte[] bytesAV = {0x20,0x01,OuT,Inp,cb[3]};

        try
        {
            DataOutputStream out = new DataOutputStream(m_socket.getOutputStream());
            out.write(bytesAV);
            out.flush();
            DataInputStream in = new DataInputStream(m_socket.getInputStream());
            in.read(buff,0,buff.length);
            //s.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    public void CrcTraFor(byte[] ByteClient)
    {

        //ByteClient = new byte[]{0x20,0x01,OuT,Inp};
        CrcS = Integer.toHexString((ByteClient[0] & 0x000000FF) | 0xFFFFFF00).substring(6);
        CrcH = Integer.valueOf(CrcS,16).toString();
        CrcI = Integer.parseInt(CrcH);
        cb[0] = CrcTab[CrcI];

        for (c = 1;c<ByteClient.length;c++)
        {

            xorCRC = cb[c-1]^ByteClient[c];
            if (xorCRC<0)
            {
                xorCRC = 256+xorCRC;

            }
            else
            {

            }

            cb[c] = CrcTab[xorCRC];

        }
    }

    public void EDIDTYPE()
    {
        try
        {
            DataOutputStream out = new DataOutputStream(m_socket.getOutputStream());

            byte[] bytesED = {0x20,0x21,0x01,0x00,(byte) 0x8b};


            out.write(bytesED);

            out.flush();

            //接收Server端資料

            DataInputStream in = new DataInputStream(m_socket.getInputStream());


            a = in.read(buff,0,buff.length);

            TypeB(a);

            //s.close();  暫時關掉
        }
        catch (IOException e)
        {
            Toast toast2 = Toast.makeText(MX_4UB.this,e.getMessage(),Toast.LENGTH_SHORT);
            toast2.show();
            System.out.println(e.getMessage());
        }
    }

    public void ProtocolVer()
    {
        try
        {
            DataOutputStream out = new DataOutputStream(m_socket.getOutputStream());

            byte[] bytesPro = {0x20,0x30,0x00,0x00,(byte) 0xae};


            out.write(bytesPro);

            out.flush();

            //接收Server端資料

            DataInputStream in = new DataInputStream(m_socket.getInputStream());


            a = in.read(buff,0,buff.length);

            TypeC(a);

            Protocol = "v"+String.valueOf(DB[0])+"."+String.valueOf(DB[1]);

            //s.close();  暫時關掉
        }
        catch (IOException e)
        {
            Toast toast2 = Toast.makeText(MX_4UB.this,e.getMessage(),Toast.LENGTH_SHORT);
            toast2.show();
            System.out.println(e.getMessage());
        }
    }

    public void FirmwareVer()
    {
        try
        {
            DataOutputStream out = new DataOutputStream(m_socket.getOutputStream());

            byte[] bytesFirm = {0x20,0x31,0x00,0x00,(byte) 0x05};


            out.write(bytesFirm);

            out.flush();

            //接收Server端資料

            DataInputStream in = new DataInputStream(m_socket.getInputStream());


            a = in.read(buff,0,buff.length);

            TypeC1(a);

            Firmware = "v"+VerA+"."+VerB+"."+String.valueOf(DB[1]);

            //s.close();  暫時關掉
        }
        catch (IOException e)
        {
            Toast toast2 = Toast.makeText(MX_4UB.this,e.getMessage(),Toast.LENGTH_SHORT);
            toast2.show();
            System.out.println(e.getMessage());
        }
    }


    public void TypeB(int b)
    {
        feedback = new String[b];
        BhexB = new int[b];
        int i;
        for (i=1; i<=b; i++)
        {
            String F = Integer.toHexString((buff[i-1] & 0x000000FF) | 0xFFFFFF00).substring(6); // 將編碼以16進制且兩位的方式顯示 並且值為正數不變，值為負數會自動刪除前面的 f (ex:  0x00 會顯示 00)
            //System.out.println("Arr" + i + "的值 : " + F);
            feedback[i-1] = F;
            BhexB[i-1] = Integer.valueOf(F, 16).intValue(); //將16進制轉為10進制儲存
        }
        i = 1;
        if (feedback[i-1].equals("80"))
        {
            EDID = true;
            IB = BhexB[1];
            IVB = new int[IB];
            for (int B = 2;B<IB+2;B++)
            {
                IVB[B-2] = BhexB[B];
            }

        }

        else
        {
            System.out.println("Command不成立");
        }


    }

    public void TypeC(int b)
    {
        feedback = new String[b];
        BhexC = new int[b];
        int i;
        for (i=1; i<=b; i++)
        {
            String F = Integer.toHexString((buff[i-1] & 0x000000FF) | 0xFFFFFF00).substring(6); // 將編碼以16進制且兩位的方式顯示 並且值為正數不變，值為負數會自動刪除前面的 f (ex:  0x00 會顯示 00)
            //System.out.println("Arr" + i + "的值 : " + F);
            feedback[i-1] = F;
            BhexC[i-1] = Integer.valueOf(F, 16).intValue(); //將16進制轉為10進制儲存
        }
        i = 1;
        if (feedback[i-1].equals("80"))
        {
            DB = new int[2];
            DB[0] = BhexC[2];
            DB[1] = BhexC[3];
        }

        else
        {
            System.out.println("Command不成立");
        }
    }

    public void TypeC1(int b)
    {
        feedback = new String[b];
        BhexC1 = new int[b];
        int i;
        for (i=1; i<=b; i++)
        {
            String F = Integer.toHexString((buff[i-1] & 0x000000FF) | 0xFFFFFF00).substring(6); // 將編碼以16進制且兩位的方式顯示 並且值為正數不變，值為負數會自動刪除前面的 f (ex:  0x00 會顯示 00)
            //System.out.println("Arr" + i + "的值 : " + F);
            feedback[i-1] = F;
            BhexC1[i-1] = Integer.valueOf(F, 16).intValue(); //將16進制轉為10進制儲存
        }
        i = 1;
        if (feedback[i-1].equals("80"))
        {
            DB = new int[2];
            DB[0] = BhexC1[2];
            DB[1] = BhexC1[3];

            VerAB = Integer.toBinaryString(DB[0]);

            TF = new char[VerAB.length()];   // 將字串的每一個字元單一取出
            for(int j=0; j<VerAB.length(); j++)
            {
                TF[j] = VerAB.charAt(j);
            }
            int bitA3,bitA2,bitA1,bitA0,bitB3,bitB2,bitB1,bitB0;
            if (VerAB.length()==8)
            {
                bitA3 = 8;
                bitA2 = (TF[1]=='1')?4:0;
                bitA1 = (TF[2]=='1')?2:0;
                bitA0 = (TF[3]=='1')?1:0;
                bitB3 = (TF[4]=='1')?8:0;
                bitB2 = (TF[5]=='1')?4:0;
                bitB1 = (TF[6]=='1')?2:0;
                bitB0 = (TF[7]=='1')?1:0;

                VerA = String.valueOf(bitA3+bitA2+bitA1+bitA0);
                VerB = String.valueOf(bitB3+bitB2+bitB1+bitB0);

            }
            else if (VerAB.length()==7)
            {
                bitA3 = 0;
                bitA2 = (TF[0]=='1')?4:0;
                bitA1 = (TF[1]=='1')?2:0;
                bitA0 = (TF[2]=='1')?1:0;
                bitB3 = (TF[3]=='1')?8:0;
                bitB2 = (TF[4]=='1')?4:0;
                bitB1 = (TF[5]=='1')?2:0;
                bitB0 = (TF[6]=='1')?1:0;

                VerA = String.valueOf(bitA3+bitA2+bitA1+bitA0);
                VerB = String.valueOf(bitB3+bitB2+bitB1+bitB0);
            }

            else if (VerAB.length()==6)
            {
                bitA3 = 0;
                bitA2 = 0;
                bitA1 = (TF[0]=='1')?2:0;
                bitA0 = (TF[1]=='1')?1:0;
                bitB3 = (TF[2]=='1')?8:0;
                bitB2 = (TF[3]=='1')?4:0;
                bitB1 = (TF[4]=='1')?2:0;
                bitB0 = (TF[5]=='1')?1:0;

                VerA = String.valueOf(bitA3+bitA2+bitA1+bitA0);
                VerB = String.valueOf(bitB3+bitB2+bitB1+bitB0);
            }

            else if (VerAB.length()==5)
            {
                bitA3 = 0;
                bitA2 = 0;
                bitA1 = 0;
                bitA0 = (TF[0]=='1')?1:0;
                bitB3 = (TF[1]=='1')?8:0;
                bitB2 = (TF[2]=='1')?4:0;
                bitB1 = (TF[3]=='1')?2:0;
                bitB0 = (TF[4]=='1')?1:0;

                VerA = String.valueOf(bitA3+bitA2+bitA1+bitA0);
                VerB = String.valueOf(bitB3+bitB2+bitB1+bitB0);
            }

            else if (VerAB.length()==4)
            {
                bitA3 = 0;
                bitA2 = 0;
                bitA1 = 0;
                bitA0 = 0;
                bitB3 = (TF[0]=='1')?8:0;
                bitB2 = (TF[1]=='1')?4:0;
                bitB1 = (TF[2]=='1')?2:0;
                bitB0 = (TF[3]=='1')?1:0;

                VerA = String.valueOf(bitA3+bitA2+bitA1+bitA0);
                VerB = String.valueOf(bitB3+bitB2+bitB1+bitB0);
            }

            else if (VerAB.length()==3)
            {
                bitA3 = 0;
                bitA2 = 0;
                bitA1 = 0;
                bitA0 = 0;
                bitB3 = 0;
                bitB2 = (TF[0]=='1')?4:0;
                bitB1 = (TF[1]=='1')?2:0;
                bitB0 = (TF[2]=='1')?1:0;

                VerA = String.valueOf(bitA3+bitA2+bitA1+bitA0);
                VerB = String.valueOf(bitB3+bitB2+bitB1+bitB0);
            }

            else if (VerAB.length()==2)
            {
                bitA3 = 0;
                bitA2 = 0;
                bitA1 = 0;
                bitA0 = 0;
                bitB3 = 0;
                bitB2 = 0;
                bitB1 = (TF[0]=='1')?2:0;
                bitB0 = (TF[1]=='1')?1:0;

                VerA = String.valueOf(bitA3+bitA2+bitA1+bitA0);
                VerB = String.valueOf(bitB3+bitB2+bitB1+bitB0);
            }

            else if (VerAB.length()==1)
            {
                bitA3 = 0;
                bitA2 = 0;
                bitA1 = 0;
                bitA0 = 0;
                bitB3 = 0;
                bitB2 = 0;
                bitB1 = 0;
                bitB0 = (TF[0]=='1')?1:0;

                VerA = String.valueOf(bitA3+bitA2+bitA1+bitA0);
                VerB = String.valueOf(bitB3+bitB2+bitB1+bitB0);
            }

            else
            {

                VerA = "0";
                VerB = "0";

            }

        }

        else
        {
            System.out.println("Command不成立");
        }
    }

    public void buttonSetText()
    {
/////////////////////////////////////////////////////////////////////////////////////////////////////////// Output 1 /////////////////////////////////////////////////////////////////////////////////////
        try {
            byte[] byteInput = new byte[]{0x20,0x07,0x01,0x00,(byte) 0xce};
            DataOutputStream getinput = new DataOutputStream(m_socket.getOutputStream());
            getinput.write(byteInput);
            getinput.flush();

            DataInputStream in = new DataInputStream(m_socket.getInputStream());
            int c = in.read(buff,0,buff.length);
            chaStr(c);

            str1 = feedback[feedback.length-2];

        } catch (IOException e) {
            e.printStackTrace();
        }
        if (str1.equals("00"))
        {
            btnO1.setText(getOUT1);
        }
        else if (str1.equals("01"))
        {
            btnO1.setText(getOUT1+"("+"V"+":"+getIP1+")");
        }
        else if (str1.equals("02"))
        {
            btnO1.setText(getOUT1+"("+"V"+":"+getIP2+")");
        }
        else if (str1.equals("03"))
        {
            btnO1.setText(getOUT1+"("+"V"+":"+getIP3+")");
        }
        else if (str1.equals("04"))
        {
            btnO1.setText(getOUT1+"("+"V"+":"+getIP4+")");
        }
        else if (str1.equals("05"))
        {
            btnO1.setText(getOUT1+"("+"V"+":"+getIP5+")");
        }
        else if (str1.equals("06"))
        {
            btnO1.setText(getOUT1+"("+"V"+":"+getIP6+")");
        }
        else if (str1.equals("07"))
        {
            btnO1.setText(getOUT1+"("+"V"+":"+getIP7+")");
        }
        else if (str1.equals("08"))
        {
            btnO1.setText(getOUT1+"("+"V"+":"+getIP8+")");
        }
        else if (str1.equals("09"))
        {
            btnO1.setText(getOUT1+"("+"V"+":"+getIP9+")");
        }
        else if (str1.equals("0a"))
        {
            btnO1.setText(getOUT1+"("+"V"+":"+getIP10+")");
        }
        else if (str1.equals("0b"))
        {
            btnO1.setText(getOUT1+"("+"V"+":"+getIP11+")");
        }
        else if (str1.equals("0c"))
        {
            btnO1.setText(getOUT1+"("+"V"+":"+getIP12+")");
        }
        else if (str1.equals("0d"))
        {
            btnO1.setText(getOUT1+"("+"V"+":"+getIP13+")");
        }
        else if (str1.equals("0e"))
        {
            btnO1.setText(getOUT1+"("+"V"+":"+getIP14+")");
        }
        else if (str1.equals("0f"))
        {
            btnO1.setText(getOUT1+"("+"V"+":"+getIP15+")");
        }
        else if (str1.equals("10"))
        {
            btnO1.setText(getOUT1+"("+"V"+":"+getIP16+")");
        }
/////////////////////////////////////////////////////////////////////////////////////////////////////////// Output 2 /////////////////////////////////////////////////////////////////////////////////////
        try {
            byte[] byteInput = new byte[]{0x20,0x07,0x02,0x00,(byte) 0x9b};
            DataOutputStream getinput = new DataOutputStream(m_socket.getOutputStream());
            getinput.write(byteInput);
            getinput.flush();

            DataInputStream in = new DataInputStream(m_socket.getInputStream());
            int c = in.read(buff,0,buff.length);
            chaStr(c);

            str2 = feedback[feedback.length-2];

        } catch (IOException e) {
            e.printStackTrace();
        }
        if (str2.equals("00"))
        {
            btnO2.setText(getOUT2);
        }
        else if (str2.equals("01"))
        {

            inputString1 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString1","1");
            btnO2.setText(getOUT2+"("+"V"+":"+getIP1+")");

        }
        else if (str2.equals("02"))
        {
            inputString2 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString2","2");
            btnO2.setText(getOUT2+"("+"V"+":"+getIP2+")");
        }
        else if (str2.equals("03"))
        {
            inputString3 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString3","3");
            btnO2.setText(getOUT2+"("+"V"+":"+getIP3+")");
        }
        else if (str2.equals("04"))
        {
            inputString4 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString4","4");
            btnO2.setText(getOUT2+"("+"V"+":"+getIP4+")");
        }
        else if (str2.equals("05"))
        {
            inputString5 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString5","5");
            btnO2.setText(getOUT2+"("+"V"+":"+getIP5+")");
        }
        else if (str2.equals("06"))
        {
            inputString6 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString6","6");
            btnO2.setText(getOUT2+"("+"V"+":"+getIP6+")");
        }
        else if (str2.equals("07"))
        {
            inputString7 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString7","7");
            btnO2.setText(getOUT2+"("+"V"+":"+getIP7+")");
        }
        else if (str2.equals("08"))
        {
            inputString8 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString8","8");
            btnO2.setText(getOUT2+"("+"V"+":"+getIP8+")");
        }
        else if (str2.equals("09"))
        {
            btnO2.setText(getOUT2+"("+"V"+":"+getIP9+")");
        }
        else if (str2.equals("0a"))
        {
            btnO2.setText(getOUT2+"("+"V"+":"+getIP10+")");
        }
        else if (str2.equals("0b"))
        {
            btnO2.setText(getOUT2+"("+"V"+":"+getIP11+")");
        }
        else if (str2.equals("0c"))
        {
            btnO2.setText(getOUT2+"("+"V"+":"+getIP12+")");
        }
        else if (str2.equals("0d"))
        {
            btnO2.setText(getOUT2+"("+"V"+":"+getIP13+")");
        }
        else if (str2.equals("0e"))
        {
            btnO2.setText(getOUT2+"("+"V"+":"+getIP14+")");
        }
        else if (str2.equals("0f"))
        {
            btnO2.setText(getOUT2+"("+"V"+":"+getIP15+")");
        }
        else if (str2.equals("10"))
        {
            btnO2.setText(getOUT2+"("+"V"+":"+getIP16+")");
        }
/////////////////////////////////////////////////////////////////////////////////////////////////////////// Output 3 /////////////////////////////////////////////////////////////////////////////////////
        try {
            byte[] byteInput = new byte[]{0x20,0x07,0x03,0x00,(byte) 0x5f};
            DataOutputStream getinput = new DataOutputStream(m_socket.getOutputStream());
            getinput.write(byteInput);
            getinput.flush();

            DataInputStream in = new DataInputStream(m_socket.getInputStream());
            int c = in.read(buff,0,buff.length);
            chaStr(c);

            str3 = feedback[feedback.length-2];

        } catch (IOException e) {
            e.printStackTrace();
        }
        if (str3.equals("00"))
        {
            btnO3.setText(getOUT3);
        }
        else if (str3.equals("01"))
        {

            inputString1 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString1","1");
            btnO3.setText(getOUT3+"("+"V"+":"+getIP1+")");

        }
        else if (str3.equals("02"))
        {
            inputString2 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString2","2");
            btnO3.setText(getOUT3+"("+"V"+":"+getIP2+")");
        }
        else if (str3.equals("03"))
        {
            inputString3 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString3","3");
            btnO3.setText(getOUT3+"("+"V"+":"+getIP3+")");
        }
        else if (str3.equals("04"))
        {
            inputString4 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString4","4");
            btnO3.setText(getOUT3+"("+"V"+":"+getIP4+")");
        }
        else if (str3.equals("05"))
        {
            inputString5 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString5","5");
            btnO3.setText(getOUT3+"("+"V"+":"+getIP5+")");
        }
        else if (str3.equals("06"))
        {
            inputString6 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString6","6");
            btnO3.setText(getOUT3+"("+"V"+":"+getIP6+")");
        }
        else if (str3.equals("07"))
        {
            inputString7 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString7","7");
            btnO3.setText(getOUT3+"("+"V"+":"+getIP7+")");
        }
        else if (str3.equals("08"))
        {
            inputString8 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString8","8");
            btnO3.setText(getOUT3+"("+"V"+":"+getIP8+")");
        }
        else if (str3.equals("09"))
        {
            btnO3.setText(getOUT3+"("+"V"+":"+getIP9+")");
        }
        else if (str3.equals("0a"))
        {
            btnO3.setText(getOUT3+"("+"V"+":"+getIP10+")");
        }
        else if (str3.equals("0b"))
        {
            btnO3.setText(getOUT3+"("+"V"+":"+getIP11+")");
        }
        else if (str3.equals("0c"))
        {
            btnO3.setText(getOUT3+"("+"V"+":"+getIP12+")");
        }
        else if (str3.equals("0d"))
        {
            btnO3.setText(getOUT3+"("+"V"+":"+getIP13+")");
        }
        else if (str3.equals("0e"))
        {
            btnO3.setText(getOUT3+"("+"V"+":"+getIP14+")");
        }
        else if (str3.equals("0f"))
        {
            btnO3.setText(getOUT3+"("+"V"+":"+getIP15+")");
        }
        else if (str3.equals("10"))
        {
            btnO3.setText(getOUT3+"("+"V"+":"+getIP16+")");
        }
/////////////////////////////////////////////////////////////////////////////////////////////////////////// Output 4 /////////////////////////////////////////////////////////////////////////////////////
        try {
            byte[] byteInput = new byte[]{0x20,0x07,0x04,0x00,(byte) 0x31};
            DataOutputStream getinput = new DataOutputStream(m_socket.getOutputStream());
            getinput.write(byteInput);
            getinput.flush();

            DataInputStream in = new DataInputStream(m_socket.getInputStream());
            int c = in.read(buff,0,buff.length);
            chaStr(c);

            str4 = feedback[feedback.length-2];

        } catch (IOException e) {
            e.printStackTrace();
        }
        if (str4.equals("00"))
        {
            btnO4.setText(getOUT4);
        }
        else if (str4.equals("01"))
        {

            inputString1 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString1","1");
            btnO4.setText(getOUT4+"("+"V"+":"+getIP1+")");

        }
        else if (str4.equals("02"))
        {
            inputString2 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString2","2");
            btnO4.setText(getOUT4+"("+"V"+":"+getIP2+")");
        }
        else if (str4.equals("03"))
        {
            inputString3 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString3","3");
            btnO4.setText(getOUT4+"("+"V"+":"+getIP3+")");
        }
        else if (str4.equals("04"))
        {
            inputString4 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString4","4");
            btnO4.setText(getOUT4+"("+"V"+":"+getIP4+")");
        }
        else if (str4.equals("05"))
        {
            inputString5 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString5","5");
            btnO4.setText(getOUT4+"("+"V"+":"+getIP5+")");
        }
        else if (str4.equals("06"))
        {
            inputString6 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString6","6");
            btnO4.setText(getOUT4+"("+"V"+":"+getIP6+")");
        }
        else if (str4.equals("07"))
        {
            inputString7 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString7","7");
            btnO4.setText(getOUT4+"("+"V"+":"+getIP7+")");
        }
        else if (str4.equals("08"))
        {
            inputString8 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString8","8");
            btnO4.setText(getOUT4+"("+"V"+":"+getIP8+")");
        }
        else if (str4.equals("09"))
        {
            btnO4.setText(getOUT4+"("+"V"+":"+getIP9+")");
        }
        else if (str4.equals("0a"))
        {
            btnO4.setText(getOUT4+"("+"V"+":"+getIP10+")");
        }
        else if (str4.equals("0b"))
        {
            btnO4.setText(getOUT4+"("+"V"+":"+getIP11+")");
        }
        else if (str4.equals("0c"))
        {
            btnO4.setText(getOUT4+"("+"V"+":"+getIP12+")");
        }
        else if (str4.equals("0d"))
        {
            btnO4.setText(getOUT4+"("+"V"+":"+getIP13+")");
        }
        else if (str4.equals("0e"))
        {
            btnO4.setText(getOUT4+"("+"V"+":"+getIP14+")");
        }
        else if (str4.equals("0f"))
        {
            btnO4.setText(getOUT4+"("+"V"+":"+getIP15+")");
        }
        else if (str4.equals("10"))
        {
            btnO4.setText(getOUT4+"("+"V"+":"+getIP16+")");
        }
/////////////////////////////////////////////////////////////////////////////////////////////////////////// Output 5 /////////////////////////////////////////////////////////////////////////////////////
        try {
            byte[] byteInput = new byte[]{0x20,0x07,0x05,0x00,(byte) 0xf5};
            DataOutputStream getinput = new DataOutputStream(m_socket.getOutputStream());
            getinput.write(byteInput);
            getinput.flush();

            DataInputStream in = new DataInputStream(m_socket.getInputStream());
            int c = in.read(buff,0,buff.length);
            chaStr(c);

            str5 = feedback[feedback.length-2];

        } catch (IOException e) {
            e.printStackTrace();
        }
        if (str5.equals("00"))
        {
            btnO5.setText(getOUT5);
        }
        else if (str4.equals("01"))
        {

            inputString1 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString1","1");
            btnO5.setText(getOUT5+"("+"V"+":"+getIP1+")");

        }
        else if (str5.equals("02"))
        {
            inputString2 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString2","2");
            btnO5.setText(getOUT5+"("+"V"+":"+getIP2+")");
        }
        else if (str5.equals("03"))
        {
            inputString3 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString3","3");
            btnO5.setText(getOUT5+"("+"V"+":"+getIP3+")");
        }
        else if (str5.equals("04"))
        {
            inputString4 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString4","4");
            btnO5.setText(getOUT5+"("+"V"+":"+getIP4+")");
        }
        else if (str5.equals("05"))
        {
            inputString5 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString5","5");
            btnO5.setText(getOUT5+"("+"V"+":"+getIP5+")");
        }
        else if (str5.equals("06"))
        {
            inputString6 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString6","6");
            btnO5.setText(getOUT5+"("+"V"+":"+getIP6+")");
        }
        else if (str5.equals("07"))
        {
            inputString7 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString7","7");
            btnO5.setText(getOUT5+"("+"V"+":"+getIP7+")");
        }
        else if (str5.equals("08"))
        {
            inputString8 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString8","8");
            btnO5.setText(getOUT5+"("+"V"+":"+getIP8+")");
        }
        else if (str5.equals("09"))
        {
            btnO5.setText(getOUT5+"("+"V"+":"+getIP9+")");
        }
        else if (str5.equals("0a"))
        {
            btnO5.setText(getOUT5+"("+"V"+":"+getIP10+")");
        }
        else if (str5.equals("0b"))
        {
            btnO5.setText(getOUT5+"("+"V"+":"+getIP11+")");
        }
        else if (str5.equals("0c"))
        {
            btnO5.setText(getOUT5+"("+"V"+":"+getIP12+")");
        }
        else if (str5.equals("0d"))
        {
            btnO5.setText(getOUT5+"("+"V"+":"+getIP13+")");
        }
        else if (str5.equals("0e"))
        {
            btnO5.setText(getOUT5+"("+"V"+":"+getIP14+")");
        }
        else if (str5.equals("0f"))
        {
            btnO5.setText(getOUT5+"("+"V"+":"+getIP15+")");
        }
        else if (str5.equals("10"))
        {
            btnO5.setText(getOUT5+"("+"V"+":"+getIP16+")");
        }
/////////////////////////////////////////////////////////////////////////////////////////////////////////// Output 6 /////////////////////////////////////////////////////////////////////////////////////
        try {
            byte[] byteInput = new byte[]{0x20,0x07,0x06,0x00,(byte) 0xa0};
            DataOutputStream getinput = new DataOutputStream(m_socket.getOutputStream());
            getinput.write(byteInput);
            getinput.flush();

            DataInputStream in = new DataInputStream(m_socket.getInputStream());
            int c = in.read(buff,0,buff.length);
            chaStr(c);

            str6 = feedback[feedback.length-2];

        } catch (IOException e) {
            e.printStackTrace();
        }
        if (str6.equals("00"))
        {
            btnO6.setText(getOUT6);
        }
        else if (str6.equals("01"))
        {

            inputString1 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString1","1");
            btnO6.setText(getOUT6+"("+"V"+":"+getIP1+")");

        }
        else if (str6.equals("02"))
        {
            inputString2 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString2","2");
            btnO6.setText(getOUT6+"("+"V"+":"+getIP2+")");
        }
        else if (str6.equals("03"))
        {
            inputString3 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString3","3");
            btnO6.setText(getOUT6+"("+"V"+":"+getIP3+")");
        }
        else if (str6.equals("04"))
        {
            inputString4 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString4","4");
            btnO6.setText(getOUT6+"("+"V"+":"+getIP4+")");
        }
        else if (str6.equals("05"))
        {
            inputString5 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString5","5");
            btnO6.setText(getOUT6+"("+"V"+":"+getIP5+")");
        }
        else if (str6.equals("06"))
        {
            inputString6 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString6","6");
            btnO6.setText(getOUT6+"("+"V"+":"+getIP6+")");
        }
        else if (str6.equals("07"))
        {
            inputString7 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString7","7");
            btnO6.setText(getOUT6+"("+"V"+":"+getIP7+")");
        }
        else if (str6.equals("08"))
        {
            inputString8 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString8","8");
            btnO6.setText(getOUT6+"("+"V"+":"+getIP8+")");
        }
        else if (str6.equals("09"))
        {
            btnO6.setText(getOUT6+"("+"V"+":"+getIP9+")");
        }
        else if (str6.equals("0a"))
        {
            btnO6.setText(getOUT6+"("+"V"+":"+getIP10+")");
        }
        else if (str6.equals("0b"))
        {
            btnO6.setText(getOUT6+"("+"V"+":"+getIP11+")");
        }
        else if (str6.equals("0c"))
        {
            btnO6.setText(getOUT6+"("+"V"+":"+getIP12+")");
        }
        else if (str6.equals("0d"))
        {
            btnO6.setText(getOUT6+"("+"V"+":"+getIP13+")");
        }
        else if (str6.equals("0e"))
        {
            btnO6.setText(getOUT6+"("+"V"+":"+getIP14+")");
        }
        else if (str6.equals("0f"))
        {
            btnO6.setText(getOUT6+"("+"V"+":"+getIP15+")");
        }
        else if (str6.equals("10"))
        {
            btnO6.setText(getOUT6+"("+"V"+":"+getIP16+")");
        }
/////////////////////////////////////////////////////////////////////////////////////////////////////////// Output 7 /////////////////////////////////////////////////////////////////////////////////////
        try {
            byte[] byteInput = new byte[]{0x20,0x07,0x07,0x00,(byte) 0x64};
            DataOutputStream getinput = new DataOutputStream(m_socket.getOutputStream());
            getinput.write(byteInput);
            getinput.flush();

            DataInputStream in = new DataInputStream(m_socket.getInputStream());
            int c = in.read(buff,0,buff.length);
            chaStr(c);

            str7 = feedback[feedback.length-2];

        } catch (IOException e) {
            e.printStackTrace();
        }
        if (str7.equals("00"))
        {
            btnO7.setText(getOUT7);
        }
        else if (str7.equals("01"))
        {

            inputString1 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString1","1");
            btnO7.setText(getOUT7+"("+"V"+":"+getIP1+")");

        }
        else if (str7.equals("02"))
        {
            inputString2 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString2","2");
            btnO7.setText(getOUT7+"("+"V"+":"+getIP2+")");
        }
        else if (str7.equals("03"))
        {
            inputString3 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString3","3");
            btnO7.setText(getOUT7+"("+"V"+":"+getIP3+")");
        }
        else if (str7.equals("04"))
        {
            inputString4 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString4","4");
            btnO7.setText(getOUT7+"("+"V"+":"+getIP4+")");
        }
        else if (str7.equals("05"))
        {
            inputString5 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString5","5");
            btnO7.setText(getOUT7+"("+"V"+":"+getIP5+")");
        }
        else if (str7.equals("06"))
        {
            inputString6 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString6","6");
            btnO7.setText(getOUT7+"("+"V"+":"+getIP6+")");
        }
        else if (str7.equals("07"))
        {
            inputString7 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString7","7");
            btnO7.setText(getOUT7+"("+"V"+":"+getIP7+")");
        }
        else if (str7.equals("08"))
        {
            inputString8 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString8","8");
            btnO7.setText(getOUT7+"("+"V"+":"+getIP8+")");
        }
        else if (str7.equals("09"))
        {
            btnO7.setText(getOUT7+"("+"V"+":"+getIP9+")");
        }
        else if (str7.equals("0a"))
        {
            btnO7.setText(getOUT7+"("+"V"+":"+getIP10+")");
        }
        else if (str7.equals("0b"))
        {
            btnO7.setText(getOUT7+"("+"V"+":"+getIP11+")");
        }
        else if (str7.equals("0c"))
        {
            btnO7.setText(getOUT7+"("+"V"+":"+getIP12+")");
        }
        else if (str7.equals("0d"))
        {
            btnO7.setText(getOUT7+"("+"V"+":"+getIP13+")");
        }
        else if (str7.equals("0e"))
        {
            btnO7.setText(getOUT7+"("+"V"+":"+getIP14+")");
        }
        else if (str7.equals("0f"))
        {
            btnO7.setText(getOUT7+"("+"V"+":"+getIP15+")");
        }
        else if (str7.equals("10"))
        {
            btnO7.setText(getOUT7+"("+"V"+":"+getIP16+")");
        }
/////////////////////////////////////////////////////////////////////////////////////////////////////////// Output 8 /////////////////////////////////////////////////////////////////////////////////////
        try {
            byte[] byteInput = new byte[]{0x20,0x07,0x08,0x00,(byte) 0x7c};
            DataOutputStream getinput = new DataOutputStream(m_socket.getOutputStream());
            getinput.write(byteInput);
            getinput.flush();

            DataInputStream in = new DataInputStream(m_socket.getInputStream());
            int c = in.read(buff,0,buff.length);
            chaStr(c);

            str8 = feedback[feedback.length-2];

        } catch (IOException e) {
            e.printStackTrace();
        }
        if (str8.equals("00"))
        {
            btnO8.setText(getOUT8);
        }
        else if (str8.equals("01"))
        {

            inputString1 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString1","1");
            btnO8.setText(getOUT8+"("+"V"+":"+getIP1+")");

        }
        else if (str8.equals("02"))
        {
            inputString2 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString2","2");
            btnO8.setText(getOUT8+"("+"V"+":"+getIP2+")");
        }
        else if (str8.equals("03"))
        {
            inputString3 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString3","3");
            btnO8.setText(getOUT8+"("+"V"+":"+getIP3+")");
        }
        else if (str8.equals("04"))
        {
            inputString4 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString4","4");
            btnO8.setText(getOUT8+"("+"V"+":"+getIP4+")");
        }
        else if (str8.equals("05"))
        {
            inputString5 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString5","5");
            btnO8.setText(getOUT8+"("+"V"+":"+getIP5+")");
        }
        else if (str8.equals("06"))
        {
            inputString6 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString6","6");
            btnO8.setText(getOUT8+"("+"V"+":"+getIP6+")");
        }
        else if (str8.equals("07"))
        {
            inputString7 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString7","7");
            btnO8.setText(getOUT8+"("+"V"+":"+getIP7+")");
        }
        else if (str8.equals("08"))
        {
            inputString8 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString8","8");
            btnO8.setText(getOUT8+"("+"V"+":"+getIP8+")");
        }
        else if (str8.equals("09"))
        {
            btnO8.setText(getOUT8+"("+"V"+":"+getIP9+")");
        }
        else if (str8.equals("0a"))
        {
            btnO8.setText(getOUT8+"("+"V"+":"+getIP10+")");
        }
        else if (str8.equals("0b"))
        {
            btnO8.setText(getOUT8+"("+"V"+":"+getIP11+")");
        }
        else if (str8.equals("0c"))
        {
            btnO8.setText(getOUT8+"("+"V"+":"+getIP12+")");
        }
        else if (str8.equals("0d"))
        {
            btnO8.setText(getOUT8+"("+"V"+":"+getIP13+")");
        }
        else if (str8.equals("0e"))
        {
            btnO8.setText(getOUT8+"("+"V"+":"+getIP14+")");
        }
        else if (str8.equals("0f"))
        {
            btnO8.setText(getOUT8+"("+"V"+":"+getIP15+")");
        }
        else if (str8.equals("10"))
        {
            btnO8.setText(getOUT8+"("+"V"+":"+getIP16+")");
        }
/////////////////////////////////////////////////////////////////////////////////////////////////////////// Output 9 /////////////////////////////////////////////////////////////////////////////////////
        try {
            byte[] byteInput = new byte[]{0x20,0x07,0x09,0x00,(byte) 0xb8};
            DataOutputStream getinput = new DataOutputStream(m_socket.getOutputStream());
            getinput.write(byteInput);
            getinput.flush();

            DataInputStream in = new DataInputStream(m_socket.getInputStream());
            int c = in.read(buff,0,buff.length);
            chaStr(c);

            str9 = feedback[feedback.length-2];

        } catch (IOException e) {
            e.printStackTrace();
        }
        if (str9.equals("00"))
        {
            btnO9.setText(getOUT9);
        }
        else if (str9.equals("01"))
        {

            inputString1 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString1","1");
            btnO9.setText(getOUT9+"("+"V"+":"+getIP1+")");

        }
        else if (str9.equals("02"))
        {
            inputString2 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString2","2");
            btnO9.setText(getOUT9+"("+"V"+":"+getIP2+")");
        }
        else if (str9.equals("03"))
        {
            inputString3 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString3","3");
            btnO9.setText(getOUT9+"("+"V"+":"+getIP3+")");
        }
        else if (str9.equals("04"))
        {
            inputString4 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString4","4");
            btnO9.setText(getOUT9+"("+"V"+":"+getIP4+")");
        }
        else if (str9.equals("05"))
        {
            inputString5 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString5","5");
            btnO9.setText(getOUT9+"("+"V"+":"+getIP5+")");
        }
        else if (str8.equals("06"))
        {
            inputString6 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString6","6");
            btnO9.setText(getOUT9+"("+"V"+":"+getIP6+")");
        }
        else if (str9.equals("07"))
        {
            inputString7 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString7","7");
            btnO9.setText(getOUT9+"("+"V"+":"+getIP7+")");
        }
        else if (str9.equals("08"))
        {
            inputString8 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString8","8");
            btnO9.setText(getOUT9+"("+"V"+":"+getIP8+")");
        }
        else if (str9.equals("09"))
        {
            btnO9.setText(getOUT9+"("+"V"+":"+getIP9+")");
        }
        else if (str9.equals("0a"))
        {
            btnO9.setText(getOUT9+"("+"V"+":"+getIP10+")");
        }
        else if (str9.equals("0b"))
        {
            btnO9.setText(getOUT9+"("+"V"+":"+getIP11+")");
        }
        else if (str9.equals("0c"))
        {
            btnO9.setText(getOUT9+"("+"V"+":"+getIP12+")");
        }
        else if (str9.equals("0d"))
        {
            btnO9.setText(getOUT9+"("+"V"+":"+getIP13+")");
        }
        else if (str9.equals("0e"))
        {
            btnO9.setText(getOUT9+"("+"V"+":"+getIP14+")");
        }
        else if (str9.equals("0f"))
        {
            btnO9.setText(getOUT9+"("+"V"+":"+getIP15+")");
        }
        else if (str9.equals("10"))
        {
            btnO9.setText(getOUT9+"("+"V"+":"+getIP16+")");
        }
/////////////////////////////////////////////////////////////////////////////////////////////////////////// Output 10 /////////////////////////////////////////////////////////////////////////////////////
        try {
            byte[] byteInput = new byte[]{0x20,0x07,0x0a,0x00,(byte) 0xed};
            DataOutputStream getinput = new DataOutputStream(m_socket.getOutputStream());
            getinput.write(byteInput);
            getinput.flush();

            DataInputStream in = new DataInputStream(m_socket.getInputStream());
            int c = in.read(buff,0,buff.length);
            chaStr(c);

            str10 = feedback[feedback.length-2];

        } catch (IOException e) {
            e.printStackTrace();
        }
        if (str10.equals("00"))
        {
            btnO10.setText(getOUT10);
        }
        else if (str10.equals("01"))
        {

            inputString1 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString1","1");
            btnO10.setText(getOUT10+"("+"V"+":"+getIP1+")");

        }
        else if (str10.equals("02"))
        {
            inputString2 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString2","2");
            btnO10.setText(getOUT10+"("+"V"+":"+getIP2+")");
        }
        else if (str10.equals("03"))
        {
            inputString3 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString3","3");
            btnO10.setText(getOUT10+"("+"V"+":"+getIP3+")");
        }
        else if (str10.equals("04"))
        {
            inputString4 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString4","4");
            btnO10.setText(getOUT10+"("+"V"+":"+getIP4+")");
        }
        else if (str10.equals("05"))
        {
            inputString5 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString5","5");
            btnO10.setText(getOUT10+"("+"V"+":"+getIP5+")");
        }
        else if (str10.equals("06"))
        {
            inputString6 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString6","6");
            btnO10.setText(getOUT10+"("+"V"+":"+getIP6+")");
        }
        else if (str10.equals("07"))
        {
            inputString7 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString7","7");
            btnO10.setText(getOUT10+"("+"V"+":"+getIP7+")");
        }
        else if (str10.equals("08"))
        {
            inputString8 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString8","8");
            btnO10.setText(getOUT10+"("+"V"+":"+getIP8+")");
        }
        else if (str10.equals("09"))
        {
            btnO10.setText(getOUT10+"("+"V"+":"+getIP9+")");
        }
        else if (str10.equals("0a"))
        {
            btnO10.setText(getOUT10+"("+"V"+":"+getIP10+")");
        }
        else if (str10.equals("0b"))
        {
            btnO10.setText(getOUT10+"("+"V"+":"+getIP11+")");
        }
        else if (str10.equals("0c"))
        {
            btnO10.setText(getOUT10+"("+"V"+":"+getIP12+")");
        }
        else if (str10.equals("0d"))
        {
            btnO10.setText(getOUT10+"("+"V"+":"+getIP13+")");
        }
        else if (str10.equals("0e"))
        {
            btnO10.setText(getOUT10+"("+"V"+":"+getIP14+")");
        }
        else if (str10.equals("0f"))
        {
            btnO10.setText(getOUT10+"("+"V"+":"+getIP15+")");
        }
        else if (str10.equals("10"))
        {
            btnO10.setText(getOUT10+"("+"V"+":"+getIP16+")");
        }
/////////////////////////////////////////////////////////////////////////////////////////////////////////// Output 11 /////////////////////////////////////////////////////////////////////////////////////
        try {
            byte[] byteInput = new byte[]{0x20,0x07,0x0b,0x00,(byte) 0x29};
            DataOutputStream getinput = new DataOutputStream(m_socket.getOutputStream());
            getinput.write(byteInput);
            getinput.flush();

            DataInputStream in = new DataInputStream(m_socket.getInputStream());
            int c = in.read(buff,0,buff.length);
            chaStr(c);

            str11 = feedback[feedback.length-2];

        } catch (IOException e) {
            e.printStackTrace();
        }
        if (str11.equals("00"))
        {
            btnO11.setText(getOUT11);
        }
        else if (str11.equals("01"))
        {

            inputString1 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString1","1");
            btnO11.setText(getOUT11+"("+"V"+":"+getIP1+")");

        }
        else if (str11.equals("02"))
        {
            inputString2 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString2","2");
            btnO11.setText(getOUT11+"("+"V"+":"+getIP2+")");
        }
        else if (str11.equals("03"))
        {
            inputString3 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString3","3");
            btnO11.setText(getOUT11+"("+"V"+":"+getIP3+")");
        }
        else if (str11.equals("04"))
        {
            inputString4 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString4","4");
            btnO11.setText(getOUT11+"("+"V"+":"+getIP4+")");
        }
        else if (str11.equals("05"))
        {
            inputString5 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString5","5");
            btnO11.setText(getOUT11+"("+"V"+":"+getIP5+")");
        }
        else if (str11.equals("06"))
        {
            inputString6 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString6","6");
            btnO11.setText(getOUT11+"("+"V"+":"+getIP6+")");
        }
        else if (str11.equals("07"))
        {
            inputString7 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString7","7");
            btnO11.setText(getOUT11+"("+"V"+":"+getIP7+")");
        }
        else if (str11.equals("08"))
        {
            inputString8 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString8","8");
            btnO11.setText(getOUT11+"("+"V"+":"+getIP8+")");
        }
        else if (str11.equals("09"))
        {
            btnO11.setText(getOUT11+"("+"V"+":"+getIP9+")");
        }
        else if (str11.equals("0a"))
        {
            btnO11.setText(getOUT11+"("+"V"+":"+getIP10+")");
        }
        else if (str11.equals("0b"))
        {
            btnO11.setText(getOUT11+"("+"V"+":"+getIP11+")");
        }
        else if (str11.equals("0c"))
        {
            btnO11.setText(getOUT11+"("+"V"+":"+getIP12+")");
        }
        else if (str11.equals("0d"))
        {
            btnO11.setText(getOUT11+"("+"V"+":"+getIP13+")");
        }
        else if (str11.equals("0e"))
        {
            btnO11.setText(getOUT11+"("+"V"+":"+getIP14+")");
        }
        else if (str11.equals("0f"))
        {
            btnO11.setText(getOUT11+"("+"V"+":"+getIP15+")");
        }
        else if (str11.equals("10"))
        {
            btnO11.setText(getOUT11+"("+"V"+":"+getIP16+")");
        }
/////////////////////////////////////////////////////////////////////////////////////////////////////////// Output 12 /////////////////////////////////////////////////////////////////////////////////////
        try {
            byte[] byteInput = new byte[]{0x20,0x07,0x0c,0x00,(byte) 0x47};
            DataOutputStream getinput = new DataOutputStream(m_socket.getOutputStream());
            getinput.write(byteInput);
            getinput.flush();

            DataInputStream in = new DataInputStream(m_socket.getInputStream());
            int c = in.read(buff,0,buff.length);
            chaStr(c);

            str12 = feedback[feedback.length-2];

        } catch (IOException e) {
            e.printStackTrace();
        }
        if (str12.equals("00"))
        {
            btnO12.setText(getOUT12);
        }
        else if (str12.equals("01"))
        {

            inputString1 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString1","1");
            btnO12.setText(getOUT12+"("+"V"+":"+getIP1+")");

        }
        else if (str12.equals("02"))
        {
            inputString2 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString2","2");
            btnO12.setText(getOUT12+"("+"V"+":"+getIP2+")");
        }
        else if (str12.equals("03"))
        {
            inputString3 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString3","3");
            btnO12.setText(getOUT12+"("+"V"+":"+getIP3+")");
        }
        else if (str12.equals("04"))
        {
            inputString4 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString4","4");
            btnO12.setText(getOUT12+"("+"V"+":"+getIP4+")");
        }
        else if (str12.equals("05"))
        {
            inputString5 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString5","5");
            btnO12.setText(getOUT12+"("+"V"+":"+getIP5+")");
        }
        else if (str12.equals("06"))
        {
            inputString6 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString6","6");
            btnO12.setText(getOUT12+"("+"V"+":"+getIP6+")");
        }
        else if (str12.equals("07"))
        {
            inputString7 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString7","7");
            btnO12.setText(getOUT12+"("+"V"+":"+getIP7+")");
        }
        else if (str12.equals("08"))
        {
            inputString8 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString8","8");
            btnO12.setText(getOUT12+"("+"V"+":"+getIP8+")");
        }
        else if (str12.equals("09"))
        {
            btnO12.setText(getOUT12+"("+"V"+":"+getIP9+")");
        }
        else if (str12.equals("0a"))
        {
            btnO12.setText(getOUT12+"("+"V"+":"+getIP10+")");
        }
        else if (str12.equals("0b"))
        {
            btnO12.setText(getOUT12+"("+"V"+":"+getIP11+")");
        }
        else if (str12.equals("0c"))
        {
            btnO12.setText(getOUT12+"("+"V"+":"+getIP12+")");
        }
        else if (str12.equals("0d"))
        {
            btnO12.setText(getOUT12+"("+"V"+":"+getIP13+")");
        }
        else if (str12.equals("0e"))
        {
            btnO12.setText(getOUT12+"("+"V"+":"+getIP14+")");
        }
        else if (str12.equals("0f"))
        {
            btnO12.setText(getOUT12+"("+"V"+":"+getIP15+")");
        }
        else if (str12.equals("10"))
        {
            btnO12.setText(getOUT12+"("+"V"+":"+getIP16+")");
        }
/////////////////////////////////////////////////////////////////////////////////////////////////////////// Output 13 /////////////////////////////////////////////////////////////////////////////////////
        try {
            byte[] byteInput = new byte[]{0x20,0x07,0x0d,0x00,(byte) 0x83};
            DataOutputStream getinput = new DataOutputStream(m_socket.getOutputStream());
            getinput.write(byteInput);
            getinput.flush();

            DataInputStream in = new DataInputStream(m_socket.getInputStream());
            int c = in.read(buff,0,buff.length);
            chaStr(c);

            str13 = feedback[feedback.length-2];

        } catch (IOException e) {
            e.printStackTrace();
        }
        if (str13.equals("00"))
        {
            btnO13.setText(getOUT13);
        }
        else if (str13.equals("01"))
        {

            inputString1 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString1","1");
            btnO13.setText(getOUT13+"("+"V"+":"+getIP1+")");

        }
        else if (str13.equals("02"))
        {
            inputString2 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString2","2");
            btnO13.setText(getOUT13+"("+"V"+":"+getIP2+")");
        }
        else if (str13.equals("03"))
        {
            inputString3 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString3","3");
            btnO13.setText(getOUT13+"("+"V"+":"+getIP3+")");
        }
        else if (str13.equals("04"))
        {
            inputString4 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString4","4");
            btnO13.setText(getOUT13+"("+"V"+":"+getIP4+")");
        }
        else if (str13.equals("05"))
        {
            inputString5 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString5","5");
            btnO13.setText(getOUT13+"("+"V"+":"+getIP5+")");
        }
        else if (str13.equals("06"))
        {
            inputString6 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString6","6");
            btnO13.setText(getOUT13+"("+"V"+":"+getIP6+")");
        }
        else if (str13.equals("07"))
        {
            inputString7 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString7","7");
            btnO13.setText(getOUT13+"("+"V"+":"+getIP7+")");
        }
        else if (str13.equals("08"))
        {
            inputString8 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString8","8");
            btnO13.setText(getOUT13+"("+"V"+":"+getIP8+")");
        }
        else if (str13.equals("09"))
        {
            btnO13.setText(getOUT13+"("+"V"+":"+getIP9+")");
        }
        else if (str13.equals("0a"))
        {
            btnO13.setText(getOUT13+"("+"V"+":"+getIP10+")");
        }
        else if (str13.equals("0b"))
        {
            btnO13.setText(getOUT13+"("+"V"+":"+getIP11+")");
        }
        else if (str13.equals("0c"))
        {
            btnO13.setText(getOUT13+"("+"V"+":"+getIP12+")");
        }
        else if (str13.equals("0d"))
        {
            btnO13.setText(getOUT13+"("+"V"+":"+getIP13+")");
        }
        else if (str13.equals("0e"))
        {
            btnO13.setText(getOUT13+"("+"V"+":"+getIP14+")");
        }
        else if (str13.equals("0f"))
        {
            btnO13.setText(getOUT13+"("+"V"+":"+getIP15+")");
        }
        else if (str13.equals("10"))
        {
            btnO13.setText(getOUT13+"("+"V"+":"+getIP16+")");
        }
/////////////////////////////////////////////////////////////////////////////////////////////////////////// Output 14 /////////////////////////////////////////////////////////////////////////////////////
        try {
            byte[] byteInput = new byte[]{0x20,0x07,0x0e,0x00,(byte) 0xd6};
            DataOutputStream getinput = new DataOutputStream(m_socket.getOutputStream());
            getinput.write(byteInput);
            getinput.flush();

            DataInputStream in = new DataInputStream(m_socket.getInputStream());
            int c = in.read(buff,0,buff.length);
            chaStr(c);

            str14 = feedback[feedback.length-2];

        } catch (IOException e) {
            e.printStackTrace();
        }
        if (str14.equals("00"))
        {
            btnO14.setText(getOUT14);
        }
        else if (str14.equals("01"))
        {

            inputString1 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString1","1");
            btnO14.setText(getOUT14+"("+"V"+":"+getIP1+")");

        }
        else if (str14.equals("02"))
        {
            inputString2 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString2","2");
            btnO14.setText(getOUT14+"("+"V"+":"+getIP2+")");
        }
        else if (str14.equals("03"))
        {
            inputString3 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString3","3");
            btnO14.setText(getOUT14+"("+"V"+":"+getIP3+")");
        }
        else if (str14.equals("04"))
        {
            inputString4 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString4","4");
            btnO14.setText(getOUT14+"("+"V"+":"+getIP4+")");
        }
        else if (str14.equals("05"))
        {
            inputString5 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString5","5");
            btnO14.setText(getOUT14+"("+"V"+":"+getIP5+")");
        }
        else if (str14.equals("06"))
        {
            inputString6 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString6","6");
            btnO14.setText(getOUT14+"("+"V"+":"+getIP6+")");
        }
        else if (str14.equals("07"))
        {
            inputString7 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString7","7");
            btnO14.setText(getOUT14+"("+"V"+":"+getIP7+")");
        }
        else if (str14.equals("08"))
        {
            inputString8 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString8","8");
            btnO14.setText(getOUT14+"("+"V"+":"+getIP8+")");
        }
        else if (str14.equals("09"))
        {
            btnO14.setText(getOUT14+"("+"V"+":"+getIP9+")");
        }
        else if (str14.equals("0a"))
        {
            btnO14.setText(getOUT14+"("+"V"+":"+getIP10+")");
        }
        else if (str14.equals("0b"))
        {
            btnO14.setText(getOUT14+"("+"V"+":"+getIP11+")");
        }
        else if (str14.equals("0c"))
        {
            btnO14.setText(getOUT14+"("+"V"+":"+getIP12+")");
        }
        else if (str14.equals("0d"))
        {
            btnO14.setText(getOUT14+"("+"V"+":"+getIP13+")");
        }
        else if (str14.equals("0e"))
        {
            btnO14.setText(getOUT14+"("+"V"+":"+getIP14+")");
        }
        else if (str14.equals("0f"))
        {
            btnO14.setText(getOUT14+"("+"V"+":"+getIP15+")");
        }
        else if (str14.equals("10"))
        {
            btnO14.setText(getOUT14+"("+"V"+":"+getIP16+")");
        }
/////////////////////////////////////////////////////////////////////////////////////////////////////////// Output 15 /////////////////////////////////////////////////////////////////////////////////////
        try {
            byte[] byteInput = new byte[]{0x20,0x07,0x0f,0x00,(byte) 0x12};
            DataOutputStream getinput = new DataOutputStream(m_socket.getOutputStream());
            getinput.write(byteInput);
            getinput.flush();

            DataInputStream in = new DataInputStream(m_socket.getInputStream());
            int c = in.read(buff,0,buff.length);
            chaStr(c);

            str15 = feedback[feedback.length-2];

        } catch (IOException e) {
            e.printStackTrace();
        }
        if (str15.equals("00"))
        {
            btnO15.setText(getOUT15);
        }
        else if (str15.equals("01"))
        {

            inputString1 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString1","1");
            btnO15.setText(getOUT15+"("+"V"+":"+getIP1+")");

        }
        else if (str15.equals("02"))
        {
            inputString2 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString2","2");
            btnO15.setText(getOUT15+"("+"V"+":"+getIP2+")");
        }
        else if (str15.equals("03"))
        {
            inputString3 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString3","3");
            btnO15.setText(getOUT15+"("+"V"+":"+getIP3+")");
        }
        else if (str15.equals("04"))
        {
            inputString4 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString4","4");
            btnO15.setText(getOUT15+"("+"V"+":"+getIP4+")");
        }
        else if (str15.equals("05"))
        {
            inputString5 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString5","5");
            btnO15.setText(getOUT15+"("+"V"+":"+getIP5+")");
        }
        else if (str15.equals("06"))
        {
            inputString6 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString6","6");
            btnO15.setText(getOUT15+"("+"V"+":"+getIP6+")");
        }
        else if (str15.equals("07"))
        {
            inputString7 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString7","7");
            btnO15.setText(getOUT15+"("+"V"+":"+getIP7+")");
        }
        else if (str15.equals("08"))
        {
            inputString8 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString8","8");
            btnO15.setText(getOUT15+"("+"V"+":"+getIP8+")");
        }
        else if (str15.equals("09"))
        {
            btnO15.setText(getOUT15+"("+"V"+":"+getIP9+")");
        }
        else if (str15.equals("0a"))
        {
            btnO15.setText(getOUT15+"("+"V"+":"+getIP10+")");
        }
        else if (str15.equals("0b"))
        {
            btnO15.setText(getOUT15+"("+"V"+":"+getIP11+")");
        }
        else if (str15.equals("0c"))
        {
            btnO15.setText(getOUT15+"("+"V"+":"+getIP12+")");
        }
        else if (str15.equals("0d"))
        {
            btnO15.setText(getOUT15+"("+"V"+":"+getIP13+")");
        }
        else if (str15.equals("0e"))
        {
            btnO15.setText(getOUT15+"("+"V"+":"+getIP14+")");
        }
        else if (str15.equals("0f"))
        {
            btnO15.setText(getOUT15+"("+"V"+":"+getIP15+")");
        }
        else if (str15.equals("10"))
        {
            btnO15.setText(getOUT15+"("+"V"+":"+getIP16+")");
        }
/////////////////////////////////////////////////////////////////////////////////////////////////////////// Output 16 /////////////////////////////////////////////////////////////////////////////////////
        try {
            byte[] byteInput = new byte[]{0x20,0x07,0x10,0x00,(byte) 0xe6};
            DataOutputStream getinput = new DataOutputStream(m_socket.getOutputStream());
            getinput.write(byteInput);
            getinput.flush();

            DataInputStream in = new DataInputStream(m_socket.getInputStream());
            int c = in.read(buff,0,buff.length);
            chaStr(c);

            str16 = feedback[feedback.length-2];

        } catch (IOException e) {
            e.printStackTrace();
        }
        if (str16.equals("00"))
        {
            btnO16.setText(getOUT16);
        }
        else if (str16.equals("01"))
        {

            inputString1 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString1","1");
            btnO16.setText(getOUT16+"("+"V"+":"+getIP1+")");

        }
        else if (str16.equals("02"))
        {
            inputString2 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString2","2");
            btnO16.setText(getOUT16+"("+"V"+":"+getIP2+")");
        }
        else if (str16.equals("03"))
        {
            inputString3 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString3","3");
            btnO16.setText(getOUT16+"("+"V"+":"+getIP3+")");
        }
        else if (str16.equals("04"))
        {
            inputString4 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString4","4");
            btnO16.setText(getOUT16+"("+"V"+":"+getIP4+")");
        }
        else if (str16.equals("05"))
        {
            inputString5 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString5","5");
            btnO16.setText(getOUT16+"("+"V"+":"+getIP5+")");
        }
        else if (str16.equals("06"))
        {
            inputString6 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString6","6");
            btnO16.setText(getOUT16+"("+"V"+":"+getIP6+")");
        }
        else if (str16.equals("07"))
        {
            inputString7 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString7","7");
            btnO16.setText(getOUT16+"("+"V"+":"+getIP7+")");
        }
        else if (str16.equals("08"))
        {
            inputString8 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString8","8");
            btnO16.setText(getOUT16+"("+"V"+":"+getIP8+")");
        }
        else if (str16.equals("09"))
        {
            btnO16.setText(getOUT16+"("+"V"+":"+getIP9+")");
        }
        else if (str16.equals("0a"))
        {
            btnO16.setText(getOUT16+"("+"V"+":"+getIP10+")");
        }
        else if (str16.equals("0b"))
        {
            btnO16.setText(getOUT16+"("+"V"+":"+getIP11+")");
        }
        else if (str16.equals("0c"))
        {
            btnO16.setText(getOUT16+"("+"V"+":"+getIP12+")");
        }
        else if (str16.equals("0d"))
        {
            btnO16.setText(getOUT16+"("+"V"+":"+getIP13+")");
        }
        else if (str16.equals("0e"))
        {
            btnO16.setText(getOUT16+"("+"V"+":"+getIP14+")");
        }
        else if (str16.equals("0f"))
        {
            btnO16.setText(getOUT16+"("+"V"+":"+getIP15+")");
        }
        else if (str16.equals("10"))
        {
            btnO16.setText(getOUT16+"("+"V"+":"+getIP16+")");
        }
    }

}