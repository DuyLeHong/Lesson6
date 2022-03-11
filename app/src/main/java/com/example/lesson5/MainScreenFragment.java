package com.example.lesson5;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MainScreenFragment  extends Fragment {

    View view;
    Button shareImageButton;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_simple, container, false);
        // get the reference of Button
        shareImageButton = (Button) view.findViewById(R.id.firstButton);
        // perform setOnClickListener on first Button
        shareImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // display a message by using a Toast

                Bundle bundle = getArguments();
                String sData = bundle.getString("data");

                Toast.makeText(getContext(), sData, Toast.LENGTH_SHORT).show();

            }
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        MainActivity ac = (MainActivity) getActivity();

        ac.doSomeThing();
    }

//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//    }

    @Override
    public void onResume() {
        super.onResume();

        // viet code o day

        //
    }

    @Override
    public void onPause() {
        super.onPause();

        // viet code o day

        //
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
