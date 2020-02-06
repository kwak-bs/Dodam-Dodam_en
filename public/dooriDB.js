
var firebaseConfig = {
    apiKey: "AIzaSyDz5_OVkk6NbkiwqMHe7cLFfRADs5cpKls",
    authDomain: "dodamproject-en.firebaseapp.com",
    databaseURL: "https://dodamproject-en.firebaseio.com",
    projectId: "dodamproject-en",
    storageBucket: "dodamproject-en.appspot.com",
    messagingSenderId: "300480487895",
    appId: "1:300480487895:web:1b4a1ec33ed6fbc99ceb92"
  };

firebase.initializeApp(firebaseConfig);
var storage = firebase.database();
var database = firebase.database();

var xhr = new XMLHttpRequest();
xhr.open("GET", "https://dodamproject-en.firebaseio.com/category/numbers/.json");
xhr.send();

xhr.onreadystatechange = function() {
  if(xhr.readyState === XMLHttpRequest.DONE) {
    if(xhr.status == 200) {
      cardsJson = JSON.parse(xhr.responseText);
      var img = document.getElementById('word-card');
      img.src = cardsJson.two[0];

      console.log(img.src);
    }else {
      console.log("fail to load");
    }
  }
};
