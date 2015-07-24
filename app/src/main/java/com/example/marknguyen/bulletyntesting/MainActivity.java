package com.example.marknguyen.bulletyntesting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Firebase.setAndroidContext(this);

        // Get a reference to our posts
        Firebase ref = new Firebase("https://intense-fire-8521.firebaseio.com/post/-JudY_HUxeaFvnztu6h5");

        // Attach an listener to read the data at our posts reference

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
        });

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
        //Firebase ref = new Firebase("https://docs-examples.firebaseio.com/web/saving-data/fireblog/posts");
/*
        ref.addChildEventListener(new ChildEventListener() {
            // Retrieve new posts as they are added to the database
            @Override
            public void onChildAdded(DataSnapshot snapshot, String previousChildKey) {
                Map<String, Object> newPost = (Map<String, Object>) snapshot.getValue();
                System.out.println("Author: " + newPost.get("author"));
                System.out.println("Title: " + newPost.get("title"));
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
*/
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
