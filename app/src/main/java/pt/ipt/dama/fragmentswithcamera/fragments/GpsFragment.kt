package pt.ipt.dama.fragmentswithcamera.fragments

import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.android.gms.location.FusedLocationProviderClient
import android.Manifest
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import pt.ipt.dama.fragmentswithcamera.R
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat.getSystemService
import com.google.android.gms.location.LocationServices


class GpsFragment : Fragment(), LocationListener {

    private lateinit var locationManager: LocationManager
    private lateinit var textViewGPSPosition: TextView
    private lateinit var bt: Button
    private lateinit var fusedLocationClient: FusedLocationProviderClient

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.gpsfragment, container, false)
        bt = view.findViewById(R.id.button)
        textViewGPSPosition = view.findViewById(R.id.textView)
        bt.setOnClickListener{
            getLocation()
        }
        // Inflate the layout for this fragment
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireActivity())
    }

    private fun getLocation() {
        locationManager = requireActivity().getSystemService(Context.LOCATION_SERVICE) as LocationManager

        if(ContextCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ){
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 5f, this)
        }
        else{
            requestLocationPermission()
        }
    }

    private fun requestLocationPermission() {
        ActivityCompat.requestPermissions(
            requireActivity(),
            arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
            LOCATION_PERMISSION_REQUEST_CODE
        )
    }
    companion object {
        private const val LOCATION_PERMISSION_REQUEST_CODE = 100
    }

    override fun onLocationChanged(p0: Location) {
        val lat = p0.latitude
        val long = p0.longitude
        val accuracy = p0.accuracy

        textViewGPSPosition.text = "Latitude: $lat\nLongitude: $long\nAccuracy: $accuracy meters"
    }


}