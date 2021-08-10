package com.tsse.spain.marvelapptalentomobile.utils

import android.net.Uri
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterInside
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.target.Target
import java.math.BigInteger
import java.security.MessageDigest

/**
Created By Diego Garzón on 09/08/2021
 */

fun setImgFromUri(imageView: ImageView, url: String) {
    val uri = Uri.parse(url.replace("http", "https"))

    Glide.with(imageView.context)
        .load(uri)
        .transform(CenterInside(), RoundedCorners(8))
        .override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
        .into(imageView)
}


fun String.md5(): String {
    val md = MessageDigest.getInstance("MD5")
    return BigInteger(1, md.digest(this.toByteArray())).toString(16).padStart(32, '0')

}
