package com.example.communication_between_fragments


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragmentb.view.*
import kotlinx.android.synthetic.main.fragment_.*
import kotlinx.android.synthetic.main.fragment_.view.*
import kotlinx.android.synthetic.main.fragment_.view.fragmentAEditText
import kotlinx.android.synthetic.main.fragmentb.*
import kotlinx.android.synthetic.main.fragmentb.view.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class FragmentB : Fragment() {

    //Since to communicate between 2 fragments interface is used. Therefore we need to create an object of this interface so that we can access its abstract method
    //in fragments onCreateView function
    private var fragmentBListner : FragmentBListner? = null



    public interface FragmentBListner{

        //Here we define the 1 interface method
        fun onInputBSent(v:String)
        //Therefore the Main Activity would have to implement this method if the activity inherits this interface

    }


    override fun onAttach(context: Context?) {
        super.onAttach(context)
        //This function will be called when this fragment gets attached to the activity.
        //Therefore when this fragment gets attached it to the activity. We must make sure it implements the interface methods.
        // So we should provide the fragmenentAListener the context which it wants to contact.

        fragmentBListner = context as FragmentBListner  // writing this we have made an link with the fragment and the activity so that they could contact.
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragmentb, container, false)
        v.fragmentBButton.setOnClickListener {
            val data = fragmentBEditText.text.toString()
            fragmentBListner?.onInputBSent(data) //This function will be executed every where it is implemented, in short it will be implemented by the  main activity which will implement this interface
            // Therefore every time this line is executed , the onInputAsent would also be implemented in the activity.
        }
        return v
    }

    override fun onDetach() {
        super.onDetach()
        //when the activity is finished. The fragment also gets detached. Therefore we should also finish the link between the activity and the fragment.
        fragmentBListner = null
    }


}
