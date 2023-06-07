package pt.ipt.dama.fragmentswithcamera

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import pt.ipt.dama.fragmentswithcamera.fragments.CameraFragment
import pt.ipt.dama.fragmentswithcamera.fragments.GalleryFragment
import pt.ipt.dama.fragmentswithcamera.fragments.GpsFragment

class MyPageViewAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

        /**
         * specify the number of fragments that you are going to use
         */
        override fun getItemCount(): Int {
            return 3
        }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> CameraFragment()
            1 -> GalleryFragment()
            2 -> GpsFragment()
            else -> CameraFragment()
        }
    }
}