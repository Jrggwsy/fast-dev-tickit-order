package com.irinnovative.onepagesigninsignup;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.irinnovative.onepagesigninsignup.sql.Database;
import com.irinnovative.onepagesigninsignup.sql.User;

public class PassengerInformationDialog extends DialogFragment {

    public static PassengerInformationDialog newInstance() {
        Bundle args = new Bundle();
        PassengerInformationDialog fragment = new PassengerInformationDialog();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

       View view = inflater.inflate(R.layout.dialog_passenger_information, container, false);
       final EditText id = (EditText) view.findViewById(R.id.id);
       final EditText name = (EditText) view.findViewById(R.id.name);
       final EditText sex = (EditText) view.findViewById(R.id.sex);
       final EditText number = (EditText) view.findViewById(R.id.number);
       TextView complete = (TextView) view.findViewById(R.id.complete);

        final SharedPreferences sharedPreferences = getActivity().getSharedPreferences("user", 0);
        final String userName = sharedPreferences.getString("userName", "");
        final Database database = Database.newInstance(getActivity());
        final User user = database.getUser('"' + userName + '"');

        if (!TextUtils.isEmpty(user.getName())) {
            name.setText(user.getName());
        }
        if (!TextUtils.isEmpty(user.getSex())) {
            sex.setText(user.getSex());
        }
        if (!TextUtils.isEmpty(user.getNumber())) {
            number.setText(user.getNumber());
        }
        if (!TextUtils.isEmpty(user.getNumberId())) {
            id.setText(user.getNumberId());
        }

        complete.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                String mId = id.getText().toString();
                String mName = name.getText().toString();
                String mSex = sex.getText().toString();
                String mNumber = number.getText().toString();
                if (TextUtils.isEmpty(mId)) {
                    Toast.makeText(getActivity(), "身份证号码不可为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!personIdValidation(mId)) {
                    Toast.makeText(getActivity(), "请输入正确的身份证号码", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(mName)) {
                    Toast.makeText(getActivity(), "姓名不可为空", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(mSex)) {
                    Toast.makeText(getActivity(), "性别不可为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(mNumber)) {
                    Toast.makeText(getActivity(), "手机号码不可为空", Toast.LENGTH_SHORT).show();
                    return;
                }

                user.setNumberId(mId);
                user.setNumber(mNumber);
                user.setName(mName);
                user.setSex(mSex);
                database.upUser(user);
                dismiss();

            }
        });

        return view;
    }

    /**
     * 验证身份证号是否符合规则
     *
     * @param text 身份证号
     * @return
     */
    public boolean personIdValidation(String text) {
        String regx = "[0-9]{17}x";
        String reg1 = "[0-9]{15}";
        String regex = "[0-9]{18}";
        return text.matches(regx) || text.matches(reg1) || text.matches(regex);
    }

}