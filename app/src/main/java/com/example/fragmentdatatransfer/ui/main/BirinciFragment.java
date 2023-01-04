package com.example.fragmentdatatransfer.ui.main;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.fragmentdatatransfer.R;

import org.jetbrains.annotations.Nullable;


public class BirinciFragment extends Fragment {
    PageViewModel pageViewModel;
    public static BirinciFragment birinciFragment(){
        return new BirinciFragment();
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        pageViewModel = new ViewModelProvider(requireActivity()).get(PageViewModel.class);
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable
            ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_birinci,container,false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        EditText editText_KullaniciAdi = view.findViewById(R.id.editText_KullaniciAdi);
        EditText editText_KullaniciSifre = view.findViewById(R.id.editText_KullaniciSifresi);
        editText_KullaniciAdi.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int
                    i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1,
                                      int i2) {
                pageViewModel.setKullaniciAdi(charSequence.toString());
            }
            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
        editText_KullaniciSifre.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int
                    i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1,
                                      int i2) {
                pageViewModel.setKullaniciSifre(charSequence.toString());
            }
            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
    }
}