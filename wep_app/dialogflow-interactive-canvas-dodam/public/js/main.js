/* eslint-disable no-invalid-this */
/**
 * Copyright 2019 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

//'use strict';

// imageUrlFront = new Array(3);
// imageUrlBack = new Array(3);
// soundUrl = new Array(3);


var xhr = new XMLHttpRequest();
this.jsonResult;
var imageUrlFront = new Array("1","2","3");
var imageUrlBack = new Array(3);
var soundUrl = new Array(3);


window.onload = () => {
  this.scene = new Scene();

  // Set Google Assistant Canvas Action at scene level
  this.scene.action = new Action(scene);
  // Call setCallbacks to register interactive canvas
  this.scene.action.setCallbacks();
};


class Scene {
  /**
   * Initializes the game with visual components.
   */

  constructor() {

    const view = document.getElementById('view');

    // set up fps monitoring
    //   const stats = new Stats();
    //   view.getElementsByClassName('stats')[0].appendChild(stats.domElement);

    // initialize rendering and set correct sizing
    this.radio = window.devicePixelRatio; // 해상도 가져오기

    this.renderer = new PIXI.Application({ // 해당 기기의 사이즈
    width: view.clientWidth,
    height: view.clientHeight,
    antialias: true,
    transparent: true,
    resolution: this.radio
  }
);
document.body.appendChild(this.renderer.view); // this.rederer에 있는 뷰를 바디 안에다가 붙인다
// center stage and normalize scaling for all resolutions
PIXI.loader
.add([
  "images/backgrounds.jpg",
  "images/word.png",
  "images/number.png",
  "images/replay.png",
  "images/title.png",
  "images/포도사진.png",
  "images/포도글씨.png",
  "images/repeat.png",
  "images/home.png",
])
.on("progress", loadProgressHandler)
.load(setup); // 이미지 불러오는 코드인데 업어도됨.

function loadProgressHandler(loader, resource) {
  //Display the file `url` currently being loaded
  console.log("loading: " + resource.url);

  //Display the percentage of files currently loaded
  console.log("progress: " + loader.progress + "%");

}
function setup() {
  console.log("All files loaded");

}

var firebaseConfig = { //firebase DB연동 해서, 저장되어 있는 사진을 불러와서 업로드 할려고 했으나 실패.  134번줄 까지는 없어도 되는 코드임.
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

//  var xhr = new XMLHttpRequest();

  xhr.open("GET", "https://dodamproject-en.firebaseio.com/category/words/.json?orderBy=\"id\"&limitToFirst=3", true);
  xhr.send();
var name = "global";
  xhr.onreadystatechange = function() {
      if(xhr.status == 200 && xhr.readyState == 4) {
        this.jsonResult = JSON.parse(xhr.responseText);
        console.log(this.jsonResult);
        console.log("*************");

        name = "local";
        for(var i=0; i<this.jsonResult.length; i++) {
          soundUrl[i] = this.jsonResult[i].sound;
          imageUrlFront[i] = this.jsonResult[i].images[0];
          imageUrlBack[i] = this.jsonResult[i].images[1];
        }
        console.log(soundUrl[0]);
        console.log(imageUrlFront[0]);
        console.log(imageUrlBack[0]);
      }
    };

console.log(imageUrlFront[0]);

    //컨데이너 생성 및 위치 초기화.
    this.main = new PIXI.Container();
    this.main.position.set(0, 60);

    this.wordPage = new PIXI.Container();
    this.wordPage.position.set(0, 0);

    this.numberPage = new PIXI.Container();
    this.numberPage.position.set(0, 0);

    this.flagPage = new PIXI.Container();
    this.flagPage.position.set(0, 0);

    // 저장되어있는 사진을 불러오기.
    this.backgrounds = new PIXI.Sprite.from("images/backgrounds.jpg");
    this.title = new PIXI.Sprite.from("images/title.png");
    this.word = new PIXI.Sprite.from("images/word.png");
    this.number = new PIXI.Sprite.from("images/number.png");
    this.flag = new PIXI.Sprite.from("images/flag.png");
    this.appleImage = new PIXI.Sprite.from("images/apple.png");
    this.bananaImage = new PIXI.Sprite.from("images/banana.png");
    this.carImage = new PIXI.Sprite.from("images/car.png");
    this.bananaWriting = new PIXI.Sprite.from("images/banana_text.png");
    this.appleWriting = new PIXI.Sprite.from("images/apple_text.png");
    this.carWriting = new PIXI.Sprite.from("images/car_text.png");
    this.wordrepeat = new PIXI.Sprite.from("images/repeat.png");
    this.numberrepeat = new PIXI.Sprite.from("images/repeat.png");
    this.wordhome = new PIXI.Sprite.from("images/home.png");
    this.numberhome = new PIXI.Sprite.from("images/home.png");
    this.appleSound = new PIXI.sound.Sound.from('sound/apple.mp3');
    this.bananaSound = new PIXI.sound.Sound.from('sound/banana.mp3');
    this.carSound = new PIXI.sound.Sound.from('sound/car.mp3');
    this.oneSound = new PIXI.sound.Sound.from('sound/1.mp3');
    this.twoSound = new PIXI.sound.Sound.from('sound/2.mp3');
    this.threeSound = new PIXI.sound.Sound.from('sound/3.mp3');
    this.count1 = new PIXI.Sprite.from("images/count1.png");
    this.count2 = new PIXI.Sprite.from("images/count2.jpg");
    this.count3 = new PIXI.Sprite.from("images/count3.jpg");
    this.one = new PIXI.Sprite.from("images/one.png");
    this.two = new PIXI.Sprite.from("images/two.png");
    this.three = new PIXI.Sprite.from("images/three.png");
    this.franceimage = new PIXI.Sprite.from("images/france.png");
    this.francewriting = new PIXI.Sprite.from("images/france_text.png");
    this.koreaimage = new PIXI.Sprite.from("images/korea.png");
    this.koreawriting = new PIXI.Sprite.from("images/korea_text.png");
    this.canadaimage = new PIXI.Sprite.from("images/canada.png");
    this.canadawriting = new PIXI.Sprite.from("images/canada_text.png");
    this.koreaSound = new PIXI.sound.Sound.from('sound/korea.mp3');
    this.franceSound = new PIXI.sound.Sound.from('sound/france.mp3');
    this.canadaSound = new PIXI.sound.Sound.from('sound/canada.mp3');
    this.clapSound = new PIXI.sound.Sound.from('sound/clap_sound.mp3');
    this.flaghome = new PIXI.Sprite.from("images/home.png");
    this.flagrepeat = new PIXI.Sprite.from("images/repeat.png");


    //불러온 이미지 위치 지정.
    this.title.x = 270;
    this.title.y = 0;

    this.word.x = 30;
    this.word.y = 270;

    this.number.x = 360;
    this.number.y = 270;

    this.flag.x = 690;
    this.flag.y = 270;

    this.appleImage.x = 280;
    this.appleImage.y = 100;

    this.bananaImage.x = 280;
    this.bananaImage.y = 100;

    this.carImage.x = 280;
    this.carImage.y = 100;

    this.appleWriting.x = 280;
    this.appleWriting.y = 100;

    this.bananaWriting.x = 280;
    this.bananaWriting.y = 100;

    this.carWriting.x = 280;
    this.carWriting.y = 100;

    this.count1.x = 280;
    this.count1.y = 100;

    this.count2.x = 280;
    this.count2.y = 100;

    this.count3.x = 280;
    this.count3.y = 100;

    this.one.x = 280;
    this.one.y = 100;

    this.two.x = 280;
    this.two.y = 100;

    this.three.x = 280;
    this.three.y = 100;

    this.wordrepeat.x = 50;
    this.wordrepeat.y = 450;

    this.wordhome.x = 840;
    this.wordhome.y = 450;

    this.numberrepeat.x = 50;
    this.numberrepeat.y = 450;

    this.numberhome.x = 840;
    this.numberhome.y = 450;

    this.flaghome.x = 840;
    this.flaghome.y = 450;

    this.flagrepeat.x = 50;
    this.flagrepeat.y = 450;

    this.koreaimage.x = 280;
    this.koreaimage.y = 100;

    this.koreawriting.x = 280;
    this.koreawriting.y = 100;

    this.franceimage.x = 280;
    this.franceimage.y = 100;

    this.francewriting.x = 280;
    this.francewriting.y = 100;

    this.canadawriting.x = 280;
    this.canadawriting.y = 100;

    this.canadaimage.x = 280;
    this.canadaimage.y = 100;


    //불러온 이미지 크기 지정.
    this.word.scale.set(0.3);
    this.number.scale.set(0.3);
    this.flag.scale.set(0.3);
    this.title.scale.set(0.6);
    this.appleImage.scale.set(0.4);
    this.bananaImage.scale.set(0.4);
    this.carImage.scale.set(0.4);
    this.bananaWriting.scale.set(0.4);
    this.appleWriting.scale.set(0.4);
    this.carWriting.scale.set(0.4);
    this.wordrepeat.scale.set(0.2);
    this.wordhome.scale.set(0.2);
    this.count1.scale.set(0.4);
    this.count2.scale.set(0.4);
    this.count3.scale.set(0.4);
    this.one.scale.set(0.4);
    this.two.scale.set(0.4);
    this.three.scale.set(0.4);
    this.numberrepeat.scale.set(0.2);
    this.numberhome.scale.set(0.2);
    this.flaghome.scale.set(0.2);
    this.flagrepeat.scale.set(0.2);
    this.koreaimage.scale.set(0.4);
    this.koreawriting.scale.set(0.4);
    this.franceimage.scale.set(0.4);
    this.francewriting.scale.set(0.4);
    this.canadaimage.scale.set(0.4);
    this.canadawriting.scale.set(0.4);

    //화면에 띄움 renderer.stage 이용해서
    this.renderer.stage.addChild(this.backgrounds);
    this.renderer.stage.addChild(this.main);
    this.renderer.stage.addChild(this.wordPage);
    this.renderer.stage.addChild(this.numberPage);
    this.renderer.stage.addChild(this.flagPage);

    //초기 main UI 안에는 word, number, flag는 안보이게 함.
    this.wordPage.visible = false;
    this.numberPage.visible = false;
    this.flagPage.visible = false;

    //main container에 각각의 요소 추가.
    this.main.addChild(this.word);
    this.main.addChild(this.number);
    this.main.addChild(this.flag);
    this.main.addChild(this.title);

    //wordPage container에 각각의 요소 추가.
    this.wordPage.addChild(this.appleImage);
    this.wordPage.addChild(this.wordrepeat);
    this.wordPage.addChild(this.wordhome);
    this.wordPage.addChild(this.appleWriting);
    this.wordPage.addChild(this.bananaImage);
    this.wordPage.addChild(this.carImage);
    this.wordPage.addChild(this.bananaWriting);
    this.wordPage.addChild(this.carWriting);

    //numberPage container에 각각의 요소 추가.
    this.numberPage.addChild(this.count1);
    this.numberPage.addChild(this.numberrepeat);
    this.numberPage.addChild(this.numberhome);
    this.numberPage.addChild(this.one);
    this.numberPage.addChild(this.count2);
    this.numberPage.addChild(this.count3);
    this.numberPage.addChild(this.two);
    this.numberPage.addChild(this.three);

    //flagPage container에 각각의 요소 추가.
    this.flagPage.addChild(this.koreaimage);
    this.flagPage.addChild(this.flagrepeat);
    this.flagPage.addChild(this.flaghome);
    this.flagPage.addChild(this.koreawriting);
    this.flagPage.addChild(this.canadaimage);
    this.flagPage.addChild(this.canadawriting);
    this.flagPage.addChild(this.franceimage);
    this.flagPage.addChild(this.francewriting);

    //word card 첫 번째 문제에서는 다른 문제의 이미지들이 보이면 안됨.
    this.bananaImage.visible = false;
    this.bananaWriting.visible = false;
    this.carImage.visible = false;
    this.carWriting.visible = false;

    //number card 첫 번째 문제에서는 다른 문제의 이미지들이 보이면 안됨.
    this.count2.visible = false;
    this.two.visible = false;
    this.count3.visible = false;
    this.three.visible = false;

    //flag card 첫 번째 문제에서는 다른 문제의 이미지들이 보이면 안됨.
    this.franceimage.visible = false;
    this.francewriting.visible = false;
    this.canadaimage.visible = false;
    this.canadawriting.visible = false;

    //this.appleWriting.visible = false;

    //word card 클릭 시.
    this.word.interactive = true;
    this.word.buttonMode = true;
    this.word.on('pointerdown', () => {
      console.log("word pointerdown " );
      this.main.visible = false;
      this.wordPage.visible = true;
      this.appleImage.visible = true;
      this.appleWriting.visible = false;

      const that = this;
        console.log(`Request in flight`);
        that.action.canvas.sendTextQuery('word card')
            .then((res) => {
              if (res.toUpperCase() === 'SUCCESS') {
                console.log(`Request in flight: ${res}`);
              } else {
                console.log(`Request in flight: ${res}`);
              }
        });
    });

    //number card 클릭 시.
    this.number.interactive = true;
    this.number.buttonMode = true;
    this.number.on('pointerdown', () => {
      console.log("number pointerdown " );
      this.main.visible = false;
      this.numberPage.visible = true;
      this.count1.visible = true;
      this.one.visible = false;

      const that = this;
        console.log(`Request in flight`);
        that.action.canvas.sendTextQuery('number card')
            .then((res) => {
              if (res.toUpperCase() === 'SUCCESS') {
                console.log(`Request in flight: ${res}`);
              } else {
                console.log(`Request in flight: ${res}`);
              }
        });
    });

    //flag card 클릭 시.
    this.flag.interactive = true;
    this.flag.buttonMode = true;
    this.flag.on('pointerdown', () => {
      console.log("flag pointerdown " );
      this.main.visible = false;
      this.flagPage.visible = true;
      this.koreaimage.visible = true;
      this.koreawriting.visible = false;

      const that = this;
        console.log(`Request in flight`);
        that.action.canvas.sendTextQuery('flag')
            .then((res) => {
              if (res.toUpperCase() === 'SUCCESS') {
                console.log(`Request in flight: ${res}`);
              } else {
                console.log(`Request in flight: ${res}`);
              }
        });
    });

    //word card 안의 home 버튼 클릭시
    this.wordhome.interactive = true;
    this.wordhome.buttonMode = true;
    this.wordhome.on('pointerdown', () => {
      console.log("wordhome pointerdown " );
      this.main.visible = true;
      this.wordPage.visible = false;
      this.numberPage.visible = false;
      //this.bgm.play();
      const that = this;
        console.log(`Request in flight`);
        that.action.canvas.sendTextQuery('home')
            .then((res) => {
              if (res.toUpperCase() === 'SUCCESS') {
                console.log(`Request in flight: ${res}`);
              } else {
                console.log(`Request in flight: ${res}`);
              }
        });
    });

    //number card 안의 home 버튼 클릭시
    this.numberhome.interactive = true;
    this.numberhome.buttonMode = true;
    this.numberhome.on('pointerdown', () => {
      console.log("home pointerdown " );
      this.main.visible = true;
      this.wordPage.visible = false;
      this.numberPage.visible = false;
  //this.bgm.play();
  const that = this;
    console.log(`Request in flight`);
    that.action.canvas.sendTextQuery('home')
        .then((res) => {
          if (res.toUpperCase() === 'SUCCESS') {
            console.log(`Request in flight: ${res}`);
          } else {
            console.log(`Request in flight: ${res}`);
          }
    });
});

//flag card 안의 home 버튼 클릭시
this.flaghome.interactive = true;
this.flaghome.buttonMode = true;
this.flaghome.on('pointerdown', () => {
  console.log(" pointerdown " );
  this.main.visible = true;
  this.wordPage.visible = false;
  this.numberPage.visible = false;
  this.flagPage.visible = false;
  //this.bgm.play();
  const that = this;
    console.log(`Request in flight`);
    that.action.canvas.sendTextQuery('home')
        .then((res) => {
          if (res.toUpperCase() === 'SUCCESS') {
            console.log(`Request in flight: ${res}`);
          } else {
            console.log(`Request in flight: ${res}`);
          }
    });
});

    //사과 이미지 클릭 시
    this.appleImage.interactive = true;
    this.appleImage.buttonMode = true;
    this.appleImage.on('pointerdown', () => {
      console.log("appleImage pointerdown " );
      this.appleSound.play();
     console.log("touch!!");
    });

    //바나나 이미지 클릭 시
    this.bananaImage.interactive = true;
    this.bananaImage.buttonMode = true;
    this.bananaImage.on('pointerdown', () => {
      console.log("bananaImage pointerdown " );
      this.bananaSound.play();
     console.log("touch!!");
    });

    this.carImage.interactive = true;
    this.carImage.buttonMode = true;
    this.carImage.on('pointerdown', () => {
      console.log("carImage pointerdown " );
      this.carSound.play();
     console.log("touch!!");
    });

    //number card의 one 카드 클릭 시
    this.count1.interactive = true;
    this.count1.buttonMode = true;
    this.count1.on('pointerdown', () => {
      console.log("count1 pointerdown " );
      this.oneSound.play();
     console.log("touch!!");
    });

    this.count2.interactive = true;
    this.count2.buttonMode = true;
    this.count2.on('pointerdown', () => {
      console.log("count2 pointerdown " );
      this.twoSound.play();
     console.log("touch!!");
    });

    this.count3.interactive = true;
    this.count3.buttonMode = true;
    this.count3.on('pointerdown', () => {
      console.log("count3 pointerdown " );
      this.threeSound.play();
     console.log("touch!!");
    });

    //국기카드 안의 한국 카드 클릭 시
    this.koreaimage.interactive = true;
    this.koreaimage.buttonMode = true;
    this.koreaimage.on('pointerdown', () => {
      console.log("koreaimage pointerdown " );
      this.koreaSound.play();
     console.log("touch!!");
    });

    this.franceimage.interactive = true;
    this.franceimage.buttonMode = true;
    this.count3.on('pointerdown', () => {
      console.log("franceimage pointerdown " );
      this.franceSound.play();
     console.log("touch!!");
    });

    this.canadaimage.interactive = true;
    this.canadaimage.buttonMode = true;
    this.count3.on('pointerdown', () => {
      console.log("canadaimage pointerdown " );
      this.canadaSound.play();
     console.log("touch!!");
    });

    //word card 안의 repeat 이미지 클릭 시
    this.wordrepeat.interactive = true;
    this.wordrepeat.buttonMode = true;
    this.wordrepeat.on('pointerdown', () => {
      console.log("repeat pointerdown " );

      const that = this;
        console.log(`Request in flight`);
        that.action.canvas.sendTextQuery('repeat')
            .then((res) => {
              if (res.toUpperCase() === 'SUCCESS') {
                console.log(`Request in flight: ${res}`);
              } else {
                console.log(`Request in flight: ${res}`);
              }
        });
    });

    this.numberrepeat.interactive = true;
    this.numberrepeat.buttonMode = true;
    this.numberrepeat.on('pointerdown', () => {
      console.log("repeat pointerdown " );

      const that = this;
        console.log(`Request in flight`);
        that.action.canvas.sendTextQuery('repeat')
            .then((res) => {
              if (res.toUpperCase() === 'SUCCESS') {
                console.log(`Request in flight: ${res}`);
              } else {
                console.log(`Request in flight: ${res}`);
              }
        });
    });

    this.flagrepeat.interactive = true;
    this.flagrepeat.buttonMode = true;
    this.flagrepeat.on('pointerdown', () => {
      console.log("repeat pointerdown " );

      const that = this;
        console.log(`Request in flight`);
        that.action.canvas.sendTextQuery('repeat')
            .then((res) => {
              if (res.toUpperCase() === 'SUCCESS') {
                console.log(`Request in flight: ${res}`);
              } else {
                console.log(`Request in flight: ${res}`);
              }
        });
    });
  }
}
