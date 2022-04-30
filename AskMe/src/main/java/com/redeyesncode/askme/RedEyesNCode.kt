package com.redeyesncode.askme

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity

open class RedEyesNCode(var context: Context,var activity: Activity) {

    //CONCEPT OF THE COMPANION OBJECT TO GET THE ALL THE GLOBAL VARIABLES VALUE OF THE CLASS INTO ANY OTHER CLASS.
    companion object{
        var PERMISSION_GRANTED_REQUEST=99;
        var PERMISSION_REQUEST_CODE =77;
        var PERMISSION_DENIED_CODE =-100
        var PERMISSION_REQUESTING_CODE =66;
    }


    //DEFINING  THE RUNTIME PERMISSION AND THE OTHER FUNCTIONS AND INTERFACES REALTED TO PERMISSIONS HERE !

    @RequiresApi(Build.VERSION_CODES.M)
    fun askMeSinglePermission(permission:String,dialogBoxDenyMessage:String,permissionObservers: permissionObservers){

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            //runtime permission are only allowed after android marshmellow.
            if( context.checkSelfPermission(permission)==PackageManager.PERMISSION_GRANTED){
                //THE PERMISSION IS GRANTED SUCCESSFULLY YOU CAN USE THE API REQUESTING THE PERMISSION NOW.
                permissionObservers.onPermissionResultObserver(PERMISSION_GRANTED_REQUEST)

            }else{
                //NEED TO REQUEST THE PERMISSION FROM THE USER.
                    //INTIALIZING AN ARRAY IN KOTLIN WITH THE FIXED SIZE
                    var permissionArray : Array<String> =Array<String>(1){permission}
                activity.requestPermissions(permissionArray,PERMISSION_REQUEST_CODE)


            }
        }

    }

    interface permissionObservers{
        fun onPermissionResultObserver(permissionCode: Int)


    }

    fun showPermissionDenyDialog(message:String){
        var dialog = Dialog(context,R.style.RoundedCornersDialog)
        dialog.setContentView(R.layout.common_dialog_box_warning)

        var  textViewMessage: TextView
        textViewMessage = dialog.findViewById(R.id.tvSetText)
        var btnOk:LinearLayout
        btnOk = dialog.findViewById(R.id.btnOk);
        btnOk.setOnClickListener {
            dialog.dismiss()
        }
        textViewMessage.text = message
        dialog.setCancelable(true)
        dialog.setCanceledOnTouchOutside(true)
        dialog.show()



    }








}