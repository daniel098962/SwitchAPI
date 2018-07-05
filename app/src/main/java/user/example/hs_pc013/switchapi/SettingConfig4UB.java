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
import android.widget.Toast;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

import static user.example.hs_pc013.switchapi.ClientCode.ipFinal4UB;
import static user.example.hs_pc013.switchapi.ClientCode.m_socket;
import static user.example.hs_pc013.switchapi.ClientCode.CrcTab;

public class SettingConfig4UB extends AppCompatActivity {

    EditText InputConfig1,InputConfig2,InputConfig3,InputConfig4,InputConfig5,InputConfig6,InputConfig7,InputConfig8,
            InputConfig9,InputConfig10,InputConfig11,InputConfig12,InputConfig13,InputConfig14,InputConfig15,InputConfig16,
            OutputConfig1,OutputConfig2,OutputConfig3,OutputConfig4,OutputConfig5,OutputConfig6,OutputConfig7,OutputConfig8,
            OutputConfig9,OutputConfig10,OutputConfig11,OutputConfig12,OutputConfig13,OutputConfig14,OutputConfig15,OutputConfig16,IpConfig;
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
        setContentView(R.layout.activity_setting_config4_ub);

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);

        mToolbar.setNavigationIcon(R.drawable.ic_navigate_before_black_24dp);

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ProgressDialog dialog = ProgressDialog.show(SettingConfig4UB.this,
                        "Loading", "Please wait for 3 seconds...", true);
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
                        Toast.makeText(SettingConfig4UB.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                    }

                    ipFinal4UB = IpConfig.getText().toString();
                    SharedPreferences sharedIP = getSharedPreferences("SharedIP", MODE_PRIVATE);
                    sharedIP.edit()
                            .putString("shIP",ipFinal4UB)
                            .commit();

                    try{
                        // delay 10 second
                        Thread.sleep(10000);

                    } catch(InterruptedException e){
                        e.printStackTrace();

                    }

                    try {
                        m_socket = new Socket();//建立連線。(ip為伺服器端的ip，port為伺服器端開啟的port)
                        m_socket.connect(new InetSocketAddress(ipFinal4UB, 5000), 5000);
                    }
                    catch (IOException e)
                    {
                        Toast.makeText(SettingConfig4UB.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                    }

                    finish();
                    break;
                }
                case R.id.btnConCancelIP :
                {
                    final ProgressDialog dialog = ProgressDialog.show(SettingConfig4UB.this,
                            "Loading", "Please wait for 3 seconds...", true);
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
                    final ProgressDialog dialog = ProgressDialog.show(SettingConfig4UB.this,
                            "Loading", "Please wait for 3 seconds...", true);
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
                            out1,out2,out3,out4,out5,out6,out7,out8,
                            out9,out10,out11,out12,out13,out14,out15,out16;

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

                    SharedPreferences shared = getSharedPreferences("Config4UB", MODE_PRIVATE);
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
                            .commit();

                    finish();
                    break;
                }
                case R.id.btnConCancelSet :
                {
                    final ProgressDialog dialog = ProgressDialog.show(SettingConfig4UB.this,
                            "Loading", "Please wait for 3 seconds...", true);
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

        Type = bundleConfigSet.getString("Type");

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
}
