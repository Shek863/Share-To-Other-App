fun share (message:String) {
  
  var intent = Intent(Intent.ACTION_SEND)
  intent.type = "text/plain"
  //intent.putExtra(Intent.EXTRA_SUBJET, "Partage de fichier")
  intent.putExtra(Intent.EXTRA_TEXT, message)
  
  //Here we will check correct Whatsapp package 
  val pm : PackageManager = context.PackageManager()
  val matches = pm.queryIntentActivities()
  val best: ResolveInfo? = null
  for (info in matches)
    if(info.activityInfo.packageName.startsWith("com.whatsapp") || info.activity.name.toLowerCase().contains("whatsapp"))
      best = info
  if (best != null)
    intent.setClassName(best.activityInfo.packageName,best.activityInfo.name)
    
  ///let's go
  context.startActivity(intent)
  
  
//           // val uri = Uri.fromFile(viewModel.file.value)
//            val uri : Uri = FileProvider.getUriForFile(
//                requireContext(),
//                requireContext().applicationContext.packageName.toString() + ".provider",
//                viewModel.file.value!!
//            )
//
//            val share = Intent()
//            share.action = Intent.ACTION_SEND
//            share.type = "application/pdf"
//            //share.putExtra(Intent.EXTRA_TEXT, viewModel.getMessage())
//            share.putExtra(Intent.EXTRA_TEXT, "Bonjour Mr Fabrice Dossou\n Voci votre reçu:")
//            share.putExtra(Intent.EXTRA_STREAM, uri)
//
//            val pm: PackageManager = requireContext().getPackageManager()
//            val matches = pm.queryIntentActivities(share, 0)
//            var best: ResolveInfo? = null
//            for (info in matches)
//                if (info.activityInfo.packageName.startsWith("com.whatsapp") || info.activityInfo.name.toLowerCase().contains("whatsapp"))
//                    best = info
//            if (best != null) share.setClassName(
//                best.activityInfo.packageName,
//                best.activityInfo.name
//            )
//            requireContext().startActivity(share)
  
}
