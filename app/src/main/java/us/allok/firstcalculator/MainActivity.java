package us.allok.firstcalculator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity implements View.OnClickListener{

    private TextView text_res, text_hist;
    private Button btn_0, btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9, btn_sep, btn_del, btn_umn, btn_plu, btn_min, btn_rav, btn_clr;
    private String resStr = "", befStr = "", number1="", number2="", histStr="";
    private float num1 = 0, num2 = 0, result = 0;
    private int operat = 0, key = 0;
    private char c;
    private Animation anim = null, anim2 = null;
    private final int MENU_RESET_ID = 1;
    private final int MENU_QUIT_ID = 2;
    private final int OPER_PLU = 1;
    private final int OPER_MIN = 2;
    private final int OPER_UMN = 3;
    private final int OPER_DEL = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text_res = (TextView) findViewById(R.id.text_res);
        text_hist = (TextView) findViewById(R.id.text_hist);

        btn_0 = (Button) findViewById(R.id.btn_0);
        btn_1 = (Button) findViewById(R.id.btn_1);
        btn_2 = (Button) findViewById(R.id.btn_2);
        btn_3 = (Button) findViewById(R.id.btn_3);
        btn_4 = (Button) findViewById(R.id.btn_4);
        btn_5 = (Button) findViewById(R.id.btn_5);
        btn_6 = (Button) findViewById(R.id.btn_6);
        btn_7 = (Button) findViewById(R.id.btn_7);
        btn_8 = (Button) findViewById(R.id.btn_8);
        btn_9 = (Button) findViewById(R.id.btn_9);
        btn_sep = (Button) findViewById(R.id.btn_sep);
        btn_del = (Button) findViewById(R.id.btn_del);
        btn_umn = (Button) findViewById(R.id.btn_umn);
        btn_plu = (Button) findViewById(R.id.btn_plu);
        btn_min = (Button) findViewById(R.id.btn_min);
        btn_rav = (Button) findViewById(R.id.btn_rav);
        btn_clr = (Button) findViewById(R.id.btn_clr);

        btn_0.setOnClickListener(this);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);
        btn_sep.setOnClickListener(this);
        btn_del.setOnClickListener(this);
        btn_umn.setOnClickListener(this);
        btn_plu.setOnClickListener(this);
        btn_min.setOnClickListener(this);
        btn_rav.setOnClickListener(this);
        btn_clr.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        menu.add(0, MENU_RESET_ID, 0, getString(R.string.clear));
        menu.add(0, MENU_QUIT_ID, 0, getString(R.string.quit));
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == MENU_RESET_ID) {
            text_hist.setText("");
            return true;
        }

        if(id == MENU_QUIT_ID) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        resStr = "";
        befStr = text_res.getText().toString();
        int kol = befStr.length();

        switch (view.getId()) {
            case R.id.btn_0:
                if( operat==0 ) number1 += "0";
                else number2 += "0";
                resStr="0";
                break;
            case R.id.btn_1:
                if( operat==0 ) number1 += "1";
                else number2 += "1";
                resStr="1";
                break;
            case R.id.btn_2:
                if( operat==0 ) number1 += "2";
                else number2 += "2";
                resStr="2";
                break;
            case R.id.btn_3:
                if( operat==0 ) number1 += "3";
                else number2 += "3";
                resStr="3";
                break;
            case R.id.btn_4:
                if( operat==0 ) number1 += "4";
                else number2 += "4";
                resStr="4";
                break;
            case R.id.btn_5:
                if( operat==0 ) number1 += "5";
                else number2 += "5";
                resStr="5";
                break;
            case R.id.btn_6:
                if( operat==0 ) number1 += "6";
                else number2 += "6";
                resStr="6";
                break;
            case R.id.btn_7:
                if( operat==0 ) number1 += "7";
                else number2 += "7";
                resStr="7";
                break;
            case R.id.btn_8:
                if( operat==0 ) number1 += "8";
                else number2 += "8";
                resStr="8";
                break;
            case R.id.btn_9:
                if( operat==0 ) number1 += "9";
                else number2 += "9";
                resStr="9";
                break;
            case R.id.btn_sep:
                if(!befStr.isEmpty()) {
                    c = befStr.charAt(kol-1);
                    if( c=='.') break;
                }
                int pos_point;

                if( operat==0 ) {
                    if( number1.isEmpty() )  {
                        number1 += "0";
                        resStr += "0";
                    }
                    else {
                        pos_point = number1.indexOf('.');
                        if(pos_point>=0) break;
                    }
                    number1 += ".";
                }
                else {
                    if( number2.isEmpty() ) {
                        number2 += "0";
                        resStr += "0";
                    }
                    else {
                        pos_point = number2.indexOf('.');
                        if(pos_point>=0) break;
                    }
                    number2 += ".";
                }
                resStr += ".";
                break;
            case R.id.btn_del:
                if (number1.isEmpty() || ( !number2.isEmpty() && operat!=0) ) break;
                if( operat !=0 ) {
                    c = befStr.charAt(kol-1);
                    befStr = befStr.replace(c, '÷');
                }
                else {
                    resStr = "÷";
                }
                operat = OPER_DEL;
                break;
            case R.id.btn_umn:
                if (number1.isEmpty() || (!number2.isEmpty() && operat!=0) ) break;
                if( operat !=0 ) {
                    c = befStr.charAt(kol-1);
                    befStr = befStr.replace(c, '×');
                }
                else {
                    resStr = "×";
                }
                operat = OPER_UMN;
                break;
            case R.id.btn_plu:
                if (number1.isEmpty() || (!number2.isEmpty() && operat!=0) ) break;
                if( operat !=0 ) {
                    c = befStr.charAt(kol-1);
                    befStr = befStr.replace(c, '+');
                }
                else {
                    resStr = "+";
                }
                operat = OPER_PLU;
                break;
            case R.id.btn_min:
                if (number1.isEmpty() || (!number2.isEmpty() && operat!=0) ) break;
                if( operat !=0 ) {
                    char c = befStr.charAt(kol-1);
                    befStr = befStr.replace(c, '-');
                }
                else {
                    resStr = "-";
                }
                operat = OPER_MIN;
                break;
            case R.id.btn_rav:
                if(number1.isEmpty() || number2.isEmpty() || operat==0) break;
                anim = AnimationUtils.loadAnimation(this, R.anim.combo);
                anim2 = AnimationUtils.loadAnimation(this, R.anim.alpha_res);

                num1 = Float.parseFloat(number1);
                num2 = Float.parseFloat(number2);

                if(num2==0 && operat==OPER_DEL) {
                    Toast.makeText(this, getString(R.string.dev_by_zero), Toast.LENGTH_LONG).show();
                    clear();
                    break;
                }

                result = operation(num1, num2, operat);
                number1 = Float.toString(result);

                histStr = text_hist.getText().toString();
                text_hist.setText(histStr + befStr + "="+number1+ "\n");
                key = 1;

                resStr=number1;
                befStr="";
                num1 = result;
                num2 = 0;
                number2 = "";
                operat = 0;
                break;
            case R.id.btn_clr:
                clear();
                break;
            default:
                break;
        }

        text_res.setText(befStr + resStr);
        if(key==1) {
            text_hist.startAnimation(anim);
            text_res.startAnimation(anim2);
            key = 0;
        }

    }

    private float operation(float n1, float n2, int toper) {
        float res = 0;
        switch (toper) {
            case OPER_PLU:
                res = n1+n2;
                break;
            case OPER_MIN:
                res = n1-n2;
                break;
            case OPER_UMN:
                res = n1*n2;
                break;
            case OPER_DEL:
                res = n1/n2;
                break;
        }
        return res;
    }

    private void clear(){
        operat = 0;
        num2 = 0;
        num1 = 0;
        number1="";
        number2="";
        befStr="";
        resStr="";
    }

}
