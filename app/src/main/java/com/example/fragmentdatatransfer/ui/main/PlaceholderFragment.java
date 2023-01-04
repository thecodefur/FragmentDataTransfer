package com.example.fragmentdatatransfer.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.fragmentdatatransfer.R;
import com.example.fragmentdatatransfer.databinding.FragmentMainBinding;

import kotlin.Function;

public class PageViewModel extends ViewModel {
    private static final String name = "atilimciftci";
    private static final String sifre = "12345";
    private MutableLiveData<String> kullaniciAdi = new MutableLiveData<>();
    private MutableLiveData<String> kullaniciSifre = new MutableLiveData<>();
    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi.setValue(kullaniciAdi);
    }
    public void setKullaniciSifre(String kullaniciSifre) {
        this.kullaniciSifre.setValue(kullaniciSifre);
    }
    public LiveData<String> getKullaniciAdi() {
        return kullaniciAdi;
    }
    public LiveData<String> getKullaniciSifre(){
        return kullaniciSifre;
    }
    public static String getName() { return name; }
    public static String getSifre(){return sifre;}


    private MutableLiveData<Integer> mIndex = new MutableLiveData<>();
    private LiveData<String> mText = Transformations.map(mIndex, new Function() {
        @Override
        public String apply(Integer input) {
            return "Hello world from section: " + input;
        }
    });

    public void setIndex(int index) {
        mIndex.setValue(index);
    }

    public LiveData<String> getText() {
        return mText;
    }
}