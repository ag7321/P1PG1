package com.example.p1pg1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.p1pg1.tablas.Empleados;

public class ActivityEditar extends AppCompatActivity {
    EditText nombres, apellidos, edad, correo;
    Button btnActualizar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);

        nombres = (EditText) findViewById(R.id.nombres);
        apellidos = (EditText) findViewById(R.id.apellidos);
        edad = (EditText) findViewById(R.id.edad);
        correo = (EditText) findViewById(R.id.correo);
        btnActualizar = (Button) findViewById(R.id.actualizar);

        Bundle obj = getIntent().getExtras();

        Empleados emple=null;

        if(obj!=null){
            emple = (Empleados) obj.getSerializable("empleado");

            nombres.setText(emple.getNombres().toString());
            apellidos.setText(emple.getApellidos().toString());
            edad.setText(emple.getEdad().toString());
            correo.setText(emple.getCorreo().toString());
        }

    }
}