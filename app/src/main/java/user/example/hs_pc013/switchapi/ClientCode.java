package user.example.hs_pc013.switchapi;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.StrictMode;
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

public class ClientCode extends AppCompatActivity {

    public static Socket m_socket;//和伺服器端進行連線
    public static String Input1,Input2,Input3,Input4,Input5,Input6,Output1,Output2,Output3,Output4;
    public static String Input7,Input8,Output5,Output6,Output7,Output8;
    public static String Input9,Input10,Input11,Input12,Input13,Input14,Input15,Input16,Output9,Output10,Output11,Output12,Output13,Output14,Output15,Output16;
    public static String Input17,Input18,Input19,Input20,Input21,Input22,Input23,Input24,Input25,Input26,Input27,Input28,Input29,Input30,Input31,Input32,
            Output17,Output18,Output19,Output20,Output21,Output22,Output23,Output24,Output25,Output26,Output27,Output28,Output29,Output30,Output31,Output32;
    public static byte[] CrcTab =
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
    public static String ipFinal,ipFinal2544,ipFinal3UB,ipFinal4UB,ipFinal7UB,outputFinal1,outputFinal2,outputFinal2544_1,outputFinal2544_2,outputFinal2544_3,outputFinal2544_4,inputFinal1,inputFinal2,inputFinal2544_1,inputFinal2544_2,inputFinal2544_3,inputFinal2544_4;
    public static int outLength1,outLength2,inLength1,inLength2;
    public static int LastInput=0,LastInput2544=0,LastInput3UB=0,LastInput4UB=0,LastInput7UB=0;
    public static SharedPreferences sharedFinal;
    public static Boolean page;
    public String ipForConnect;
    public int portForConnect;

    String IP;
    int PORT;
    byte buff[] = new byte[4096];
    String str = "";
    int a;
    String[] feedback;
    int Bhex[];
    int LB,DN;
    String devicename;
    EditText edt1,edt2;
    ProgressBar mDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_code);

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);

        mToolbar.setNavigationIcon(R.drawable.ic_navigate_before_black_24dp);

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
                overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
            }
        });

        Button btnTRY,btnDis,btnList;
        btnTRY = (Button)findViewById(R.id.btnTry);
        btnTRY.setOnClickListener(btnTry);

        btnDis = (Button)findViewById(R.id.btnDis);
        btnDis.setOnClickListener(btnTry);
        btnList = (Button)findViewById(R.id.btnList);
        btnList.setOnClickListener(btnTry);
        sharedFinal = getSharedPreferences("sharedButton",MODE_PRIVATE);


        edt1 = (EditText)findViewById(R.id.edtIP);
        edt2 = (EditText)findViewById(R.id.edtPORT);
        edt1.setText("192.168.0.3");
        edt2.setText("5000");

       mDialog = (ProgressBar)findViewById(R.id.connectProgressBar);

    }

    @Override
    public void onStart()
    {
        super.onStart();
        String LoadIP = getSharedPreferences("SharedIP",MODE_PRIVATE)
                .getString("shIP","");
        if (!LoadIP.equals(""))
        {
            edt1.setText(LoadIP);
        }

        page = true;

    }

    public Button.OnClickListener btnTry = new Button.OnClickListener()
    {
        public void onClick(View v)
        {
            switch (v.getId()) {
                case R.id.btnTry :
                {
                    EditText edtip, edtport;
                    edtip = (EditText) findViewById(R.id.edtIP);
                    edtport = (EditText) findViewById(R.id.edtPORT);

                    if (edtip.getText().toString().matches("") || edtport.getText().toString().matches("")) {

                        Toast toast4 = Toast.makeText(ClientCode.this, "IP and Port can't be empty", Toast.LENGTH_LONG);
                        toast4.show();

                    } else {
                        IP = edtip.getText().toString();

                        PORT = Integer.parseInt(edtport.getText().toString());

                        Connect(IP, PORT);
                    }

                    break;
                }

                case R.id.btnDis :
                {
                    if (m_socket != null)
                    {
                        try {
                            m_socket.close();
                        }
                        catch (IOException e)
                        {
                            Toast.makeText(ClientCode.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                            System.out.println(e.getMessage());
                        }
                    }
                    Intent intent = new Intent();
                    intent.setClass(ClientCode.this,Main4Activity.class);
                    startActivity(intent);
                    break;
                }

                case R.id.btnList :
                {
                    WifiManager mWifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                    if (!mWifiManager.isWifiEnabled()) {
                        mWifiManager.setWifiEnabled(true);
                    }
                    WifiInfo mWifiInfo = mWifiManager.getConnectionInfo();
                    if (mWifiInfo != null)
                    {
                        Intent intentList = new Intent();
                        intentList.setClass(ClientCode.this,ScanList.class);
                        startActivity(intentList);
                        break;
                    }
                    break;
                }

            }
        }
    };



    public void Connect(String ip,int port)
    {
        if (m_socket != null)
        {
            try {
                m_socket.close();
                m_socket = new Socket();//建立連線。(ip為伺服器端的ip，port為伺服器端開啟的port)
                m_socket.connect(new InetSocketAddress(ip, port), 5000);
                //run();
                DeviceType();
                //m_socket.close();  // 2/12改的 若要直接跳頁要記得關
                Change();
            }
            catch (IOException e)
            {
                Toast toast0 = Toast.makeText(ClientCode.this, e.getMessage(), Toast.LENGTH_SHORT);
                toast0.show();
                System.out.println(e.getMessage());
            }
        }
        else {
            try {
                m_socket = new Socket();//建立連線。(ip為伺服器端的ip，port為伺服器端開啟的port)
                m_socket.connect(new InetSocketAddress(ip, port), 5000);
                //run();
                DeviceType();
                //m_socket.close();  // 2/12改的 若要直接跳頁要記得關
                Change();

            } catch (IOException e) {
                Toast toast0 = Toast.makeText(ClientCode.this, e.getMessage(), Toast.LENGTH_SHORT);
                toast0.show();
                System.out.println(e.getMessage());

            }
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /*
    public void run()
    {

        try
        {
            if (m_socket != null)//連線成功才繼續往下執行
            {

                Toast toast = Toast.makeText(ClientCode.this,"連線成功",Toast.LENGTH_SHORT);
                toast.show();
                System.out.println("連線成功");

                //傳送資料到Server端


                DataOutputStream out = new DataOutputStream(m_socket.getOutputStream());

                //   byte[] bytes = {0x20,0x01,0x06,0x03, (byte) 0x93};  //  00 00
                byte[] bytes2 = {0x20,0x3F,0x00,0x00,(byte) 0xF1};  //  給server 回傳機型相關資訊  80 0A 64 02 06 48 58 2D 32 35 36 32 47


                out.write(bytes2);

                out.flush();

                //接收Server端資料

                DataInputStream in = new DataInputStream(m_socket.getInputStream());


                a = in.read(buff,0,buff.length);
                //feedback = new String[a];
                chaStr(a);


               // DataSendGet();

                m_socket.close();



                Change();

            }
        }
        catch (IOException e)
        {
            Toast toast2 = Toast.makeText(ClientCode.this,e.getMessage(),Toast.LENGTH_SHORT);
            toast2.show();
            System.out.println(e.getMessage());

        }


    }
    */
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void DeviceType()
    {
        try
        {

            DataOutputStream out = new DataOutputStream(m_socket.getOutputStream());

            //   byte[] bytes = {0x20,0x01,0x06,0x03, (byte) 0x93};  //  00 00
            byte[] bytes2 = {0x20,0x3F,0x00,0x00,(byte) 0xF1};  //  給server 回傳機型相關資訊  80 0A 64 02 06 48 58 2D 32 35 36 32 47(HX-2562)


            out.write(bytes2);

            out.flush();

            //接收Server端資料

            DataInputStream in = new DataInputStream(m_socket.getInputStream());


            a = in.read(buff,0,buff.length);

            chaStr(a);

            //s.close();  暫時關掉

        }
        catch (IOException e)
        {
            Toast toast2 = Toast.makeText(ClientCode.this,e.getMessage(),Toast.LENGTH_SHORT);
            toast2.show();
            System.out.println(e.getMessage());

        }
    }

    public void Change()
    {

        //mDialog.setVisibility(View.INVISIBLE);
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("IP",IP);
        bundle.putInt("PORT",PORT);
        bundle.putString("DeviceName",devicename);
        intent.putExtras(bundle);

        switch (devicename)
        {
            case "HX-2562":
            {
                final ProgressDialog dialog = ProgressDialog.show(ClientCode.this,
                        "Loading", "Please wait...");
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(50);
                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            dialog.dismiss();
                        }
                    }
                }).start();
                intent.setClass(ClientCode.this,HX_2562.class);
                startActivity(intent);
                break;
            }
            case "HX-2544":
            {
                final ProgressDialog dialog = ProgressDialog.show(ClientCode.this,
                        "Loading", "Please wait...");
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(50);
                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            dialog.dismiss();
                        }
                    }
                }).start();
                intent.setClass(ClientCode.this,HX_2544.class);
                startActivity(intent);
                break;
            }
            case "MX-3UB":
            {
                final ProgressDialog dialog = ProgressDialog.show(ClientCode.this,
                        "Loading", "Please wait...");
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(50);
                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            dialog.dismiss();
                        }
                    }
                }).start();
                intent.setClass(ClientCode.this,MX_3UB.class);
                startActivity(intent);
                break;
            }
            case "MX-4UB":
            {
                final ProgressDialog dialog = ProgressDialog.show(ClientCode.this,
                        "Loading", "Please wait...");
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(50);
                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            dialog.dismiss();
                        }
                    }
                }).start();
                intent.setClass(ClientCode.this,MX_4UB.class);
                startActivity(intent);
                break;
            }
            case "MX-7UB":
            {
                final ProgressDialog dialog = ProgressDialog.show(ClientCode.this,
                        "Loading", "Please wait...");
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(50);
                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            dialog.dismiss();
                        }
                    }
                }).start();
                intent.setClass(ClientCode.this,MX_7UB.class);
                startActivity(intent);
                break;
            }
            default: {
                Toast.makeText(ClientCode.this, "Connect is unstable or don't support this devices.", Toast.LENGTH_SHORT).show();
                break;
            }
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
        Check();
        return b;
    }

    public void Check()
    {
        int i=1;
        if (feedback[i-1].equals("80"))
        {

            LB = Bhex[1];
            DN = LB-3;
            String Devicename = "";

            for (int g=5;g<(5+DN);g++)
            {
                char Asc2Char= (char) Bhex[g];
                Devicename+=Asc2Char;
            }
            devicename = Devicename;
        }

        else
        {
            System.out.println("Command不成立");
        }

    }

}
