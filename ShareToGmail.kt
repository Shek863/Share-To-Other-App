

//give on parameter the message that you will share
fun share (message:String) {
  
  var intent = Intent(Intent.ACTION_SEND)
  intent.type = "text/plain"
  intent.putExtra(Intent.EXTRA_SUBJET, "Partage de fichier")
  intent.putExtra(Intent.EXTRA_TEXT, message)
  
  //Here we will check correct Gmail package 
  val pm : PackageManager = context.PackageManager()
  val matches = pm.queryIntentActivities()
  val best: ResolveInfo? = null
  for (info in matches)
    if(info.activityInfo.packageName.endsWith(".gm") || info.activity.name.toLowerCase().contains("gmail"))
      best = info
  if (best != null)
    intent.setClassName(best.activityInfo.packageName,best.activityInfo.name)
    
  ///let's go
  context.startActivity(intent)
  
}
