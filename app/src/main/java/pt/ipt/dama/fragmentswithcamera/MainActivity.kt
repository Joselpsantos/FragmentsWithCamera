package pt.ipt.dama.fragmentswithcamera

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import pt.ipt.dama.fragmentswithcamera.fragments.CameraFragment
import pt.ipt.dama.fragmentswithcamera.fragments.GalleryFragment
import pt.ipt.dama.fragmentswithcamera.fragments.GpsFragment

class MainActivity : AppCompatActivity() {

    lateinit var tabLayout: TabLayout
    lateinit var viewPager: ViewPager2
    // add variable to reference the tool used
    // to interact with fragments
    lateinit var myViewPagerAdapter: MyPageViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tabLayout=findViewById(R.id.tabLayout)
        viewPager=findViewById(R.id.viewPager)

        // assign the viewPagerAdapter to ViewPager
        myViewPagerAdapter= MyPageViewAdapter(this)
        viewPager.adapter=myViewPagerAdapter

        // choose what happens when we click on tabs
        tabLayout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                viewPager.currentItem=tab!!.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) { }
            override fun onTabReselected(tab: TabLayout.Tab?){ }
        })

        // do something if user uses their fingers on screen
        viewPager.registerOnPageChangeCallback(object:ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                tabLayout.getTabAt(position)?.select()
            }
        })
    }

}