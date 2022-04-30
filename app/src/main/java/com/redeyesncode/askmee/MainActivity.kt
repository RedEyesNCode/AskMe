package com.redeyesncode.askmee

import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.redeyesncode.askme.RedEyesNCode
import com.redeyesncode.askmee.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() ,RedEyesNCode.permissionObservers {
    lateinit var binding : ActivityMainBinding
    override fun onPermissionResultObserver(permissionCode: Int) {

        //THIS METHOD GET NOTIFIED EVERY-TIME IF THE PERMISSION IS ALREADY GRANTED.
        if(RedEyesNCode.PERMISSION_GRANTED_REQUEST==permissionCode){
            Toast.makeText(this@MainActivity,"PERMISSION IS ALREADY GRANTED !",Toast.LENGTH_SHORT).show()
        }else if (RedEyesNCode.PERMISSION_DENIED_CODE==permissionCode){
            Toast.makeText(this@MainActivity,"PERMISSION IS DENIED !",Toast.LENGTH_SHORT).show()

        }


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAskCamera.setOnClickListener {
            //CODE FOR THE LIBARY GOES HERE !
            var redEyesNCode = RedEyesNCode(context = this,this)
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                redEyesNCode.askMeSinglePermission(android.Manifest.permission.CAMERA,"Need this permission to take photos.",this)
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode==RedEyesNCode.PERMISSION_REQUEST_CODE && permissions.isNotEmpty() && grantResults[0]==PackageManager.PERMISSION_GRANTED){
            Toast.makeText(this@MainActivity,"PERMISSION IS GRANTED !",Toast.LENGTH_SHORT).show()
        }else{
            var redEyesNCode = RedEyesNCode(context = this,this)
            redEyesNCode.showPermissionDenyDialog("This features requires permission of camera to take photos.")
        }
    }

}