package com.example.kotlincoroutines.data

import android.annotation.SuppressLint
import android.os.Parcel
import android.os.Parcelable


class AccessTokenModel private constructor(`in`: Parcel) : Parcelable {
    private val id: Long
    private val token: String?
    private val hashedToken: String?
    private val accessToken: String?
    private val tokenType: String?

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeLong(this.id)
        dest.writeString(this.token)
        dest.writeString(this.hashedToken)
        dest.writeString(this.accessToken)
        dest.writeString(this.tokenType)
    }

    init {
        this.id = `in`.readLong()
        this.token = `in`.readString()
        this.hashedToken = `in`.readString()
        this.accessToken = `in`.readString()
        this.tokenType = `in`.readString()
    }

    companion object {

        @SuppressLint("ParcelCreator")
        val CREATOR: Parcelable.Creator<AccessTokenModel> = object : Parcelable.Creator<AccessTokenModel> {
            override fun createFromParcel(source: Parcel): AccessTokenModel {
                return AccessTokenModel(source)
            }

            override fun newArray(size: Int): Array<AccessTokenModel?> {
                return arrayOfNulls(size)
            }
        }
    }
}
