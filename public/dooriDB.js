
var firebaseConfig = {
    apiKey: "AIzaSyDz5_OVkk6NbkiwqMHe7cLFfRADs5cpKls",
    authDomain: "dodamproject-en.firebaseapp.com",
    databaseURL: "https://dodamproject-en.firebaseio.com",
    projectId: "dodamproject-en",
    storageBucket: "dodamproject-en.appspot.com",
    appId: "1:300480487895:web:1b4a1ec33ed6fbc99ceb92"
  };

firebase.initializeApp(firebaseConfig);
var database = firebase.database();
var ref = database.ref("category/numbers/"); //하위폴더 a,b있음

 ref.once("value", function(snapshot) {   //once = 변경을 수신대기하지 않고 단순히 데이터의 스냅샷만 필요할 때
  var card = snapshot.val();
  var img = document.getElementById('word-card');
  var img2 = document.getElementById('word-card-back');
  img.src = card.one[0];
  img2.src = card.one[1];

  console.log(card);
  console.log(card.one);
  console.log(card.two);
}, function(errorObject) {
  console.log("The read failed:" + errorObject);
});

var state = 0;

function changeImage() {
  if(state == 0) {
    state = 1;

    ref.once("value", function(snapshot) {
     var card = snapshot.val();
     var img = document.getElementById('grape-card');
     img.src = card.a[1];

    }, function(errorObject) {
     console.log("The read failed:" + errorObject);
    });
  }
  else {
    state = 0;
    ref.once("value", function(snapshot) {
     var card = snapshot.val();
     var img = document.getElementById('grape-card');
     img.src = card.a[0];

   }, function(errorObject) {
     console.log("The read failed:" + errorObject);
   });
  }
}
