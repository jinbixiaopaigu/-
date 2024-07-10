import web_webview from '@ohos.web.webview';
@Entry
@Component
struct View {
  @State message: string = 'Hello World'
  controller: web_webview.WebviewController = new web_webview.WebviewController();
  build() {
    Row() {
      Column() {
        Web({ src:'http://student.dataease.fit2cloud.com/link/oRv5cnG1', controller: this.controller })
          .domStorageAccess(true)
      }
      .width('100%')
    }
    .height('100%')
  }
}