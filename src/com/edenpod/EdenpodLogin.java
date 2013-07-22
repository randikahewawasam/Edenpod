package com.edenpod;

import com.edenpod.base.BaseActivity;
import com.edenpod.common.Constants;
import com.edenpod.ui.LoginFragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.FragmentManager.OnBackStackChangedListener;
import android.os.Bundle;

public class EdenpodLogin extends BaseActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.edenpod_main);
		super.onCreate(savedInstanceState);
	}

	@Override
	protected void initializeUI() {
		// TODO Auto-generated method stub
		hideActionbar();
		
		FragmentManager fm = getFragmentManager();
		FragmentTransaction ft = fm.beginTransaction();
		fm.addOnBackStackChangedListener(new OnBackStackChangedListener() {
			@Override
			public void onBackStackChanged() {
				
			}
		});

		LoginFragment loginFragment = new LoginFragment();
		ft.replace(R.id.loginArea, loginFragment, Constants.FRG_TAG_LOGIN);
		ft.commit();
	}

	@Override
	protected void refreshUI() {
		// TODO Auto-generated method stub
		
	}
}
