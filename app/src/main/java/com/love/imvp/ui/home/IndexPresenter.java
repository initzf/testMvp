package com.love.imvp.ui.home;

import com.love.imvp.api.Api;
import com.love.imvp.mode.PolicyStatus;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 作者：zf on 2016/6/12 14:47
 * 邮箱：initzf@126.com
 */
public class IndexPresenter implements IndexContract.Present {

    private final IndexContract.View view;

    public IndexPresenter(IndexContract.View view) {
        this.view = view;
    }

    @Override
    public void getPolicyStatus(Map<String, String> map) {
        final Call<PolicyStatus> policyStatus = Api.getInstance().movieService.getPolicyStatus(map);
        policyStatus.enqueue(new Callback<PolicyStatus>() {
            @Override
            public void onResponse(Call<PolicyStatus> call, Response<PolicyStatus> response) {
                final PolicyStatus body = response.body();

                final int errFlag = body.getErrFlag();
                if(errFlag==1){
                    final PolicyStatus.ListEntity list = body.getList();
                    view.userPolicy(list.getPolicyStatus());
                }
            }

            @Override
            public void onFailure(Call<PolicyStatus> call, Throwable t) {

            }
        });
    }

    @Override
    public void start() {

    }
}
