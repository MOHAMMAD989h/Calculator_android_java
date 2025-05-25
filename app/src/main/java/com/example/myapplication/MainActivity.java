package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import android.text.method.ScrollingMovementMethod;
import com.google.android.material.button.MaterialButton;
import android.app.AlertDialog;
import android.content.DialogInterface;

import org.mariuszgromada.math.mxparser.*;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView resultTv,solutionTv;
    MaterialButton buttonC,buttonBrackOpen,buttonBrackClose,buttonDivide;
    MaterialButton button7,button8,button9,buttonMultiply;
    MaterialButton button4,button5,button6,buttonPlus;
    MaterialButton button1,button2,button3,buttonMinus;
    MaterialButton buttonAC,button0,buttonDot,buttonEquals;


    MaterialButton sinBtn,cosBtn,tanBtn,cotBtn,radBtn,c1Btn;
    MaterialButton arcsinBtn,arccosBtn,arctanBtn,arccotBtn;
    MaterialButton sinhBtn,coshBtn,tanhBtn,cothBtn;
    MaterialButton arcsinhBtn,arccoshBtn,arctanhBtn,arccothBtn;


    MaterialButton eBtn,expBtn,piBtn,c2Btn;
    MaterialButton l__Btn,pow2Btn,powyBtn,radxBtn;
    MaterialButton modBtn,xfactBtn,logBtn,log2Btn;
    MaterialButton lnBtn,minBtn,maxBtn,cBtn;
    MaterialButton pBtn,absBtn,lcmBtn,gcdBtn;

    ImageView imageTopOn,imageKeyboard,headSwitch;

    private LinearLayout layout1;
    private LinearLayout layout2;
    private LinearLayout layout3;

    private Button Btnswich1;
    private Button BtnSwich2;
    private Button BtnSwich3;

    private ImageButton aboutUs;

    private String dataToCalculate = "";
    public static String dataHistory = "";

    ImageButton historyBtn;

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private Switch swichDark;
    String[] buttonList = new String[1000];



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        resultTv = findViewById(R.id.resuly_tv);
        solutionTv = findViewById(R.id.solution_tv);
        resultTv.setMovementMethod(new ScrollingMovementMethod());
        solutionTv.setMovementMethod(new ScrollingMovementMethod());

        layout1 = findViewById(R.id.buttons_layout);
        layout2 = findViewById(R.id.buttons_layout1);
        layout3 = findViewById(R.id.buttons_layout2);

        Btnswich1 = findViewById(R.id.swichBtn1);
        BtnSwich2 = findViewById(R.id.swichBtn2);
        BtnSwich3 = findViewById(R.id.swichBtn3);

        imageTopOn = findViewById(R.id.imageOnTop);
        imageKeyboard = findViewById(R.id.imageKeyboard);
        headSwitch = findViewById(R.id.headswitch);

        aboutUs = findViewById(R.id.aboutus);

        swichDark = findViewById(R.id.swichDark);

        historyBtn = findViewById(R.id.historyBtn);

        Btnswich1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Btnswich1.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#1B6A9C")));
                BtnSwich2.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA726")));
                BtnSwich3.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA726")));
                layout1.setVisibility(View.VISIBLE);
                layout2.setVisibility(View.INVISIBLE);
                layout3.setVisibility(View.INVISIBLE);
            }
        });
        BtnSwich2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Btnswich1.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA726")));
                BtnSwich2.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#1B6A9C")));
                BtnSwich3.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA726")));
                layout1.setVisibility(View.INVISIBLE);
                layout2.setVisibility(View.VISIBLE);
                layout3.setVisibility(View.INVISIBLE);
            }
        });
        BtnSwich3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Btnswich1.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA726")));
                BtnSwich2.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA726")));
                BtnSwich3.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#1B6A9C")));
                layout1.setVisibility(View.INVISIBLE);
                layout2.setVisibility(View.INVISIBLE);
                layout3.setVisibility(View.VISIBLE);
            }
        });

        aboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("درباره ما");
                builder.setMessage("این یک ماشین حساب با عملیات مختلف هست که می تواند نیاز های شما را بر اورده کند  asadpour808@gmail.com با ما در ارتباط باشید\n");

                builder.setPositiveButton("خروج", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
     swichDark.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                resultTv.setTextColor(Color.WHITE);
                solutionTv.setTextColor(Color.WHITE);
                headSwitch.setImageResource(R.drawable.headdark1);
                imageKeyboard.setImageResource(R.drawable.keyboarddark1);
                imageTopOn.setImageResource(R.drawable.dark2);
            } else {
                resultTv.setTextColor(Color.BLACK);
                solutionTv.setTextColor(Color.BLACK);
                headSwitch.setImageResource(R.drawable.head1);
                imageKeyboard.setImageResource(R.drawable.keyboard1);
                imageTopOn.setImageResource(R.drawable.light3);
            }
        });

        historyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,HistoryActivity.class);
                startActivity(intent);
            }
        });


        //layout1
        assignID(buttonC,R.id.button_c);
        assignID(buttonAC,R.id.button_ac);
        assignID(button0,R.id.button_0);
        assignID(button1,R.id.button_1);
        assignID(button2,R.id.button_2);
        assignID(button3,R.id.button_3);
        assignID(button4,R.id.button_4);
        assignID(button5,R.id.button_5);
        assignID(button6,R.id.button_6);
        assignID(button7,R.id.button_7);
        assignID(button8,R.id.button_8);
        assignID(button9,R.id.button_9);
        assignID(buttonBrackClose,R.id.button_close_bracket);
        assignID(buttonBrackOpen,R.id.button_open_bracket);
        assignID(buttonDot,R.id.button_dot);
        assignID(buttonPlus,R.id.button_plus);
        assignID(buttonMinus,R.id.button_minus);
        assignID(buttonMultiply,R.id.button_multiply);
        assignID(buttonDivide,R.id.button_divide);
        assignID(buttonEquals,R.id.button_equals);

        //layout2
        assignID(c1Btn,R.id.button_c1);
        assignID(radBtn,R.id.deg_rad);
        assignID(sinBtn,R.id.sin);
        assignID(cosBtn,R.id.cos);
        assignID(tanBtn,R.id.tan);
        assignID(cotBtn,R.id.cot);
        assignID(arcsinBtn,R.id.arcsin);
        assignID(arccosBtn,R.id.arccos);
        assignID(arctanBtn,R.id.arctan);
        assignID(arccotBtn,R.id.arccot);
        assignID(sinhBtn,R.id.sinh);
        assignID(coshBtn,R.id.cosh);
        assignID(tanhBtn,R.id.tanh);
        assignID(cothBtn,R.id.coth);
        assignID(arcsinhBtn,R.id.arcsinh);
        assignID(arccoshBtn,R.id.arccosh);
        assignID(arctanhBtn,R.id.arctanh);
        assignID(arccothBtn,R.id.arccoth);

        //layout3
        assignID(c2Btn,R.id.button_c2);
        assignID(eBtn,R.id.numberE);
        assignID(expBtn,R.id.exp);
        assignID(piBtn,R.id.pi);
        assignID(l__Btn,R.id.l__);
        assignID(pow2Btn,R.id.power2);
        assignID(powyBtn,R.id.powery);
        assignID(radxBtn,R.id.radicalX);
        assignID(modBtn,R.id.modNumber);
        assignID(xfactBtn,R.id.factNumber);
        assignID(logBtn,R.id.log10);
        assignID(log2Btn,R.id.log2);
        assignID(lnBtn,R.id.ln);
        assignID(minBtn,R.id.min);
        assignID(maxBtn,R.id.max);
        assignID(cBtn,R.id.combination);
        assignID(pBtn,R.id.p__);
        assignID(absBtn,R.id.abs);
        assignID(lcmBtn,R.id.lcm);
        assignID(gcdBtn,R.id.gcd);


    }

    private void assignID(MaterialButton btn,int id){
        btn = findViewById(id);
        btn.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        MaterialButton button = (MaterialButton) v;
        String buttonText = button.getText().toString();


        int i = 0;
        int j = 0;
        if (!buttonText.equals("C")) {
            buttonList[i] = buttonText;
            i++;
            j = i - 1;
        }

        if(buttonText.equals("AC")){
            solutionTv.setText("");
            resultTv.setText("0");
            dataToCalculate = "";
            buttonText = "";
            i = 0;
            j = 0;
            return;
        }
        if(buttonText.equals("C")){
            if (!dataToCalculate.isEmpty()) {
                dataToCalculate = dataToCalculate.substring(0, dataToCalculate.length() - buttonList[j].length());
                if (j > 0){j--;}
           }
            buttonText = "";
        }
        if(buttonText.equals("=")){
            try {

                Expression e = new Expression(solutionTv.getText().toString());
                if (Double.isNaN(e.calculate())) {
                    resultTv.setText("Error");
                } else {
                    resultTv.setText(String.valueOf(e.calculate()));
                    solutionTv.setText(resultTv.getText());
                    dataHistory = dataHistory + "\n"+ dataToCalculate;
                    SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("myKey", dataHistory);
                    editor.apply();

                }
                dataToCalculate = resultTv.getText().toString();
                buttonText = "";
                return;
            }
            catch (Exception ex){
                ex.printStackTrace();
            }
        }
        dataToCalculate = dataToCalculate + buttonText;
        solutionTv.setText(dataToCalculate);
    }
}