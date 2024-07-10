import web_webview from '@ohos.web.webview';

@Entry
@Component
struct Yygh {
  @State message: string = 'Hello World'
  controller: web_webview.WebviewController = new web_webview.WebviewController();
  build() {
    Row() {
      Column() {
        Web({ src: 'www.zs-hospital.sh.cn/fddxfszsyy/yygh/yygh.html', controller: this.controller })
          .domStorageAccess(true)
      }
      .width('100%')
    }
    .height('100%')
  }
}