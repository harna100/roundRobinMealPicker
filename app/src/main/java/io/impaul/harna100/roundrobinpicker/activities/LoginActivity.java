package io.impaul.harna100.roundrobinpicker.activities;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import io.impaul.harna100.roundrobinpicker.R;

public class LoginActivity extends AppCompatActivity{

	// UI references.
	private AutoCompleteTextView tv_email;
	private EditText et_password;
	private View pv_progress;
	private View v_loginForm;
	private Button btn_signin;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		getReferences();
		setListeners();
	}

	private void getReferences(){
		tv_email = findViewById(R.id.email);
		et_password = findViewById(R.id.password);
		btn_signin = findViewById(R.id.email_sign_in_button);
		v_loginForm = findViewById(R.id.login_form);
		pv_progress = findViewById(R.id.login_progress);
	}
	private void setListeners() {
		setLoginButtonListener();
		setEditorActionListener();
	}

	private void setEditorActionListener() {
		et_password.setOnEditorActionListener(new TextView.OnEditorActionListener() {
			@Override
			public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
				if (id == EditorInfo.IME_ACTION_DONE || id == EditorInfo.IME_NULL) {
					attemptLogin();
					return true;
				}
				return false;
			}
		});
	}

	private void setLoginButtonListener() {
		btn_signin.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				attemptLogin();
			}
		});

	}

	private void attemptLogin() {

	}


}

