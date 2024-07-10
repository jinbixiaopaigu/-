import router from '@ohos.router'

@Component
export default struct Mine {
  build(){
    Refresh({ friction: 62, offset: "16vp", refreshing: false }) {
      Scroll() {
        Column() {
          Column() {
            Row() {
              Image($r('app.media.landscape'))
                .width("30%")
                .height("80%")
              Column() {
                Text("用户名")
                  .width("90%")
                  .height("30%")
                  .textAlign(TextAlign.Start)
                  .fontSize("26fp")
                  .fontWeight(FontWeight.Bold)
                Text("ID：13325756323")
                  .width("90%")
                  .height("30%")
                  .fontColor("#9b9b9b")
                  .margin({ top: "5%" })
                  .textAlign(TextAlign.Start)
                  .fontSize("18fp")
                  .fontWeight(FontWeight.Normal)
              }
              .width("70%")
              .height("100%")
            }
            .width("100%")
            .height("100%")
            .alignItems(VerticalAlign.Top)
          }
          .width("100%")
          .height("24%")
          .backgroundColor("#FFFFFF")
          .padding({ top: "12.5%", bottom: "3%", left: "5%", right: "5%" })
          .alignItems(HorizontalAlign.Start)
          Row() {
            Image($r('app.media.elderly_information'))
              .width("10%")
              .height("50%")
            Text("老人信息设置")
              .width("85%")
              .height("90%")
              .fontSize("22fp")
              .onClick(()=>{
                router.pushUrl({
                  url:'pages/OlderPage',
                })
              })
          }
          .backgroundColor("#FFFFFF")
          .width("100%")
          .height("10%")
          .margin({ top: "4%" })
          .padding({ left: "5%", right: "5%" })
          Row() {
            Image($r('app.media.account_information'))
              .width("10%")
              .height("50%")
            Text("账户信息设置")
              .width("85%")
              .height("90%")
              .fontSize("22fp")
              .onClick(()=>{
                router.pushUrl({
                  url:'pages/register',
                })
              })
          }
          .backgroundColor("#FFFFFF")
          .width("100%")
          .height("10%")
          .padding({ left: "5%", right: "5%" })
          Row() {
            Image($r('app.media.config'))
              .width("10%")
              .height("50%")
            Text("应用设置")
              .width("85%")
              .height("90%")
              .fontSize("22fp")
          }
          .backgroundColor("#FFFFFF")
          .width("100%")
          .height("10%")
          .margin({ top: "0%", bottom: "0vp", left: "0vp", right: "0vp" })
          .padding({ left: "5%", right: "5%" })
        }
        .width("100%")
        .height("100%")
      }
      .width("100%")
      .height("100%")
      .scrollable(ScrollDirection.Vertical)
      .scrollBar(BarState.Auto)
      .edgeEffect(EdgeEffect.None)
    }
    .width("100%")
    .height("100%")
  }
}