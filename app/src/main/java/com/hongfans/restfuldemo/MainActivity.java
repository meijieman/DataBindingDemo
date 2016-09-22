package com.hongfans.restfuldemo;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.hongfans.restfuldemo.databinding.ActivityMainBinding;
import com.hongfans.restfuldemo.model.GitHubModel;
import com.hongfans.restfuldemo.vm.MainViewModel;

public class MainActivity extends AppCompatActivity {

    private MainViewModel viewModel;
    private GitHubModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // dataBinding
        final ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewModel = new MainViewModel();
        binding.setModel(viewModel);
        model = new GitHubModel(viewModel);

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.setPb(true);
                model.getUser(binding.username.getText().toString());
            }
        });
    }

}
