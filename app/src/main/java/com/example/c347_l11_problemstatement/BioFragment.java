package com.example.c347_l11_problemstatement;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BioFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BioFragment extends Fragment {

    Button btnEdit;
    TextView tvBio;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BioFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BioFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BioFragment newInstance(String param1, String param2) {
        BioFragment fragment = new BioFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.biofragment, container, false);

        // UI Elements
        btnEdit = view.findViewById(R.id.btnEditBio);
        tvBio = view.findViewById(R.id.tvBio);

        // On btn edit click
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Inflat layout
                LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View dialogView= inflater.inflate(R.layout.dialog_edit, null, false);
                final EditText et = (EditText) dialogView.findViewById(R.id.etBio);

                // Set text to user input
                et.setText(tvBio.getText().toString());

                // Builder
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

                builder.setTitle("Edit Bio")
                        .setView(dialogView)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialogInterface, int i) {
                                tvBio.setText(et.getText().toString());
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogInterface, int i) {
                            }
                        })
                        .create();
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

        return view;
    }
}