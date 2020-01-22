// Set the configuration for your app
  // TODO: Replace with your app's config object
  var firebaseConfig = {
    apiKey: 'AIzaSyDlmBurVxPlpPCj60BfHTXKXLCC-75w6g8',
    authDomain: 'dodamproject-b11e9.firebaseapp.com',
    databaseURL: 'https://dodamproject-b11e9.firebaseio.com',
    storageBucket: 'gs://dodamproject-b11e9.appspot.com/'
  };
  firebase.initializeApp(firebaseConfig);

  // Get a reference to the storage service, which is used to create references in your storage bucket
  var storage = firebase.storage();
