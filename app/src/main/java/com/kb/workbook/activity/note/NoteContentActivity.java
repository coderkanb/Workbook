package com.kb.workbook.activity.note;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.kb.workbook.BaseActivity;
import com.kb.workbook.R;
import com.kb.workbook.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

public class NoteContentActivity extends BaseActivity implements AdapterView.OnItemClickListener {

    private List<String> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_content);

        data = new ArrayList<>();
        ListView listView = (ListView) findViewById(R.id.note_content_listview);
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, getData());
        listView.setAdapter(stringArrayAdapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void initParams(Bundle params) {

    }

    @Override
    public int bindLayout() {
        return 0;
    }

    @Override
    public void widgetClick(View v) {

    }

    public List<String> getData() {
        data.clear();
        data.add("ViewPager的使用");
        return data;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        ToastUtils.showShort(data.get(i));
        switch (i) {
            case 0:
                startActivity(ViewPagerActivity.class);
                break;

            default:
                break;
        }
    }
}
