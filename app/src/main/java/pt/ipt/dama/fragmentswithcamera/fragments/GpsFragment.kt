package pt.ipt.dama.fragmentswithcamera.fragments

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import pt.ipt.dama.fragmentswithcamera.R

class GpsFragment : Fragment() {

    private lateinit var textViewGPSPosition: TextView
    private lateinit var bt: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.gpsfragment, container, false)
        bt = view.findViewById(R.id.button)
        bt.setOnClickListener{
            getLocation()
        }
        // Inflate the layout for this fragment
        return view
    }


}