package com.thiendn.coderschool.democardreader;

import android.app.DialogFragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.R.id.edit;

/**
 * Created by thiendn on 06/03/2017.
 */

public class SettingDialog extends DialogFragment {
    private Context mContext;
    private Spinner spinner;
    private EditText editText;
    private Button btnSave;
    private Listener mListener;
    public static SettingDialog newInstance(Context context, Listener listener) {
        SettingDialog f = new SettingDialog();
        f.setContext(context);
        f.setListener(listener);
        return f;
    }
    private void setContext(Context context){
        mContext = context;
    }

    private void setListener(Listener listener){
        mListener = listener;
    }
    public interface Listener{
        void onSaveButtonClick(String url);
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.setting_fragment, container);
        spinner = (Spinner) view.findViewById(R.id.spinner);
        editText = (EditText) view.findViewById(R.id.etIP);
        btnSave = (Button) view.findViewById(R.id.btnSave);
        getDialog().setTitle("Setting");
        final ArrayList<String> list = new ArrayList<>();
        list.add("HEROKU");
        list.add("LOCALHOST");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(mContext,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (list.get(position).equals("LOCALHOST")){
                    editText.setEnabled(true);
                }
                if (list.get(position).equals("HEROKU")){
                    editText.setEnabled(false);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url;
                if (spinner.getSelectedItem().equals("HEROKU")){
                    url = "https://jwl-api-v0.herokuapp.com/";
                }
                else url = "http://" + editText.getText().toString() + ":8080/";
                Toast.makeText(mContext, url, Toast.LENGTH_LONG).show();
                mListener.onSaveButtonClick(url);
                getDialog().dismiss();
            }
        });
        return view;
    }
}
