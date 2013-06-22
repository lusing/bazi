
package yunos.tech.panaimin.bazi;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.*;

public class MainActivity extends Activity {
    TextView txtResult;
    Button btnEval;
    Spinner[] spinners;
    String[] baziInputs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtResult = (TextView) findViewById(R.id.txtResult);
        btnEval = (Button) findViewById(R.id.btnEval);

        spinners = new Spinner[4];
        baziInputs = new String[4];

        spinners[0] = (Spinner) findViewById(R.id.spinner1);
        spinners[1] = (Spinner) findViewById(R.id.spinner2);
        spinners[2] = (Spinner) findViewById(R.id.spinner3);
        spinners[3] = (Spinner) findViewById(R.id.spinner4);

        ArrayAdapter<String> adapBaziList = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, BaZi.getGanZhiList());
        adapBaziList.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        for (Spinner s : spinners) {
            s.setAdapter(adapBaziList);
            s.setOnItemSelectedListener(spnItemSelLis);
        }

        btnEval.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                final String paraStr = spinners[0].getSelectedItem().toString()
                        + spinners[1].getSelectedItem().toString()
                        + spinners[2].getSelectedItem().toString()
                        + spinners[3].getSelectedItem().toString();
                new AsyncTask<String, Integer, String>() {
                    @Override
                    protected void onPreExecute() {

                    }

                    @Override
                    protected String doInBackground(String... paraStrs) {
                        BaZi bz = new BaZi();
                        return bz.evalBazi(paraStrs[0]);
                    }

                    @Override
                    protected void onPostExecute(String result) {
                        if (result == null) {
                            txtResult.setText("测算不成功，另请高明！");
                        } else {
                            txtResult.setText("此八字的五行平衡分析结果如下：" + result);
                        }
                    }

                    @Override
                    protected void onProgressUpdate(Integer... value) {

                    }
                }.execute(paraStr);
            }
        });
    }

    private Spinner.OnItemSelectedListener spnItemSelLis = new Spinner.OnItemSelectedListener() {

        @Override
        public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {

        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {
            // TODO Auto-generated method stub

        }

    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
