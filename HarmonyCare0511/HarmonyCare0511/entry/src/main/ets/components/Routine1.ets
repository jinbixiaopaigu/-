@Extend (Column)function commonColumnStyle(){
  .backgroundColor("#FFFFFF")
  .width("92%")
  .borderRadius("5vp")
}

@Component
export default struct Routine1 {
  build() {
    Refresh({ friction: 62, offset: "16vp", refreshing: false }) {
      Scroll() {
        Column() {

          //标题栏
          Row() {
            Text("近期数据")
              .width("85%")
              .height("100%")
              .fontSize("30fp")
              .fontColor("#FFFFFF")
            Image($r('app.media.refresh'))
              .width("10%")
              .height("70%")
          }
          .width("92%")
          .height("7%")
          .margin({ top: "1%" })

          Image($r('app.media.test1'))
            .width("90%")
            .height("80%")
            .margin({left:"2%"})
        }
      }
    }
  }
}