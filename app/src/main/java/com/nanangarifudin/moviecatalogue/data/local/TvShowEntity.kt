package com.nanangarifudin.moviecatalogue.data.local

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "favoritetv")
data class TvShowEntity(

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    var id : Int? = 0,

    @NonNull
    @ColumnInfo(name = "title")
    var title : String? = "",

    @NonNull
    @ColumnInfo(name = "description")
    var description : String? = "",

    @ColumnInfo(name = "bookmarked")
    var bookmarked: Boolean = false,

    @NonNull
    @ColumnInfo(name = "poster")
    var poster : String? = ""
) : Parcelable