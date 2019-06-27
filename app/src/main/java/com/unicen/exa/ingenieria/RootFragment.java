package com.unicen.exa.ingenieria;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.Serializable;

/**
 * Example about replacing fragments inside a ViewPager. I'm using
 * android-support-v7 to maximize the compatibility.
 * 
 * @author Dani Lao (@dani_lao)
 * 
 */
public class RootFragment extends Fragment {

	private static final String TAG = "RootFragment";

	private Serializable frag;

	public static RootFragment newInstance(Fragment frag) {

		Bundle args = new Bundle();
		args.putSerializable("frag", (Serializable) frag);

		RootFragment fragment = new RootFragment();
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		Bundle arguments = getArguments();
		if (arguments != null){
			frag = arguments.getSerializable("frag");
		}

		View view = inflater.inflate(R.layout.root_fragment, container, false);
		FragmentTransaction transaction = getFragmentManager()
				.beginTransaction();
		transaction.replace(R.id.root_frame, (Fragment) frag);
		transaction.commit();
		return view;
	}

}
