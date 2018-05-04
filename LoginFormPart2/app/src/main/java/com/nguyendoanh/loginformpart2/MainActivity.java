package com.nguyendoanh.loginformpart2;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtuser, edtpassword;
    Button btndangky,btndangnhap,btnthoat;
    String ten,mk,mail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        ControlButton();
        
    }

    private void ControlButton() {
        // Xu ly nut thoat
        btnthoat.setOnClickListener(new View.OnClickListener() {
            @Override
            //Dung alert Dialog khi show ra hop thoai
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this, android.R.style.Theme_DeviceDefault);
                builder.setTitle("Bạn có chắc muốn thoát khỏi app");
                builder.setMessage("Hãy lựa chọn bên dưới để xác nhận");
                builder.setIcon(android.R.drawable.ic_dialog_alert);
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        onBackPressed();
                    }
                });
                builder.setNeutralButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.show();
            }
        });
        //Xu ly nut dang ki.Khi nhan vao nut dang ki thi se mo ra hop thoai dang ki (DialogCustom)
        btndangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(MainActivity.this);
               // dialog.setTitle("FORM SIGN UP");
                // Ham nay dung de xu ly trong hop thoai ko duoc nhan ra ngoai
                dialog.setCancelable(false);
                dialog.setContentView(R.layout.customdialog);
                final EditText edttk = (EditText) dialog.findViewById(R.id.edittk);
                final EditText edtmk = (EditText) dialog.findViewById(R.id.edittmk);
                EditText edtm = (EditText) dialog.findViewById(R.id.edittm);
                Button btnhuy = (Button) dialog.findViewById(R.id.buttonhuy);
                Button btndongy = (Button) dialog.findViewById(R.id.buttondongy);
                btndongy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    // Lay du lieu tu nguoi dung nhap vao form sign up dien vao form dang nhap
                    public void onClick(View view) {
                        ten = edttk.getText().toString().trim();
                        mk = edtmk.getText().toString().trim();
                        edtuser.setText(ten);
                        edtpassword.setText(mk);
                        dialog.cancel();
                    }
                });
                btnhuy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.cancel();
                    }
                });
                dialog.show();
            }
        });
        btndangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Kiem tra xem edittext user,password da co ki tu nao hay chua
                if (edtuser.getText().length() != 0 && edtpassword.getText().length() != 0) {
                    if (edtuser.getText().toString().equals(ten) && edtuser.getText().toString().equals(mk)) {
                        Toast.makeText(MainActivity.this, "Login successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                        //  Thuc hien goi ham chuyen man hinh
                        startActivity(intent);
                    } else if (edtuser.getText().toString().equals("doanh") && edtpassword.getText().toString().equals("123")) {
                        Toast.makeText(MainActivity.this, "Login successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(MainActivity.this, "Login failed", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Please enter enough information", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void Anhxa() {
        edtuser = (EditText) findViewById(R.id.edittextuser);
        edtpassword = (EditText) findViewById(R.id.editpassword);
        btndangnhap = (Button) findViewById(R.id.buttondangnhap);
        btndangky = (Button) findViewById(R.id.buttondangky);
        btnthoat =(Button) findViewById(R.id.buttonthoat);

    }
}
