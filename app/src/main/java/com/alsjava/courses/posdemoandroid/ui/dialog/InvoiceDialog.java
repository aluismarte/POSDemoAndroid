package com.alsjava.courses.posdemoandroid.ui.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alsjava.courses.posdemoandroid.R;
import com.alsjava.courses.posdemoandroid.model.CallBack;
import com.alsjava.courses.posdemoandroid.model.adapters.BuyAdapter;
import com.alsjava.courses.posdemoandroid.model.api.BuyAPI;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aluis on 11/16/19.
 */
public class InvoiceDialog extends Dialog implements CallBack<BuyAPI> {

    private Activity activity;

    private final List<BuyAPI> data = new ArrayList<>();

    public InvoiceDialog(final Activity activity) {
        super(activity);
        this.activity = activity;
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setCancelable(false);
        setContentView(R.layout.dialog_invoice);
//        Window window = getWindow();
//        if (window != null) {
//            window.setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
//        }
        AppCompatButton btnClose = findViewById(R.id.btnClose);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        RecyclerView rvProducts = findViewById(R.id.rvProducts);
        final BuyAdapter buyAdapter = new BuyAdapter(activity, data, this);
        rvProducts.setLayoutManager(new LinearLayoutManager(activity));
        rvProducts.setAdapter(buyAdapter);
        final AppCompatButton btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProductDialog productDialog = new ProductDialog(activity);
                productDialog.setOnDismissListener(new OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialog) {
                        BuyAPI buyAPI = productDialog.getBuyAPI();
                        if (buyAPI != null) {
                            data.add(buyAPI);
                            buyAdapter.notifyDataSetChanged();
                        }
                    }
                });
                productDialog.show();
            }
        });
    }

    @Override
    public void onResult(BuyAPI buyAPI) {
        Toast.makeText(activity, buyAPI.toString(), Toast.LENGTH_LONG).show();
        data.remove(buyAPI);
    }
}
