package user.example.hs_pc013.switchapi;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

import static user.example.hs_pc013.switchapi.ClientCode.ipFinal7UB;
import static user.example.hs_pc013.switchapi.ClientCode.m_socket;
import static user.example.hs_pc013.switchapi.ClientCode.CrcTab;

public class SettingConfig7UB extends AppCompatActivity {

    EditText InputConfig1,InputConfig2,InputConfig3,InputConfig4,InputConfig5,InputConfig6,InputConfig7,InputConfig8,
            InputConfig9,InputConfig10,InputConfig11,InputConfig12,InputConfig13,InputConfig14,InputConfig15,InputConfig16,
            InputConfig17,InputConfig18,InputConfig19,InputConfig20,InputConfig21,InputConfig22,InputConfig23,InputConfig24,
            InputConfig25,InputConfig26,InputConfig27,InputConfig28,InputConfig29,InputConfig30,InputConfig31,InputConfig32,
            OutputConfig1,OutputConfig2,OutputConfig3,OutputConfig4,OutputConfig5,OutputConfig6,OutputConfig7,OutputConfig8,
            OutputConfig9,OutputConfig10,OutputConfig11,OutputConfig12,OutputConfig13,OutputConfig14,OutputConfig15,OutputConfig16,
            OutputConfig17,OutputConfig18,OutputConfig19,OutputConfig20,OutputConfig21,OutputConfig22,OutputConfig23,OutputConfig24,
            OutputConfig25,OutputConfig26,OutputConfig27,OutputConfig28,OutputConfig29,OutputConfig30,OutputConfig31,OutputConfig32,IpConfig;
    Button btnSaveRe,btnCancelIP,btnModify,btnCancelSet;
    String getipConfig;
    int index1,index2,index3;
    String CrcS,CrcH;
    int CrcI;
    int xorCRC;
    byte[] cb,reboot;
    byte buff2[] = new byte[4096];
    int a2;
    String Type;
    ProgressBar progressBar;

    byte[] hexTable =
            {
                    (byte)0x00,(byte)0x01,(byte)0x02,(byte)0x03,(byte)0x04,(byte)0x05,(byte)0x06,(byte)0x07,(byte)0x08,(byte)0x09,(byte)0x0a,(byte)0x0b,(byte)0x0c,(byte)0x0d,(byte)0x0e,(byte)0x0f,
                    (byte)0x10,(byte)0x11,(byte)0x12,(byte)0x13,(byte)0x14,(byte)0x15,(byte)0x16,(byte)0x17,(byte)0x18,(byte)0x19,(byte)0x1a,(byte)0x1b,(byte)0x1c,(byte)0x1d,(byte)0x1e,(byte)0x1f,
                    (byte)0x20,(byte)0x21,(byte)0x22,(byte)0x23,(byte)0x24,(byte)0x25,(byte)0x26,(byte)0x27,(byte)0x28,(byte)0x29,(byte)0x2a,(byte)0x2b,(byte)0x2c,(byte)0x2d,(byte)0x2e,(byte)0x2f,
                    (byte)0x30,(byte)0x31,(byte)0x32,(byte)0x33,(byte)0x34,(byte)0x35,(byte)0x36,(byte)0x37,(byte)0x38,(byte)0x39,(byte)0x3a,(byte)0x3b,(byte)0x3c,(byte)0x3d,(byte)0x3e,(byte)0x3f,
                    (byte)0x40,(byte)0x41,(byte)0x42,(byte)0x43,(byte)0x44,(byte)0x45,(byte)0x46,(byte)0x47,(byte)0x48,(byte)0x49,(byte)0x4a,(byte)0x4b,(byte)0x4c,(byte)0x4d,(byte)0x4e,(byte)0x4f,
                    (byte)0x50,(byte)0x51,(byte)0x52,(byte)0x53,(byte)0x54,(byte)0x55,(byte)0x56,(byte)0x57,(byte)0x58,(byte)0x59,(byte)0x5a,(byte)0x5b,(byte)0x5c,(byte)0x5d,(byte)0x5e,(byte)0x5f,
                    (byte)0x60,(byte)0x61,(byte)0x62,(byte)0x63,(byte)0x64,(byte)0x65,(byte)0x66,(byte)0x67,(byte)0x68,(byte)0x69,(byte)0x6a,(byte)0x6b,(byte)0x6c,(byte)0x6d,(byte)0x6e,(byte)0x6f,
                    (byte)0x70,(byte)0x71,(byte)0x72,(byte)0x73,(byte)0x74,(byte)0x75,(byte)0x76,(byte)0x77,(byte)0x78,(byte)0x79,(byte)0x7a,(byte)0x7b,(byte)0x7c,(byte)0x7d,(byte)0x7e,(byte)0x7f,
                    (byte)0x80,(byte)0x81,(byte)0x82,(byte)0x83,(byte)0x84,(byte)0x85,(byte)0x86,(byte)0x87,(byte)0x88,(byte)0x89,(byte)0x8a,(byte)0x8b,(byte)0x8c,(byte)0x8d,(byte)0x8e,(byte)0x8f,
                    (byte)0x90,(byte)0x91,(byte)0x92,(byte)0x93,(byte)0x94,(byte)0x95,(byte)0x96,(byte)0x97,(byte)0x98,(byte)0x99,(byte)0x9a,(byte)0x9b,(byte)0x9c,(byte)0x9d,(byte)0x9e,(byte)0x9f,
                    (byte)0xa0,(byte)0xa1,(byte)0xa2,(byte)0xa3,(byte)0xa4,(byte)0xa5,(byte)0xa6,(byte)0xa7,(byte)0xa8,(byte)0xa9,(byte)0xaa,(byte)0xab,(byte)0xac,(byte)0xad,(byte)0xae,(byte)0xaf,
                    (byte)0xb0,(byte)0xb1,(byte)0xb2,(byte)0xb3,(byte)0xb4,(byte)0xb5,(byte)0xb6,(byte)0xb7,(byte)0xb8,(byte)0xb9,(byte)0xba,(byte)0xbb,(byte)0xbc,(byte)0xbd,(byte)0xbe,(byte)0xbf,
                    (byte)0xc0,(byte)0xc1,(byte)0xc2,(byte)0xc3,(byte)0xc4,(byte)0xc5,(byte)0xc6,(byte)0xc7,(byte)0xc8,(byte)0xc9,(byte)0xca,(byte)0xcb,(byte)0xcc,(byte)0xcd,(byte)0xce,(byte)0xcf,
                    (byte)0xd0,(byte)0xd1,(byte)0xd2,(byte)0xd3,(byte)0xd4,(byte)0xd5,(byte)0xd6,(byte)0xd7,(byte)0xd8,(byte)0xd9,(byte)0xda,(byte)0xdb,(byte)0xdc,(byte)0xdd,(byte)0xde,(byte)0xdf,
                    (byte)0xe0,(byte)0xe1,(byte)0xe2,(byte)0xe3,(byte)0xe4,(byte)0xe5,(byte)0xe6,(byte)0xe7,(byte)0xe8,(byte)0xe9,(byte)0xea,(byte)0xeb,(byte)0xec,(byte)0xed,(byte)0xee,(byte)0xef,
                    (byte)0xf0,(byte)0xf1,(byte)0xf2,(byte)0xf3,(byte)0xf4,(byte)0xf5,(byte)0xf6,(byte)0xf7,(byte)0xf8,(byte)0xf9,(byte)0xfa,(byte)0xfb,(byte)0xfc,(byte)0xfd,(byte)0xfe,(byte)0xff,
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_config7_ub);

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);

        mToolbar.setNavigationIcon(R.drawable.ic_navigate_before_black_24dp);

        progressBar = (ProgressBar)findViewById(R.id.progressBar7UB);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog dialog = ProgressDialog.show(SettingConfig7UB.this,
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
                //progressBar.setVisibility(View.INVISIBLE);
                finish();
                overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
            }
        });

        InputConfig1 = (EditText)findViewById(R.id.edtConInput1);
        InputConfig2 = (EditText)findViewById(R.id.edtConInput2);
        InputConfig3 = (EditText)findViewById(R.id.edtConInput3);
        InputConfig4 = (EditText)findViewById(R.id.edtConInput4);
        InputConfig5 = (EditText)findViewById(R.id.edtConInput5);
        InputConfig6 = (EditText)findViewById(R.id.edtConInput6);
        InputConfig7 = (EditText)findViewById(R.id.edtConInput7);
        InputConfig8 = (EditText)findViewById(R.id.edtConInput8);
        InputConfig9 = (EditText)findViewById(R.id.edtConInput9);
        InputConfig10 = (EditText)findViewById(R.id.edtConInput10);
        InputConfig11 = (EditText)findViewById(R.id.edtConInput11);
        InputConfig12 = (EditText)findViewById(R.id.edtConInput12);
        InputConfig13 = (EditText)findViewById(R.id.edtConInput13);
        InputConfig14 = (EditText)findViewById(R.id.edtConInput14);
        InputConfig15 = (EditText)findViewById(R.id.edtConInput15);
        InputConfig16 = (EditText)findViewById(R.id.edtConInput16);
        InputConfig17 = (EditText)findViewById(R.id.edtConInput17);
        InputConfig18 = (EditText)findViewById(R.id.edtConInput18);
        InputConfig19 = (EditText)findViewById(R.id.edtConInput19);
        InputConfig20 = (EditText)findViewById(R.id.edtConInput20);
        InputConfig21 = (EditText)findViewById(R.id.edtConInput21);
        InputConfig22 = (EditText)findViewById(R.id.edtConInput22);
        InputConfig23 = (EditText)findViewById(R.id.edtConInput23);
        InputConfig24 = (EditText)findViewById(R.id.edtConInput24);
        InputConfig25 = (EditText)findViewById(R.id.edtConInput25);
        InputConfig26 = (EditText)findViewById(R.id.edtConInput26);
        InputConfig27 = (EditText)findViewById(R.id.edtConInput27);
        InputConfig28 = (EditText)findViewById(R.id.edtConInput28);
        InputConfig29 = (EditText)findViewById(R.id.edtConInput29);
        InputConfig30 = (EditText)findViewById(R.id.edtConInput30);
        InputConfig31 = (EditText)findViewById(R.id.edtConInput31);
        InputConfig32 = (EditText)findViewById(R.id.edtConInput32);

        OutputConfig1 = (EditText)findViewById(R.id.edtConOutput1);
        OutputConfig2 = (EditText)findViewById(R.id.edtConOutput2);
        OutputConfig3 = (EditText)findViewById(R.id.edtConOutput3);
        OutputConfig4 = (EditText)findViewById(R.id.edtConOutput4);
        OutputConfig5 = (EditText)findViewById(R.id.edtConOutput5);
        OutputConfig6 = (EditText)findViewById(R.id.edtConOutput6);
        OutputConfig7 = (EditText)findViewById(R.id.edtConOutput7);
        OutputConfig8 = (EditText)findViewById(R.id.edtConOutput8);
        OutputConfig9 = (EditText)findViewById(R.id.edtConOutput9);
        OutputConfig10 = (EditText)findViewById(R.id.edtConOutput10);
        OutputConfig11 = (EditText)findViewById(R.id.edtConOutput11);
        OutputConfig12 = (EditText)findViewById(R.id.edtConOutput12);
        OutputConfig13 = (EditText)findViewById(R.id.edtConOutput13);
        OutputConfig14 = (EditText)findViewById(R.id.edtConOutput14);
        OutputConfig15 = (EditText)findViewById(R.id.edtConOutput15);
        OutputConfig16 = (EditText)findViewById(R.id.edtConOutput16);
        OutputConfig17 = (EditText)findViewById(R.id.edtConOutput17);
        OutputConfig18 = (EditText)findViewById(R.id.edtConOutput18);
        OutputConfig19 = (EditText)findViewById(R.id.edtConOutput19);
        OutputConfig20 = (EditText)findViewById(R.id.edtConOutput20);
        OutputConfig21 = (EditText)findViewById(R.id.edtConOutput21);
        OutputConfig22 = (EditText)findViewById(R.id.edtConOutput22);
        OutputConfig23 = (EditText)findViewById(R.id.edtConOutput23);
        OutputConfig24 = (EditText)findViewById(R.id.edtConOutput24);
        OutputConfig25 = (EditText)findViewById(R.id.edtConOutput25);
        OutputConfig26 = (EditText)findViewById(R.id.edtConOutput26);
        OutputConfig27 = (EditText)findViewById(R.id.edtConOutput27);
        OutputConfig28 = (EditText)findViewById(R.id.edtConOutput28);
        OutputConfig29 = (EditText)findViewById(R.id.edtConOutput29);
        OutputConfig30 = (EditText)findViewById(R.id.edtConOutput30);
        OutputConfig31 = (EditText)findViewById(R.id.edtConOutput31);
        OutputConfig32 = (EditText)findViewById(R.id.edtConOutput32);

        IpConfig = (EditText)findViewById(R.id.edtConfigSet1);

        btnSaveRe = (Button)findViewById(R.id.btnConSaveRe);
        btnCancelIP = (Button)findViewById(R.id.btnConCancelIP);
        btnModify = (Button)findViewById(R.id.btnConModify);
        btnCancelSet = (Button)findViewById(R.id.btnConCancelSet);

        btnSaveRe.setOnClickListener(btnConfigSetLis);
        btnCancelIP.setOnClickListener(btnConfigSetLis);
        btnModify.setOnClickListener(btnConfigSetLis);
        btnCancelSet.setOnClickListener(btnConfigSetLis);
        reboot = new byte[]{0x40, 0x04,0x00,0x01,0x20};
        cb = new byte[7];

        String op = "";

    }
    @Override
    public void onStart()
    {
        super.onStart();
        checkText();
    }

    public Button.OnClickListener btnConfigSetLis = new Button.OnClickListener()
    {
        public void onClick(View v)
        {
            switch (v.getId())
            {
                case R.id.btnConSaveRe :
                {

                    getipConfig = IpConfig.getText().toString();
                    index1 = getipConfig.indexOf('.');
                    index2 = getipConfig.indexOf('.',index1+1);
                    index3 = getipConfig.indexOf('.',index2+1);

                    String ipPart1,ipPart2,ipPart3,ipPart4;
                    ipPart1 = getipConfig.substring(0,index1);
                    ipPart2 = getipConfig.substring(index1+1,index2);
                    ipPart3 = getipConfig.substring(index2+1,index3);
                    ipPart4 = getipConfig.substring(index3+1,getipConfig.length());

                    int ipP1,ipP2,ipP3,ipP4;
                    ipP1 = Integer.parseInt(ipPart1);
                    ipP2 = Integer.parseInt(ipPart2);
                    ipP3 = Integer.parseInt(ipPart3);
                    ipP4 = Integer.parseInt(ipPart4);

                    byte[] bytes = new byte[7];
                    bytes[0] = 0x40;
                    bytes[1] = 0x07;
                    bytes[2] = 0x01;
                    bytes[3] = hexTable[ipP1];
                    bytes[4] = hexTable[ipP2];
                    bytes[5] = hexTable[ipP3];
                    bytes[6] = hexTable[ipP4];

                    CrcTraFor(bytes);

                    byte[] bytesConfigIP = new byte[8];
                    bytesConfigIP[0] = 0x40;
                    bytesConfigIP[1] = 0x07;
                    bytesConfigIP[2] = 0x01;
                    bytesConfigIP[3] = hexTable[ipP1];
                    bytesConfigIP[4] = hexTable[ipP2];
                    bytesConfigIP[5] = hexTable[ipP3];
                    bytesConfigIP[6] = hexTable[ipP4];
                    bytesConfigIP[7] = cb[6];

                    try {
                        DataOutputStream outConSaveRe2544 = new DataOutputStream(m_socket.getOutputStream());

                        outConSaveRe2544.write(bytesConfigIP);
                        outConSaveRe2544.flush();

                        DataInputStream in2 = new DataInputStream(m_socket.getInputStream());


                        a2 = in2.read(buff2,0,buff2.length);

                        chaStr(a2);

                        outConSaveRe2544.write(reboot);
                        outConSaveRe2544.flush();

                    }
                    catch (IOException e)
                    {
                        Toast.makeText(SettingConfig7UB.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                    }

                    ipFinal7UB = IpConfig.getText().toString();
                    SharedPreferences sharedIP = getSharedPreferences("SharedIP", MODE_PRIVATE);
                    sharedIP.edit()
                            .putString("shIP",ipFinal7UB)
                            .commit();

                    try{
                        // delay 10 second
                        Thread.sleep(10000);

                    } catch(InterruptedException e){
                        e.printStackTrace();

                    }

                    try {
                        m_socket = new Socket();//建立連線。(ip為伺服器端的ip，port為伺服器端開啟的port)
                        m_socket.connect(new InetSocketAddress(ipFinal7UB, 5000), 5000);
                    }
                    catch (IOException e)
                    {
                        Toast.makeText(SettingConfig7UB.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent();
                        intent.setClass(SettingConfig7UB.this,Main4Activity.class);
                        startActivity(intent);
                    }

                    finish();
                    break;
                }
                case R.id.btnConCancelIP :
                {
                    final ProgressDialog dialog = ProgressDialog.show(SettingConfig7UB.this,
                            "Loading", "Please wait for 6 seconds...", true);
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Thread.sleep(500);
                            } catch (Exception e) {
                                e.printStackTrace();
                            } finally {
                                dialog.dismiss();
                            }
                        }
                    }).start();

                    finish();
                    break;
                }
                case R.id.btnConModify :
                {
                    final ProgressDialog dialog = ProgressDialog.show(SettingConfig7UB.this,
                            "Loading", "Please wait for 6 seconds...", true);
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Thread.sleep(500);
                            } catch (Exception e) {
                                e.printStackTrace();
                            } finally {
                                dialog.dismiss();
                            }
                        }
                    }).start();

                    String ip1,ip2,ip3,ip4,ip5,ip6,ip7,ip8,
                            ip9,ip10,ip11,ip12,ip13,ip14,ip15,ip16,
                            ip17,ip18,ip19,ip20,ip21,ip22,ip23,ip24,
                            ip25,ip26,ip27,ip28,ip29,ip30,ip31,ip32,
                            out1,out2,out3,out4,out5,out6,out7,out8,
                            out9,out10,out11,out12,out13,out14,out15,out16,
                            out17,out18,out19,out20,out21,out22,out23,out24,
                            out25,out26,out27,out28,out29,out30,out31,out32;

                    ip1 = InputConfig1.getText().toString();
                    ip2 = InputConfig2.getText().toString();
                    ip3 = InputConfig3.getText().toString();
                    ip4 = InputConfig4.getText().toString();
                    ip5 = InputConfig5.getText().toString();
                    ip6 = InputConfig6.getText().toString();
                    ip7 = InputConfig7.getText().toString();
                    ip8 = InputConfig8.getText().toString();
                    ip9 = InputConfig9.getText().toString();
                    ip10 = InputConfig10.getText().toString();
                    ip11 = InputConfig11.getText().toString();
                    ip12 = InputConfig12.getText().toString();
                    ip13 = InputConfig13.getText().toString();
                    ip14 = InputConfig14.getText().toString();
                    ip15 = InputConfig15.getText().toString();
                    ip16 = InputConfig16.getText().toString();
                    ip17 = InputConfig17.getText().toString();
                    ip18 = InputConfig18.getText().toString();
                    ip19 = InputConfig19.getText().toString();
                    ip20 = InputConfig20.getText().toString();
                    ip21 = InputConfig21.getText().toString();
                    ip22 = InputConfig22.getText().toString();
                    ip23 = InputConfig23.getText().toString();
                    ip24 = InputConfig24.getText().toString();
                    ip25 = InputConfig25.getText().toString();
                    ip26 = InputConfig26.getText().toString();
                    ip27 = InputConfig27.getText().toString();
                    ip28 = InputConfig28.getText().toString();
                    ip29 = InputConfig29.getText().toString();
                    ip30 = InputConfig30.getText().toString();
                    ip31 = InputConfig31.getText().toString();
                    ip32 = InputConfig32.getText().toString();

                    out1 = OutputConfig1.getText().toString();
                    out2 = OutputConfig2.getText().toString();
                    out3 = OutputConfig3.getText().toString();
                    out4 = OutputConfig4.getText().toString();
                    out5 = OutputConfig5.getText().toString();
                    out6 = OutputConfig6.getText().toString();
                    out7 = OutputConfig7.getText().toString();
                    out8 = OutputConfig8.getText().toString();
                    out9 = OutputConfig9.getText().toString();
                    out10 = OutputConfig10.getText().toString();
                    out11 = OutputConfig11.getText().toString();
                    out12 = OutputConfig12.getText().toString();
                    out13 = OutputConfig13.getText().toString();
                    out14 = OutputConfig14.getText().toString();
                    out15 = OutputConfig15.getText().toString();
                    out16 = OutputConfig16.getText().toString();
                    out17 = OutputConfig17.getText().toString();
                    out18 = OutputConfig18.getText().toString();
                    out19 = OutputConfig19.getText().toString();
                    out20 = OutputConfig20.getText().toString();
                    out21 = OutputConfig21.getText().toString();
                    out22 = OutputConfig22.getText().toString();
                    out23 = OutputConfig23.getText().toString();
                    out24 = OutputConfig24.getText().toString();
                    out25 = OutputConfig25.getText().toString();
                    out26 = OutputConfig26.getText().toString();
                    out27 = OutputConfig27.getText().toString();
                    out28 = OutputConfig28.getText().toString();
                    out29 = OutputConfig29.getText().toString();
                    out30 = OutputConfig30.getText().toString();
                    out31 = OutputConfig31.getText().toString();
                    out32 = OutputConfig32.getText().toString();

                    SharedPreferences shared = getSharedPreferences("Config7UB", MODE_PRIVATE);
                    shared.edit()
                            .putString("IP1",ip1)
                            .putString("IP2",ip2)
                            .putString("IP3",ip3)
                            .putString("IP4",ip4)
                            .putString("IP5",ip5)
                            .putString("IP6",ip6)
                            .putString("IP7",ip7)
                            .putString("IP8",ip8)
                            .putString("IP9",ip9)
                            .putString("IP10",ip10)
                            .putString("IP11",ip11)
                            .putString("IP12",ip12)
                            .putString("IP13",ip13)
                            .putString("IP14",ip14)
                            .putString("IP15",ip15)
                            .putString("IP16",ip16)
                            .putString("IP17",ip17)
                            .putString("IP18",ip18)
                            .putString("IP19",ip19)
                            .putString("IP20",ip20)
                            .putString("IP21",ip21)
                            .putString("IP22",ip22)
                            .putString("IP23",ip23)
                            .putString("IP24",ip24)
                            .putString("IP25",ip25)
                            .putString("IP26",ip26)
                            .putString("IP27",ip27)
                            .putString("IP28",ip28)
                            .putString("IP29",ip29)
                            .putString("IP30",ip30)
                            .putString("IP31",ip31)
                            .putString("IP32",ip32)

                            .putString("OUT1",out1)
                            .putString("OUT2",out2)
                            .putString("OUT3",out3)
                            .putString("OUT4",out4)
                            .putString("OUT5",out5)
                            .putString("OUT6",out6)
                            .putString("OUT7",out7)
                            .putString("OUT8",out8)
                            .putString("OUT9",out9)
                            .putString("OUT10",out10)
                            .putString("OUT11",out11)
                            .putString("OUT12",out12)
                            .putString("OUT13",out13)
                            .putString("OUT14",out14)
                            .putString("OUT15",out15)
                            .putString("OUT16",out16)
                            .putString("OUT17",out17)
                            .putString("OUT18",out18)
                            .putString("OUT19",out19)
                            .putString("OUT20",out20)
                            .putString("OUT21",out21)
                            .putString("OUT22",out22)
                            .putString("OUT23",out23)
                            .putString("OUT24",out24)
                            .putString("OUT25",out25)
                            .putString("OUT26",out26)
                            .putString("OUT27",out27)
                            .putString("OUT28",out28)
                            .putString("OUT29",out29)
                            .putString("OUT30",out30)
                            .putString("OUT31",out31)
                            .putString("OUT32",out32)
                            .commit();

                    finish();
                    break;
                }
                case R.id.btnConCancelSet :
                {
                    final ProgressDialog dialog = ProgressDialog.show(SettingConfig7UB.this,
                            "Loading", "Please wait for 6 seconds...", true);
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Thread.sleep(500);
                            } catch (Exception e) {
                                e.printStackTrace();
                            } finally {
                                dialog.dismiss();
                            }
                        }
                    }).start();

                    checkText();
                    finish();
                    break;
                }
            }
        }
    };

    public void checkText()
    {

        Intent intentConfigSet = this.getIntent();
        Bundle bundleConfigSet = intentConfigSet.getExtras();

        Type = bundleConfigSet.getString("Type");

        String in1 = bundleConfigSet.getString("In1");
        String in2 = bundleConfigSet.getString("In2");
        String in3 = bundleConfigSet.getString("In3");
        String in4 = bundleConfigSet.getString("In4");
        String in5 = bundleConfigSet.getString("In5");
        String in6 = bundleConfigSet.getString("In6");
        String in7 = bundleConfigSet.getString("In7");
        String in8 = bundleConfigSet.getString("In8");
        String in9 = bundleConfigSet.getString("In9");
        String in10 = bundleConfigSet.getString("In10");
        String in11 = bundleConfigSet.getString("In11");
        String in12 = bundleConfigSet.getString("In12");
        String in13 = bundleConfigSet.getString("In13");
        String in14 = bundleConfigSet.getString("In14");
        String in15 = bundleConfigSet.getString("In15");
        String in16 = bundleConfigSet.getString("In16");
        String in17 = bundleConfigSet.getString("In17");
        String in18 = bundleConfigSet.getString("In18");
        String in19 = bundleConfigSet.getString("In19");
        String in20 = bundleConfigSet.getString("In20");
        String in21 = bundleConfigSet.getString("In21");
        String in22 = bundleConfigSet.getString("In22");
        String in23 = bundleConfigSet.getString("In23");
        String in24 = bundleConfigSet.getString("In24");
        String in25 = bundleConfigSet.getString("In25");
        String in26 = bundleConfigSet.getString("In26");
        String in27 = bundleConfigSet.getString("In27");
        String in28 = bundleConfigSet.getString("In28");
        String in29 = bundleConfigSet.getString("In29");
        String in30 = bundleConfigSet.getString("In30");
        String in31 = bundleConfigSet.getString("In31");
        String in32 = bundleConfigSet.getString("In32");

        String out3 = bundleConfigSet.getString("Out3");
        String out4 = bundleConfigSet.getString("Out4");
        String out1 = bundleConfigSet.getString("Out1");
        String out2 = bundleConfigSet.getString("Out2");
        String out5 = bundleConfigSet.getString("Out5");
        String out6 = bundleConfigSet.getString("Out6");
        String out7 = bundleConfigSet.getString("Out7");
        String out8 = bundleConfigSet.getString("Out8");
        String out9 = bundleConfigSet.getString("Out9");
        String out10 = bundleConfigSet.getString("Out10");
        String out11 = bundleConfigSet.getString("Out11");
        String out12 = bundleConfigSet.getString("Out12");
        String out13 = bundleConfigSet.getString("Out13");
        String out14 = bundleConfigSet.getString("Out14");
        String out15 = bundleConfigSet.getString("Out15");
        String out16 = bundleConfigSet.getString("Out16");
        String out17 = bundleConfigSet.getString("Out17");
        String out18 = bundleConfigSet.getString("Out18");
        String out19 = bundleConfigSet.getString("Out19");
        String out20 = bundleConfigSet.getString("Out20");
        String out21 = bundleConfigSet.getString("Out21");
        String out22 = bundleConfigSet.getString("Out22");
        String out23 = bundleConfigSet.getString("Out23");
        String out24 = bundleConfigSet.getString("Out24");
        String out25 = bundleConfigSet.getString("Out25");
        String out26 = bundleConfigSet.getString("Out26");
        String out27 = bundleConfigSet.getString("Out27");
        String out28 = bundleConfigSet.getString("Out28");
        String out29 = bundleConfigSet.getString("Out29");
        String out30 = bundleConfigSet.getString("Out30");
        String out31 = bundleConfigSet.getString("Out31");
        String out32 = bundleConfigSet.getString("Out32");

        InputConfig1.setText(in1);
        InputConfig2.setText(in2);
        InputConfig3.setText(in3);
        InputConfig4.setText(in4);
        InputConfig5.setText(in5);
        InputConfig6.setText(in6);
        InputConfig7.setText(in7);
        InputConfig8.setText(in8);
        InputConfig9.setText(in9);
        InputConfig10.setText(in10);
        InputConfig11.setText(in11);
        InputConfig12.setText(in12);
        InputConfig13.setText(in13);
        InputConfig14.setText(in14);
        InputConfig15.setText(in15);
        InputConfig16.setText(in16);
        InputConfig17.setText(in17);
        InputConfig18.setText(in18);
        InputConfig19.setText(in19);
        InputConfig20.setText(in20);
        InputConfig21.setText(in21);
        InputConfig22.setText(in22);
        InputConfig23.setText(in23);
        InputConfig24.setText(in24);
        InputConfig25.setText(in25);
        InputConfig26.setText(in26);
        InputConfig27.setText(in27);
        InputConfig28.setText(in28);
        InputConfig29.setText(in29);
        InputConfig30.setText(in30);
        InputConfig31.setText(in31);
        InputConfig32.setText(in32);

        OutputConfig1.setText(out1);
        OutputConfig2.setText(out2);
        OutputConfig3.setText(out3);
        OutputConfig4.setText(out4);
        OutputConfig5.setText(out5);
        OutputConfig6.setText(out6);
        OutputConfig7.setText(out7);
        OutputConfig8.setText(out8);
        OutputConfig9.setText(out9);
        OutputConfig10.setText(out10);
        OutputConfig11.setText(out11);
        OutputConfig12.setText(out12);
        OutputConfig13.setText(out13);
        OutputConfig14.setText(out14);
        OutputConfig15.setText(out15);
        OutputConfig16.setText(out16);
        OutputConfig17.setText(out17);
        OutputConfig18.setText(out18);
        OutputConfig19.setText(out19);
        OutputConfig20.setText(out20);
        OutputConfig21.setText(out21);
        OutputConfig22.setText(out22);
        OutputConfig23.setText(out23);
        OutputConfig24.setText(out24);
        OutputConfig25.setText(out25);
        OutputConfig26.setText(out26);
        OutputConfig27.setText(out27);
        OutputConfig28.setText(out28);
        OutputConfig29.setText(out29);
        OutputConfig30.setText(out30);
        OutputConfig31.setText(out31);
        OutputConfig32.setText(out32);

    }

    public void CrcTraFor(byte[] ByteClient)
    {

        //ByteClient = new byte[]{0x20,0x01,OuT,Inp};
        CrcS = Integer.toHexString((ByteClient[0] & 0x000000FF) | 0xFFFFFF00).substring(6);
        CrcH = Integer.valueOf(CrcS,16).toString();
        CrcI = Integer.parseInt(CrcH);
        cb[0] = CrcTab[CrcI];

        for (int c = 1;c<ByteClient.length;c++)
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

    public int chaStr(int b)
    {
        for (int i=1; i<=b; i++)
        {
            String F = Integer.toHexString((buff2[i-1] & 0x000000FF) | 0xFFFFFF00).substring(6); // 將編碼以16進制且兩位的方式顯示 並且值為正數不變，值為負數會自動刪除前面的 f (ex:  0x00 會顯示 00)

            System.out.println(F);
        }
        return b;
    }

    public void pleasewait()
    {
        final ProgressDialog dialog2 = ProgressDialog.show(SettingConfig7UB.this,
                "Loading", "Please wait for 10 seconds...", true);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(9000);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    dialog2.dismiss();
                }
            }
        }).start();
    }
}
