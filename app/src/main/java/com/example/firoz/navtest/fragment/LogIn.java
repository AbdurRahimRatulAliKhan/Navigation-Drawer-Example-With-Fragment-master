package com.example.firoz.navtest.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.firoz.navtest.R;

public class LogIn extends Fragment {


    private View view;
    private EditText etUserName, etUserPassword;
    private Button loginButton;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_login, null);
        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        initView();
        addClickListener();

    }


    private void initView() {

        etUserName = view.findViewById(R.id.etUserName);
        etUserPassword = view.findViewById(R.id.etUserPassword);
        loginButton = view.findViewById(R.id.loginBtn);
    }


    private void addClickListener() {

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // --- when login button is clicked

                if (etUserName.getText().toString().trim().equalsIgnoreCase("afridi") && etUserPassword.getText().toString().trim().equals("1234")) {

                    Toast.makeText(getActivity(), "Login Success", Toast.LENGTH_SHORT).show();


                } else {

                    Toast.makeText(getActivity(), "User and Password not match", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
