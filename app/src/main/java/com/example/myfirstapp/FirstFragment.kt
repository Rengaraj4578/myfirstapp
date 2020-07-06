package com.example.myfirstapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import java.nio.channels.Selector

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val editorActivityViewModel:MyViewModel = ViewModelProviders.of(activity!!).get(MyViewModel::class.java)
        var value =  editorActivityViewModel.getNumber()
        view.findViewById<TextView>(R.id.textview_first).setText(value.toString())
        value.observe(this, Observer { s :String->
            view.findViewById<TextView>(R.id.textview_first).setText(s)
        })

        view.findViewById<Button>(R.id.random_button).setOnClickListener {
            val showCountTextView = view.findViewById<TextView>(R.id.textview_first)
            val currentCount = showCountTextView.text.toString().toInt()
            val random = java.util.Random()
            var randomNumber = 0
            if (currentCount > 0){
                randomNumber = random.nextInt(currentCount + 1)
            }
            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(currentCount,randomNumber)
            findNavController().navigate(action)
        }

        view.findViewById<Button>(R.id.toast_button).setOnClickListener {
            val myToast = Toast.makeText(context, "Hello Toast!", Toast.LENGTH_SHORT)
            myToast.show()
        }

        view.findViewById<Button>(R.id.count_button).setOnClickListener {
            val showCountTextView = view?.findViewById<TextView>(R.id.textview_first)
            var count = showCountTextView?.text.toString().toInt()
            count++
            editorActivityViewModel.setNumber(count)
        }
    }
}