package com.o2o.action.server.app;

import com.google.actions.api.ActionRequest;
import com.google.actions.api.ActionResponse;
import com.google.actions.api.DialogflowApp;
import com.google.actions.api.ForIntent;
import com.google.actions.api.response.ResponseBuilder;
import com.google.api.services.actions_fulfillment.v2.model.*;
import com.o2o.action.server.util.CommonUtil;
import com.o2o.action.server.util.CommonWord;

import javax.print.DocFlavor;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class testapp extends DialogflowApp {
  static int botwins = 0;
  static int playerwins = 0;
  static String elvis = "";


	@ForIntent("Default Welcome Intent")
	public ActionResponse defaultWelcome(ActionRequest request) throws ExecutionException, InterruptedException {
		ResponseBuilder rb = getResponseBuilder(request);
		List<String> suggestions = new ArrayList<String>();
		SimpleResponse simpleResponse = new SimpleResponse();
		BasicCard basicCard = new BasicCard();

		Map<String, Object> data = rb.getConversationData();


		data.clear();
		CommonUtil.printMapData(data);

		simpleResponse.setTextToSpeech(" 안녕! 나는 엘비스. 가위바위봇이야! 나랑 3판 2선승제 가위바위보 게임하자! " +
      " 참고로 나는 날씨도 알려 줄 수 있어!")
				.setDisplayText(" 안녕! 나는 엘비스. 가위바위봇이야! 나랑 3판 2선승제 가위바위보 게임하자! "+
          " 참고로 나는 날씨도 알려 줄 수 있어!")
		;
		basicCard
				.setFormattedText("안녕하세요, 엘비스입니다.")
				.setImage(new Image().setUrl("https://actions.o2o.kr/content/telechips/telechipsaiperson_ko.gif")
						.setAccessibilityText("home"));

		rb.add(simpleResponse);
		rb.add(basicCard);
    suggestions.add("오늘 날씨 어때?");
    suggestions.add("가위바위보 하자!");

	  rb.addSuggestions(suggestions.toArray(new String[suggestions.size()]));
		return rb.build();
	}

  @ForIntent("Default Fallback Intent")
  public ActionResponse defaultFallback(ActionRequest request) throws ExecutionException, InterruptedException {
    ResponseBuilder rb = getResponseBuilder(request);
    List<String> suggestions = new ArrayList<String>();
    SimpleResponse simpleResponse = new SimpleResponse();
    BasicCard basicCard = new BasicCard();

    Map<String, Object> data = rb.getConversationData();

    data.clear();
    CommonUtil.printMapData(data);

    simpleResponse.setTextToSpeech("죄송해요. 다시 들려 주실래요?")
      .setDisplayText("죄송해요. 다시 들려 주실래요?")
    ;
    basicCard
      .setFormattedText("엘비스는 이해하지 못했어요")
      .setImage(new Image().setUrl("https://actions.o2o.kr/content/telechips/telechipsaiperson_ko.gif")
        .setAccessibilityText("home"));

    rb.add(simpleResponse);
    rb.add(basicCard);

    rb.addSuggestions(suggestions.toArray(new String[suggestions.size()]));
    return rb.build();
  }

  @ForIntent("RockScissorsPaper")
  public ActionResponse RockScissorsPaper(ActionRequest request) throws ExecutionException, InterruptedException {
    ResponseBuilder rb = getResponseBuilder(request);
    List<String> suggestions = new ArrayList<String>();
    SimpleResponse simpleResponse = new SimpleResponse();
    BasicCard basicCard = new BasicCard();
    double bot = Math.floor((Math.random() * 10) +1) %3;

    switch ((int) bot) {
      case 0 :
        elvis = "가위";
        break;
      case 1:
        elvis = "바위";
        break;
      case 2 :
        elvis = "보";
        break;
    }

    Map<String, Object> data = rb.getConversationData();

    data.clear();
    CommonUtil.printMapData(data);

    String input = CommonUtil.makeSafeString(request.getParameter("RockScissorsPaper"));

    if(!CommonUtil.isEmptyString(input) && input.equals("Rock") || input.equals("Scissors") || input.equals("Paper")) {
      switch (input) {
        case "Scissors":
          if (elvis.equals("가위")) {
              simpleResponse.setTextToSpeech("난 " + elvis + "!!" + " 비겼네. 다시 하자!")
                .setDisplayText("난 " + elvis + "!!" + " 비겼네. 다시 하자!"+"\n"
                  +"플레이어 : " +playerwins+" 엘비스 : "+botwins);
            if((botwins == 0 || botwins == 1) && (playerwins == 0 || playerwins == 1)) {
              suggestions.add("가위");
              suggestions.add("바위");
              suggestions.add("보");
            }
          } else if (elvis.equals("바위")) {
            simpleResponse.setTextToSpeech("난 " + elvis + "!!" + " 헤헤 내가 이겼당!")
              .setDisplayText("난 " + elvis + "!!" + " 헤헤 내가 이겼당!"+"\n"
                +"플레이어 : " +playerwins+" 엘비스 : "+(++botwins));
            if((botwins == 0 || botwins == 1) && (playerwins == 0 || playerwins == 1)) {
              suggestions.add("가위");
              suggestions.add("바위");
              suggestions.add("보");
            }
          } else if (elvis.equals("보")) {
            simpleResponse.setTextToSpeech("난 " + elvis + "!!" + " 이런 내가 졌네, 계속해!")
              .setDisplayText("난 " + elvis + "!!" + " 이런 내가 졌네, 계속해!"+"\n"
                +"플레이어 : " +(++playerwins)+" 엘비스 : "+botwins);
            if((botwins == 0 || botwins == 1) && (playerwins == 0 || playerwins == 1)) {
              suggestions.add("가위");
              suggestions.add("바위");
              suggestions.add("보");
            }
          }
          break;
        case "Rock":
          if (elvis.equals("가위")) {
            simpleResponse.setTextToSpeech("난 " + elvis + "!!" + " 이런 내가 졌네, 계속해!")
              .setDisplayText("난 " + elvis + "!!" + " 이런 내가 졌네, 계속해!"+"\n"
                +"플레이어 : " +(++playerwins)+" 엘비스 : "+botwins);
            if((botwins == 0 || botwins == 1) && (playerwins == 0 || playerwins == 1)) {
              suggestions.add("가위");
              suggestions.add("바위");
              suggestions.add("보");
            }

          } else if (elvis.equals("바위")) {
            simpleResponse.setTextToSpeech("난 " + elvis + "!!" + " 비겼네. 다시 하자!")
              .setDisplayText("난 " + elvis + "!!" + " 비겼네. 다시 하자!"+"\n"
                +"플레이어 : " +playerwins+" 엘비스 : "+botwins);
            if((botwins == 0 || botwins == 1) && (playerwins == 0 || playerwins == 1)) {
              suggestions.add("가위");
              suggestions.add("바위");
              suggestions.add("보");
            }

          } else if (elvis.equals("보")) {
            simpleResponse.setTextToSpeech("난 " + elvis + "!!" + " 헤헤 내가 이겼당!")
              .setDisplayText("난 " + elvis + "!!" + " 헤헤 내가 이겼당!"+"\n"
                +"플레이어 : " +playerwins+" 엘비스 : "+(++botwins));
            if((botwins == 0 || botwins == 1) && (playerwins == 0 || playerwins == 1)) {
              suggestions.add("가위");
              suggestions.add("바위");
              suggestions.add("보");
            }
          }
          break;
        case "Paper":
          if (elvis.equals("가위")) {
            simpleResponse.setTextToSpeech("난 " + elvis + "!!" + " 헤헤 내가 이겼당!")
              .setDisplayText("난 " + elvis + "!!" + " 헤헤 내가 이겼당!"+"\n"
                +"플레이어 : " +playerwins+" 엘비스 : "+(++botwins));
            if((botwins == 0 || botwins == 1) && (playerwins == 0 || playerwins == 1)) {
              suggestions.add("가위");
              suggestions.add("바위");
              suggestions.add("보");
            }
          } else if (elvis.equals("바위")) {
            simpleResponse.setTextToSpeech("난 " + elvis + "!!" + " 이런 내가 졌네, 계속해! ")
              .setDisplayText("난 " + elvis + "!!" + " 이런 내가 졌네, 계속해!"+"\n"
                +"플레이어 : " +(++playerwins)+" 엘비스 : "+botwins);
            if((botwins == 0 || botwins == 1) && (playerwins == 0 || playerwins == 1)) {
              suggestions.add("가위");
              suggestions.add("바위");
              suggestions.add("보");
            }
          } else if (elvis.equals("보")) {
            simpleResponse.setTextToSpeech("난 " + elvis + "!!" + "비겼네. 다시 하자!")
              .setDisplayText("난 " + elvis + "!!" + "비겼네. 다시 하자!"+"\n"
                +"플레이어 : " +playerwins+" 엘비스 : "+botwins);
            if((botwins == 0 || botwins == 1) && (playerwins == 0 || playerwins == 1)) {
              suggestions.add("가위");
              suggestions.add("바위");
              suggestions.add("보");
            }
          }
          break;
        }
      }

    if(!CommonUtil.isEmptyString(input) && input.equals("RSP")) {
      simpleResponse.setTextToSpeech("그래!! 가위바위보 중에서 하나를 골라봐.")
        .setDisplayText("그래!! 가위바위보 중에서 하나를 골라봐.");
      botwins = 0;
      playerwins = 0;

        suggestions.add("가위");
        suggestions.add("바위");
        suggestions.add("보");
    }

    if(!CommonUtil.isEmptyString(input) && input.equals("b2oo3")) {
      simpleResponse.setTextToSpeech("후후후.. 자신있나요?")
        .setDisplayText("후후후 자신있나요?");
      suggestions.add("후달리냐?");
    }

    if(!CommonUtil.isEmptyString(input) && input.equals("joke1")) {
      simpleResponse.setTextToSpeech("후달려? 오냐. 내 돈 모두 하고 내 손모가지를 건다. 넌 무엇을 걸래?")
        .setDisplayText("후달려? 오냐. 내 돈 모두 하고 내 손모가지를 건다. 넌 무엇을 걸래?");
      suggestions.add("꼭 그렇게 피를 봐야겠어?");
    }

    if(!CommonUtil.isEmptyString(input) && input.equals("joke2")) {
      simpleResponse.setTextToSpeech("쫄리냐? 쫄리면 뒈지시던지.")
        .setDisplayText("쫄리냐? 쫄리면 뒈지시던지.");
      botwins = 0;
      playerwins = 0;
      suggestions.add("가위");
      suggestions.add("바위");
      suggestions.add("보");
      suggestions.add("안해");
    }

    if(playerwins == 1 && botwins == 1 && !CommonUtil.isEmptyString(input)
      && input.equals("joke3") || input.equals("joke4") || input.equals("joke5")){
      simpleResponse.setTextToSpeech("동작 그만.! 손가락 빼기냐?")
        .setDisplayText("동작 그만. 손가락 빼기냐?");
      suggestions.add("증거 있어?");
    }

    if(playerwins == 1 && botwins == 1 && !CommonUtil.isEmptyString(input)
      && input.equals("joke7")){
      simpleResponse.setTextToSpeech("증거? 증거 있지. 지금 너의 굉장히 어색하게 움직이고 있는 손가락.. " +
        "그게 증거 아냐? " + "손가락 움직이지마. 평생 가위바위보를 못하게 해주겠어. 해머 가져와")
        .setDisplayText("증거? 증거 있지. 지금 너의 굉장히 어색하게 움직이고 있는 손가락.. " +
          "그게 증거 아냐? " + "손가락 움직이지마. 평생 가위바위보를 못하게 해주겠어. 해머 가져와");
      suggestions.add("시나리오 쓰고있네.");
    }

    if(playerwins == 1 && botwins == 1 && !CommonUtil.isEmptyString(input)
      && input.equals("joke8")){
      simpleResponse.setTextToSpeech("아주 귀여운 친구구만. 그래. 이번만은 넘어가주도록 하지. 이제 더이상 돌이킬 수 없어. 준비되면 마지막 수를 꺼내도록 해.")
        .setDisplayText("아주 귀여운 친구구만. 그래. 이번만은 넘어가주도록 하지. 이제 더이상 돌이킬 수 없어. 준비되면 마지막 수를 꺼내도록 해.");
      suggestions.add("가위");
      suggestions.add("바위");
      suggestions.add("보");
    }

    if(playerwins == 2 ){
      simpleResponse.setTextToSpeech("너가 진정한 승리자야 축하해")
        .setDisplayText("플레이어 : " +playerwins+" 엘비스 : "+botwins+"\n"+
          "너가 진정한 승리자야 축하해");
      suggestions.add("다시 하자!");
      suggestions.add("안해");
      botwins = 0;
      playerwins = 0;
    }

    if(botwins == 2 ){
      simpleResponse.setTextToSpeech("이 엘비스가 승리했어. 조금 더 연습해와")
        .setDisplayText("플레이어 : " +playerwins+" 엘비스 : "+botwins+"\n"+
          "이 엘비스가 승리했어. 조금 더 연습해와");
      suggestions.add("다시 하자!");
      suggestions.add("안해");
      botwins = 0;
      playerwins = 0;
    }
    rb.add(simpleResponse);
    rb.addSuggestions(suggestions.toArray(new String[suggestions.size()]));
    return rb.build();
  }

  @ForIntent("weather")
  public ActionResponse weather(ActionRequest request) throws ExecutionException, InterruptedException {
    ResponseBuilder rb = getResponseBuilder(request);
    List<String> suggestions = new ArrayList<String>();
    SimpleResponse simpleResponse = new SimpleResponse();
    BasicCard basicCard = new BasicCard();

    Map<String, Object> data = rb.getConversationData();

    //String input = CommonUtil.makeSafeString(request.getParameter("weather"));
    String text = CommonUtil.makeSafeString(request.getRawText());
    data.clear();
    CommonUtil.printMapData(data);

    if(!CommonUtil.isEmptyString(text) && text.contains("춘천")){
      simpleResponse.setTextToSpeech("춘천의 날씨가 궁금하구나?")
        .setDisplayText("춘천의 날씨가 궁금하구나?")
      ;
      basicCard
        .setTitle("춘천 날씨")
        .setFormattedText("춘천 강원대학교 날씨 정보입니다.")
        .setImage(new Image().setUrl("https://lh3.googleusercontent.com/yhywHEAGpOOVNNrk2-cFYo-MBaPE4_77wKVs-a0440ROFDZteEhdeP4wn8ZeOBrPP7_c=w300")
          .setAccessibilityText("weather"))
        .setButtons(
          new ArrayList<Button>(
            Arrays.asList(
              new Button()
                .setTitle("상세 정보 링크.")
                .setOpenUrlAction(
                  new OpenUrlAction().setUrl("https://freemeteo.kr/weather/hyojai-dong/daily-forecast/today/?gid=6802305&language=korean&country=south-korea")
                )
            )
          )
        );
    }

    else if(!CommonUtil.isEmptyString(text) && text.contains("성남")){
      simpleResponse.setTextToSpeech("성남의 날씨가 궁금하구나?")
        .setDisplayText("성남의 날씨가 궁금하구나?")
      ;
      basicCard
        .setTitle("성남 날씨")
        .setFormattedText("성남 판교 기준 날씨 정보입니다.")
        .setImage(new Image().setUrl("https://lh3.googleusercontent.com/yhywHEAGpOOVNNrk2-cFYo-MBaPE4_77wKVs-a0440ROFDZteEhdeP4wn8ZeOBrPP7_c=w300")
          .setAccessibilityText("weather"))
        .setButtons(
          new ArrayList<Button>(
            Arrays.asList(
              new Button()
                .setTitle("상세 정보 링크.")
                .setOpenUrlAction(
                  new OpenUrlAction().setUrl("https://freemeteo.kr/weather/pangyo/daily-forecast/today/?gid=6575468&language=korean&country=south-korea")
                )
            )
          )
        );
    }

    else if(!CommonUtil.isEmptyString(text) && text.contains("오늘")){
      simpleResponse.setTextToSpeech("오늘의 날씨가 궁금하구나?")
        .setDisplayText("오늘의 날씨가 궁금하구나?")
      ;
      basicCard
        .setTitle("오늘 날씨")
        .setFormattedText("오늘 현재 위치 기반 날씨 정보입니다.")
        .setImage(new Image().setUrl("https://lh3.googleusercontent.com/yhywHEAGpOOVNNrk2-cFYo-MBaPE4_77wKVs-a0440ROFDZteEhdeP4wn8ZeOBrPP7_c=w300")
          .setAccessibilityText("weather"))
        .setButtons(
          new ArrayList<Button>(
            Arrays.asList(
              new Button()
                .setTitle("상세 정보 링크.")
                .setOpenUrlAction(
                  new OpenUrlAction().setUrl("https://www.weather.go.kr/w/weather/today.do")
                )
            )
          )
        );
    }

    else if(!CommonUtil.isEmptyString(text) && text.contains("내일")){
      simpleResponse.setTextToSpeech("내일의 날씨가 궁금하구나?")
        .setDisplayText("내일의 날씨가 궁금하구나?")
      ;
      basicCard
        .setTitle("내일 날씨")
        .setFormattedText("내일 현재 기반 날씨 정보입니다.")
        .setImage(new Image().setUrl("https://lh3.googleusercontent.com/yhywHEAGpOOVNNrk2-cFYo-MBaPE4_77wKVs-a0440ROFDZteEhdeP4wn8ZeOBrPP7_c=w300")
          .setAccessibilityText("weather"))
        .setButtons(
          new ArrayList<Button>(
            Arrays.asList(
              new Button()
                .setTitle("상세 정보 링크.")
                .setOpenUrlAction(
                  new OpenUrlAction().setUrl("https://www.weather.go.kr/w/weather/today.do")
                )
            )
          )
        );
    }

    else if(!CommonUtil.isEmptyString(text) && text.contains("이번주")){
      simpleResponse.setTextToSpeech("이번 주 날씨가 궁금하구나?")
        .setDisplayText("이번 주 날씨가 궁금하구나?")
      ;
      basicCard
        .setTitle("이번 주 날씨")
        .setFormattedText("이번 주 현재 위치 기반 날씨 정보입니다.")
        .setImage(new Image().setUrl("https://lh3.googleusercontent.com/yhywHEAGpOOVNNrk2-cFYo-MBaPE4_77wKVs-a0440ROFDZteEhdeP4wn8ZeOBrPP7_c=w300")
          .setAccessibilityText("weather"))
        .setButtons(
          new ArrayList<Button>(
            Arrays.asList(
              new Button()
                .setTitle("상세 정보 링크입니다. 링크를 클릭 후 하단으로 내리세요.")
                .setOpenUrlAction(
                  new OpenUrlAction().setUrl("https://www.weather.go.kr/w/weather/today.do")
                )
            )
          )
        );
    }

    rb.add(simpleResponse);
    rb.add(basicCard);

    rb.addSuggestions(suggestions.toArray(new String[suggestions.size()]));
    return rb.build();
  }
}

