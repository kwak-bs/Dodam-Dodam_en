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

'use strict';

/**
 * This class is used as a wrapper for Google Assistant Canvas Action class
 * along with its callbacks.
 */
class Action {
  /**
   * @param {*} scene which serves as a container of all visual elements
   */
  constructor(scene) {
    this.canvas = window.interactiveCanvas;
    this.scene = scene;
    const that = this;
    this.commands = {
      CANADA_CORRECT : function(data) {
        that.scene.canadaimage.visible = false;
        that.scene.canadawriting.visible = true;
      },
      CANADA : function(data){
        that.scene.francewriting.visible = false;
        that.scene.canadaimage.visible = true;
      },
      FRANCE_CORRECT : function(data){
        that.scene.franceimage.visible = false;
        that.scene.francewriting.visible = true;
      },
      FRANCE : function(data){
        that.scene.koreawriting.visible = false;
        that.scene.franceimage.visible = true;
      },
      KOREA_CORRECT : function(data){
        that.scene.koreaimage.visible = false;
        that.scene.koreawriting.visible = true;
      },
      FLAG_PAGE : function(data){
        that.scene.main.visible = false;
        that.scene.numberPage.visible = false;
        that.scene.flagPage.visible = true;
        that.scene.koreaimage.visible = true;
        that.scene.koreawriting.visible = false;
        that.scene.franceimage.visible = false;
        that.scene.francewriting.visible = false;
        that.scene.canadaimage.visible = false;
        that.scene.canadawriting.visible = false;
      },
      THREE_CORRECT :function(data) {
        that.scene.count3.visible = false;
        that.scene.three.visible = true;
      },
      THREE :function(data) {
        that.scene.two.visible = false;
        that.scene.count3.visible = true;
      },
      TWO_CORRECT :function(data) {
        that.scene.count2.visible = false;
        that.scene.two.visible = true;
      },
      TWO :function(data) {
        that.scene.one.visible = false;
        that.scene.count2.visible = true;
      },
      ONE_CORRECT :function(data) {
        that.scene.count1.visible = false;
        that.scene.one.visible = true;
      },
      NUMBER_PAGE :function(data) {
        that.scene.main.visible = false;
        that.scene.numberPage.visible = true;
        that.scene.flagPage.visible = false;
        that.scene.count1.visible = true;
        that.scene.one.visible = false;
        that.scene.three.visible = false;
        that.scene.two.visible = false;
        that.scene.count2.visible = false;
        that.scene.count3.visible = false;
      },
      CAR_CORRECT :function(data) {
        that.scene.carImage.visible = false;
        that.scene.carWriting.visible = true;
      },
      CAR : function(data) {
        that.scene.carImage.visible = true;
        that.scene.bananaWriting.visible = false;
      },
      BANANA_CORRECT :function(data) {
        that.scene.bananaImage.visible = false;
        that.scene.bananaWriting.visible = true;
      },
      BANANA :function(data) {
        that.scene.bananaImage.visible = true;
        that.scene.appleWriting.visible = false;
        that.scene.appleImage.visible = false;
      },
      APPLE_CORRECT: function(data){
        that.scene.appleImage.visible = false;
        that.scene.appleWriting.visible = true;
        that.scene.clapSound.play();
      },
      HOME : function(data){
        that.scene.main.visible = true;
        that.scene.wordPage.visible = false;
        that.scene.numberPage.visible = false;
        that.scene.flagPage.visible = false;
      },
      WORD_PAGE: function(data){
        that.scene.main.visible = false;
        that.scene.wordPage.visible = true;
        that.scene.numberPage.visible = false;
        that.scene.flagPage.visible = false;
        that.scene.appleImage.visible = true;
        that.scene.appleWriting.visible = false;
        that.scene.carWriting.visible = false;
        that.scene.bananaImage.visible = false;
        that.scene.bananaWriting.visible = false;
        that.scene.carImage.visible = false;
      },
      TINT: function(data) {
        //that.scene.sprite.tint = data.tint;
        that.scene.visible = false;
      },
      SPIN: function(data) {
        that.scene.sprite.spin = data.spin;
      },
      RESTART_GAME: function(data) {
        that.scene.button.texture = that.scene.button.textureButton;
        that.scene.sprite.spin = true;
        that.scene.sprite.tint = 0x0000FF; // blue
        that.scene.sprite.rotation = 0;
      },
    };
  }

  /**
   * Register all callbacks used by Interactive Canvas
   * executed during scene creation time.
   *
   */
  setCallbacks() {
    const that = this;
    // declare interactive canvas callbacks
    const callbacks = {
      onUpdate(data) {
        try {
          that.commands[data.command.toUpperCase()](data);
        } catch (e) {
          // do nothing, when no command is sent or found
        }
      },
    };
    // called by the Interactive Canvas web app once web app has loaded to
    // register callbacks
    this.canvas.ready(callbacks);
  }
}
