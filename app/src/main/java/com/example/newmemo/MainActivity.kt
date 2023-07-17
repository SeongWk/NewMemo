package com.example.newmemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.newmemo.databinding.ActivityMainBinding
import java.io.FileReader

class MainActivity : AppCompatActivity() {
    lateinit var activityMainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(activityMainBinding.root)

        activityMainBinding.run {
            replaceFragment(FragmentName.FRAGMENT_MAIN,false,false,null)
        }

    }
    //fragment 교체하는 메서드
    fun replaceFragment(name:FragmentName,addTobackStack:Boolean,animate:Boolean,arguments :Bundle? = null){
        //프래그먼트 매니저 설정
        var fragmentReplaced = supportFragmentManager.beginTransaction()

        var newFragment : Fragment? = null
        //프래그먼트 분가처리
        when(name){
            FragmentName.FRAGMENT_MAIN->{
                newFragment = MainFragment()
            }
            FragmentName.FRAGMENT_CATEGORY->{}
            FragmentName.FRAGMENT_MEMO->{}
            FragmentName.FRAGMENT_DETAIL_MEMO->{}
        }
        if(newFragment!=null){
            //프래그먼트 교체
            fragmentReplaced.replace(R.id.main_container,newFragment)
            //프래그먼트 애니메이션 설정
            if(animate == true){
                fragmentReplaced.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            }
            // 프래그먼트 addtobackstack 설정
            if(addTobackStack == true){
                fragmentReplaced.addToBackStack(name.names)
            }
            //프래그먼트 커밋
            fragmentReplaced.commit()
        }
    }

    //프래그먼트 제거
    fun deleteFragment(name: FragmentName){
       supportFragmentManager.popBackStack(name.names,FragmentManager.POP_BACK_STACK_INCLUSIVE)
    }

}

enum class FragmentName(val names:String) {
    FRAGMENT_MAIN("mainFragment"),
    FRAGMENT_CATEGORY("categoryFragment"),
    FRAGMENT_MEMO("memoFragment"),
    FRAGMENT_DETAIL_MEMO("detailFragment")
}