package au.edu.swin.sdmd.w07_numberlist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val numberList = findViewById<RecyclerView>(R.id.numberList)

        val data = IntArray(100) { it }.filter { it % 3 == 0 || it % 5 == 0}

        numberList.adapter = NumberAdapter(data) { showDetail(it) }
        numberList.layoutManager = LinearLayoutManager(this)
    }

    fun showDetail(item: Int) {
        val i = Intent(this, DetailActivity::class.java)
        i.putExtra("NUMBER", item)
        startActivity(i)
    }
}