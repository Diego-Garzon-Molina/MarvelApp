package com.tsse.spain.marvelapptalentomobile.ui

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.tsse.spain.marvelapptalentomobile.R
import com.tsse.spain.marvelapptalentomobile.databinding.MainActivityBinding
import com.tsse.spain.marvelapptalentomobile.platform.appModule
import com.tsse.spain.marvelapptalentomobile.ui.characters_landing.CharactersLandingFragment
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainActivity : AppCompatActivity() {
    private var _binding: MainActivityBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startKoin {
            androidLogger()
            androidContext(this@MainActivity)
            modules(
                listOf(
                    appModule
                )
            )
        }
        _binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onSupportNavigateUp() =
        this.findNavController(R.id.nav_host_fragment_container).navigateUp()
}