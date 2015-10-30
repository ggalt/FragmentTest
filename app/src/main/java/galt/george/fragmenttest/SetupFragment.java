package galt.george.fragmenttest;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by ggalt66 on 10/28/2015.
 */
public class SetupFragment extends Fragment {
    Button buttonOK;
    Button buttonCancel;
    Button buttonDefault;

    public interface SetupListener {
        public void onButtonClick( int val );
    }

    private SetupListener mCallBack;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.setup_fragment, container, false);

        buttonOK = (Button) view.findViewById(R.id.btnOK);
        buttonCancel = (Button) view.findViewById(R.id.btnCancel);
        buttonDefault = (Button) view.findViewById(R.id.btnReset);

        // OK
        buttonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallBack.onButtonClick(1);
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = getActivity();
        try {
            mCallBack = (SetupListener)activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement SetupListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallBack = null;
    }
}
