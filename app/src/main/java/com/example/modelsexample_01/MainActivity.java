package com.example.modelsexample_01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;

public class MainActivity extends AppCompatActivity {

    EditText name,phone,address,studentCode,teacher,course,
    grade,studentCodeSearch;

    Button userRegister, gradeRegister,search;

    TableLayout table;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=findViewById(R.id.editTextName);
        phone=findViewById(R.id.editTextPhone);
        address=findViewById(R.id.editTextAddress);

        studentCode=findViewById(R.id.editTextCode);
        course=findViewById(R.id.editTextCourse);
        teacher=findViewById(R.id.editTextTeacher);
        grade=findViewById(R.id.editTextGrade);

        studentCodeSearch=findViewById(R.id.edStudentCode);

        userRegister=findViewById(R.id.buttonStudentRegister);
        gradeRegister=findViewById(R.id.buttonGradeRegister);
        search=findViewById(R.id.button2);



    }

    public String studentCodeGenerator(){

        return "";
    }

    public void showResults(){

    }

    public boolean userValidation(){
        return true;
    }





}