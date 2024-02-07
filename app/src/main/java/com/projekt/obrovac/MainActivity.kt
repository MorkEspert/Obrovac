package com.projekt.obrovac

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.projekt.obrovac.databinding.ActivityMainBinding




class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val database: DatabaseReference = FirebaseDatabase.getInstance("https://obrovac-24e61-default-rtdb.europe-west1.firebasedatabase.app/").getReference("tekstovi")
    private var korisnikList = ArrayList<korisnik>()
    private var racunList = ArrayList<racun>()
    private var transakcijaList = ArrayList<transakcija>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val rv1 = findViewById(R.id.RV1);
        val rv2 = findViewById(R.id.RV2);
        val rv3 = findViewById(R.id.RV3);

        binding.button1.setOnClickListener {
            startActivity(Intent(this, korisnik::class.java))
        }

        binding.button2.setOnClickListener {
            startActivity(Intent(this, racun::class.java))
        }

        binding.button3.setOnClickListener {
            startActivity(Intent(this, transakcija::class.java))
        }

        database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                korisnikList.clear()
                racunList.clear()
                transakcijaList.clear()

                try {
                    for (data in snapshot.child("korisnici").children) {
                        val korisnikData = data.getValue(korisnik::class.java)
                        korisnikData?.let { korisnikList.add(it) }
                    }

                    for (data in snapshot.child("racuni").children) {
                        val racunData = data.getValue(racun::class.java)
                        racunData?.let { racunList.add(it) }
                    }

                    for (data in snapshot.child("transakcije").children) {
                        val transakcijaData = data.getValue(transakcija::class.java)
                        transakcijaData?.let { transakcijaList.add(it) }
                    }
                } catch (e: Exception) {
                    // Handle the exception
                }
                binding.rv1.apply {
                    layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
                    adapter = korisnikAdapter(korisnikList, this@MainActivity)
                }
                binding.rv2.apply {
                    layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
                    adapter = korisnikAdapter(racunList, this@MainActivity)
                }
                binding.rv3.apply {
                    layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
                    adapter = korisnikAdapter(transakcijaList, this@MainActivity)
                }


            }

            override fun onCancelled(error: DatabaseError) {
                // Handle the error
            }
        })
    }
}
