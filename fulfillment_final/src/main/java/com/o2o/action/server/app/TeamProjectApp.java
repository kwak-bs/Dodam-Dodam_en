package com.o2o.action.server.app;
import com.google.actions.api.ActionRequest;
import com.google.actions.api.ActionResponse;
import com.google.actions.api.DialogflowApp;
import com.google.actions.api.ForIntent;
import com.google.actions.api.response.ResponseBuilder;
import com.google.api.services.actions_fulfillment.v2.model.BasicCard;
import com.google.api.services.actions_fulfillment.v2.model.HtmlResponse;
import com.google.api.services.actions_fulfillment.v2.model.SimpleResponse;
import com.o2o.action.server.util.CommonUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class TeamProjectApp extends DialogflowApp {

	@ForIntent("Default Welcome Intent")
	public ActionResponse defaultWelcome(ActionRequest request) throws ExecutionException, InterruptedException {
		ResponseBuilder rb = getResponseBuilder(request);
    List<String> suggestions = new ArrayList<String>();

    HtmlResponse htmlResponse = new HtmlResponse();
		Map<String, Object> data = rb.getConversationData();
		data.clear();
		CommonUtil.printMapData(data);
    String input = CommonUtil.makeSafeString(request.getParameter("ComeBackHome"));

    htmlResponse.setUrl("https://kwak-bs.github.io/o2oTeamProject/web-seola/public/main.html");

    if(!input.equals("처음")) {
      rb.add("안녕하세요!, 도담도담에 온 걸 환영합니다!. " +
        "저는 여러분과 함께할 도담이 요정이에요. 원하는 놀이를 말하거나 터치해보세요.");
    }
    else if(!CommonUtil.isEmptyString(input) && input.equals("처음")){
      rb.add("처음 화면 입니다.");
    }
    rb.add(htmlResponse);

		rb.addSuggestions(suggestions.toArray(new String[suggestions.size()]));
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
      rb.add("잘 못 알아들었습니다. 다시 한번 말해보세요!");
      rb.add(htmlResponse);

    //rb.addSuggestions(suggestions.toArray(new String[suggestions.size()]));
    return rb.build();
  }

  @ForIntent("card_word")
  public ActionResponse card_word(ActionRequest request) throws ExecutionException, InterruptedException {
    ResponseBuilder rb = getResponseBuilder(request);
    List<String> suggestions = new ArrayList<String>();
    SimpleResponse simpleResponse = new SimpleResponse();
    BasicCard basicCard = new BasicCard();
    HtmlResponse htmlResponse = new HtmlResponse();
    Map<String, Object> data = rb.getConversationData();
    data.clear();
    CommonUtil.printMapData(data);

    htmlResponse.setUrl("https://kwak-bs.github.io/o2oTeamProject/web-seola/public/game.html");
    String input = CommonUtil.makeSafeString(request.getRawText());
    String text = CommonUtil.makeSafeString(request.getParameter("word"));
    int question_count = 1;

    if(!CommonUtil.isEmptyString(input)&& input.contains("낱말")){
      rb.add("낱말 카드 놀이는 해당 그림 혹은 사진에 대한 " +
        "정답을 말하면 돼요. 사진 혹은 그림을 터치 하면 정답이 나온답니다." +
        "정답은 무엇일까요?");
    }

    if(!CommonUtil.isEmptyString(input) && text.equals("fruits")
      || text.equals("family") || text.equals("animals")) {
      switch (text) {
        case "fruits":
          if(question_count == 1 && input.contains("포도")) {
            rb.add("정답입니다!");
            //question_count++;
          }
          else if (question_count == 1 && !input.contains("포도")){
            rb.add(" 포.도. 라고 다시 정확히 발음해보세요!");
          }
          break;
        case "family":
          rb.add("정답입니다!");
          break;
        case "animals":
          rb.add("정답입니다!");
          break;
      }
    }

//    rb.add(simpleResponse);

    rb.add(htmlResponse);
    rb.addSuggestions(suggestions.toArray(new String[suggestions.size()]));
    return rb.build();
  }
}

