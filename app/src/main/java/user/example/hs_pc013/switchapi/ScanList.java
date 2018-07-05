package user.example.hs_pc013.switchapi;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class ScanList extends ClientCode {

    private ListView listViewIp;

    ArrayList<String> ipList;
    ArrayAdapter<String> adapter;
    String ipScan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_list);

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);

        mToolbar.setNavigationIcon(R.drawable.ic_navigate_before_black_24dp);

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
                overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
            }
        });

        //btnScan = (Button)findViewById(R.id.scan);
        listViewIp = (ListView)findViewById(R.id.listviewip);


        ipList = new ArrayList();
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, ipList);
        listViewIp.setAdapter(adapter);
        listViewIp.setOnItemClickListener(listLis);


/*        btnScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ScanIpTask().execute();
            }
        });
*/
    }

    public void onStart()
    {
        super.onStart();
        new ScanIpTask().execute();
    }


    private class ScanIpTask extends AsyncTask<Void, String, Void> {

        /*
        Scan IP 192.168.1.100~192.168.1.110
        you should try different timeout for your network/devices
         */
        static final String subnet = "192.168.0.";
        static final int lower = 0;
        static final int upper = 255;
        static final int timeout = 1000;
        //String value[] = new String[255];

        @Override
        protected void onPreExecute() {
            ipList.clear();
            adapter.notifyDataSetInvalidated();
            Toast.makeText(ScanList.this, "Scan IP...", Toast.LENGTH_SHORT).show();
        }

        @Override
        protected Void doInBackground(Void... params) {

            for (int i = lower; i <= upper; i++) {
                String host = subnet + i;

                try {
                    InetAddress inetAddress = InetAddress.getByName(host);
                    if (inetAddress.isReachable(timeout)){
                        publishProgress(inetAddress.toString().substring(1));  //未加substring前IP會跑出"/"  加substring以只顯示IP
                    }

                } catch (UnknownHostException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            return null;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            ipList.add(values[0]);
            adapter.notifyDataSetInvalidated();
            Toast.makeText(ScanList.this, values[0], Toast.LENGTH_LONG).show();
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            Toast.makeText(ScanList.this, "Done", Toast.LENGTH_LONG).show();
        }
    }

    private ListView.OnItemClickListener listLis = new ListView.OnItemClickListener()
    {
        public void onItemClick(AdapterView<?> parent, View view, int position, long id)
        {

            String result = String.valueOf(ipList.get(position));
            ipScan = result.substring(0);
            //portScan = Integer.parseInt(edtPortScan.getText().toString());
            //Toast.makeText(ScanList.this,"選到 "+ipScan,Toast.LENGTH_SHORT).show();
            Connect(ipScan,5000);
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
                Toast toast0 = Toast.makeText(ScanList.this, e.getMessage(), Toast.LENGTH_SHORT);
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
                Toast toast0 = Toast.makeText(ScanList.this, e.getMessage(), Toast.LENGTH_SHORT);
                toast0.show();
                System.out.println(e.getMessage());

            }
        }
    }

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
            Toast toast2 = Toast.makeText(ScanList.this,e.getMessage(),Toast.LENGTH_SHORT);
            toast2.show();
            System.out.println(e.getMessage());

        }
    }

    public void Change()
    {

        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("IP",ipScan);
        bundle.putInt("PORT",5000);
        bundle.putString("DeviceName",devicename);
        intent.putExtras(bundle);

        switch (devicename)
        {
            case "HX-2562":
            {
                intent.setClass(ScanList.this,HX_2562.class);
                startActivity(intent);
                break;
            }
            case "HX-2544":
            {
                intent.setClass(ScanList.this,HX_2544.class);
                startActivity(intent);
                break;
            }
            case "MX-3UB":
            {
                intent.setClass(ScanList.this,MX_3UB.class);
                startActivity(intent);
                break;
            }
            case "MX-4UB":
            {
                intent.setClass(ScanList.this,MX_4UB.class);
                startActivity(intent);
                break;
            }
            case "MX-7UB":
            {
                intent.setClass(ScanList.this,MX_7UB.class);
                startActivity(intent);
                break;
            }
            case "": {
                Toast.makeText(ScanList.this, "Connect is unstable or don't support this devices.", Toast.LENGTH_SHORT).show();
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