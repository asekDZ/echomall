package dz.uc2.sci.echomall;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class SignInFragement extends Fragment {


    public SignInFragement() {
        // Required empty public constructor
    }

    private TextView dontHaveAccount;
    private TextView forgetpassword;
    private Button sign_in_btn;
    private FrameLayout parentFrameLayout;
    private ImageButton crossbtn;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sign_in, container, false);
        dontHaveAccount = view.findViewById(R.id.tv_newcompte);
        forgetpassword = view.findViewById(R.id.sign_in_forget);
        crossbtn = view.findViewById(R.id.sign_in_cross_btn);
        parentFrameLayout= getActivity().findViewById(R.id.register_framelayout);
        sign_in_btn = view.findViewById(R.id.sign_in_btn);



        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        forgetpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                setFragment(new ResetPasswordFragment());
            }
        });
        dontHaveAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(new SignUpFragment());
            }
        });
        crossbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i;
                i = new Intent(getActivity(), MainActivity.class);
                startActivity(i); }
        });


        sign_in_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                setFragment(new ResetPasswordFragment());
            }
        });

    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_from_right,R.anim.slideout_from_left);
        fragmentTransaction.replace(parentFrameLayout.getId(),fragment);
        fragmentTransaction.commit();

    }
}
