package com.bakkenbaeck.token.model;


import android.os.Parcel;
import android.os.Parcelable;

import com.journeyapps.barcodescanner.BarcodeResult;

public class ScanResult implements Parcelable {

    private final String text;

    public ScanResult(final BarcodeResult result) {
        this.text = result.getText();
    }

    public String getText() {
        return this.text;
    }

    private ScanResult(final Parcel in) {
        this.text = in.readString();
    }

    public static final Creator<ScanResult> CREATOR = new Creator<ScanResult>() {
        @Override
        public ScanResult createFromParcel(final Parcel in) {
            return new ScanResult(in);
        }

        @Override
        public ScanResult[] newArray(final int size) {
            return new ScanResult[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(final Parcel dest, final int flags) {
        dest.writeString(text);
    }
}
