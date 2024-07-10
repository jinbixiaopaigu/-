@Extend (Column)function commonColumnStyle(){
  .backgroundColor("#FFFFFF")
  .width("92%")
  .borderRadius("5vp")
}

@Component
export default struct Routine {
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

        

        //  心率
                  Column() {
                    Row() {
                      Image($r('app.media.heart_rate'))
                        .width("10%")
                        .height("80%")
                        .margin({left:"2%"})
                      Text("心率")
                        .width("59%")
                        .height("100%")
                        .fontSize("20fp")
                      Text("88")
                        .width("11%")
                        .height("100%")
                        .fontSize("30fp")
                        .fontWeight(FontWeight.Bold)
                      Text("次/分钟")
                        .width("20%")
                        .height("100%")
                        .textAlign(TextAlign.Center)
                        .fontSize("18fp")
                    }
                    .width("97.5%")
                    .height("30%")
                    Text("心率折线图")
                      .width("97.5%")
                      .height("70%")
                      .textAlign(TextAlign.Center)
                      .fontSize("55fp")
                  }
                  .height("20%")
                  .margin({ top: "2.6%" })
                  .alignItems(HorizontalAlign.Center)
                  .commonColumnStyle()

                  //血压
                  Column() {
                    Row() {
                      Image($r('app.media.blood_pressure'))
                        .width("10%")
                        .height("80%")
                        .margin({left:"2%"})
                      Text("血压")
                        .width("39%")
                        .height("100%")
                        .fontSize("20fp")
                      Text("120/80")
                        .width("31%")
                        .height("100%")
                        .fontSize("30fp")
                        .fontWeight(FontWeight.Bold)
                      Text("mmHg")
                        .width("18%")
                        .height("100%")
                        .textAlign(TextAlign.Center)
                        .fontSize("18fp")
                    }
                    .width("97.5%")
                    .height("30%")
                    Text("血压折线图")
                      .width("97.5%")
                      .height("70%")
                      .textAlign(TextAlign.Center)
                      .fontSize("55fp")
                  }
                  .height("20%")
                  .margin({ top: "2.6%" })
                  .alignItems(HorizontalAlign.Center)
                  .commonColumnStyle()

                  //血氧
                  Column() {
                    Row() {
                      Image($r('app.media.blood_oxygen'))
                        .width("9%")
                        .height("70%")
                        .margin({left:"2%"})
                      Text("血氧")
                        .width("72%")
                        .height("100%")
                        .fontSize("20fp")
                      Text("97")
                        .width("11%")
                        .height("100%")
                        .fontSize("30fp")
                        .fontWeight(FontWeight.Bold)
                      Text("%")
                        .width("5%")
                        .height("100%")
                        .textAlign(TextAlign.Center)
                        .fontSize("18fp")
                    }
                    .width("97.5%")
                    .height("30%")
                    Text("血氧折线图")
                      .width("97.5%")
                      .height("70%")
                      .textAlign(TextAlign.Center)
                      .fontSize("55fp")
                  }
                  .height("20%")
                  .margin({ top: "2.6%" })
                  .alignItems(HorizontalAlign.Center)
                  .justifyContent(FlexAlign.Start)
                  .commonColumnStyle()

                  //体温
                  Column() {
                    Row() {
                      Image($r('app.media.temperature'))
                        .width("10%")
                        .height("80%")
                      Text("体温")
                        .width("63%")
                        .height("100%")
                        .fontSize("20fp")
                      Text("36.5")
                        .width("19%")
                        .height("100%")
                        .fontSize("30fp")
                        .fontWeight(FontWeight.Bold)
                      Text("°C")
                        .width("8%")
                        .height("100%")
                        .textAlign(TextAlign.Center)
                        .fontSize("18fp")
                    }
                    .width("97.5%")
                    .height("30%")
                    Text("体温折线图")
                      .width("97.5%")
                      .height("70%")
                      .textAlign(TextAlign.Center)
                      .fontSize("55fp")
                  }
                  .height("20%")
                  .margin({ top: "2.6%",bottom:"10%" })
                  .alignItems(HorizontalAlign.Center)
                  .justifyContent(FlexAlign.Start)
                  .commonColumnStyle()

                }

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