package com.my.desk

import android.os.Bundle
import android.view.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.composethemeadapter.MdcTheme
//import com.my.desk.databinding.FragmentSetupFeedBinding
import com.my.desk.ui.theme.MyDeskTheme

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FeedFragment : Fragment() {

//    private var _binding: FragmentSetupFeedBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
//    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = ComposeView(requireContext()).apply {
        setContent {
            MyDeskTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Scaffold(
                        topBar = {
                            TopAppBar(
                                elevation = 0.dp,
                                backgroundColor = MaterialTheme.colors.background,
                                contentColor = Color.Black,
                                title = { Text(text = "My Desk") },
                                actions = {
                                    IconButton(onClick = { /*TODO*/ }) {
                                        Icon(Icons.Filled.Add, contentDescription = "")
                                    }
                                }
                            )
                        },
                        content = {
                            Column {
                                Text(text = "Featured", fontSize = 20.sp)
                                Image(
                                    painter = painterResource(id = R.drawable.desk_image_1),
                                    contentDescription = ""
                                )
                                Text(text = "Popular", fontSize = 20.sp)


                            }
                        },
                    )
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        binding.buttonFirst.setOnClickListener {
//            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
//        }
    }
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setHasOptionsMenu(true)
//    }
//
//
//    override fun onPrepareOptionsMenu(menu: Menu) {
//        super.onPrepareOptionsMenu(menu)
//        val confirmSubmitItem = menu.findItem(R.id.action_confirm_submission)
//        val newSubmitItem = menu.findItem(R.id.action_create_new_submission)
//
//        confirmSubmitItem.isVisible = false
//        newSubmitItem.isVisible = true
//    }
//
//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null
//    }
}