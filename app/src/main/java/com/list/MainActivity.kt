
package com.list

import android.R.layout
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.github.hyuwah.draggableviewlib.DraggableView


class Person(val username: String, val points: Int)
val friendsList: MutableList<Person> by lazy { mutableListOf() }

fun addPerson(name: String, number: Int) {
    friendsList.add(Person(name, number))
}

fun makeLeaderboard(): List<Person> {
    return friendsList.sortedByDescending {it.points}.toMutableList().slice(0..4)
}


class MainActivity : AppCompatActivity() {

    lateinit var overlay: DraggableView<RecyclerView>
    private var personNames = listOf(
        "Brad",
        "Drew",
        "lilQties",
        "Cartman",
        "Kyle",
        "Thundercat",
        "Kenny",
        "RJames",
        "Stan",
        "docOct",
        "Butters",
        "deltaMech",
        "drewM",
        "TheSpinDiesel",
        "TourdeMerlot",
        "Momcanthearyou",
        "GoCats",
        )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        for (names in personNames){
            addPerson(names, (25..100).random())
        }
        val leaderBoard = makeLeaderboard()
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val customAdapter = CustomAdapter(leaderBoard) // to see full list pass in friendsList
        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = customAdapter

    }


}