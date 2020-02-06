package com.o2o.action.server.app;

import com.google.actions.api.ActionRequest;
import com.google.actions.api.ActionResponse;
import com.google.actions.api.DialogflowApp;
import com.google.actions.api.ForIntent;
import com.google.actions.api.response.ResponseBuilder;
import com.google.api.client.json.webtoken.JsonWebSignature;
import com.google.api.services.actions_fulfillment.v2.model.BasicCard;
import com.google.api.services.actions_fulfillment.v2.model.HtmlResponse;
import com.google.api.services.actions_fulfillment.v2.model.SimpleResponse;
import com.o2o.action.server.util.CommonUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class DodamDodam_eng extends DialogflowApp {

	@ForIntent("Default Welcome Intent")
	public ActionResponse defaultWelcome(ActionRequest request) throws ExecutionException, InterruptedException {
    ResponseBuilder rb = getResponseBuilder(request);
    List<String> suggestions = new ArrayList<String>();
    HtmlResponse htmlResponse = new HtmlResponse();
		Map<String, Object> data = rb.getConversationData();
		data.clear();
		CommonUtil.printMapData(data);

    String input = CommonUtil.makeSafeString(request.getParameter("comebackhome"));

   htmlResponse.setUrl("https://dodamproject-en.web.app/index.html");

    if(!input.equals("home")) {
      rb.add("Welcome to Dodam Dodam. I'm a Dodam Fairy to help you guys. " +
        "Shall we play word cards? OR numbers?");
    }
    else if(!CommonUtil.isEmptyString(input) && input.equals("home")){
      rb.add("This is the first screen");
    }

    rb.add(htmlResponse);
		//rb.addSuggestions(suggestions.toArray(new String[suggestions.size()]));
		return rb.build();
	}

	@ForIntent("Default Fallback Intent")
  public ActionResponse defaultFallback(ActionRequest request) throws ExecutionException, InterruptedException {
    ResponseBuilder rb = getResponseBuilder(request);
    List<String> suggestions = new ArrayList<String>();
    SimpleResponse simpleResponse = new SimpleResponse();
    BasicCard basicCard = new BasicCard();
    HtmlResponse htmlResponse = new HtmlResponse();

    Map<String, Object> data = rb.getConversationData();
    data.clear();
    CommonUtil.printMapData(data);
      rb.add("I don't know what you're talking about. Can you say that again?");
   //   rb.add(htmlResponse);

    //rb.addSuggestions(suggestions.toArray(new String[suggestions.size()]));
    return rb.build();
  }

  @ForIntent("Card_word")
  public ActionResponse card_alphabet(ActionRequest request) throws ExecutionException, InterruptedException {
    ResponseBuilder rb = getResponseBuilder(request);
    List<String> suggestions = new ArrayList<String>();
    SimpleResponse simpleResponse = new SimpleResponse();
    BasicCard basicCard = new BasicCard();
    HtmlResponse htmlResponse = new HtmlResponse();
    Map<String, Object> data = rb.getConversationData();
    data.clear();
    CommonUtil.printMapData(data);
    htmlResponse.setUrl("https://dodamproject-en.web.app/game-1.html");

    String input = CommonUtil.makeSafeString(request.getRawText());
    String text = CommonUtil.makeSafeString(request.getParameter("WordCard"));
    int question_count = 1;
    int intent_count = 1;
    Map<String, Object> correct = new HashMap<>();

    if(!CommonUtil.isEmptyString(input)&& (text.equals("word")|| input.contains("word")||text.equals("card") || input.contains("card"))){
      rb.add("The word card game is played on the back when you pronounce the alphabet on the card. " +
        " On the back, there is a word with that alphabet written on it. " +
        " Pronounce the word!?");
    }

    if(!CommonUtil.isEmptyString(input) && text.equals("grape")){
      switch (text) {
        case "grape":
            rb.add("correct!");
//            correct.put("command", "ANSWER");
//            correct.put("correct", true);
//            htmlResponse.setUpdatedState(correct);
          htmlResponse.setUrl("https://dodamproject-en.web.app/game-bs.html");
            break;
      }
    }
    rb.add(htmlResponse);
    rb.addSuggestions(suggestions.toArray(new String[suggestions.size()]));
    return rb.build();
  }
}
