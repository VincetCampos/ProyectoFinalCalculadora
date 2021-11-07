package com.example.calculadora

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private var num1 : Float = 0.0F
    private var num2 : Float = 0.0F
    private var tipoOperacion : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setTitle("Vincet Alejandro Campos Samayoa")

        val btnInfo : Button = findViewById(R.id.botonInfo)
        val intentInfo = Intent(this, InfoApp::class.java)
        val btn1 : Button = findViewById(R.id.boton1)
        val btn2 : Button = findViewById(R.id.boton2)
        val btn3 : Button = findViewById(R.id.boton3)
        val btn4 : Button = findViewById(R.id.boton4)
        val btn5 : Button = findViewById(R.id.boton5)
        val btn6 : Button = findViewById(R.id.boton6)
        val btn7 : Button = findViewById(R.id.boton7)
        val btn8 : Button = findViewById(R.id.boton8)
        val btn9 : Button = findViewById(R.id.boton9)
        val btn0 : Button = findViewById(R.id.boton0)
        val btnSuma : Button = findViewById(R.id.botonSuma)
        val btnResta : Button = findViewById(R.id.botonResta)
        val btnMultiplicacion : Button = findViewById(R.id.botonMulti)
        val btnDivision : Button = findViewById(R.id.botonDivision)
        val btnLimpiar : Button = findViewById(R.id.botonLimpiar)
        val btnOperar : Button = findViewById(R.id.botonOperar)
        val btnPunto: Button = findViewById(R.id.botonPunto)

        //Boton que dirige a la activity de informacion
        btnInfo.setOnClickListener{view ->
            startActivity(intentInfo)
        }

        //Botones de los numeros
        btn1.setOnClickListener{agregarNumero("1")}
        btn2.setOnClickListener{agregarNumero("2")}
        btn3.setOnClickListener{agregarNumero("3")}
        btn4.setOnClickListener{agregarNumero("4")}
        btn5.setOnClickListener{agregarNumero("5")}
        btn6.setOnClickListener{agregarNumero("6")}
        btn7.setOnClickListener{agregarNumero("7")}
        btn8.setOnClickListener{agregarNumero("8")}
        btn9.setOnClickListener{agregarNumero("9")}
        btn0.setOnClickListener{agregarNumero("0")}
        btnPunto.setOnClickListener {agregarNumero(".")}

        //Botones de las Operaciones
        btnSuma.setOnClickListener{operaciones(1)}
        btnResta.setOnClickListener{operaciones(2)}
        btnMultiplicacion.setOnClickListener{operaciones(3)}
        btnDivision.setOnClickListener{operaciones(4)}

        //Boton para limpiar la pantalla
        btnLimpiar.setOnClickListener{
            limpiarPantalla()
        }

        //Boton para obtener el resultado
        btnOperar.setOnClickListener{
            resolverOperacion()
        }

    }

    private fun agregarNumero(numero : String){
        var pantalla : TextView = findViewById(R.id.txtPantalla)
        if (pantalla.text == "0" && numero != "."){
            pantalla.text = "${numero}"
        }else{
            if(pantalla.text.contains(".") && numero == "."){
                Toast.makeText(this, "Ya hay un punto decimal", Toast.LENGTH_SHORT).show()
            }else{
                pantalla.text = "${pantalla.text}${numero}"
            }
            
        }

        if(tipoOperacion == 0){
            num1 = pantalla.text.toString().toFloat()
        }else{
            num2 = pantalla.text.toString().toFloat()
        }

    }

    private fun operaciones(operacion : Int){
        var pantalla : TextView = findViewById(R.id.txtPantalla)
        tipoOperacion = operacion
        pantalla.text = "0"
    }

    private fun resolverOperacion(){
        var pantalla : TextView = findViewById(R.id.txtPantalla)
        var resultado = when(tipoOperacion){
            1 -> num1+num2
            2 -> num1-num2
            3 -> num1*num2
            4 -> num1/num2
            else -> num1
        }

        num1 = resultado

        pantalla.text = (if ("${resultado}".endsWith(".0")){
            "${resultado}".replace(".0","")
        }else{
            "%.7f".format(resultado)
        }).toString()

    }

    private fun limpiarPantalla(){
        var pantalla : TextView = findViewById(R.id.txtPantalla)
        num1 = 0.0F
        num2 = 0.0F
        tipoOperacion = 0
        pantalla.text = "0"
    }
}