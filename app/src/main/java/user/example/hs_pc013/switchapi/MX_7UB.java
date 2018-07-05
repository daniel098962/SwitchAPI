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

public class MX_7UB extends ClientCode {

    ImageButton btnC;
    ImageButton btnF;
    ImageButton btnS;
    RadioGroup rgAV,rgIN,rgIN2,rgIN3,rgIN4,rgIN5,rgIN6,rgIN7,rgIN8,rgOP,rgOP2,rgOP3,rgOP4,rgOP5,rgOP6,rgOP7,rgOP8,rgME,rgAll;
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
    RadioButton btnIN17;
    RadioButton btnIN18;
    RadioButton btnIN19;
    RadioButton btnIN20;
    RadioButton btnIN21;
    RadioButton btnIN22;
    RadioButton btnIN23;
    RadioButton btnIN24;
    RadioButton btnIN25;
    RadioButton btnIN26;
    RadioButton btnIN27;
    RadioButton btnIN28;
    RadioButton btnIN29;
    RadioButton btnIN30;
    RadioButton btnIN31;
    RadioButton btnIN32;
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
    RadioButton btnO17;
    RadioButton btnO18;
    RadioButton btnO19;
    RadioButton btnO20;
    RadioButton btnO21;
    RadioButton btnO22;
    RadioButton btnO23;
    RadioButton btnO24;
    RadioButton btnO25;
    RadioButton btnO26;
    RadioButton btnO27;
    RadioButton btnO28;
    RadioButton btnO29;
    RadioButton btnO30;
    RadioButton btnO31;
    RadioButton btnO32;
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
    String str1,str2,str3,str4,str5,str6,str7,str8,str9,str10,str11,str12,str13,str14,str15,str16,str17,str18,str19,str20,str21,str22,str23,str24,str25,str26,str27,str28,str29,str30,str31,str32;
    int a;
    String feedback[],bx,VerAB,VerA,VerB;
    int len,LB,INF,DN,CB,Ot,It,IB;
    char T[],TF[];
    String AorV = "";
    int InpuT=1,OutpuT;
    String inputString;
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
    String getIP17,getIP18,getIP19,getIP20,getIP21,getIP22,getIP23,getIP24;
    String getIP25,getIP26,getIP27,getIP28,getIP29,getIP30,getIP31,getIP32;
    String getOUT1,getOUT2,getOUT3,getOUT4,getOUT5,getOUT6,getOUT7,getOUT8;
    String getOUT9,getOUT10,getOUT11,getOUT12,getOUT13,getOUT14,getOUT15,getOUT16;
    String getOUT17,getOUT18,getOUT19,getOUT20,getOUT21,getOUT22,getOUT23,getOUT24;
    String getOUT25,getOUT26,getOUT27,getOUT28,getOUT29,getOUT30,getOUT31,getOUT32;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mx_7_ub);

        rgAV = (RadioGroup)findViewById(R.id.segmentAV);
        rgIN = (RadioGroup)findViewById(R.id.segmentedIn);
        rgIN2 = (RadioGroup)findViewById(R.id.segmentInput2);
        rgIN3 = (RadioGroup)findViewById(R.id.segmentedIn3);
        rgIN4 = (RadioGroup)findViewById(R.id.segmentedIn4);
        rgIN5 = (RadioGroup)findViewById(R.id.segmentedIn5);
        rgIN6 = (RadioGroup)findViewById(R.id.segmentedIn6);
        rgIN7 = (RadioGroup)findViewById(R.id.segmentedIn7);
        rgIN8 = (RadioGroup)findViewById(R.id.segmentedIn8);

        rgOP = (RadioGroup)findViewById(R.id.segmentOutput);
        rgOP2 = (RadioGroup)findViewById(R.id.segmentOutput2);
        rgOP3 = (RadioGroup)findViewById(R.id.segmentOutput3);
        rgOP4 = (RadioGroup)findViewById(R.id.segmentOutput4);
        rgOP5 = (RadioGroup)findViewById(R.id.segmentOutput5);
        rgOP6 = (RadioGroup)findViewById(R.id.segmentOutput6);
        rgOP7 = (RadioGroup)findViewById(R.id.segmentOutput7);
        rgOP8 = (RadioGroup)findViewById(R.id.segmentOutput8);
        rgME = (RadioGroup)findViewById(R.id.segmentMe);
        rgAll = (RadioGroup)findViewById(R.id.segmentAll);

        rgAV.setOnCheckedChangeListener(radLis);
        rgIN.setOnCheckedChangeListener(radLis);
        rgIN2.setOnCheckedChangeListener(radLis);
        rgIN3.setOnCheckedChangeListener(radLis);
        rgIN4.setOnCheckedChangeListener(radLis);
        rgIN5.setOnCheckedChangeListener(radLis);
        rgIN6.setOnCheckedChangeListener(radLis);
        rgIN7.setOnCheckedChangeListener(radLis);
        rgIN8.setOnCheckedChangeListener(radLis);
        rgOP.setOnCheckedChangeListener(radLis);
        rgOP2.setOnCheckedChangeListener(radLis);
        rgOP3.setOnCheckedChangeListener(radLis);
        rgOP4.setOnCheckedChangeListener(radLis);
        rgOP5.setOnCheckedChangeListener(radLis);
        rgOP6.setOnCheckedChangeListener(radLis);
        rgOP7.setOnCheckedChangeListener(radLis);
        rgOP8.setOnCheckedChangeListener(radLis);
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
        rgIN5.getLayoutParams().width = (int)(vWidth-214.2);
        rgIN6.getLayoutParams().width = (int)(vWidth-214.2);
        rgIN7.getLayoutParams().width = (int)(vWidth-214.2);
        rgIN8.getLayoutParams().width = (int)(vWidth-214.2);
        rgAll.getLayoutParams().width=(int)((vWidth-214.2)/2);
        rgOP.getLayoutParams().width = (int)(vWidth-214.2);
        rgOP2.getLayoutParams().width = (int)(vWidth-214.2);
        rgOP3.getLayoutParams().width = (int)(vWidth-214.2);
        rgOP4.getLayoutParams().width = (int)(vWidth-214.2);
        rgOP5.getLayoutParams().width = (int)(vWidth-214.2);
        rgOP6.getLayoutParams().width = (int)(vWidth-214.2);
        rgOP7.getLayoutParams().width = (int)(vWidth-214.2);
        rgOP8.getLayoutParams().width = (int)(vWidth-214.2);
        rgME.getLayoutParams().width=(int)((vWidth-214.2)/2);

        btnC = (ImageButton) findViewById(R.id.btnLink);
        btnC.setOnClickListener(btnLis);

        btnF = (ImageButton) findViewById(R.id.btnI);
        btnF.setOnClickListener(btnLis);

        btnS = (ImageButton) findViewById(R.id.btnS);
        btnS.setOnClickListener(btnLis);

        btnA1 = (RadioButton) findViewById(R.id.btnAV1);
        btnA2 = (RadioButton) findViewById(R.id.btnAV2);

        btnIN1 = (RadioButton) findViewById(R.id.btnIN1);
        btnIN2 = (RadioButton) findViewById(R.id.btnIN2);
        btnIN3 = (RadioButton) findViewById(R.id.btnIN3);
        btnIN4 = (RadioButton) findViewById(R.id.btnIN4);
        btnIN5 = (RadioButton) findViewById(R.id.btnIN5);
        btnIN6 = (RadioButton) findViewById(R.id.btnIN6);
        btnIN7 = (RadioButton) findViewById(R.id.btnIN7);
        btnIN8 = (RadioButton) findViewById(R.id.btnIN8);
        btnIN9 = (RadioButton) findViewById(R.id.btnIN9);
        btnIN10 = (RadioButton) findViewById(R.id.btnIN10);
        btnIN11 = (RadioButton) findViewById(R.id.btnIN11);
        btnIN12 = (RadioButton) findViewById(R.id.btnIN12);
        btnIN13 = (RadioButton) findViewById(R.id.btnIN13);
        btnIN14 = (RadioButton) findViewById(R.id.btnIN14);
        btnIN15 = (RadioButton) findViewById(R.id.btnIN15);
        btnIN16 = (RadioButton) findViewById(R.id.btnIN16);
        btnIN17 = (RadioButton) findViewById(R.id.btnIN17);
        btnIN18 = (RadioButton) findViewById(R.id.btnIN18);
        btnIN19 = (RadioButton) findViewById(R.id.btnIN19);
        btnIN20 = (RadioButton) findViewById(R.id.btnIN20);
        btnIN21 = (RadioButton) findViewById(R.id.btnIN21);
        btnIN22 = (RadioButton) findViewById(R.id.btnIN22);
        btnIN23 = (RadioButton) findViewById(R.id.btnIN23);
        btnIN24 = (RadioButton) findViewById(R.id.btnIN24);
        btnIN25 = (RadioButton) findViewById(R.id.btnIN25);
        btnIN26 = (RadioButton) findViewById(R.id.btnIN26);
        btnIN27 = (RadioButton) findViewById(R.id.btnIN27);
        btnIN28 = (RadioButton) findViewById(R.id.btnIN28);
        btnIN29 = (RadioButton) findViewById(R.id.btnIN29);
        btnIN30 = (RadioButton) findViewById(R.id.btnIN30);
        btnIN31 = (RadioButton) findViewById(R.id.btnIN31);
        btnIN32 = (RadioButton) findViewById(R.id.btnIN32);

        btnO1 = (RadioButton) findViewById(R.id.btnOU1);
        btnO2 = (RadioButton) findViewById(R.id.btnOU2);
        btnO3 = (RadioButton) findViewById(R.id.btnOU3);
        btnO4 = (RadioButton) findViewById(R.id.btnOU4);
        btnO5 = (RadioButton) findViewById(R.id.btnOU5);
        btnO6 = (RadioButton) findViewById(R.id.btnOU6);
        btnO7 = (RadioButton) findViewById(R.id.btnOU7);
        btnO8 = (RadioButton) findViewById(R.id.btnOU8);
        btnO9 = (RadioButton) findViewById(R.id.btnOU9);
        btnO10 = (RadioButton) findViewById(R.id.btnOU10);
        btnO11 = (RadioButton) findViewById(R.id.btnOU11);
        btnO12 = (RadioButton) findViewById(R.id.btnOU12);
        btnO13 = (RadioButton) findViewById(R.id.btnOU13);
        btnO14 = (RadioButton) findViewById(R.id.btnOU14);
        btnO15 = (RadioButton) findViewById(R.id.btnOU15);
        btnO16 = (RadioButton) findViewById(R.id.btnOU16);
        btnO17 = (RadioButton) findViewById(R.id.btnOU17);
        btnO18 = (RadioButton) findViewById(R.id.btnOU18);
        btnO19 = (RadioButton) findViewById(R.id.btnOU19);
        btnO20 = (RadioButton) findViewById(R.id.btnOU20);
        btnO21 = (RadioButton) findViewById(R.id.btnOU21);
        btnO22 = (RadioButton) findViewById(R.id.btnOU22);
        btnO23 = (RadioButton) findViewById(R.id.btnOU23);
        btnO24 = (RadioButton) findViewById(R.id.btnOU24);
        btnO25 = (RadioButton) findViewById(R.id.btnOU25);
        btnO26 = (RadioButton) findViewById(R.id.btnOU26);
        btnO27 = (RadioButton) findViewById(R.id.btnOU27);
        btnO28 = (RadioButton) findViewById(R.id.btnOU28);
        btnO29 = (RadioButton) findViewById(R.id.btnOU29);
        btnO30 = (RadioButton) findViewById(R.id.btnOU30);
        btnO31 = (RadioButton) findViewById(R.id.btnOU31);
        btnO32 = (RadioButton) findViewById(R.id.btnOU32);

        btnM1 = (RadioButton) findViewById(R.id.btnME1);
        btnM2 = (RadioButton) findViewById(R.id.btnME2);
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

                    change.setClass(MX_7UB.this,ClientCode.class);

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
                    Input17 = btnIN17.getText().toString();
                    Input18 = btnIN18.getText().toString();
                    Input19 = btnIN19.getText().toString();
                    Input20 = btnIN20.getText().toString();
                    Input21 = btnIN21.getText().toString();
                    Input22 = btnIN22.getText().toString();
                    Input23 = btnIN23.getText().toString();
                    Input24 = btnIN24.getText().toString();
                    Input25 = btnIN25.getText().toString();
                    Input26 = btnIN26.getText().toString();
                    Input27 = btnIN27.getText().toString();
                    Input28 = btnIN28.getText().toString();
                    Input29 = btnIN29.getText().toString();
                    Input30 = btnIN30.getText().toString();
                    Input31 = btnIN31.getText().toString();
                    Input32 = btnIN32.getText().toString();

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
                    Output17 = btnO17.getText().toString();
                    Output18 = btnO18.getText().toString();
                    Output19 = btnO19.getText().toString();
                    Output20 = btnO20.getText().toString();
                    Output21 = btnO21.getText().toString();
                    Output22 = btnO22.getText().toString();
                    Output23 = btnO23.getText().toString();
                    Output24 = btnO24.getText().toString();
                    Output25 = btnO25.getText().toString();
                    Output26 = btnO26.getText().toString();
                    Output27 = btnO27.getText().toString();
                    Output28 = btnO28.getText().toString();
                    Output29 = btnO29.getText().toString();
                    Output30 = btnO30.getText().toString();
                    Output31 = btnO31.getText().toString();
                    Output32 = btnO32.getText().toString();
////////////////////////////////////////////////////////////////////////////////////////////// 3/13 做到這/////////////////////////////////////////////////////////////////////////////////////
                    change.setClass(MX_7UB.this,SettingConfig7UB.class);
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
                    bundleConSet.putString("In17",Input17);
                    bundleConSet.putString("In18",Input18);
                    bundleConSet.putString("In19",Input19);
                    bundleConSet.putString("In20",Input20);
                    bundleConSet.putString("In21",Input21);
                    bundleConSet.putString("In22",Input22);
                    bundleConSet.putString("In23",Input23);
                    bundleConSet.putString("In24",Input24);
                    bundleConSet.putString("In25",Input25);
                    bundleConSet.putString("In26",Input26);
                    bundleConSet.putString("In27",Input27);
                    bundleConSet.putString("In28",Input28);
                    bundleConSet.putString("In29",Input29);
                    bundleConSet.putString("In30",Input30);
                    bundleConSet.putString("In31",Input31);
                    bundleConSet.putString("In32",Input32);

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
                    bundleConSet.putString("Out17",getOUT17);
                    bundleConSet.putString("Out18",getOUT18);
                    bundleConSet.putString("Out19",getOUT19);
                    bundleConSet.putString("Out20",getOUT20);
                    bundleConSet.putString("Out21",getOUT21);
                    bundleConSet.putString("Out22",getOUT22);
                    bundleConSet.putString("Out23",getOUT23);
                    bundleConSet.putString("Out24",getOUT24);
                    bundleConSet.putString("Out25",getOUT25);
                    bundleConSet.putString("Out26",getOUT26);
                    bundleConSet.putString("Out27",getOUT27);
                    bundleConSet.putString("Out28",getOUT28);
                    bundleConSet.putString("Out29",getOUT29);
                    bundleConSet.putString("Out30",getOUT30);
                    bundleConSet.putString("Out31",getOUT31);
                    bundleConSet.putString("Out32",getOUT32);

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

                    change.setClass(MX_7UB.this, AV_Setting_MX.class);
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
                    btnIN17.setTextColor(Color.parseColor("#c90000"));
                    btnIN18.setTextColor(Color.parseColor("#c90000"));
                    btnIN19.setTextColor(Color.parseColor("#c90000"));
                    btnIN20.setTextColor(Color.parseColor("#c90000"));
                    btnIN21.setTextColor(Color.parseColor("#c90000"));
                    btnIN22.setTextColor(Color.parseColor("#c90000"));
                    btnIN23.setTextColor(Color.parseColor("#c90000"));
                    btnIN24.setTextColor(Color.parseColor("#c90000"));
                    btnIN25.setTextColor(Color.parseColor("#c90000"));
                    btnIN26.setTextColor(Color.parseColor("#c90000"));
                    btnIN27.setTextColor(Color.parseColor("#c90000"));
                    btnIN28.setTextColor(Color.parseColor("#c90000"));
                    btnIN29.setTextColor(Color.parseColor("#c90000"));
                    btnIN30.setTextColor(Color.parseColor("#c90000"));
                    btnIN31.setTextColor(Color.parseColor("#c90000"));
                    btnIN32.setTextColor(Color.parseColor("#c90000"));

                    InpuT = 1;
                    Inp = 0x01;
                    inputString = btnIN1.getText().toString();
                    LastInput7UB = 1;
                    rgIN2.clearCheck();
                    rgIN3.clearCheck();
                    rgIN4.clearCheck();
                    rgIN5.clearCheck();
                    rgIN6.clearCheck();
                    rgIN7.clearCheck();
                    rgIN8.clearCheck();
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
                    btnIN17.setTextColor(Color.parseColor("#c90000"));
                    btnIN18.setTextColor(Color.parseColor("#c90000"));
                    btnIN19.setTextColor(Color.parseColor("#c90000"));
                    btnIN20.setTextColor(Color.parseColor("#c90000"));
                    btnIN21.setTextColor(Color.parseColor("#c90000"));
                    btnIN22.setTextColor(Color.parseColor("#c90000"));
                    btnIN23.setTextColor(Color.parseColor("#c90000"));
                    btnIN24.setTextColor(Color.parseColor("#c90000"));
                    btnIN25.setTextColor(Color.parseColor("#c90000"));
                    btnIN26.setTextColor(Color.parseColor("#c90000"));
                    btnIN27.setTextColor(Color.parseColor("#c90000"));
                    btnIN28.setTextColor(Color.parseColor("#c90000"));
                    btnIN29.setTextColor(Color.parseColor("#c90000"));
                    btnIN30.setTextColor(Color.parseColor("#c90000"));
                    btnIN31.setTextColor(Color.parseColor("#c90000"));
                    btnIN32.setTextColor(Color.parseColor("#c90000"));

                    InpuT = 2;
                    Inp = 0x02;
                    inputString = btnIN2.getText().toString();
                    LastInput7UB = 2;
                    rgIN2.clearCheck();
                    rgIN3.clearCheck();
                    rgIN4.clearCheck();
                    rgIN5.clearCheck();
                    rgIN6.clearCheck();
                    rgIN7.clearCheck();
                    rgIN8.clearCheck();
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
                    btnIN17.setTextColor(Color.parseColor("#c90000"));
                    btnIN18.setTextColor(Color.parseColor("#c90000"));
                    btnIN19.setTextColor(Color.parseColor("#c90000"));
                    btnIN20.setTextColor(Color.parseColor("#c90000"));
                    btnIN21.setTextColor(Color.parseColor("#c90000"));
                    btnIN22.setTextColor(Color.parseColor("#c90000"));
                    btnIN23.setTextColor(Color.parseColor("#c90000"));
                    btnIN24.setTextColor(Color.parseColor("#c90000"));
                    btnIN25.setTextColor(Color.parseColor("#c90000"));
                    btnIN26.setTextColor(Color.parseColor("#c90000"));
                    btnIN27.setTextColor(Color.parseColor("#c90000"));
                    btnIN28.setTextColor(Color.parseColor("#c90000"));
                    btnIN29.setTextColor(Color.parseColor("#c90000"));
                    btnIN30.setTextColor(Color.parseColor("#c90000"));
                    btnIN31.setTextColor(Color.parseColor("#c90000"));
                    btnIN32.setTextColor(Color.parseColor("#c90000"));

                    InpuT = 3;
                    Inp = 0x03;
                    inputString = btnIN3.getText().toString();
                    LastInput7UB = 3;
                    rgIN2.clearCheck();
                    rgIN3.clearCheck();
                    rgIN4.clearCheck();
                    rgIN5.clearCheck();
                    rgIN6.clearCheck();
                    rgIN7.clearCheck();
                    rgIN8.clearCheck();
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
                    btnIN17.setTextColor(Color.parseColor("#c90000"));
                    btnIN18.setTextColor(Color.parseColor("#c90000"));
                    btnIN19.setTextColor(Color.parseColor("#c90000"));
                    btnIN20.setTextColor(Color.parseColor("#c90000"));
                    btnIN21.setTextColor(Color.parseColor("#c90000"));
                    btnIN22.setTextColor(Color.parseColor("#c90000"));
                    btnIN23.setTextColor(Color.parseColor("#c90000"));
                    btnIN24.setTextColor(Color.parseColor("#c90000"));
                    btnIN25.setTextColor(Color.parseColor("#c90000"));
                    btnIN26.setTextColor(Color.parseColor("#c90000"));
                    btnIN27.setTextColor(Color.parseColor("#c90000"));
                    btnIN28.setTextColor(Color.parseColor("#c90000"));
                    btnIN29.setTextColor(Color.parseColor("#c90000"));
                    btnIN30.setTextColor(Color.parseColor("#c90000"));
                    btnIN31.setTextColor(Color.parseColor("#c90000"));
                    btnIN32.setTextColor(Color.parseColor("#c90000"));

                    InpuT = 4;
                    Inp = 0x04;
                    inputString = btnIN4.getText().toString();
                    LastInput7UB = 4;
                    rgIN2.clearCheck();
                    rgIN3.clearCheck();
                    rgIN4.clearCheck();
                    rgIN5.clearCheck();
                    rgIN6.clearCheck();
                    rgIN7.clearCheck();
                    rgIN8.clearCheck();
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
                    btnIN17.setTextColor(Color.parseColor("#c90000"));
                    btnIN18.setTextColor(Color.parseColor("#c90000"));
                    btnIN19.setTextColor(Color.parseColor("#c90000"));
                    btnIN20.setTextColor(Color.parseColor("#c90000"));
                    btnIN21.setTextColor(Color.parseColor("#c90000"));
                    btnIN22.setTextColor(Color.parseColor("#c90000"));
                    btnIN23.setTextColor(Color.parseColor("#c90000"));
                    btnIN24.setTextColor(Color.parseColor("#c90000"));
                    btnIN25.setTextColor(Color.parseColor("#c90000"));
                    btnIN26.setTextColor(Color.parseColor("#c90000"));
                    btnIN27.setTextColor(Color.parseColor("#c90000"));
                    btnIN28.setTextColor(Color.parseColor("#c90000"));
                    btnIN29.setTextColor(Color.parseColor("#c90000"));
                    btnIN30.setTextColor(Color.parseColor("#c90000"));
                    btnIN31.setTextColor(Color.parseColor("#c90000"));
                    btnIN32.setTextColor(Color.parseColor("#c90000"));

                    InpuT = 5;
                    Inp = 0x05;
                    inputString = btnIN5.getText().toString();
                    LastInput7UB = 5;
                    rgIN.clearCheck();
                    rgIN3.clearCheck();
                    rgIN4.clearCheck();
                    rgIN5.clearCheck();
                    rgIN6.clearCheck();
                    rgIN7.clearCheck();
                    rgIN8.clearCheck();
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
                    btnIN17.setTextColor(Color.parseColor("#c90000"));
                    btnIN18.setTextColor(Color.parseColor("#c90000"));
                    btnIN19.setTextColor(Color.parseColor("#c90000"));
                    btnIN20.setTextColor(Color.parseColor("#c90000"));
                    btnIN21.setTextColor(Color.parseColor("#c90000"));
                    btnIN22.setTextColor(Color.parseColor("#c90000"));
                    btnIN23.setTextColor(Color.parseColor("#c90000"));
                    btnIN24.setTextColor(Color.parseColor("#c90000"));
                    btnIN25.setTextColor(Color.parseColor("#c90000"));
                    btnIN26.setTextColor(Color.parseColor("#c90000"));
                    btnIN27.setTextColor(Color.parseColor("#c90000"));
                    btnIN28.setTextColor(Color.parseColor("#c90000"));
                    btnIN29.setTextColor(Color.parseColor("#c90000"));
                    btnIN30.setTextColor(Color.parseColor("#c90000"));
                    btnIN31.setTextColor(Color.parseColor("#c90000"));
                    btnIN32.setTextColor(Color.parseColor("#c90000"));

                    InpuT = 6;
                    Inp = 0x06;
                    inputString = btnIN6.getText().toString();
                    LastInput7UB = 6;
                    rgIN.clearCheck();
                    rgIN3.clearCheck();
                    rgIN4.clearCheck();
                    rgIN5.clearCheck();
                    rgIN6.clearCheck();
                    rgIN7.clearCheck();
                    rgIN8.clearCheck();
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
                    btnIN17.setTextColor(Color.parseColor("#c90000"));
                    btnIN18.setTextColor(Color.parseColor("#c90000"));
                    btnIN19.setTextColor(Color.parseColor("#c90000"));
                    btnIN20.setTextColor(Color.parseColor("#c90000"));
                    btnIN21.setTextColor(Color.parseColor("#c90000"));
                    btnIN22.setTextColor(Color.parseColor("#c90000"));
                    btnIN23.setTextColor(Color.parseColor("#c90000"));
                    btnIN24.setTextColor(Color.parseColor("#c90000"));
                    btnIN25.setTextColor(Color.parseColor("#c90000"));
                    btnIN26.setTextColor(Color.parseColor("#c90000"));
                    btnIN27.setTextColor(Color.parseColor("#c90000"));
                    btnIN28.setTextColor(Color.parseColor("#c90000"));
                    btnIN29.setTextColor(Color.parseColor("#c90000"));
                    btnIN30.setTextColor(Color.parseColor("#c90000"));
                    btnIN31.setTextColor(Color.parseColor("#c90000"));
                    btnIN32.setTextColor(Color.parseColor("#c90000"));

                    InpuT = 7;
                    Inp = 0x07;
                    inputString = btnIN7.getText().toString();
                    LastInput7UB = 7;
                    rgIN.clearCheck();
                    rgIN3.clearCheck();
                    rgIN4.clearCheck();
                    rgIN5.clearCheck();
                    rgIN6.clearCheck();
                    rgIN7.clearCheck();
                    rgIN8.clearCheck();
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
                    btnIN17.setTextColor(Color.parseColor("#c90000"));
                    btnIN18.setTextColor(Color.parseColor("#c90000"));
                    btnIN19.setTextColor(Color.parseColor("#c90000"));
                    btnIN20.setTextColor(Color.parseColor("#c90000"));
                    btnIN21.setTextColor(Color.parseColor("#c90000"));
                    btnIN22.setTextColor(Color.parseColor("#c90000"));
                    btnIN23.setTextColor(Color.parseColor("#c90000"));
                    btnIN24.setTextColor(Color.parseColor("#c90000"));
                    btnIN25.setTextColor(Color.parseColor("#c90000"));
                    btnIN26.setTextColor(Color.parseColor("#c90000"));
                    btnIN27.setTextColor(Color.parseColor("#c90000"));
                    btnIN28.setTextColor(Color.parseColor("#c90000"));
                    btnIN29.setTextColor(Color.parseColor("#c90000"));
                    btnIN30.setTextColor(Color.parseColor("#c90000"));
                    btnIN31.setTextColor(Color.parseColor("#c90000"));
                    btnIN32.setTextColor(Color.parseColor("#c90000"));

                    InpuT = 8;
                    Inp = 0x08;
                    inputString = btnIN8.getText().toString();
                    LastInput7UB = 8;
                    rgIN.clearCheck();
                    rgIN3.clearCheck();
                    rgIN4.clearCheck();
                    rgIN5.clearCheck();
                    rgIN6.clearCheck();
                    rgIN7.clearCheck();
                    rgIN8.clearCheck();
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
                    btnIN17.setTextColor(Color.parseColor("#c90000"));
                    btnIN18.setTextColor(Color.parseColor("#c90000"));
                    btnIN19.setTextColor(Color.parseColor("#c90000"));
                    btnIN20.setTextColor(Color.parseColor("#c90000"));
                    btnIN21.setTextColor(Color.parseColor("#c90000"));
                    btnIN22.setTextColor(Color.parseColor("#c90000"));
                    btnIN23.setTextColor(Color.parseColor("#c90000"));
                    btnIN24.setTextColor(Color.parseColor("#c90000"));
                    btnIN25.setTextColor(Color.parseColor("#c90000"));
                    btnIN26.setTextColor(Color.parseColor("#c90000"));
                    btnIN27.setTextColor(Color.parseColor("#c90000"));
                    btnIN28.setTextColor(Color.parseColor("#c90000"));
                    btnIN29.setTextColor(Color.parseColor("#c90000"));
                    btnIN30.setTextColor(Color.parseColor("#c90000"));
                    btnIN31.setTextColor(Color.parseColor("#c90000"));
                    btnIN32.setTextColor(Color.parseColor("#c90000"));

                    InpuT = 9;
                    Inp = 0x09;
                    inputString = btnIN9.getText().toString();
                    LastInput7UB = 9;
                    rgIN.clearCheck();
                    rgIN2.clearCheck();
                    rgIN4.clearCheck();
                    rgIN5.clearCheck();
                    rgIN6.clearCheck();
                    rgIN7.clearCheck();
                    rgIN8.clearCheck();
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
                    btnIN17.setTextColor(Color.parseColor("#c90000"));
                    btnIN18.setTextColor(Color.parseColor("#c90000"));
                    btnIN19.setTextColor(Color.parseColor("#c90000"));
                    btnIN20.setTextColor(Color.parseColor("#c90000"));
                    btnIN21.setTextColor(Color.parseColor("#c90000"));
                    btnIN22.setTextColor(Color.parseColor("#c90000"));
                    btnIN23.setTextColor(Color.parseColor("#c90000"));
                    btnIN24.setTextColor(Color.parseColor("#c90000"));
                    btnIN25.setTextColor(Color.parseColor("#c90000"));
                    btnIN26.setTextColor(Color.parseColor("#c90000"));
                    btnIN27.setTextColor(Color.parseColor("#c90000"));
                    btnIN28.setTextColor(Color.parseColor("#c90000"));
                    btnIN29.setTextColor(Color.parseColor("#c90000"));
                    btnIN30.setTextColor(Color.parseColor("#c90000"));
                    btnIN31.setTextColor(Color.parseColor("#c90000"));
                    btnIN32.setTextColor(Color.parseColor("#c90000"));

                    InpuT = 10;
                    Inp = 0x0a;
                    inputString = btnIN10.getText().toString();
                    LastInput7UB = 10;
                    rgIN.clearCheck();
                    rgIN2.clearCheck();
                    rgIN4.clearCheck();
                    rgIN5.clearCheck();
                    rgIN6.clearCheck();
                    rgIN7.clearCheck();
                    rgIN8.clearCheck();
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
                    btnIN17.setTextColor(Color.parseColor("#c90000"));
                    btnIN18.setTextColor(Color.parseColor("#c90000"));
                    btnIN19.setTextColor(Color.parseColor("#c90000"));
                    btnIN20.setTextColor(Color.parseColor("#c90000"));
                    btnIN21.setTextColor(Color.parseColor("#c90000"));
                    btnIN22.setTextColor(Color.parseColor("#c90000"));
                    btnIN23.setTextColor(Color.parseColor("#c90000"));
                    btnIN24.setTextColor(Color.parseColor("#c90000"));
                    btnIN25.setTextColor(Color.parseColor("#c90000"));
                    btnIN26.setTextColor(Color.parseColor("#c90000"));
                    btnIN27.setTextColor(Color.parseColor("#c90000"));
                    btnIN28.setTextColor(Color.parseColor("#c90000"));
                    btnIN29.setTextColor(Color.parseColor("#c90000"));
                    btnIN30.setTextColor(Color.parseColor("#c90000"));
                    btnIN31.setTextColor(Color.parseColor("#c90000"));
                    btnIN32.setTextColor(Color.parseColor("#c90000"));

                    InpuT = 11;
                    Inp = 0x0b;
                    inputString = btnIN11.getText().toString();
                    LastInput7UB = 11;
                    rgIN.clearCheck();
                    rgIN2.clearCheck();
                    rgIN4.clearCheck();
                    rgIN5.clearCheck();
                    rgIN6.clearCheck();
                    rgIN7.clearCheck();
                    rgIN8.clearCheck();
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
                    btnIN17.setTextColor(Color.parseColor("#c90000"));
                    btnIN18.setTextColor(Color.parseColor("#c90000"));
                    btnIN19.setTextColor(Color.parseColor("#c90000"));
                    btnIN20.setTextColor(Color.parseColor("#c90000"));
                    btnIN21.setTextColor(Color.parseColor("#c90000"));
                    btnIN22.setTextColor(Color.parseColor("#c90000"));
                    btnIN23.setTextColor(Color.parseColor("#c90000"));
                    btnIN24.setTextColor(Color.parseColor("#c90000"));
                    btnIN25.setTextColor(Color.parseColor("#c90000"));
                    btnIN26.setTextColor(Color.parseColor("#c90000"));
                    btnIN27.setTextColor(Color.parseColor("#c90000"));
                    btnIN28.setTextColor(Color.parseColor("#c90000"));
                    btnIN29.setTextColor(Color.parseColor("#c90000"));
                    btnIN30.setTextColor(Color.parseColor("#c90000"));
                    btnIN31.setTextColor(Color.parseColor("#c90000"));
                    btnIN32.setTextColor(Color.parseColor("#c90000"));

                    InpuT = 12;
                    Inp = 0x0c;
                    inputString = btnIN12.getText().toString();
                    LastInput7UB = 12;
                    rgIN.clearCheck();
                    rgIN2.clearCheck();
                    rgIN4.clearCheck();
                    rgIN5.clearCheck();
                    rgIN6.clearCheck();
                    rgIN7.clearCheck();
                    rgIN8.clearCheck();
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
                    btnIN17.setTextColor(Color.parseColor("#c90000"));
                    btnIN18.setTextColor(Color.parseColor("#c90000"));
                    btnIN19.setTextColor(Color.parseColor("#c90000"));
                    btnIN20.setTextColor(Color.parseColor("#c90000"));
                    btnIN21.setTextColor(Color.parseColor("#c90000"));
                    btnIN22.setTextColor(Color.parseColor("#c90000"));
                    btnIN23.setTextColor(Color.parseColor("#c90000"));
                    btnIN24.setTextColor(Color.parseColor("#c90000"));
                    btnIN25.setTextColor(Color.parseColor("#c90000"));
                    btnIN26.setTextColor(Color.parseColor("#c90000"));
                    btnIN27.setTextColor(Color.parseColor("#c90000"));
                    btnIN28.setTextColor(Color.parseColor("#c90000"));
                    btnIN29.setTextColor(Color.parseColor("#c90000"));
                    btnIN30.setTextColor(Color.parseColor("#c90000"));
                    btnIN31.setTextColor(Color.parseColor("#c90000"));
                    btnIN32.setTextColor(Color.parseColor("#c90000"));

                    InpuT = 13;
                    Inp = 0x0d;
                    inputString = btnIN13.getText().toString();
                    LastInput7UB = 13;
                    rgIN.clearCheck();
                    rgIN2.clearCheck();
                    rgIN3.clearCheck();
                    rgIN5.clearCheck();
                    rgIN6.clearCheck();
                    rgIN7.clearCheck();
                    rgIN8.clearCheck();
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
                    btnIN17.setTextColor(Color.parseColor("#c90000"));
                    btnIN18.setTextColor(Color.parseColor("#c90000"));
                    btnIN19.setTextColor(Color.parseColor("#c90000"));
                    btnIN20.setTextColor(Color.parseColor("#c90000"));
                    btnIN21.setTextColor(Color.parseColor("#c90000"));
                    btnIN22.setTextColor(Color.parseColor("#c90000"));
                    btnIN23.setTextColor(Color.parseColor("#c90000"));
                    btnIN24.setTextColor(Color.parseColor("#c90000"));
                    btnIN25.setTextColor(Color.parseColor("#c90000"));
                    btnIN26.setTextColor(Color.parseColor("#c90000"));
                    btnIN27.setTextColor(Color.parseColor("#c90000"));
                    btnIN28.setTextColor(Color.parseColor("#c90000"));
                    btnIN29.setTextColor(Color.parseColor("#c90000"));
                    btnIN30.setTextColor(Color.parseColor("#c90000"));
                    btnIN31.setTextColor(Color.parseColor("#c90000"));
                    btnIN32.setTextColor(Color.parseColor("#c90000"));

                    InpuT = 14;
                    Inp = 0x0e;
                    inputString = btnIN14.getText().toString();
                    LastInput7UB = 14;
                    rgIN.clearCheck();
                    rgIN2.clearCheck();
                    rgIN3.clearCheck();
                    rgIN5.clearCheck();
                    rgIN6.clearCheck();
                    rgIN7.clearCheck();
                    rgIN8.clearCheck();
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
                    btnIN17.setTextColor(Color.parseColor("#c90000"));
                    btnIN18.setTextColor(Color.parseColor("#c90000"));
                    btnIN19.setTextColor(Color.parseColor("#c90000"));
                    btnIN20.setTextColor(Color.parseColor("#c90000"));
                    btnIN21.setTextColor(Color.parseColor("#c90000"));
                    btnIN22.setTextColor(Color.parseColor("#c90000"));
                    btnIN23.setTextColor(Color.parseColor("#c90000"));
                    btnIN24.setTextColor(Color.parseColor("#c90000"));
                    btnIN25.setTextColor(Color.parseColor("#c90000"));
                    btnIN26.setTextColor(Color.parseColor("#c90000"));
                    btnIN27.setTextColor(Color.parseColor("#c90000"));
                    btnIN28.setTextColor(Color.parseColor("#c90000"));
                    btnIN29.setTextColor(Color.parseColor("#c90000"));
                    btnIN30.setTextColor(Color.parseColor("#c90000"));
                    btnIN31.setTextColor(Color.parseColor("#c90000"));
                    btnIN32.setTextColor(Color.parseColor("#c90000"));

                    InpuT = 15;
                    Inp = 0x0f;
                    inputString = btnIN15.getText().toString();
                    LastInput7UB = 15;
                    rgIN.clearCheck();
                    rgIN2.clearCheck();
                    rgIN3.clearCheck();
                    rgIN5.clearCheck();
                    rgIN6.clearCheck();
                    rgIN7.clearCheck();
                    rgIN8.clearCheck();
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
                    btnIN17.setTextColor(Color.parseColor("#c90000"));
                    btnIN18.setTextColor(Color.parseColor("#c90000"));
                    btnIN19.setTextColor(Color.parseColor("#c90000"));
                    btnIN20.setTextColor(Color.parseColor("#c90000"));
                    btnIN21.setTextColor(Color.parseColor("#c90000"));
                    btnIN22.setTextColor(Color.parseColor("#c90000"));
                    btnIN23.setTextColor(Color.parseColor("#c90000"));
                    btnIN24.setTextColor(Color.parseColor("#c90000"));
                    btnIN25.setTextColor(Color.parseColor("#c90000"));
                    btnIN26.setTextColor(Color.parseColor("#c90000"));
                    btnIN27.setTextColor(Color.parseColor("#c90000"));
                    btnIN28.setTextColor(Color.parseColor("#c90000"));
                    btnIN29.setTextColor(Color.parseColor("#c90000"));
                    btnIN30.setTextColor(Color.parseColor("#c90000"));
                    btnIN31.setTextColor(Color.parseColor("#c90000"));
                    btnIN32.setTextColor(Color.parseColor("#c90000"));

                    InpuT = 16;
                    Inp = 0x10;
                    inputString = btnIN16.getText().toString();
                    LastInput7UB = 16;
                    rgIN.clearCheck();
                    rgIN2.clearCheck();
                    rgIN3.clearCheck();
                    rgIN5.clearCheck();
                    rgIN6.clearCheck();
                    rgIN7.clearCheck();
                    rgIN8.clearCheck();
                    rgIN4.check(R.id.btnIN16);

                    break;
                }
                case R.id.btnIN17:
                {
                    btnIN17.setTextColor(Color.parseColor("#ffffff"));
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
                    btnIN1.setTextColor(Color.parseColor("#c90000"));
                    btnIN18.setTextColor(Color.parseColor("#c90000"));
                    btnIN19.setTextColor(Color.parseColor("#c90000"));
                    btnIN20.setTextColor(Color.parseColor("#c90000"));
                    btnIN21.setTextColor(Color.parseColor("#c90000"));
                    btnIN22.setTextColor(Color.parseColor("#c90000"));
                    btnIN23.setTextColor(Color.parseColor("#c90000"));
                    btnIN24.setTextColor(Color.parseColor("#c90000"));
                    btnIN25.setTextColor(Color.parseColor("#c90000"));
                    btnIN26.setTextColor(Color.parseColor("#c90000"));
                    btnIN27.setTextColor(Color.parseColor("#c90000"));
                    btnIN28.setTextColor(Color.parseColor("#c90000"));
                    btnIN29.setTextColor(Color.parseColor("#c90000"));
                    btnIN30.setTextColor(Color.parseColor("#c90000"));
                    btnIN31.setTextColor(Color.parseColor("#c90000"));
                    btnIN32.setTextColor(Color.parseColor("#c90000"));

                    InpuT = 17;
                    Inp = 0x11;
                    inputString = btnIN17.getText().toString();
                    LastInput7UB = 17;
                    rgIN2.clearCheck();
                    rgIN3.clearCheck();
                    rgIN4.clearCheck();
                    rgIN.clearCheck();
                    rgIN6.clearCheck();
                    rgIN7.clearCheck();
                    rgIN8.clearCheck();
                    rgIN5.check(R.id.btnIN17);

                    break;
                }
                case R.id.btnIN18:
                {
                    btnIN18.setTextColor(Color.parseColor("#ffffff"));
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
                    btnIN1.setTextColor(Color.parseColor("#c90000"));
                    btnIN17.setTextColor(Color.parseColor("#c90000"));
                    btnIN19.setTextColor(Color.parseColor("#c90000"));
                    btnIN20.setTextColor(Color.parseColor("#c90000"));
                    btnIN21.setTextColor(Color.parseColor("#c90000"));
                    btnIN22.setTextColor(Color.parseColor("#c90000"));
                    btnIN23.setTextColor(Color.parseColor("#c90000"));
                    btnIN24.setTextColor(Color.parseColor("#c90000"));
                    btnIN25.setTextColor(Color.parseColor("#c90000"));
                    btnIN26.setTextColor(Color.parseColor("#c90000"));
                    btnIN27.setTextColor(Color.parseColor("#c90000"));
                    btnIN28.setTextColor(Color.parseColor("#c90000"));
                    btnIN29.setTextColor(Color.parseColor("#c90000"));
                    btnIN30.setTextColor(Color.parseColor("#c90000"));
                    btnIN31.setTextColor(Color.parseColor("#c90000"));
                    btnIN32.setTextColor(Color.parseColor("#c90000"));

                    InpuT = 18;
                    Inp = 0x12;
                    inputString = btnIN18.getText().toString();
                    LastInput7UB = 18;
                    rgIN2.clearCheck();
                    rgIN3.clearCheck();
                    rgIN4.clearCheck();
                    rgIN.clearCheck();
                    rgIN6.clearCheck();
                    rgIN7.clearCheck();
                    rgIN8.clearCheck();
                    rgIN5.check(R.id.btnIN18);

                    break;
                }
                case R.id.btnIN19:
                {
                    btnIN19.setTextColor(Color.parseColor("#ffffff"));
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
                    btnIN1.setTextColor(Color.parseColor("#c90000"));
                    btnIN18.setTextColor(Color.parseColor("#c90000"));
                    btnIN17.setTextColor(Color.parseColor("#c90000"));
                    btnIN20.setTextColor(Color.parseColor("#c90000"));
                    btnIN21.setTextColor(Color.parseColor("#c90000"));
                    btnIN22.setTextColor(Color.parseColor("#c90000"));
                    btnIN23.setTextColor(Color.parseColor("#c90000"));
                    btnIN24.setTextColor(Color.parseColor("#c90000"));
                    btnIN25.setTextColor(Color.parseColor("#c90000"));
                    btnIN26.setTextColor(Color.parseColor("#c90000"));
                    btnIN27.setTextColor(Color.parseColor("#c90000"));
                    btnIN28.setTextColor(Color.parseColor("#c90000"));
                    btnIN29.setTextColor(Color.parseColor("#c90000"));
                    btnIN30.setTextColor(Color.parseColor("#c90000"));
                    btnIN31.setTextColor(Color.parseColor("#c90000"));
                    btnIN32.setTextColor(Color.parseColor("#c90000"));

                    InpuT = 19;
                    Inp = 0x13;
                    inputString = btnIN19.getText().toString();
                    LastInput7UB = 19;
                    rgIN2.clearCheck();
                    rgIN3.clearCheck();
                    rgIN4.clearCheck();
                    rgIN.clearCheck();
                    rgIN6.clearCheck();
                    rgIN7.clearCheck();
                    rgIN8.clearCheck();
                    rgIN5.check(R.id.btnIN19);

                    break;
                }
                case R.id.btnIN20:
                {
                    btnIN20.setTextColor(Color.parseColor("#ffffff"));
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
                    btnIN1.setTextColor(Color.parseColor("#c90000"));
                    btnIN18.setTextColor(Color.parseColor("#c90000"));
                    btnIN19.setTextColor(Color.parseColor("#c90000"));
                    btnIN17.setTextColor(Color.parseColor("#c90000"));
                    btnIN21.setTextColor(Color.parseColor("#c90000"));
                    btnIN22.setTextColor(Color.parseColor("#c90000"));
                    btnIN23.setTextColor(Color.parseColor("#c90000"));
                    btnIN24.setTextColor(Color.parseColor("#c90000"));
                    btnIN25.setTextColor(Color.parseColor("#c90000"));
                    btnIN26.setTextColor(Color.parseColor("#c90000"));
                    btnIN27.setTextColor(Color.parseColor("#c90000"));
                    btnIN28.setTextColor(Color.parseColor("#c90000"));
                    btnIN29.setTextColor(Color.parseColor("#c90000"));
                    btnIN30.setTextColor(Color.parseColor("#c90000"));
                    btnIN31.setTextColor(Color.parseColor("#c90000"));
                    btnIN32.setTextColor(Color.parseColor("#c90000"));

                    InpuT = 20;
                    Inp = 0x14;
                    inputString = btnIN20.getText().toString();
                    LastInput7UB = 20;
                    rgIN2.clearCheck();
                    rgIN3.clearCheck();
                    rgIN4.clearCheck();
                    rgIN.clearCheck();
                    rgIN6.clearCheck();
                    rgIN7.clearCheck();
                    rgIN8.clearCheck();
                    rgIN5.check(R.id.btnIN20);

                    break;
                }
                case R.id.btnIN21:
                {
                    btnIN21.setTextColor(Color.parseColor("#ffffff"));
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
                    btnIN1.setTextColor(Color.parseColor("#c90000"));
                    btnIN18.setTextColor(Color.parseColor("#c90000"));
                    btnIN19.setTextColor(Color.parseColor("#c90000"));
                    btnIN20.setTextColor(Color.parseColor("#c90000"));
                    btnIN17.setTextColor(Color.parseColor("#c90000"));
                    btnIN22.setTextColor(Color.parseColor("#c90000"));
                    btnIN23.setTextColor(Color.parseColor("#c90000"));
                    btnIN24.setTextColor(Color.parseColor("#c90000"));
                    btnIN25.setTextColor(Color.parseColor("#c90000"));
                    btnIN26.setTextColor(Color.parseColor("#c90000"));
                    btnIN27.setTextColor(Color.parseColor("#c90000"));
                    btnIN28.setTextColor(Color.parseColor("#c90000"));
                    btnIN29.setTextColor(Color.parseColor("#c90000"));
                    btnIN30.setTextColor(Color.parseColor("#c90000"));
                    btnIN31.setTextColor(Color.parseColor("#c90000"));
                    btnIN32.setTextColor(Color.parseColor("#c90000"));

                    InpuT = 21;
                    Inp = 0x15;
                    inputString = btnIN21.getText().toString();
                    LastInput7UB = 21;
                    rgIN2.clearCheck();
                    rgIN3.clearCheck();
                    rgIN4.clearCheck();
                    rgIN.clearCheck();
                    rgIN5.clearCheck();
                    rgIN7.clearCheck();
                    rgIN8.clearCheck();
                    rgIN6.check(R.id.btnIN21);

                    break;
                }
                case R.id.btnIN22:
                {
                    btnIN22.setTextColor(Color.parseColor("#ffffff"));
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
                    btnIN1.setTextColor(Color.parseColor("#c90000"));
                    btnIN18.setTextColor(Color.parseColor("#c90000"));
                    btnIN19.setTextColor(Color.parseColor("#c90000"));
                    btnIN20.setTextColor(Color.parseColor("#c90000"));
                    btnIN17.setTextColor(Color.parseColor("#c90000"));
                    btnIN21.setTextColor(Color.parseColor("#c90000"));
                    btnIN23.setTextColor(Color.parseColor("#c90000"));
                    btnIN24.setTextColor(Color.parseColor("#c90000"));
                    btnIN25.setTextColor(Color.parseColor("#c90000"));
                    btnIN26.setTextColor(Color.parseColor("#c90000"));
                    btnIN27.setTextColor(Color.parseColor("#c90000"));
                    btnIN28.setTextColor(Color.parseColor("#c90000"));
                    btnIN29.setTextColor(Color.parseColor("#c90000"));
                    btnIN30.setTextColor(Color.parseColor("#c90000"));
                    btnIN31.setTextColor(Color.parseColor("#c90000"));
                    btnIN32.setTextColor(Color.parseColor("#c90000"));

                    InpuT = 22;
                    Inp = 0x16;
                    inputString = btnIN22.getText().toString();
                    LastInput7UB = 22;
                    rgIN2.clearCheck();
                    rgIN3.clearCheck();
                    rgIN4.clearCheck();
                    rgIN.clearCheck();
                    rgIN5.clearCheck();
                    rgIN7.clearCheck();
                    rgIN8.clearCheck();
                    rgIN6.check(R.id.btnIN22);

                    break;
                }
                case R.id.btnIN23:
                {
                    btnIN23.setTextColor(Color.parseColor("#ffffff"));
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
                    btnIN1.setTextColor(Color.parseColor("#c90000"));
                    btnIN18.setTextColor(Color.parseColor("#c90000"));
                    btnIN19.setTextColor(Color.parseColor("#c90000"));
                    btnIN20.setTextColor(Color.parseColor("#c90000"));
                    btnIN17.setTextColor(Color.parseColor("#c90000"));
                    btnIN22.setTextColor(Color.parseColor("#c90000"));
                    btnIN21.setTextColor(Color.parseColor("#c90000"));
                    btnIN24.setTextColor(Color.parseColor("#c90000"));
                    btnIN25.setTextColor(Color.parseColor("#c90000"));
                    btnIN26.setTextColor(Color.parseColor("#c90000"));
                    btnIN27.setTextColor(Color.parseColor("#c90000"));
                    btnIN28.setTextColor(Color.parseColor("#c90000"));
                    btnIN29.setTextColor(Color.parseColor("#c90000"));
                    btnIN30.setTextColor(Color.parseColor("#c90000"));
                    btnIN31.setTextColor(Color.parseColor("#c90000"));
                    btnIN32.setTextColor(Color.parseColor("#c90000"));

                    InpuT = 23;
                    Inp = 0x17;
                    inputString = btnIN23.getText().toString();
                    LastInput7UB = 23;
                    rgIN2.clearCheck();
                    rgIN3.clearCheck();
                    rgIN4.clearCheck();
                    rgIN.clearCheck();
                    rgIN5.clearCheck();
                    rgIN7.clearCheck();
                    rgIN8.clearCheck();
                    rgIN6.check(R.id.btnIN23);

                    break;
                }
                case R.id.btnIN24:
                {
                    btnIN24.setTextColor(Color.parseColor("#ffffff"));
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
                    btnIN1.setTextColor(Color.parseColor("#c90000"));
                    btnIN18.setTextColor(Color.parseColor("#c90000"));
                    btnIN19.setTextColor(Color.parseColor("#c90000"));
                    btnIN20.setTextColor(Color.parseColor("#c90000"));
                    btnIN17.setTextColor(Color.parseColor("#c90000"));
                    btnIN22.setTextColor(Color.parseColor("#c90000"));
                    btnIN23.setTextColor(Color.parseColor("#c90000"));
                    btnIN21.setTextColor(Color.parseColor("#c90000"));
                    btnIN25.setTextColor(Color.parseColor("#c90000"));
                    btnIN26.setTextColor(Color.parseColor("#c90000"));
                    btnIN27.setTextColor(Color.parseColor("#c90000"));
                    btnIN28.setTextColor(Color.parseColor("#c90000"));
                    btnIN29.setTextColor(Color.parseColor("#c90000"));
                    btnIN30.setTextColor(Color.parseColor("#c90000"));
                    btnIN31.setTextColor(Color.parseColor("#c90000"));
                    btnIN32.setTextColor(Color.parseColor("#c90000"));

                    InpuT = 24;
                    Inp = 0x18;
                    inputString = btnIN24.getText().toString();
                    LastInput7UB = 24;
                    rgIN2.clearCheck();
                    rgIN3.clearCheck();
                    rgIN4.clearCheck();
                    rgIN.clearCheck();
                    rgIN5.clearCheck();
                    rgIN7.clearCheck();
                    rgIN8.clearCheck();
                    rgIN6.check(R.id.btnIN24);

                    break;
                }
                case R.id.btnIN25:
                {
                    btnIN25.setTextColor(Color.parseColor("#ffffff"));
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
                    btnIN1.setTextColor(Color.parseColor("#c90000"));
                    btnIN18.setTextColor(Color.parseColor("#c90000"));
                    btnIN19.setTextColor(Color.parseColor("#c90000"));
                    btnIN20.setTextColor(Color.parseColor("#c90000"));
                    btnIN17.setTextColor(Color.parseColor("#c90000"));
                    btnIN22.setTextColor(Color.parseColor("#c90000"));
                    btnIN23.setTextColor(Color.parseColor("#c90000"));
                    btnIN21.setTextColor(Color.parseColor("#c90000"));
                    btnIN24.setTextColor(Color.parseColor("#c90000"));
                    btnIN26.setTextColor(Color.parseColor("#c90000"));
                    btnIN27.setTextColor(Color.parseColor("#c90000"));
                    btnIN28.setTextColor(Color.parseColor("#c90000"));
                    btnIN29.setTextColor(Color.parseColor("#c90000"));
                    btnIN30.setTextColor(Color.parseColor("#c90000"));
                    btnIN31.setTextColor(Color.parseColor("#c90000"));
                    btnIN32.setTextColor(Color.parseColor("#c90000"));

                    InpuT = 25;
                    Inp = 0x19;
                    inputString = btnIN25.getText().toString();
                    LastInput7UB = 25;
                    rgIN2.clearCheck();
                    rgIN3.clearCheck();
                    rgIN4.clearCheck();
                    rgIN.clearCheck();
                    rgIN5.clearCheck();
                    rgIN6.clearCheck();
                    rgIN8.clearCheck();
                    rgIN7.check(R.id.btnIN25);

                    break;
                }
                case R.id.btnIN26:
                {
                    btnIN26.setTextColor(Color.parseColor("#ffffff"));
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
                    btnIN1.setTextColor(Color.parseColor("#c90000"));
                    btnIN18.setTextColor(Color.parseColor("#c90000"));
                    btnIN19.setTextColor(Color.parseColor("#c90000"));
                    btnIN20.setTextColor(Color.parseColor("#c90000"));
                    btnIN17.setTextColor(Color.parseColor("#c90000"));
                    btnIN22.setTextColor(Color.parseColor("#c90000"));
                    btnIN23.setTextColor(Color.parseColor("#c90000"));
                    btnIN21.setTextColor(Color.parseColor("#c90000"));
                    btnIN24.setTextColor(Color.parseColor("#c90000"));
                    btnIN25.setTextColor(Color.parseColor("#c90000"));
                    btnIN27.setTextColor(Color.parseColor("#c90000"));
                    btnIN28.setTextColor(Color.parseColor("#c90000"));
                    btnIN29.setTextColor(Color.parseColor("#c90000"));
                    btnIN30.setTextColor(Color.parseColor("#c90000"));
                    btnIN31.setTextColor(Color.parseColor("#c90000"));
                    btnIN32.setTextColor(Color.parseColor("#c90000"));

                    InpuT = 26;
                    Inp = 0x1a;
                    inputString = btnIN26.getText().toString();
                    LastInput7UB = 26;
                    rgIN2.clearCheck();
                    rgIN3.clearCheck();
                    rgIN4.clearCheck();
                    rgIN.clearCheck();
                    rgIN5.clearCheck();
                    rgIN6.clearCheck();
                    rgIN8.clearCheck();
                    rgIN7.check(R.id.btnIN26);

                    break;
                }
                case R.id.btnIN27:
                {
                    btnIN27.setTextColor(Color.parseColor("#ffffff"));
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
                    btnIN1.setTextColor(Color.parseColor("#c90000"));
                    btnIN18.setTextColor(Color.parseColor("#c90000"));
                    btnIN19.setTextColor(Color.parseColor("#c90000"));
                    btnIN20.setTextColor(Color.parseColor("#c90000"));
                    btnIN17.setTextColor(Color.parseColor("#c90000"));
                    btnIN22.setTextColor(Color.parseColor("#c90000"));
                    btnIN23.setTextColor(Color.parseColor("#c90000"));
                    btnIN21.setTextColor(Color.parseColor("#c90000"));
                    btnIN24.setTextColor(Color.parseColor("#c90000"));
                    btnIN26.setTextColor(Color.parseColor("#c90000"));
                    btnIN25.setTextColor(Color.parseColor("#c90000"));
                    btnIN28.setTextColor(Color.parseColor("#c90000"));
                    btnIN29.setTextColor(Color.parseColor("#c90000"));
                    btnIN30.setTextColor(Color.parseColor("#c90000"));
                    btnIN31.setTextColor(Color.parseColor("#c90000"));
                    btnIN32.setTextColor(Color.parseColor("#c90000"));

                    InpuT = 27;
                    Inp = 0x1b;
                    inputString = btnIN27.getText().toString();
                    LastInput7UB = 27;
                    rgIN2.clearCheck();
                    rgIN3.clearCheck();
                    rgIN4.clearCheck();
                    rgIN.clearCheck();
                    rgIN5.clearCheck();
                    rgIN6.clearCheck();
                    rgIN8.clearCheck();
                    rgIN7.check(R.id.btnIN27);

                    break;
                }
                case R.id.btnIN28:
                {
                    btnIN28.setTextColor(Color.parseColor("#ffffff"));
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
                    btnIN1.setTextColor(Color.parseColor("#c90000"));
                    btnIN18.setTextColor(Color.parseColor("#c90000"));
                    btnIN19.setTextColor(Color.parseColor("#c90000"));
                    btnIN20.setTextColor(Color.parseColor("#c90000"));
                    btnIN17.setTextColor(Color.parseColor("#c90000"));
                    btnIN22.setTextColor(Color.parseColor("#c90000"));
                    btnIN23.setTextColor(Color.parseColor("#c90000"));
                    btnIN21.setTextColor(Color.parseColor("#c90000"));
                    btnIN24.setTextColor(Color.parseColor("#c90000"));
                    btnIN26.setTextColor(Color.parseColor("#c90000"));
                    btnIN27.setTextColor(Color.parseColor("#c90000"));
                    btnIN25.setTextColor(Color.parseColor("#c90000"));
                    btnIN29.setTextColor(Color.parseColor("#c90000"));
                    btnIN30.setTextColor(Color.parseColor("#c90000"));
                    btnIN31.setTextColor(Color.parseColor("#c90000"));
                    btnIN32.setTextColor(Color.parseColor("#c90000"));

                    InpuT = 28;
                    Inp = 0x1c;
                    inputString = btnIN28.getText().toString();
                    LastInput7UB = 28;
                    rgIN2.clearCheck();
                    rgIN3.clearCheck();
                    rgIN4.clearCheck();
                    rgIN.clearCheck();
                    rgIN5.clearCheck();
                    rgIN6.clearCheck();
                    rgIN8.clearCheck();
                    rgIN7.check(R.id.btnIN28);

                    break;
                }
                case R.id.btnIN29:
                {
                    btnIN29.setTextColor(Color.parseColor("#ffffff"));
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
                    btnIN1.setTextColor(Color.parseColor("#c90000"));
                    btnIN18.setTextColor(Color.parseColor("#c90000"));
                    btnIN19.setTextColor(Color.parseColor("#c90000"));
                    btnIN20.setTextColor(Color.parseColor("#c90000"));
                    btnIN17.setTextColor(Color.parseColor("#c90000"));
                    btnIN22.setTextColor(Color.parseColor("#c90000"));
                    btnIN23.setTextColor(Color.parseColor("#c90000"));
                    btnIN21.setTextColor(Color.parseColor("#c90000"));
                    btnIN24.setTextColor(Color.parseColor("#c90000"));
                    btnIN26.setTextColor(Color.parseColor("#c90000"));
                    btnIN27.setTextColor(Color.parseColor("#c90000"));
                    btnIN28.setTextColor(Color.parseColor("#c90000"));
                    btnIN25.setTextColor(Color.parseColor("#c90000"));
                    btnIN30.setTextColor(Color.parseColor("#c90000"));
                    btnIN31.setTextColor(Color.parseColor("#c90000"));
                    btnIN32.setTextColor(Color.parseColor("#c90000"));

                    InpuT = 29;
                    Inp = 0x1d;
                    inputString = btnIN29.getText().toString();
                    LastInput7UB = 29;
                    rgIN2.clearCheck();
                    rgIN3.clearCheck();
                    rgIN4.clearCheck();
                    rgIN.clearCheck();
                    rgIN5.clearCheck();
                    rgIN6.clearCheck();
                    rgIN7.clearCheck();
                    rgIN8.check(R.id.btnIN29);

                    break;
                }
                case R.id.btnIN30:
                {
                    btnIN30.setTextColor(Color.parseColor("#ffffff"));
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
                    btnIN1.setTextColor(Color.parseColor("#c90000"));
                    btnIN18.setTextColor(Color.parseColor("#c90000"));
                    btnIN19.setTextColor(Color.parseColor("#c90000"));
                    btnIN20.setTextColor(Color.parseColor("#c90000"));
                    btnIN17.setTextColor(Color.parseColor("#c90000"));
                    btnIN22.setTextColor(Color.parseColor("#c90000"));
                    btnIN23.setTextColor(Color.parseColor("#c90000"));
                    btnIN21.setTextColor(Color.parseColor("#c90000"));
                    btnIN24.setTextColor(Color.parseColor("#c90000"));
                    btnIN26.setTextColor(Color.parseColor("#c90000"));
                    btnIN27.setTextColor(Color.parseColor("#c90000"));
                    btnIN28.setTextColor(Color.parseColor("#c90000"));
                    btnIN25.setTextColor(Color.parseColor("#c90000"));
                    btnIN29.setTextColor(Color.parseColor("#c90000"));
                    btnIN31.setTextColor(Color.parseColor("#c90000"));
                    btnIN32.setTextColor(Color.parseColor("#c90000"));

                    InpuT = 30;
                    Inp = 0x1e;
                    inputString = btnIN30.getText().toString();
                    LastInput7UB = 30;
                    rgIN2.clearCheck();
                    rgIN3.clearCheck();
                    rgIN4.clearCheck();
                    rgIN.clearCheck();
                    rgIN5.clearCheck();
                    rgIN6.clearCheck();
                    rgIN7.clearCheck();
                    rgIN8.check(R.id.btnIN30);

                    break;
                }
                case R.id.btnIN31:
                {
                    btnIN31.setTextColor(Color.parseColor("#ffffff"));
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
                    btnIN1.setTextColor(Color.parseColor("#c90000"));
                    btnIN18.setTextColor(Color.parseColor("#c90000"));
                    btnIN19.setTextColor(Color.parseColor("#c90000"));
                    btnIN20.setTextColor(Color.parseColor("#c90000"));
                    btnIN17.setTextColor(Color.parseColor("#c90000"));
                    btnIN22.setTextColor(Color.parseColor("#c90000"));
                    btnIN23.setTextColor(Color.parseColor("#c90000"));
                    btnIN21.setTextColor(Color.parseColor("#c90000"));
                    btnIN24.setTextColor(Color.parseColor("#c90000"));
                    btnIN26.setTextColor(Color.parseColor("#c90000"));
                    btnIN27.setTextColor(Color.parseColor("#c90000"));
                    btnIN28.setTextColor(Color.parseColor("#c90000"));
                    btnIN25.setTextColor(Color.parseColor("#c90000"));
                    btnIN29.setTextColor(Color.parseColor("#c90000"));
                    btnIN30.setTextColor(Color.parseColor("#c90000"));
                    btnIN32.setTextColor(Color.parseColor("#c90000"));

                    InpuT = 31;
                    Inp = 0x1f;
                    inputString = btnIN31.getText().toString();
                    LastInput7UB = 31;
                    rgIN2.clearCheck();
                    rgIN3.clearCheck();
                    rgIN4.clearCheck();
                    rgIN.clearCheck();
                    rgIN5.clearCheck();
                    rgIN6.clearCheck();
                    rgIN7.clearCheck();
                    rgIN8.check(R.id.btnIN31);

                    break;
                }
                case R.id.btnIN32:
                {
                    btnIN32.setTextColor(Color.parseColor("#ffffff"));
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
                    btnIN1.setTextColor(Color.parseColor("#c90000"));
                    btnIN18.setTextColor(Color.parseColor("#c90000"));
                    btnIN19.setTextColor(Color.parseColor("#c90000"));
                    btnIN20.setTextColor(Color.parseColor("#c90000"));
                    btnIN17.setTextColor(Color.parseColor("#c90000"));
                    btnIN22.setTextColor(Color.parseColor("#c90000"));
                    btnIN23.setTextColor(Color.parseColor("#c90000"));
                    btnIN21.setTextColor(Color.parseColor("#c90000"));
                    btnIN24.setTextColor(Color.parseColor("#c90000"));
                    btnIN26.setTextColor(Color.parseColor("#c90000"));
                    btnIN27.setTextColor(Color.parseColor("#c90000"));
                    btnIN28.setTextColor(Color.parseColor("#c90000"));
                    btnIN25.setTextColor(Color.parseColor("#c90000"));
                    btnIN29.setTextColor(Color.parseColor("#c90000"));
                    btnIN31.setTextColor(Color.parseColor("#c90000"));
                    btnIN30.setTextColor(Color.parseColor("#c90000"));

                    InpuT = 32;
                    Inp = 0x20;
                    inputString = btnIN32.getText().toString();
                    LastInput7UB = 32;
                    rgIN2.clearCheck();
                    rgIN3.clearCheck();
                    rgIN4.clearCheck();
                    rgIN.clearCheck();
                    rgIN5.clearCheck();
                    rgIN6.clearCheck();
                    rgIN7.clearCheck();
                    rgIN8.check(R.id.btnIN32);

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
                        Toast.makeText(MX_7UB.this, "You choose the wrong button  " + AorV + " please change", Toast.LENGTH_LONG).show();
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
                        Toast.makeText(MX_7UB.this, "You choose the wrong button  " + AorV + " please change", Toast.LENGTH_LONG).show();
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
                        Toast.makeText(MX_7UB.this, "You choose the wrong button  " + AorV + " please change", Toast.LENGTH_LONG).show();
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
                        Toast.makeText(MX_7UB.this, "You choose the wrong button  " + AorV + " please change", Toast.LENGTH_LONG).show();
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
                        Toast.makeText(MX_7UB.this, "You choose the wrong button  " + AorV + " please change", Toast.LENGTH_LONG).show();
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
                        Toast.makeText(MX_7UB.this, "You choose the wrong button  " + AorV + " please change", Toast.LENGTH_LONG).show();
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
                        Toast.makeText(MX_7UB.this, "You choose the wrong button  " + AorV + " please change", Toast.LENGTH_LONG).show();
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
                        Toast.makeText(MX_7UB.this, "You choose the wrong button  " + AorV + " please change", Toast.LENGTH_LONG).show();
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
                        Toast.makeText(MX_7UB.this, "You choose the wrong button  " + AorV + " please change", Toast.LENGTH_LONG).show();
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
                        Toast.makeText(MX_7UB.this, "You choose the wrong button  " + AorV + " please change", Toast.LENGTH_LONG).show();
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
                        Toast.makeText(MX_7UB.this, "You choose the wrong button  " + AorV + " please change", Toast.LENGTH_LONG).show();
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
                        Toast.makeText(MX_7UB.this, "You choose the wrong button  " + AorV + " please change", Toast.LENGTH_LONG).show();
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
                        Toast.makeText(MX_7UB.this, "You choose the wrong button  " + AorV + " please change", Toast.LENGTH_LONG).show();
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
                        Toast.makeText(MX_7UB.this, "You choose the wrong button  " + AorV + " please change", Toast.LENGTH_LONG).show();
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
                        Toast.makeText(MX_7UB.this, "You choose the wrong button  " + AorV + " please change", Toast.LENGTH_LONG).show();
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
                        Toast.makeText(MX_7UB.this, "You choose the wrong button  " + AorV + " please change", Toast.LENGTH_LONG).show();
                    }

                    break;
                }
                case R.id.btnOU17:
                {

                    if (AorV.equals("Video") || AorV.equals("Audio") || AorV.equals("")) {

                        OutpuT = 17;
                        OuT = 0x11;

                        btnO17.setText(getOUT17+"("+"V"+":"+inputString+")");

                        byteCB = new byte[]{0x20, 0x01, OuT, Inp};

                        CrcTraFor(byteCB);

                        byteAV = new byte[]{0x20, 0x01, OuT, Inp, cb[3]};
                        SwitchAV(byteAV);

                    }
                    else
                    {
                        Toast.makeText(MX_7UB.this, "You choose the wrong button  " + AorV + " please change", Toast.LENGTH_LONG).show();
                    }

                    break;
                }
                case R.id.btnOU18:
                {

                    if (AorV.equals("Video") || AorV.equals("Audio") || AorV.equals("")) {

                        OutpuT = 18;
                        OuT = 0x12;

                        btnO18.setText(getOUT18+"("+"V"+":"+inputString+")");

                        byteCB = new byte[]{0x20, 0x01, OuT, Inp};

                        CrcTraFor(byteCB);

                        byteAV = new byte[]{0x20, 0x01, OuT, Inp, cb[3]};
                        SwitchAV(byteAV);

                    }
                    else
                    {
                        Toast.makeText(MX_7UB.this, "You choose the wrong button  " + AorV + " please change", Toast.LENGTH_LONG).show();
                    }

                    break;
                }
                case R.id.btnOU19:
                {

                    if (AorV.equals("Video") || AorV.equals("Audio") || AorV.equals("")) {

                        OutpuT = 19;
                        OuT = 0x13;

                        btnO19.setText(getOUT19+"("+"V"+":"+inputString+")");

                        byteCB = new byte[]{0x20, 0x01, OuT, Inp};

                        CrcTraFor(byteCB);

                        byteAV = new byte[]{0x20, 0x01, OuT, Inp, cb[3]};
                        SwitchAV(byteAV);

                    }
                    else
                    {
                        Toast.makeText(MX_7UB.this, "You choose the wrong button  " + AorV + " please change", Toast.LENGTH_LONG).show();
                    }

                    break;
                }
                case R.id.btnOU20:
                {

                    if (AorV.equals("Video") || AorV.equals("Audio") || AorV.equals("")) {

                        OutpuT = 20;
                        OuT = 0x14;

                        btnO20.setText(getOUT20+"("+"V"+":"+inputString+")");

                        byteCB = new byte[]{0x20, 0x01, OuT, Inp};

                        CrcTraFor(byteCB);

                        byteAV = new byte[]{0x20, 0x01, OuT, Inp, cb[3]};
                        SwitchAV(byteAV);

                    }
                    else
                    {
                        Toast.makeText(MX_7UB.this, "You choose the wrong button  " + AorV + " please change", Toast.LENGTH_LONG).show();
                    }

                    break;
                }
                case R.id.btnOU21:
                {

                    if (AorV.equals("Video") || AorV.equals("Audio") || AorV.equals("")) {

                        OutpuT = 21;
                        OuT = 0x15;

                        btnO21.setText(getOUT21+"("+"V"+":"+inputString+")");

                        byteCB = new byte[]{0x20, 0x01, OuT, Inp};

                        CrcTraFor(byteCB);

                        byteAV = new byte[]{0x20, 0x01, OuT, Inp, cb[3]};
                        SwitchAV(byteAV);

                    }
                    else
                    {
                        Toast.makeText(MX_7UB.this, "You choose the wrong button  " + AorV + " please change", Toast.LENGTH_LONG).show();
                    }

                    break;
                }
                case R.id.btnOU22:
                {

                    if (AorV.equals("Video") || AorV.equals("Audio") || AorV.equals("")) {

                        OutpuT = 22;
                        OuT = 0x16;

                        btnO22.setText(getOUT22+"("+"V"+":"+inputString+")");

                        byteCB = new byte[]{0x20, 0x01, OuT, Inp};

                        CrcTraFor(byteCB);

                        byteAV = new byte[]{0x20, 0x01, OuT, Inp, cb[3]};
                        SwitchAV(byteAV);

                    }
                    else
                    {
                        Toast.makeText(MX_7UB.this, "You choose the wrong button  " + AorV + " please change", Toast.LENGTH_LONG).show();
                    }

                    break;
                }
                case R.id.btnOU23:
                {

                    if (AorV.equals("Video") || AorV.equals("Audio") || AorV.equals("")) {

                        OutpuT = 23;
                        OuT = 0x17;

                        btnO23.setText(getOUT23+"("+"V"+":"+inputString+")");

                        byteCB = new byte[]{0x20, 0x01, OuT, Inp};

                        CrcTraFor(byteCB);

                        byteAV = new byte[]{0x20, 0x01, OuT, Inp, cb[3]};
                        SwitchAV(byteAV);

                    }
                    else
                    {
                        Toast.makeText(MX_7UB.this, "You choose the wrong button  " + AorV + " please change", Toast.LENGTH_LONG).show();
                    }

                    break;
                }
                case R.id.btnOU24:
                {

                    if (AorV.equals("Video") || AorV.equals("Audio") || AorV.equals("")) {

                        OutpuT = 24;
                        OuT = 0x18;

                        btnO24.setText(getOUT24+"("+"V"+":"+inputString+")");

                        byteCB = new byte[]{0x20, 0x01, OuT, Inp};

                        CrcTraFor(byteCB);

                        byteAV = new byte[]{0x20, 0x01, OuT, Inp, cb[3]};
                        SwitchAV(byteAV);

                    }
                    else
                    {
                        Toast.makeText(MX_7UB.this, "You choose the wrong button  " + AorV + " please change", Toast.LENGTH_LONG).show();
                    }

                    break;
                }
                case R.id.btnOU25:
                {

                    if (AorV.equals("Video") || AorV.equals("Audio") || AorV.equals("")) {

                        OutpuT = 25;
                        OuT = 0x19;

                        btnO25.setText(getOUT25+"("+"V"+":"+inputString+")");

                        byteCB = new byte[]{0x20, 0x01, OuT, Inp};

                        CrcTraFor(byteCB);

                        byteAV = new byte[]{0x20, 0x01, OuT, Inp, cb[3]};
                        SwitchAV(byteAV);

                    }
                    else
                    {
                        Toast.makeText(MX_7UB.this, "You choose the wrong button  " + AorV + " please change", Toast.LENGTH_LONG).show();
                    }

                    break;
                }
                case R.id.btnOU26:
                {

                    if (AorV.equals("Video") || AorV.equals("Audio") || AorV.equals("")) {

                        OutpuT = 26;
                        OuT = 0x1a;

                        btnO26.setText(getOUT26+"("+"V"+":"+inputString+")");

                        byteCB = new byte[]{0x20, 0x01, OuT, Inp};

                        CrcTraFor(byteCB);

                        byteAV = new byte[]{0x20, 0x01, OuT, Inp, cb[3]};
                        SwitchAV(byteAV);

                    }
                    else
                    {
                        Toast.makeText(MX_7UB.this, "You choose the wrong button  " + AorV + " please change", Toast.LENGTH_LONG).show();
                    }

                    break;
                }
                case R.id.btnOU27:
                {

                    if (AorV.equals("Video") || AorV.equals("Audio") || AorV.equals("")) {

                        OutpuT = 27;
                        OuT = 0x1b;

                        btnO27.setText(getOUT27+"("+"V"+":"+inputString+")");

                        byteCB = new byte[]{0x20, 0x01, OuT, Inp};

                        CrcTraFor(byteCB);

                        byteAV = new byte[]{0x20, 0x01, OuT, Inp, cb[3]};
                        SwitchAV(byteAV);

                    }
                    else
                    {
                        Toast.makeText(MX_7UB.this, "You choose the wrong button  " + AorV + " please change", Toast.LENGTH_LONG).show();
                    }

                    break;
                }
                case R.id.btnOU28:
                {

                    if (AorV.equals("Video") || AorV.equals("Audio") || AorV.equals("")) {

                        OutpuT = 28;
                        OuT = 0x1c;

                        btnO28.setText(getOUT28+"("+"V"+":"+inputString+")");

                        byteCB = new byte[]{0x20, 0x01, OuT, Inp};

                        CrcTraFor(byteCB);

                        byteAV = new byte[]{0x20, 0x01, OuT, Inp, cb[3]};
                        SwitchAV(byteAV);

                    }
                    else
                    {
                        Toast.makeText(MX_7UB.this, "You choose the wrong button  " + AorV + " please change", Toast.LENGTH_LONG).show();
                    }

                    break;
                }
                case R.id.btnOU29:
                {

                    if (AorV.equals("Video") || AorV.equals("Audio") || AorV.equals("")) {

                        OutpuT = 29;
                        OuT = 0x1d;

                        btnO29.setText(getOUT29+"("+"V"+":"+inputString+")");

                        byteCB = new byte[]{0x20, 0x01, OuT, Inp};

                        CrcTraFor(byteCB);

                        byteAV = new byte[]{0x20, 0x01, OuT, Inp, cb[3]};
                        SwitchAV(byteAV);

                    }
                    else
                    {
                        Toast.makeText(MX_7UB.this, "You choose the wrong button  " + AorV + " please change", Toast.LENGTH_LONG).show();
                    }

                    break;
                }
                case R.id.btnOU30:
                {

                    if (AorV.equals("Video") || AorV.equals("Audio") || AorV.equals("")) {

                        OutpuT = 30;
                        OuT = 0x1e;

                        btnO30.setText(getOUT30+"("+"V"+":"+inputString+")");

                        byteCB = new byte[]{0x20, 0x01, OuT, Inp};

                        CrcTraFor(byteCB);

                        byteAV = new byte[]{0x20, 0x01, OuT, Inp, cb[3]};
                        SwitchAV(byteAV);

                    }
                    else
                    {
                        Toast.makeText(MX_7UB.this, "You choose the wrong button  " + AorV + " please change", Toast.LENGTH_LONG).show();
                    }

                    break;
                }
                case R.id.btnOU31:
                {

                    if (AorV.equals("Video") || AorV.equals("Audio") || AorV.equals("")) {

                        OutpuT = 31;
                        OuT = 0x1f;

                        btnO31.setText(getOUT31+"("+"V"+":"+inputString+")");

                        byteCB = new byte[]{0x20, 0x01, OuT, Inp};

                        CrcTraFor(byteCB);

                        byteAV = new byte[]{0x20, 0x01, OuT, Inp, cb[3]};
                        SwitchAV(byteAV);

                    }
                    else
                    {
                        Toast.makeText(MX_7UB.this, "You choose the wrong button  " + AorV + " please change", Toast.LENGTH_LONG).show();
                    }

                    break;
                }
                case R.id.btnOU32:
                {

                    if (AorV.equals("Video") || AorV.equals("Audio") || AorV.equals("")) {

                        OutpuT = 32;
                        OuT = 0x20;

                        btnO32.setText(getOUT32+"("+"V"+":"+inputString+")");

                        byteCB = new byte[]{0x20, 0x01, OuT, Inp};

                        CrcTraFor(byteCB);

                        byteAV = new byte[]{0x20, 0x01, OuT, Inp, cb[3]};
                        SwitchAV(byteAV);

                    }
                    else
                    {
                        Toast.makeText(MX_7UB.this, "You choose the wrong button  " + AorV + " please change", Toast.LENGTH_LONG).show();
                    }

                    break;
                }
                case R.id.btnME1:
                {

                    SL = true;
                    change.setClass(MX_7UB.this, SaveLoad_MX.class);
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
                    change.setClass(MX_7UB.this, SaveLoad_MX.class);
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
                    btnO17.setText(getOUT17+"("+"V"+":"+inputString+")");
                    btnO18.setText(getOUT18+"("+"V"+":"+inputString+")");
                    btnO19.setText(getOUT19+"("+"V"+":"+inputString+")");
                    btnO20.setText(getOUT20+"("+"V"+":"+inputString+")");
                    btnO21.setText(getOUT21+"("+"V"+":"+inputString+")");
                    btnO22.setText(getOUT22+"("+"V"+":"+inputString+")");
                    btnO23.setText(getOUT23+"("+"V"+":"+inputString+")");
                    btnO24.setText(getOUT24+"("+"V"+":"+inputString+")");
                    btnO25.setText(getOUT25+"("+"V"+":"+inputString+")");
                    btnO26.setText(getOUT26+"("+"V"+":"+inputString+")");
                    btnO27.setText(getOUT27+"("+"V"+":"+inputString+")");
                    btnO28.setText(getOUT28+"("+"V"+":"+inputString+")");
                    btnO29.setText(getOUT29+"("+"V"+":"+inputString+")");
                    btnO30.setText(getOUT30+"("+"V"+":"+inputString+")");
                    btnO31.setText(getOUT31+"("+"V"+":"+inputString+")");
                    btnO32.setText(getOUT32+"("+"V"+":"+inputString+")");

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
                    btnO17.setText(getOUT17);
                    btnO18.setText(getOUT18);
                    btnO19.setText(getOUT19);
                    btnO20.setText(getOUT20);
                    btnO21.setText(getOUT21);
                    btnO22.setText(getOUT22);
                    btnO23.setText(getOUT23);
                    btnO24.setText(getOUT24);
                    btnO25.setText(getOUT25);
                    btnO26.setText(getOUT26);
                    btnO27.setText(getOUT27);
                    btnO28.setText(getOUT28);
                    btnO29.setText(getOUT29);
                    btnO30.setText(getOUT30);
                    btnO31.setText(getOUT31);
                    btnO32.setText(getOUT32);

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
        rgIN5.clearCheck();
        rgIN6.clearCheck();
        rgIN7.clearCheck();
        rgIN8.clearCheck();

        getIP1 = getSharedPreferences("Config7UB", MODE_PRIVATE).getString("IP1","1");
        getIP2 = getSharedPreferences("Config7UB", MODE_PRIVATE).getString("IP2","2");
        getIP3 = getSharedPreferences("Config7UB", MODE_PRIVATE).getString("IP3","3");
        getIP4 = getSharedPreferences("Config7UB", MODE_PRIVATE).getString("IP4","4");
        getIP5 = getSharedPreferences("Config7UB", MODE_PRIVATE).getString("IP5","5");
        getIP6 = getSharedPreferences("Config7UB", MODE_PRIVATE).getString("IP6","6");
        getIP7 = getSharedPreferences("Config7UB", MODE_PRIVATE).getString("IP7","7");
        getIP8 = getSharedPreferences("Config7UB", MODE_PRIVATE).getString("IP8","8");
        getIP9 = getSharedPreferences("Config7UB", MODE_PRIVATE).getString("IP9","9");
        getIP10 = getSharedPreferences("Config7UB", MODE_PRIVATE).getString("IP10","10");
        getIP11 = getSharedPreferences("Config7UB", MODE_PRIVATE).getString("IP11","11");
        getIP12 = getSharedPreferences("Config7UB", MODE_PRIVATE).getString("IP12","12");
        getIP13 = getSharedPreferences("Config7UB", MODE_PRIVATE).getString("IP13","13");
        getIP14 = getSharedPreferences("Config7UB", MODE_PRIVATE).getString("IP14","14");
        getIP15 = getSharedPreferences("Config7UB", MODE_PRIVATE).getString("IP15","15");
        getIP16 = getSharedPreferences("Config7UB", MODE_PRIVATE).getString("IP16","16");
        getIP17 = getSharedPreferences("Config7UB", MODE_PRIVATE).getString("IP17","17");
        getIP18 = getSharedPreferences("Config7UB", MODE_PRIVATE).getString("IP18","18");
        getIP19 = getSharedPreferences("Config7UB", MODE_PRIVATE).getString("IP19","19");
        getIP20 = getSharedPreferences("Config7UB", MODE_PRIVATE).getString("IP20","20");
        getIP21 = getSharedPreferences("Config7UB", MODE_PRIVATE).getString("IP21","21");
        getIP22 = getSharedPreferences("Config7UB", MODE_PRIVATE).getString("IP22","22");
        getIP23 = getSharedPreferences("Config7UB", MODE_PRIVATE).getString("IP23","23");
        getIP24 = getSharedPreferences("Config7UB", MODE_PRIVATE).getString("IP24","24");
        getIP25 = getSharedPreferences("Config7UB", MODE_PRIVATE).getString("IP25","25");
        getIP26 = getSharedPreferences("Config7UB", MODE_PRIVATE).getString("IP26","26");
        getIP27 = getSharedPreferences("Config7UB", MODE_PRIVATE).getString("IP27","27");
        getIP28 = getSharedPreferences("Config7UB", MODE_PRIVATE).getString("IP28","28");
        getIP29 = getSharedPreferences("Config7UB", MODE_PRIVATE).getString("IP29","29");
        getIP30 = getSharedPreferences("Config7UB", MODE_PRIVATE).getString("IP30","30");
        getIP31 = getSharedPreferences("Config7UB", MODE_PRIVATE).getString("IP31","31");
        getIP32 = getSharedPreferences("Config7UB", MODE_PRIVATE).getString("IP32","32");

        getOUT1 = getSharedPreferences("Config7UB",MODE_PRIVATE).getString("OUT1","1");
        getOUT2 = getSharedPreferences("Config7UB",MODE_PRIVATE).getString("OUT2","2");
        getOUT3 = getSharedPreferences("Config7UB",MODE_PRIVATE).getString("OUT3","3");
        getOUT4 = getSharedPreferences("Config7UB",MODE_PRIVATE).getString("OUT4","4");
        getOUT5 = getSharedPreferences("Config7UB",MODE_PRIVATE).getString("OUT5","5");
        getOUT6 = getSharedPreferences("Config7UB",MODE_PRIVATE).getString("OUT6","6");
        getOUT7 = getSharedPreferences("Config7UB",MODE_PRIVATE).getString("OUT7","7");
        getOUT8 = getSharedPreferences("Config7UB",MODE_PRIVATE).getString("OUT8","8");
        getOUT9 = getSharedPreferences("Config7UB",MODE_PRIVATE).getString("OUT9","9");
        getOUT10 = getSharedPreferences("Config7UB",MODE_PRIVATE).getString("OUT10","10");
        getOUT11 = getSharedPreferences("Config7UB",MODE_PRIVATE).getString("OUT11","11");
        getOUT12 = getSharedPreferences("Config7UB",MODE_PRIVATE).getString("OUT12","12");
        getOUT13 = getSharedPreferences("Config7UB",MODE_PRIVATE).getString("OUT13","13");
        getOUT14 = getSharedPreferences("Config7UB",MODE_PRIVATE).getString("OUT14","14");
        getOUT15 = getSharedPreferences("Config7UB",MODE_PRIVATE).getString("OUT15","15");
        getOUT16 = getSharedPreferences("Config7UB",MODE_PRIVATE).getString("OUT16","16");
        getOUT17 = getSharedPreferences("Config7UB",MODE_PRIVATE).getString("OUT17","17");
        getOUT18 = getSharedPreferences("Config7UB",MODE_PRIVATE).getString("OUT18","18");
        getOUT19 = getSharedPreferences("Config7UB",MODE_PRIVATE).getString("OUT19","19");
        getOUT20 = getSharedPreferences("Config7UB",MODE_PRIVATE).getString("OUT20","20");
        getOUT21 = getSharedPreferences("Config7UB",MODE_PRIVATE).getString("OUT21","21");
        getOUT22 = getSharedPreferences("Config7UB",MODE_PRIVATE).getString("OUT22","22");
        getOUT23 = getSharedPreferences("Config7UB",MODE_PRIVATE).getString("OUT23","23");
        getOUT24 = getSharedPreferences("Config7UB",MODE_PRIVATE).getString("OUT24","24");
        getOUT25 = getSharedPreferences("Config7UB",MODE_PRIVATE).getString("OUT25","25");
        getOUT26 = getSharedPreferences("Config7UB",MODE_PRIVATE).getString("OUT26","26");
        getOUT27 = getSharedPreferences("Config7UB",MODE_PRIVATE).getString("OUT27","27");
        getOUT28 = getSharedPreferences("Config7UB",MODE_PRIVATE).getString("OUT28","28");
        getOUT29 = getSharedPreferences("Config7UB",MODE_PRIVATE).getString("OUT29","29");
        getOUT30 = getSharedPreferences("Config7UB",MODE_PRIVATE).getString("OUT30","30");
        getOUT31 = getSharedPreferences("Config7UB",MODE_PRIVATE).getString("OUT31","31");
        getOUT32 = getSharedPreferences("Config7UB",MODE_PRIVATE).getString("OUT32","32");

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
        btnIN17.setText(getIP17);
        btnIN18.setText(getIP18);
        btnIN19.setText(getIP19);
        btnIN20.setText(getIP20);
        btnIN21.setText(getIP21);
        btnIN22.setText(getIP22);
        btnIN23.setText(getIP23);
        btnIN24.setText(getIP24);
        btnIN25.setText(getIP25);
        btnIN26.setText(getIP26);
        btnIN27.setText(getIP27);
        btnIN28.setText(getIP28);
        btnIN29.setText(getIP29);
        btnIN30.setText(getIP30);
        btnIN31.setText(getIP31);
        btnIN32.setText(getIP32);

        buttonSetText();
        if (LastInput7UB != 0)
        {
            switch (LastInput7UB)
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
                case 17 :
                {
                    inputString = getIP17;
                    break;
                }
                case 18 :
                {
                    inputString = getIP18;
                    break;
                }
                case 19 :
                {
                    inputString = getIP19;
                    break;
                }
                case 20 :
                {
                    inputString = getIP20;
                    break;
                }
                case 21 :
                {
                    inputString = getIP21;
                    break;
                }
                case 22 :
                {
                    inputString = getIP22;
                    break;
                }
                case 23 :
                {
                    inputString = getIP23;
                    break;
                }
                case 24 :
                {
                    inputString = getIP24;
                    break;
                }
                case 25 :
                {
                    inputString = getIP25;
                    break;
                }
                case 26 :
                {
                    inputString = getIP26;
                    break;
                }
                case 27 :
                {
                    inputString = getIP27;
                    break;
                }
                case 28 :
                {
                    inputString = getIP28;
                    break;
                }
                case 29 :
                {
                    inputString = getIP29;
                    break;
                }
                case 30 :
                {
                    inputString = getIP30;
                    break;
                }
                case 31 :
                {
                    inputString = getIP31;
                    break;
                }
                case 32 :
                {
                    inputString = getIP32;
                    break;
                }
            }
        }

        if (ipFinal7UB != null)
        {
            txtI.setText("       IP: "+ipFinal7UB);
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
                DataInputStream in = new DataInputStream(m_socket.getInputStream());
                a = in.read(buff,0,buff.length);
                chaStr(a);
                Check();
            }
        }
        catch (IOException e)
        {
            Toast toast2 = Toast.makeText(MX_7UB.this,e.getMessage(),Toast.LENGTH_SHORT);
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
        bx = Integer.toBinaryString(Bhex[2]);
        T = new char[bx.length()];   // 將字串的每一個字元單一取出
        for(int j=0; j<bx.length(); j++)
        {
            T[j] = bx.charAt(j);
        }
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
        MeTol = MemoryTol;
        EDIDTYPE();
        ProtocolVer();
        FirmwareVer();
        Mation.setClass(MX_7UB.this,Information.class);
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
        Mation.putExtras(bundleInf);
    }
    public void SwitchAV(byte[] bytesAV)
    {
        try
        {
            DataOutputStream out = new DataOutputStream(m_socket.getOutputStream());
            out.write(bytesAV);
            out.flush();
            DataInputStream in = new DataInputStream(m_socket.getInputStream());
            in.read(buff,0,buff.length);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void CrcTraFor(byte[] ByteClient)
    {
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
            DataInputStream in = new DataInputStream(m_socket.getInputStream());
            a = in.read(buff,0,buff.length);
            TypeB(a);
        }
        catch (IOException e)
        {
            Toast toast2 = Toast.makeText(MX_7UB.this,e.getMessage(),Toast.LENGTH_SHORT);
            toast2.show();
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
            DataInputStream in = new DataInputStream(m_socket.getInputStream());
            a = in.read(buff,0,buff.length);
            TypeC(a);
            Protocol = "v"+String.valueOf(DB[0])+"."+String.valueOf(DB[1]);
        }
        catch (IOException e)
        {
            Toast toast2 = Toast.makeText(MX_7UB.this,e.getMessage(),Toast.LENGTH_SHORT);
            toast2.show();
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
            DataInputStream in = new DataInputStream(m_socket.getInputStream());
            a = in.read(buff,0,buff.length);
            TypeC1(a);
            Firmware = "v"+VerA+"."+VerB+"."+String.valueOf(DB[1]);
        }
        catch (IOException e)
        {
            Toast toast2 = Toast.makeText(MX_7UB.this,e.getMessage(),Toast.LENGTH_SHORT);
            toast2.show();
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
        else if (str1.equals("11"))
        {
            btnO1.setText(getOUT1+"("+"V"+":"+getIP17+")");
        }
        else if (str1.equals("12"))
        {
            btnO1.setText(getOUT1+"("+"V"+":"+getIP18+")");
        }
        else if (str1.equals("13"))
        {
            btnO1.setText(getOUT1+"("+"V"+":"+getIP19+")");
        }
        else if (str1.equals("14"))
        {
            btnO1.setText(getOUT1+"("+"V"+":"+getIP20+")");
        }
        else if (str1.equals("15"))
        {
            btnO1.setText(getOUT1+"("+"V"+":"+getIP21+")");
        }
        else if (str1.equals("16"))
        {
            btnO1.setText(getOUT1+"("+"V"+":"+getIP22+")");
        }
        else if (str1.equals("17"))
        {
            btnO1.setText(getOUT1+"("+"V"+":"+getIP23+")");
        }
        else if (str1.equals("18"))
        {
            btnO1.setText(getOUT1+"("+"V"+":"+getIP24+")");
        }
        else if (str1.equals("19"))
        {
            btnO1.setText(getOUT1+"("+"V"+":"+getIP25+")");
        }
        else if (str1.equals("1a"))
        {
            btnO1.setText(getOUT1+"("+"V"+":"+getIP26+")");
        }
        else if (str1.equals("1b"))
        {
            btnO1.setText(getOUT1+"("+"V"+":"+getIP27+")");
        }
        else if (str1.equals("1c"))
        {
            btnO1.setText(getOUT1+"("+"V"+":"+getIP28+")");
        }
        else if (str1.equals("1d"))
        {
            btnO1.setText(getOUT1+"("+"V"+":"+getIP29+")");
        }
        else if (str1.equals("1e"))
        {
            btnO1.setText(getOUT1+"("+"V"+":"+getIP30+")");
        }
        else if (str1.equals("1f"))
        {
            btnO1.setText(getOUT1+"("+"V"+":"+getIP31+")");
        }
        else if (str1.equals("20"))
        {
            btnO1.setText(getOUT1+"("+"V"+":"+getIP32+")");
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
            btnO2.setText(getOUT2+"("+"V"+":"+getIP1+")");
        }
        else if (str2.equals("02"))
        {
            btnO2.setText(getOUT2+"("+"V"+":"+getIP2+")");
        }
        else if (str2.equals("03"))
        {
            btnO2.setText(getOUT2+"("+"V"+":"+getIP3+")");
        }
        else if (str2.equals("04"))
        {
            btnO2.setText(getOUT2+"("+"V"+":"+getIP4+")");
        }
        else if (str2.equals("05"))
        {
            btnO2.setText(getOUT2+"("+"V"+":"+getIP5+")");
        }
        else if (str2.equals("06"))
        {
            btnO2.setText(getOUT2+"("+"V"+":"+getIP6+")");
        }
        else if (str2.equals("07"))
        {
            btnO2.setText(getOUT2+"("+"V"+":"+getIP7+")");
        }
        else if (str2.equals("08"))
        {
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
        else if (str2.equals("11"))
        {
            btnO2.setText(getOUT2+"("+"V"+":"+getIP17+")");
        }
        else if (str2.equals("12"))
        {
            btnO2.setText(getOUT2+"("+"V"+":"+getIP18+")");
        }
        else if (str2.equals("13"))
        {
            btnO2.setText(getOUT2+"("+"V"+":"+getIP19+")");
        }
        else if (str2.equals("14"))
        {
            btnO2.setText(getOUT2+"("+"V"+":"+getIP20+")");
        }
        else if (str2.equals("15"))
        {
            btnO2.setText(getOUT2+"("+"V"+":"+getIP21+")");
        }
        else if (str2.equals("16"))
        {
            btnO2.setText(getOUT2+"("+"V"+":"+getIP22+")");
        }
        else if (str2.equals("17"))
        {
            btnO2.setText(getOUT2+"("+"V"+":"+getIP23+")");
        }
        else if (str2.equals("18"))
        {
            btnO2.setText(getOUT2+"("+"V"+":"+getIP24+")");
        }
        else if (str2.equals("19"))
        {
            btnO2.setText(getOUT2+"("+"V"+":"+getIP25+")");
        }
        else if (str2.equals("1a"))
        {
            btnO2.setText(getOUT2+"("+"V"+":"+getIP26+")");
        }
        else if (str2.equals("1b"))
        {
            btnO2.setText(getOUT2+"("+"V"+":"+getIP27+")");
        }
        else if (str2.equals("1c"))
        {
            btnO2.setText(getOUT2+"("+"V"+":"+getIP28+")");
        }
        else if (str2.equals("1d"))
        {
            btnO2.setText(getOUT2+"("+"V"+":"+getIP29+")");
        }
        else if (str2.equals("1e"))
        {
            btnO2.setText(getOUT2+"("+"V"+":"+getIP30+")");
        }
        else if (str2.equals("1f"))
        {
            btnO2.setText(getOUT2+"("+"V"+":"+getIP31+")");
        }
        else if (str2.equals("20"))
        {
            btnO2.setText(getOUT2+"("+"V"+":"+getIP32+")");
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
            btnO3.setText(getOUT3+"("+"V"+":"+getIP1+")");
        }
        else if (str3.equals("02"))
        {
            btnO3.setText(getOUT3+"("+"V"+":"+getIP2+")");
        }
        else if (str3.equals("03"))
        {
            btnO3.setText(getOUT3+"("+"V"+":"+getIP3+")");
        }
        else if (str3.equals("04"))
        {
            btnO3.setText(getOUT3+"("+"V"+":"+getIP4+")");
        }
        else if (str3.equals("05"))
        {
            btnO3.setText(getOUT3+"("+"V"+":"+getIP5+")");
        }
        else if (str3.equals("06"))
        {
            btnO3.setText(getOUT3+"("+"V"+":"+getIP6+")");
        }
        else if (str3.equals("07"))
        {
            btnO3.setText(getOUT3+"("+"V"+":"+getIP7+")");
        }
        else if (str3.equals("08"))
        {
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
        else if (str3.equals("11"))
        {
            btnO3.setText(getOUT3+"("+"V"+":"+getIP17+")");
        }
        else if (str3.equals("12"))
        {
            btnO3.setText(getOUT3+"("+"V"+":"+getIP18+")");
        }
        else if (str3.equals("13"))
        {
            btnO3.setText(getOUT3+"("+"V"+":"+getIP19+")");
        }
        else if (str3.equals("14"))
        {
            btnO3.setText(getOUT3+"("+"V"+":"+getIP20+")");
        }
        else if (str3.equals("15"))
        {
            btnO3.setText(getOUT3+"("+"V"+":"+getIP21+")");
        }
        else if (str3.equals("16"))
        {
            btnO3.setText(getOUT3+"("+"V"+":"+getIP22+")");
        }
        else if (str3.equals("17"))
        {
            btnO3.setText(getOUT3+"("+"V"+":"+getIP23+")");
        }
        else if (str3.equals("18"))
        {
            btnO3.setText(getOUT3+"("+"V"+":"+getIP24+")");
        }
        else if (str3.equals("19"))
        {
            btnO3.setText(getOUT3+"("+"V"+":"+getIP25+")");
        }
        else if (str3.equals("1a"))
        {
            btnO3.setText(getOUT3+"("+"V"+":"+getIP26+")");
        }
        else if (str3.equals("1b"))
        {
            btnO3.setText(getOUT3+"("+"V"+":"+getIP27+")");
        }
        else if (str3.equals("1c"))
        {
            btnO3.setText(getOUT3+"("+"V"+":"+getIP28+")");
        }
        else if (str3.equals("1d"))
        {
            btnO3.setText(getOUT3+"("+"V"+":"+getIP29+")");
        }
        else if (str3.equals("1e"))
        {
            btnO3.setText(getOUT3+"("+"V"+":"+getIP30+")");
        }
        else if (str3.equals("1f"))
        {
            btnO3.setText(getOUT3+"("+"V"+":"+getIP31+")");
        }
        else if (str3.equals("20"))
        {
            btnO3.setText(getOUT3+"("+"V"+":"+getIP32+")");
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
            btnO4.setText(getOUT4+"("+"V"+":"+getIP1+")");
        }
        else if (str4.equals("02"))
        {
            btnO4.setText(getOUT4+"("+"V"+":"+getIP2+")");
        }
        else if (str4.equals("03"))
        {
            btnO4.setText(getOUT4+"("+"V"+":"+getIP3+")");
        }
        else if (str4.equals("04"))
        {
            btnO4.setText(getOUT4+"("+"V"+":"+getIP4+")");
        }
        else if (str4.equals("05"))
        {
            btnO4.setText(getOUT4+"("+"V"+":"+getIP5+")");
        }
        else if (str4.equals("06"))
        {
            btnO4.setText(getOUT4+"("+"V"+":"+getIP6+")");
        }
        else if (str4.equals("07"))
        {
            btnO4.setText(getOUT4+"("+"V"+":"+getIP7+")");
        }
        else if (str4.equals("08"))
        {
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
        else if (str4.equals("11"))
        {
            btnO4.setText(getOUT4+"("+"V"+":"+getIP17+")");
        }
        else if (str4.equals("12"))
        {
            btnO4.setText(getOUT4+"("+"V"+":"+getIP18+")");
        }
        else if (str4.equals("13"))
        {
            btnO4.setText(getOUT4+"("+"V"+":"+getIP19+")");
        }
        else if (str4.equals("14"))
        {
            btnO4.setText(getOUT4+"("+"V"+":"+getIP20+")");
        }
        else if (str4.equals("15"))
        {
            btnO4.setText(getOUT4+"("+"V"+":"+getIP21+")");
        }
        else if (str4.equals("16"))
        {
            btnO4.setText(getOUT4+"("+"V"+":"+getIP22+")");
        }
        else if (str4.equals("17"))
        {
            btnO4.setText(getOUT4+"("+"V"+":"+getIP23+")");
        }
        else if (str4.equals("18"))
        {
            btnO4.setText(getOUT4+"("+"V"+":"+getIP24+")");
        }
        else if (str4.equals("19"))
        {
            btnO4.setText(getOUT4+"("+"V"+":"+getIP25+")");
        }
        else if (str4.equals("1a"))
        {
            btnO4.setText(getOUT4+"("+"V"+":"+getIP26+")");
        }
        else if (str4.equals("1b"))
        {
            btnO4.setText(getOUT4+"("+"V"+":"+getIP27+")");
        }
        else if (str4.equals("1c"))
        {
            btnO4.setText(getOUT4+"("+"V"+":"+getIP28+")");
        }
        else if (str4.equals("1d"))
        {
            btnO4.setText(getOUT4+"("+"V"+":"+getIP29+")");
        }
        else if (str4.equals("1e"))
        {
            btnO4.setText(getOUT4+"("+"V"+":"+getIP30+")");
        }
        else if (str4.equals("1f"))
        {
            btnO4.setText(getOUT4+"("+"V"+":"+getIP31+")");
        }
        else if (str4.equals("20"))
        {
            btnO4.setText(getOUT4+"("+"V"+":"+getIP32+")");
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
        else if (str5.equals("01"))
        {
            btnO5.setText(getOUT5+"("+"V"+":"+getIP1+")");
        }
        else if (str5.equals("02"))
        {
            btnO5.setText(getOUT5+"("+"V"+":"+getIP2+")");
        }
        else if (str5.equals("03"))
        {
            btnO5.setText(getOUT5+"("+"V"+":"+getIP3+")");
        }
        else if (str5.equals("04"))
        {
            btnO5.setText(getOUT5+"("+"V"+":"+getIP4+")");
        }
        else if (str5.equals("05"))
        {
            btnO5.setText(getOUT5+"("+"V"+":"+getIP5+")");
        }
        else if (str5.equals("06"))
        {
            btnO5.setText(getOUT5+"("+"V"+":"+getIP6+")");
        }
        else if (str5.equals("07"))
        {
            btnO5.setText(getOUT5+"("+"V"+":"+getIP7+")");
        }
        else if (str5.equals("08"))
        {
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
        else if (str5.equals("11"))
        {
            btnO5.setText(getOUT5+"("+"V"+":"+getIP17+")");
        }
        else if (str5.equals("12"))
        {
            btnO5.setText(getOUT5+"("+"V"+":"+getIP18+")");
        }
        else if (str5.equals("13"))
        {
            btnO5.setText(getOUT5+"("+"V"+":"+getIP19+")");
        }
        else if (str5.equals("14"))
        {
            btnO5.setText(getOUT5+"("+"V"+":"+getIP20+")");
        }
        else if (str5.equals("15"))
        {
            btnO5.setText(getOUT5+"("+"V"+":"+getIP21+")");
        }
        else if (str5.equals("16"))
        {
            btnO5.setText(getOUT5+"("+"V"+":"+getIP22+")");
        }
        else if (str5.equals("17"))
        {
            btnO5.setText(getOUT5+"("+"V"+":"+getIP23+")");
        }
        else if (str5.equals("18"))
        {
            btnO5.setText(getOUT5+"("+"V"+":"+getIP24+")");
        }
        else if (str5.equals("19"))
        {
            btnO5.setText(getOUT5+"("+"V"+":"+getIP25+")");
        }
        else if (str5.equals("1a"))
        {
            btnO5.setText(getOUT5+"("+"V"+":"+getIP26+")");
        }
        else if (str5.equals("1b"))
        {
            btnO5.setText(getOUT5+"("+"V"+":"+getIP27+")");
        }
        else if (str5.equals("1c"))
        {
            btnO5.setText(getOUT5+"("+"V"+":"+getIP28+")");
        }
        else if (str5.equals("1d"))
        {
            btnO5.setText(getOUT5+"("+"V"+":"+getIP29+")");
        }
        else if (str5.equals("1e"))
        {
            btnO5.setText(getOUT5+"("+"V"+":"+getIP30+")");
        }
        else if (str5.equals("1f"))
        {
            btnO5.setText(getOUT5+"("+"V"+":"+getIP31+")");
        }
        else if (str5.equals("20"))
        {
            btnO5.setText(getOUT5+"("+"V"+":"+getIP32+")");
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
            btnO6.setText(getOUT6+"("+"V"+":"+getIP1+")");
        }
        else if (str6.equals("02"))
        {
            btnO6.setText(getOUT6+"("+"V"+":"+getIP2+")");
        }
        else if (str6.equals("03"))
        {
            btnO6.setText(getOUT6+"("+"V"+":"+getIP3+")");
        }
        else if (str6.equals("04"))
        {
            btnO6.setText(getOUT6+"("+"V"+":"+getIP4+")");
        }
        else if (str6.equals("05"))
        {
            btnO6.setText(getOUT6+"("+"V"+":"+getIP5+")");
        }
        else if (str6.equals("06"))
        {
            btnO6.setText(getOUT6+"("+"V"+":"+getIP6+")");
        }
        else if (str6.equals("07"))
        {
            btnO6.setText(getOUT6+"("+"V"+":"+getIP7+")");
        }
        else if (str6.equals("08"))
        {
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
        else if (str6.equals("11"))
        {
            btnO6.setText(getOUT6+"("+"V"+":"+getIP17+")");
        }
        else if (str6.equals("12"))
        {
            btnO6.setText(getOUT6+"("+"V"+":"+getIP18+")");
        }
        else if (str6.equals("13"))
        {
            btnO6.setText(getOUT6+"("+"V"+":"+getIP19+")");
        }
        else if (str6.equals("14"))
        {
            btnO6.setText(getOUT6+"("+"V"+":"+getIP20+")");
        }
        else if (str6.equals("15"))
        {
            btnO6.setText(getOUT6+"("+"V"+":"+getIP21+")");
        }
        else if (str6.equals("16"))
        {
            btnO6.setText(getOUT6+"("+"V"+":"+getIP22+")");
        }
        else if (str6.equals("17"))
        {
            btnO6.setText(getOUT6+"("+"V"+":"+getIP23+")");
        }
        else if (str6.equals("18"))
        {
            btnO6.setText(getOUT6+"("+"V"+":"+getIP24+")");
        }
        else if (str6.equals("19"))
        {
            btnO6.setText(getOUT6+"("+"V"+":"+getIP25+")");
        }
        else if (str6.equals("1a"))
        {
            btnO6.setText(getOUT6+"("+"V"+":"+getIP26+")");
        }
        else if (str6.equals("1b"))
        {
            btnO6.setText(getOUT6+"("+"V"+":"+getIP27+")");
        }
        else if (str6.equals("1c"))
        {
            btnO6.setText(getOUT6+"("+"V"+":"+getIP28+")");
        }
        else if (str6.equals("1d"))
        {
            btnO6.setText(getOUT6+"("+"V"+":"+getIP29+")");
        }
        else if (str6.equals("1e"))
        {
            btnO6.setText(getOUT6+"("+"V"+":"+getIP30+")");
        }
        else if (str6.equals("1f"))
        {
            btnO6.setText(getOUT6+"("+"V"+":"+getIP31+")");
        }
        else if (str6.equals("20"))
        {
            btnO6.setText(getOUT6+"("+"V"+":"+getIP32+")");
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
            btnO7.setText(getOUT7+"("+"V"+":"+getIP1+")");
        }
        else if (str7.equals("02"))
        {
            btnO7.setText(getOUT7+"("+"V"+":"+getIP2+")");
        }
        else if (str7.equals("03"))
        {
            btnO7.setText(getOUT7+"("+"V"+":"+getIP3+")");
        }
        else if (str7.equals("04"))
        {
            btnO7.setText(getOUT7+"("+"V"+":"+getIP4+")");
        }
        else if (str7.equals("05"))
        {
            btnO7.setText(getOUT7+"("+"V"+":"+getIP5+")");
        }
        else if (str7.equals("06"))
        {
            btnO7.setText(getOUT7+"("+"V"+":"+getIP6+")");
        }
        else if (str7.equals("07"))
        {
            btnO7.setText(getOUT7+"("+"V"+":"+getIP7+")");
        }
        else if (str7.equals("08"))
        {
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
        else if (str7.equals("11"))
        {
            btnO7.setText(getOUT7+"("+"V"+":"+getIP17+")");
        }
        else if (str7.equals("12"))
        {
            btnO7.setText(getOUT7+"("+"V"+":"+getIP18+")");
        }
        else if (str7.equals("13"))
        {
            btnO7.setText(getOUT7+"("+"V"+":"+getIP19+")");
        }
        else if (str7.equals("14"))
        {
            btnO7.setText(getOUT7+"("+"V"+":"+getIP20+")");
        }
        else if (str7.equals("15"))
        {
            btnO7.setText(getOUT7+"("+"V"+":"+getIP21+")");
        }
        else if (str7.equals("16"))
        {
            btnO7.setText(getOUT7+"("+"V"+":"+getIP22+")");
        }
        else if (str7.equals("17"))
        {
            btnO7.setText(getOUT7+"("+"V"+":"+getIP23+")");
        }
        else if (str7.equals("18"))
        {
            btnO7.setText(getOUT7+"("+"V"+":"+getIP24+")");
        }
        else if (str7.equals("19"))
        {
            btnO7.setText(getOUT7+"("+"V"+":"+getIP25+")");
        }
        else if (str7.equals("1a"))
        {
            btnO7.setText(getOUT7+"("+"V"+":"+getIP26+")");
        }
        else if (str7.equals("1b"))
        {
            btnO7.setText(getOUT7+"("+"V"+":"+getIP27+")");
        }
        else if (str7.equals("1c"))
        {
            btnO7.setText(getOUT7+"("+"V"+":"+getIP28+")");
        }
        else if (str7.equals("1d"))
        {
            btnO7.setText(getOUT7+"("+"V"+":"+getIP29+")");
        }
        else if (str7.equals("1e"))
        {
            btnO7.setText(getOUT7+"("+"V"+":"+getIP30+")");
        }
        else if (str7.equals("1f"))
        {
            btnO7.setText(getOUT7+"("+"V"+":"+getIP31+")");
        }
        else if (str7.equals("20"))
        {
            btnO7.setText(getOUT7+"("+"V"+":"+getIP32+")");
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
            btnO8.setText(getOUT8+"("+"V"+":"+getIP1+")");
        }
        else if (str8.equals("02"))
        {
            btnO8.setText(getOUT8+"("+"V"+":"+getIP2+")");
        }
        else if (str8.equals("03"))
        {
            btnO8.setText(getOUT8+"("+"V"+":"+getIP3+")");
        }
        else if (str8.equals("04"))
        {
            btnO8.setText(getOUT8+"("+"V"+":"+getIP4+")");
        }
        else if (str8.equals("05"))
        {
            btnO8.setText(getOUT8+"("+"V"+":"+getIP5+")");
        }
        else if (str8.equals("06"))
        {
            btnO8.setText(getOUT8+"("+"V"+":"+getIP6+")");
        }
        else if (str8.equals("07"))
        {
            btnO8.setText(getOUT8+"("+"V"+":"+getIP7+")");
        }
        else if (str8.equals("08"))
        {
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
        else if (str8.equals("11"))
        {
            btnO8.setText(getOUT8+"("+"V"+":"+getIP17+")");
        }
        else if (str8.equals("12"))
        {
            btnO8.setText(getOUT8+"("+"V"+":"+getIP18+")");
        }
        else if (str8.equals("13"))
        {
            btnO8.setText(getOUT8+"("+"V"+":"+getIP19+")");
        }
        else if (str8.equals("14"))
        {
            btnO8.setText(getOUT8+"("+"V"+":"+getIP20+")");
        }
        else if (str8.equals("15"))
        {
            btnO8.setText(getOUT8+"("+"V"+":"+getIP21+")");
        }
        else if (str8.equals("16"))
        {
            btnO8.setText(getOUT8+"("+"V"+":"+getIP22+")");
        }
        else if (str8.equals("17"))
        {
            btnO8.setText(getOUT8+"("+"V"+":"+getIP23+")");
        }
        else if (str8.equals("18"))
        {
            btnO8.setText(getOUT8+"("+"V"+":"+getIP24+")");
        }
        else if (str8.equals("19"))
        {
            btnO8.setText(getOUT8+"("+"V"+":"+getIP25+")");
        }
        else if (str8.equals("1a"))
        {
            btnO8.setText(getOUT8+"("+"V"+":"+getIP26+")");
        }
        else if (str8.equals("1b"))
        {
            btnO8.setText(getOUT8+"("+"V"+":"+getIP27+")");
        }
        else if (str8.equals("1c"))
        {
            btnO8.setText(getOUT8+"("+"V"+":"+getIP28+")");
        }
        else if (str8.equals("1d"))
        {
            btnO8.setText(getOUT8+"("+"V"+":"+getIP29+")");
        }
        else if (str8.equals("1e"))
        {
            btnO8.setText(getOUT8+"("+"V"+":"+getIP30+")");
        }
        else if (str8.equals("1f"))
        {
            btnO8.setText(getOUT8+"("+"V"+":"+getIP31+")");
        }
        else if (str8.equals("20"))
        {
            btnO8.setText(getOUT8+"("+"V"+":"+getIP32+")");
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
            btnO9.setText(getOUT9+"("+"V"+":"+getIP1+")");
        }
        else if (str9.equals("02"))
        {
            btnO9.setText(getOUT9+"("+"V"+":"+getIP2+")");
        }
        else if (str9.equals("03"))
        {
            btnO9.setText(getOUT9+"("+"V"+":"+getIP3+")");
        }
        else if (str9.equals("04"))
        {
            btnO9.setText(getOUT9+"("+"V"+":"+getIP4+")");
        }
        else if (str9.equals("05"))
        {
            btnO9.setText(getOUT9+"("+"V"+":"+getIP5+")");
        }
        else if (str8.equals("06"))
        {
            btnO9.setText(getOUT9+"("+"V"+":"+getIP6+")");
        }
        else if (str9.equals("07"))
        {
            btnO9.setText(getOUT9+"("+"V"+":"+getIP7+")");
        }
        else if (str9.equals("08"))
        {
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
        else if (str9.equals("11"))
        {
            btnO9.setText(getOUT9+"("+"V"+":"+getIP17+")");
        }
        else if (str9.equals("12"))
        {
            btnO9.setText(getOUT9+"("+"V"+":"+getIP18+")");
        }
        else if (str9.equals("13"))
        {
            btnO9.setText(getOUT9+"("+"V"+":"+getIP19+")");
        }
        else if (str9.equals("14"))
        {
            btnO9.setText(getOUT9+"("+"V"+":"+getIP20+")");
        }
        else if (str9.equals("15"))
        {
            btnO9.setText(getOUT9+"("+"V"+":"+getIP21+")");
        }
        else if (str9.equals("16"))
        {
            btnO9.setText(getOUT9+"("+"V"+":"+getIP22+")");
        }
        else if (str9.equals("17"))
        {
            btnO9.setText(getOUT9+"("+"V"+":"+getIP23+")");
        }
        else if (str9.equals("18"))
        {
            btnO9.setText(getOUT9+"("+"V"+":"+getIP24+")");
        }
        else if (str9.equals("19"))
        {
            btnO9.setText(getOUT9+"("+"V"+":"+getIP25+")");
        }
        else if (str9.equals("1a"))
        {
            btnO9.setText(getOUT9+"("+"V"+":"+getIP26+")");
        }
        else if (str9.equals("1b"))
        {
            btnO9.setText(getOUT9+"("+"V"+":"+getIP27+")");
        }
        else if (str9.equals("1c"))
        {
            btnO9.setText(getOUT9+"("+"V"+":"+getIP28+")");
        }
        else if (str9.equals("1d"))
        {
            btnO9.setText(getOUT9+"("+"V"+":"+getIP29+")");
        }
        else if (str9.equals("1e"))
        {
            btnO9.setText(getOUT9+"("+"V"+":"+getIP30+")");
        }
        else if (str9.equals("1f"))
        {
            btnO9.setText(getOUT9+"("+"V"+":"+getIP31+")");
        }
        else if (str9.equals("20"))
        {
            btnO9.setText(getOUT9+"("+"V"+":"+getIP32+")");
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
            btnO10.setText(getOUT10+"("+"V"+":"+getIP1+")");
        }
        else if (str10.equals("02"))
        {
            btnO10.setText(getOUT10+"("+"V"+":"+getIP2+")");
        }
        else if (str10.equals("03"))
        {
            btnO10.setText(getOUT10+"("+"V"+":"+getIP3+")");
        }
        else if (str10.equals("04"))
        {
            btnO10.setText(getOUT10+"("+"V"+":"+getIP4+")");
        }
        else if (str10.equals("05"))
        {
            btnO10.setText(getOUT10+"("+"V"+":"+getIP5+")");
        }
        else if (str10.equals("06"))
        {
            btnO10.setText(getOUT10+"("+"V"+":"+getIP6+")");
        }
        else if (str10.equals("07"))
        {
            btnO10.setText(getOUT10+"("+"V"+":"+getIP7+")");
        }
        else if (str10.equals("08"))
        {
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
        else if (str10.equals("11"))
        {
            btnO10.setText(getOUT10+"("+"V"+":"+getIP17+")");
        }
        else if (str10.equals("12"))
        {
            btnO10.setText(getOUT10+"("+"V"+":"+getIP18+")");
        }
        else if (str10.equals("13"))
        {
            btnO10.setText(getOUT10+"("+"V"+":"+getIP19+")");
        }
        else if (str10.equals("14"))
        {
            btnO10.setText(getOUT10+"("+"V"+":"+getIP20+")");
        }
        else if (str10.equals("15"))
        {
            btnO10.setText(getOUT10+"("+"V"+":"+getIP21+")");
        }
        else if (str10.equals("16"))
        {
            btnO10.setText(getOUT10+"("+"V"+":"+getIP22+")");
        }
        else if (str10.equals("17"))
        {
            btnO10.setText(getOUT10+"("+"V"+":"+getIP23+")");
        }
        else if (str10.equals("18"))
        {
            btnO10.setText(getOUT10+"("+"V"+":"+getIP24+")");
        }
        else if (str10.equals("19"))
        {
            btnO10.setText(getOUT10+"("+"V"+":"+getIP25+")");
        }
        else if (str10.equals("1a"))
        {
            btnO10.setText(getOUT10+"("+"V"+":"+getIP26+")");
        }
        else if (str10.equals("1b"))
        {
            btnO10.setText(getOUT10+"("+"V"+":"+getIP27+")");
        }
        else if (str10.equals("1c"))
        {
            btnO10.setText(getOUT10+"("+"V"+":"+getIP28+")");
        }
        else if (str10.equals("1d"))
        {
            btnO10.setText(getOUT10+"("+"V"+":"+getIP29+")");
        }
        else if (str10.equals("1e"))
        {
            btnO10.setText(getOUT10+"("+"V"+":"+getIP30+")");
        }
        else if (str10.equals("1f"))
        {
            btnO10.setText(getOUT10+"("+"V"+":"+getIP31+")");
        }
        else if (str10.equals("20"))
        {
            btnO10.setText(getOUT10+"("+"V"+":"+getIP32+")");
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
            btnO11.setText(getOUT11+"("+"V"+":"+getIP1+")");
        }
        else if (str11.equals("02"))
        {
            btnO11.setText(getOUT11+"("+"V"+":"+getIP2+")");
        }
        else if (str11.equals("03"))
        {
            btnO11.setText(getOUT11+"("+"V"+":"+getIP3+")");
        }
        else if (str11.equals("04"))
        {
            btnO11.setText(getOUT11+"("+"V"+":"+getIP4+")");
        }
        else if (str11.equals("05"))
        {
            btnO11.setText(getOUT11+"("+"V"+":"+getIP5+")");
        }
        else if (str11.equals("06"))
        {
            btnO11.setText(getOUT11+"("+"V"+":"+getIP6+")");
        }
        else if (str11.equals("07"))
        {
            btnO11.setText(getOUT11+"("+"V"+":"+getIP7+")");
        }
        else if (str11.equals("08"))
        {
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
        else if (str11.equals("11"))
        {
            btnO11.setText(getOUT11+"("+"V"+":"+getIP17+")");
        }
        else if (str11.equals("12"))
        {
            btnO11.setText(getOUT11+"("+"V"+":"+getIP18+")");
        }
        else if (str11.equals("13"))
        {
            btnO11.setText(getOUT11+"("+"V"+":"+getIP19+")");
        }
        else if (str11.equals("14"))
        {
            btnO11.setText(getOUT11+"("+"V"+":"+getIP20+")");
        }
        else if (str11.equals("15"))
        {
            btnO11.setText(getOUT11+"("+"V"+":"+getIP21+")");
        }
        else if (str11.equals("16"))
        {
            btnO11.setText(getOUT11+"("+"V"+":"+getIP22+")");
        }
        else if (str11.equals("17"))
        {
            btnO11.setText(getOUT11+"("+"V"+":"+getIP23+")");
        }
        else if (str11.equals("18"))
        {
            btnO11.setText(getOUT11+"("+"V"+":"+getIP24+")");
        }
        else if (str11.equals("19"))
        {
            btnO11.setText(getOUT11+"("+"V"+":"+getIP25+")");
        }
        else if (str11.equals("1a"))
        {
            btnO11.setText(getOUT11+"("+"V"+":"+getIP26+")");
        }
        else if (str11.equals("1b"))
        {
            btnO11.setText(getOUT11+"("+"V"+":"+getIP27+")");
        }
        else if (str11.equals("1c"))
        {
            btnO11.setText(getOUT11+"("+"V"+":"+getIP28+")");
        }
        else if (str11.equals("1d"))
        {
            btnO11.setText(getOUT11+"("+"V"+":"+getIP29+")");
        }
        else if (str11.equals("1e"))
        {
            btnO11.setText(getOUT11+"("+"V"+":"+getIP30+")");
        }
        else if (str11.equals("1f"))
        {
            btnO11.setText(getOUT11+"("+"V"+":"+getIP31+")");
        }
        else if (str11.equals("20"))
        {
            btnO11.setText(getOUT11+"("+"V"+":"+getIP32+")");
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
            btnO12.setText(getOUT12+"("+"V"+":"+getIP1+")");
        }
        else if (str12.equals("02"))
        {
            btnO12.setText(getOUT12+"("+"V"+":"+getIP2+")");
        }
        else if (str12.equals("03"))
        {
            btnO12.setText(getOUT12+"("+"V"+":"+getIP3+")");
        }
        else if (str12.equals("04"))
        {
            btnO12.setText(getOUT12+"("+"V"+":"+getIP4+")");
        }
        else if (str12.equals("05"))
        {
            btnO12.setText(getOUT12+"("+"V"+":"+getIP5+")");
        }
        else if (str12.equals("06"))
        {
            btnO12.setText(getOUT12+"("+"V"+":"+getIP6+")");
        }
        else if (str12.equals("07"))
        {
            btnO12.setText(getOUT12+"("+"V"+":"+getIP7+")");
        }
        else if (str12.equals("08"))
        {
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
        else if (str12.equals("11"))
        {
            btnO12.setText(getOUT12+"("+"V"+":"+getIP17+")");
        }
        else if (str12.equals("12"))
        {
            btnO12.setText(getOUT12+"("+"V"+":"+getIP18+")");
        }
        else if (str12.equals("13"))
        {
            btnO12.setText(getOUT12+"("+"V"+":"+getIP19+")");
        }
        else if (str12.equals("14"))
        {
            btnO12.setText(getOUT12+"("+"V"+":"+getIP20+")");
        }
        else if (str12.equals("15"))
        {
            btnO12.setText(getOUT12+"("+"V"+":"+getIP21+")");
        }
        else if (str12.equals("16"))
        {
            btnO12.setText(getOUT12+"("+"V"+":"+getIP22+")");
        }
        else if (str12.equals("17"))
        {
            btnO12.setText(getOUT12+"("+"V"+":"+getIP23+")");
        }
        else if (str12.equals("18"))
        {
            btnO12.setText(getOUT12+"("+"V"+":"+getIP24+")");
        }
        else if (str12.equals("19"))
        {
            btnO12.setText(getOUT12+"("+"V"+":"+getIP25+")");
        }
        else if (str12.equals("1a"))
        {
            btnO12.setText(getOUT12+"("+"V"+":"+getIP26+")");
        }
        else if (str12.equals("1b"))
        {
            btnO12.setText(getOUT12+"("+"V"+":"+getIP27+")");
        }
        else if (str12.equals("1c"))
        {
            btnO12.setText(getOUT12+"("+"V"+":"+getIP28+")");
        }
        else if (str12.equals("1d"))
        {
            btnO12.setText(getOUT12+"("+"V"+":"+getIP29+")");
        }
        else if (str12.equals("1e"))
        {
            btnO12.setText(getOUT12+"("+"V"+":"+getIP30+")");
        }
        else if (str12.equals("1f"))
        {
            btnO12.setText(getOUT12+"("+"V"+":"+getIP31+")");
        }
        else if (str12.equals("20"))
        {
            btnO12.setText(getOUT12+"("+"V"+":"+getIP32+")");
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
            btnO13.setText(getOUT13+"("+"V"+":"+getIP1+")");
        }
        else if (str13.equals("02"))
        {
            btnO13.setText(getOUT13+"("+"V"+":"+getIP2+")");
        }
        else if (str13.equals("03"))
        {
            btnO13.setText(getOUT13+"("+"V"+":"+getIP3+")");
        }
        else if (str13.equals("04"))
        {
            btnO13.setText(getOUT13+"("+"V"+":"+getIP4+")");
        }
        else if (str13.equals("05"))
        {
            btnO13.setText(getOUT13+"("+"V"+":"+getIP5+")");
        }
        else if (str13.equals("06"))
        {
            btnO13.setText(getOUT13+"("+"V"+":"+getIP6+")");
        }
        else if (str13.equals("07"))
        {
            btnO13.setText(getOUT13+"("+"V"+":"+getIP7+")");
        }
        else if (str13.equals("08"))
        {
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
        else if (str13.equals("11"))
        {
            btnO13.setText(getOUT13+"("+"V"+":"+getIP17+")");
        }
        else if (str13.equals("12"))
        {
            btnO13.setText(getOUT13+"("+"V"+":"+getIP18+")");
        }
        else if (str13.equals("13"))
        {
            btnO13.setText(getOUT13+"("+"V"+":"+getIP19+")");
        }
        else if (str13.equals("14"))
        {
            btnO13.setText(getOUT13+"("+"V"+":"+getIP20+")");
        }
        else if (str13.equals("15"))
        {
            btnO13.setText(getOUT13+"("+"V"+":"+getIP21+")");
        }
        else if (str13.equals("16"))
        {
            btnO13.setText(getOUT13+"("+"V"+":"+getIP22+")");
        }
        else if (str13.equals("17"))
        {
            btnO13.setText(getOUT13+"("+"V"+":"+getIP23+")");
        }
        else if (str13.equals("18"))
        {
            btnO13.setText(getOUT13+"("+"V"+":"+getIP24+")");
        }
        else if (str13.equals("19"))
        {
            btnO13.setText(getOUT13+"("+"V"+":"+getIP25+")");
        }
        else if (str13.equals("1a"))
        {
            btnO13.setText(getOUT13+"("+"V"+":"+getIP26+")");
        }
        else if (str13.equals("1b"))
        {
            btnO13.setText(getOUT13+"("+"V"+":"+getIP27+")");
        }
        else if (str13.equals("1c"))
        {
            btnO13.setText(getOUT13+"("+"V"+":"+getIP28+")");
        }
        else if (str13.equals("1d"))
        {
            btnO13.setText(getOUT13+"("+"V"+":"+getIP29+")");
        }
        else if (str13.equals("1e"))
        {
            btnO13.setText(getOUT13+"("+"V"+":"+getIP30+")");
        }
        else if (str13.equals("1f"))
        {
            btnO13.setText(getOUT13+"("+"V"+":"+getIP31+")");
        }
        else if (str13.equals("20"))
        {
            btnO13.setText(getOUT13+"("+"V"+":"+getIP32+")");
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
            btnO14.setText(getOUT14+"("+"V"+":"+getIP1+")");
        }
        else if (str14.equals("02"))
        {
            btnO14.setText(getOUT14+"("+"V"+":"+getIP2+")");
        }
        else if (str14.equals("03"))
        {
            btnO14.setText(getOUT14+"("+"V"+":"+getIP3+")");
        }
        else if (str14.equals("04"))
        {
            btnO14.setText(getOUT14+"("+"V"+":"+getIP4+")");
        }
        else if (str14.equals("05"))
        {
            btnO14.setText(getOUT14+"("+"V"+":"+getIP5+")");
        }
        else if (str14.equals("06"))
        {
            btnO14.setText(getOUT14+"("+"V"+":"+getIP6+")");
        }
        else if (str14.equals("07"))
        {
            btnO14.setText(getOUT14+"("+"V"+":"+getIP7+")");
        }
        else if (str14.equals("08"))
        {
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
        else if (str14.equals("11"))
        {
            btnO14.setText(getOUT14+"("+"V"+":"+getIP17+")");
        }
        else if (str14.equals("12"))
        {
            btnO14.setText(getOUT14+"("+"V"+":"+getIP18+")");
        }
        else if (str14.equals("13"))
        {
            btnO14.setText(getOUT14+"("+"V"+":"+getIP19+")");
        }
        else if (str14.equals("14"))
        {
            btnO14.setText(getOUT14+"("+"V"+":"+getIP20+")");
        }
        else if (str14.equals("15"))
        {
            btnO14.setText(getOUT14+"("+"V"+":"+getIP21+")");
        }
        else if (str14.equals("16"))
        {
            btnO14.setText(getOUT14+"("+"V"+":"+getIP22+")");
        }
        else if (str14.equals("17"))
        {
            btnO14.setText(getOUT14+"("+"V"+":"+getIP23+")");
        }
        else if (str14.equals("18"))
        {
            btnO14.setText(getOUT14+"("+"V"+":"+getIP24+")");
        }
        else if (str14.equals("19"))
        {
            btnO14.setText(getOUT14+"("+"V"+":"+getIP25+")");
        }
        else if (str14.equals("1a"))
        {
            btnO14.setText(getOUT14+"("+"V"+":"+getIP26+")");
        }
        else if (str14.equals("1b"))
        {
            btnO14.setText(getOUT14+"("+"V"+":"+getIP27+")");
        }
        else if (str14.equals("1c"))
        {
            btnO14.setText(getOUT14+"("+"V"+":"+getIP28+")");
        }
        else if (str14.equals("1d"))
        {
            btnO14.setText(getOUT14+"("+"V"+":"+getIP29+")");
        }
        else if (str14.equals("1e"))
        {
            btnO14.setText(getOUT14+"("+"V"+":"+getIP30+")");
        }
        else if (str14.equals("1f"))
        {
            btnO14.setText(getOUT14+"("+"V"+":"+getIP31+")");
        }
        else if (str14.equals("20"))
        {
            btnO14.setText(getOUT14+"("+"V"+":"+getIP32+")");
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
            btnO15.setText(getOUT15+"("+"V"+":"+getIP1+")");
        }
        else if (str15.equals("02"))
        {
            btnO15.setText(getOUT15+"("+"V"+":"+getIP2+")");
        }
        else if (str15.equals("03"))
        {
            btnO15.setText(getOUT15+"("+"V"+":"+getIP3+")");
        }
        else if (str15.equals("04"))
        {
            btnO15.setText(getOUT15+"("+"V"+":"+getIP4+")");
        }
        else if (str15.equals("05"))
        {
            btnO15.setText(getOUT15+"("+"V"+":"+getIP5+")");
        }
        else if (str15.equals("06"))
        {
            btnO15.setText(getOUT15+"("+"V"+":"+getIP6+")");
        }
        else if (str15.equals("07"))
        {
            btnO15.setText(getOUT15+"("+"V"+":"+getIP7+")");
        }
        else if (str15.equals("08"))
        {
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
        else if (str15.equals("11"))
        {
            btnO15.setText(getOUT15+"("+"V"+":"+getIP17+")");
        }
        else if (str15.equals("12"))
        {
            btnO15.setText(getOUT15+"("+"V"+":"+getIP18+")");
        }
        else if (str15.equals("13"))
        {
            btnO15.setText(getOUT15+"("+"V"+":"+getIP19+")");
        }
        else if (str15.equals("14"))
        {
            btnO15.setText(getOUT15+"("+"V"+":"+getIP20+")");
        }
        else if (str15.equals("15"))
        {
            btnO15.setText(getOUT15+"("+"V"+":"+getIP21+")");
        }
        else if (str15.equals("16"))
        {
            btnO15.setText(getOUT15+"("+"V"+":"+getIP22+")");
        }
        else if (str15.equals("17"))
        {
            btnO15.setText(getOUT15+"("+"V"+":"+getIP23+")");
        }
        else if (str15.equals("18"))
        {
            btnO15.setText(getOUT15+"("+"V"+":"+getIP24+")");
        }
        else if (str15.equals("19"))
        {
            btnO15.setText(getOUT15+"("+"V"+":"+getIP25+")");
        }
        else if (str15.equals("1a"))
        {
            btnO15.setText(getOUT15+"("+"V"+":"+getIP26+")");
        }
        else if (str15.equals("1b"))
        {
            btnO15.setText(getOUT15+"("+"V"+":"+getIP27+")");
        }
        else if (str15.equals("1c"))
        {
            btnO15.setText(getOUT15+"("+"V"+":"+getIP28+")");
        }
        else if (str15.equals("1d"))
        {
            btnO15.setText(getOUT15+"("+"V"+":"+getIP29+")");
        }
        else if (str15.equals("1e"))
        {
            btnO15.setText(getOUT15+"("+"V"+":"+getIP30+")");
        }
        else if (str15.equals("1f"))
        {
            btnO15.setText(getOUT15+"("+"V"+":"+getIP31+")");
        }
        else if (str15.equals("20"))
        {
            btnO15.setText(getOUT15+"("+"V"+":"+getIP32+")");
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
            btnO16.setText(getOUT16+"("+"V"+":"+getIP1+")");
        }
        else if (str16.equals("02"))
        {
            btnO16.setText(getOUT16+"("+"V"+":"+getIP2+")");
        }
        else if (str16.equals("03"))
        {
            btnO16.setText(getOUT16+"("+"V"+":"+getIP3+")");
        }
        else if (str16.equals("04"))
        {
            btnO16.setText(getOUT16+"("+"V"+":"+getIP4+")");
        }
        else if (str16.equals("05"))
        {
            btnO16.setText(getOUT16+"("+"V"+":"+getIP5+")");
        }
        else if (str16.equals("06"))
        {
            btnO16.setText(getOUT16+"("+"V"+":"+getIP6+")");
        }
        else if (str16.equals("07"))
        {
            btnO16.setText(getOUT16+"("+"V"+":"+getIP7+")");
        }
        else if (str16.equals("08"))
        {
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
        else if (str16.equals("11"))
        {
            btnO16.setText(getOUT16+"("+"V"+":"+getIP17+")");
        }
        else if (str16.equals("12"))
        {
            btnO16.setText(getOUT16+"("+"V"+":"+getIP18+")");
        }
        else if (str16.equals("13"))
        {
            btnO16.setText(getOUT16+"("+"V"+":"+getIP19+")");
        }
        else if (str16.equals("14"))
        {
            btnO16.setText(getOUT16+"("+"V"+":"+getIP20+")");
        }
        else if (str16.equals("15"))
        {
            btnO16.setText(getOUT16+"("+"V"+":"+getIP21+")");
        }
        else if (str16.equals("16"))
        {
            btnO16.setText(getOUT16+"("+"V"+":"+getIP22+")");
        }
        else if (str16.equals("17"))
        {
            btnO16.setText(getOUT16+"("+"V"+":"+getIP23+")");
        }
        else if (str16.equals("18"))
        {
            btnO16.setText(getOUT16+"("+"V"+":"+getIP24+")");
        }
        else if (str16.equals("19"))
        {
            btnO16.setText(getOUT16+"("+"V"+":"+getIP25+")");
        }
        else if (str16.equals("1a"))
        {
            btnO16.setText(getOUT16+"("+"V"+":"+getIP26+")");
        }
        else if (str16.equals("1b"))
        {
            btnO16.setText(getOUT16+"("+"V"+":"+getIP27+")");
        }
        else if (str16.equals("1c"))
        {
            btnO16.setText(getOUT16+"("+"V"+":"+getIP28+")");
        }
        else if (str16.equals("1d"))
        {
            btnO16.setText(getOUT16+"("+"V"+":"+getIP29+")");
        }
        else if (str16.equals("1e"))
        {
            btnO16.setText(getOUT16+"("+"V"+":"+getIP30+")");
        }
        else if (str16.equals("1f"))
        {
            btnO16.setText(getOUT16+"("+"V"+":"+getIP31+")");
        }
        else if (str16.equals("20"))
        {
            btnO16.setText(getOUT16+"("+"V"+":"+getIP32+")");
        }
/////////////////////////////////////////////////////////////////////////////////////////////////////////// Output 17 /////////////////////////////////////////////////////////////////////////////////////
        try {
            byte[] byteInput = new byte[]{0x20,0x07,0x11,0x00,(byte) 0x22};
            DataOutputStream getinput = new DataOutputStream(m_socket.getOutputStream());
            getinput.write(byteInput);
            getinput.flush();
            DataInputStream in = new DataInputStream(m_socket.getInputStream());
            int c = in.read(buff,0,buff.length);
            chaStr(c);
            str17 = feedback[feedback.length-2];
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (str17.equals("00"))
        {
            btnO17.setText(getOUT17);
        }
        else if (str17.equals("01"))
        {
            btnO17.setText(getOUT17+"("+"V"+":"+getIP1+")");
        }
        else if (str17.equals("02"))
        {
            btnO17.setText(getOUT17+"("+"V"+":"+getIP2+")");
        }
        else if (str17.equals("03"))
        {
            btnO17.setText(getOUT17+"("+"V"+":"+getIP3+")");
        }
        else if (str17.equals("04"))
        {
            btnO17.setText(getOUT17+"("+"V"+":"+getIP4+")");
        }
        else if (str17.equals("05"))
        {
            btnO17.setText(getOUT17+"("+"V"+":"+getIP5+")");
        }
        else if (str17.equals("06"))
        {
            btnO17.setText(getOUT17+"("+"V"+":"+getIP6+")");
        }
        else if (str17.equals("07"))
        {
            btnO17.setText(getOUT17+"("+"V"+":"+getIP7+")");
        }
        else if (str17.equals("08"))
        {
            btnO17.setText(getOUT17+"("+"V"+":"+getIP8+")");
        }
        else if (str17.equals("09"))
        {
            btnO17.setText(getOUT17+"("+"V"+":"+getIP9+")");
        }
        else if (str17.equals("0a"))
        {
            btnO17.setText(getOUT17+"("+"V"+":"+getIP10+")");
        }
        else if (str17.equals("0b"))
        {
            btnO17.setText(getOUT17+"("+"V"+":"+getIP11+")");
        }
        else if (str17.equals("0c"))
        {
            btnO17.setText(getOUT17+"("+"V"+":"+getIP12+")");
        }
        else if (str17.equals("0d"))
        {
            btnO17.setText(getOUT17+"("+"V"+":"+getIP13+")");
        }
        else if (str17.equals("0e"))
        {
            btnO17.setText(getOUT17+"("+"V"+":"+getIP14+")");
        }
        else if (str17.equals("0f"))
        {
            btnO17.setText(getOUT17+"("+"V"+":"+getIP15+")");
        }
        else if (str17.equals("10"))
        {
            btnO17.setText(getOUT17+"("+"V"+":"+getIP16+")");
        }
        else if (str17.equals("11"))
        {
            btnO17.setText(getOUT17+"("+"V"+":"+getIP17+")");
        }
        else if (str17.equals("12"))
        {
            btnO17.setText(getOUT17+"("+"V"+":"+getIP18+")");
        }
        else if (str17.equals("13"))
        {
            btnO17.setText(getOUT17+"("+"V"+":"+getIP19+")");
        }
        else if (str17.equals("14"))
        {
            btnO17.setText(getOUT17+"("+"V"+":"+getIP20+")");
        }
        else if (str17.equals("15"))
        {
            btnO17.setText(getOUT17+"("+"V"+":"+getIP21+")");
        }
        else if (str17.equals("16"))
        {
            btnO17.setText(getOUT17+"("+"V"+":"+getIP22+")");
        }
        else if (str17.equals("17"))
        {
            btnO17.setText(getOUT17+"("+"V"+":"+getIP23+")");
        }
        else if (str17.equals("18"))
        {
            btnO17.setText(getOUT17+"("+"V"+":"+getIP24+")");
        }
        else if (str17.equals("19"))
        {
            btnO17.setText(getOUT17+"("+"V"+":"+getIP25+")");
        }
        else if (str17.equals("1a"))
        {
            btnO17.setText(getOUT17+"("+"V"+":"+getIP26+")");
        }
        else if (str17.equals("1b"))
        {
            btnO17.setText(getOUT17+"("+"V"+":"+getIP27+")");
        }
        else if (str17.equals("1c"))
        {
            btnO17.setText(getOUT17+"("+"V"+":"+getIP28+")");
        }
        else if (str17.equals("1d"))
        {
            btnO17.setText(getOUT17+"("+"V"+":"+getIP29+")");
        }
        else if (str17.equals("1e"))
        {
            btnO17.setText(getOUT17+"("+"V"+":"+getIP30+")");
        }
        else if (str17.equals("1f"))
        {
            btnO17.setText(getOUT17+"("+"V"+":"+getIP31+")");
        }
        else if (str17.equals("20"))
        {
            btnO17.setText(getOUT17+"("+"V"+":"+getIP32+")");
        }
/////////////////////////////////////////////////////////////////////////////////////////////////////////// Output 18 /////////////////////////////////////////////////////////////////////////////////////
        try {
            byte[] byteInput = new byte[]{0x20,0x07,0x12,0x00,(byte) 0x77};
            DataOutputStream getinput = new DataOutputStream(m_socket.getOutputStream());
            getinput.write(byteInput);
            getinput.flush();
            DataInputStream in = new DataInputStream(m_socket.getInputStream());
            int c = in.read(buff,0,buff.length);
            chaStr(c);
            str18 = feedback[feedback.length-2];
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (str18.equals("00"))
        {
            btnO18.setText(getOUT18);
        }
        else if (str18.equals("01"))
        {
            btnO18.setText(getOUT18+"("+"V"+":"+getIP1+")");
        }
        else if (str18.equals("02"))
        {
            btnO18.setText(getOUT18+"("+"V"+":"+getIP2+")");
        }
        else if (str18.equals("03"))
        {
            btnO18.setText(getOUT18+"("+"V"+":"+getIP3+")");
        }
        else if (str18.equals("04"))
        {
            btnO18.setText(getOUT18+"("+"V"+":"+getIP4+")");
        }
        else if (str18.equals("05"))
        {
            btnO18.setText(getOUT18+"("+"V"+":"+getIP5+")");
        }
        else if (str18.equals("06"))
        {
            btnO18.setText(getOUT18+"("+"V"+":"+getIP6+")");
        }
        else if (str18.equals("07"))
        {
            btnO18.setText(getOUT18+"("+"V"+":"+getIP7+")");
        }
        else if (str18.equals("08"))
        {
            btnO18.setText(getOUT18+"("+"V"+":"+getIP8+")");
        }
        else if (str18.equals("09"))
        {
            btnO18.setText(getOUT18+"("+"V"+":"+getIP9+")");
        }
        else if (str18.equals("0a"))
        {
            btnO18.setText(getOUT18+"("+"V"+":"+getIP10+")");
        }
        else if (str18.equals("0b"))
        {
            btnO18.setText(getOUT18+"("+"V"+":"+getIP11+")");
        }
        else if (str18.equals("0c"))
        {
            btnO18.setText(getOUT18+"("+"V"+":"+getIP12+")");
        }
        else if (str18.equals("0d"))
        {
            btnO18.setText(getOUT18+"("+"V"+":"+getIP13+")");
        }
        else if (str18.equals("0e"))
        {
            btnO18.setText(getOUT18+"("+"V"+":"+getIP14+")");
        }
        else if (str18.equals("0f"))
        {
            btnO18.setText(getOUT18+"("+"V"+":"+getIP15+")");
        }
        else if (str18.equals("10"))
        {
            btnO18.setText(getOUT18+"("+"V"+":"+getIP16+")");
        }
        else if (str18.equals("11"))
        {
            btnO18.setText(getOUT18+"("+"V"+":"+getIP17+")");
        }
        else if (str18.equals("12"))
        {
            btnO18.setText(getOUT18+"("+"V"+":"+getIP18+")");
        }
        else if (str18.equals("13"))
        {
            btnO18.setText(getOUT18+"("+"V"+":"+getIP19+")");
        }
        else if (str18.equals("14"))
        {
            btnO18.setText(getOUT18+"("+"V"+":"+getIP20+")");
        }
        else if (str18.equals("15"))
        {
            btnO18.setText(getOUT18+"("+"V"+":"+getIP21+")");
        }
        else if (str18.equals("16"))
        {
            btnO18.setText(getOUT18+"("+"V"+":"+getIP22+")");
        }
        else if (str18.equals("17"))
        {
            btnO18.setText(getOUT18+"("+"V"+":"+getIP23+")");
        }
        else if (str18.equals("18"))
        {
            btnO18.setText(getOUT18+"("+"V"+":"+getIP24+")");
        }
        else if (str18.equals("19"))
        {
            btnO18.setText(getOUT18+"("+"V"+":"+getIP25+")");
        }
        else if (str18.equals("1a"))
        {
            btnO18.setText(getOUT18+"("+"V"+":"+getIP26+")");
        }
        else if (str18.equals("1b"))
        {
            btnO18.setText(getOUT18+"("+"V"+":"+getIP27+")");
        }
        else if (str18.equals("1c"))
        {
            btnO18.setText(getOUT18+"("+"V"+":"+getIP28+")");
        }
        else if (str18.equals("1d"))
        {
            btnO18.setText(getOUT18+"("+"V"+":"+getIP29+")");
        }
        else if (str18.equals("1e"))
        {
            btnO18.setText(getOUT18+"("+"V"+":"+getIP30+")");
        }
        else if (str18.equals("1f"))
        {
            btnO18.setText(getOUT18+"("+"V"+":"+getIP31+")");
        }
        else if (str18.equals("20"))
        {
            btnO18.setText(getOUT18+"("+"V"+":"+getIP32+")");
        }
        /////////////////////////////////////////////////////////////////////////////////////////////////////////// Output 19 /////////////////////////////////////////////////////////////////////////////////////
        try {
            byte[] byteInput = new byte[]{0x20,0x07,0x13,0x00,(byte) 0xb3};
            DataOutputStream getinput = new DataOutputStream(m_socket.getOutputStream());
            getinput.write(byteInput);
            getinput.flush();
            DataInputStream in = new DataInputStream(m_socket.getInputStream());
            int c = in.read(buff,0,buff.length);
            chaStr(c);
            str19 = feedback[feedback.length-2];
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (str19.equals("00"))
        {
            btnO19.setText(getOUT19);
        }
        else if (str19.equals("01"))
        {
            btnO19.setText(getOUT19+"("+"V"+":"+getIP1+")");
        }
        else if (str19.equals("02"))
        {
            btnO19.setText(getOUT19+"("+"V"+":"+getIP2+")");
        }
        else if (str19.equals("03"))
        {
            btnO19.setText(getOUT19+"("+"V"+":"+getIP3+")");
        }
        else if (str19.equals("04"))
        {
            btnO19.setText(getOUT19+"("+"V"+":"+getIP4+")");
        }
        else if (str19.equals("05"))
        {
            btnO19.setText(getOUT19+"("+"V"+":"+getIP5+")");
        }
        else if (str19.equals("06"))
        {
            btnO19.setText(getOUT19+"("+"V"+":"+getIP6+")");
        }
        else if (str19.equals("07"))
        {
            btnO19.setText(getOUT19+"("+"V"+":"+getIP7+")");
        }
        else if (str19.equals("08"))
        {
            btnO19.setText(getOUT19+"("+"V"+":"+getIP8+")");
        }
        else if (str19.equals("09"))
        {
            btnO19.setText(getOUT19+"("+"V"+":"+getIP9+")");
        }
        else if (str19.equals("0a"))
        {
            btnO19.setText(getOUT19+"("+"V"+":"+getIP10+")");
        }
        else if (str19.equals("0b"))
        {
            btnO19.setText(getOUT19+"("+"V"+":"+getIP11+")");
        }
        else if (str19.equals("0c"))
        {
            btnO19.setText(getOUT19+"("+"V"+":"+getIP12+")");
        }
        else if (str19.equals("0d"))
        {
            btnO19.setText(getOUT19+"("+"V"+":"+getIP13+")");
        }
        else if (str19.equals("0e"))
        {
            btnO19.setText(getOUT19+"("+"V"+":"+getIP14+")");
        }
        else if (str19.equals("0f"))
        {
            btnO19.setText(getOUT19+"("+"V"+":"+getIP15+")");
        }
        else if (str19.equals("10"))
        {
            btnO19.setText(getOUT19+"("+"V"+":"+getIP16+")");
        }
        else if (str19.equals("11"))
        {
            btnO19.setText(getOUT19+"("+"V"+":"+getIP17+")");
        }
        else if (str19.equals("12"))
        {
            btnO19.setText(getOUT19+"("+"V"+":"+getIP18+")");
        }
        else if (str19.equals("13"))
        {
            btnO19.setText(getOUT19+"("+"V"+":"+getIP19+")");
        }
        else if (str19.equals("14"))
        {
            btnO19.setText(getOUT19+"("+"V"+":"+getIP20+")");
        }
        else if (str19.equals("15"))
        {
            btnO19.setText(getOUT19+"("+"V"+":"+getIP21+")");
        }
        else if (str19.equals("16"))
        {
            btnO19.setText(getOUT19+"("+"V"+":"+getIP22+")");
        }
        else if (str19.equals("17"))
        {
            btnO19.setText(getOUT19+"("+"V"+":"+getIP23+")");
        }
        else if (str19.equals("18"))
        {
            btnO19.setText(getOUT19+"("+"V"+":"+getIP24+")");
        }
        else if (str19.equals("19"))
        {
            btnO19.setText(getOUT19+"("+"V"+":"+getIP25+")");
        }
        else if (str19.equals("1a"))
        {
            btnO19.setText(getOUT19+"("+"V"+":"+getIP26+")");
        }
        else if (str19.equals("1b"))
        {
            btnO19.setText(getOUT19+"("+"V"+":"+getIP27+")");
        }
        else if (str19.equals("1c"))
        {
            btnO19.setText(getOUT19+"("+"V"+":"+getIP28+")");
        }
        else if (str19.equals("1d"))
        {
            btnO19.setText(getOUT19+"("+"V"+":"+getIP29+")");
        }
        else if (str19.equals("1e"))
        {
            btnO19.setText(getOUT19+"("+"V"+":"+getIP30+")");
        }
        else if (str19.equals("1f"))
        {
            btnO19.setText(getOUT19+"("+"V"+":"+getIP31+")");
        }
        else if (str19.equals("20"))
        {
            btnO19.setText(getOUT19+"("+"V"+":"+getIP32+")");
        }
        /////////////////////////////////////////////////////////////////////////////////////////////////////////// Output 20 /////////////////////////////////////////////////////////////////////////////////////
        try {
            byte[] byteInput = new byte[]{0x20,0x07,0x14,0x00,(byte) 0xdd};
            DataOutputStream getinput = new DataOutputStream(m_socket.getOutputStream());
            getinput.write(byteInput);
            getinput.flush();
            DataInputStream in = new DataInputStream(m_socket.getInputStream());
            int c = in.read(buff,0,buff.length);
            chaStr(c);
            str20 = feedback[feedback.length-2];
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (str20.equals("00"))
        {
            btnO20.setText(getOUT20);
        }
        else if (str20.equals("01"))
        {
            btnO20.setText(getOUT20+"("+"V"+":"+getIP1+")");
        }
        else if (str20.equals("02"))
        {
            btnO20.setText(getOUT20+"("+"V"+":"+getIP2+")");
        }
        else if (str20.equals("03"))
        {
            btnO20.setText(getOUT20+"("+"V"+":"+getIP3+")");
        }
        else if (str20.equals("04"))
        {
            btnO20.setText(getOUT20+"("+"V"+":"+getIP4+")");
        }
        else if (str20.equals("05"))
        {
            btnO20.setText(getOUT20+"("+"V"+":"+getIP5+")");
        }
        else if (str20.equals("06"))
        {
            btnO20.setText(getOUT20+"("+"V"+":"+getIP6+")");
        }
        else if (str20.equals("07"))
        {
            btnO20.setText(getOUT20+"("+"V"+":"+getIP7+")");
        }
        else if (str20.equals("08"))
        {
            btnO20.setText(getOUT20+"("+"V"+":"+getIP8+")");
        }
        else if (str20.equals("09"))
        {
            btnO20.setText(getOUT20+"("+"V"+":"+getIP9+")");
        }
        else if (str20.equals("0a"))
        {
            btnO20.setText(getOUT20+"("+"V"+":"+getIP10+")");
        }
        else if (str20.equals("0b"))
        {
            btnO20.setText(getOUT20+"("+"V"+":"+getIP11+")");
        }
        else if (str20.equals("0c"))
        {
            btnO20.setText(getOUT20+"("+"V"+":"+getIP12+")");
        }
        else if (str20.equals("0d"))
        {
            btnO20.setText(getOUT20+"("+"V"+":"+getIP13+")");
        }
        else if (str20.equals("0e"))
        {
            btnO20.setText(getOUT20+"("+"V"+":"+getIP14+")");
        }
        else if (str20.equals("0f"))
        {
            btnO20.setText(getOUT20+"("+"V"+":"+getIP15+")");
        }
        else if (str20.equals("10"))
        {
            btnO20.setText(getOUT20+"("+"V"+":"+getIP16+")");
        }
        else if (str20.equals("11"))
        {
            btnO20.setText(getOUT20+"("+"V"+":"+getIP17+")");
        }
        else if (str20.equals("12"))
        {
            btnO20.setText(getOUT20+"("+"V"+":"+getIP18+")");
        }
        else if (str20.equals("13"))
        {
            btnO20.setText(getOUT20+"("+"V"+":"+getIP19+")");
        }
        else if (str20.equals("14"))
        {
            btnO20.setText(getOUT20+"("+"V"+":"+getIP20+")");
        }
        else if (str20.equals("15"))
        {
            btnO20.setText(getOUT20+"("+"V"+":"+getIP21+")");
        }
        else if (str20.equals("16"))
        {
            btnO20.setText(getOUT20+"("+"V"+":"+getIP22+")");
        }
        else if (str20.equals("17"))
        {
            btnO20.setText(getOUT20+"("+"V"+":"+getIP23+")");
        }
        else if (str20.equals("18"))
        {
            btnO20.setText(getOUT20+"("+"V"+":"+getIP24+")");
        }
        else if (str20.equals("19"))
        {
            btnO20.setText(getOUT20+"("+"V"+":"+getIP25+")");
        }
        else if (str20.equals("1a"))
        {
            btnO20.setText(getOUT20+"("+"V"+":"+getIP26+")");
        }
        else if (str20.equals("1b"))
        {
            btnO20.setText(getOUT20+"("+"V"+":"+getIP27+")");
        }
        else if (str20.equals("1c"))
        {
            btnO20.setText(getOUT20+"("+"V"+":"+getIP28+")");
        }
        else if (str20.equals("1d"))
        {
            btnO20.setText(getOUT20+"("+"V"+":"+getIP29+")");
        }
        else if (str20.equals("1e"))
        {
            btnO20.setText(getOUT20+"("+"V"+":"+getIP30+")");
        }
        else if (str20.equals("1f"))
        {
            btnO20.setText(getOUT20+"("+"V"+":"+getIP31+")");
        }
        else if (str20.equals("20"))
        {
            btnO20.setText(getOUT20+"("+"V"+":"+getIP32+")");
        }
/////////////////////////////////////////////////////////////////////////////////////////////////////////// Output 21 /////////////////////////////////////////////////////////////////////////////////////
        try {
            byte[] byteInput = new byte[]{0x20,0x07,0x15,0x00,(byte) 0x19};
            DataOutputStream getinput = new DataOutputStream(m_socket.getOutputStream());
            getinput.write(byteInput);
            getinput.flush();
            DataInputStream in = new DataInputStream(m_socket.getInputStream());
            int c = in.read(buff,0,buff.length);
            chaStr(c);
            str21 = feedback[feedback.length-2];
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (str21.equals("00"))
        {
            btnO21.setText(getOUT21);
        }
        else if (str21.equals("01"))
        {
            btnO21.setText(getOUT21+"("+"V"+":"+getIP1+")");
        }
        else if (str21.equals("02"))
        {
            btnO21.setText(getOUT21+"("+"V"+":"+getIP2+")");
        }
        else if (str21.equals("03"))
        {
            btnO21.setText(getOUT21+"("+"V"+":"+getIP3+")");
        }
        else if (str21.equals("04"))
        {
            btnO21.setText(getOUT21+"("+"V"+":"+getIP4+")");
        }
        else if (str21.equals("05"))
        {
            btnO21.setText(getOUT21+"("+"V"+":"+getIP5+")");
        }
        else if (str21.equals("06"))
        {
            btnO21.setText(getOUT21+"("+"V"+":"+getIP6+")");
        }
        else if (str21.equals("07"))
        {
            btnO21.setText(getOUT21+"("+"V"+":"+getIP7+")");
        }
        else if (str21.equals("08"))
        {
            btnO21.setText(getOUT21+"("+"V"+":"+getIP8+")");
        }
        else if (str21.equals("09"))
        {
            btnO21.setText(getOUT21+"("+"V"+":"+getIP9+")");
        }
        else if (str21.equals("0a"))
        {
            btnO21.setText(getOUT21+"("+"V"+":"+getIP10+")");
        }
        else if (str21.equals("0b"))
        {
            btnO21.setText(getOUT21+"("+"V"+":"+getIP11+")");
        }
        else if (str21.equals("0c"))
        {
            btnO21.setText(getOUT21+"("+"V"+":"+getIP12+")");
        }
        else if (str21.equals("0d"))
        {
            btnO21.setText(getOUT21+"("+"V"+":"+getIP13+")");
        }
        else if (str21.equals("0e"))
        {
            btnO21.setText(getOUT21+"("+"V"+":"+getIP14+")");
        }
        else if (str21.equals("0f"))
        {
            btnO21.setText(getOUT21+"("+"V"+":"+getIP15+")");
        }
        else if (str21.equals("10"))
        {
            btnO21.setText(getOUT21+"("+"V"+":"+getIP16+")");
        }
        else if (str21.equals("11"))
        {
            btnO21.setText(getOUT21+"("+"V"+":"+getIP17+")");
        }
        else if (str21.equals("12"))
        {
            btnO21.setText(getOUT21+"("+"V"+":"+getIP18+")");
        }
        else if (str21.equals("13"))
        {
            btnO21.setText(getOUT21+"("+"V"+":"+getIP19+")");
        }
        else if (str21.equals("14"))
        {
            btnO21.setText(getOUT21+"("+"V"+":"+getIP20+")");
        }
        else if (str21.equals("15"))
        {
            btnO21.setText(getOUT21+"("+"V"+":"+getIP21+")");
        }
        else if (str21.equals("16"))
        {
            btnO21.setText(getOUT21+"("+"V"+":"+getIP22+")");
        }
        else if (str21.equals("17"))
        {
            btnO21.setText(getOUT21+"("+"V"+":"+getIP23+")");
        }
        else if (str21.equals("18"))
        {
            btnO21.setText(getOUT21+"("+"V"+":"+getIP24+")");
        }
        else if (str21.equals("19"))
        {
            btnO21.setText(getOUT21+"("+"V"+":"+getIP25+")");
        }
        else if (str21.equals("1a"))
        {
            btnO21.setText(getOUT21+"("+"V"+":"+getIP26+")");
        }
        else if (str21.equals("1b"))
        {
            btnO21.setText(getOUT21+"("+"V"+":"+getIP27+")");
        }
        else if (str21.equals("1c"))
        {
            btnO21.setText(getOUT21+"("+"V"+":"+getIP28+")");
        }
        else if (str21.equals("1d"))
        {
            btnO21.setText(getOUT21+"("+"V"+":"+getIP29+")");
        }
        else if (str21.equals("1e"))
        {
            btnO21.setText(getOUT21+"("+"V"+":"+getIP30+")");
        }
        else if (str21.equals("1f"))
        {
            btnO21.setText(getOUT21+"("+"V"+":"+getIP31+")");
        }
        else if (str21.equals("20"))
        {
            btnO21.setText(getOUT21+"("+"V"+":"+getIP32+")");
        }
        /////////////////////////////////////////////////////////////////////////////////////////////////////////// Output 22 /////////////////////////////////////////////////////////////////////////////////////
        try {
            byte[] byteInput = new byte[]{0x20,0x07,0x16,0x00,(byte) 0x4c};
            DataOutputStream getinput = new DataOutputStream(m_socket.getOutputStream());
            getinput.write(byteInput);
            getinput.flush();
            DataInputStream in = new DataInputStream(m_socket.getInputStream());
            int c = in.read(buff,0,buff.length);
            chaStr(c);
            str22 = feedback[feedback.length-2];
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (str22.equals("00"))
        {
            btnO22.setText(getOUT22);
        }
        else if (str22.equals("01"))
        {
            btnO22.setText(getOUT22+"("+"V"+":"+getIP1+")");
        }
        else if (str22.equals("02"))
        {
            btnO22.setText(getOUT22+"("+"V"+":"+getIP2+")");
        }
        else if (str22.equals("03"))
        {
            btnO22.setText(getOUT22+"("+"V"+":"+getIP3+")");
        }
        else if (str22.equals("04"))
        {
            btnO22.setText(getOUT22+"("+"V"+":"+getIP4+")");
        }
        else if (str22.equals("05"))
        {
            btnO22.setText(getOUT22+"("+"V"+":"+getIP5+")");
        }
        else if (str22.equals("06"))
        {
            btnO22.setText(getOUT22+"("+"V"+":"+getIP6+")");
        }
        else if (str22.equals("07"))
        {
            btnO22.setText(getOUT22+"("+"V"+":"+getIP7+")");
        }
        else if (str22.equals("08"))
        {
            btnO22.setText(getOUT22+"("+"V"+":"+getIP8+")");
        }
        else if (str22.equals("09"))
        {
            btnO22.setText(getOUT22+"("+"V"+":"+getIP9+")");
        }
        else if (str22.equals("0a"))
        {
            btnO22.setText(getOUT22+"("+"V"+":"+getIP10+")");
        }
        else if (str22.equals("0b"))
        {
            btnO22.setText(getOUT22+"("+"V"+":"+getIP11+")");
        }
        else if (str22.equals("0c"))
        {
            btnO22.setText(getOUT22+"("+"V"+":"+getIP12+")");
        }
        else if (str22.equals("0d"))
        {
            btnO22.setText(getOUT22+"("+"V"+":"+getIP13+")");
        }
        else if (str22.equals("0e"))
        {
            btnO22.setText(getOUT22+"("+"V"+":"+getIP14+")");
        }
        else if (str22.equals("0f"))
        {
            btnO22.setText(getOUT22+"("+"V"+":"+getIP15+")");
        }
        else if (str22.equals("10"))
        {
            btnO22.setText(getOUT22+"("+"V"+":"+getIP16+")");
        }
        else if (str22.equals("11"))
        {
            btnO22.setText(getOUT22+"("+"V"+":"+getIP17+")");
        }
        else if (str22.equals("12"))
        {
            btnO22.setText(getOUT22+"("+"V"+":"+getIP18+")");
        }
        else if (str22.equals("13"))
        {
            btnO22.setText(getOUT22+"("+"V"+":"+getIP19+")");
        }
        else if (str22.equals("14"))
        {
            btnO22.setText(getOUT22+"("+"V"+":"+getIP20+")");
        }
        else if (str22.equals("15"))
        {
            btnO22.setText(getOUT22+"("+"V"+":"+getIP21+")");
        }
        else if (str22.equals("16"))
        {
            btnO22.setText(getOUT22+"("+"V"+":"+getIP22+")");
        }
        else if (str22.equals("17"))
        {
            btnO22.setText(getOUT22+"("+"V"+":"+getIP23+")");
        }
        else if (str22.equals("18"))
        {
            btnO22.setText(getOUT22+"("+"V"+":"+getIP24+")");
        }
        else if (str22.equals("19"))
        {
            btnO22.setText(getOUT22+"("+"V"+":"+getIP25+")");
        }
        else if (str22.equals("1a"))
        {
            btnO22.setText(getOUT22+"("+"V"+":"+getIP26+")");
        }
        else if (str22.equals("1b"))
        {
            btnO22.setText(getOUT22+"("+"V"+":"+getIP27+")");
        }
        else if (str22.equals("1c"))
        {
            btnO22.setText(getOUT22+"("+"V"+":"+getIP28+")");
        }
        else if (str22.equals("1d"))
        {
            btnO22.setText(getOUT22+"("+"V"+":"+getIP29+")");
        }
        else if (str22.equals("1e"))
        {
            btnO22.setText(getOUT22+"("+"V"+":"+getIP30+")");
        }
        else if (str22.equals("1f"))
        {
            btnO22.setText(getOUT22+"("+"V"+":"+getIP31+")");
        }
        else if (str22.equals("20"))
        {
            btnO22.setText(getOUT22+"("+"V"+":"+getIP32+")");
        }
/////////////////////////////////////////////////////////////////////////////////////////////////////////// Output 23 /////////////////////////////////////////////////////////////////////////////////////
        try {
            byte[] byteInput = new byte[]{0x20,0x07,0x17,0x00,(byte) 0x88};
            DataOutputStream getinput = new DataOutputStream(m_socket.getOutputStream());
            getinput.write(byteInput);
            getinput.flush();
            DataInputStream in = new DataInputStream(m_socket.getInputStream());
            int c = in.read(buff,0,buff.length);
            chaStr(c);
            str23 = feedback[feedback.length-2];
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (str23.equals("00"))
        {
            btnO23.setText(getOUT23);
        }
        else if (str23.equals("01"))
        {
            btnO23.setText(getOUT23+"("+"V"+":"+getIP1+")");
        }
        else if (str23.equals("02"))
        {
            btnO23.setText(getOUT23+"("+"V"+":"+getIP2+")");
        }
        else if (str23.equals("03"))
        {
            btnO23.setText(getOUT23+"("+"V"+":"+getIP3+")");
        }
        else if (str23.equals("04"))
        {
            btnO23.setText(getOUT23+"("+"V"+":"+getIP4+")");
        }
        else if (str23.equals("05"))
        {
            btnO23.setText(getOUT23+"("+"V"+":"+getIP5+")");
        }
        else if (str23.equals("06"))
        {
            btnO23.setText(getOUT23+"("+"V"+":"+getIP6+")");
        }
        else if (str23.equals("07"))
        {
            btnO23.setText(getOUT23+"("+"V"+":"+getIP7+")");
        }
        else if (str23.equals("08"))
        {
            btnO23.setText(getOUT23+"("+"V"+":"+getIP8+")");
        }
        else if (str23.equals("09"))
        {
            btnO23.setText(getOUT23+"("+"V"+":"+getIP9+")");
        }
        else if (str23.equals("0a"))
        {
            btnO23.setText(getOUT23+"("+"V"+":"+getIP10+")");
        }
        else if (str23.equals("0b"))
        {
            btnO23.setText(getOUT23+"("+"V"+":"+getIP11+")");
        }
        else if (str23.equals("0c"))
        {
            btnO23.setText(getOUT23+"("+"V"+":"+getIP12+")");
        }
        else if (str23.equals("0d"))
        {
            btnO23.setText(getOUT23+"("+"V"+":"+getIP13+")");
        }
        else if (str23.equals("0e"))
        {
            btnO23.setText(getOUT23+"("+"V"+":"+getIP14+")");
        }
        else if (str23.equals("0f"))
        {
            btnO23.setText(getOUT23+"("+"V"+":"+getIP15+")");
        }
        else if (str23.equals("10"))
        {
            btnO23.setText(getOUT23+"("+"V"+":"+getIP16+")");
        }
        else if (str23.equals("11"))
        {
            btnO23.setText(getOUT23+"("+"V"+":"+getIP17+")");
        }
        else if (str23.equals("12"))
        {
            btnO23.setText(getOUT23+"("+"V"+":"+getIP18+")");
        }
        else if (str23.equals("13"))
        {
            btnO23.setText(getOUT23+"("+"V"+":"+getIP19+")");
        }
        else if (str23.equals("14"))
        {
            btnO23.setText(getOUT23+"("+"V"+":"+getIP20+")");
        }
        else if (str23.equals("15"))
        {
            btnO23.setText(getOUT23+"("+"V"+":"+getIP21+")");
        }
        else if (str23.equals("16"))
        {
            btnO23.setText(getOUT23+"("+"V"+":"+getIP22+")");
        }
        else if (str23.equals("17"))
        {
            btnO23.setText(getOUT23+"("+"V"+":"+getIP23+")");
        }
        else if (str23.equals("18"))
        {
            btnO23.setText(getOUT23+"("+"V"+":"+getIP24+")");
        }
        else if (str23.equals("19"))
        {
            btnO23.setText(getOUT23+"("+"V"+":"+getIP25+")");
        }
        else if (str23.equals("1a"))
        {
            btnO23.setText(getOUT23+"("+"V"+":"+getIP26+")");
        }
        else if (str23.equals("1b"))
        {
            btnO23.setText(getOUT23+"("+"V"+":"+getIP27+")");
        }
        else if (str23.equals("1c"))
        {
            btnO23.setText(getOUT23+"("+"V"+":"+getIP28+")");
        }
        else if (str23.equals("1d"))
        {
            btnO23.setText(getOUT23+"("+"V"+":"+getIP29+")");
        }
        else if (str23.equals("1e"))
        {
            btnO23.setText(getOUT23+"("+"V"+":"+getIP30+")");
        }
        else if (str23.equals("1f"))
        {
            btnO23.setText(getOUT23+"("+"V"+":"+getIP31+")");
        }
        else if (str23.equals("20"))
        {
            btnO23.setText(getOUT23+"("+"V"+":"+getIP32+")");
        }
/////////////////////////////////////////////////////////////////////////////////////////////////////////// Output 24 /////////////////////////////////////////////////////////////////////////////////////
        try {
            byte[] byteInput = new byte[]{0x20,0x07,0x18,0x00,(byte) 0x90};
            DataOutputStream getinput = new DataOutputStream(m_socket.getOutputStream());
            getinput.write(byteInput);
            getinput.flush();

            DataInputStream in = new DataInputStream(m_socket.getInputStream());
            int c = in.read(buff,0,buff.length);
            chaStr(c);
            str24 = feedback[feedback.length-2];
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (str24.equals("00"))
        {
            btnO24.setText(getOUT24);
        }
        else if (str24.equals("01"))
        {
            btnO24.setText(getOUT24+"("+"V"+":"+getIP1+")");
        }
        else if (str24.equals("02"))
        {
            btnO24.setText(getOUT24+"("+"V"+":"+getIP2+")");
        }
        else if (str24.equals("03"))
        {
            btnO24.setText(getOUT24+"("+"V"+":"+getIP3+")");
        }
        else if (str24.equals("04"))
        {
            btnO24.setText(getOUT24+"("+"V"+":"+getIP4+")");
        }
        else if (str24.equals("05"))
        {
            btnO24.setText(getOUT24+"("+"V"+":"+getIP5+")");
        }
        else if (str24.equals("06"))
        {
            btnO24.setText(getOUT24+"("+"V"+":"+getIP6+")");
        }
        else if (str24.equals("07"))
        {
            btnO24.setText(getOUT24+"("+"V"+":"+getIP7+")");
        }
        else if (str24.equals("08"))
        {
            btnO24.setText(getOUT24+"("+"V"+":"+getIP8+")");
        }
        else if (str24.equals("09"))
        {
            btnO24.setText(getOUT24+"("+"V"+":"+getIP9+")");
        }
        else if (str24.equals("0a"))
        {
            btnO24.setText(getOUT24+"("+"V"+":"+getIP10+")");
        }
        else if (str24.equals("0b"))
        {
            btnO24.setText(getOUT24+"("+"V"+":"+getIP11+")");
        }
        else if (str24.equals("0c"))
        {
            btnO24.setText(getOUT24+"("+"V"+":"+getIP12+")");
        }
        else if (str24.equals("0d"))
        {
            btnO24.setText(getOUT24+"("+"V"+":"+getIP13+")");
        }
        else if (str24.equals("0e"))
        {
            btnO24.setText(getOUT24+"("+"V"+":"+getIP14+")");
        }
        else if (str24.equals("0f"))
        {
            btnO24.setText(getOUT24+"("+"V"+":"+getIP15+")");
        }
        else if (str24.equals("10"))
        {
            btnO24.setText(getOUT24+"("+"V"+":"+getIP16+")");
        }
        else if (str24.equals("11"))
        {
            btnO24.setText(getOUT24+"("+"V"+":"+getIP17+")");
        }
        else if (str24.equals("12"))
        {
            btnO24.setText(getOUT24+"("+"V"+":"+getIP18+")");
        }
        else if (str24.equals("13"))
        {
            btnO24.setText(getOUT24+"("+"V"+":"+getIP19+")");
        }
        else if (str24.equals("14"))
        {
            btnO24.setText(getOUT24+"("+"V"+":"+getIP20+")");
        }
        else if (str24.equals("15"))
        {
            btnO24.setText(getOUT24+"("+"V"+":"+getIP21+")");
        }
        else if (str24.equals("16"))
        {
            btnO24.setText(getOUT24+"("+"V"+":"+getIP22+")");
        }
        else if (str24.equals("17"))
        {
            btnO24.setText(getOUT24+"("+"V"+":"+getIP23+")");
        }
        else if (str24.equals("18"))
        {
            btnO24.setText(getOUT24+"("+"V"+":"+getIP24+")");
        }
        else if (str24.equals("19"))
        {
            btnO24.setText(getOUT24+"("+"V"+":"+getIP25+")");
        }
        else if (str24.equals("1a"))
        {
            btnO24.setText(getOUT24+"("+"V"+":"+getIP26+")");
        }
        else if (str24.equals("1b"))
        {
            btnO24.setText(getOUT24+"("+"V"+":"+getIP27+")");
        }
        else if (str24.equals("1c"))
        {
            btnO24.setText(getOUT24+"("+"V"+":"+getIP28+")");
        }
        else if (str24.equals("1d"))
        {
            btnO24.setText(getOUT24+"("+"V"+":"+getIP29+")");
        }
        else if (str24.equals("1e"))
        {
            btnO24.setText(getOUT24+"("+"V"+":"+getIP30+")");
        }
        else if (str24.equals("1f"))
        {
            btnO24.setText(getOUT24+"("+"V"+":"+getIP31+")");
        }
        else if (str24.equals("20"))
        {
            btnO24.setText(getOUT24+"("+"V"+":"+getIP32+")");
        }
/////////////////////////////////////////////////////////////////////////////////////////////////////////// Output 25 /////////////////////////////////////////////////////////////////////////////////////
        try {
            byte[] byteInput = new byte[]{0x20,0x07,0x19,0x00,(byte) 0x54};
            DataOutputStream getinput = new DataOutputStream(m_socket.getOutputStream());
            getinput.write(byteInput);
            getinput.flush();
            DataInputStream in = new DataInputStream(m_socket.getInputStream());
            int c = in.read(buff,0,buff.length);
            chaStr(c);
            str25 = feedback[feedback.length-2];
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (str25.equals("00"))
        {
            btnO25.setText(getOUT25);
        }
        else if (str25.equals("01"))
        {
            btnO25.setText(getOUT25+"("+"V"+":"+getIP1+")");
        }
        else if (str25.equals("02"))
        {
            btnO25.setText(getOUT25+"("+"V"+":"+getIP2+")");
        }
        else if (str25.equals("03"))
        {
            btnO25.setText(getOUT25+"("+"V"+":"+getIP3+")");
        }
        else if (str25.equals("04"))
        {
            btnO25.setText(getOUT25+"("+"V"+":"+getIP4+")");
        }
        else if (str25.equals("05"))
        {
            btnO25.setText(getOUT25+"("+"V"+":"+getIP5+")");
        }
        else if (str25.equals("06"))
        {
            btnO25.setText(getOUT25+"("+"V"+":"+getIP6+")");
        }
        else if (str25.equals("07"))
        {
            btnO25.setText(getOUT25+"("+"V"+":"+getIP7+")");
        }
        else if (str25.equals("08"))
        {
            btnO25.setText(getOUT25+"("+"V"+":"+getIP8+")");
        }
        else if (str25.equals("09"))
        {
            btnO25.setText(getOUT25+"("+"V"+":"+getIP9+")");
        }
        else if (str25.equals("0a"))
        {
            btnO25.setText(getOUT25+"("+"V"+":"+getIP10+")");
        }
        else if (str25.equals("0b"))
        {
            btnO25.setText(getOUT25+"("+"V"+":"+getIP11+")");
        }
        else if (str25.equals("0c"))
        {
            btnO25.setText(getOUT25+"("+"V"+":"+getIP12+")");
        }
        else if (str25.equals("0d"))
        {
            btnO25.setText(getOUT25+"("+"V"+":"+getIP13+")");
        }
        else if (str25.equals("0e"))
        {
            btnO25.setText(getOUT25+"("+"V"+":"+getIP14+")");
        }
        else if (str25.equals("0f"))
        {
            btnO25.setText(getOUT25+"("+"V"+":"+getIP15+")");
        }
        else if (str25.equals("10"))
        {
            btnO25.setText(getOUT25+"("+"V"+":"+getIP16+")");
        }
        else if (str25.equals("11"))
        {
            btnO25.setText(getOUT25+"("+"V"+":"+getIP17+")");
        }
        else if (str25.equals("12"))
        {
            btnO25.setText(getOUT25+"("+"V"+":"+getIP18+")");
        }
        else if (str25.equals("13"))
        {
            btnO25.setText(getOUT25+"("+"V"+":"+getIP19+")");
        }
        else if (str25.equals("14"))
        {
            btnO25.setText(getOUT25+"("+"V"+":"+getIP20+")");
        }
        else if (str25.equals("15"))
        {
            btnO25.setText(getOUT25+"("+"V"+":"+getIP21+")");
        }
        else if (str25.equals("16"))
        {
            btnO25.setText(getOUT25+"("+"V"+":"+getIP22+")");
        }
        else if (str25.equals("17"))
        {
            btnO25.setText(getOUT25+"("+"V"+":"+getIP23+")");
        }
        else if (str25.equals("18"))
        {
            btnO25.setText(getOUT25+"("+"V"+":"+getIP24+")");
        }
        else if (str25.equals("19"))
        {
            btnO25.setText(getOUT25+"("+"V"+":"+getIP25+")");
        }
        else if (str25.equals("1a"))
        {
            btnO25.setText(getOUT25+"("+"V"+":"+getIP26+")");
        }
        else if (str25.equals("1b"))
        {
            btnO25.setText(getOUT25+"("+"V"+":"+getIP27+")");
        }
        else if (str25.equals("1c"))
        {
            btnO25.setText(getOUT25+"("+"V"+":"+getIP28+")");
        }
        else if (str25.equals("1d"))
        {
            btnO25.setText(getOUT25+"("+"V"+":"+getIP29+")");
        }
        else if (str25.equals("1e"))
        {
            btnO25.setText(getOUT25+"("+"V"+":"+getIP30+")");
        }
        else if (str25.equals("1f"))
        {
            btnO25.setText(getOUT25+"("+"V"+":"+getIP31+")");
        }
        else if (str25.equals("20"))
        {
            btnO25.setText(getOUT25+"("+"V"+":"+getIP32+")");
        }
/////////////////////////////////////////////////////////////////////////////////////////////////////////// Output 26 /////////////////////////////////////////////////////////////////////////////////////
        try {
            byte[] byteInput = new byte[]{0x20,0x07,0x1a,0x00,(byte) 0x01};
            DataOutputStream getinput = new DataOutputStream(m_socket.getOutputStream());
            getinput.write(byteInput);
            getinput.flush();
            DataInputStream in = new DataInputStream(m_socket.getInputStream());
            int c = in.read(buff,0,buff.length);
            chaStr(c);
            str26 = feedback[feedback.length-2];
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (str26.equals("00"))
        {
            btnO26.setText(getOUT26);
        }
        else if (str26.equals("01"))
        {
            btnO26.setText(getOUT26+"("+"V"+":"+getIP1+")");
        }
        else if (str26.equals("02"))
        {
            btnO26.setText(getOUT26+"("+"V"+":"+getIP2+")");
        }
        else if (str26.equals("03"))
        {
            btnO26.setText(getOUT26+"("+"V"+":"+getIP3+")");
        }
        else if (str26.equals("04"))
        {
            btnO26.setText(getOUT26+"("+"V"+":"+getIP4+")");
        }
        else if (str26.equals("05"))
        {
            btnO26.setText(getOUT26+"("+"V"+":"+getIP5+")");
        }
        else if (str26.equals("06"))
        {
            btnO26.setText(getOUT26+"("+"V"+":"+getIP6+")");
        }
        else if (str26.equals("07"))
        {
            btnO26.setText(getOUT26+"("+"V"+":"+getIP7+")");
        }
        else if (str26.equals("08"))
        {
            btnO26.setText(getOUT26+"("+"V"+":"+getIP8+")");
        }
        else if (str26.equals("09"))
        {
            btnO26.setText(getOUT26+"("+"V"+":"+getIP9+")");
        }
        else if (str26.equals("0a"))
        {
            btnO26.setText(getOUT26+"("+"V"+":"+getIP10+")");
        }
        else if (str26.equals("0b"))
        {
            btnO26.setText(getOUT26+"("+"V"+":"+getIP11+")");
        }
        else if (str26.equals("0c"))
        {
            btnO26.setText(getOUT26+"("+"V"+":"+getIP12+")");
        }
        else if (str26.equals("0d"))
        {
            btnO26.setText(getOUT26+"("+"V"+":"+getIP13+")");
        }
        else if (str26.equals("0e"))
        {
            btnO26.setText(getOUT26+"("+"V"+":"+getIP14+")");
        }
        else if (str26.equals("0f"))
        {
            btnO26.setText(getOUT26+"("+"V"+":"+getIP15+")");
        }
        else if (str26.equals("10"))
        {
            btnO26.setText(getOUT26+"("+"V"+":"+getIP16+")");
        }
        else if (str26.equals("11"))
        {
            btnO26.setText(getOUT26+"("+"V"+":"+getIP17+")");
        }
        else if (str26.equals("12"))
        {
            btnO26.setText(getOUT26+"("+"V"+":"+getIP18+")");
        }
        else if (str26.equals("13"))
        {
            btnO26.setText(getOUT26+"("+"V"+":"+getIP19+")");
        }
        else if (str26.equals("14"))
        {
            btnO26.setText(getOUT26+"("+"V"+":"+getIP20+")");
        }
        else if (str26.equals("15"))
        {
            btnO26.setText(getOUT26+"("+"V"+":"+getIP21+")");
        }
        else if (str26.equals("16"))
        {
            btnO26.setText(getOUT26+"("+"V"+":"+getIP22+")");
        }
        else if (str26.equals("17"))
        {
            btnO26.setText(getOUT26+"("+"V"+":"+getIP23+")");
        }
        else if (str26.equals("18"))
        {
            btnO26.setText(getOUT26+"("+"V"+":"+getIP24+")");
        }
        else if (str26.equals("19"))
        {
            btnO26.setText(getOUT26+"("+"V"+":"+getIP25+")");
        }
        else if (str26.equals("1a"))
        {
            btnO26.setText(getOUT26+"("+"V"+":"+getIP26+")");
        }
        else if (str26.equals("1b"))
        {
            btnO26.setText(getOUT26+"("+"V"+":"+getIP27+")");
        }
        else if (str26.equals("1c"))
        {
            btnO26.setText(getOUT26+"("+"V"+":"+getIP28+")");
        }
        else if (str26.equals("1d"))
        {
            btnO26.setText(getOUT26+"("+"V"+":"+getIP29+")");
        }
        else if (str26.equals("1e"))
        {
            btnO26.setText(getOUT26+"("+"V"+":"+getIP30+")");
        }
        else if (str26.equals("1f"))
        {
            btnO26.setText(getOUT26+"("+"V"+":"+getIP31+")");
        }
        else if (str26.equals("20"))
        {
            btnO26.setText(getOUT26+"("+"V"+":"+getIP32+")");
        }
/////////////////////////////////////////////////////////////////////////////////////////////////////////// Output 27 /////////////////////////////////////////////////////////////////////////////////////
        try {
            byte[] byteInput = new byte[]{0x20,0x07,0x1b,0x00,(byte) 0xc5};
            DataOutputStream getinput = new DataOutputStream(m_socket.getOutputStream());
            getinput.write(byteInput);
            getinput.flush();
            DataInputStream in = new DataInputStream(m_socket.getInputStream());
            int c = in.read(buff,0,buff.length);
            chaStr(c);
            str27 = feedback[feedback.length-2];
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (str27.equals("00"))
        {
            btnO27.setText(getOUT27);
        }
        else if (str27.equals("01"))
        {
            btnO27.setText(getOUT27+"("+"V"+":"+getIP1+")");
        }
        else if (str27.equals("02"))
        {
            btnO27.setText(getOUT27+"("+"V"+":"+getIP2+")");
        }
        else if (str27.equals("03"))
        {
            btnO27.setText(getOUT27+"("+"V"+":"+getIP3+")");
        }
        else if (str27.equals("04"))
        {
            btnO27.setText(getOUT27+"("+"V"+":"+getIP4+")");
        }
        else if (str27.equals("05"))
        {
            btnO27.setText(getOUT27+"("+"V"+":"+getIP5+")");
        }
        else if (str27.equals("06"))
        {
            btnO27.setText(getOUT27+"("+"V"+":"+getIP6+")");
        }
        else if (str27.equals("07"))
        {
            btnO27.setText(getOUT27+"("+"V"+":"+getIP7+")");
        }
        else if (str27.equals("08"))
        {
            btnO27.setText(getOUT27+"("+"V"+":"+getIP8+")");
        }
        else if (str27.equals("09"))
        {
            btnO27.setText(getOUT27+"("+"V"+":"+getIP9+")");
        }
        else if (str27.equals("0a"))
        {
            btnO27.setText(getOUT27+"("+"V"+":"+getIP10+")");
        }
        else if (str27.equals("0b"))
        {
            btnO27.setText(getOUT27+"("+"V"+":"+getIP11+")");
        }
        else if (str27.equals("0c"))
        {
            btnO27.setText(getOUT27+"("+"V"+":"+getIP12+")");
        }
        else if (str27.equals("0d"))
        {
            btnO27.setText(getOUT27+"("+"V"+":"+getIP13+")");
        }
        else if (str27.equals("0e"))
        {
            btnO27.setText(getOUT27+"("+"V"+":"+getIP14+")");
        }
        else if (str27.equals("0f"))
        {
            btnO27.setText(getOUT27+"("+"V"+":"+getIP15+")");
        }
        else if (str27.equals("10"))
        {
            btnO27.setText(getOUT27+"("+"V"+":"+getIP16+")");
        }
        else if (str27.equals("11"))
        {
            btnO27.setText(getOUT27+"("+"V"+":"+getIP17+")");
        }
        else if (str27.equals("12"))
        {
            btnO27.setText(getOUT27+"("+"V"+":"+getIP18+")");
        }
        else if (str27.equals("13"))
        {
            btnO27.setText(getOUT27+"("+"V"+":"+getIP19+")");
        }
        else if (str27.equals("14"))
        {
            btnO27.setText(getOUT27+"("+"V"+":"+getIP20+")");
        }
        else if (str27.equals("15"))
        {
            btnO27.setText(getOUT27+"("+"V"+":"+getIP21+")");
        }
        else if (str27.equals("16"))
        {
            btnO27.setText(getOUT27+"("+"V"+":"+getIP22+")");
        }
        else if (str27.equals("17"))
        {
            btnO27.setText(getOUT27+"("+"V"+":"+getIP23+")");
        }
        else if (str27.equals("18"))
        {
            btnO27.setText(getOUT27+"("+"V"+":"+getIP24+")");
        }
        else if (str27.equals("19"))
        {
            btnO27.setText(getOUT27+"("+"V"+":"+getIP25+")");
        }
        else if (str27.equals("1a"))
        {
            btnO27.setText(getOUT27+"("+"V"+":"+getIP26+")");
        }
        else if (str27.equals("1b"))
        {
            btnO27.setText(getOUT27+"("+"V"+":"+getIP27+")");
        }
        else if (str27.equals("1c"))
        {
            btnO27.setText(getOUT27+"("+"V"+":"+getIP28+")");
        }
        else if (str27.equals("1d"))
        {
            btnO27.setText(getOUT27+"("+"V"+":"+getIP29+")");
        }
        else if (str27.equals("1e"))
        {
            btnO27.setText(getOUT27+"("+"V"+":"+getIP30+")");
        }
        else if (str27.equals("1f"))
        {
            btnO27.setText(getOUT27+"("+"V"+":"+getIP31+")");
        }
        else if (str27.equals("20"))
        {
            btnO27.setText(getOUT27+"("+"V"+":"+getIP32+")");
        }
/////////////////////////////////////////////////////////////////////////////////////////////////////////// Output 28 /////////////////////////////////////////////////////////////////////////////////////
        try {
            byte[] byteInput = new byte[]{0x20,0x07,0x1c,0x00,(byte) 0xab};
            DataOutputStream getinput = new DataOutputStream(m_socket.getOutputStream());
            getinput.write(byteInput);
            getinput.flush();
            DataInputStream in = new DataInputStream(m_socket.getInputStream());
            int c = in.read(buff,0,buff.length);
            chaStr(c);
            str28 = feedback[feedback.length-2];
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (str28.equals("00"))
        {
            btnO28.setText(getOUT28);
        }
        else if (str28.equals("01"))
        {
            btnO28.setText(getOUT28+"("+"V"+":"+getIP1+")");
        }
        else if (str28.equals("02"))
        {
            btnO28.setText(getOUT28+"("+"V"+":"+getIP2+")");
        }
        else if (str28.equals("03"))
        {
            btnO28.setText(getOUT28+"("+"V"+":"+getIP3+")");
        }
        else if (str28.equals("04"))
        {
            btnO28.setText(getOUT28+"("+"V"+":"+getIP4+")");
        }
        else if (str28.equals("05"))
        {
            btnO28.setText(getOUT28+"("+"V"+":"+getIP5+")");
        }
        else if (str28.equals("06"))
        {
            btnO28.setText(getOUT28+"("+"V"+":"+getIP6+")");
        }
        else if (str28.equals("07"))
        {
            btnO28.setText(getOUT28+"("+"V"+":"+getIP7+")");
        }
        else if (str28.equals("08"))
        {
            btnO28.setText(getOUT28+"("+"V"+":"+getIP8+")");
        }
        else if (str28.equals("09"))
        {
            btnO28.setText(getOUT28+"("+"V"+":"+getIP9+")");
        }
        else if (str28.equals("0a"))
        {
            btnO28.setText(getOUT28+"("+"V"+":"+getIP10+")");
        }
        else if (str28.equals("0b"))
        {
            btnO28.setText(getOUT28+"("+"V"+":"+getIP11+")");
        }
        else if (str28.equals("0c"))
        {
            btnO28.setText(getOUT28+"("+"V"+":"+getIP12+")");
        }
        else if (str28.equals("0d"))
        {
            btnO28.setText(getOUT28+"("+"V"+":"+getIP13+")");
        }
        else if (str28.equals("0e"))
        {
            btnO28.setText(getOUT28+"("+"V"+":"+getIP14+")");
        }
        else if (str28.equals("0f"))
        {
            btnO28.setText(getOUT28+"("+"V"+":"+getIP15+")");
        }
        else if (str28.equals("10"))
        {
            btnO28.setText(getOUT28+"("+"V"+":"+getIP16+")");
        }
        else if (str28.equals("11"))
        {
            btnO28.setText(getOUT28+"("+"V"+":"+getIP17+")");
        }
        else if (str28.equals("12"))
        {
            btnO28.setText(getOUT28+"("+"V"+":"+getIP18+")");
        }
        else if (str28.equals("13"))
        {
            btnO28.setText(getOUT28+"("+"V"+":"+getIP19+")");
        }
        else if (str28.equals("14"))
        {
            btnO28.setText(getOUT28+"("+"V"+":"+getIP20+")");
        }
        else if (str28.equals("15"))
        {
            btnO28.setText(getOUT28+"("+"V"+":"+getIP21+")");
        }
        else if (str28.equals("16"))
        {
            btnO28.setText(getOUT28+"("+"V"+":"+getIP22+")");
        }
        else if (str28.equals("17"))
        {
            btnO28.setText(getOUT28+"("+"V"+":"+getIP23+")");
        }
        else if (str28.equals("18"))
        {
            btnO28.setText(getOUT28+"("+"V"+":"+getIP24+")");
        }
        else if (str28.equals("19"))
        {
            btnO28.setText(getOUT28+"("+"V"+":"+getIP25+")");
        }
        else if (str28.equals("1a"))
        {
            btnO28.setText(getOUT28+"("+"V"+":"+getIP26+")");
        }
        else if (str28.equals("1b"))
        {
            btnO28.setText(getOUT28+"("+"V"+":"+getIP27+")");
        }
        else if (str28.equals("1c"))
        {
            btnO28.setText(getOUT28+"("+"V"+":"+getIP28+")");
        }
        else if (str28.equals("1d"))
        {
            btnO28.setText(getOUT28+"("+"V"+":"+getIP29+")");
        }
        else if (str28.equals("1e"))
        {
            btnO28.setText(getOUT28+"("+"V"+":"+getIP30+")");
        }
        else if (str28.equals("1f"))
        {
            btnO28.setText(getOUT28+"("+"V"+":"+getIP31+")");
        }
        else if (str28.equals("20"))
        {
            btnO28.setText(getOUT28+"("+"V"+":"+getIP32+")");
        }
/////////////////////////////////////////////////////////////////////////////////////////////////////////// Output 29 /////////////////////////////////////////////////////////////////////////////////////
        try {
            byte[] byteInput = new byte[]{0x20,0x07,0x1d,0x00,(byte) 0x6f};
            DataOutputStream getinput = new DataOutputStream(m_socket.getOutputStream());
            getinput.write(byteInput);
            getinput.flush();
            DataInputStream in = new DataInputStream(m_socket.getInputStream());
            int c = in.read(buff,0,buff.length);
            chaStr(c);
            str29 = feedback[feedback.length-2];
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (str29.equals("00"))
        {
            btnO29.setText(getOUT29);
        }
        else if (str29.equals("01"))
        {
            btnO29.setText(getOUT29+"("+"V"+":"+getIP1+")");
        }
        else if (str29.equals("02"))
        {
            btnO29.setText(getOUT29+"("+"V"+":"+getIP2+")");
        }
        else if (str29.equals("03"))
        {
            btnO29.setText(getOUT29+"("+"V"+":"+getIP3+")");
        }
        else if (str29.equals("04"))
        {
            btnO29.setText(getOUT29+"("+"V"+":"+getIP4+")");
        }
        else if (str29.equals("05"))
        {
            btnO29.setText(getOUT29+"("+"V"+":"+getIP5+")");
        }
        else if (str29.equals("06"))
        {
            btnO29.setText(getOUT29+"("+"V"+":"+getIP6+")");
        }
        else if (str29.equals("07"))
        {
            btnO29.setText(getOUT29+"("+"V"+":"+getIP7+")");
        }
        else if (str29.equals("08"))
        {
            btnO29.setText(getOUT29+"("+"V"+":"+getIP8+")");
        }
        else if (str29.equals("09"))
        {
            btnO29.setText(getOUT29+"("+"V"+":"+getIP9+")");
        }
        else if (str29.equals("0a"))
        {
            btnO29.setText(getOUT29+"("+"V"+":"+getIP10+")");
        }
        else if (str29.equals("0b"))
        {
            btnO29.setText(getOUT29+"("+"V"+":"+getIP11+")");
        }
        else if (str29.equals("0c"))
        {
            btnO29.setText(getOUT29+"("+"V"+":"+getIP12+")");
        }
        else if (str29.equals("0d"))
        {
            btnO29.setText(getOUT29+"("+"V"+":"+getIP13+")");
        }
        else if (str29.equals("0e"))
        {
            btnO29.setText(getOUT29+"("+"V"+":"+getIP14+")");
        }
        else if (str29.equals("0f"))
        {
            btnO29.setText(getOUT29+"("+"V"+":"+getIP15+")");
        }
        else if (str29.equals("10"))
        {
            btnO29.setText(getOUT29+"("+"V"+":"+getIP16+")");
        }
        else if (str29.equals("11"))
        {
            btnO29.setText(getOUT29+"("+"V"+":"+getIP17+")");
        }
        else if (str29.equals("12"))
        {
            btnO29.setText(getOUT29+"("+"V"+":"+getIP18+")");
        }
        else if (str29.equals("13"))
        {
            btnO29.setText(getOUT29+"("+"V"+":"+getIP19+")");
        }
        else if (str29.equals("14"))
        {
            btnO29.setText(getOUT29+"("+"V"+":"+getIP20+")");
        }
        else if (str29.equals("15"))
        {
            btnO29.setText(getOUT29+"("+"V"+":"+getIP21+")");
        }
        else if (str29.equals("16"))
        {
            btnO29.setText(getOUT29+"("+"V"+":"+getIP22+")");
        }
        else if (str29.equals("17"))
        {
            btnO29.setText(getOUT29+"("+"V"+":"+getIP23+")");
        }
        else if (str29.equals("18"))
        {
            btnO29.setText(getOUT29+"("+"V"+":"+getIP24+")");
        }
        else if (str29.equals("19"))
        {
            btnO29.setText(getOUT29+"("+"V"+":"+getIP25+")");
        }
        else if (str29.equals("1a"))
        {
            btnO29.setText(getOUT29+"("+"V"+":"+getIP26+")");
        }
        else if (str29.equals("1b"))
        {
            btnO29.setText(getOUT29+"("+"V"+":"+getIP27+")");
        }
        else if (str29.equals("1c"))
        {
            btnO29.setText(getOUT29+"("+"V"+":"+getIP28+")");
        }
        else if (str29.equals("1d"))
        {
            btnO29.setText(getOUT29+"("+"V"+":"+getIP29+")");
        }
        else if (str29.equals("1e"))
        {
            btnO29.setText(getOUT29+"("+"V"+":"+getIP30+")");
        }
        else if (str29.equals("1f"))
        {
            btnO29.setText(getOUT29+"("+"V"+":"+getIP31+")");
        }
        else if (str29.equals("20"))
        {
            btnO29.setText(getOUT29+"("+"V"+":"+getIP32+")");
        }
/////////////////////////////////////////////////////////////////////////////////////////////////////////// Output 30 /////////////////////////////////////////////////////////////////////////////////////
        try {
            byte[] byteInput = new byte[]{0x20,0x07,0x1e,0x00,(byte) 0x3a};
            DataOutputStream getinput = new DataOutputStream(m_socket.getOutputStream());
            getinput.write(byteInput);
            getinput.flush();
            DataInputStream in = new DataInputStream(m_socket.getInputStream());
            int c = in.read(buff,0,buff.length);
            chaStr(c);
            str30 = feedback[feedback.length-2];
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (str30.equals("00"))
        {
            btnO30.setText(getOUT30);
        }
        else if (str30.equals("01"))
        {
            btnO30.setText(getOUT30+"("+"V"+":"+getIP1+")");
        }
        else if (str30.equals("02"))
        {
            btnO30.setText(getOUT30+"("+"V"+":"+getIP2+")");
        }
        else if (str30.equals("03"))
        {
            btnO30.setText(getOUT30+"("+"V"+":"+getIP3+")");
        }
        else if (str30.equals("04"))
        {
            btnO30.setText(getOUT30+"("+"V"+":"+getIP4+")");
        }
        else if (str30.equals("05"))
        {
            btnO30.setText(getOUT30+"("+"V"+":"+getIP5+")");
        }
        else if (str30.equals("06"))
        {
            btnO30.setText(getOUT30+"("+"V"+":"+getIP6+")");
        }
        else if (str30.equals("07"))
        {
            btnO30.setText(getOUT30+"("+"V"+":"+getIP7+")");
        }
        else if (str30.equals("08"))
        {
            btnO30.setText(getOUT30+"("+"V"+":"+getIP8+")");
        }
        else if (str30.equals("09"))
        {
            btnO30.setText(getOUT30+"("+"V"+":"+getIP9+")");
        }
        else if (str30.equals("0a"))
        {
            btnO30.setText(getOUT30+"("+"V"+":"+getIP10+")");
        }
        else if (str30.equals("0b"))
        {
            btnO30.setText(getOUT30+"("+"V"+":"+getIP11+")");
        }
        else if (str30.equals("0c"))
        {
            btnO30.setText(getOUT30+"("+"V"+":"+getIP12+")");
        }
        else if (str30.equals("0d"))
        {
            btnO30.setText(getOUT30+"("+"V"+":"+getIP13+")");
        }
        else if (str30.equals("0e"))
        {
            btnO30.setText(getOUT30+"("+"V"+":"+getIP14+")");
        }
        else if (str30.equals("0f"))
        {
            btnO30.setText(getOUT30+"("+"V"+":"+getIP15+")");
        }
        else if (str30.equals("10"))
        {
            btnO30.setText(getOUT30+"("+"V"+":"+getIP16+")");
        }
        else if (str30.equals("11"))
        {
            btnO30.setText(getOUT30+"("+"V"+":"+getIP17+")");
        }
        else if (str30.equals("12"))
        {
            btnO30.setText(getOUT30+"("+"V"+":"+getIP18+")");
        }
        else if (str30.equals("13"))
        {
            btnO30.setText(getOUT30+"("+"V"+":"+getIP19+")");
        }
        else if (str30.equals("14"))
        {
            btnO30.setText(getOUT30+"("+"V"+":"+getIP20+")");
        }
        else if (str30.equals("15"))
        {
            btnO30.setText(getOUT30+"("+"V"+":"+getIP21+")");
        }
        else if (str30.equals("16"))
        {
            btnO30.setText(getOUT30+"("+"V"+":"+getIP22+")");
        }
        else if (str30.equals("17"))
        {
            btnO30.setText(getOUT30+"("+"V"+":"+getIP23+")");
        }
        else if (str30.equals("18"))
        {
            btnO30.setText(getOUT30+"("+"V"+":"+getIP24+")");
        }
        else if (str30.equals("19"))
        {
            btnO30.setText(getOUT30+"("+"V"+":"+getIP25+")");
        }
        else if (str30.equals("1a"))
        {
            btnO30.setText(getOUT30+"("+"V"+":"+getIP26+")");
        }
        else if (str30.equals("1b"))
        {
            btnO30.setText(getOUT30+"("+"V"+":"+getIP27+")");
        }
        else if (str30.equals("1c"))
        {
            btnO30.setText(getOUT30+"("+"V"+":"+getIP28+")");
        }
        else if (str30.equals("1d"))
        {
            btnO30.setText(getOUT30+"("+"V"+":"+getIP29+")");
        }
        else if (str30.equals("1e"))
        {
            btnO30.setText(getOUT30+"("+"V"+":"+getIP30+")");
        }
        else if (str30.equals("1f"))
        {
            btnO30.setText(getOUT30+"("+"V"+":"+getIP31+")");
        }
        else if (str30.equals("20"))
        {
            btnO30.setText(getOUT30+"("+"V"+":"+getIP32+")");
        }
/////////////////////////////////////////////////////////////////////////////////////////////////////////// Output 31 /////////////////////////////////////////////////////////////////////////////////////
        try {
            byte[] byteInput = new byte[]{0x20,0x07,0x1f,0x00,(byte) 0xfe};
            DataOutputStream getinput = new DataOutputStream(m_socket.getOutputStream());
            getinput.write(byteInput);
            getinput.flush();
            DataInputStream in = new DataInputStream(m_socket.getInputStream());
            int c = in.read(buff,0,buff.length);
            chaStr(c);
            str31 = feedback[feedback.length-2];
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (str31.equals("00"))
        {
            btnO31.setText(getOUT31);
        }
        else if (str31.equals("01"))
        {
            btnO31.setText(getOUT31+"("+"V"+":"+getIP1+")");
        }
        else if (str31.equals("02"))
        {
            btnO31.setText(getOUT31+"("+"V"+":"+getIP2+")");
        }
        else if (str31.equals("03"))
        {
            btnO31.setText(getOUT31+"("+"V"+":"+getIP3+")");
        }
        else if (str31.equals("04"))
        {
            btnO31.setText(getOUT31+"("+"V"+":"+getIP4+")");
        }
        else if (str31.equals("05"))
        {
            btnO31.setText(getOUT31+"("+"V"+":"+getIP5+")");
        }
        else if (str31.equals("06"))
        {
            btnO31.setText(getOUT31+"("+"V"+":"+getIP6+")");
        }
        else if (str31.equals("07"))
        {
            btnO31.setText(getOUT31+"("+"V"+":"+getIP7+")");
        }
        else if (str31.equals("08"))
        {
            btnO31.setText(getOUT31+"("+"V"+":"+getIP8+")");
        }
        else if (str31.equals("09"))
        {
            btnO31.setText(getOUT31+"("+"V"+":"+getIP9+")");
        }
        else if (str31.equals("0a"))
        {
            btnO31.setText(getOUT31+"("+"V"+":"+getIP10+")");
        }
        else if (str31.equals("0b"))
        {
            btnO31.setText(getOUT31+"("+"V"+":"+getIP11+")");
        }
        else if (str31.equals("0c"))
        {
            btnO31.setText(getOUT31+"("+"V"+":"+getIP12+")");
        }
        else if (str31.equals("0d"))
        {
            btnO31.setText(getOUT31+"("+"V"+":"+getIP13+")");
        }
        else if (str31.equals("0e"))
        {
            btnO31.setText(getOUT31+"("+"V"+":"+getIP14+")");
        }
        else if (str31.equals("0f"))
        {
            btnO31.setText(getOUT31+"("+"V"+":"+getIP15+")");
        }
        else if (str31.equals("10"))
        {
            btnO31.setText(getOUT31+"("+"V"+":"+getIP16+")");
        }
        else if (str31.equals("11"))
        {
            btnO31.setText(getOUT31+"("+"V"+":"+getIP17+")");
        }
        else if (str31.equals("12"))
        {
            btnO31.setText(getOUT31+"("+"V"+":"+getIP18+")");
        }
        else if (str31.equals("13"))
        {
            btnO31.setText(getOUT31+"("+"V"+":"+getIP19+")");
        }
        else if (str31.equals("14"))
        {
            btnO31.setText(getOUT31+"("+"V"+":"+getIP20+")");
        }
        else if (str31.equals("15"))
        {
            btnO31.setText(getOUT31+"("+"V"+":"+getIP21+")");
        }
        else if (str31.equals("16"))
        {
            btnO31.setText(getOUT31+"("+"V"+":"+getIP22+")");
        }
        else if (str31.equals("17"))
        {
            btnO31.setText(getOUT31+"("+"V"+":"+getIP23+")");
        }
        else if (str31.equals("18"))
        {
            btnO31.setText(getOUT31+"("+"V"+":"+getIP24+")");
        }
        else if (str31.equals("19"))
        {
            btnO31.setText(getOUT31+"("+"V"+":"+getIP25+")");
        }
        else if (str31.equals("1a"))
        {
            btnO31.setText(getOUT31+"("+"V"+":"+getIP26+")");
        }
        else if (str31.equals("1b"))
        {
            btnO31.setText(getOUT31+"("+"V"+":"+getIP27+")");
        }
        else if (str31.equals("1c"))
        {
            btnO31.setText(getOUT31+"("+"V"+":"+getIP28+")");
        }
        else if (str31.equals("1d"))
        {
            btnO31.setText(getOUT31+"("+"V"+":"+getIP29+")");
        }
        else if (str31.equals("1e"))
        {
            btnO31.setText(getOUT31+"("+"V"+":"+getIP30+")");
        }
        else if (str31.equals("1f"))
        {
            btnO31.setText(getOUT31+"("+"V"+":"+getIP31+")");
        }
        else if (str31.equals("20"))
        {
            btnO31.setText(getOUT31+"("+"V"+":"+getIP32+")");
        }
/////////////////////////////////////////////////////////////////////////////////////////////////////////// Output 32 /////////////////////////////////////////////////////////////////////////////////////
        try {
            byte[] byteInput = new byte[]{0x20,0x07,0x20,0x00,(byte) 0xcb};
            DataOutputStream getinput = new DataOutputStream(m_socket.getOutputStream());
            getinput.write(byteInput);
            getinput.flush();
            DataInputStream in = new DataInputStream(m_socket.getInputStream());
            int c = in.read(buff,0,buff.length);
            chaStr(c);
            str32 = feedback[feedback.length-2];
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (str32.equals("00"))
        {
            btnO32.setText(getOUT32);
        }
        else if (str32.equals("01"))
        {
            btnO32.setText(getOUT32+"("+"V"+":"+getIP1+")");
        }
        else if (str32.equals("02"))
        {
            btnO32.setText(getOUT32+"("+"V"+":"+getIP2+")");
        }
        else if (str32.equals("03"))
        {
            btnO32.setText(getOUT32+"("+"V"+":"+getIP3+")");
        }
        else if (str32.equals("04"))
        {
            btnO32.setText(getOUT32+"("+"V"+":"+getIP4+")");
        }
        else if (str32.equals("05"))
        {
            btnO32.setText(getOUT32+"("+"V"+":"+getIP5+")");
        }
        else if (str32.equals("06"))
        {
            btnO32.setText(getOUT32+"("+"V"+":"+getIP6+")");
        }
        else if (str32.equals("07"))
        {
            btnO32.setText(getOUT32+"("+"V"+":"+getIP7+")");
        }
        else if (str32.equals("08"))
        {
            btnO32.setText(getOUT32+"("+"V"+":"+getIP8+")");
        }
        else if (str32.equals("09"))
        {
            btnO32.setText(getOUT32+"("+"V"+":"+getIP9+")");
        }
        else if (str32.equals("0a"))
        {
            btnO32.setText(getOUT32+"("+"V"+":"+getIP10+")");
        }
        else if (str32.equals("0b"))
        {
            btnO32.setText(getOUT32+"("+"V"+":"+getIP11+")");
        }
        else if (str32.equals("0c"))
        {
            btnO32.setText(getOUT32+"("+"V"+":"+getIP12+")");
        }
        else if (str32.equals("0d"))
        {
            btnO32.setText(getOUT32+"("+"V"+":"+getIP13+")");
        }
        else if (str32.equals("0e"))
        {
            btnO32.setText(getOUT32+"("+"V"+":"+getIP14+")");
        }
        else if (str32.equals("0f"))
        {
            btnO32.setText(getOUT32+"("+"V"+":"+getIP15+")");
        }
        else if (str32.equals("10"))
        {
            btnO32.setText(getOUT32+"("+"V"+":"+getIP16+")");
        }
        else if (str32.equals("11"))
        {
            btnO32.setText(getOUT32+"("+"V"+":"+getIP17+")");
        }
        else if (str32.equals("12"))
        {
            btnO32.setText(getOUT32+"("+"V"+":"+getIP18+")");
        }
        else if (str32.equals("13"))
        {
            btnO32.setText(getOUT32+"("+"V"+":"+getIP19+")");
        }
        else if (str32.equals("14"))
        {
            btnO32.setText(getOUT32+"("+"V"+":"+getIP20+")");
        }
        else if (str32.equals("15"))
        {
            btnO32.setText(getOUT32+"("+"V"+":"+getIP21+")");
        }
        else if (str32.equals("16"))
        {
            btnO32.setText(getOUT32+"("+"V"+":"+getIP22+")");
        }
        else if (str32.equals("17"))
        {
            btnO32.setText(getOUT32+"("+"V"+":"+getIP23+")");
        }
        else if (str32.equals("18"))
        {
            btnO32.setText(getOUT32+"("+"V"+":"+getIP24+")");
        }
        else if (str32.equals("19"))
        {
            btnO32.setText(getOUT32+"("+"V"+":"+getIP25+")");
        }
        else if (str32.equals("1a"))
        {
            btnO32.setText(getOUT32+"("+"V"+":"+getIP26+")");
        }
        else if (str32.equals("1b"))
        {
            btnO32.setText(getOUT32+"("+"V"+":"+getIP27+")");
        }
        else if (str32.equals("1c"))
        {
            btnO32.setText(getOUT32+"("+"V"+":"+getIP28+")");
        }
        else if (str32.equals("1d"))
        {
            btnO32.setText(getOUT32+"("+"V"+":"+getIP29+")");
        }
        else if (str32.equals("1e"))
        {
            btnO32.setText(getOUT32+"("+"V"+":"+getIP30+")");
        }
        else if (str32.equals("1f"))
        {
            btnO32.setText(getOUT32+"("+"V"+":"+getIP31+")");
        }
        else if (str32.equals("20"))
        {
            btnO32.setText(getOUT32+"("+"V"+":"+getIP32+")");
        }

    }

}