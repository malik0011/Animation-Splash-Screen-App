package com.example.booking;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.Cursor;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText phoneNumber,Name,LastName,Pin,Address,other,Mail;
    private Button checkInDate,checkOutDate;
    int day,month,year;
    String inDate,outDate,adultsNumber,childsNumber,roomtype,country;
    TextView textView,tvInDate,tvOutDate;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //hocks
        phoneNumber = findViewById(R.id.UserPoneNumber);
        Name = findViewById(R.id.UserName);
        LastName = findViewById(R.id.UserLastName);
        Pin = findViewById(R.id.UserPinCode);
        Address = findViewById(R.id.UserAddress);
        other = findViewById(R.id.UserOtherReq);
        Mail = findViewById(R.id.UserUserMail);
        textView = findViewById(R.id.orderIdForUser);
        tvInDate = findViewById(R.id.checkInDateTextView);
        tvOutDate = findViewById(R.id.checkOutTextView);

        checkInDate = findViewById(R.id.checkInDate);
        checkOutDate = findViewById(R.id.checkOutDate);

        //for country piker
        Spinner spinner = findViewById(R.id.dropDown);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.country, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String msg = adapterView.getItemAtPosition(i).toString();
                country=msg;
                //Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //for number of adults
        Spinner spinner2 = findViewById(R.id.Adult);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.adultsNumber, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String msg = adapterView.getItemAtPosition(i).toString();
                adultsNumber = msg;
               // Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //for number of children

        Spinner spinner3 = findViewById(R.id.Children);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this, R.array.childrenNumber, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter3);
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String msg = adapterView.getItemAtPosition(i).toString();
                childsNumber = msg;
                //Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        //for number of room type

        Spinner spinner4 = findViewById(R.id.room);
        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(this, R.array.roomtype, android.R.layout.simple_spinner_item);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner4.setAdapter(adapter4);
        spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String msg = adapterView.getItemAtPosition(i).toString();
                roomtype = msg;
                //Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });





        //for check in date
        checkInDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //date piker
                final Calendar calendar = Calendar.getInstance();
                year = calendar.get(Calendar.YEAR);
                month = calendar.get(Calendar.MONDAY);
                day = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        inDate = "";
                        inDate = (i2)+"/"+(i1+1)+"/"+i;
                       // Toast.makeText(MainActivity.this, inDate, Toast.LENGTH_SHORT).show();

                        tvInDate.setText(inDate);
                    }
                },year,month,day);

                datePickerDialog.show();
            }
        });

        //for check out date

        checkOutDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //date piker
                final Calendar calendar = Calendar.getInstance();
                year = calendar.get(Calendar.YEAR);
                month = calendar.get(Calendar.MONDAY);
                day = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        outDate = "";
                        outDate = (i2)+"/"+(i1+1)+"/"+i;
                        //Toast.makeText(MainActivity.this, inDate, Toast.LENGTH_SHORT).show();
                        tvOutDate.setText(outDate);
                    }
                },year,month,day);

                datePickerDialog.show();
            }
        });


    }


    public void Submit(View view) {

        //taking variable values
        String ph = phoneNumber.getText().toString();
        String name = Name.getText().toString()+" "+LastName.getText().toString();
        String address = Address.getText().toString();
        String pin = Pin.getText().toString();
        String mail = Mail.getText().toString();
        String Other = other.getText().toString();

        //phoneNumber codition
        if(ph.length()!=10){
            phoneNumber.setError("Please provide 10 digit phone number!");
        }
        else{

            DataInsert(name,ph,mail,address,pin,inDate,outDate,country,Other);

        }
    }

    private void DataInsert(String name, String ph, String mail, String address, String pin, String inDate, String outDate, String country, String Other) {
        //getting the resp.



        String res = new dbManager(this).addRecord(name,mail,ph,address,pin,inDate,outDate,country,Other,adultsNumber,childsNumber,roomtype);
        phoneNumber.setText("");Name.setText("");
        LastName.setText("");
        Pin.setText("");
        Address.setText("");
        Mail.setText("");
        other.setText("");

        Toast.makeText(this, res, Toast.LENGTH_SHORT).show();

        //showing bokking id
        Cursor cursor = new dbManager(this).ShowAllData(); //here we get the db ref.
        //now we have go through the cursor || 12 items are there
        int i=cursor.getCount();
        if(res.equals("Successfully Inserted!")){
            String id = new dbManager(this).getMaxId();
            textView.setText("Your booking ID is : "+id);
        }

    }

    public void Update(View view){

        //phoneNumber codition
        String ph = phoneNumber.getText().toString();
//        if(ph.length()!=10){
//            phoneNumber.setError("Please provide 10 digit phone number!");
//        }
//        else{

            startActivity(new Intent(this,UpdateActivity.class).putExtra("phone",ph));

       // }


    }

    public void Search(View view) {
    }

    public void ShowAll(View view) {
        startActivity(new Intent(this,AllData.class));
    }

}
