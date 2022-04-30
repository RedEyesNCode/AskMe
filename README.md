# PickMe
**This Libary helps you ask for the runtime permission in kotlin**
#### This Libary is under constant Updates.

**Currently the libary can only ask about a single permission**
## Features
- Ask Runtime permission in android.
- Show Custom Denied Permission Dialog with a custom message to tell the user why this particular permission is needed/
-  More adding soon , Suggestions are welcomed !

**Screenshots of the Libary**

<table>
  <tr>
    <td>Permission Preview</td>
   </tr>
  <tr>
    <td><img src="media/askmesingle.gif" width=270 height=480></td>
  </tr>
 </table>

------------



## Installation

##### Add  The jitpack repository inside the settings.fradle file of your project.



    dependencyResolutionManagement {
                repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
                repositories {
                    google()
                    mavenCentral()
                    jcenter() // Warning: this repository is going to shut down soon
                    maven { url "https://jitpack.io" }
                }
    }

------------


#####  Add the dependency inside the android project
            	        implementation 'com.github.RedEyesNCode:InformMe:1.0

------------

##### Usage

**Activity Code for the permission**
`` redEyesNCode.askMeSinglePermission(android.Manifest.permission.CAMERA,"Need this permission to take photos.",this)``
**onRequestPermissionsResult Code**
``  if(requestCode==RedEyesNCode.PERMISSION_REQUEST_CODE && permissions.isNotEmpty() && grantResults[0]==PackageManager.PERMISSION_GRANTED){
Toast.makeText(this@MainActivity,"PERMISSION IS GRANTED !",Toast.LENGTH_SHORT).show()
}else{
var redEyesNCode = RedEyesNCode(context = this,this)
redEyesNCode.showPermissionDenyDialog("This features requires permission of camera to take photos.")
}``
**Implement this interface** : ``RedEyesNCode.permissionObservers`` in the Activity class
**Permission Codes for the Libary** :
var PERMISSION_GRANTED_REQUEST=99;
var PERMISSION_REQUEST_CODE =77;
var PERMISSION_DENIED_CODE =-100
var PERMISSION_REQUESTING_CODE =66;





