package com.manu.memeappretrofitmvvm.activities

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.manu.memeappretrofitmvvm.MyApplication
import com.manu.memeappretrofitmvvm.adapter.MemesAdapter
import com.manu.memeappretrofitmvvm.api.ApiUtilities
import com.manu.memeappretrofitmvvm.api.MemesAPI
import com.manu.memeappretrofitmvvm.databinding.ActivityHomeBinding
import com.manu.memeappretrofitmvvm.factory.MemesViewModelFactory
import com.manu.memeappretrofitmvvm.model.MemeTemplate
import com.manu.memeappretrofitmvvm.repository.MemesRepository
import com.manu.memeappretrofitmvvm.viewmodel.MemesViewModel

class HomeActivity : AppCompatActivity() {
    private val binding by lazy { ActivityHomeBinding.inflate(layoutInflater) }
    private lateinit var memesViewModel: MemesViewModel
    private lateinit var memesAdapter: MemesAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val memesRepository = (application as MyApplication).memesRepository
        val memesFactory = MemesViewModelFactory(memesRepository)
        memesViewModel = ViewModelProvider(this, memesFactory) [MemesViewModel::class.java]

        memesAdapter = MemesAdapter()
        binding.memesRv.adapter = memesAdapter
        val memeList = ArrayList<MemeTemplate>()
        if(memeList.isEmpty()) {
            binding.tvLoading.visibility = View.VISIBLE
            binding.memesRv.visibility = View.GONE
        } else {
            binding.tvLoading.visibility = View.GONE
            binding.memesRv.visibility = View.VISIBLE


        }

        memesViewModel.memes.observe(this) {

            Toast.makeText(this, "${it.data.memes.size}", Toast.LENGTH_SHORT).show()
           it.data.memes.iterator().forEach { meme ->
               memeList.add(MemeTemplate(meme.url, meme.name, meme.id))
               Log.d("MAANU", "onCreate: $memeList")
           }

            memesAdapter.submitList(memeList)

            binding.tvLoading.visibility = View.GONE
            binding.memesRv.visibility = View.VISIBLE
        }
    }
}