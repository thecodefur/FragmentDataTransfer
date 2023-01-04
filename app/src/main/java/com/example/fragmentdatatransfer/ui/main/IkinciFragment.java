package com.example.fragmentdatatransfer.ui.main;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fragmentdatatransfer.R;

import org.jetbrains.annotations.Nullable;

public class IkinciFragment extends Fragment {
    PageViewModel pageViewModel;
    public static IkinciFragment ikinciFragment(){
        return new IkinciFragment();
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = new ViewModelProvider(requireActivity()).get(PageViewModel.class);
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_ikinci,container,false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView textView_KullaniciAdi=view.findViewById(R.id.textView_KullaniciBilgileri);

        pageViewModel.getKullaniciAdi().observe(requireActivity(), new Observer<String>()
        {
            @Override
            public void onChanged(String s) {
                if(pageViewModel.getName().equals(s)){
                    pageViewModel.getKullaniciSifre().observe(requireActivity(), new Observer<String>() {
                        @Override
                        public void onChanged(String t) {
                            if (pageViewModel.getSifre().toString().equals(t)){
                                textView_KullaniciAdi.setText(s);
                            }else
                            {
                                textView_KullaniciAdi.setText("Kullanici Bilgileri");
                            }
                        }
                    });
                }
                else
                {
                    textView_KullaniciAdi.setText("Kullanici Bilgileri");
                }
            }
        });
    }
}
