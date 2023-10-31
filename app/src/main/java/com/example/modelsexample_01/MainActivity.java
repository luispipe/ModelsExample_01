package com.example.modelsexample_01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.Toast;

import com.example.modelsexample_01.models.Grades;
import com.example.modelsexample_01.models.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

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

        ArrayList<Integer> studentCodesList=new ArrayList<>();
        HashMap<Integer, Student> studentList= new HashMap<>();
        HashMap<String, Grades> gradeList=new HashMap<>();

        userRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int code=studentCodeGenerator(studentCodesList);
                studentCodesList.add(code);
                String studentName= name.getText().toString();
                String studentPhone=phone.getText().toString();
                String studentAddress=address.getText().toString();

                if (studentName.isEmpty() || studentPhone.isEmpty() || studentAddress.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Todos los campos" +
                            "deben diligenciarse",Toast.LENGTH_LONG).show();
                }else {
                    Student studentObject= new Student(code,studentName,studentPhone,studentAddress);
                    studentList.put(code,studentObject);
                }

            }
        });

        gradeRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String code_student=studentCode.getText().toString();
                String course_name= course.getText().toString();
                String teacher_name= teacher.getText().toString();
                String final_grade= grade.getText().toString();
                LocalDate register_date= LocalDate.now();
                String date= register_date.toString();
                String code= code_student+course_name+date;

                if (course_name.isEmpty()||code_student.isEmpty()||
                    teacher_name.isEmpty()||final_grade.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Todos los campos " +
                            "deben estar diligenciados",Toast.LENGTH_LONG).show();
                }else {
                    int code_studentInt=Integer.parseInt(code_student);
                    if(userValidation(code_studentInt,studentCodesList)){
                        double finalGradeInt= Double.parseDouble(final_grade);
                        Grades gradeObject= new Grades(code,code_studentInt,course_name,
                                teacher_name,date,finalGradeInt);
                        gradeList.put(code,gradeObject);
                    }else {
                        Toast.makeText(getApplicationContext(),"Este estudiante" +
                                "no esta registrado en nuestra base de datos",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String studentCode= studentCodeSearch.getText().toString();
                if (studentCode.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Se requiere el " +
                            "código del estudiantes",Toast.LENGTH_LONG).show();
                }else{
                    int studentCodeInt= Integer.parseInt(studentCode);
                    if(userValidation(studentCodeInt,studentCodesList)){
                        showResults(studentCodeInt,gradeList);
                    }else{
                        Toast.makeText(getApplicationContext(),"No se encuentra estudiantes" +
                                " con este código",Toast.LENGTH_LONG).show();
                    }
                }

            }
        });

    }

    public int studentCodeGenerator(ArrayList<Integer>list){
        int random= (int)((Math.random()+0)*(999999-0+1));
        if (userValidation(random,list)){
            studentCodeGenerator(list);
        }
        return random;
    }



    public void showResults(int code, HashMap<String,Grades>grades){

    }

    public boolean userValidation(int code,ArrayList<Integer> list){
        boolean exist=false;
        for (int i:list){
            if (i==code){
                exist=true;
                break;
            }
        }
        return exist;
    }





}