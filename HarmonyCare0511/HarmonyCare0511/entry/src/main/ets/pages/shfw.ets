import web_webview from '@ohos.web.webview';

@Entry
@Component
struct Yygh {
  @State message: string = 'Hello World'
  controller: web_webview.WebviewController = new web_webview.WebviewController();
  build() {
    Row() {
      Column() {
        Web({ src: 'https://www.taobao.com/', controller: this.controller })
      }
      .width('100%')
    }
    .height('100%')
  }
}