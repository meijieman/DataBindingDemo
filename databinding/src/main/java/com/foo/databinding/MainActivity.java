package com.foo.databinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.foo.databinding.databinding.ActivityMainBinding;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
       final ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        final Person person = new Person();
        person.setAge(8);
        person.setName("小明");
        person.setBoy(true);
        binding.setPerson(person);

        binding.btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                person.setBoy(false);
                int age = new Random().nextInt(20);
                person.setAge(age);
                person.setName("小华");
                // 注意调用 set()
                person.count.set(age);
                person.like.set("zzzzz");
            }
        });

    }
}
