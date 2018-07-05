package user.example.hs_pc013.switchapi;

import android.content.Intent;
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

public class SaveLoad extends ClientCode {

    private ListView lstPrefer;
    String[] Memory;

    Boolean sl;
    Intent intentSL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_load);

        Memory= new String[] {"   Memory 1","   Memory 2","   Memory 3","   Memory 4"};

/*
        txv2.setText("Audio:"+boolA);
        txv3.setText("Video:"+boolV);
        txv4.setText("Page1:"+boolP);
        txv5.setText("Memory:"+Memory+"個");
*/
        lstPrefer=(ListView) findViewById(R.id.lstPrefer);

        // 建立 ArrayAdapter
        ArrayAdapter<String> adapterBalls=new ArrayAdapter<String>(
                this,android.R.layout.simple_list_item_1,Memory);

        // 設定 ListView 的資料來源
        lstPrefer.setAdapter(adapterBalls);

        lstPrefer.setOnItemClickListener(lstPreferListener);

        intentSL = this.getIntent();
        Bundle bundlesl = intentSL.getExtras();
        Boolean SL2 = bundlesl.getBoolean("SL");
        sl = SL2;

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setNavigationIcon(R.drawable.ic_navigate_before_black_24dp);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
                overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);

            }
        });

    }

    private ListView.OnItemClickListener lstPreferListener = new ListView.OnItemClickListener()
    {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id)
        {

            //connect();

            if (sl == true) {
                switch (position) {
                    case 0: {
                        try {
                            DataOutputStream outSL = new DataOutputStream(m_socket.getOutputStream());
                            byte[] bytes2 = {0x20, 0x03, 0x00, 0x01, (byte) 0xca};
                            outSL.write(bytes2);
                            outSL.flush();
                            DataInputStream inSL = new DataInputStream(m_socket.getInputStream());
                            inSL.read(buff,0,buff.length);

                            //s.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                            Toast toast2 = Toast.makeText(SaveLoad.this,e.getMessage(),Toast.LENGTH_SHORT);
                            toast2.show();
                            System.out.println(e.getMessage());
                        }

                        //finish();
                        break;
                    }
                    case 1: {
                        try {
                            DataOutputStream outSL = new DataOutputStream(m_socket.getOutputStream());
                            byte[] bytes2 = {0x20, 0x03, 0x00, 0x02, (byte) 0x28};
                            outSL.write(bytes2);
                            outSL.flush();
                            DataInputStream inSL = new DataInputStream(m_socket.getInputStream());
                            inSL.read(buff,0,buff.length);
                            //s.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                            Toast toast2 = Toast.makeText(SaveLoad.this,e.getMessage(),Toast.LENGTH_SHORT);
                            toast2.show();
                            System.out.println(e.getMessage());
                        }
                        //finish();
                        break;
                    }
                    case 2: {
                        try {
                            DataOutputStream outSL = new DataOutputStream(m_socket.getOutputStream());
                            byte[] bytes2 = {0x20, 0x03, 0x00, 0x03, (byte) 0x76};
                            outSL.write(bytes2);
                            outSL.flush();
                            DataInputStream inSL = new DataInputStream(m_socket.getInputStream());
                            inSL.read(buff,0,buff.length);
                            //s.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                            Toast toast2 = Toast.makeText(SaveLoad.this,e.getMessage(),Toast.LENGTH_SHORT);
                            toast2.show();
                            System.out.println(e.getMessage());
                        }
                        //finish();
                        break;
                    }
                    case 3: {
                        try {
                            DataOutputStream outSL = new DataOutputStream(m_socket.getOutputStream());
                            byte[] bytes2 = {0x20, 0x03, 0x00, 0x04, (byte) 0xf5};
                            outSL.write(bytes2);
                            outSL.flush();
                            DataInputStream inSL = new DataInputStream(m_socket.getInputStream());
                            inSL.read(buff,0,buff.length);
                            //s.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                            Toast toast2 = Toast.makeText(SaveLoad.this,e.getMessage(),Toast.LENGTH_SHORT);
                            toast2.show();
                            System.out.println(e.getMessage());
                        }
                        //finish();
                        break;
                    }
                }

                finish();
            }
            else if (sl == false)
            {
                switch (position) {
                    case 0: {
                        try {
                            DataOutputStream outSL = new DataOutputStream(m_socket.getOutputStream());
                            byte[] bytes2 = {0x20, 0x05, 0x00, 0x01, (byte) 0x1b};
                            outSL.write(bytes2);
                            outSL.flush();
                            DataInputStream inSL = new DataInputStream(m_socket.getInputStream());
                            inSL.read(buff,0,buff.length);
                            //s.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                            Toast toast2 = Toast.makeText(SaveLoad.this,e.getMessage(),Toast.LENGTH_SHORT);
                            toast2.show();
                            System.out.println(e.getMessage());
                        }
                        //finish();
                        break;
                    }
                    case 1: {
                        try {
                            DataOutputStream outSL = new DataOutputStream(m_socket.getOutputStream());
                            byte[] bytes2 = {0x20, 0x05, 0x00, 0x02, (byte) 0xf9};
                            outSL.write(bytes2);
                            outSL.flush();
                            DataInputStream inSL = new DataInputStream(m_socket.getInputStream());
                            inSL.read(buff,0,buff.length);
                            //s.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                            Toast toast2 = Toast.makeText(SaveLoad.this,e.getMessage(),Toast.LENGTH_SHORT);
                            toast2.show();
                            System.out.println(e.getMessage());
                        }
                        //finish();
                        break;
                    }
                    case 2: {
                        try {
                            DataOutputStream outSL = new DataOutputStream(m_socket.getOutputStream());
                            byte[] bytes2 = {0x20, 0x05, 0x00, 0x03, (byte) 0xa7};
                            outSL.write(bytes2);
                            outSL.flush();
                            DataInputStream inSL = new DataInputStream(m_socket.getInputStream());
                            inSL.read(buff,0,buff.length);
                            //s.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                            Toast toast2 = Toast.makeText(SaveLoad.this,e.getMessage(),Toast.LENGTH_SHORT);
                            toast2.show();
                            System.out.println(e.getMessage());
                        }
                        //finish();
                        break;
                    }
                    case 3: {
                        try {
                            DataOutputStream outSL = new DataOutputStream(m_socket.getOutputStream());
                            byte[] bytes2 = {0x20, 0x05, 0x00, 0x04, (byte) 0x24};
                            outSL.write(bytes2);
                            outSL.flush();
                            DataInputStream inSL = new DataInputStream(m_socket.getInputStream());
                            inSL.read(buff,0,buff.length);
                            //s.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                            Toast toast2 = Toast.makeText(SaveLoad.this,e.getMessage(),Toast.LENGTH_SHORT);
                            toast2.show();
                            System.out.println(e.getMessage());
                        }
                        //finish();
                        break;
                    }
                }
                finish();
            }
        }

    };

}
