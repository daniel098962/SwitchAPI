package user.example.hs_pc013.switchapi;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class AV_Setting_MX extends ClientCode {

    Intent intentSet;
    byte buffAV[] = new byte[4096];
    String feedbackAV[];
    RadioGroup rgST;
    RadioButton btnST1,btnST2,btnST3,btnST4,btnST5;
    String Type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_av__setting__mx);

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);

        mToolbar.setNavigationIcon(R.drawable.ic_navigate_before_black_24dp);

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (Type) {

                    case "MX-3UB" :
                    {
                        final ProgressDialog dialog = ProgressDialog.show(AV_Setting_MX.this,
                                "Loading", "Please wait for 2 seconds...", true);
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
                        break;
                    }
                    case "MX-4UB" :
                    {
                        final ProgressDialog dialog = ProgressDialog.show(AV_Setting_MX.this,
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
                        break;
                    }
                    case "MX-7UB" : {
                        final ProgressDialog dialog = ProgressDialog.show(AV_Setting_MX.this,
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
                        break;
                    }
                }
                finish();
                overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
            }
        });
        btnST1 = (RadioButton)findViewById(R.id.btnST1);
        btnST2 = (RadioButton)findViewById(R.id.btnST2);
        btnST3 = (RadioButton)findViewById(R.id.btnST3);
        btnST4 = (RadioButton)findViewById(R.id.btnST4);
        btnST5 = (RadioButton)findViewById(R.id.btnST5);
        rgST = (RadioGroup)findViewById(R.id.segmentST);
        rgST.setOnCheckedChangeListener(radLisST);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int vWidth = dm.widthPixels;
        int vHeight = dm.heightPixels;

        rgST.getLayoutParams().width = (int)(vWidth-214.2);
        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        Type = bundle.getString("Type");
    }
    public void onStart()
    {
        super.onStart();
        VideoType();
    }

    public RadioGroup.OnCheckedChangeListener radLisST = new RadioGroup.OnCheckedChangeListener() {
        public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
            switch (checkedId) {
                case R.id.btnST1: {
                    btnST1.setTextColor(Color.parseColor("#ffffff"));
                    btnST2.setTextColor(Color.parseColor("#c90000"));
                    btnST3.setTextColor(Color.parseColor("#c90000"));
                    btnST4.setTextColor(Color.parseColor("#c90000"));
                    btnST5.setTextColor(Color.parseColor("#c90000"));

                    try {
                        DataOutputStream outST = new DataOutputStream(m_socket.getOutputStream());
                        byte[] bytes2 = {0x20, 0x20, 0x00, 0x00, (byte) 0xe4};
                        outST.write(bytes2);
                        outST.flush();
                        DataInputStream inST = new DataInputStream(m_socket.getInputStream());
                        inST.read(buffAV,0,buffAV.length);
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }

                    break;
                }
                case R.id.btnST2: {
                    //rd2.setText("Change");
                    btnST2.setTextColor(Color.parseColor("#ffffff"));
                    btnST1.setTextColor(Color.parseColor("#c90000"));
                    btnST3.setTextColor(Color.parseColor("#c90000"));
                    btnST4.setTextColor(Color.parseColor("#c90000"));
                    btnST5.setTextColor(Color.parseColor("#c90000"));

                    try {
                        DataOutputStream outST = new DataOutputStream(m_socket.getOutputStream());
                        byte[] bytes2 = {0x20, 0x20, 0x00, 0x01, (byte) 0xba};
                        outST.write(bytes2);
                        outST.flush();
                        DataInputStream inST = new DataInputStream(m_socket.getInputStream());
                        inST.read(buffAV,0,buffAV.length);
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }

                    break;
                }
                case R.id.btnST3: {
                    //rd1.setText("Change");
                    btnST3.setTextColor(Color.parseColor("#ffffff"));
                    btnST2.setTextColor(Color.parseColor("#c90000"));
                    btnST1.setTextColor(Color.parseColor("#c90000"));
                    btnST4.setTextColor(Color.parseColor("#c90000"));
                    btnST5.setTextColor(Color.parseColor("#c90000"));

                    try {
                        DataOutputStream outST = new DataOutputStream(m_socket.getOutputStream());
                        byte[] bytes2 = {0x20, 0x20, 0x00, 0x02, (byte) 0x58};
                        outST.write(bytes2);
                        outST.flush();
                        DataInputStream inST = new DataInputStream(m_socket.getInputStream());
                        inST.read(buffAV,0,buffAV.length);
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }

                    break;
                }
                case R.id.btnST4: {
                    //rd1.setText("Change");
                    btnST4.setTextColor(Color.parseColor("#ffffff"));
                    btnST2.setTextColor(Color.parseColor("#c90000"));
                    btnST3.setTextColor(Color.parseColor("#c90000"));
                    btnST1.setTextColor(Color.parseColor("#c90000"));
                    btnST5.setTextColor(Color.parseColor("#c90000"));

                    try {
                        DataOutputStream outST = new DataOutputStream(m_socket.getOutputStream());
                        byte[] bytes2 = {0x20, 0x20, 0x00, 0x03, (byte) 0x06};
                        outST.write(bytes2);
                        outST.flush();
                        DataInputStream inST = new DataInputStream(m_socket.getInputStream());
                        inST.read(buffAV,0,buffAV.length);
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }

                    break;
                }
                case R.id.btnST5: {
                    //rd1.setText("Change");
                    btnST5.setTextColor(Color.parseColor("#ffffff"));
                    btnST2.setTextColor(Color.parseColor("#c90000"));
                    btnST3.setTextColor(Color.parseColor("#c90000"));
                    btnST1.setTextColor(Color.parseColor("#c90000"));
                    btnST4.setTextColor(Color.parseColor("#c90000"));

                    try {
                        DataOutputStream outST = new DataOutputStream(m_socket.getOutputStream());
                        byte[] bytes2 = {0x20, 0x20, 0x00, 0x04, (byte) 0x85};
                        outST.write(bytes2);
                        outST.flush();
                        DataInputStream inST = new DataInputStream(m_socket.getInputStream());
                        inST.read(buffAV,0,buffAV.length);
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }

                    break;
                }
            }
        }
    };

    public void VideoType()
    {
        String EdidType="";
        try {
            DataOutputStream out = new DataOutputStream(m_socket.getOutputStream());
            byte[] edid = new byte[]{0x20,0x21,0x01,0x00,(byte) 0x8b};
            out.write(edid);
            out.flush();
            DataInputStream inputStream = new DataInputStream(m_socket.getInputStream());
            int av = inputStream.read(buffAV,0,buffAV.length);

            chaStrAV(av);
            EdidType = feedbackAV[feedbackAV.length-2];

        }
        catch (IOException e)
        {
            Toast.makeText(AV_Setting_MX.this,e.getMessage(),Toast.LENGTH_SHORT).show();
        }

        if (EdidType.equals("00"))
        {
            btnST1.setChecked(true);
            btnST1.setTextColor(Color.parseColor("#ffffff"));
        }
        else if (EdidType.equals("01"))
        {
            btnST2.setChecked(true);
            btnST2.setTextColor(Color.parseColor("#ffffff"));
        }
        else if (EdidType.equals("02"))
        {
            btnST3.setChecked(true);
            btnST3.setTextColor(Color.parseColor("#ffffff"));
        }
        else if (EdidType.equals("03"))
        {
            btnST4.setChecked(true);
            btnST4.setTextColor(Color.parseColor("#ffffff"));
        }
        else if (EdidType.equals("04"))
        {
            btnST5.setChecked(true);
            btnST5.setTextColor(Color.parseColor("#ffffff"));
        }
        else
        {

        }

    }

    public int chaStrAV(int b)
    {
        feedbackAV = new String[b];

        for (int i=1; i<=b; i++)
        {
            String F = Integer.toHexString((buffAV[i-1] & 0x000000FF) | 0xFFFFFF00).substring(6); // 將編碼以16進制且兩位的方式顯示 並且值為正數不變，值為負數會自動刪除前面的 f (ex:  0x00 會顯示 00)

            feedbackAV[i-1] = F;
        }
        return b;
    }

}
