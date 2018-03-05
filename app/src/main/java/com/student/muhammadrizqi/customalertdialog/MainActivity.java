package com.student.muhammadrizqi.customalertdialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton fab;
    Toolbar toolbar;
    AlertDialog.Builder dialog;
    LayoutInflater infalter;
    View dialogView;
    EditText txt_nama, txt_usia, txt_alamat, txt_status;
    TextView txt_hasil;
    String nama, usia, alamat, status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        txt_hasil = (TextView) findViewById(R.id.txt_Hasil);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt_hasil.setText(null);
                DialogForm();
            }
        });

    }

    // untuk mengosongi edittext
    private void kosong(){
        txt_nama.setText(null);
        txt_usia.setText(null);
        txt_alamat.setText(null);
        txt_status.setText(null);
    }

    private void  DialogForm(){
        dialog = new AlertDialog.Builder(MainActivity.this);
        infalter = getLayoutInflater();
        dialogView = infalter.inflate(R.layout.form_data, null);
        dialog.setView(dialogView);
        dialog.setCancelable(true);
        dialog.setIcon(R.mipmap.ic_launcher);
        dialog.setTitle("Form Biodata");

        txt_nama = (EditText) dialogView.findViewById(R.id.txt_nama);
        txt_usia = (EditText) dialogView.findViewById(R.id.txt_Usia);
        txt_alamat = (EditText) dialogView.findViewById(R.id.txt_alamat);
        txt_status = (EditText) dialogView.findViewById(R.id.txt_Status);

        kosong();

        dialog.setPositiveButton("Submit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                nama = txt_nama.getText().toString();
                usia = txt_usia.getText().toString();
                alamat = txt_alamat.getText().toString();
                status = txt_status.getText().toString();

                txt_hasil.setText("Nama : "+nama+"\n"+"Usia : "+usia+"\n"+"Alamat :"+alamat+"\n"+"Status"+status);
                dialogInterface.dismiss();
            }
        });

        dialog.setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        dialog.show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
