package com.o2o.action.server.app;

import com.google.actions.api.ActionRequest;
import com.google.actions.api.ActionResponse;
import com.google.actions.api.DialogflowApp;
import com.google.actions.api.ForIntent;
import com.google.actions.api.response.ResponseBuilder;
import com.google.actions.api.response.helperintent.SelectionCarousel;
import com.google.api.services.actions_fulfillment.v2.model.BasicCard;
import com.google.api.services.actions_fulfillment.v2.model.Button;
import com.google.api.services.actions_fulfillment.v2.model.CarouselSelectCarouselItem;
import com.google.api.services.actions_fulfillment.v2.model.Image;
import com.google.api.services.actions_fulfillment.v2.model.OptionInfo;
import com.google.api.services.actions_fulfillment.v2.model.OpenUrlAction;
import com.google.api.services.actions_fulfillment.v2.model.SimpleResponse;
import com.o2o.action.server.util.CommonUtil;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class internApp extends DialogflowApp {
	@ForIntent("Default Welcome Intent")
	public ActionResponse defaultWelcome(ActionRequest request) throws ExecutionException, InterruptedException {
		ResponseBuilder rb = getResponseBuilder(request);
		List<String> suggestions = new ArrayList<String>();
		SimpleResponse simpleResponse = new SimpleResponse();
		BasicCard basicCard = new BasicCard();

		Map<String, Object> data = rb.getConversationData();


		data.clear();
		CommonUtil.printMapData(data);

		simpleResponse.setTextToSpeech("안녕하세요, 테스트앱입니다.")
				.setDisplayText("안녕하세요, 테스트앱입니다.")
		;
		basicCard
				.setFormattedText("안녕하세요, 테스트앱입니다.")
				.setImage(new Image().setUrl("https://actions.o2o.kr/content/telechips/telechipsaiperson_ko.gif")
						.setAccessibilityText("home"));

		rb.add(simpleResponse);
		rb.add(basicCard);

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

    simpleResponse.setTextToSpeech("안녕하세요, 테스트앱입니다.")
      .setDisplayText("안녕하세요, 테스트앱입니다.")
    ;
    basicCard
      .setFormattedText("안녕하세요, 테스트앱입니다.")
      .setImage(new Image().setUrl("https://actions.o2o.kr/content/telechips/telechipsaiperson_ko.gif")
        .setAccessibilityText("home"));

    rb.add(simpleResponse);
    rb.add(basicCard);

    rb.addSuggestions(suggestions.toArray(new String[suggestions.size()]));
    return rb.build();
  }
}

