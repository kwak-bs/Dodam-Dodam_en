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
  var imageUrlFront = new Array(3);
  var imageUrlBack = new Array(3);
  var soundUrl = new Array(3);

  var xhr = new XMLHttpRequest();

  xhr.open("GET", "https://dodamproject-en.firebaseio.com/category/words/.json?orderBy=\"id\"&limitToFirst=3", true);
  xhr.send();

  xhr.onreadystatechange = function() {
      if(xhr.status == 200 && xhr.readyState == 4) {
        jsonResult = JSON.parse(xhr.responseText);
        console.log(jsonResult);
        console.log("*************");

        for(var i=1; i<jsonResult.length+1; i++) {
          soundUrl[i-1] = jsonResult[i].sound;
          imageUrlFront[i-1] = jsonResult[i].images[0];
          imageUrlBack[i-1] = jsonResult[i].images[1];
          console.log(soundUrl[i-1]);
          console.log(imageUrlFront[i-1]);
          console.log(imageUrlBack[i-1]);
        }
      }
    };
