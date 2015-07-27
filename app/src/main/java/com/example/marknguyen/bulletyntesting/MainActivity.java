package com.example.marknguyen.bulletyntesting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    ArrayList<Event> itemArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Firebase.setAndroidContext(this);

        // Get a reference to our posts
        //Firebase ref = new Firebase("https://intense-fire-8521.firebaseio.com/post/-JudY_HUxeaFvnztu6h5");

        // Attach an listener to read the data at our posts reference
/*
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                System.out.println(snapshot.getValue());
                Map<String, Object> newPost = (Map<String, Object>) snapshot.getValue();
                System.out.println("category: " + newPost.get("category"));
                System.out.println("email: " + newPost.get("email"));
                System.out.println("hashtag: " + newPost.get("hashtag"));
                System.out.println("img: " + newPost.get("img"));
                System.out.println("info: " + newPost.get("info"));
                System.out.println("location: " + newPost.get("location"));
                System.out.println("name: " + newPost.get("name"));
                System.out.println("phone: " + newPost.get("phone"));
                System.out.println("title: " + newPost.get("title"));
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                System.out.println("The read failed: " + firebaseError.getMessage());
            }
        });*/

        //public String category;
        ///public String email;
        //public String hashtag;
        //public String img;
        //public String info;
        //public String location;
        //public String name;
        //public String phone;
        //public String title;

        // Get a reference to our posts

        Firebase ref = new Firebase("https://intense-fire-8521.firebaseio.com/post");

        itemArrayList = new ArrayList<Event>();
        //int index=0;

        ref.addChildEventListener(new ChildEventListener() {
            // Retrieve new posts as they are added to the database
            @Override
            public void onChildAdded(DataSnapshot snapshot, String previousChildKey) {
                Map<String, String> newPost = (Map<String, String>) snapshot.getValue();
                //System.out.println("Author: " + newPost.get("author"));
                //System.out.println("Title: " + newPost.get("title"));
                Event event = new Event(newPost.get("category"), newPost.get("email"),
                        newPost.get("hashtag"), newPost.get("img"),
                        newPost.get("info"), newPost.get("location"),
                        newPost.get("name"), newPost.get("phone"),
                        newPost.get("title"));
                System.out.println(event.category);
                System.out.println(event.email);
                System.out.println(event.hashtag);
                System.out.println(event.img);
                System.out.println(event.info);
                System.out.println(event.location);
                System.out.println(event.name);
                System.out.println(event.phone);
                System.out.println(event.title);
                Log.i("current size", String.valueOf(itemArrayList.size()));
                itemArrayList.add(event);
                Log.i("next size", String.valueOf(itemArrayList.size()));
            }

            // Get the data on a post that has changed
            @Override
            public void onChildChanged(DataSnapshot snapshot, String previousChildKey) {
                String title = (String) snapshot.child("title").getValue();
                System.out.println("The updated post title is " + title);
            }
            // Get the data on a post that has been removed
            @Override
            public void onChildRemoved(DataSnapshot snapshot) {
                String title = (String) snapshot.child("title").getValue();
                System.out.println("The blog post titled " + title + " has been deleted");
            }

            @Override
            public void onChildMoved (DataSnapshot snapshot, String string){

            }

            @Override
            public void onCancelled (FirebaseError error){

            }
        });
        createView();
    }

    public void createView(){
        if(itemArrayList.size()>0) {
            for (int i = 0; i < itemArrayList.size(); i++) {
                System.out.println(itemArrayList.get(i).category);
                System.out.println(itemArrayList.get(i).email);
                System.out.println(itemArrayList.get(i).hashtag);
                System.out.println(itemArrayList.get(i).img);
                System.out.println(itemArrayList.get(i).info);
                System.out.println(itemArrayList.get(i).location);
                System.out.println(itemArrayList.get(i).name);
                System.out.println(itemArrayList.get(i).phone);
                System.out.println(itemArrayList.get(i).title);
            }
        }
        else{
            System.out.println("no item added");
        }
    }

    public void checkItem(View view){
        if(itemArrayList.size()>0) {
            for (int i = 0; i < itemArrayList.size(); i++) {
                System.out.println(itemArrayList.get(i).category);
                System.out.println(itemArrayList.get(i).email);
                System.out.println(itemArrayList.get(i).hashtag);
                System.out.println(itemArrayList.get(i).img);
                System.out.println(itemArrayList.get(i).info);
                System.out.println(itemArrayList.get(i).location);
                System.out.println(itemArrayList.get(i).name);
                System.out.println(itemArrayList.get(i).phone);
                System.out.println(itemArrayList.get(i).title);
            }
        }
        else{
            System.out.println("no item added");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
