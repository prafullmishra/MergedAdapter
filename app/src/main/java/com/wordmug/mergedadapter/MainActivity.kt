package com.wordmug.mergedadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.MergeAdapter
import com.wordmug.mergedadapter.adapters.FirstAdapter
import com.wordmug.mergedadapter.adapters.SecondAdapter
import kotlinx.android.synthetic.main.activity_main.myList

class MainActivity : AppCompatActivity() {

    private lateinit var firstAdapter: FirstAdapter
    private lateinit var secondAdapter: SecondAdapter

    private val listHeroes: ArrayList<String> = arrayListOf()
    private val listVillains : ArrayList<String> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listHeroes.add("Iron Man")
        listHeroes.add("Captain America")
        listHeroes.add("Black Panther")
        listHeroes.add("Dr. Strange")
        /*listHeroes.add("Thor")
        listHeroes.add("Hulk")*/

        listVillains.add("Hela")
        listVillains.add("Ultron")
        listVillains.add("Thanos")
        listVillains.add("Mandarin")
        /*listVillains.add("Loki ??")
        listVillains.add("Red Skull")*/

        /**
         * Construct individual adapters, as if we are working on two different lists.
         */
        firstAdapter = FirstAdapter(listHeroes)
        secondAdapter = SecondAdapter(listVillains)

        /**
         * Then we add them to an instance of [MergeAdapter], out of which we will get a "combined"
         * adapter to be used.
         */
        val configBuilder = MergeAdapter.Config.Builder()
        configBuilder.setIsolateViewTypes(true)

        val mergedAdapter = MergeAdapter(configBuilder.build(),firstAdapter,secondAdapter)
        mergedAdapter.addAdapter(firstAdapter)
        mergedAdapter.addAdapter(secondAdapter)

        /**
         * Then finally apply the above merged adapter to the recyclerview.
         */
        myList.adapter = mergedAdapter
    }
}
