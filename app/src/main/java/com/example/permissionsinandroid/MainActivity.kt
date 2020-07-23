package com.example.permissionsinandroid

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_permission.setOnClickListener {

            if(ContextCompat.checkSelfPermission(this,
                    android.Manifest.permission.CAMERA)==PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this,"Already Camera Permission Granted..",Toast.LENGTH_SHORT).show()
            }else{
                    ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA),
                        CAMERA_PERMISSION_CODE)
            }
        }

        btn_permission_storage.setOnClickListener {

        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if(requestCode== CAMERA_PERMISSION_CODE){
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "camera permission granted", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "camera permission denied", Toast.LENGTH_LONG).show();
            }
        }
    }

    companion object {
        private const val CAMERA_PERMISSION_CODE=1;
    }
}
