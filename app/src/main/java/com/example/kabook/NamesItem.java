package com.example.kabook;

import android.os.Parcel;
import android.os.Parcelable;


public class NamesItem implements Parcelable {
    private int mImageResourse;
    private String mNameBook;
    private String mAboutBook;

    public NamesItem(int ImageResourse, String NameBook, String AboutBook){
        mImageResourse = ImageResourse;
        mNameBook = NameBook;
        mAboutBook = AboutBook;
    }
    public void changeNameBook(String text){
        mNameBook = text;
    }

    protected NamesItem(Parcel in) {
        mImageResourse = in.readInt();
        mNameBook = in.readString();
        mAboutBook = in.readString();
    }

    public static final Creator<NamesItem> CREATOR = new Creator<NamesItem>() {
        @Override
        public NamesItem createFromParcel(Parcel in) {
            return new NamesItem(in);
        }

        @Override
        public NamesItem[] newArray(int size) {
            return new NamesItem[size];
        }
    };

    public int getmImageResourse(){
        return mImageResourse;
    }
    public String getNameBook(){
        return mNameBook;
    }
    public String getAboutBook(){
        return mAboutBook;
    }
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mImageResourse);
        dest.writeString(mNameBook);
        dest.writeString(mAboutBook);
    }
}
