
package yunos.tech.panaimin.bazi;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.*;
import android.widget.DatePicker.OnDateChangedListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.github.lusing.bazi.base.BaZiEngine;

public class MainActivity extends Activity {
    TextView txtResult;
    Button btnEval;
    DatePicker datePicker;
    TimePicker timePicker;
    //Spinner[] spinners;
    String[] baziInputs;
    
    private int year;
    private int month;
    private int day;
    private int hour; 

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtResult = (TextView) findViewById(R.id.txtResult);
        btnEval = (Button) findViewById(R.id.btnEval);

        baziInputs = new String[4];

        datePicker = (DatePicker)findViewById(R.id.datePicker);
        timePicker = (TimePicker)findViewById(R.id.timePicker);

        Calendar cNow = Calendar.getInstance();
        int yearNow = cNow.get(Calendar.YEAR);
        int monthNow = cNow.get(Calendar.MONTH);
        int dayNow = cNow.get(Calendar.DAY_OF_MONTH);
        
        datePicker.init(yearNow, monthNow, dayNow, new OnDateChangedListener(){

            @Override
            public void onDateChanged(DatePicker obj, int year, int month, int day) {
                MainActivity.this.year = year;
                MainActivity.this.month = month+1;
                MainActivity.this.day = day;
            }
        });
        
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                MainActivity.this.hour = hourOfDay;
            }
        });

        btnEval.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Calendar cal = Calendar.getInstance();
                try {
                        
                        cal.setTime(sdf.parse(year+"-"+month+"-"+day));
                        luozhuanghehun.BaZi lunar = new luozhuanghehun.BaZi(cal);
                        txtResult.setText("");
                        txtResult.setText("公历生日:"+year+"年"+month+"月"+day+"日\n");
                        txtResult.setText(txtResult.getText()+"此人农历的日期【"+lunar.toString()+"】\n");
                        
                        txtResult.setText(txtResult.getText()+"此人八字【"+lunar.getYearGanZhi(MainActivity.this.getHour())+"】\n");
                        //获取生肖
                        txtResult.setText(txtResult.getText()+"此人的农历生肖【"+lunar.animalsYear()+"】\n");
                        
                        final String paraStr = lunar.getYearGanZhi(MainActivity.this.getHour());
                        final int[] baBazi = lunar.bazi.clone();
                        
                        new AsyncTask<String, Integer, String>() {
                            @Override
                            protected void onPreExecute() {

                            }

                            @Override
                            protected String doInBackground(String... paraStrs) {
                            	StringBuffer sb = new StringBuffer();
                                BaZi bz = new BaZi();
                                sb.append(bz.evalBazi(paraStrs[0])+"\n");
                                BaZiEngine bze = new BaZiEngine(baBazi);
                                sb.append(bze.run());
                                return sb.toString();
                            }

                            @Override
                            protected void onPostExecute(String result) {
                                if (result == null) {
                                    txtResult.setText(txtResult.getText()+"测算不成功，另请高明！");
                                } else {
                                    txtResult.setText(txtResult.getText()+"此八字的五行平衡分析结果如下：" + result);
                                }
                            }

                            @Override
                            protected void onProgressUpdate(Integer... value) {

                            }
                        }.execute(paraStr);

                }catch(Exception e){
                    e.printStackTrace();
                }
                
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    private int getHour(){
        return hour/2+1;
    }
}
