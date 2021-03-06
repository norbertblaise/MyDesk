package com.my.desk

import android.os.Bundle
import android.view.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
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
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.my.desk.ui.components.SetupPostCard
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

    private lateinit var mAuth: FirebaseAuth
    private lateinit var loggedUser: FirebaseUser

    override fun onStart() {
        super.onStart()
        mAuth = FirebaseAuth.getInstance()
        val loggedUser = mAuth.currentUser
        if(loggedUser == null){
            findNavController().navigate(R.id.action_FeedFragment_to_loginFragment)
        }
    }

    override fun onResume() {
        super.onResume()
        if(loggedUser == null){
            findNavController().navigate(R.id.action_FeedFragment_to_loginFragment)
        }

    }

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
                        modifier = Modifier.padding(horizontal = 16.dp),

                        topBar = {
                            TopAppBar(
                                elevation = 0.dp,
                                backgroundColor = MaterialTheme.colors.background,
                                contentColor = Color.Black,
                                title = { Text(text = "My Desk") },
                                actions = {
                                    IconButton(onClick = {
                                        findNavController().navigate(R.id.action_FeedFragment_to_AddSetupFragment)
                                    }) {
                                        Icon(Icons.Filled.Add, contentDescription = "")
                                    }
                                }
                            )
                        },
                        content = {
                            Column {
                                Text(text = "Featured", fontSize = 20.sp)
                                Image(
                                    painter = painterResource(id = R.drawable.splash_screen_illustration),
                                    contentDescription = ""
                                )
                                Text(text = "Popular", fontSize = 20.sp)
                                Spacer(modifier = Modifier.height(20.dp))
                                Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                                    SetupPostCard(onClick = { findNavController().navigate(R.id.action_FeedFragment_to_deskSetupFragment) })
                                    SetupPostCard(onClick = { findNavController().navigate(R.id.action_FeedFragment_to_deskSetupFragment) })
                                    SetupPostCard(onClick = { findNavController().navigate(R.id.action_FeedFragment_to_deskSetupFragment) })
                                    SetupPostCard(onClick = { findNavController().navigate(R.id.action_FeedFragment_to_deskSetupFragment) })
                                }

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