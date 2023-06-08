package com.example.recyclerviewapplicationsabaorkoshneli

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewapplicationsabaorkoshneli.databinding.ActivityMainBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    private lateinit var homeRVAdapter : HomeRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            homeRVAdapter = HomeRecyclerViewAdapter(getData())
            homeRV.adapter = homeRVAdapter
            homeRV.layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }

    private fun getData(): MutableList<Email> {
        val dataList = ArrayList<Email>()
        // Replace the code for manual data with Firebase Database retrieval logic
        // For example, you can fetch the data from a "emails" node in the database:
        val database = FirebaseDatabase.getInstance()
        val emailsRef = database.getReference("emails")
        emailsRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (emailSnapshot in dataSnapshot.children) {
                    val author = emailSnapshot.child("author").getValue(String::class.java)
                    val subject = emailSnapshot.child("subject").getValue(String::class.java)
                    val content = emailSnapshot.child("content").getValue(String::class.java)
                    if (author != null && subject != null && content != null) {
                        dataList.add(Email(author, subject, content))
                    }
                }
                homeRVAdapter.notifyDataSetChanged()
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Handle the error case
            }
        })

        return dataList
    }



}