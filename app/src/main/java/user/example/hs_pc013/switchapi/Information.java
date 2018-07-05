package user.example.hs_pc013.switchapi;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Information extends AppCompatActivity {

    TextView txv2,txv3,txv4,txv5;
    private ListView lstPrefer;
    String[] Balls;
    String[] Result;
    String Type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);

        mToolbar.setNavigationIcon(R.drawable.ic_navigate_before_black_24dp);

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (Type) {
                    case "HX-2562" :
                    {
                        break;
                    }
                    case "HX-2544" :
                    {
                        break;
                    }
                    case "MX-3UB" :
                    {
                        final ProgressDialog dialog = ProgressDialog.show(Information.this,
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
                        final ProgressDialog dialog = ProgressDialog.show(Information.this,
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
                        final ProgressDialog dialog = ProgressDialog.show(Information.this,
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

        Intent intentInf = this.getIntent();
        Bundle bundleInfor = intentInf.getExtras();
        boolean Audio = bundleInfor.getBoolean("Audio");
        boolean Video = bundleInfor.getBoolean("Video");
        boolean Page1 = bundleInfor.getBoolean("Page1");
        boolean EDID = bundleInfor.getBoolean("EDID");
        Type = bundleInfor.getString("Type");
        String Protocol = bundleInfor.getString("Protocol");
        String Firmware = bundleInfor.getString("Firmware");
        int Memory = bundleInfor.getInt("Memory");
        int Out = bundleInfor.getInt("Output");
        int Put = bundleInfor.getInt("Input");

        String boolA,boolV,boolP,boolEDID;

        boolA = (Audio==true)?"Support":"Not Support";
        boolV = (Video==true)?"Support":"Not Support";
        boolP = (Page1==true)?"Support":"Not Support";
        boolEDID = (EDID==true)?"Support":"Not Support";

        Balls= new String[] {"Name","ID","Audio","Video","EDID Type","Total Memory","Total Output","Total Input","Protocol Ver.","Firmware Ver."};
        Result = new String[]{Type,"0",boolA,boolV,boolEDID,String.valueOf(Memory), String.valueOf(Out),String.valueOf(Put),Protocol,Firmware};

        lstPrefer=(ListView) findViewById(R.id.lstPrefer);

        MyAdapter adapter = new MyAdapter(this);
        lstPrefer.setAdapter(adapter);


    }

    public class MyAdapter extends BaseAdapter
    {
        private LayoutInflater myInflater;
        public MyAdapter(Context c)
        {
            myInflater = LayoutInflater.from(c);
        }
        @Override
        public int getCount()
        {
            return Balls.length;
        }
        @Override
        public Object getItem(int position)
        {
            return Balls[position];
        }
        @Override
        public long getItemId(int position)
        {
            return position;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            convertView = myInflater.inflate(R.layout.customlist,null);

            TextView txt1 = (TextView)convertView.findViewById(R.id.item);
            TextView txt2 = (TextView)convertView.findViewById(R.id.result);

            txt1.setText(Balls[position]);
            txt2.setText(Result[position]);

            return convertView;
        }
    }

}
