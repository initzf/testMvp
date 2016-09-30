package com.love.imvp.ui.home;

import android.util.Log;

import com.google.gson.Gson;
import com.love.imvp.api.Api;
import com.love.imvp.mode.CZPV;
import com.love.imvp.mode.PolicyStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 作者：zf on 2016/6/12 14:47
 * 邮箱：initzf@126.com
 */
public class IndexPresenter implements IndexContract.Present {
    private static final String TAG = "IndexPresenter";
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
    public void sendPv() {
        CZPV czpv = new CZPV();
        czpv.setApp("cz");
        czpv.setUbt_client_version("1.0.0");
        czpv.setUbt_client_type("h5");
        czpv.setPvid("10086");
        czpv.setPrePVID("2");
        czpv.setUid("58064");
        czpv.setAccessTime("1465219604000");
        czpv.setLeaveTime("1465219604000");

        CZPV.DataEntity.AndroidEntity.ClickEntity entity = new CZPV.DataEntity.AndroidEntity.ClickEntity();
        entity.setId("btn1");
        entity.setTime("1465219604000");


        List<CZPV.DataEntity.AndroidEntity.ClickEntity> list = new ArrayList<>();
        list.add(entity);

        CZPV.DataEntity.AndroidEntity aentity = new CZPV.DataEntity.AndroidEntity();
        aentity.setVersion("4.1.4");
        aentity.setClick(list);

        CZPV.DataEntity dataEntity = new CZPV.DataEntity();
        dataEntity.setAndroid(aentity);

        czpv.setData(dataEntity);

        Gson gson = new Gson();
        String json = gson.toJson(czpv);
        Log.i(TAG, "login: "+json);

        final Call<String> stringCall = Api.getInstance().movieService.sendPv(json);
        stringCall.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.i(TAG, "onResponse: "+response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.i(TAG, "onFailure: "+t);
            }
        });
    }

    @Override
    public void start() {

    }
}
