package com.example.android.scientificcalculator;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import org.mariuszgromada.math.mxparser.*;

public class MainActivity extends AppCompatActivity {
    private TextView previousCalculation;
    private EditText display;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        previousCalculation =findViewById(R.id.previousCalculation);
        display =findViewById(R.id.displayEditText);
        display.setShowSoftInputOnFocus(false);
    }
    private void updateText(String strToAdd) {
        String oldStr = display.getText().toString();
        int cursorPos = display.getSelectionStart();

        String leftStr =oldStr.substring(0,cursorPos) ;
        String rightStr = oldStr.substring(cursorPos);
        display.setText(String.format("%s%s%s",leftStr,strToAdd,rightStr));
        display.setSelection(cursorPos + strToAdd.length() );
    }
    public void zeroBTNPush(View view){
        updateText(getResources().getString(R.string.zeroText));
    }
    public void oneBTNPush(View view){
        updateText(getResources().getString(R.string.oneText));
    }
    public void twoBTNPush(View view){
        updateText(getResources().getString(R.string.twoText));
    }
    public void threeBTNPush(View view){
        updateText(getResources().getString(R.string.threeText));
    }
    public void fourBTNPush(View view){
        updateText(getResources().getString(R.string.fourText));
    }
    public void fiveBTNPush(View view){
        updateText(getResources().getString(R.string.fiveText));
    }
    public void sixBTNPush(View view){
        updateText(getResources().getString(R.string.sixText));
    }
    public void sevenBTNPush(View view){
        updateText(getResources().getString(R.string.sevenText));
    }
    public void eightBTNPush(View view){
        updateText(getResources().getString(R.string.eightText));
    }
    public void nineBTNPush(View view){
        updateText(getResources().getString(R.string.nineText));
    }
    public void clearBTNpush(View view){
        display.setText("");
        previousCalculation.setText("");
    }
    public void openParenthesisBTNPush(View view){
        updateText(getResources().getString(R.string.parenthesesOpenText));
    }
    public void closedParenthesisBTNPush(View view){
        updateText(getResources().getString(R.string.parenthesesCloseText));
    }
    public void equalBTNpush(View view){
        String userExp =display.getText().toString();

        previousCalculation.setText(userExp);

        userExp = userExp.replaceAll(getResources().getString(R.string.divideText),"/");
        userExp = userExp.replaceAll(getResources().getString(R.string.multiplyText),"*");


        Expression exp = new Expression(userExp);
        String result = String.valueOf(exp.calculate());

        display.setText(result);
        display.setSelection(result.length());

    }
    public void decimalBTNpush(View view){
        updateText(getResources().getString(R.string.decimalText));
    }
    public void divideBTNpush(View view){
        updateText(getResources().getString(R.string.divideText));
    }
    public void multiplyBTNpush(View view){
        updateText(getResources().getString(R.string.multiplyText));
    }
    public void subtractBTNpush(View view){
        updateText(getResources().getString(R.string.subtractText));
    }
    public void addBTNpush(View view){
        updateText(getResources().getString(R.string.addText));
    }
    public void backspaceBTNpush(View view){
        int cursorPos = display.getSelectionStart();
        int textLen = display.getText().length();

        if(cursorPos != 0 && textLen != 0){
            SpannableStringBuilder  selection=(SpannableStringBuilder) display.getText();
            selection.replace(cursorPos-1,cursorPos,"");
            display.setText(selection);
            display.setSelection(cursorPos-1);
        }

    }
    public void trigSinBTNpush(View view){
        updateText("sin(");
    }
    public void trigCosBTNpush(View view){
       updateText("cos(");
    }
    public void trigTanBTNpush(View view){
        updateText("tan(");
    }
    public void trigArcSinBTNpush(View view){
        updateText("arcsin(");
    }
    public void trigArcCosBTNpush(View view){
        updateText("arccos(");
    }
    public void trigArcTanBTNpush(View view){
        updateText("arctan(");
    }
    public void naturalLogBTNpush(View view){
        updateText("ln(");
    }
    public void LogBTNpush(View view){
        updateText("log(");
    }
    public void squareRootBTNpush(View view){
        updateText("sqrt(");
    }
    public void absoluteValueBTNpush(View view){
        updateText("abs(");
    }
    public void piBTNpush(View view){
        updateText("pi");
    }
    public void eBTNpush(View view){
        updateText("e");
    }
    public void xSquaredBTNpush(View view){
        updateText("^(2)");
    }
    public void xPowerYBTNpush(View view){
        updateText("^(");
    }
    public void isPrimeFunctionBTNpush(View view){
        updateText("ispr(");
    }



}