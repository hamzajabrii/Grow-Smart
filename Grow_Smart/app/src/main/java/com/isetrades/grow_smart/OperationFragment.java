package com.isetrades.grow_smart;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;


public class OperationFragment extends Fragment {
    private ImageButton OkBt;
    private ImageButton btnEngrais;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_operation, container, false);

        OkBt = (ImageButton) view.findViewById(R.id.OkBt);
        btnEngrais = (ImageButton) view.findViewById(R.id.btnEngrais);
        OkBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CalculQtePlante.class);
                startActivity(intent);
            }
        });

        btnEngrais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CalculEngrais.class);
                startActivity(intent);
            }
        });


        return view;
    }

    public void goToAttract()
    {
        Intent intent = new Intent(getActivity(), CalculQtePlante.class);
        startActivity(intent);
    }
}
