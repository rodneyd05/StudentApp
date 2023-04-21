package com.thisisit.studentapp

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.thisisit.studentapp.databinding.ActivityMainBinding
import java.io.IOException

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding
    private val selectCode = 100
    private val cameraCode = 101
    private val getPermission = 102
    private lateinit var bitmap: Bitmap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        mainBinding.subjectRecyclerView.layoutManager = LinearLayoutManager(this)
        val subjectListAdapter = SubjectAdapter(subjectList)
        mainBinding.subjectRecyclerView.adapter = subjectListAdapter

        mainBinding.camera.setOnClickListener {
            val fragmentManager: FragmentManager = supportFragmentManager
            val dialogFragment = ChangeProfileDialogFragment()

            //to prevent from closing when clicking anywhere
            dialogFragment.isCancelable = false
            dialogFragment.show(fragmentManager, "ChangeProfilePicture")
        }

        subjectListAdapter.setOnClickListener(object: SubjectAdapter.OnClickListener {
            override fun onClick(position: Int, model: Subjects) {
                val intent = Intent(this@MainActivity, SubjectActivity::class.java)
                //pass the data here to SubjectActivity
                intent.putExtra(NEXT_SCREEN, model)
                startActivity(intent)
            }

        })
    }

    companion object{
        val NEXT_SCREEN="details_screen"
    }

    fun getPermission() {
        if(checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(arrayOf(Manifest.permission.CAMERA), getPermission)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == getPermission && grantResults.isNotEmpty()) {
            if (grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                getPermission()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == selectCode && data != null) {

            try {
                bitmap = MediaStore.Images.Media.getBitmap(this.contentResolver, data.data)
                mainBinding.profileImage.setImageBitmap(bitmap)

            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
        if (requestCode == cameraCode) {
            bitmap = data?.extras?.get("data") as Bitmap
            mainBinding.profileImage.setImageBitmap(bitmap)
        }
    }
}