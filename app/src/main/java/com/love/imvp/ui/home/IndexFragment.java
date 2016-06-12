package com.love.imvp.ui.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.love.imvp.R;
import com.love.imvp.base.Parameter;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 作者：zf on 2016/6/12 14:09
 * 邮箱：initzf@126.com
 */
public class IndexFragment extends Fragment implements IndexContract.View{

    private IndexPresenter presenter;


    @Bind(R.id.tv_status)
    TextView tvStatus;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main,container,false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter = new IndexPresenter(this);


        presenter.getPolicyStatus(Parameter.getInstance().getparaMap());
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void userPolicy(int status) {
        tvStatus.setText(String.valueOf(status));
    }

    @Override
    public void setPresenter(IndexContract.Present presenter) {

    }
}
