package com.testlslavag76.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txt; /* создаем переменную типа текстового поля */
    int buffer; /* задаем переменную для промежуточного хранения первого числа */
    char op; /* задаем переменную для обозначения операций */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = findViewById(R.id.edit_result); /* делаем ссылку переменной txt на id поля ввода */
        Button answer = findViewById(R.id.equal); /*прописываем переменную для кнопки "равно" */

        answer.setOnClickListener(v -> {  /*прописываем запись в txt-поле по результатам выполнения арифм. операции*/
            switch (op) {

                case '+':
                    buffer +=Integer.parseInt(txt.getText().toString());
                    txt.setText(String.valueOf(buffer)); /*привели для текстового поля int к String и отправили на экран*/
                    break;
                case '-':
                    buffer -=Integer.parseInt(txt.getText().toString());
                    txt.setText(String.valueOf(buffer));
                    break;
                case '*':
                    buffer *=Integer.parseInt(txt.getText().toString());
                    txt.setText(String.valueOf(buffer));
                    break;
                case '/':
                    buffer /=Integer.parseInt(txt.getText().toString());
                    txt.setText(String.valueOf(buffer));
                    break;
            }

        });

        Log.d("My tag", "Мы в методе onCreated");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("My tag", "Мы в методе onPause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("My tag", "Мы в методе onDestroy");
    }

    public void operations(View view) {  /*метод вычленения знака операции и очистки поля*/
        buffer = Integer.parseInt(txt.getText().toString()); /*записываем в буфер значение поля и приводим к int */
        Button b = (Button) view; /* задаем переменную кнопки и приводим типы - вьюшки к типу кнопки*/
        op = b.getText().charAt(0); /*присваиваем переменной "операция" значение операции с тектового поля*/
        txt.setText("");
        Log.d("operation", buffer + "" + op); /*проверка*/
    }

    public void appendText(View view) {  /*метод добавления цифр в текстовое поле*/
        Button b = (Button) view;
        txt.setText(txt.getText().toString() + b.getText().toString());
    }


}

