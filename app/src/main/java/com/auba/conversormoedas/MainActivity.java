package com.auba.conversormoedas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{ //implementa a inteface View.OnclickListener,
                                                                                     // mas para isso tem que implementar o metodo
                                                                                     //onClick.

    private ViewHolder mViewHolder = new ViewHolder(); //Abre uma instância da função ViewHolder chamada de mViewHolder

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.editValue = findViewById(R.id.edit_valor);//a função MainActivity acessa a função mViewHolder
                                                                   // com o método do objeto editValue que é do tipo EditText
                                                                   // e acessa a caixa de texto atraves do id dela.
        this.mViewHolder.textDolar = findViewById(R.id.text_dolar);
        this.mViewHolder.textBit = findViewById(R.id.text_bit);
        this.mViewHolder.textXrp = findViewById(R.id.text_xrp);
        this.mViewHolder.buttonConvert = findViewById(R.id.button_convert);

        this.mViewHolder.buttonConvert.setOnClickListener(this); //coloca o botão para ficar esperando um click

        this.clearValues();
    }

    @Override
    public void onClick(View v) {//método obrigatório do View.OnClickListener. Capta uma ação de click
        if(v.getId() == R.id.button_convert) {//para saber qual botão foi clicado
            String value = this.mViewHolder.editValue.getText().toString();
            if ("".equals(value)){
                Toast.makeText(this, this.getString(R.string.invalid_value), Toast.LENGTH_LONG).show();
            } else {
                Double real = Double.valueOf(value);

                this.mViewHolder.textDolar.setText("$ " +String.format("%.2f", (real / 6)));
                this.mViewHolder.textBit.setText(String.format("%,6f", (real/300000)) + " BTC");
                this.mViewHolder.textXrp.setText(String.format("%.2f", (real / 2.9)) + " XRP");
            }
        }
    }

    private void clearValues(){
        this.mViewHolder.textDolar.setText("");
        this.mViewHolder.textBit.setText("");
        this.mViewHolder.textXrp.setText("");
    }

    private static class ViewHolder { //função de código de boa conduta para criação de objetos que armazenarão as informações do layout
        EditText editValue;
        TextView textDolar;
        TextView textBit;
        TextView textXrp;
        Button buttonConvert;

    }
}