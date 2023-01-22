package com.example.youtube.core.network.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

 abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity() {
    protected lateinit var binding: VB
    protected abstract fun inflateViewBinding(): VB
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = inflateViewBinding()
        setContentView(binding.root)

        checkInternet()
        setUI()
        initAdapter()
        setupLiveData()
        initListener()

    }

   open fun setupLiveData(){}

    open fun setUI(){}

    open fun  initAdapter(){}

   open fun checkInternet(){}

   open fun initListener(){}


}