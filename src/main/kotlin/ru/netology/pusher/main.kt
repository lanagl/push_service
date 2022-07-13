package ru.netology.pusher

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.Message
import java.io.FileInputStream


fun main() {
    val options = FirebaseOptions.builder()
        .setCredentials(GoogleCredentials.fromStream(FileInputStream("fcm.json")))
        .build()

    FirebaseApp.initializeApp(options)

    val message = Message.builder()
        .putData("action", "NEW_POST")
        .putData("content", """{
          "userId": 1,
          "userName": "Vasiliy",
          "postContent": "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."
        }""".trimIndent())
        .setToken("dJgIemnvRk6IIUYtnAendR:APA91bGl6rXWkFiNKDn_ahff5O_tA0RayZEWYtVm3-e9mEgxUFoF4KdBr-jbQc6gMCg2x4R-0Otsj5PkjFjy7md6GRo72SQuI9cmBpA6QWDmujWr24ITgryIfhnj82DGHxZnAw6uDvBd")
        .build()

    FirebaseMessaging.getInstance().send(message)
}
