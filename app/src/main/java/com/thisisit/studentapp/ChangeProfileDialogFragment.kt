package com.thisisit.studentapp

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.DialogFragment

class ChangeProfileDialogFragment : DialogFragment() {

    private lateinit var cancel: ImageView
    private lateinit var camera: Button
    private lateinit var gallery: Button

    private val selectCode = 100
    private val cameraCode = 101

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view: View = inflater.inflate(R.layout.fragment_change_profile_dialog, container, false)

        camera = view.findViewById(R.id.buttonCamera)
        gallery = view.findViewById(R.id.buttonGallery)
        cancel = view.findViewById(R.id.buttonCancel)

        //to make the dialog design transparent
        dialog!!.window!!.setBackgroundDrawableResource(android.R.color.transparent)

        camera.setOnClickListener{

            val mainActivity: MainActivity = activity as MainActivity
            mainActivity.getPermission()
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            mainActivity.startActivityForResult(intent, cameraCode)

            dialog!!.dismiss()
        }

        gallery.setOnClickListener {

            val mainActivity: MainActivity = activity as MainActivity
            mainActivity.getPermission()

            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "image/*"
            mainActivity.startActivityForResult(intent, selectCode)

            dialog!!.dismiss()
        }

        cancel.setOnClickListener {
            dialog!!.dismiss()
        }

        // Inflate the layout for this fragment
        return view
    }
}