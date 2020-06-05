package com.example.colormyviews

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setLisreners()
    }

    private fun setLisreners() {

        //Прослушиватель кликов. В динном случае один и тот же для всех. В скобках перечисленны id
        //элементов, которые слушает программа
        val clickableViews: List<View> =
            listOf(box_one_text, box_two_text, box_tree_text, box_four_text, box_five_text,
                constraint_layout, red_button, green_button, yellow_button)

        //Здесь мы смотрим если один из box нажат то вызываем функцию makeColored
        for (item in clickableViews) {
            item.setOnClickListener{makeColored(it)}
        }
    }

    fun makeColored(view: View) {
        when (view.id) {

            // Boxes using Color class colors for background
            R.id.box_one_text -> view.setBackgroundColor(Color.DKGRAY)
            R.id.box_two_text -> view.setBackgroundColor(Color.GRAY)

            // Boxes using Android color resources for background
            R.id.box_tree_text -> view.setBackgroundResource(android.R.color.holo_green_light)
            R.id.box_four_text -> view.setBackgroundResource(android.R.color.holo_green_dark)
            R.id.box_five_text -> view.setBackgroundResource(android.R.color.holo_green_light)

            // Boxes using custom colors for background
            R.id.red_button -> box_tree_text.setBackgroundResource(R.color.my_red)
            R.id.yellow_button -> box_four_text.setBackgroundResource(R.color.my_yellow)
            R.id.green_button -> box_five_text.setBackgroundResource(R.color.my_green)

            //Если пользователь коснулся фона устанавливаем цвет светло-серый
            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }
}
