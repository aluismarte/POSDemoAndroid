package com.alsjava.courses.posdemoandroid.ui.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.text.Editable;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alsjava.courses.posdemoandroid.R;
import com.alsjava.courses.posdemoandroid.model.CallBack;
import com.alsjava.courses.posdemoandroid.model.adapters.ProductAdapter;
import com.alsjava.courses.posdemoandroid.model.api.BuyAPI;
import com.alsjava.courses.posdemoandroid.model.api.ProductAPI;
import com.alsjava.courses.posdemoandroid.model.communication.request.ProductRequest;
import com.alsjava.courses.posdemoandroid.model.communication.response.ProductResponse;
import com.alsjava.courses.posdemoandroid.utils.ServiceTool;

/**
 * Created by aluis on 11/16/19.
 */
public class ProductDialog extends Dialog implements CallBack<ProductAPI> {

    private Activity activity;
    private ProductAPI productAPI;
    private BuyAPI buyAPI;

    private ProductAdapter productAdapter;

    public ProductDialog(final Activity activity) {
        super(activity);
        this.activity = activity;
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setCancelable(false);
        setContentView(R.layout.dialog_product);
//        Window window = getWindow();
//        if (window != null) {
//            window.setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
//        }
        RecyclerView rvProducts = findViewById(R.id.rvProducts);
        productAdapter = new ProductAdapter(activity, this);
        rvProducts.setLayoutManager(new LinearLayoutManager(activity));
        rvProducts.setAdapter(productAdapter);
        final AppCompatEditText etQuantity = findViewById(R.id.etQuantity);
        final AppCompatButton btnOK = findViewById(R.id.btnOK);
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Editable etQuantityText = etQuantity.getText();
                    if (etQuantityText != null) {
                        int quantity = Integer.parseInt(etQuantityText.toString());
                        if (quantity <= 0) {
                            return;
                        }
                        buyAPI = new BuyAPI();
                        buyAPI.setPrice(productAPI.getPrice());
                        buyAPI.setQuantity(quantity);
                        buyAPI.setProduct(productAPI);
                        dismiss();
                    }
                } catch (Exception ignored) {
                }
            }
        });
        final AppCompatButton btnCancel = findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buyAPI = null;
                dismiss();
            }
        });
        ServiceTool.get().products(new ProductRequest(), new CallBack<ProductResponse>() {
            @Override
            public void onResult(ProductResponse productResponse) {
                if (productResponse != null) {
                    productAdapter.loadData(productResponse.getProducts());
                    activity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            productAdapter.notifyDataSetChanged();
                        }
                    });
                }
            }
        });
    }

    public BuyAPI getBuyAPI() {
        return buyAPI;
    }

    @Override
    public void onResult(ProductAPI productAPI) {
        this.productAPI = productAPI;
        productAdapter.notifyDataSetChanged();
        Toast.makeText(activity, productAPI.toString(), Toast.LENGTH_LONG).show();
    }
}
