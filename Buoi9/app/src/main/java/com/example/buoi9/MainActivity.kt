package com.example.buoi9

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.buoi9.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import java.util.Objects

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //binding.recyclerViewId.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        //binding.recyclerViewId.adapter = StudentAdapter(list)

//        val apiService = RetrofitClient.getInstance().create(ApiService::class.java)
//        apiService.getAllStudent().enqueue(
//            object : Callback<List<Student>>{
//                override fun onResponse(
//                    call: Call<List<Student>>,
//                    response: Response<List<Student>>
//                ) {
//                    if (response.isSuccessful){
//                        binding.recyclerViewId.adapter = StudentAdapter(response.body() ?: emptyList())
//                    }else{
//
//                    }
//                }
//
//                override fun onFailure(call: Call<List<Student>>, t: Throwable) {
//                    Toast.makeText(this@MainActivity, "HIHI", Toast.LENGTH_SHORT).show()
//                }
//            }
//        )
        val apiService = RetrofitClient.getInstance().create(ApiService::class.java)
        binding.btnFind.setOnClickListener {
            val id = binding.studentId.text.toString()
            apiService.getStudentById(id).enqueue(
                object : Callback<Student> {
                    override fun onResponse(call: Call<Student>, response: Response<Student>) {
                        if (response.isSuccessful) {
                            val student = response.body()
                            if (student != null) {
                                with(binding) {
                                    id1.text = student.id
                                    nameId.text = student.nameStudent
                                    AgeId.text = student.ageStudent.toString()
                                    AddressId.text = student.addressStudent
                                }
                            }
                        } else {

                        }
                    }

                    override fun onFailure(call: Call<Student>, t: Throwable) {

                    }

                }
            )
        }

        binding.btnCreate.setOnClickListener {
            val apiService = RetrofitClient.getInstance().create(ApiService::class.java)
            val student = Student(
                "100",
                "100",
                100,
                "100"
            )
            apiService.createStudent(student).enqueue(
                object : Callback<Student>{
                    override fun onResponse(call: Call<Student>, response: Response<Student>) {
                        Toast.makeText(this@MainActivity, response.message(), Toast.LENGTH_LONG).show()
                    }

                    override fun onFailure(call: Call<Student>, t: Throwable) {

                    }

                }
            )
        }
    }
}