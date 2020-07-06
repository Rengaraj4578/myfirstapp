package com.example.myfirstapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    val args: SecondFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val count = arguments?.getInt("myArg")
        val random = arguments?.getInt("myArg2")

        view.findViewById<Button>(R.id.button_second).setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }

//        val count = args.myArg
//        val random = args.myArg2
        val countText = getString(R.string.random_heading, count)
        view.findViewById<TextView>(R.id.textview_second).text = countText
        val editorActivityViewModel:MyViewModel = ViewModelProviders.of(activity!!).get(MyViewModel::class.java)
        var value =  editorActivityViewModel.getRandom()
        view.findViewById<TextView>(R.id.textview_random).setText(value.toString())
        value.observe(this, Observer { s :String->
            view.findViewById<TextView>(R.id.textview_random).setText(s)
        })
        if (random != null) {
            editorActivityViewModel.setRandom(random)
        }
    }
}