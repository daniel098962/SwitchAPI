package user.example.hs_pc013.switchapi;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
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

public class HX_2544 extends ClientCode {

    ImageButton btnC;
    ImageButton btnF;
    ImageButton btnS;
    RadioGroup rgAV,rgIN,rgOP,rgME,rgAll;

    RadioButton btnA1;
    RadioButton btnA2;
    RadioButton btnIN1;
    RadioButton btnIN2;
    RadioButton btnIN3;
    RadioButton btnIN4;
    RadioButton btnO3;
    RadioButton btnO4;
    RadioButton btnO1;
    RadioButton btnO2;
    RadioButton btnM1;
    RadioButton btnM2;
    RadioButton btnAll,btnOff;
    TextView txtN,txtI,txtV;
    Intent change = new Intent();
    Intent Mation = new Intent();

    String IP2,TYPE,IP3;
    int PORT2;
    Button btnTRY,btnTRY2;
    byte buff[] = new byte[4096];
    int Bhex[],BhexB[],BhexC[],BhexC1[],IVB[],DB[];
    byte x,y,z;
    String str = "";
    int a;
    String feedback[],bx,VerAB,VerA,VerB;
    int len,LB,INF,DN,CB,Ot,It,IB;
    char T[],TF[];
    String AorV = "";
    int InpuT=1,OutpuT;
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
    int MeTol,MeNum[];
    String str1,str2,str3,str4;
    String inputString2544;
    String inputString1,inputString2,inputString3,inputString4;
    String getIP1,getIP2,getIP3,getIP4;
    String getOUT1,getOUT2,getOUT3,getOUT4;
    SharedPreferences sharedPreferences;



    byte[] CRCTable =
            {
                    0x00, 0x5e, (byte) 0xbc, (byte) 0xe2, 0x61, 0x3f, (byte)0xdd, (byte)0x83,
                    (byte)0xc2, (byte)0x9c, 0x7e, 0x20, (byte)0xa3, (byte)0xfd, 0x1f, 0x41,
                    (byte) 0x9d, (byte)0xc3, 0x21, 0x7f, (byte)0xfc, (byte)0xa2, 0x40, 0x1e,
                    0x5f, 0x01, (byte)0xe3, (byte)0xbd, 0x3e, 0x60, (byte)0x82, (byte)0xdc,
                    0x23, 0x7d, (byte)0x9f, (byte)0xc1, 0x42, 0x1c, (byte)0xfe, (byte)0xa0,
                    (byte)0xe1, (byte)0xbf, 0x5d, 0x03, (byte)0x80, (byte)0xde, 0x3c, 0x62,
                    (byte)0xbe, (byte)0xe0, 0x02, 0x5c, (byte)0xdf, (byte)0x81, 0x63, 0x3d,
                    0x7c, 0x22, (byte)0xc0, (byte)0x9e, 0x1d, 0x43, (byte)0xa1, (byte)0xff,
                    0x46, 0x18, (byte)0xfa, (byte)0xa4, 0x27, 0x79, (byte)0x9b, (byte)0xc5,
                    (byte)0x84, (byte)0xda, 0x38, 0x66, (byte)0xe5, (byte)0xbb, 0x59, 0x07,
                    (byte)0xdb, (byte)0x85, 0x67, 0x39, (byte)0xba, (byte)0xe4, 0x06, 0x58,
                    0x19, 0x47, (byte)0xa5, (byte)0xfb, 0x78, 0x26, (byte)0xc4, (byte)0x9a,
                    0x65, 0x3b, (byte)0xd9, (byte)0x87, 0x04, 0x5a, (byte)0xb8, (byte)0xe6,
                    (byte)0xa7, (byte)0xf9, 0x1b, 0x45, (byte)0xc6, (byte)0x98, 0x7a, 0x24,
                    (byte)0xf8, (byte)0xa6, 0x44, 0x1a, (byte)0x99, (byte)0xc7, 0x25, 0x7b,
                    0x3a, 0x64, (byte)0x86, (byte)0xd8, 0x5b, 0x05, (byte)0xe7, (byte)0xb9,
                    (byte)0x8c, (byte)0xd2, 0x30, 0x6e, (byte)0xed, (byte)0xb3, 0x51, 0x0f,
                    0x4e, 0x10, (byte)0xf2, (byte)0xac, 0x2f, 0x71, (byte)0x93, (byte)0xcd,
                    0x11, 0x4f, (byte)0xad, (byte)0xf3, 0x70, 0x2e, (byte)0xcc, (byte)0x92,
                    (byte)0xd3, (byte)0x8d, 0x6f, 0x31, (byte)0xb2, (byte)0xec, 0x0e, 0x50,
                    (byte)0xaf, (byte)0xf1, 0x13, 0x4d, (byte)0xce, (byte)0x90, 0x72, 0x2c,
                    0x6d, 0x33, (byte)0xd1, (byte)0x8f, 0x0c, 0x52, (byte)0xb0, (byte)0xee,
                    0x32, 0x6c, (byte)0x8e, (byte)0xd0, 0x53, 0x0d, (byte)0xef, (byte)0xb1,
                    (byte)0xf0, (byte)0xae, 0x4c, 0x12, (byte)0x91, (byte)0xcf, 0x2d, 0x73,
                    (byte)0xca, (byte)0x94, 0x76, 0x28, (byte)0xab, (byte)0xf5, 0x17, 0x49,
                    0x08, 0x56, (byte)0xb4, (byte)0xea, 0x69, 0x37, (byte)0xd5, (byte)0x8b,
                    0x57, 0x09, (byte)0xeb, (byte)0xb5, 0x36, 0x68, (byte)0x8a, (byte)0xd4,
                    (byte)0x95, (byte)0xcb, 0x29, 0x77, (byte)0xf4, (byte)0xaa, 0x48, 0x16,
                    (byte)0xe9, (byte)0xb7, 0x55, 0x0b, (byte)0x88, (byte)0xd6, 0x34, 0x6a,
                    0x2b, 0x75, (byte)0x97, (byte)0xc9, 0x4a, 0x14, (byte)0xf6, (byte)0xa8,
                    0x74, 0x2a, (byte)0xc8, (byte)0x96, 0x15, 0x4b, (byte)0xa9, (byte)0xf7,
                    (byte)0xb6, (byte)0xe8, 0x0a, 0x54, (byte)0xd7, (byte)0x89, 0x6b, 0x35,
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hx_2544);

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
/*
        mToolbar.setNavigationIcon(R.drawable.ic_navigate_before_black_24dp);

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    s.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                finish();
            }
        });
*/
        rgAV = (RadioGroup)findViewById(R.id.segmentAV);
        rgIN = (RadioGroup)findViewById(R.id.segmentedIn);
        rgOP = (RadioGroup)findViewById(R.id.segmentOutput);
        rgME = (RadioGroup)findViewById(R.id.segmentMe);
        rgAll = (RadioGroup)findViewById(R.id.segmentAll);

        rgAV.setOnCheckedChangeListener(radLis);
        rgIN.setOnCheckedChangeListener(radLis);
        rgOP.setOnCheckedChangeListener(radLis);
        rgME.setOnCheckedChangeListener(radLis);
        rgAll.setOnCheckedChangeListener(radLis);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int vWidth = dm.widthPixels;
        int vHeight = dm.heightPixels;

        rgAV.getLayoutParams().width = (int)((vWidth-214.2)/2);
        rgIN.getLayoutParams().width = (int)(vWidth-214.2);
        rgAll.getLayoutParams().width=(int)((vWidth-214.2)/2);
        rgOP.getLayoutParams().width = (int)(vWidth-214.2);
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

        btnO3 = (RadioButton) findViewById(R.id.btnOU3);
        btnO3.setEnabled(true);

        btnO4 = (RadioButton) findViewById(R.id.btnOU4);
        btnO4.setEnabled(true);

        btnO1 = (RadioButton) findViewById(R.id.btnOU1);
        btnO1.setEnabled(true);

        btnO2 = (RadioButton) findViewById(R.id.btnOU2);
        btnO2.setEnabled(true);

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

                    change.setClass(HX_2544.this,ClientCode.class);

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

                    Output1 = btnO1.getText().toString();
                    Output2 = btnO2.getText().toString();
                    Output3 = btnO3.getText().toString();
                    Output4 = btnO4.getText().toString();

                    change.setClass(HX_2544.this,SettingConfig2544.class);
                    Bundle bundleConSet = new Bundle();
                    bundleConSet.putString("In1",Input1);
                    bundleConSet.putString("In2",Input2);
                    bundleConSet.putString("In3",Input3);
                    bundleConSet.putString("In4",Input4);

                    bundleConSet.putString("Out1",getOUT1);
                    bundleConSet.putString("Out2",getOUT2);
                    bundleConSet.putString("Out3",getOUT3);
                    bundleConSet.putString("Out4",getOUT4);

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

                    change.setClass(HX_2544.this, AV_Setting.class);
                    startActivity(change);

                    break;
                }
                case R.id.btnIN1:
                {
                    //rd2.setText("Change");
                    btnIN1.setTextColor(Color.parseColor("#ffffff"));
                    btnIN2.setTextColor(Color.parseColor("#c90000"));
                    btnIN3.setTextColor(Color.parseColor("#c90000"));
                    btnIN4.setTextColor(Color.parseColor("#c90000"));


                    InpuT = 1;
                    Inp = 0x01;
                    inputString2544 = btnIN1.getText().toString();
                    LastInput2544 = 1;


                    break;
                }
                case R.id.btnIN2:
                {
                    //rd2.setText("Change");
                    btnIN2.setTextColor(Color.parseColor("#ffffff"));
                    btnIN1.setTextColor(Color.parseColor("#c90000"));
                    btnIN3.setTextColor(Color.parseColor("#c90000"));
                    btnIN4.setTextColor(Color.parseColor("#c90000"));


                    InpuT = 2;
                    Inp = 0x02;
                    inputString2544 = btnIN2.getText().toString();
                    LastInput2544 = 2;

                    break;
                }
                case R.id.btnIN3:
                {
                    //rd2.setText("Change");
                    btnIN3.setTextColor(Color.parseColor("#ffffff"));
                    btnIN2.setTextColor(Color.parseColor("#c90000"));
                    btnIN1.setTextColor(Color.parseColor("#c90000"));
                    btnIN4.setTextColor(Color.parseColor("#c90000"));

                    InpuT = 3;
                    Inp = 0x03;
                    inputString2544 = btnIN3.getText().toString();
                    LastInput2544 = 3;

                    break;
                }
                case R.id.btnIN4:
                {
                    //rd2.setText("Change");
                    btnIN4.setTextColor(Color.parseColor("#ffffff"));
                    btnIN2.setTextColor(Color.parseColor("#c90000"));
                    btnIN3.setTextColor(Color.parseColor("#c90000"));
                    btnIN1.setTextColor(Color.parseColor("#c90000"));

                    InpuT = 4;
                    Inp = 0x04;
                    inputString2544 = btnIN4.getText().toString();
                    LastInput2544 = 4;

                    break;
                }
                case R.id.btnOU1:
                {

                    if (AorV.equals("Video") || AorV.equals("Audio") || AorV.equals("")) {

                        OutpuT = 1;
                        OuT = 0x01;

                        btnO1.setText(getOUT1+"("+"V"+":"+inputString2544+")");

                        byteCB = new byte[]{0x20, 0x01, OuT, Inp};

                        CrcTraFor(byteCB);

                        byteAV = new byte[]{0x20, 0x01, OuT, Inp, cb[3]};
                        //Connect();
                        SwitchAV(byteAV);

                    }
                    else         //
                    {
                        Toast.makeText(HX_2544.this, "You choose the wrong button  " + AorV + " please change", Toast.LENGTH_LONG).show();
                    }
                    rgOP.clearCheck();
                    break;
                }
                case R.id.btnOU2:
                {

                    if (AorV.equals("Video") || AorV.equals("Audio") || AorV.equals("")) {

                        OutpuT = 2;
                        OuT = 0x02;

                        btnO2.setText(getOUT2+"("+"V"+":"+inputString2544+")");

                        byteCB = new byte[]{0x20, 0x01, OuT, Inp};

                        CrcTraFor(byteCB);

                        byteAV = new byte[]{0x20, 0x01, OuT, Inp, cb[3]};
                        //Connect();
                        SwitchAV(byteAV);

                    }
                    else         //
                    {
                        Toast.makeText(HX_2544.this, "You choose the wrong button  " + AorV + " please change", Toast.LENGTH_LONG).show();
                    }

                    rgOP.clearCheck();
                    break;
                }
                case R.id.btnOU3:
                {

                    if (AorV.equals("Video") || AorV.equals("Audio") || AorV.equals("")) {

                        OutpuT = 3;
                        OuT = 0x03;

                        btnO3.setText(getOUT3+"("+"V"+":"+inputString2544+")");

                        byteCB = new byte[]{0x20, 0x01, OuT, Inp};

                        CrcTraFor(byteCB);

                        byteAV = new byte[]{0x20, 0x01, OuT, Inp, cb[3]};
                        //Connect();
                        SwitchAV(byteAV);

                    }
                    else         //
                    {
                        Toast.makeText(HX_2544.this, "You choose the wrong button  " + AorV + " please change", Toast.LENGTH_LONG).show();
                    }

                    rgOP.clearCheck();
                    break;
                }
                case R.id.btnOU4:
                {

                    if (AorV.equals("Video") || AorV.equals("Audio") || AorV.equals("")) {

                        OutpuT = 4;
                        OuT = 0x04;

                        btnO4.setText(getOUT4+"("+"V"+":"+inputString2544+")");

                        byteCB = new byte[]{0x20, 0x01, OuT, Inp};

                        CrcTraFor(byteCB);

                        byteAV = new byte[]{0x20, 0x01, OuT, Inp, cb[3]};
                        //Connect();
                        SwitchAV(byteAV);

                    }
                    else         //
                    {
                        Toast.makeText(HX_2544.this, "You choose the wrong button  " + AorV + " please change", Toast.LENGTH_LONG).show();
                    }

                    rgOP.clearCheck();
                    break;
                }
                case R.id.btnME1:
                {

                    SL = true;
                    change.setClass(HX_2544.this, SaveLoad.class);
                    Bundle bundleSL = new Bundle();
                    bundleSL.putBoolean("SL", SL);

                    change.putExtras(bundleSL);
                    startActivity(change);
                    rgME.clearCheck();
                    break;
                }
                case R.id.btnME2:
                {

                    SL = false;
                    change.setClass(HX_2544.this, SaveLoad.class);
                    Bundle bundleSL = new Bundle();
                    bundleSL.putBoolean("SL", SL);

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

                    btnO1.setText(getOUT1+"("+"V"+":"+inputString2544+")");
                    btnO2.setText(getOUT2+"("+"V"+":"+inputString2544+")");
                    btnO3.setText(getOUT3+"("+"V"+":"+inputString2544+")");
                    btnO4.setText(getOUT4+"("+"V"+":"+inputString2544+")");

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

        getIP1 = getSharedPreferences("Config2544", MODE_PRIVATE).getString("IP1","1");
        getIP2 = getSharedPreferences("Config2544", MODE_PRIVATE).getString("IP2","2");
        getIP3 = getSharedPreferences("Config2544", MODE_PRIVATE).getString("IP3","3");
        getIP4 = getSharedPreferences("Config2544", MODE_PRIVATE).getString("IP4","4");

        getOUT1 = getSharedPreferences("Config2544",MODE_PRIVATE).getString("OUT1","1");
        getOUT2 = getSharedPreferences("Config2544",MODE_PRIVATE).getString("OUT2","2");
        getOUT3 = getSharedPreferences("Config2544",MODE_PRIVATE).getString("OUT3","3");
        getOUT4 = getSharedPreferences("Config2544",MODE_PRIVATE).getString("OUT4","4");

        btnIN1.setText(getIP1);

        inputString2544 = btnIN1.getText().toString();

        btnIN2.setText(getIP2);
        btnIN3.setText(getIP3);
        btnIN4.setText(getIP4);

        buttonSetText();
        if (LastInput2544 != 0)
        {
            switch (LastInput2544)
            {
                case 1 :
                {
                    inputString2544 = getIP1;
                    break;
                }
                case 2 :
                {
                    inputString2544 = getIP2;
                    break;
                }
                case 3 :
                {
                    inputString2544 = getIP3;
                    break;
                }
                case 4 :
                {
                    inputString2544 = getIP4;
                    break;
                }
            }
        }

        if (ipFinal2544 != null)
        {
            txtI.setText("       IP: "+ipFinal2544);
        }
    }

    public void runSocket()
    {

        try
        {
            if (m_socket != null)//連線成功才繼續往下執行
            {

                Toast toast = Toast.makeText(HX_2544.this, "連線成功", Toast.LENGTH_SHORT);
                //toast.show();
                System.out.println("連線成功");

                //傳送資料到Server端



                DataOutputStream out = new DataOutputStream(m_socket.getOutputStream());

                //   byte[] bytes = {0x20,0x01,0x06,0x03, (byte) 0x93};  //  00 00
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
            else {

            }
        }
        catch (IOException e)
        {
            Toast toast2 = Toast.makeText(HX_2544.this,e.getMessage(),Toast.LENGTH_SHORT);
            toast2.show();
            System.out.println(e.getMessage());

        }
    }

    public int chaStr(int b)
    {

        //String sum = "";
        feedback = new String[b];
        Bhex = new int[b];
        int BhexInt;

        for (int i=1; i<=b; i++)
        {

            //String c = Integer.toHexString(buff[i-1]);   //將值轉16進制

            String F = Integer.toHexString((buff[i-1] & 0x000000FF) | 0xFFFFFF00).substring(6); // 將編碼以16進制且兩位的方式顯示 並且值為正數不變，值為負數會自動刪除前面的 f (ex:  0x00 會顯示 00)
            //System.out.println("Arr" + i + "的值 : " + F);
            feedback[i-1] = F;
            //sum+=F+" ";

            Bhex[i-1] = Integer.valueOf(F, 16).intValue(); //將16進制轉為10進制儲存

        }

        //System.out.println(sum);
        //Toast server = Toast.makeText(HX_2562.this,"Server 跑出:"+sum,Toast.LENGTH_LONG);
        //server.show();
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

        Mation.setClass(HX_2544.this,Information.class);
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
        cb[0] = CRCTable[CrcI];

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

            cb[c] = CRCTable[xorCRC];

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
            Toast toast2 = Toast.makeText(HX_2544.this,e.getMessage(),Toast.LENGTH_SHORT);
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
            Toast toast2 = Toast.makeText(HX_2544.this,e.getMessage(),Toast.LENGTH_SHORT);
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
            Toast toast2 = Toast.makeText(HX_2544.this,e.getMessage(),Toast.LENGTH_SHORT);
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

            inputString1 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString1","1");
            btnO1.setText(getOUT1+"("+"V"+":"+getIP1+")");

        }
        else if (str1.equals("02"))
        {
            inputString2 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString2","2");
            btnO1.setText(getOUT1+"("+"V"+":"+getIP2+")");
        }
        else if (str1.equals("03"))
        {
            inputString3 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString3","3");
            btnO1.setText(getOUT1+"("+"V"+":"+getIP3+")");
        }
        else if (str1.equals("04"))
        {
            inputString4 = getSharedPreferences("sharedButton",MODE_PRIVATE)
                    .getString("inputString4","4");
            btnO1.setText(getOUT1+"("+"V"+":"+getIP4+")");
        }

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
        //Toast.makeText(HX_2544.this,str1+" "+str2,Toast.LENGTH_SHORT).show();
    }

}