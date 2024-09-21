package com.example.tehranbus.Fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.tehranbus.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MovesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MovesFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";

    private String mParam1;

    public MovesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment MovesFragment.
     */
    public static MovesFragment newInstance(String param1) {
        MovesFragment fragment = new MovesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_moves, container, false);

        // Find the TextView in the layout and set the parameter value
        TextView param1TextView = view.findViewById(R.id.textViewParam1);

        if (mParam1 != null) {
            param1TextView.setText(mParam1);
        }

        return view;
    }
}
