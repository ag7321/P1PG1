package com.example.p1pg1;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.p1pg1.configuraciones.SQLiteConexion;
import com.example.p1pg1.configuraciones.Transacciones;

public class ActivityConsulta extends AppCompatActivity {
    SQLiteConexion conexion;
    EditText id,nombres,apellidos,edad,correo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);

        conexion = new SQLiteConexion(this, Transacciones.NameDatabase,null,1);

        Button btnBuscar = (Button) findViewById(R.id.btnBuscar);

        id = (EditText) findViewById(R.id.codigoFind);
        nombres = (EditText) findViewById(R.id.txtNom);
        apellidos = (EditText) findViewById(R.id.txtApe);
        edad = (EditText) findViewById(R.id.txtEda);
        correo = (EditText) findViewById(R.id.txtCor);

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Buscar();
            }
        });
    }

    private void Buscar(){
        SQLiteDatabase db = conexion.getWritableDatabase();
        String [] params = {id.getText().toString()};
        String [] fields = {Transacciones.nombres,
                            Transacciones.apellidos,
                            Transacciones.edad,
                            Transacciones.correo};

        String wherecondition = Transacciones.id + "=?";

        try {
            Cursor cdata = db.query(Transacciones.tablaempleados,fields,wherecondition,params,null,null,null);
            cdata.moveToFirst();

            nombres.setText(cdata.getString(0));
            apellidos.setText(cdata.getString(1));
            edad.setText(cdata.getString(2));
            correo.setText(cdata.getString(3));

            Toast.makeText(getApplicationContext(),"Consultado con exito", Toast.LENGTH_LONG).show();

        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"Elemento no encontrado", Toast.LENGTH_LONG).show();
        }
    }
}