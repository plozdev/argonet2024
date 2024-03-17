package com.example.appdemo.database;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.appdemo.R;

import java.util.List;

public class ModelAdapter extends BaseAdapter {
    List<Model> models;
    Context context;


    @Override
    public int getCount() {
        return models==null?0: models.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View viewModel;
        if (convertView==null) {
            viewModel = View.inflate(parent.getContext(), R.layout.child_item_layout, null);
        } else {
            viewModel = convertView;
        }

        Model model = models.get(position);
        String ac1,ac2,ac3,ac4;
        ac1 = model.getAcc1();
        ac2 = model.getAcc2();
        ac3 = model.getAcc3();
        ac4 = model.getAcc4();

        TextView title,timeTitle,n,p,k,temp,humid,rain,ph,nhan1,nhan2,nhan3,nhan4;
        title = viewModel.findViewById(androidx.core.R.id.title);
        timeTitle = viewModel.findViewById(R.id.timeTitle);
        n = viewModel.findViewById(R.id.childItemN);
        p = viewModel.findViewById(R.id.childItemP);
        k = viewModel.findViewById(R.id.childItemK);
        temp = viewModel.findViewById(R.id.childItemTemp);
        humid = viewModel.findViewById(R.id.childItemHumid);
        rain = viewModel.findViewById(R.id.childItemRainfall);
        ph = viewModel.findViewById(R.id.childItempH);

        nhan1 = viewModel.findViewById(R.id.nhan1tv);
        nhan2 = viewModel.findViewById(R.id.nhan2tv);
        nhan3 = viewModel.findViewById(R.id.nhan3tv);
        nhan4 = viewModel.findViewById(R.id.nhan4tv);

        title.setText(model.getTitle());
        timeTitle.setText(model.getTimeTitle());
        n.setText(model.getNito());
        p.setText(model.getPhotpho());
        k.setText(model.getKali());
        temp.setText(model.getTemp());
        humid.setText(model.getHumid());
        rain.setText(model.getRainfall());
        ph.setText(model.getPh());
        nhan1.setText("Nhãn 1: " + model.getNhan1());
        nhan2.setText("Nhãn 2: " + model.getNhan2());
        nhan3.setText("Nhãn 3: " + model.getNhan3());
        nhan4.setText("Nhãn 4: " + model.getNhan4());

        return null;
    }
}
