# 도담도담 팀 프로젝트(병선, 두리, 설아, 동환 2020/02/28)


## 도담도담 시연영상 (유투브 링크)
[![Video Label](http://img.youtube.com/vi/AXcjqv5eBh0/0.jpg)](https://www.youtube.com/watch?v=AXcjqv5eBh0) 

<br/>

<br/>

## 프로젝트 설명(2020.02.28)

- 기존에 있던 Interactive Canvas Sample 예제(삼각형 회전 및 색깔 변환 게임)코드를 응용 및 변환하여 만든 **web app**입니다. 이 프로젝트의 목적은 **Actions on Google 플랫폼**을 이용하여 **Interactive canvas Google 음성인식 AI 서비스**를 만들고자 하였습니다. PIXI.js를 이용하였고 **firebase 플랫폼**을 이용하여 배포하였습니다. <br>
- **배포된 도메인**은 https://cantododam.firebaseapp.com/ 이며 본인이 이 web app을 보고 싶으시면 위 web app을 clone하시고 아래 사용법을 참조하여 본인의 firebase에서 배포하신다음 사용하시면 됩니다. 참고로 이 웹 앱 프로젝트의 target device는 google nest hub 입니다.(반응형 x) 자세한 프로젝트의 동작 및 UI 구성은 Dodam-Dodam_en repository 첫 README.md에 있는 영상을 보시면 됩니다. 

### web app 개발자 : 곽병선, 김두리, 한설아, 이동환

# Actions on Google: Interactive Canvas Sample

This sample demonstrates how to create an [Interactive Canvas](https://developers.google.com/assistant/interactivecanvas/) experience using Actions on Google for the Google Assistant. It uses the [Node.js client library](https://github.com/actions-on-google/actions-on-google-nodejs) and is deployed on [Cloud Functions for Firebase](https://firebase.google.com/docs/functions/) and [Firebase Hosting](https://firebase.google.com/docs/hosting).

## Setup Instructions

### Prerequisites

1. Node.js and NPM
   + We recommend installing using [nvm for Linux/Mac](https://github.com/creationix/nvm) and [nvm-windows for Windows](https://github.com/coreybutler/nvm-windows)
1. Install the [Firebase CLI](https://developers.google.com/assistant/actions/dialogflow/deploy-fulfillment)
   + We recommend using MAJOR version `7` with `7.1.1` or above, `npm install -g firebase-tools@^7.1.1`
   + Run `firebase login` with your Google account

### Configuration

#### Actions Console

1. From the [Actions on Google Console](https://console.actions.google.com/), add a new project > **Create Project** > under **More options** > **Conversational**
1. Click **Deploy** in the top menu. Then, click **Additional information**.
   1. Under **Category**, select **Games & fun**
   1. Under **Interactive Canvas** *Do your Actions use Interactive Canvas?*, check **Yes**
1. Click **Develop** in the top menu. Then, click **Actions** > **Add Your First Action** > **Custom intent** > **BUILD** (this will bring you to the Dialogflow console) > Select language and time zone > **CREATE**.
1. In the Dialogflow console, go to **Settings** ⚙ > **Export and Import** > **Restore from zip** using the `agent.zip` in this sample's directory.

#### Firebase Deployment

1. On your local machine, in the `functions` directory, run `npm install`
1. Run `firebase deploy --project {PROJECT_ID}` to deploy the function and hosting
   + To find your **Project ID**: In [Dialogflow console](https://console.dialogflow.com/) under **Settings** ⚙ > **General** tab > **Project ID**.

#### Dialogflow Console

1. Return to the [Dialogflow Console](https://console.dialogflow.com) > select **Fulfillment** > **Enable** Webhook > Set **URL** to the **Function URL** that was returned after the deploy command > **SAVE**.

   ```
   https://${REGION}-${PROJECT_ID}.cloudfunctions.net/dialogflowFirebaseFulfillment
   ```

1. From the left navigation menu, click **Integrations** > **Integration Settings** under Google Assistant > Enable **Auto-preview changes** >  **Test** to open the Actions on Google simulator then say or type `Talk to my test app`.

### Running this Sample

+ You can test your Action on any Google Assistant-enabled device on which the Assistant is signed into the same account used to create this project. Just say or type, “OK Google, talk to my test app”.
+ You can also use the Actions on Google Console simulator to test most features and preview on-device behavior.
+ To hide the debug overlay, uncomment the code below `/* Uncomment below to disable the debug overlay */` in `public/css/main.css`.

## References & Issues

+ Questions? Go to [StackOverflow](https://stackoverflow.com/questions/tagged/actions-on-google), [Assistant Developer Community on Reddit](https://www.reddit.com/r/GoogleAssistantDev/) or [Support](https://developers.google.com/assistant/support).
+ For bugs, please report an issue on Github.
+ Actions on Google [Interactive Canvas Documentation](https://developers.google.com/assistant/interactivecanvas/)
+ Actions on Google [Documentation](https://developers.google.com/assistant)
+ Actions on Google [Codelabs](https://codelabs.developers.google.com/?cat=Assistant)
+ [Webhook Boilerplate Template](https://github.com/actions-on-google/dialogflow-webhook-boilerplate-nodejs) for Actions on Google

## Make Contributions

Please read and follow the steps in the [CONTRIBUTING.md](CONTRIBUTING.md).

## License

See [LICENSE](LICENSE).

## Terms

Your use of this sample is subject to, and by using or downloading the sample files you agree to comply with, the [Google APIs Terms of Service](https://developers.google.com/terms/).

<br/>

## 도담도담 AOG fulfillment 코드(2020.02.28, fulfillment_final)

##### 도담도담 파일은 fulfillment_final폴더 자체를 클론하시고 src/main/java/com.o2o.action.server.app/DodamApp 파일에서 fulfillment코드를 확인하실 수 있습니다. dialogflow 압축파일은 o2o intern 구글 드라이브에 업로드 하였고, fulfillment 코드 및 web app 코드도 구글 드라이브에 업로드 해놨습니다. 