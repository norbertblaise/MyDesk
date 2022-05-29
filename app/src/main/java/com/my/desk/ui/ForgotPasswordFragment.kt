package com.my.desk.ui

import android.graphics.SurfaceTexture
import android.os.Bundle
import android.view.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.my.desk.ui.theme.MyDeskTheme

class ForgotPasswordFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setContent {
                MyDeskTheme() {
                    Surface(
                        color = Color.White,
                    ) {
                        Scaffold() {

                        }
                    }
                }
            }
        }
    }
}