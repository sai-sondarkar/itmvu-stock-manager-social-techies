package xyz.nvrsettle.itmvustockm.Activities;

import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.support.v7.app.ActionBar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;

import java.util.ArrayList;
import java.util.List;

import io.paperdb.Paper;
import xyz.nvrsettle.itmvustockm.Adapters.ItemsDetailAdapter;
import xyz.nvrsettle.itmvustockm.Classes.ItemModel;
import xyz.nvrsettle.itmvustockm.R;

public class MainActivity extends AppCompatActivity {

    List<ItemModel> itemModelList = new ArrayList<>();

    ListView listView;
    ItemsDetailAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.list_item);
        adapter = new ItemsDetailAdapter(this,itemModelList);
        listView.setAdapter(adapter);
        Paper.init(this);
        InitUiElements();
        showTheList();
    }

    public void InitUiElements(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("");
    }

    public void InitDialogElements(){

        boolean wrapInScrollView = true;

        MaterialDialog.Builder  builder = new MaterialDialog.Builder(this)
                .title("Enter New Item Into our Software")
                .customView(R.layout.custom_item, wrapInScrollView)
                .positiveText("confirm");

        MaterialDialog dialog = builder.build();

        View view = dialog.getCustomView();

        final EditText ed_name = (EditText) view.findViewById(R.id.ed_name);
        final EditText ed_desp = (EditText) view.findViewById(R.id.ed_desp);
        final EditText ed_number = (EditText) view.findViewById(R.id.ed_number);
        final EditText ed_price = (EditText) view.findViewById(R.id.ed_price);

        dialog.getBuilder().onPositive(new MaterialDialog.SingleButtonCallback() {
            @Override
            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {

                ItemModel itemModel = new ItemModel();

                itemModel.setNameOfTheItem(ed_name.getText().toString());
                itemModel.setDescriptionOfTheItem(ed_desp.getText().toString());
                itemModel.setPrice(Float.parseFloat(ed_price.getText().toString()));
                itemModel.setStockWithUs(Integer.parseInt(ed_number.getText().toString()));

                itemModelList.add(itemModel);
                adapter.add(itemModel);
//                adapter.notifyDataSetChanged();
                Paper.book().write("list",itemModelList); // stored our data into an NoSQL Data base very simply.

                // so we have a item stored in a list right now.
            }
        });

        dialog.show();
    }

    public void showTheList(){

        itemModelList = Paper.book().read("list",new ArrayList<ItemModel>());
        adapter.addAll(itemModelList);
//        adapter.notifyDataSetChanged();
        // we will be create the things in it.
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.add_button:
                Toast.makeText(getApplicationContext(),"Add button clicked",Toast.LENGTH_SHORT).show();
                InitDialogElements();
                break;
            default:
                Toast.makeText(getApplicationContext(),"Not working",Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }
}
