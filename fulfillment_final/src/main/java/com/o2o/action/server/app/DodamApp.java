package com.o2o.action.server.app;

import com.google.actions.api.ActionRequest;
import com.google.actions.api.ActionResponse;
import com.google.actions.api.DialogflowApp;
import com.google.actions.api.ForIntent;
import com.google.actions.api.response.ResponseBuilder;
import com.google.actions.api.response.helperintent.HelperIntent;
import com.google.api.client.util.ArrayMap;
import com.google.api.services.actions_fulfillment.v2.model.*;
import com.google.api.services.dialogflow_fulfillment.v2.model.*;
import com.o2o.action.server.util.CommonUtil;
import jdk.jfr.Frequency;
import org.aspectj.weaver.IEclipseSourceContext;
import sun.security.krb5.internal.APReq;

import javax.smartcardio.CommandAPDU;
import java.util.*;
import java.util.concurrent.ExecutionException;

public class DodamApp extends DialogflowApp{
  int word_count = 1;
  int number_count = 1;
  int flag_count = 1;

    @ForIntent("welcome")
    public ActionResponse defaultWelcome(ActionRequest request) throws ExecutionException, InterruptedException {
        ResponseBuilder rb = getResponseBuilder(request);
        SimpleResponse simpleResponse = new SimpleResponse();
        HtmlResponse htmlResponse = new HtmlResponse();
        Map<String, Object> data = rb.getConversationData();
        data.clear();
        CommonUtil.printMapData(data);

        String input = CommonUtil.makeSafeString(request.getParameter("comebackhome"));

        Map<String, Object> home = new HashMap<>();

        if(!request.hasCapability("actions.capability.INTERACTIVE_CANVAS")){
            simpleResponse.setSsml("Sorry, this device does not support Interactive Canvas!");
            return rb.build();
        }
        //home을 제외한 모든 발화는 일반적인 welcome 인텐트.
        if(!input.equals("home")) {
           rb.add("Hi. welcome to dodam world. I am dodam Bot who will play a game with you. " +
          "shall we play word cards?, numbers? or flags?");
        }
        //home 이라는 발화를 했을 경우 첫 메인 페이지로
        else if(!CommonUtil.isEmptyString(input) && input.equals("home")){
          home.put("command", "HOME");
          htmlResponse.setUpdatedState(home);
          rb.add("This is the first screen");
          word_count = 1; //home 으로 들어갔을 경우 낱말 카드 문제 순서 초기화.
          number_count = 1; //home 으로 들어갔을 경우 숫자 카드 문제 순서 초기화.
          flag_count = 1 ; //home 으로 들어갔을 경우 국기 카드 문제 순서 초기화.
        }

        htmlResponse.setUrl("https://cantododam.firebaseapp.com/index.html");
        rb.add(htmlResponse);
        return rb.build();
    }

    @ForIntent("fallback")
    public ActionResponse defaultFallback(ActionRequest request) throws ExecutionException, InterruptedException {
        ResponseBuilder rb = getResponseBuilder(request);
        Map<String, Object> data = rb.getConversationData();
        SimpleResponse simpleResponse = new SimpleResponse();
        HtmlResponse htmlResponse = new HtmlResponse();
        //String query = CommonUtil.makeSafeString(request.getRawText());
        //data.put("query", query);
        //simpleResponse.setSsml("I don't understand. You can play a game with me. shall we play word cards? or numbers?");
        //htmlResponse.setUpdatedState(data);

        String intent = CommonUtil.makeSafeString(request.getIntent());

        //일반적인 fallback 대답. 문제에서의 잘못된 발화와 메인 UI에서의 잘못된 발화를 구별해야됨(아직 미완성)
        rb.add("I didn't get it. You can choose from word cards, numbers, or flags. Make a choice!");
        rb.add(htmlResponse);

        return rb.build();
    }

  @ForIntent("Card_word")
  public ActionResponse card_alphabet(ActionRequest request) throws  ExecutionException, InterruptedException {
    ResponseBuilder rb = getResponseBuilder(request);
    Map<String, Object> data = rb.getConversationData();
    SimpleResponse simpleResponse = new SimpleResponse();
    HtmlResponse htmlResponse = new HtmlResponse();
    CommonUtil.printMapData(data);

    String input = CommonUtil.makeSafeString(request.getRawText());
    String text = CommonUtil.makeSafeString(request.getParameter("WordCard"));

    Map<String, Object> apple_correct = new HashMap<>();
    Map<String, Object> wordgame = new HashMap<>();
    Map<String, Object> banana_correct = new HashMap<>();
    Map<String, Object> car_correct = new HashMap<>();

    // word card 인텐트로 들어왔을 경우 바로 문제 설명 및 첫번 째 문제 시작. , word count로 문제 순서 맞춰줌
    if((!CommonUtil.isEmptyString(input) && word_count == 1) || (text.equals("word")|| input.contains("word"))){
      rb.add("The word card game is played on the back when you pronounce the alphabet on the card. " +
        " On the back, there is a word with that alphabet written on it.  Let's start with the first question. " +
        "This is a fruit. It starts with the letter A. " + "It is round and red. What is this?");
      wordgame.put("command", "WORD_PAGE");
      htmlResponse.setUpdatedState(wordgame);
      word_count++;
    }

    //정답 맞추기
    if((!CommonUtil.isEmptyString(input) && word_count >= 2) || text.equals("apple") || text.equals("banana") || text.equals("car")){
      switch (text) {
        case "apple":
          if(word_count == 2) { //정답
            rb.add("great! It is a apple. apple was also made by Steve Jobs. Ha! ha! ha!. Do you want to pass on to the next question??");
            apple_correct.put("command", "APPLE_CORRECT");
            htmlResponse.setUpdatedState(apple_correct);
            break;
          }else  { //오답 ( fallback intent에서 구현 못해서 여기다가 구현 해놓음)
            rb.add("Try again. You can do it! Click on the picture to hear the word that corresponds to the picture. " +
              "Click the repeat button to hear the problem again!");
            break;
          }

        case "banana" :
          if(word_count == 3) {
            rb.add("congratulation! It is a banana. banana Bananas are good for children. " +
              "How about eating a banana today!?. " +
              " Do you want to pass on to the next question?? ");
            banana_correct.put("command", "BANANA_CORRECT");
            htmlResponse.setUpdatedState(banana_correct);
            break;
          }
          else{
            rb.add("Try again. You can do it! Click on the picture to hear the word that corresponds to the picture. " +
              "Click the repeat button to hear the problem again!");
            break;
          }

        case "car" :
          if(word_count == 4) {
            rb.add("correct! It is a car. and.. I was a car! na neun! cha! yoes seo! so I'm sad. heuk! heuk! heuk! " +
              " Do you want to pass on to the next question?? ");
            car_correct.put("command", "CAR_CORRECT");
            htmlResponse.setUpdatedState(car_correct);
            break;
          }else{
            rb.add("Try again. You can do it! Click on the picture to hear the word that corresponds to the picture. " +
              "Click the repeat button to hear the problem again!");
            break;
          }
        }
      }

    rb.add(htmlResponse);
    return rb.build();
  }

  @ForIntent("Card_word - yes")
  public ActionResponse card_alphabet_yes(ActionRequest request) throws  ExecutionException, InterruptedException {
    ResponseBuilder rb = getResponseBuilder(request);
    Map<String, Object> data = rb.getConversationData();
    SimpleResponse simpleResponse = new SimpleResponse();
    HtmlResponse htmlResponse = new HtmlResponse();
    CommonUtil.printMapData(data);

    String input = CommonUtil.makeSafeString(request.getRawText());

    Map<String, Object> banana = new HashMap<>();
    Map<String, Object> car = new HashMap<>();

    //사용자가 yes 발화 시 다음 문제.
    if(!CommonUtil.isEmptyString(input) && input.equals("yes")){
      switch (input){
        case "yes" :
          if(word_count == 2) {
            rb.add("good! next question! This is a fruit. This is yellow. " +
              "It begins with a letter b. This is what monkeys like. What is this?");
            banana.put("command", "BANANA");
            htmlResponse.setUpdatedState(banana);
            word_count++;
            break;
          }
          else if(word_count == 3){
            rb.add("ok! Last question! It begins with a letter c. It is so fast. It is convenient for humans." +
              "and You can ride this. what is this?");
            car.put("command", "CAR");
            htmlResponse.setUpdatedState(car);
            word_count++;
            break;
          }
      }
    }
    rb.add(htmlResponse);
    return rb.build();
  }

  //repeat 발화 시
  @ForIntent("Card_word - repeat")
  public ActionResponse card_alphabet_repeat(ActionRequest request) throws  ExecutionException, InterruptedException {
    ResponseBuilder rb = getResponseBuilder(request);
    Map<String, Object> data = rb.getConversationData();
    SimpleResponse simpleResponse = new SimpleResponse();
    HtmlResponse htmlResponse = new HtmlResponse();
    CommonUtil.printMapData(data);

    String input = CommonUtil.makeSafeString(request.getRawText());

    if((!CommonUtil.isEmptyString(input))){ //문제 순서에 맞게 repeat 발화.
      switch (word_count){
        case 2 :
          rb.add("This is a fruit. It starts with the letter A. It is round and red. What is this?");
          break;
        case 3 :
          rb.add("This is a fruit. This is yellow. " +
            "It begins with a letter b. This is what monkeys like. What is this?");
          break;
        case 4 :
          rb.add("It begins with a letter c. It is so fast. It is convenient for humans. " +
            "and You can ride this. what is this?");
          break;
      }
    }

    rb.add(htmlResponse);
    return rb.build();
  }

  //logic은 word card와 동일
  @ForIntent("Card_number")
  public ActionResponse card_number(ActionRequest request) throws  ExecutionException, InterruptedException {
    ResponseBuilder rb = getResponseBuilder(request);
    Map<String, Object> data = rb.getConversationData();
    SimpleResponse simpleResponse = new SimpleResponse();
    HtmlResponse htmlResponse = new HtmlResponse();
    CommonUtil.printMapData(data);

    String input = CommonUtil.makeSafeString(request.getRawText());
    String text = CommonUtil.makeSafeString(request.getParameter("NumberCard"));

    Map<String, Object> one_correct = new HashMap<>();
    Map<String, Object> numbergame = new HashMap<>();
    Map<String, Object> two_correct = new HashMap<>();
    Map<String, Object> three_correct = new HashMap<>();

    if((!CommonUtil.isEmptyString(input) && number_count == 1) || (text.equals("number")|| input.contains("number"))){
      rb.add("The number card game is to match the number of objects or animals in the picture. " +
        "If you get the right answer, you'll see the spelling for it on the back. It's the first question. " +
        "I see a teddy bear. How many of this?");
      numbergame.put("command", "NUMBER_PAGE");
      htmlResponse.setUpdatedState(numbergame);
      number_count++;
    }

    //정답 맞추기
    if((!CommonUtil.isEmptyString(input) && number_count >= 2) || text.equals("one") || text.equals("two") || text.equals("three")){
      switch (text) {
        case "one":
          if(number_count == 2) {
            rb.add("correct! It is one. It's really easy, isn't it? " +
              "Why don't you put a teddy bear by your bedside from today? It will protect you while you sleep!. " +
              " Do you want to pass on to the next question??");
            one_correct.put("command", "ONE_CORRECT");
            htmlResponse.setUpdatedState(one_correct);
            break;
          } else {
            rb.add("Try again. You can do it! Click on the picture to hear the word that corresponds to the picture. " +
              "Click the repeat button to hear the problem again!");
            break;
          }

        case "two" :
          if(number_count == 3) {
            rb.add("congratulation! It is two. Be careful when you use scissors. and" +
              " one plus one is two. And!!! one plus one is guiyomi!. ha! ha! ha!" +
              " sorry. Do you want to pass on to the next question?? ");
            two_correct.put("command", "TWO_CORRECT");
            htmlResponse.setUpdatedState(two_correct);
            break;
          }else {
            rb.add("Try again. You can do it! Click on the picture to hear the word that corresponds to the picture. " +
              "Click the repeat button to hear the problem again!");
            break;
          }

        case "three" :
          if(number_count == 4) {
            rb.add("unbelievable!! It is three. I love candy." +
              "If you eat too much candy, your teeth will rot, so don't eat too much. But... I don't have teeth ke.ke.ke!" +
              "Do you want to pass on to the next question?? ");
            three_correct.put("command", "THREE_CORRECT");
            htmlResponse.setUpdatedState(three_correct);
            break;
          }else {
            rb.add("Try again. You can do it! Click on the picture to hear the word that corresponds to the picture. " +
              "Click the repeat button to hear the problem again!");
            break;
          }
      }
    }

    rb.add(htmlResponse);
    return rb.build();
  }

  @ForIntent("Card_number - yes")
  public ActionResponse card_number_yes(ActionRequest request) throws  ExecutionException, InterruptedException {
    ResponseBuilder rb = getResponseBuilder(request);
    Map<String, Object> data = rb.getConversationData();
    SimpleResponse simpleResponse = new SimpleResponse();
    HtmlResponse htmlResponse = new HtmlResponse();
    CommonUtil.printMapData(data);

    String input = CommonUtil.makeSafeString(request.getRawText());

    Map<String, Object> two = new HashMap<>();
    Map<String, Object> three = new HashMap<>();


    //yes 발화 시 다음 문제.
    if(!CommonUtil.isEmptyString(input) && input.equals("yes")){
      switch (input){
        case "yes" :
          if(number_count == 2) {
            rb.add("good! next question! I see two scissors now. So how many are these??");
            two.put("command", "TWO");
            htmlResponse.setUpdatedState(two);
            number_count++;
            break;
          }

          else if(number_count == 3){
            rb.add("very nice! Last question! Now I have one candy and you have two. " +
              "How many candies do you and I have?");
            three.put("command", "THREE");
            htmlResponse.setUpdatedState(three);
            number_count++;
            break;
          }
        }
      }

    rb.add(htmlResponse);

    return rb.build();
  }

  @ForIntent("Card_number - repeat")
  public ActionResponse card_number_repeat(ActionRequest request) throws  ExecutionException, InterruptedException {
    ResponseBuilder rb = getResponseBuilder(request);
    Map<String, Object> data = rb.getConversationData();
    SimpleResponse simpleResponse = new SimpleResponse();
    HtmlResponse htmlResponse = new HtmlResponse();
    CommonUtil.printMapData(data);

    String input = CommonUtil.makeSafeString(request.getRawText());

    //repeat 발화 시
    if(!CommonUtil.isEmptyString(input)){
      switch (number_count){
        case 2 :
          rb.add("I see a teddy bear. How many of this?");
          break;
        case 3 :
          rb.add("I see two scissors now. So how many are these??");
          break;
        case 4 :
          rb.add("Now I have one candy and you have two. " +
            " How many candies do you and I have?");
          break;
      }
    }

    rb.add(htmlResponse);

    return rb.build();
  }


  @ForIntent("Card_flag")
  public ActionResponse card_flag(ActionRequest request) throws  ExecutionException, InterruptedException {
    ResponseBuilder rb = getResponseBuilder(request);
    Map<String, Object> data = rb.getConversationData();
    SimpleResponse simpleResponse = new SimpleResponse();
    HtmlResponse htmlResponse = new HtmlResponse();
    CommonUtil.printMapData(data);

    String input = CommonUtil.makeSafeString(request.getRawText());
    String text = CommonUtil.makeSafeString(request.getParameter("FlagCard"));

    Map<String, Object> southkorea_correct = new HashMap<>();
    Map<String, Object> flaggame = new HashMap<>();
    Map<String, Object> france_correct = new HashMap<>();
    Map<String, Object> canada_correct = new HashMap<>();

    if((!CommonUtil.isEmptyString(input) && flag_count == 1) || (text.equals("flag")|| input.contains("flag"))){
      rb.add("The flag card game is about the country of flags shown in the picture. If you get the right answer, you'll see the answer on the back. " +
        "Here's the first question. This country is in asian and a divided country. BTS is from here. What is this country?");
      flaggame.put("command", "FLAG_PAGE");
      htmlResponse.setUpdatedState(flaggame);
      flag_count++;
    }

    //정답 맞추기
    if((!CommonUtil.isEmptyString(input) && flag_count >= 2) || text.equals("korea") || text.equals("canada") || text.equals("france")){
      switch (text) {
        case "korea":
          if(flag_count == 2) {
            rb.add("great! This is south korea. This is Korea. Dodambot lives in Korea. Come and see me later. I will wait in Su-nae 3-dong, Bundang-gu, Seongnam-si, Gyeonggi-do. " +
              "Do you want to pass on to the next question?? ");
            southkorea_correct.put("command", "KOREA_CORRECT");
            htmlResponse.setUpdatedState(southkorea_correct);
            break;
          }else {
            rb.add("Try again. You can do it! Click on the picture to hear the word that corresponds to the picture. " +
              "Click the repeat button to hear the problem again!");
            break;
          }

        case "france" :
          if(flag_count == 3) {
            rb.add("congratulation! This is france. The capital of France is Paris. The Eiffel Tower is a very famous city! " +
              " Do you want to pass on to the next question?? ");
            france_correct.put("command", "FRANCE_CORRECT");
            htmlResponse.setUpdatedState(france_correct);
            break;
          }else {
            rb.add("Try again. You can do it! Click on the picture to hear the word that corresponds to the picture. " +
              "Click the repeat button to hear the problem again!");
            break;
          }

        case "canada" :
          if(flag_count == 4) {
            rb.add("correct! This is canada.  The capital of Canada is ottawa. Let's go to ottawa with me later." +
              " Do you want to pass on to the next question?? ");
            canada_correct.put("command", "CANADA_CORRECT");
            htmlResponse.setUpdatedState(canada_correct);
            break;
          }else {
            rb.add("Try again. You can do it! Click on the picture to hear the word that corresponds to the picture. " +
              "Click the repeat button to hear the problem again!");
            break;
          }
        }
      }

    rb.add(htmlResponse);
    return rb.build();
  }

  @ForIntent("Card_flag - yes")
  public ActionResponse card_flag_yes(ActionRequest request) throws  ExecutionException, InterruptedException {
    ResponseBuilder rb = getResponseBuilder(request);
    Map<String, Object> data = rb.getConversationData();
    SimpleResponse simpleResponse = new SimpleResponse();
    HtmlResponse htmlResponse = new HtmlResponse();
    CommonUtil.printMapData(data);

    String input = CommonUtil.makeSafeString(request.getRawText());

    Map<String, Object> france = new HashMap<>();
    Map<String, Object> canada = new HashMap<>();

    //yes 발화 시 다음 문제.
    if(!CommonUtil.isEmptyString(input) && input.equals("yes")){
      switch (input){
        case "yes" :
          if(flag_count == 2) {
            rb.add("good! next question! This country is in Europe! Napoleon is from this country! And this country won the most recent World Cup. What is this country?");
            france.put("command", "FRANCE");
            htmlResponse.setUpdatedState(france);
            flag_count++;
            break;
          }
          else if(flag_count == 3){
            rb.add("very nice! Last question! This country is in North America. Ice hockey is really famous! And maple syrup is really delicious country! What is this country?");
            canada.put("command", "CANADA");
            htmlResponse.setUpdatedState(canada);
            flag_count++;
            break;
          }
        }
      }

    rb.add(htmlResponse);
    return rb.build();
  }

  @ForIntent("Card_flag - repeat")
  public ActionResponse card_flag_repeat(ActionRequest request) throws  ExecutionException, InterruptedException {
    ResponseBuilder rb = getResponseBuilder(request);
    Map<String, Object> data = rb.getConversationData();
    SimpleResponse simpleResponse = new SimpleResponse();
    HtmlResponse htmlResponse = new HtmlResponse();
    CommonUtil.printMapData(data);

    String input = CommonUtil.makeSafeString(request.getRawText());

    //repeat 발화 시
    if((!CommonUtil.isEmptyString(input))){
      switch (flag_count){
        case 2 :
          rb.add("This country is an Asian country and a divided country. BTS is the idol of this country. What is this country?");
          break;
        case 3 :
          rb.add("This country is in Europe! Napoleon is from this country! And this country won the most recent World Cup. What is this country?");
          break;
        case 4 :
          rb.add("This country is in North America. Ice hockey is really famous! And maple syrup is really delicious country! What is this country?");
          break;
      }
    }

    rb.add(htmlResponse);
    return rb.build();
  }
}
