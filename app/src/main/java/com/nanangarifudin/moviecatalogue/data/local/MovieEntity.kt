package com.nanangarifudin.moviecatalogue.data.local

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieEntity(
    var id : Int,
    var title : String,
    var description : String,
    var poster : Int
) : Parcelable