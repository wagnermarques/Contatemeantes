package br.com.contatemeantes;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class FirebaseFeatures {
    private static int i = 0;
    public static void SaveDocument(String coll) {
        Log.d("#!#!#!#!#", "FirebaseFeatures.SaveDocument(String collection){...");

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        Map<String, Object> user = new HashMap<>();
        user.put("dateTime", new Date().toString());
        user.put("value", FirebaseFeatures.i++);

        // Add a new document with a generated ID
        db.collection(coll)
                .add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        final int d = Log.d("#####", "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.d("#####", "Error adding document", e);
                    }
                });
    }//public static void SaveDocument(String collection) {
}
