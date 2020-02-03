var config = {
  apiKey: "AIzaSyAmWvMWreibVluYelIYHel2X7xVLnAgeOo",
  authDomain: "test-db-f70aa.firebaseapp.com",
  databaseURL: "https://test-db-f70aa.firebaseio.com",
  projectId: "test-db-f70aa",
  storageBucket: "test-db-f70aa.appspot.com",
  messagingSenderId: "914895177413",
  appId: "1:914895177413:web:9e700ab83eaf8ffa6812ac",
  measurementId: "G-MGMCRK5JR9"
};

var storage = firebase.storage();
var gsRefernce = storage.refFromURL('gs://test-db-f70aa.appspot.com/images');
var storageRef = storage.ref();
var pathRefernce = storage.ref('images/image12.jpg');

storageRef.child('images/image12.jpg').getDownloadURL().then(function(url) {    //파일의 다운로드 URL가져오기
  var xhr = new XMLHttpRequest();
  xhr.responseType = 'blob';
  xhr.onload = function() {
    var blob = xhr.response;
    console.log(url);
  };
  xhr.open('GET', url, true);
  xhr.send();

  var img = document.getElementById('card-front');
  img.src = url;


}).catch(function(error) {
  switch (error.code) {
    case 'storage/unauthorized' :
      console.log("권한이 없습니다.");
      break;
    case 'storage/unknown' :
      console.log("알 수 없는 에러 발생");
      break;
    case 'storage/object-not-found' :
      console.log("파일이 존재하지 않음");
      break;
  }
});
