//firebase 초기화 및 configuration

var database = firebase.database();
// Get a reference to the storage service, which is used to create references in your storage bucket
var storage = firebase.app().storage("gs://test-db-f70aa.appspot.com");


// Your web app's Firebase configuration
var firebaseConfig = {
apiKey: "AIzaSyAmWvMWreibVluYelIYHel2X7xVLnAgeOo",
authDomain: "test-db-f70aa.firebaseapp.com",
databaseURL: "https://test-db-f70aa.firebaseio.com",
projectId: "test-db-f70aa",
storageBucket: "test-db-f70aa.appspot.com",
messagingSenderId: "914895177413",
appId: "1:914895177413:web:9e700ab83eaf8ffa6812ac",
measurementId: "G-MGMCRK5JR9"
};
// Initialize Firebase

firebase.initializeApp(firebaseConfig);
firebase.analytics();

var admin = require('firebase-admin');

var serviceAccount = require("C:/Users/enfl8/test-db");

admin.initializeApp({
credential: admin.credential.cert(serviceAccount),
databaseURL: "https://test-db-f70aa.firebaseio.com"
});
