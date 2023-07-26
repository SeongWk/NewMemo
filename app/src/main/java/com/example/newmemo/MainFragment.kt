package com.example.newmemo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.example.newmemo.databinding.FragmentMainBinding
import com.example.newmemo.databinding.RecyclerviewerBinding


class MainFragment : Fragment() {

    lateinit var fragmentMainBinding: FragmentMainBinding
    lateinit var mainActivity: MainActivity

    // Fragment가 보여줄 화면을 생성하는 메서드
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        // Fragment를 관리하는 Activity객체를 가져온다.
        mainActivity = activity as MainActivity
        // View Binding
        fragmentMainBinding = FragmentMainBinding.inflate(layoutInflater)

        return fragmentMainBinding.root
    }
    inner class recyclerclass:RecyclerView.Adapter<recyclerclass.viewholderclass>(){
        inner class viewholderclass(recyclerviewerBinding: RecyclerviewerBinding):RecyclerView.ViewHolder(recyclerviewerBinding.root){

        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholderclass {
            TODO("Not yet implemented")
        }

        override fun getItemCount(): Int {
            TODO("Not yet implemented")
        }

        override fun onBindViewHolder(holder: viewholderclass, position: Int) {
            TODO("Not yet implemented")
        }
    }

}






