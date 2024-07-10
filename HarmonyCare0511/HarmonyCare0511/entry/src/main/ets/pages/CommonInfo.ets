import router from '@ohos.router'

@Entry
@Component
struct CommonInfo {
  @State message: string = '自我身体状况'

  build() {

    Column() {
      Column() {
        Text(`${this.message}`)
          .width("300vp")
          .height("60vp")
          .offset({ x: "5vp", y: "-230vp" })
          .textAlign(TextAlign.Center)
          .fontSize("40fp")
          .fontWeight(FontWeight.Bold)
        Image($r('app.media.tu'))
          .width("284.83vp")
          .height("194.2vp")
          .offset({ x: "-0.25vp", y: "-200vp" })
        Button('查看健康详情').backgroundColor(0xF55A42)
          .offset({ x: "-0.25vp", y: "-180vp" })
          .onClick(()=>{
            router.pushUrl({
              url:"pages/OldIndex"})
              //url:"pages/view2"})
            })
        Text("收缩压       舒张压")
          .width("200vp")
          .height("60vp")
          .offset({ x: "0vp", y: "-148.86vp" })
          .fontSize("21fp")
          .fontWeight(FontWeight.Bolder)
        Text("120mmHg       80mmHg")
          .width("200vp")
          .height("35.96vp")
          .offset({ x: "0vp", y: "-170vp" })
        Text("  体温           心率")
          .width("200vp")
          .height("60vp")
          .offset({ x: "0vp", y: "-157.05vp" })
          .fontSize("21fp")
          .fontWeight(FontWeight.Bolder)
        Text("    37 ℃             85 bpm")
          .width("200vp")
          .height("30vp")
          .offset({ x: "0vp", y: "-170vp" })
        Text("  日期           时间")
          .width("200vp")
          .height("60vp")
          .offset({ x: "0vp", y: "-159.92vp" })
          .fontSize("21fp")
          .fontWeight(FontWeight.Bolder)
        Text("2023-04-18      13：00PM")
          .width("200vp")
          .height("35.96vp")
          .offset({ x: "0vp", y: "-172.28vp" })
      }
      .width("100%")
      .height("100%")
      .justifyContent(FlexAlign.Center)


    }
    .width("100%")
    .height("100%")
    .offset({ x: "0vp", y: "180vp" })

  }

}

