package com.example.flixsterpt2

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import com.example.flixsterpt2.BuildConfig.API_KEY
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.Headers
import org.json.JSONArray

class MovieFragment: Fragment(), MovieInteractionListener {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.movie_rv, container, false)
        val progressBar = view.findViewById<ProgressBar>(R.id.movieProgressBar)
        val recyclerView = view.findViewById<RecyclerView>(R.id.movieRV)
        val context = view.context
        recyclerView.layoutManager = GridLayoutManager(context, 1)
        updateAdapter(progressBar, recyclerView)
        return view
    }
